package group2;

import javafx.scene.web.WebView;

public class generateLibraryWebView extends generateWebView{

	generateLibraryWebView()
	{

	}

	public WebView outPutWebViewObject(String URL) {
		WebView webView = new WebView();
		URL = "https://dlc.lib.de.us/client/en_US/DTCC/";
		webView.getEngine().load(URL);
		return webView;
	}

}
