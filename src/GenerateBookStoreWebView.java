

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GenerateBookStoreWebView extends GenerateWebView {

	GenerateBookStoreWebView()
	{

	}

	/*
	 * (non-Javadoc)
	 * @see GenerateWebView#outPutWebViewObject(java.lang.String)
	 * This function is designed to take a URL and output a webview object
	 * It does this.

	 */
	public WebView outPutWebViewObject(String URL) {
        WebView webView = new WebView();
		URL = "https://www.dtcc.edu/student-resources/bookstores";
		webView.getEngine().load(URL);
		return webView;
	}

	/*
	 * Creates a new scene with a back button
	 * and updates that info with the main stage
	 */
	void startScene()
	{
		BorderPane mainPane = new BorderPane();


		Stage newStage;
		WebView webView = new WebView();
		webView.getEngine().load("https://www.dtcc.edu/student-resources/bookstores");

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
}
