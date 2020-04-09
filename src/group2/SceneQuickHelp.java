package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneQuickHelp extends Scene {

	SceneQuickHelp() throws IOException
	{
		startScene();
	}

	@Override
	public void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}

}
