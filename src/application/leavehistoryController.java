package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
public class leavehistoryController implements Initializable{
@FXML
private Button applyleave4;

@FXML
private Button companyleave4;

@FXML
private Button completemyprofile4;

@FXML
private Button logout4;

@FXML
private Button myprofile4;

@FXML
void applyleave4clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout4.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("applyleaveemployee.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Application");
	stage.show();
}

@FXML
void companyleave4clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout4.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("companyleaveemployee.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("COMPANY HOLIDAYS");
	stage.show();
}

@FXML
void completemyprofile4clicked(ActionEvent event) throws IOException{
	Stage stage = (Stage) logout4.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("completemyprofileemployee.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("MY PROFILE COMPLETION");
	stage.show();
}

@FXML
void logout4clicked(ActionEvent event) throws IOException{
	Stage stage = (Stage) logout4.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("OUR COMPANY");
	stage.show();

}

@FXML
void myprofile4clicked(ActionEvent event) throws IOException{
	Stage stage = (Stage) logout4.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("Myprofileemployee.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("YOUR PROFILE");
	stage.show();
}
@FXML
private TableView<employeerequesttable> tableView;
@FXML
private TableColumn<employeerequesttable, String> empname;

@FXML
private TableColumn<employeerequesttable,String> fromdate;

@FXML
private TableColumn<employeerequesttable,String> empphone;

@FXML
private TableColumn<employeerequesttable,String> reason;

@FXML
private TableColumn<employeerequesttable,String> result1;
@FXML
private TableColumn<employeerequesttable,String> todate;
private Connection connect ;
private PreparedStatement prepare;
private ResultSet result ;

public void addPetsShowListData()  {
    try {
        // Connect to the database
        connect = Database.getConnection();

        // Prepare the select statement
        String selectData = "SELECT * FROM applyleave";
        prepare=connect.prepareStatement(selectData);

        // Execute the query and store the results
        result = prepare.executeQuery();

        // Create a new ObservableList of data objects
        ObservableList<employeerequesttable> dataObservableList = FXCollections.observableArrayList();

        // Iterate through the result set and populate the data list
        while (result.next()) {
            employeerequesttable dataObject =new employeerequesttable(
            		result.getString("empname"),
            		result.getString("empphone"),
            		result.getString("fromdate"),
            		result.getString("todate"),
            		result.getString("reason"),
            		result.getString("Leave_status")
            		);
            dataObservableList.add(dataObject);
        }

        // Close the result set and statement
        result.close();
        prepare.close();

        // Update the table view with the data list
        tableView.setItems(dataObservableList);
        empname.setCellValueFactory(f->f.getValue().nameProperty());
        empphone.setCellValueFactory(f->f.getValue().phonenoProperty());
        fromdate.setCellValueFactory(f->f.getValue().fromdateProperty());
        todate.setCellValueFactory(f->f.getValue().todateProperty());
        reason.setCellValueFactory(f->f.getValue().reasonProperty());
        result1.setCellValueFactory(f->f.getValue().statusProperty());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	addPetsShowListData();
}}
