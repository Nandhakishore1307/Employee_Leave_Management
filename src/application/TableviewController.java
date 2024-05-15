package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
public class TableviewController  implements Initializable{
@FXML
private Button cmyprofile3;
@FXML
private Button accept;
@FXML
private Button decline;

@FXML
private Button employeeprofile3;



@FXML
private Button leaveapproval3;

@FXML
private Button logout3;

@FXML
private Button myprofile3;



@FXML
void cmyprofile3clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout3.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("completemyprofilemanager.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("PROFILE COMPLETION");
	stage.show();
}

@FXML
void employeeprofile3clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout3.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("employeeprofilemanager.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("EMPLOYEE PROFILES");
	stage.show();
}

@FXML
void leaveapproval3clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout3.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("leaveapprovalManager.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("LEAVE APPROVALS");
	stage.show();
}

@FXML
void logout3clicked(ActionEvent event)throws IOException {
	Stage stage = (Stage) logout3.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("front.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("DASHBOARD");
	stage.show();
}

@FXML
void myprofile3clicked(ActionEvent event) throws IOException{
	Stage stage = (Stage) logout3.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("myprofilemanager.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("MY PROFILE");
	stage.show();
}

@FXML
    private TableColumn<employeerequesttable, String> empname;

    @FXML
    private TableColumn<employeerequesttable,String> empphone;

    @FXML
    private TableColumn<employeerequesttable,String> fromdate;


    @FXML
    private TableColumn<employeerequesttable,String> reason;

    @FXML
    private TableColumn<employeerequesttable, String> todate;
    
    @FXML
    private TableView<employeerequesttable> tableView;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void acceptLeave() {
        if (showConfirmationDialog("Accept Leave", "Are you sure you want to accept this leave request?")) {
            updateStatus("accepted");
        }
    }

    @FXML
    private void declineLeave() {
        if (showConfirmationDialog("Decline Leave", "Are you sure you want to decline this leave request?")) {
            updateStatus("declined");
        }
    }

    private boolean showConfirmationDialog(String title, String content) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(title);
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText(content);

        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    private void updateStatus(String newStatus) {
        // Get the selected item from the table
        employeerequesttable selectedData = tableView.getSelectionModel().getSelectedItem();

        if (selectedData != null) {
            try {
                // Connect to the database
                connect = Database.getConnection();

                // Prepare the update statement for the "applyleave" table
                String updateStatusQuery = "UPDATE applyleave SET Leave_status = ? WHERE empname = ? AND fromdate = ? AND todate = ? AND reason = ?";
                prepare = connect.prepareStatement(updateStatusQuery);

                // Set parameters
                prepare.setString(1, newStatus);
                prepare.setString(2, selectedData.getname());
                prepare.setString(3, selectedData.getfromdate());
                prepare.setString(4, selectedData.gettodate());
                prepare.setString(5, selectedData.getreason());

                // Execute the update
                prepare.executeUpdate();

                // Close the statement
                prepare.close();

               
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Response Successful");
                alert.showAndWait();
                // Refresh the table to reflect the changes
                addPetsShowListData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showAlert("No Employee Selected", "Please select an Employee before accepting or declining.");
        }
    }

  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub


		addPetsShowListData();
	}

    
}