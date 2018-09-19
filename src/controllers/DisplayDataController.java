package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.User;
import core.UserAPIHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class DisplayDataController implements Initializable {

	@FXML
	private ListView<String> dataListView;

	@FXML
	private Button getBtn;

	@FXML
	private Button postBtn;

	@FXML
	private TextArea logsTextArea;

	ObservableList<String> observableList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataListView.setItems(observableList); // dataListView will observate
												// this list

		logsTextArea.setFont(Font.font("Arial", 14));
		logsTextArea.appendText("Test");
		logsTextArea.appendText("\nHello");

		observableList.add("Element 1");
	}

	@FXML
	void postRequest(ActionEvent event) {
		UserAPIHandler api = new UserAPIHandler();
		String response = api.postObject(new User("Julian", "Software Engineering"));
		System.out.println("Hello");
		logsTextArea.appendText("\n" + response);
	}

}
