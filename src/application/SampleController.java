package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SampleController  implements Initializable{
	@FXML
	private Button click;

    @FXML
    private TextField IdField;


    @FXML
    private TextField mailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button register;

    @FXML
    private Hyperlink signin;

    @FXML
    private TextField usernameField;
   
    @FXML
    private Button close;

    @FXML
    private Hyperlink forgetpass;

    @FXML
    private Button login;

    @FXML
    private PasswordField password1;

    @FXML
    private Button signup;

    @FXML
    private TextField username1;
    @FXML
    private Button Mainadmin;

    @FXML
    private Button Mainemployee;

    @FXML
    private Button Mainmanager;
    @FXML
    public void Admin()throws IOException {
    	Stage stage = (Stage) Mainadmin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("dummy.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Admin login");
		stage.show();

    }

    @FXML
     public void Employee()throws IOException {
    	Stage stage = (Stage) Mainadmin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Employee login");
		stage.show();

    }

    @FXML
    public void Manager()throws IOException {
    	Stage stage = (Stage) Mainadmin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Manager login");
		stage.show();

    }

     
    public void reg() throws IOException {
		Stage stage = (Stage) login.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Sign_up.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Sign Up");
		stage.show();
	}
    public void rebuilt() throws IOException {
		Stage stage = (Stage) register.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Profile");
		stage.show();
	}

@FXML
public void validateemployee(MouseEvent event) throws IOException {
	System.out.println("HIHI");
    String name = username1.getText();
    String pass = password1.getText();
    System.out.println(name);

    Database database = new Database(); // Assuming you have a Database class

    if (database.getConnection() != null) {
        String selectQuery = "SELECT Password FROM users WHERE UserName = ?";
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
                    Stage stage = (Stage) login.getScene().getWindow();
            		Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
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
   public void registerButtonClicked(ActionEvent event) throws IOException{
    	
    	    try {
    	        Integer id = Integer.parseInt(IdField.getText());
    	        String email = mailField.getText();
    	        String username = usernameField.getText();
    	        String userPassword = passwordField.getText();

    	        // Print values to console for debugging
    	        System.out.println("Employee_Id: " + id);
    	        System.out.println("Username: " + username);
    	        System.out.println("Email: " + email);
    	        System.out.println("Password: " + userPassword);

    	        // Call the method in your database class to insert data
    	        Database database = new Database();
    	        int rowsAffected = database.insert(id, email,username, userPassword);

    	        if (rowsAffected > 0) {
    	            System.out.println("Registration successful!");
    	            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Registered!");
                    alert.showAndWait();
    	            Stage stage = (Stage) register.getScene().getWindow();
    	  			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
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
    private Button click1;
    @FXML
    private Label help;
   

    @FXML
    void onclick(ActionEvent event)throws IOException {
    	  Stage stage = (Stage) click1.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		    Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login page");
		    stage.show();

    }


    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
