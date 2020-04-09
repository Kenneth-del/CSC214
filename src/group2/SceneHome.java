package group2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneHome  {

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
	
	public void handleStudentInformation() throws IOException
	{
		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.startScene();
	}
	/*public void handleAccountSummary()
	{

	}*/
	public void handleClassInformation() throws IOException
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
	//public void handleQuickHelp()
	//{

	//}

}
