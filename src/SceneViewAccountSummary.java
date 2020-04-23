

import java.awt.Desktop;
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
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;
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
	 * User to create a print job: https://docs.oracle.com/javase/7/docs/api/javax/print/DocFlavor.INPUT_STREAM.html
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

		 FileInputStream textStream = null;
		 try {
		         textStream = new FileInputStream("Transactions.pdf");
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
	 }
