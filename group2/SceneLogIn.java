package group2;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/*
 * This is the primary controller that will handle the
 * initial login UI. This will launch the login prompt
 * the actual scene transitions from there will be handled
 * by their respective sub-controllers or classes.
 *
 *
 */
public class SceneLogIn {
	public ArrayList<String> studentID;
	public ArrayList<String> studentPW;
	/* these are the property fields from the fxml
	 * they will hold what values the user enters from there they can be validated
	 */

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
	public void handleLoginButtonAction() throws IOException
	{
		
		try {
			if (Security.authenticateUser(UID.getText(), UPW.getText()))
			{
			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("KioskHome.fxml"));

			Stage newStage = Driver.parentWindow;
			newStage.getScene().setRoot(userInfo);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			/*
		else
		{
			SceneHome self = new SceneHome();
		}
		*/
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
		return true;
	}
	private boolean passwordIsValid() {
		// TODO Auto-generated method stub
		return true;
	}
	private boolean userIDIsvalidFormat()
	{
		return true;
	}
	private boolean passwordIsValidFormat()
	{
		return true;
	}

	public ArrayList<String> getStudentID() {
		return studentID;
	}

	public void setStudentID(ArrayList<String> studentID) {
		this.studentID = studentID;
	}

	public ArrayList<String> getStudentPW() {
		return studentPW;
	}

	public void setStudentPW(ArrayList<String> studentPW) {
		this.studentPW = studentPW;
	}


}
