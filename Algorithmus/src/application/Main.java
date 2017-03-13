package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader window = new FXMLLoader();
			window.setLocation(this.getClass().getResource("/view/MainView.fxml"));
			StackPane pane = window.load();
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Algorithmus");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
