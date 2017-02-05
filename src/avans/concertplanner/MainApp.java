package avans.concertplanner;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class containing startup and render logic
 * @author Jason
 *
 */

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ConcertPlanner");
		
		initRootLayout();
		
		showConcertOverview();
	}
	
	/**
	 * Initializes the root layout.
	 */
	
	public void initRootLayout() {
		try {
			// Load root layout from FXML file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show the scene with the retrieved root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows the overview of concerts inside the root layout.
	 */
	
	public void showConcertOverview() {
		try {
			// Load concert overview from FXML file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ConcertOverview.fxml"));
			AnchorPane concertOverview = (AnchorPane) loader.load();
			
			// Set the retrieved concert overview into the center of the root layout.
			rootLayout.setCenter(concertOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Return the main stage.
	 * @return
	 */
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
