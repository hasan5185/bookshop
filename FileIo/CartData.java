package FileIo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class CartData{
	
	private String username;
	private String bookName;
	private String quantity;
	private String price;
	
	LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

	String timeDate= myDateObj.format(myFormatObj);
	public CartData(){}
	public CartData(String username,String bookName,String quantity,String price){
		this.username=username;
		this.bookName=bookName;
		this.quantity=quantity;
		this.price=price;
		try {
			File file = new File(".\\data\\cart_data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			
            pw.println(username+"'s Book name :" + bookName);
            pw.println(username+"'s Quantity  :" + quantity);
            pw.println(username+"'s Price     :" + price);
			
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
		}
		catch (Exception ex) {
            System.out.print(ex);
        }
		
	}
}