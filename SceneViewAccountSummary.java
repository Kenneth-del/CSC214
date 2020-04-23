

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
	/*
	 * (non-Javadoc)
	 * @see Scene#startScene()
	 * generates and displays a scene with a list view from the users transaction list
	 */
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
	// adds the total for each line and returns the formated sum
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
	/*
	 * Used to use PDF functions https://www.tutorialspoint.com/pdfbox/pdfbox_adding_text.htm
	 * User to create a print job: https://www.developer.com/java/data/how-to-add-java-print-services-to-your-java-application.html
	 */
	public void handlePrint() throws PrintException, IOException
	{
		/*
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

	           }
	           BW.append("Total Account balance = "+ String.valueOf(getAccountTotal()));
	            BW.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 */

		PDDocument document = new PDDocument();
		document.save("Transactions.pdf");
		PDPage my_page = new PDPage();
		document.addPage(my_page);
		document.save("Transactions.pdf");
		document.close();

		File file = new File("Transactions.pdf");
		PDDocument docs = document.load(file);
		PDPage page = docs.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(docs,page);

		contentStream.beginText();
		contentStream.newLineAtOffset(10, 200);
		PDFont font = PDType1Font.COURIER;
		contentStream.setFont(font, 8 );
		contentStream.showText("Total Account balance: " + getAccountTotal());
		 for (int i = User.transactionList.size() -1 ; i >= 0; i--)
         {

			 contentStream.showText("----------------------------------------------------------");
			 contentStream.newLineAtOffset(0, 25);
			 contentStream.showText(SceneLogIn.user.transactionList.get(i).toString());
		 	 contentStream.newLineAtOffset(0, 25);
			 contentStream.showText("----------------------------------------------------------");

         }

		 contentStream.endText();
		 contentStream.close();
		 docs.save("Transactions.pdf");
		 docs.close();
		 PrintService ps=PrintServiceLookup.lookupDefaultPrintService();
	      DocPrintJob job=ps.createPrintJob();
	     /*
	      job.addPrintJobListener(new PrintJobAdapter() {
	      public void printDataTransferCompleted(PrintJobEvent event){
	      }
	      public void printJobNoMoreEvents(PrintJobEvent event){
	         }
	      });*/
	      FileInputStream fis=new FileInputStream("Transactions1.pdf");
	      Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
	      PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
	      attrib.add(new Copies(1));
	      job.print(doc, attrib);
	 }

}
