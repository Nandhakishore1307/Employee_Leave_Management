package application;

import java.io.IOException;
import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManagerController  implements Initializable{

    @FXML
    private Hyperlink Managerforgetpass;

    @FXML
    private Button Managerlogin;

    @FXML
    private PasswordField Managerpassword;

    @FXML
    private Button Managersignup;

    @FXML
    private TextField Managerusername;

    @FXML
    private Button close;

    @FXML
    private TextField MIdField;

    @FXML
    private TextField MmailField;

    @FXML
    private PasswordField MpasswordField;

    @FXML
    private Button Mregister;

    @FXML
    private Hyperlink Msignin;

    @FXML
    private TextField MusernameField;
    @FXML
    private TextArea Madd;

    @FXML
    private TextField Mdob;

    @FXML
    private TextField Mdoj;

    @FXML
    private TextField Memp;

    @FXML
    private TextField Mfirstname;

    @FXML
    private TextField Mlastname;

    @FXML
    private Button completebutton;

    @FXML
    private Button employeeprofile5;

    @FXML
    private Button leaveaprl5;

    @FXML
    private Button leavereq5;

    @FXML
    private Label mdetemail;

    @FXML
    private Button profile5;
    @FXML
    private Button employeeprofile1;

   

    @FXML
    void Mregisterclicked(ActionEvent event) throws IOException{
    	  try {
  	        Integer id = Integer.parseInt(MIdField.getText());
  	        String email = MmailField.getText();
  	        String username = MusernameField.getText();
  	        String userPassword = MpasswordField.getText();

  	        // Print values to console for debugging
  	        System.out.println("Employee_Id: " + id);
  	        System.out.println("Email: " + email);
  	        System.out.println("Username: " + username);
  	        System.out.println("Password: " + userPassword);

  	        // Call the method in your database class to insert data
  	        Database database = new Database();
  	        int rowsAffected = database.newmanager(id, email,username, userPassword);
      
  	        if (rowsAffected > 0) {
  	            System.out.println("Registration successful!");
  	          Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setContentText("Sucessfully Registered!");
              alert.showAndWait();
  	            
  	          Stage stage = (Stage) Msignin.getScene().getWindow();
  			  Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
  			  Scene scene = new Scene(root);
  			  stage.setScene(scene);
  			  stage.setTitle("Login page");
  			  stage.show();
  	        } else {
  	            System.out.println("Registration failed.");
  	        }
  	    } catch (NumberFormatException e) {
  	        System.out.println("Invalid Employee Id format. Please enter a valid number.");
  	    }	

    }
    @FXML
    
    void completeclicked(ActionEvent event) throws IOException, ParseException{
    	  try {
  	        System.out.println("tgyn");
  	        String fname = Mfirstname.getText();
  	        String lname = Mlastname.getText();
  	        String dob1 = Mdob.getText();
  	        String doj2 = Mdoj.getText();
  	        Integer num= Integer.parseInt(Memp.getText());
  	        String madd = Madd.getText();
  	      
  	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDob = dateFormat.parse(dob1);
            java.util.Date utilDoj = dateFormat.parse(doj2);

          // Convert to java.sql.Date
          java.sql.Date dob = new java.sql.Date(utilDob.getTime());
          java.sql.Date doj = new java.sql.Date(utilDoj.getTime());

  	        // Print values to console for debugging
  	        System.out.println("Mfirstname " + fname);
  	        System.out.println("Mlastname " + lname);
  	        System.out.println("Mdob " + dob1);
  	        System.out.println("Mdoj " + doj2);
  	        System.out.println("Memp " + num);
  	       System.out.println("Madd " + madd);
  	     
  	        // Call the method in your database class to insert data
  	        Database database = new Database();
  	        int rowsAffected = database.completemanager(fname,lname,dob,doj,num,madd);
  	              
  	        if (rowsAffected > 0) {
  	            System.out.println("Completed successfully!");
  	          Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setContentText("Completed Sucessfully!");
              alert.showAndWait();
  	            
  	          Stage stage = (Stage) completebutton.getScene().getWindow();
  			  Parent root = FXMLLoader.load(getClass().getResource("myprofilemanager.fxml"));
  			  Scene scene = new Scene(root);
  			  stage.setScene(scene);
  			  stage.setTitle("Login page");
  			  stage.show();
  	        } else {
  	            System.out.println("Registration failed.");
  	        }
  	    } catch (NumberFormatException e) {
  	        System.out.println("Invalid Employee Id format. Please enter a valid number.");
  	    }
  	

    }

    @FXML
    
    public void validateManager(MouseEvent event) throws IOException {
    	System.out.println("HIHI");
        String name = Managerusername.getText();
        String pass = Managerpassword.getText();
        System.out.println(name);

        Database database = new Database(); // Assuming you have a Database class

        if (database.getConnection() != null) {
            String selectQuery = "SELECT Password FROM managers WHERE Manager_username = ?";
            System.out.println("HI HI");

            try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(selectQuery)) {
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("Password");

                    // Validate the password
                    if (pass.equals(storedPassword)) {
                        // Password is correct, perform actions
                        System.out.println("Login successful!");
                        Alert alert = new Alert(AlertType.INFORMATION);
	                    alert.setHeaderText(null);
	                    alert.setContentText("Successfully Login!");
	                    alert.showAndWait();
                        Stage stage = (Stage) Managerlogin.getScene().getWindow();
                		Parent root = FXMLLoader.load(getClass().getResource("myprofilemanager.fxml"));
                		Scene scene = new Scene(root);
                		stage.setScene(scene);
                		stage.setTitle("Manager login");
                		stage.show();
                        
                    } else {
                        // Incorrect password
                        System.out.println("Incorrect password");
                    }
                }
                 else {
                    // User not found
                    System.out.println("User not found");
                }
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
                database.closeConnection();
            }
        } else {
            System.out.println("Not connected");
        }
    }
    @FXML
    void managersignin(ActionEvent event) throws IOException{
    	Stage stage = (Stage) Mregister.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Manager login");
		stage.show();

    }
    @FXML
    void Managersignup(ActionEvent event)throws IOException {
    	Stage stage = (Stage) Managerlogin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Managersignup.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Manager login");
		stage.show();
    }
    @FXML
    private Button cprofile1;

    @FXML
    private Button employeeprofile11;

    @FXML
    private Button leaveapprovals1;

    @FXML
    private Button leaverequest1;

    @FXML
    private Button logout1;

    @FXML
    void cprofile1clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("completemyprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("PROFILE COMPLETION");
		stage.show();
    }

    @FXML
    void employeeprofile1clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("employeeprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EMPLOYEE PROFILES");
		stage.show();

    }

    @FXML
    void leaveapprovals1clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaveapprovalManager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LEAVE APPROVALS");
		stage.show();
    }

    @FXML
    void leaverequest1clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaverequestsmanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EMPLOYEE REQUESTS");
		stage.show();
    	

    }

    @FXML
    void logout1clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("DASHBOARD");
		stage.show();
    }
    @FXML
    private Button cprofilemanager2;

   

    @FXML
    private Button leaveapproval2;

    @FXML
    private Button leaverequest2;

    @FXML
    private Button logout2;

   

    @FXML
    private Button myprofile2;

    @FXML
    void cprofilemanager2clicked(ActionEvent event) throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("completemyprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("PROFILE COMPLETION");
		stage.show();
    }

    @FXML
    void leaveapproval2clicked(ActionEvent event) throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaveapprovalManager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LEAVE APPROVALS");
		stage.show();

    }

    @FXML
    void leaverequest2clicked(ActionEvent event)  throws IOException{
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaverequestsmanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EMPLOYEE REQUESTS");
		stage.show();
    }

    @FXML
    void logout2clicked(ActionEvent event) throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("DASHBOARD");
		stage.show();
    }

    @FXML
    void myprofile2clicked(ActionEvent event)  throws IOException{
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("myprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MY PROFILE");
		stage.show();
    }
   
 

    @FXML
    private Button logout5;

    

    @FXML
    private Button myprofile5;
    @FXML
    void employeeprofile5clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout5.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("employeeprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EMPLOYEE PROFILES");
		stage.show();
    }

    @FXML
    void leaveapproval5clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout5.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaveapprovalManager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LEAVE APPROVALS");
		stage.show();
    }

    @FXML
    void leaverequest5clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout5.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leaverequestsmanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EMPLOYEE REQUESTS");
		stage.show();
    }

    @FXML
    void logout5clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout5.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("DASHBOARD");
		stage.show();
    }

    @FXML
    void myprofile5clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout5.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("myprofilemanager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MY PROFILE");
		stage.show();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
    


