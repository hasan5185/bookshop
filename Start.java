import Source.*;
import FileIo.*;
import javax.swing.*;

public class Start{
	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new LogIn();
			}
		});
	}
}