

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneViewAccountSummary extends Scene {
	@FXML HBox LH;
	public SceneViewAccountSummary()
	{

	}


	ArrayList<Transaction> transactionList = new ArrayList<>();

	public void handleBack() throws IOException
	{
		SceneHome SH = new SceneHome();
		SH.startScene();
	}
	@Override
	void startScene() throws IOException {

		Parent userInfo;
		userInfo = FXMLLoader.load(getClass().getResource("AccountSum.fxml"));
		Stage newStage;

		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
			SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
			SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
			transactionList = SceneLogIn.user.transactionList;
		ListView<Transaction> lv = new ListView<>(FXCollections.observableArrayList
												 (SceneLogIn.user.transactionList));
		lv.setPrefHeight(600);
		lv.setPrefWidth(800);
		((HBox)userInfo.lookup("#LH")).getChildren().add(lv);
		((Text)userInfo.lookup("#AB")).setText(String.valueOf(getAccountTotal()));
		newStage = Driver.parentWindow;
		newStage.getScene().setRoot(userInfo);

	}
	private double getAccountTotal()
	{
		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
	SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
	SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));
		SceneLogIn.user.transactionList.add(new Transaction("Tuition", 4282020, 480.99 ,"Spring 2020"));

		double balanceTotal = 0;

		for (int i = 0; i < SceneLogIn.user.transactionList.size(); i++)
		{

			balanceTotal = balanceTotal + SceneLogIn.user.transactionList.get(i).getAmount();
		}
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		return Double.valueOf(numberFormat.format(balanceTotal));
	}

	public void handlePrint()
	{
		 try {
			 	File file = new File("Transactions.txt");
			 	if (file.exists())
			 	{
			 		file.delete();
			 	}
	            FileWriter writer = new FileWriter("Transactions.txt", true);
	            BufferedWriter BW = new BufferedWriter(writer);
	           for (int i = 0; i < SceneLogIn.user.transactionList.size(); i++)
	           {
	        	   BW.append("-------------------------------------------------------------");
	        	   BW.newLine();
	        	   BW.append(SceneLogIn.user.transactionList.get(i).toString());
	        	   BW.newLine();
	        	   BW.append("-------------------------------------------------------------");
	        	   System.out.println("This ran");
	           }
	           BW.append("Total Account balance = "+ String.valueOf(getAccountTotal()));
	            BW.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }

}
