package application;
import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class user implements Initializable{
	
	  @FXML
	    private GridPane menu_gridpane;


	    @FXML
	    private ScrollPane menu_scrollpane;

	    private ObservableList<productdata> cardListData = FXCollections.observableArrayList();


	    private Connection connect;
	    private PreparedStatement prepare;
	    private ResultSet result;
	    
	    public  static Connection getConnection() {
			String databasename="employee_leave_management_system";
			String user="root";
			String password="N@$2005";
			String url="jdbc:mysql://localhost:3306/"+databasename;
			System.out.print("connect the database");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(url,user,password);
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		

	    
	    public ObservableList<productdata> menuGetData() {
	           
	           String sql = "SELECT * FROM eprofiles";
	           
	           ObservableList<productdata> listData = FXCollections.observableArrayList();
	           connect = getConnection();
	           
	           try {
	               prepare = connect.prepareStatement(sql);
	               result = prepare.executeQuery();
	               
	               productdata prod;
	               
	               while (result.next()) {
	                   prod = new productdata(result.getString("fullname"),
	                   		result.getString("username"),
	                           result.getString("email"),
	                           result.getString("address"),
	                           result.getString("dob"),
	                           result.getString("phonenumber"),
	                           result.getString("doj"),
	                           result.getString("leaveissuer")
	            
	                           );
	                   listData.add(prod);
	               }
	               
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	           
	           return listData;
	       }

	    public void menuDisplayCard() {
	        
	        cardListData.clear();
	        cardListData.addAll(menuGetData());
	        
	        int row = 0;
	        int column = 0;
	        
	        menu_gridpane.getChildren().clear();
	        menu_gridpane.getRowConstraints().clear();
	        menu_gridpane.getColumnConstraints().clear();
	        
	        for (int q = 0; q < cardListData.size(); q++) {
	            
	            try {
	                FXMLLoader load = new FXMLLoader();
	                load.setLocation(getClass().getResource("cardproduct.fxml"));
	                AnchorPane pane = load.load();
	                cardproductcontroller cardC = load.getController();
	                cardC.setdata(cardListData.get(q));
	                
	                if (column == 1) {
	                    column = 0;
	                    row += 1;
	                }
	                
	                menu_gridpane.add(pane, column++, row);
	                
	                GridPane.setMargin(pane, new Insets(10));
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
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


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			menuDisplayCard();
			
		}

	
		


}