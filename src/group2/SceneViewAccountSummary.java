package group2;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneViewAccountSummary extends Scene {
	public SceneViewAccountSummary()
	{

	}


	ArrayList<Transaction> transactionList = new ArrayList<>();


	@Override
	void startScene() throws IOException {

		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("AccountSum.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}

}
