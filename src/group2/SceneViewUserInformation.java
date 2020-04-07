package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneViewUserInformation extends Scene {
	public SceneViewUserInformation() throws IOException
	{
		//startScene();

	}
	void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
	public void handleEditInformation() throws IOException
	{
		SceneEditUserInformation EUI = new SceneEditUserInformation();
		EUI.startScene();
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
