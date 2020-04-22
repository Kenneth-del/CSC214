

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneViewUserInformation extends Scene {
	public boolean isSceneReturned = false;
	public SceneViewUserInformation() throws IOException
	{
		//startScene();

	}
	void startScene() throws IOException, SQLException {

		if (!isSceneReturned)
		{
			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
			Stage newStage;
			((Text)userInfo.lookup("#name")).setText(SceneLogIn.user.getFirstName() +
													 SceneLogIn.user.getMiddleName() +
													 SceneLogIn.user.getLastName());

			((Text)userInfo.lookup("#age")).setText(String.valueOf(SceneLogIn.user.getId()));
			((Text)userInfo.lookup("#phoneNumber")).setText(SceneLogIn.user.getPhoneNumber());
			((Text)userInfo.lookup("#GPA")).setText(String.valueOf(SceneLogIn.user.getGpa()));
			((Text)userInfo.lookup("#address")).setText(new Address(SceneLogIn.user.getId()).toString());
			((Text)userInfo.lookup("#emergencyContact")).setText(SceneLogIn.user.getEmergencyContacts().toString());

			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(userInfo);

		}



		else
		{
			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
			Stage newStage;


			BorderPane bp  = new BorderPane();
			Text text = new Text("Your information was updated successfully!");
			text.setFill(Color.CADETBLUE);
			bp.setTop(text);



			((Text)userInfo.lookup("#name")).setText(SceneLogIn.user.getFirstName() +
													 SceneLogIn.user.getMiddleName() +
													 SceneLogIn.user.getLastName());

			((Text)userInfo.lookup("#age")).setText(String.valueOf(SceneLogIn.user.getId()));
			((Text)userInfo.lookup("#phoneNumber")).setText(SceneLogIn.user.getPhoneNumber());
			((Text)userInfo.lookup("#GPA")).setText(String.valueOf(SceneLogIn.user.getGpa()));
			((Text)userInfo.lookup("#address")).setText(new Address(SceneLogIn.user.getId()).toString());
			((Text)userInfo.lookup("#emergencyContact")).setText(SceneLogIn.user.getEmergencyContacts().toString());

			bp.setCenter(userInfo);

			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(bp);
			isSceneReturned = false;
		}
	}



	public void handleEditInformation() throws IOException, SQLException
	{
		SceneEditUserInformation EUI = new SceneEditUserInformation();
		EUI.startScene();
	}
	public void handleBack() throws IOException
	{
		SceneHome SH = new SceneHome();
		SH.startScene();
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
