

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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

/*
 * Used to use PDF functions https://www.tutorialspoint.com/pdfbox/pdfbox_adding_text.htm
 * User to create a print job: https://docs.oracle.com/javase/7/docs/api/javax/print/DocFlavor.INPUT_STREAM.html
 */
	public void handlePrint() throws PrintException, IOException
	 {
		String semester = selectedSemester;
		ArrayList<Course> c = SceneLogIn.rg.getSemester(semester);

			PDDocument document = new PDDocument();
			document.save("Registration.pdf");
			PDPage my_page = new PDPage();
			document.addPage(my_page);
			document.save("Registration.pdf");
			document.close();

			File file = new File("Registration.pdf");
			PDDocument docs = document.load(file);
			PDPage page = docs.getPage(0);
			PDPageContentStream contentStream = new PDPageContentStream(docs,page);

			contentStream.beginText();
			contentStream.newLineAtOffset(10, 450);
			PDFont font = PDType1Font.COURIER;
			contentStream.setFont(font, 8 );
			 for (int i = CS; i >= 0; i--)
	         {

				 contentStream.showText("----------------------------------------------------------");
				 contentStream.newLineAtOffset(0, 25);
				 contentStream.showText(SceneLogIn.rg.registration.get(SC).toString());
			 	 contentStream.newLineAtOffset(0, 25);
				 contentStream.showText("----------------------------------------------------------");

	         }

			 contentStream.endText();
			 contentStream.close();
			 docs.save("Registration.pdf");
			 docs.close();
			 FileInputStream textStream = null;
			 try {
			         textStream = new FileInputStream("Registration.pdf");
			 } catch (FileNotFoundException ffne) {
			 }

			 // Set the document type
			 DocFlavor myFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
			 // Create a Doc
			 Doc myDoc = new SimpleDoc(textStream, myFormat, null);
			 // Build a set of attributes
			 PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
			 aset.add(new Copies(1));
			 aset.add(Sides.DUPLEX);
			 // discover the printers that can print the format according to the
			 // instructions in the attribute set

			         PrintService services = PrintServiceLookup.lookupDefaultPrintService();
			 // Create a print job from one of the print services

			         DocPrintJob job = services.createPrintJob();
			         job.print(myDoc, aset);

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
