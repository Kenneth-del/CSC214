package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneEditUserInformation {

	public SceneEditUserInformation()
	{

	}
	private boolean validateAddress(String address)
	{
		return true;
	}
	private boolean validatePhoneNumber(String phoneNumber)
	{
		return true;
	}
	public void updateAddress(String address)
	{

	}
	public void updateEmail(String email)
	{

	}
	public void updatePhoneNumber(String phoneNumber)
	{

	}
	public void updateContactName(String name)
	{

	}
	public void updateContactPhoneNumber(String phoneNumber)
	{

	}
	public void updateContactEmail(String contactEmail)
	{

	}
	public String getAddress()
	{
		return null;
	}
	public String getEmail()
	{
		return null;
	}
	public String getPhoneNumber()
	{
		return null;
	}
	void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("StudInfoEdit.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
}

