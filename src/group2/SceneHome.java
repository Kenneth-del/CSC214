package group2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class SceneHome implements Initializable {
	
	@FXML 
	private Text studentName;

	public SceneHome()  throws IOException
	{
		//TODO: Link scene
	}

	//TODO: Add javadoc
	@FXML
	public void handleStudentInformation() throws IOException{
		SceneViewUserInformation VUI = new SceneViewUserInformation();
		VUI.startScene();
	}
	
	//TODO: Add javadoc
	@FXML
	public void handleAccountSummary() throws IOException{
		//TODO: Link scene

	}
	
	//TODO: Add javadoc
	@FXML
	public void handleClassInformation() throws IOException{
		SceneViewRegistration VR = new SceneViewRegistration();
		VR.startScene();
	}

	//TODO: Add javadoc
	@FXML
	public void handleLibrary(){
		GenerateLibraryWebView LW = new GenerateLibraryWebView();
		LW.startScene();

	}
	
	//TODO: Add javadoc
	@FXML
	public void handleBookStore(){
		GenerateBookStoreWebView BS = new GenerateBookStoreWebView();
		BS.startScene();
	}
	
	//TODO: Add javadoc
	@FXML
	public void handleQuickHelp() throws IOException{
		//TODO: Link scene
	}

	//TODO: Add javadoc
	//Retrieves dynamic content to display
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		studentName.setText("Hello, " + User.getFirstName());

	}


}
