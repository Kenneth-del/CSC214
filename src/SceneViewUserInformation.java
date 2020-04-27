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
	/*
	 * (non-Javadoc)
	 * @see Scene#startScene()
	 * if the scene is returned it displays a success message otherwise it displays the regular scene
	 * This funtion creates a new scene
	 */
	void startScene() throws IOException, SQLException {

		if (!isSceneReturned)
		{
			Parent UserInfo;
			UserInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
			Stage newStage;
			((Text)UserInfo.lookup("#name")).setText(User.getFirstName() + " " +
					 User.getMiddleName() + " " +
					 User.getLastName());

((Text)UserInfo.lookup("#age")).setText(String.valueOf(User.getId()));
((Text)UserInfo.lookup("#phoneNumber")).setText(User.getPhoneNumber());
((Text)UserInfo.lookup("#GPA")).setText(String.valueOf(User.getGpa()));
((Text)UserInfo.lookup("#address")).setText(User.getStudentAddress().toString());
((Text)UserInfo.lookup("#emergencyContact")).setText(User.getEmergencyContacts().toString());

			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(UserInfo);

		}



		else
		{
			Parent UserInfo;
			UserInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
			Stage newStage;


			BorderPane bp  = new BorderPane();
			Text text = new Text("Your information was updated successfully!");
			text.setFill(Color.CADETBLUE);
			bp.setTop(text);



			((Text)UserInfo.lookup("#name")).setText(User.getFirstName() +
													 User.getMiddleName() +
													 User.getLastName());

			((Text)UserInfo.lookup("#age")).setText(String.valueOf(User.getId()));
			((Text)UserInfo.lookup("#phoneNumber")).setText(User.getPhoneNumber());
			((Text)UserInfo.lookup("#GPA")).setText(String.valueOf(User.getGpa()));
			((Text)UserInfo.lookup("#address")).setText(new Address(User.getId()).toString());
			((Text)UserInfo.lookup("#emergencyContact")).setText(User.getEmergencyContacts().toString());

			bp.setCenter(UserInfo);

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