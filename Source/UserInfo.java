package Source;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.*;

public class UserInfo extends JFrame implements ActionListener{
	DefaultTableModel model;
	JTable table;
	Panel panel;
	JButton btnRemove,backBtn,profile;
	
	String[] rows = new String[5];
	
	String file = ".\\data\\user_data.txt";
	String temp = ".\\data\\tempUser.txt";
	
	String username;
	
	public UserInfo(String username){
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
		
		btnRemove = new MyButton();
		btnRemove.setText("Remove User");
		btnRemove.setFocusPainted(false);
		btnRemove.setBounds(815,530, 150, 36);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) btnRemove).setRedius(10);
		btnRemove.setBorder(null);
		panel.add(btnRemove);
		btnRemove.addActionListener(this);
		btnRemove.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnRemove.setBackground(new Color(25, 118, 211));
                btnRemove.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                btnRemove.setForeground(new Color(25, 118, 211));
                btnRemove.setBackground(new Color(255, 255, 255));
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
		model.addColumn("Password");
		model.addColumn("Email");
		model.addColumn("Address");
		model.addColumn("Time");
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(147);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);

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
				String x = line.substring(0, 4);
				if (x.equals("User")){
					rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); 
					rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(13); 
					rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13);  
					rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(13);  
					rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(13);  
                  
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
		
		if(e.getSource()==btnRemove){
			
			int selectedRows[] = table.getSelectedRows(); 
			String Name = (table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
			
			if(selectedRows.length >=1){
				
				Arrays.sort(selectedRows);
				
				for (int i = selectedRows.length - 1; i >= 0; i--){
					model.removeRow(selectedRows[i]);
					if (i == 0){
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}	
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
			}
				
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
                    String x = line.substring(0, 4);
                    if (x.equals("User")){
						
                        String userName = Files.readAllLines(Paths.get(file)).get(i);
                        if (userName.substring(13).equals(Name)){
                            q = i;
                        }
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
					
                    String line = Files.readAllLines(Paths.get(file)).get(j);
                    String x = line.substring(0, 4);

                    if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))){
						
                        String userName = Files.readAllLines(Paths.get(file)).get(j);
                        pw.println("----Removed By Admin----");
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