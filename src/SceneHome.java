

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneHome extends Scene {
	public static boolean isFromHome = false;  // used to control where the using functions will display the next scene
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
	/*
	When called it creates an object of the student information  scene
	 * then calls the start scene to build an display the scene
	 * */
	public void handleStudentInformation() throws IOException, SQLException
	{
		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.startScene();
	}
	/*
	 * When called it creates an object of the account summary scene
	 * then calls the start scene to build an display the scene
	 */
	public void handleAccountSummary() throws IOException
	{
		SceneViewAccountSummary VAS = new SceneViewAccountSummary();
		VAS.startScene();
	}
	/*
	 * When called it creates an object of the registration scene
	 * then calls the start scene to build an display the scene
	 *
	 */
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

	/*
	 * This function creates a new object that then loads
	 * the appropriate scene.
	 */
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


	/*
	 * This creates a new object that then loads the function
	 * loading the appropriate scene.
	 */
	public void handleBookStore()
	{
		GenerateBookStoreWebView BS = new GenerateBookStoreWebView();
		BS.startScene();
	}

	/*
	 * Creates a new quick help scene and sets isFromHome to true
	 * so when the user goes back they are directed to the correct scene
	 */
	public void handleQuickHelp() throws IOException
	{
		isFromHome = true;
		SceneQuickHelp QHO = new SceneQuickHelp();
	}

	/*
	 * This function sets the appropriate variables to null
	 * and sets isFromHome to false so the using functions don't
	 * have the incorrect actions. it then starts a new login scene
	 * letting the garbage collector handle what the program needs.
	 */
	public void handleSignOut() throws IOException
	{
		SceneLogIn LI = new SceneLogIn();
		SceneLogIn.rg = null;
		SceneLogIn.user = null;
		SceneHome.isFromHome = false;
		LI.startScene();
	}
	/*
	 * (non-Javadoc)
	 * @see Scene#startScene()
	 * This creates the basics of a new scene then loads the KioskHome.fxml file
	 * It then changes the value of the User Name to display the Users first and last name
	 */
	@Override
	void startScene() throws IOException {
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("KioskHome.fxml"));
		Stage newStage;
		((Text)userInfo.lookup("#UN")).setText("Hello " + SceneLogIn.user.getFirstName() +" "+ SceneLogIn.user.getLastName());
		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
}
