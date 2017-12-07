package application.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

import application.Main;
import application.Objects.Helper;
import javafx.event.ActionEvent;

import javafx.scene.control.TitledPane;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class chooseController {
	@FXML
	private TitledPane t_pane;
	@FXML
	private AnchorPane a_pane;
	@FXML
	private Button button_konsole;
	@FXML
	private Button button_gui;
	@FXML
	private Button button_mysql;
	@FXML
	private Button button_xml;
	@FXML
	private AnchorPane pane_ui;
	@FXML
	private AnchorPane pane_save;
	
	public void setVisible() {
		pane_ui.setVisible(false);
		pane_ui.setVisible(true);
	}
//Start App
	boolean konsole, gui, mysql, xml;
	Helper help = new Helper();
	public void setApp() throws SQLException, IOException {
		
		if (konsole) {
			if (mysql) {
				//Konsole+mySQL DB
				Stage stage = (Stage) button_gui.getScene().getWindow();
				stage.close();
				Main.main(null, help);
			}
			if (xml) {
				//Konsole+XML
				Stage stage = (Stage) button_gui.getScene().getWindow();
				stage.close();
				Main.main(null, help);
			}
		}
		if (gui) {
			if (mysql) {
				//GUI+MySQL DB
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/MainMenu.fxml"));
				Parent content = (Parent) loader.load();
				Stage stage = new Stage();
				Stage oldstage = (Stage) button_gui.getScene().getWindow();
				oldstage.close();
				stage.setScene(new Scene(content));
				stage.show();
			}
			if (xml) {
				//GUI+XML
				
			
			}
			
		}
}
	
//Auswahl Konsole
	@FXML
	public void button_kon_klick(ActionEvent event) throws SQLException {
		konsole=true;
		help.setLook("con");
		pane_ui.setVisible(false);
		pane_save.setVisible(true);		
	}
	
//Auswahl GUI
	@FXML
	public void button_gui_klick(ActionEvent event) throws IOException {
		gui=true;
		help.setLook("gui");
		pane_ui.setVisible(false);
		pane_save.setVisible(true);			
	}
	
//Auswahl mySQL
	@FXML
	public void button_mysql_klick(ActionEvent event) throws SQLException, IOException {
		mysql=true;
		help.setSave("sql");
		pane_ui.setVisible(false);
		pane_save.setVisible(true);	
		setApp();
	}
	
//Auswahl XML
	@FXML
	public void button_xml_klick(ActionEvent event) throws SQLException, IOException {
		xml=true;
		help.setSave("xml");
		pane_ui.setVisible(true);
		pane_save.setVisible(false);	
		setApp();
	}
}