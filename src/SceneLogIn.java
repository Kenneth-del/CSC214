
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/*
 * This is the primary controller that will handle the
 * initial login UI. This will launch the login prompt
 * the actual scene transitions from there will be handled
 * by their respective sub-controllers or classes.
 *
 *
 */
public class SceneLogIn extends Scene {
	public static boolean isTargetSceneReloaded = false;
	public String studentID;
	public String studentPW;
	public static User user = new User();
	public static Registration rg = null; // set on SceneHome generation
	/* these are the property fields from the fxml
	 * they will hold what values the user enters from there they can be validated
	 */
@FXML private Text textChanged;
@FXML private TextField UID;
@FXML private PasswordField UPW;

	public SceneLogIn()
	{

		// Initializes student IDs and passwords to compare and validate
		//this.setStudentID(getStudentID());
		//this.setStudentPW(getStudentPasswords());
	}

	/* A work around to get the initial scene loaded in start
	 * essentially it loads the UI into type parent the returns that value
	 */

	public Parent generateParent() throws IOException {
		Parent mainFXML = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));
/*
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Kiosk_login.fxml"));
		//fxml.setRoot(this);
		fxml.setController(this);

		try {
			fxml.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return mainFXML;
	}





	/*
	 * This function handles the action of clicking on the login button
	 * essentially all it does it creates a new object of the next Scene
	 * the constructor of the next scene should handle the rest of the user actions
	 */
	public void handleLoginButtonAction() throws IOException, NoSuchAlgorithmException, NumberFormatException, SQLException
	{

	if (userIDIsvalid())
			{
		if (Security.authenticateUser(UID.getText(), UPW.getText()))
			{

				rg = new Registration(user.getId()); // due to some exceptions setting the registration here makes sense for now.
				Parent userInfo;
				userInfo = FXMLLoader.load(getClass().getResource("KioskHome.fxml"));
				//user.setStudent((Integer.valueOf(UID.getText())));
				((Text)userInfo.lookup("#UN")).setText("Hello " + user.getFirstName() +" "+ user.getLastName());
				Stage newStage = Driver.parentWindow;
				newStage.getScene().setRoot(userInfo);
			}

			else
				{
				isTargetSceneReloaded = true;
				SceneLogIn self = new SceneLogIn();

				self.startScene();
			}



		}
		else
		{
			isTargetSceneReloaded = true;
			SceneLogIn self = new SceneLogIn();

			self.startScene();
		}
	}

		/*
		Parent userInfo = null;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
		}
	*/

	/*
	 * A function to make a new instance of the quick help scene
	 */
	public void handleQuickHelpAction() throws IOException
	{
		SceneQuickHelp QH = new SceneQuickHelp();
	}

	/*
	 * If the user wants to view a map
	 * this scene is called if makes a new webview
	 * then displays that webview adding the scene to the
	 * root which is then displayed to the user
	 */
	public void handlePDF ()throws IOException
	{
		BorderPane mainPane = new BorderPane();


		Stage newStage;
		WebView webView = new WebView();
		webView.getEngine().load("https://www.dtcc.edu/our-campuses/");

		mainPane.setCenter(webView);

		Button bttn = new Button("Go Home");
		// set button event handler to start another scene
		bttn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

		   if(!SceneHome.isFromHome == false)
		   {
			   SceneHome SH;
			try {
				SH = new SceneHome();
				SH.startScene();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		   }
		   else{
		    	SceneLogIn SL = new SceneLogIn();
		      try {
				SL.startScene();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    }
		    }
		}
		);

		mainPane.setBottom(bttn);

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(mainPane);


	}

	/*
	 * if the user wants to go back this will either direct them
	 * to scenehome if the value isFromHome is set to true otherwise
	 * it will load the login scene
	 */
	public void handleQuickHelpBack() throws IOException
	{
		if (!SceneHome.isFromHome)
		{
		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
		}
		else
		{
			SceneHome SH = new SceneHome();
			SH.startScene();

		}
	}

	/*
	 * TODO Write in the validation functions
	 *
	 */
	//TODO get the studentIds from the DB

	/*
	 * validates the user ID entered to make sure it is the correct format
	 */
	private boolean userIDIsvalid() {
		// TODO Auto-generated method stub

		//System.out.println(UID.getCharacters());
		if (UID.getCharacters().length() != 9) // check to make sure it is the appropriate length
			return false;

		else if(UID.getCharacters().toString().matches("^[0-9]+")) // checks against every character to see if each char is 0-9
																	// if not then it returns false as a condition and skips
			return true;
		else
			return false;
	}

	/*
	 * Depreciated: used to validate if the user is in the database
	 *
	 */
	private boolean isInfoInDataBase(TextField UID,PasswordField UPW ) throws NoSuchAlgorithmException
	{
		System.out.println("Ran");
		Security validate = new Security();
		String UIDS = UID.getCharacters().toString();
		String UPWS = UPW.getCharacters().toString();
		System.out.println(validate.authenticateUser(UIDS, UPWS));
		if (validate.authenticateUser(UIDS, UPWS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentPW() {
		return studentPW;
	}

	public void setStudentPW(String studentPW) {
		this.studentPW = studentPW;
	}

	/*
	 * (non-Javadoc)
	 * @see Scene#startScene()
	 * Since this function can be launched from multiple places
	 * we need to know if it is being launched again
	 * if it is it displays with an error messsage if not is
	 * displays the correct login scene with out the error message
	 */
	void startScene() throws IOException {
		if (!isTargetSceneReloaded)
		{
			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));
			Stage newStage;
			//user = new User();
			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(userInfo);
		}
		else
		{
			BorderPane bp = new BorderPane();

			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));
			Text t = new Text("Your username or password is incorrect");
			t.setFill(Color.RED);
			bp.setTop(t);
			bp.setCenter(userInfo);

			Stage newStage;

			// To-do figure out how to change text of welcome screen


			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(bp);
		}
	}
}
