package application;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;


/**
 *
 * @author WINDOWS 10
 */
public class cardproductcontroller implements Initializable {
	
	  @FXML
	    private Label prod_fullname;

	    @FXML
	    private Label prod_username;

	    @FXML
	    private Label prod_email;


	    @FXML
	    private Label prod_dob;

	    @FXML
	    private Label prod_phonenumber;

	    @FXML
	    private Label prod_doj;

	    @FXML
	    private Label prod_leaveissuer;
   
    private productdata prodData;
    
    private String fullname;
    private String username;
    private String email;

    private String dob;
    private String phonenumber;
    private String doj;
    private String leaveissuer;
    
    public void setdata( productdata prodData)
    {
    	this.prodData = prodData;
    	
    	fullname=prodData.getfullname();
    	username=prodData.getusername();
    	email=prodData.getemail();
    	dob=prodData.getdob();
    	phonenumber=prodData.getphonenumber();
    	doj=prodData.getdoj();
    	leaveissuer=prodData.getleaveissuer();
    	
  
    	
    	prod_fullname.setText(prodData.getfullname());
    	prod_username.setText(prodData.getusername());
    	prod_email.setText(prodData.getemail());
    	prod_dob.setText(prodData.getdob());
    	prod_phonenumber.setText(prodData.getphonenumber());
    	prod_doj.setText(prodData.getdoj());
    	prod_leaveissuer.setText(prodData.getleaveissuer()); 	
    	
    	
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}