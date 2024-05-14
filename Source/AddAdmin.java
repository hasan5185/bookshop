package Source;

import FileIo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class AddAdmin extends JFrame implements ActionListener{

	JTextField usernameField;
	JPasswordField passField,conpassField;
	JCheckBox showpassBox;
	JButton signBtn,cancelBtn;
	JLabel imagelb,logolb;
	
	String username;
	
	public AddAdmin(String username) {
		super("Admin Sign Up");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
		this.setResizable(false);
		this.username=username;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		imagelb = new JLabel("New label");
		imagelb.setBounds(0, 0, 530, 648);
		imagelb.setIcon(new ImageIcon("image/adduser2.jpg"));
		panel.add(imagelb);
		
		logolb = new JLabel("New label");
		logolb.setBounds(699, 53, 214, 168);
		logolb.setIcon(new ImageIcon("image/addadmin.png"));
		panel.add(logolb);
		
		usernameField = new MyTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setOpaque(false);
		usernameField.setBounds(650, 250, 311, 57);
		((MyTextField) usernameField).setHint("User name");
		panel.add(usernameField);
		
		passField = new MyPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passField.setOpaque(false);
		passField.setBounds(650, 326, 311, 57);
		((MyPasswordField) passField).setHint("Password");
		panel.add(passField);
		
		conpassField = new MyPasswordField();
		conpassField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		conpassField.setOpaque(false);
		conpassField.setBounds(650, 404, 311, 57);
		((MyPasswordField) conpassField).setHint("Confirm Password");
		panel.add(conpassField);
		
		showpassBox = new JCheckBox("Show Password");
		showpassBox.setFocusPainted(false);
		showpassBox.setContentAreaFilled(false);
		showpassBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showpassBox.setForeground(new Color(255, 255, 255));
		showpassBox.setBorder(null);
		showpassBox.setBounds(657, 467, 140, 34);
		panel.add(showpassBox);
		showpassBox.addActionListener(this);
		
		cancelBtn = new Source.MyButton();
		cancelBtn.setText("Cancel");
		cancelBtn.setFocusPainted(false);
		cancelBtn.setBounds(650, 507, 148, 40);
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) cancelBtn).setRedius(10);
		cancelBtn.setBorder(null);;
		panel.add(cancelBtn);
		cancelBtn.addActionListener(this);
		cancelBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                cancelBtn.setBackground(new Color(25, 118, 211));
                cancelBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                cancelBtn.setForeground(new Color(25, 118, 211));
                cancelBtn.setBackground(new Color(255, 255, 255));
            }
        });
			
		signBtn = new MyButton();
		signBtn.setText("Sign up");;
		signBtn.setFocusPainted(false);
		signBtn.setBounds(813, 507, 148, 40);
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
		if(e.getSource()==cancelBtn) {
			this.setVisible(false);
			new AdminPanel(username);
		}
		if(e.getSource()==showpassBox) {
			if(showpassBox.isSelected()) {
				passField.setEchoChar((char)0);
				conpassField.setEchoChar((char)0);
			}
			else {
				passField.setEchoChar('*');
				conpassField.setEchoChar('*');
			}
		}
		if(e.getSource()==signBtn) {
			String textField1 = usernameField.getText();
            String textField2 = passField.getText();
            String textField3 = conpassField.getText();

            if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
            }
			else if(textField2.equals(textField3)){
				if(!textField2.isEmpty()){
					new AdminRegistration(textField1,textField2);
					JOptionPane.showMessageDialog(this, "Registration Succesful.", "Log In",
                            JOptionPane.WARNING_MESSAGE);
					this.setVisible(false);   
					new AdminPanel(username);
				}
			}
			else{
					JOptionPane.showMessageDialog(this, "Password missmatch", "Warning",
                    JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
