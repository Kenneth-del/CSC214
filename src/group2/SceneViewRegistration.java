package group2;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneViewRegistration extends Scene {


	public SceneViewRegistration()
	{

	}
	
	public ArrayList<Course> getRegInfo()
	{
		return null;
	}
	public void displayRegInfo(ArrayList<Course> courses)
	{

	}

	 void startScene() throws IOException {

		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("KioskClassinfo.fxml"));

		Stage newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
	}
}
