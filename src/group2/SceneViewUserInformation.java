package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneViewUserInformation {
	SceneViewUserInformation() throws IOException
	{
		Parent userInfo = null;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
	}
	public double getGPA()
	{
		return 1;
	}
	public String getName()
	{
		return null;
	}
	public String getCurrentSemester()
	{
		return null;
	}
}
