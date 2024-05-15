package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class EmpredirectController implements Initializable{
    @FXML
    private Button applyleave1;

    @FXML
    private Button companyleave1;

    @FXML
    private Button completemyprofile1;

    @FXML
    private Button leavehistory1;

    @FXML
    private Button logout1;

    @FXML
    private Button myprofile1;

    @FXML
    void applyleave1clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("applyleaveemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Application");
		stage.show();
    }

    @FXML
    void companyleave1clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("companyleaveemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Company Leave");
		stage.show();
    }

    @FXML
    void completemyprofile1clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("completemyprofileemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("COMPLETING PROFILE");
		stage.show();
    }

    @FXML
    void leavehistory1clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leavehistory.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Leave History");
		stage.show();
    }

    @FXML
    void logout1clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("OUR COMPANY");
		stage.show();
    }

    @FXML
    private Button cmyprofile2;

    @FXML
    private Button companyleave2;

    @FXML
    private Button leave;

    @FXML
    private Button leavehistory2;

    @FXML
    private Button myprofile2;
    @FXML
    private Button logout2;

    @FXML
    void cmyprofile2clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("completemyprofileemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MY PROFILE COMPLETION");
		stage.show();
    }

    @FXML
    void companyleave2clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("companyleaveemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("COMPANY HOLIDAYS");
		stage.show();
    }

    @FXML
    void leavehistory2clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leavehistory.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LEAVE HISTORY");
		stage.show();
    }

    @FXML
    void myprofile2clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("YOUR PROFILE");
		stage.show();
    }

    @FXML
    void logout2clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("OUR COMPANY");
		stage.show();

    }
    @FXML
    private Button applyleave3;

    @FXML
    private Button completemyprofile3;

    @FXML
    private Button leavehistory3;

    @FXML
    private Button logout3;

    @FXML
    private Button myprofile3;

    @FXML
    void applyleave3clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout3.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("applyleaveemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Application");
		stage.show();
    }

    @FXML
    void completemyprofile3clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout3.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("completemyprofileemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MY PROFILE COMPLETION");
		stage.show();
    }

    @FXML
    void leavehistory3clicked(ActionEvent event)throws IOException {
    	Stage stage = (Stage) logout3.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("leavehistory.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LEAVE HISTORY");
		stage.show();
    }

    @FXML
    void logout3clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout3.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("OUR COMPANY");
		stage.show();
    }

    @FXML
    void myprofile3clicked(ActionEvent event) throws IOException{
    	Stage stage = (Stage) logout3.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("YOUR PROFILE");
		stage.show();
    }
    
	  @FXML
	    private Button applyleave5;

	    @FXML
	    private Button companyleave5;

	    @FXML
	    private Button completemyprofile5;

	    @FXML
	    private Button leavehistory5;

	    @FXML
	    private Button logout5;

	    @FXML
	    private Button mprofile5;

	    @FXML
	    void applyleave5clicked(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) logout5.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("applyleaveemployee.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Company Leave");
			stage.show();
	    }

	  
	    @FXML
	    void leavehistory5clicked(ActionEvent event)throws IOException {
	    	Stage stage = (Stage) logout5.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("leavehistory.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Your Leave History");
			stage.show();

	    }
	    @FXML
	    void companyleave5clicked(ActionEvent event)throws IOException {
	    	Stage stage = (Stage) logout5.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("companyleaveemployee.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("COMPANAY HOLIDAYS");
			stage.show();
	    }

	    @FXML
	    void logout5clicked(ActionEvent event) throws IOException{
	    	Stage stage = (Stage) logout5.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("OUR COMPANY");
			stage.show();
	    }

	    @FXML
	    void mprofile5clicked(ActionEvent event) throws IOException{
	    	Stage stage = (Stage) logout5.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Employee Profile Completion");
			stage.show();
	    }
	    @FXML
	    private Button employeecompletebutton;
	    @FXML
	    private TextField dob;

	    @FXML
	    private TextField doj;

	    @FXML
	    private TextField eemail;
	    @FXML
	    private TextField addres;
	    @FXML
	    private TextField phnumber;

	    @FXML
	    private TextField uname;
	    @FXML
	    private TextField lissuer;
	    @FXML
	    private TextField fname;
	    @FXML
	    void employeecompletebuttonclicked(ActionEvent event) throws IOException {
	    	try {
	    		 String fnam = fname.getText();
    	        String unam = uname.getText();
    	        String lissue = lissuer.getText();
    	        String mail = eemail.getText();
    	        String phone = phnumber.getText();
    	        String adres = addres.getText();
    	        String dobir = dob.getText();
    	        String dojoi = doj.getText();
    	        

    	        // Print values to console for debugging
    	        System.out.println("" +fnam);
    	        System.out.println( ""+ mail);
    	        System.out.println( ""+ phone);
    	        System.out.println( ""+ adres);

    	        // Call the method in your database class to insert data
    	        Database database = new Database();
    	        int rowsAffected = database.completeemployee(fnam, unam,mail,adres,dobir,phone,dojoi,lissue);

    	        if (rowsAffected > 0) {
    	            System.out.println("Profile Completion Succesful");
    	            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Registered!");
                    alert.showAndWait();
    	            Stage stage = (Stage) employeecompletebutton.getScene().getWindow();
    	  			Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
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
	    private TextField applyfromdate;

	    @FXML
	    private TextField applyname;

	    @FXML
	    private TextField applyphone;

	    @FXML
	    private TextArea applyreason;

	    @FXML
	    private TextField applytodate;
	    @FXML
	    private Button applybutton;
	    @FXML
	    void applybuttonclicked(ActionEvent event) throws IOException{
	    	try {
	    		 String aname= applyname.getText();
   	        String aphone = applyphone.getText();
   	        String afrom = applyfromdate.getText();
   	        String ato= applytodate.getText();
   	        String areason = applyreason.getText();
   	       
   	        

   	        // Print values to console for debugging
   	        System.out.println("" +aname);
   	        System.out.println( ""+ aphone);
   	        System.out.println( ""+ afrom);
   	        System.out.println( ""+ areason);

   	        // Call the method in your database class to insert data
   	        Database database = new Database();
   	        int rowsAffected = database.applyleave1(aname,aphone,afrom,ato,areason);

   	        if (rowsAffected > 0) {
   	            System.out.println("LEAVE APPLIED");
   	            Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("Successfully Registered!");
                   alert.showAndWait();
   	            Stage stage = (Stage) applybutton.getScene().getWindow();
   	  			Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
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

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	
	   
	    
	    

	
}