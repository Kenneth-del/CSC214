package group2;

import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GenerateBookStoreWebView extends GenerateWebView {

	GenerateBookStoreWebView()
	{

	}


	public WebView outPutWebViewObject(String URL) {
        WebView webView = new WebView();
		URL = "https://www.dtcc.edu/";
		webView.getEngine().load(URL);
		return webView;
	}
	void startScene()
	{
		Stage newStage;

		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(outPutWebViewObject("https://www.bkstr.com/delawaretechccstore"));
	}
}
