package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
	public Connection DatabaseLink;
    private static final Logger logger = Logger.getLogger(Database.class.getName());

    public int insert(int id, String email,String user, String pass) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        String sql = "INSERT INTO users (Employee_id, Email,UserName, Password) VALUES (?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, user);
            preparedStatement.setString(4, pass);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error during insertion", e);
        }
        return -1;
     
    }
    public int newmanager(int id, String email,String user, String pass) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        String sql = "INSERT INTO managers (Manager_id,Manager_Email,Manager_username, Password) VALUES (?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, user);
            preparedStatement.setString(4, pass);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error during insertion", e);
        }
        return -1;
    }
    public int completemanager(String fname, String lname,Date dob, Date doj,Integer num,String add) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        String sql = "INSERT INTO mprofile (Firstname,Lastname,Dateofbirth,Dateofjoined,nemployees,Address) VALUES (?, ?, ?, ?,?,?)";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setDate(3, dob);
            preparedStatement.setDate(4, doj);
            preparedStatement.setInt(5, num);
            preparedStatement.setString(6, add);
           

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error during insertion", e);
        }
        return -1;
    }
    public static Connection getConnection() {
		String databasename="employee_leave_management_system";
		String user="root";
		String password="N@$2005";
		String url="jdbc:mysql://localhost:3306/"+databasename;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    public void closeConnection() {
        try {
            if (DatabaseLink != null && !DatabaseLink.isClosed()) {
                DatabaseLink.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement preparedStatement = DatabaseLink.prepareStatement(query);

            // Set parameters if any
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int completeemployee( String fullname,String uname, String email,String address,String dob,String phnumber,String doj,String leaveissuer) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        String sql = "INSERT INTO eprofiles (fullname,username,email,address,dob,phonenumber,doj,leaveissuer) VALUES (?, ?, ?, ?, ?, ?, ?,?)";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, uname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, dob);
            preparedStatement.setString(6, phnumber);
            preparedStatement.setString(7, doj);
            preparedStatement.setString(8, leaveissuer);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error during insertion", e);
        }
        return -1;
    }
    public int applyleave1( String applyname,String applyphone, String applyfromdate,String applytodate,String applyreason) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        String sql = "INSERT INTO applyleave (empname,empphone,fromdate,todate,reason) VALUES (?, ?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	preparedStatement.setString(1, applyname);
            preparedStatement.setString(2, applyphone);
            preparedStatement.setString(3, applyfromdate);
            preparedStatement.setString(4, applytodate);
            preparedStatement.setString(5, applyreason);
            

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error during insertion", e);
        }
        return -1;
    }

    public String getpass(String specificUsername) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ employee_leave_management_system";
        String username = "root";
        String password = "N@$2005";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT Password FROM users WHERE UserName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, specificUsername);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("Password");
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving password", e);
        }
        return null;
    }

}
