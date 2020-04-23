

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneHome extends Scene {
	public static boolean isFromHome;
@FXML Text UN;
	public SceneHome()  throws IOException
	{

	}
/*
	@Override
	public void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("/src/group2/KioskHome.fxml"));

		Stage newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
	*/

	public void handleStudentInformation() throws IOException, SQLException
	{
		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.startScene();
	}
	public void handleAccountSummary() throws IOException
	{
		SceneViewAccountSummary VAS = new SceneViewAccountSummary();
		VAS.startScene();
	}
	public void handleClassInformation() throws IOException, SQLException
	{
		SceneViewRegistration VR = new SceneViewRegistration();
		VR.startScene();
		/*
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_ClassInfo.fxml"));

		Stage newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
		*/
	}

	public void handleLibrary()
	{
		GenerateLibraryWebView LW = new GenerateLibraryWebView();
		LW.startScene();

		/*
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(LW.outPutWebViewObject("https://dlc.lib.de.us/client/en_US/DTCC/"));
		*/
	}
	public void handleBookStore()
	{
		GenerateBookStoreWebView BS = new GenerateBookStoreWebView();
		BS.startScene();
	}
	public void handleQuickHelp() throws IOException
	{
		isFromHome = true;
		SceneQuickHelp QHO = new SceneQuickHelp();
	}

	public void handleSignOut() throws IOException
	{
		SceneLogIn LI = new SceneLogIn();
		//User = null;
		LI.startScene();
	}
	@Override
	void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("KioskHome.fxml"));
		Stage newStage;
		((Text)userInfo.lookup("#UN")).setText("Hello " + User.getFirstName() +" "+ User.getLastName());
		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
}
