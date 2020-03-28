package group2;

import javafx.scene.web.WebView;

public class generateBookStoreWebView extends generateWebView {

	generateBookStoreWebView()
	{

	}


	public WebView outPutWebViewObject(String URL) {
        WebView webView = new WebView();
		URL = "https://www.bkstr.com/delawaretechccstore";
		webView.getEngine().load(URL);
		return webView;
	}
}
