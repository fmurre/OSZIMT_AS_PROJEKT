package application;



import java.sql.SQLException;

import application.Objects.Helper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;

import javafx.stage.Stage;

public class Main extends Application{
	//Auswahl GUI/Console, SQL/XML
	public void start(Stage chooseUI) {
		try {
			TitledPane root = (TitledPane) FXMLLoader.load(getClass().getResource("choose.fxml"));
			Scene scene = new Scene(root);
			chooseUI.setScene(scene);
			chooseUI.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args, Helper help) throws SQLException {		
		//launch(args);
		
		Menuswitch.mainMenu(help);		
	}

}
