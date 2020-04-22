

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneEditUserInformation {
	Parent userInfo;
	String phoneNumber;
	String address;
	EmergencyContact ec = new EmergencyContact();
	public SceneEditUserInformation()
	{

	}
	public void handleSave() throws IOException, SQLException
	{

		SceneLogIn.user.setPhoneNumber(((TextField)userInfo.lookup("#phoneNumber")).getText());
		//SceneLogIn.user.updateDBPhoneNumber(((TextField)userInfo.lookup("#phoneNumber")).getText());
		//SceneLogIn.user.setEmailAddress(emailAddress); UI not there add or remove?
		//SceneLogIn.user.updateDBEmailAddress();
		String[] ec = ((TextField)userInfo.lookup("#emergencyContact")).getText().split(",");

		SceneLogIn.user.getEmergencyContacts().updatePhoneNumber(ec[2]);
		SceneLogIn.user.getEmergencyContacts(); //. update the rest of them need functions to update the whole contact.


		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.isSceneReturned = true;
		VUI.startScene();


	}
	public void handleBackToHome() throws IOException, SQLException
	{
		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.startScene();
	}
	/*
	private boolean validateAddress(String address)
	{
		return true;
	}
	*/
	private boolean validatePhoneNumber(String phoneNumber)
	{
		if (phoneNumber.length() > 10)
			return false;
		else
			return true;
	}


	void startScene() throws IOException, SQLException {

		userInfo = FXMLLoader.load(getClass().getResource("StudInfoEdit.fxml"));
		Stage newStage;

		((TextField)userInfo.lookup("#phoneNumber")).setText(SceneLogIn.user.getPhoneNumber());
		((TextField)userInfo.lookup("#address")).setText(new Address(SceneLogIn.user.getId()).toString());
		((TextField)userInfo.lookup("#emergencyContact")).setText(SceneLogIn.user.getEmergencyContacts().toString());

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
}

