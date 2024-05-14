package Source;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.*;

public class Cart extends JFrame implements ActionListener{
	
	DefaultTableModel model;
	JTable table;
	Panel panel;
	JButton btnBuy,backBtn,homebtn,profile;
	String username;
	
	String[] rows = new String[3];
	
	String file = ".\\data\\cart_data.txt";
    String temp = ".\\data\\temp.txt";
	
	public Cart(String username){
		
		super("Cart");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
		this.username=username;
		
		panel = new Panel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		titleBar();
		
		btnBuy = new MyButton();
		btnBuy.setText("Buy now");
		btnBuy.setFocusPainted(false);
		btnBuy.setBounds(815,530, 150, 36);
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) btnBuy).setRedius(10);
		btnBuy.setBorder(null);
		panel.add(btnBuy);
		btnBuy.addActionListener(this);
		btnBuy.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnBuy.setBackground(new Color(25, 118, 211));
                btnBuy.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                btnBuy.setForeground(new Color(25, 118, 211));
                btnBuy.setBackground(new Color(255, 255, 255));
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
		model.addColumn("Quantity");
		model.addColumn("Price");
        table.getColumnModel().getColumn(0).setPreferredWidth(447);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

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
				int a=username.length();
				String line = Files.readAllLines(Paths.get(file)).get(i);
				String x = line.substring((3+a), (a+7));
				int b=a+14;
				if (x.equals("Book")){
					rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(b); 
					rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(b); 
					rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(b);  
                  
					model.addRow(rows);
				}
			}

        } 
		catch (Exception ex) {return;}
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==homebtn) {
			this.setVisible(false);
			new Form1(username);
		}
		if(e.getSource()==backBtn) {
			this.setVisible(false);
			new Form1(username);
		}
		if(e.getSource()==btnBuy) {
			
			int a=username.length();
			
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
                    String x = line.substring(0,a);
                    if (x.equals(username)){
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
						String x = userName.substring(0, 6);
						if(x.equals("Bought")){
							pw.println(userName);
						}
						if(!(x.equals("Bought"))){
							pw.println("Bought " + userName);
						}
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
			this.setVisible(false);
		    new Payment1(username);
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
		
		homebtn = new JButton("");
		homebtn.setContentAreaFilled(false);
		homebtn.setFocusPainted(false);
		homebtn.setBorder(null);
		homebtn.setIcon(new ImageIcon("image/home2.png"));
		homebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homebtn.setBounds(130, 22, 43, 31);
		titleBarPanel.add(homebtn);
		homebtn.addActionListener(this);
		
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
		Bookshop.setBounds(492, 22, 153, 31);
		titleBarPanel.add(Bookshop);
	}
}