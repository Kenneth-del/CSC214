

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneQuickHelp extends Scene {

	// A constructor that calls startScene
	public SceneQuickHelp() throws IOException
	{
		startScene();
	}

	// creates and displays a new scene
	@Override
	public void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Quick help.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}

}
