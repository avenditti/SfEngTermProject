package sfproj.client;

import java.io.IOException;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployee {
	
	ClientNetHandler cnh;
	private final String serverIPA = "localhost";
	private final int port = 5000;
	
	@FXML Button addEmp;
	@FXML Label employeeNameLbl;
	@FXML Label deptLbl;
	@FXML Label pPHLbl;
	@FXML TextField employeeName;
	@FXML TextField payPerHour;
	@FXML ComboBox<String> employeeDept;
	@FXML
	private void initialize(){
		ObservableList<String> empDept = FXCollections.observableArrayList(); 
		empDept.add("1");
		empDept.add("2");
		empDept.add("3");
		employeeDept.setItems(empDept);
	}
	
	private Stage addEmployeesStage;
	
	public AddEmployee(Stage addEmployeesStage) throws IOException{
		this.addEmployeesStage = addEmployeesStage;
		cnh = new ClientNetHandler(serverIPA, port);
	}
	
	public void addEmployee(){
		try{
			//cnh.sendToServer("Add Employee: "+ employeeName.getText() + ", " + employeeDept.getValue() + ", " + payPerHour.getText());
			cnh.sendToServer("AddEmployee|"+ employeeName.getText() + "|" + employeeDept.getValue() + "|" + payPerHour.getText());
			addEmployeesStage.close();
		} catch (UnknownHostException e) {
			// TODO
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}
}