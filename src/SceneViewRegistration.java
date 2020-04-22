

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SceneViewRegistration extends Scene {
	static ListView<Course> lv = null;
	static String selectedSemester = "Spring2020";
	static int CS;
	static int SC;
	public SceneViewRegistration()
	{

	}

	public ArrayList<Course> getRegInfo()
	{
		return null;
	}
	public void displayRegInfo(ArrayList<Course> courses)
	{

	}

	public void handleBack() throws IOException
	{
		SceneHome SH = new SceneHome();
		SH.startScene();
	}
	 void startScene() throws IOException, SQLException {

		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("KioskClassinfo.fxml"));
		Stage newStage;

		ComboBox<String> CB = new ComboBox<>();
		CB.setMinWidth(400);





		CB.setOnAction(e -> {
			try {
				selectedSemester = CB.getPromptText();
				setDisplay(CB.getValue());

			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});



		String selectedSemester = "Spring2020"; // just a default semester to display

		SceneLogIn.rg.registration.add(new ArrayList<Course>());
		SceneLogIn.rg.registration.get(0).add(new Course(948));
		SceneLogIn.rg.semesters.add(selectedSemester);


		//List Of registration details
		 lv = new ListView<>(FXCollections.observableArrayList
				 (SceneLogIn.rg.getSemester(selectedSemester)));
		lv.setPrefHeight(600);
		lv.setPrefWidth(800);

		ObservableList<String> items = FXCollections.observableArrayList(SceneLogIn.rg.semesters);
		CB.getItems().setAll(items);



		BorderPane BP = new BorderPane();
		BP.setCenter(lv);
		BP.setTop(CB);


		((HBox)userInfo.lookup("#HB")).getChildren().add(BP);

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);
	}
	 public void setDisplay(String semester) throws SQLException, IOException
	 {
		 // generate a scene, but this time with the updated information.
			Parent userInfo;
			userInfo = FXMLLoader.load(getClass().getResource("KioskClassinfo.fxml"));
			Stage newStage;

			ComboBox<String> CB = new ComboBox<>();
			CB.setMinWidth(400);
			ObservableList<String> items = FXCollections.observableArrayList(SceneLogIn.rg.semesters);
			CB.getItems().setAll(items);
			CB.setOnAction(e -> {
				try {
					selectedSemester = CB.getPromptText();
					CS = items.indexOf(CB.getValue());
					setDisplay(CB.getValue());

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			String selectedSemester = "Spring2020";

			SceneLogIn.rg.registration.add(new ArrayList<Course>());
			SceneLogIn.rg.registration.get(0).add(new Course(948));
			Course test = new Course(483);
			test.courseName = "Test";
			SceneLogIn.rg.registration.get(0).add(test);
			SceneLogIn.rg.semesters.add(selectedSemester);


			//List Of registration details
			 lv = new ListView<>(FXCollections.observableArrayList
					 (SceneLogIn.rg.getSemester(semester)));
			lv.setPrefHeight(600);
			lv.setPrefWidth(800);


			BorderPane BP = new BorderPane();
			BP.setCenter(lv);
			BP.setTop(CB);


			((HBox)userInfo.lookup("#HB")).getChildren().add(BP);
			CS = lv.getItems().size()-1;
			newStage = Driver.parentWindow;
			newStage.getScene().setRoot(userInfo);
	 }


	public void handlePrint()
	 {
		String semester = selectedSemester;
		ArrayList<Course> c = SceneLogIn.rg.getSemester(semester);
		 try {
			 System.out.println(CS);
			 System.out.println(SC);
	            FileWriter writer = new FileWriter("Registration.txt", false);
	            BufferedWriter BW = new BufferedWriter(writer);
	           for (int i = 0; i < CS; i++)
	           {
	        	   BW.append("-------------------------------------------------------------");
	        	   BW.newLine();
	        	   BW.append(SceneLogIn.rg.registration.get(SC).toString());
	        	   BW.newLine();
	        	   BW.append("-------------------------------------------------------------");
	        	   System.out.println("This ran");
	           }
	            BW.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	public void handleClass()
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

}
