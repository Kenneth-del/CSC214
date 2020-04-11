package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneQuickHelp extends Scene {

	public SceneQuickHelp() throws IOException
	{
		startScene();
	}

	@Override
	public void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Quick help.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}

}
