
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
		//if (userIDIsvalid())
			{
		//	if (isInfoInDataBase(UID, UPW))
			//{
				rg = new Registration(user.getId()); // due to some exceptions setting the registration here makes sense for now.
				Parent userInfo;
				userInfo = FXMLLoader.load(getClass().getResource("KioskHome.fxml"));
				//user.setStudent((Integer.valueOf(UID.getText())));
				((Text)userInfo.lookup("#UN")).setText("Hello " + user.getFirstName() +" "+ user.getLastName());
				Stage newStage = Driver.parentWindow;
				newStage.getScene().setRoot(userInfo);
			}



		//}
		//else
		//{
			//System.out.println("here");
			///isTargetSceneReloaded = true;
			//SceneLogIn self = new SceneLogIn();

			//self.startScene();
		//}

		/*
		Parent userInfo = null;
		userInfo = FXMLLoader.load(getClass().getResource("Kiosk_StuInfo.fxml"));
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
	*/
	}
	public void handleQuickHelpAction() throws IOException
	{
		SceneQuickHelp QH = new SceneQuickHelp();
	}

	public void handlePDF()
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
		    	SceneLogIn SL = new SceneLogIn();
		      try {
				SL.startScene();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    }
		}
		);

		mainPane.setBottom(bttn);

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(mainPane);


	}

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

	private ArrayList<String> getStudentIds()
	{
		return null;

	}
	private ArrayList<String> getStudentPasswords()
	{
		return null;

	}
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
	private boolean passwordIsValid() {
		return true;
	}

	private boolean isInfoInDataBase(TextField UID,PasswordField UPW ) throws NoSuchAlgorithmException
	{
		//To-Do Check is this works...
		/*
		Security validate = new Security();
		String UIDS = UID.getCharacters().toString();
		String UPWS = UPW.getCharacters().toString();

		if (validate.authenticateUser(UIDS, UPWS))
		{
			return true;
		}
		else
		{
			return false;
		}
		*/
		return true;
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
