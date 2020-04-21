package group2;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//TODO: Add javadoc
/*
 * This is the primary controller that will handle the
 * initial login UI. This will launch the login prompt
 * the actual scene transitions from there will be handled
 * by their respective sub-controllers or classes.
 *
 *
 */
public class SceneLogIn {

    /* these are the property fields from the fxml
     * they will hold what values the user enters from there they can be validated
     */
    @FXML
    private TextField UID;
    @FXML
    private PasswordField UPW;

    public static boolean isTargetSceneReloaded = false;


    //TODO: Add javadoc
    public Parent generateParent() throws IOException {
        Parent mainFXML = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));

        return mainFXML;
    }

    //TODO: Add javadoc
    /*
     * This function handles the action of clicking on the login button
     * essentially all it does it creates a new object of the next Scene
     * the constructor of the next scene should handle the rest of the user actions
     */
    public void handleLoginButtonAction() throws SQLException, IOException, NoSuchAlgorithmException {

        if (userIDIsvalid()) {
            //Authenticates user before opening next scene
            if (Security.authenticateUser(UID.getText(), UPW.getText())) {
                Parent userInfo;
                userInfo = FXMLLoader.load(getClass().getResource("Kiosk_Home.fxml"));

                Stage newStage = Driver.parentWindow;
                newStage.getScene().setRoot(userInfo);
                User.setUser(Integer.parseInt(UID.getText()));
                
                //Tests getting emergency contact and updating address 
               //System.out.println(User.getEmergencyContacts().get(0).getAddress());
               User.getEmergencyContacts().get(0).getAddress().update("25", "B Street", "Newark", "DE", "19801");
                
                //Tests updating user address
                //User.getAddress().update("25", "Kirkwood Street", "Wilmington", "DE", "19801");
                
                //Test making sure course information is being saved properly
                //System.out.println(User.getRegistration().getCourse("Spring 2020", 32947));
                
            }
        } else {
            System.out.println("here");
            isTargetSceneReloaded = true;
            System.out.println("test");
            SceneLogIn self = new SceneLogIn();

            self.startScene();
        }
    }

    //TODO: Add javadoc
    public void handleQuickHelpAction() throws IOException {
        SceneQuickHelp QH = new SceneQuickHelp();
    }

    private boolean userIDIsvalid() {
        // TODO Auto-generated method stub

        //System.out.println(UID.getCharacters());
        if (UID.getCharacters().length() != 9) // check to make sure it is the appropriate length
            return false;

        else if (UID.getCharacters().toString().matches("^[0-9]+")) // checks against every character to see if each char is 0-9
            // if not then it returns false as a condition and skips
            return true;


        else
            return false;
    }

    void startScene() throws IOException {
        if (!isTargetSceneReloaded) {
            Parent userInfo;
            userInfo = FXMLLoader.load(getClass().getResource("Kiosk_login.fxml"));
            Stage newStage;

            newStage = Driver.parentWindow;
            newStage.getScene().setRoot(userInfo);
        } else {
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