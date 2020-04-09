package group2;

import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GenerateLibraryWebView extends GenerateWebView{

	GenerateLibraryWebView()
	{

	}

	void startScene() {
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(outPutWebViewObject("https://dlc.lib.de.us/client/en_US/DTCC/"));

	}

	public WebView outPutWebViewObject(String URL) {
		WebView webView = new WebView();
		URL = "https://dlc.lib.de.us/client/en_US/DTCC/";
		webView.getEngine().load(URL);
		return webView;
	}

}
