

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class Driver extends Application{
	public static void main(String[] args) {
        Application.launch(args);
    }


	/*
	 * This is the primary or parent stage that will be used throughout
	 * the program to change the UI.
	 */
    public static Stage parentWindow;


    @Override
    public void start(Stage stage) throws Exception {
    	parentWindow = stage; // sets the parent window equal to the stage used in start

    	//SceneLogIn is the initial primary controller that handles UI events and
    	//Generation the controller for each UI segement will change as what handles what changes
    	SceneLogIn controllerObject = new SceneLogIn();

    	// standard JFX UI stuff
    	stage.setScene(new Scene(controllerObject.generateParent())); // see SceneLogIn fro generateParent info
        stage.setTitle("Kiosk");
        //stage.setFullScreen(true);
        stage.show();
    }
}