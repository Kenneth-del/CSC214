

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GenerateLibraryWebView extends GenerateWebView{

	GenerateLibraryWebView()
	{

	}

	/*
	 * Creates a new scene with a back button
	 * and updates that info with the main stage
	 */
	void startScene() {
		BorderPane mainPane = new BorderPane();


		Stage newStage;
		WebView webView = new WebView();
		webView.getEngine().load("https://dlc.lib.de.us/client/en_US/DTCC/");

		mainPane.setCenter(webView);

		// Button object that on click creates a new SceneHome object and calls the startScene
		//function there.

		Button bttn = new Button("Go Home");
		bttn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	SceneHome SH;
				try {
					SH = new SceneHome();
					SH.startScene();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

		    }
		}
		);

		mainPane.setBottom(bttn);

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(mainPane);


	}

	public WebView outPutWebViewObject(String URL) {
		WebView webView = new WebView();
		URL = "https://dlc.lib.de.us/client/en_US/DTCC/";
		webView.getEngine().load(URL);
		return webView;
	}

}
