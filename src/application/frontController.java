package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class frontController implements Initializable{

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}