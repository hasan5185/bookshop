package Source;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AdminPanel extends JFrame implements ActionListener{
	Panel panel;
	JButton btnUserInfo,btnOrderInfo,btnAddUser,btnAddAdmin,backBtn,profile;
	JLabel imageLb,dashboardLb,userinfoLb,orderinfoLb,adduserLb,addadminLb;
	
	String username;
	
	public AdminPanel(String username){
		super("AdminPanel");
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
		
		imageLb = new JLabel();
        imageLb.setIcon(new ImageIcon("image/admin.png"));
        imageLb.setBounds(0,74,500,574);
        panel.add(imageLb);
        
		dashboardLb = new JLabel("Admin Dashboard");
        dashboardLb.setBounds(590, 100, 339, 40);
        dashboardLb.setForeground(Color.white);
        dashboardLb.setFont(new Font("Segoe UI", Font.BOLD, 40));
        panel.add(dashboardLb);
        
        
        btnUserInfo = new JButton();
        btnUserInfo.setIcon(new ImageIcon("image/userinfo.png"));
        btnUserInfo.setBounds(540, 175, 214, 168);
        btnUserInfo.setFocusPainted(false);
        btnUserInfo.setBackground(Color.white);
        btnUserInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnUserInfo);
		btnUserInfo.addActionListener(this);
        
        btnOrderInfo = new JButton();
        btnOrderInfo.setIcon(new ImageIcon("image/adduser.jpg"));
        btnOrderInfo.setBounds(790, 175, 214, 168);
        btnOrderInfo.setFocusPainted(false);
        btnOrderInfo.setBackground(Color.white);
        btnOrderInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOrderInfo.addActionListener(this);
        panel.add(btnOrderInfo);

        btnAddUser = new JButton();
        btnAddUser.setIcon(new ImageIcon("image/addUser.png"));
        btnAddUser.setBounds(540, 396, 214, 168);
        btnAddUser.setFocusPainted(false);
        btnAddUser.setBackground(Color.white);
        btnAddUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddUser.addActionListener(this);
        panel.add(btnAddUser);

        btnAddAdmin = new JButton();
        btnAddAdmin.setIcon(new ImageIcon("image/addadmin.png"));
        btnAddAdmin.setBounds(790, 396, 214, 168);
        btnAddAdmin.setFocusPainted(false);
        btnAddAdmin.setBackground(Color.white);
        btnAddAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddAdmin.addActionListener(this);
        panel.add(btnAddAdmin);
        
		userinfoLb = new JLabel("User Information");
        userinfoLb.setBounds(575, 350, 200, 35);
        userinfoLb.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        userinfoLb.setForeground(Color.white);
        panel.add(userinfoLb );
		
		orderinfoLb = new JLabel("Order Information");
        orderinfoLb.setBounds(820, 350, 200, 35);
        orderinfoLb.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        orderinfoLb.setForeground(Color.white);
        panel.add(orderinfoLb );
		
		adduserLb = new JLabel("Add User");
        adduserLb.setBounds(600, 571, 200, 35);
        adduserLb.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        adduserLb.setForeground(Color.white);
        panel.add(adduserLb );
		
		addadminLb = new JLabel("Add Admin");
        addadminLb.setBounds(840, 571, 200, 35);
        addadminLb.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addadminLb.setForeground(Color.white);
        panel.add(addadminLb );
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnUserInfo){
			this.setVisible(false);
			new UserInfo(username);
		}
		if(e.getSource()==btnOrderInfo){
			this.setVisible(false);
			new OrderInfo(username);
		}
		if(e.getSource()==btnAddUser){
			this.setVisible(false);
			new AddUser(username);
		}
		if(e.getSource()==btnAddAdmin){
			this.setVisible(false);
			new AddAdmin(username);
		}
		if(e.getSource()==backBtn){
			this.setVisible(false);
			new AdminLogIn();
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
		
		JLabel Boijatra = new JLabel("Bookshop");
		Boijatra.setFont(new Font("Tahoma", Font.BOLD, 24));
		Boijatra.setForeground(Color.white);
		Boijatra.setBounds(492, 22, 153, 31);
		titleBarPanel.add(Boijatra);
	}
}