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

public class SignUp extends JFrame implements ActionListener{
	
	JTextField usernameField,emailField,addressField;
	JPasswordField passField,conpassField;
	JCheckBox showpassBox;
	JButton signBtn;
	JLabel imagelb,registrationLb;
	
	public SignUp() {
		super("Sign Up");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		imagelb = new JLabel("New label");
		imagelb.setBounds(0, 0, 530, 648);
		imagelb.setIcon(new ImageIcon("image/signUp.jpg"));
		panel.add(imagelb);
		
		registrationLb = new JLabel("Complete the Registration");
		registrationLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		registrationLb.setForeground(new Color(255, 255, 255));
		registrationLb.setBounds(660, 67, 268, 40);
		panel.add(registrationLb);
		
		usernameField = new MyTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setOpaque(false);
		usernameField.setBounds(643, 142, 311, 57);
		((MyTextField) usernameField).setHint("User name");
		panel.add(usernameField);
		
		emailField = new MyTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailField.setOpaque(false);
		emailField.setBounds(643, 209, 311, 57);
		((MyTextField) emailField).setHint("Email");
		panel.add(emailField);
		
		addressField = new MyTextField();
		addressField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressField.setOpaque(false);
		addressField.setBounds(643, 276, 311, 57);
		((MyTextField) addressField).setHint("Address");
		panel.add(addressField);
		
		passField = new MyPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passField.setOpaque(false);
		passField.setBounds(643, 343, 311, 57);
		((MyPasswordField) passField).setHint("Password");
		panel.add(passField);
		
		conpassField = new MyPasswordField();
		conpassField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		conpassField.setOpaque(false);
		conpassField.setBounds(643, 410, 311, 57);
		((MyPasswordField) conpassField).setHint("Confirm Password");
		panel.add(conpassField);
		
		showpassBox = new JCheckBox("Show Password");
		showpassBox.setFocusPainted(false);
		showpassBox.setContentAreaFilled(false);
		showpassBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showpassBox.setForeground(new Color(255, 255, 255));
		showpassBox.setBorder(null);
		showpassBox.setBounds(650, 473, 140, 34);
		panel.add(showpassBox);
		showpassBox.addActionListener(this);
			
		signBtn = new MyButton();
		signBtn.setText("Sign up");
		signBtn.setFocusPainted(false);
		signBtn.setBounds(643, 513, 311, 40);
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
				conpassField.setEchoChar((char)0);
			}
			else {
				passField.setEchoChar('*');
				conpassField.setEchoChar('*');
			}
		}
		if(e.getSource()==signBtn) {
			String textField1 = usernameField.getText();
            String textField2 = emailField.getText();
            String textField3 = passField.getText(); 
            String textField4 = conpassField.getText();
			String textField5 = addressField.getText();

            if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                    || textField5.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
            }
			if(textField4.equals(textField3)){
				if(!textField3.isEmpty()){
					Registration r=new Registration(textField1,textField2,textField3,textField5);
					JOptionPane.showMessageDialog(this, "Registration Succesful.", "Log In",
                            JOptionPane.WARNING_MESSAGE);
					this.setVisible(false);   
					new LogIn();
				}
			}
			else{
					JOptionPane.showMessageDialog(this, "Password missmatch", "Warning",
                    JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
