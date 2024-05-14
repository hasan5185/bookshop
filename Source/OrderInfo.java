package Source;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.*;

public class OrderInfo extends JFrame implements ActionListener{
	
	DefaultTableModel model;
	JTable table;
	Panel panel;
	JButton btnClear,backBtn,profile;
	
	String[] rows = new String[4];
	
	String file = ".\\data\\cart_data.txt";
    String temp = ".\\data\\temp.txt";
	
	String username;
	
	public OrderInfo(String username){
		
		super("Cart");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		this.username=username;
		
		panel = new Panel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		titleBar();
		
		btnClear = new MyButton();
		btnClear.setText("Clear Data");
		btnClear.setFocusPainted(false);
		btnClear.setBounds(815,530, 150, 36);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) btnClear).setRedius(10);
		btnClear.setBorder(null);
		panel.add(btnClear);
		btnClear.addActionListener(this);
		btnClear.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnClear.setBackground(new Color(25, 118, 211));
                btnClear.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                btnClear.setForeground(new Color(25, 118, 211));
                btnClear.setBackground(new Color(255, 255, 255));
            }
        });
		
		model = new DefaultTableModel();
		table = new JTable(model);
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBackground(new Color(255, 255, 255));
		table.setShowGrid(true);
		table.setSelectionBackground(new Color(100,100,100));
		table.setBounds(650, 100, 500, 400);
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		model.addColumn("Name");
		model.addColumn("Book Name");
		model.addColumn("Quantity");
		model.addColumn("Price");
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(347);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(115, 120, 850, 400);
		panel.add(scrollPane);
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader.readLine() != null){
				totalLines++;
			}
			reader.close();

            for (int i = 0; i < totalLines; i++){
				String line = Files.readAllLines(Paths.get(file)).get(i);
				int a=line.indexOf("'");
				int b=a-7;
				String x = line.substring((10+b),(14+b));
				int c=21+b;
				if (x.equals("Book")){
					rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(7,a); 
					rows[1] = Files.readAllLines(Paths.get(file)).get((i)).substring(c); 
					rows[2] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(c);  
					rows[3] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(c);  
                  
					model.addRow(rows);
				}
			}

        } 
		catch (Exception ex) {return;}
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==backBtn){
			this.setVisible(false);
			new AdminPanel(username);
		}
		if(e.getSource()==btnClear) {
			
			File oldFile = new File(file);
            File newFile = new File(temp);

            int q = 0;

            try{
				
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int totalLines = 0;
                while (reader.readLine() != null){
					totalLines++;
				}
                reader.close();
                for (int i = 0; i < totalLines; i++){
					
                    String line = Files.readAllLines(Paths.get(file)).get(i);
                    int a=line.indexOf("'");
					int b=a-7;
					String x = line.substring((10+b),19);
                    if (x.equals("Book")){
                        q = i;
                    }
                }
            }
            
			catch (Exception ex){return;}
			   
            try{
				FileWriter fw = new FileWriter(temp, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                BufferedReader reader = new BufferedReader(new FileReader(file));
                int totalLines = 0;
                while (reader.readLine() != null){
                    totalLines++;
				}
                reader.close();
				
                for (int j = 0; j < totalLines; j++){

                    if (q != 0){
                        String userName = Files.readAllLines(Paths.get(file)).get(j);
                        pw.println("-----Order Completed-----");
						break;
                    }
					else{
                        String userName = Files.readAllLines(Paths.get(file)).get(j);
                        pw.println(userName);
                    }
                }
                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();
            } 
			catch (Exception ex) {}
			
            oldFile.delete();
            File dump = new File(file);
            newFile.renameTo(dump);
		}
	}
	public void titleBar(){
		
		JPanel titleBarPanel = new JPanel();
		titleBarPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		titleBarPanel.setBackground(new Color(102, 153, 204));
		titleBarPanel.setBounds(0, 0, 1647, 77);
		panel.add(titleBarPanel);
		titleBarPanel.setLayout(null);
		
		backBtn = new JButton("");
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(null);
		backBtn.setIcon(new ImageIcon("image/back.png"));
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.setBounds(85, 22, 43, 31);
		titleBarPanel.add(backBtn);
		backBtn.addActionListener(this);
		
		profile = new JButton(username);
		profile.setContentAreaFilled(false);
		profile.setFocusPainted(false);
		profile.setBorder(null);
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		profile.setBounds(929, 22, 98, 31);
		titleBarPanel.add(profile);
		profile.addActionListener(this);
		
		JLabel Bookshop = new JLabel("Bookshop");
		Bookshop.setFont(new Font("Tahoma", Font.BOLD, 24));
		Bookshop.setForeground(Color.white);
		Bookshop.setBounds(492, 22, 153, 31);
		titleBarPanel.add(Bookshop);
	}
}