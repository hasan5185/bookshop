package Source;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class LogIn extends JFrame implements ActionListener{
	
	JTextField txtuserField;
	JPasswordField passField;
	JCheckBox showpassBox;
	JButton loginBtn,signBtn,adminBtn;
	JLabel imagelb,logolb;
	
	public LogIn() {
		super("Log In");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#FFCF79"));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		imagelb = new JLabel("");
		imagelb.setBounds(0, 0, 530, 648);
		imagelb.setIcon(new ImageIcon("image/Welcome.png"));
		panel.add(imagelb);
		
		logolb = new JLabel("New label");
		logolb.setBounds(702, 85, 176, 176);
		logolb.setIcon(new ImageIcon("image/login.png"));
		panel.add(logolb);
		
		txtuserField = new MyTextField();
		txtuserField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuserField.setOpaque(false);
		txtuserField.setBounds(643, 285, 311, 57);
		((MyTextField) txtuserField).setHint("User name");
		panel.add(txtuserField);
		
		passField = new MyPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passField.setOpaque(false);
		passField.setBounds(643, 374, 311, 57);
		((MyPasswordField) passField).setHint("Password");
		panel.add(passField);
		
		adminBtn = new JButton("Admin login");
		adminBtn.setContentAreaFilled(false);
		adminBtn.setBorderPainted(false);
		adminBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		adminBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		adminBtn.setForeground(new Color(255, 255, 255));
		adminBtn.setFocusPainted(false);
		adminBtn.setBounds(835, 436, 128, 34);
		panel.add(adminBtn);
		adminBtn.addActionListener(this);
		
		showpassBox = new JCheckBox("Show Password");
		showpassBox.setFocusPainted(false);
		showpassBox.setContentAreaFilled(false);
		showpassBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showpassBox.setForeground(new Color(255, 255, 255));
		showpassBox.setBorder(null);
		showpassBox.setBounds(650, 437, 140, 34);
		panel.add(showpassBox);
		showpassBox.addActionListener(this);	
		
		loginBtn = new MyButton();
		loginBtn.setText("Log in");
		loginBtn.setFocusPainted(false);
		loginBtn.setBounds(643, 481, 148, 40);
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) loginBtn).setRedius(10);
		loginBtn.setBorder(null);;
		panel.add(loginBtn);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginBtn.setBackground(new Color(25, 118, 211));
                loginBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                loginBtn.setForeground(new Color(25, 118, 211));
                loginBtn.setBackground(new Color(255, 255, 255));
            }
        });
			
		signBtn = new MyButton();
		signBtn.setText("Sign up");;
		signBtn.setFocusPainted(false);
		signBtn.setBounds(806, 481, 148, 40);
		signBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		signBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) signBtn).setRedius(10);
		signBtn.setBorder(null);
		panel.add(signBtn);
		signBtn.addActionListener(this);
		signBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                signBtn.setBackground(new Color(25, 118, 211));
                signBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                signBtn.setForeground(new Color(25, 118, 211));
                signBtn.setBackground(new Color(255, 255, 255));
            }
        });
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showpassBox) {
			if(showpassBox.isSelected()) {
				passField.setEchoChar((char)0);
			}
			else {
				passField.setEchoChar('*');;
			}
		}
		if(e.getSource()==loginBtn) {
			String textField1 = txtuserField.getText(); // User Name 
            String textField2 = passField.getText(); // Password

            if (textField1.isEmpty() || textField2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }
			else{
				try{
					String userNameS = "User Name  : " + textField1;
					String passwordS = "Password   : " + textField2;
					BufferedReader reader = new BufferedReader(new FileReader(".\\data\\user_data.txt"));

					int totalLines = 0;
					while (reader.readLine() != null){
						totalLines++;
					}
					reader.close();

					for (int i = 0; i <= totalLines; i++) {
						String line = Files.readAllLines(Paths.get(".\\data\\user_data.txt")).get(i);
						if (line.equalsIgnoreCase(userNameS)) {
							String line2 = Files.readAllLines(Paths.get(".\\data\\user_data.txt")).get((i + 1));
								if (line2.equals(passwordS)) {
									JOptionPane.showMessageDialog(null, "Login Successful.", "Boi Jatra!",
										JOptionPane.WARNING_MESSAGE);

									this.setVisible(false);
									new Form1(textField1);
									break;
								}
						}
					}
				}
				catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
            
				}
			}
		}
		if(e.getSource()==signBtn){
			this.setVisible(false);
			SignUp s=new SignUp();
		}
		if(e.getSource()==adminBtn){
			this.setVisible(false);
			new AdminLogIn();
		}
	}
}
