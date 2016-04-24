package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ben
 *
 * Entry point for the program
 */
public class Main extends Application{
	Window window;
	
	@Override
	/**
	 * Starts the Application
	 */
	public void start(Stage stage) throws Exception {
		window = new Window();
		PointManager pointManager = new PointManager(window);
		Scene scene = new Scene(window);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Launches the program
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		launch();
	}
}
