package Source;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Form1 extends JFrame implements ActionListener{
	JTextField textField;
	JButton toolbtn,cart,profile,btnBook1,btnBook2,btnb3,btnb4,btnb5,btnb6,btnb7,btnb8,btnb9,btnb10,btnb11,btnb12;
	Panel panel;
	String username;
	
	public Form1(String username) {
		super("Home");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
		this.setResizable(false);
		this.username=username;
		
		panel = new Panel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		titleBar();
		
		JPanel bk1 = new JPanel();
		bk1.setBounds(67, 150, 129, 168);
		panel.add(bk1);
		bk1.setLayout(null);
		
		btnBook1 = new JButton("");
		btnBook1.setContentAreaFilled(false);
		btnBook1.setFocusPainted(false);
		btnBook1.setBounds(0, 0, 129, 168);
		btnBook1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk1.add(btnBook1);
		btnBook1.addActionListener(this);
		
		JLabel bp1 = new JLabel("New label");
		bp1.setIcon(new ImageIcon("image/1.jpg"));
		bp1.setBounds(0, 0, 129, 168);
		bk1.add(bp1);
		
		JPanel bk2 = new JPanel();
		bk2.setBounds(226, 150, 129, 168);
		panel.add(bk2);
		bk2.setLayout(null);
		
		btnBook2 = new JButton("");
		btnBook2.setFocusPainted(false);
		btnBook2.setContentAreaFilled(false);
		btnBook2.setBounds(0, 0, 129, 168);
		btnBook2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk2.add(btnBook2);
		btnBook2.addActionListener(this);
		
		JLabel bp2 = new JLabel("New label");
		bp2.setIcon(new ImageIcon("image/2.jpg"));
		bp2.setBounds(0, 0, 129, 168);
		bk2.add(bp2);
		
		JPanel bk3 = new JPanel();
		bk3.setBounds(392, 150, 129, 168);
		panel.add(bk3);
		bk3.setLayout(null);
		
		btnb3 = new JButton("");
		btnb3.setFocusPainted(false);
		btnb3.setContentAreaFilled(false);
		btnb3.setBounds(0, 0, 129, 168);
		btnb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk3.add(btnb3);
		btnb3.addActionListener(this);
		
		JLabel bp3 = new JLabel("");
		bp3.setIcon(new ImageIcon("image/3.jpg"));
		bp3.setBounds(0, 0, 129, 168);
		bk3.add(bp3);
		
		JPanel bk4 = new JPanel();
		bk4.setBounds(560, 150, 129, 168);
		panel.add(bk4);
		bk4.setLayout(null);
		
		btnb4 = new JButton("");
		btnb4.setFocusPainted(false);
		btnb4.setContentAreaFilled(false);
		btnb4.setBounds(0, 0, 129, 168);
		btnb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk4.add(btnb4);
		btnb4.addActionListener(this);
		
		JLabel bp4 = new JLabel("New label");
		bp4.setIcon(new ImageIcon("image/4.jpg"));
		bp4.setBounds(0, 0, 129, 168);
		bk4.add(bp4);
		
		JPanel b5 = new JPanel();
		b5.setBounds(732, 150, 129, 168);
		panel.add(b5);
		b5.setLayout(null);
		
		btnb5 = new JButton("");
		btnb5.setFocusPainted(false);
		btnb5.setContentAreaFilled(false);
		btnb5.setBounds(0, 0, 129, 168);
		btnb5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b5.add(btnb5);
		btnb5.addActionListener(this);
		
		JLabel bp5 = new JLabel("");
		bp5.setIcon(new ImageIcon("image/5.jpg"));
		bp5.setBounds(0, 0, 129, 168);
		b5.add(bp5);
		
		JPanel bk6 = new JPanel();
		bk6.setBounds(902, 150, 129, 168);
		panel.add(bk6);
		bk6.setLayout(null);
		
		btnb6 = new JButton("");
		btnb6.setFocusPainted(false);
		btnb6.setContentAreaFilled(false);
		btnb6.setBounds(0, 0, 129, 168);
		btnb6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk6.add(btnb6);
		btnb6.addActionListener(this);
		
		JLabel bp6 = new JLabel("New label");
		bp6.setIcon(new ImageIcon("image/6.jpg"));
		bp6.setBounds(0, 0, 129, 168);
		bk6.add(bp6);
		
		JPanel bk7 = new JPanel();
		bk7.setBounds(67, 367, 129, 168);
		panel.add(bk7);
		bk7.setLayout(null);
		
		btnb7 = new JButton("");
		btnb7.setFocusPainted(false);
		btnb7.setContentAreaFilled(false);
		btnb7.setBounds(0, 0, 129, 168);
		btnb7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk7.add(btnb7);
		btnb7.addActionListener(this);
		
		JLabel bp7 = new JLabel("New label");
		bp7.setIcon(new ImageIcon("image/7.jpg"));
		bp7.setBounds(0, 0, 129, 168);
		bk7.add(bp7);
		
		JPanel bk8 = new JPanel();
		bk8.setBounds(226, 367, 129, 168);
		panel.add(bk8);
		bk8.setLayout(null);
		
		btnb8 = new JButton("");
		btnb8.setFocusPainted(false);
		btnb8.setContentAreaFilled(false);
		btnb8.setBounds(0, 0, 129, 168);
		btnb8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk8.add(btnb8);
		btnb8.addActionListener(this);
		
		JLabel bp8 = new JLabel("New label");
		bp8.setIcon(new ImageIcon("image/8.jpg"));
		bp8.setBounds(0, 0, 129, 168);
		bk8.add(bp8);
		
		JPanel bk9 = new JPanel();
		bk9.setBounds(392, 367, 129, 168);
		panel.add(bk9);
		bk9.setLayout(null);
		
		btnb9 = new JButton("");
		btnb9.setFocusPainted(false);
		btnb9.setContentAreaFilled(false);
		btnb9.setBounds(0, 0, 129, 168);
		btnb9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk9.add(btnb9);
		btnb9.addActionListener(this);
		
		JLabel bp9 = new JLabel("New label");
		bp9.setIcon(new ImageIcon("image/9.jpg"));
		bp9.setBounds(0, 0, 129, 168);
		bk9.add(bp9);
		
		JPanel bk10 = new JPanel();
		bk10.setBounds(560, 367, 129, 168);
		panel.add(bk10);
		bk10.setLayout(null);
		
		btnb10 = new JButton("");
		btnb10.setFocusPainted(false);
		btnb10.setContentAreaFilled(false);
		btnb10.setBounds(0, 0, 129, 168);
		btnb10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk10.add(btnb10);
		btnb10.addActionListener(this);
		
		JLabel bp10 = new JLabel("New label");
		bp10.setIcon(new ImageIcon("image/10.jpg"));
		bp10.setBounds(0, 0, 129, 168);
		bk10.add(bp10);
		
		JPanel bk11 = new JPanel();
		bk11.setBounds(732, 367, 129, 168);
		panel.add(bk11);
		bk11.setLayout(null);
		
		btnb11 = new JButton("");
		btnb11.setFocusPainted(false);
		btnb11.setContentAreaFilled(false);
		btnb11.setBounds(0, 0, 129, 168);
		btnb11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk11.add(btnb11);
		btnb11.addActionListener(this);
		
		JLabel bp11 = new JLabel("New label");
		bp11.setIcon(new ImageIcon("image/11.jpg"));
		bp11.setBounds(0, 0, 129, 168);
		bk11.add(bp11);
		
		JPanel bk12 = new JPanel();
		bk12.setBounds(902, 367, 129, 168);
		panel.add(bk12);
		bk12.setLayout(null);
		
		btnb12 = new JButton("");
		btnb12.setFocusPainted(false);
		btnb12.setContentAreaFilled(false);
		btnb12.setBounds(0, 0, 129, 168);
		btnb12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bk12.add(btnb12);
		btnb12.addActionListener(this);
		
		JLabel bp12 = new JLabel("New label");
		bp12.setIcon(new ImageIcon("image/12.jpg"));
		bp12.setBounds(0, 0, 129, 168);
		bk12.add(bp12);
	}
	public void actionPerformed(ActionEvent e) {
		if(toolbtn==e.getSource()) {
			this.setVisible(false);
			new Form2(username);	
		}
		if(e.getSource()==cart) {
			this.setVisible(false);
			new Cart(username);
		}
		if(e.getSource()==profile) {
			this.setVisible(false);
			new LogIn();
		}
		if(btnBook1==e.getSource()) {
			this.setVisible(false);
			new Form3(username);
		}
		if(btnBook2==e.getSource()) {
			this.setVisible(false);
			new Form4(username);
		}
		if(btnb3==e.getSource()) {
			this.setVisible(false);
			new Form5(username);
		}
		if(btnb4==e.getSource()) {
			this.setVisible(false);
			new Form6(username);
		}
		if(btnb5==e.getSource()) {
			this.setVisible(false);
			new Form7(username);
		}
		if(btnb6==e.getSource()) {
			this.setVisible(false);
			new Form8(username);
		}
		if(btnb7==e.getSource()) {
			this.setVisible(false);
			new Form9(username);
		}
		if(btnb8==e.getSource()) {
			this.setVisible(false);
			new Form10(username);
		}
		if(btnb9==e.getSource()) {
			this.setVisible(false);
			new Form11(username);
		}
		if(btnb10==e.getSource()) {
			this.setVisible(false);
			new Form12(username);
		}
		if(btnb11==e.getSource()) {
			this.setVisible(false);
			new Form13(username);
		}
		if(btnb12==e.getSource()) {
			this.setVisible(false);
			new Form14(username);
		}
		
	}
	public void titleBar(){
		
		JPanel titleBarPanel = new JPanel();
		titleBarPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		titleBarPanel.setBackground(new Color(102, 153, 204));
		titleBarPanel.setBounds(0, 0, 1647, 77);
		panel.add(titleBarPanel);
		titleBarPanel.setLayout(null);
		
		toolbtn = new JButton("");
		toolbtn.setContentAreaFilled(false);
		toolbtn.setFocusPainted(false);
		toolbtn.setBorder(null);
		toolbtn.setIcon(new ImageIcon("image/menu.png"));
		toolbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		toolbtn.setBounds(65, 22, 43, 31);
		titleBarPanel.add(toolbtn);
		toolbtn.addActionListener(this);
		
		cart = new JButton("");
		cart.setContentAreaFilled(false);
		cart.setFocusPainted(false);
		cart.setBorder(null);
		cart.setIcon(new ImageIcon("image/cart.png"));
		cart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cart.setBounds(981, 22, 43, 31);
		titleBarPanel.add(cart);
		cart.addActionListener(this);
		
		profile = new JButton(username);
		profile.setContentAreaFilled(false);
		profile.setFocusPainted(false);
		profile.setBorder(null);
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		profile.setBounds(880, 22, 98, 31);
		titleBarPanel.add(profile);
		profile.addActionListener(this);
		
		JLabel Bookshop = new JLabel("Bookshop");
		Bookshop.setFont(new Font("Tahoma", Font.BOLD, 24));
		Bookshop.setBounds(492, 22, 153, 31);
		titleBarPanel.add(Bookshop);
	}
}