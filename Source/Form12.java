package Source;

import FileIo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Form12 extends JFrame implements ActionListener {
	Panel panel;
	JButton backBtn,homebtn,cart,profile,btnBuy,btnCart;
	
	JSpinner spinner;
	SpinnerNumberModel spinModel;
	
	String username;
	String bookName="The Scarlet Letter";
	String price ="100 Taka";

	public Form12(String username) {
		super("Book-10");
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
		
		JPanel bk1panel = new JPanel();
		bk1panel.setBounds(93, 144, 283, 410);
		panel.add(bk1panel);
		bk1panel.setLayout(null);
		
		JLabel bklb1 = new JLabel("New label");
		bklb1.setIcon(new ImageIcon("image/10b.jpg"));
		bklb1.setBounds(0, 0, 283, 410);
		bk1panel.add(bklb1);
		
		JLabel bTitle = new JLabel(bookName);
		bTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		bTitle.setBounds(408, 154, 426, 57);
		panel.add(bTitle);
		
		JLabel bWriter = new JLabel("by Nathaniel Hawthorne");
		bWriter.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		bWriter.setBounds(408, 185, 426, 46);
		panel.add(bWriter);
		
		JLabel priceLb = new JLabel("Price:  "+price);
		priceLb.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		priceLb.setBounds(408, 240, 115, 36);
		panel.add(priceLb);
		
		JLabel quantityLb = new JLabel("Quantity :");
		quantityLb.setFont(new Font("Tahoma", Font.BOLD, 17));
		quantityLb.setBounds(408, 479, 95, 24);
		panel.add(quantityLb);
		
		spinModel = new SpinnerNumberModel(0,0,5,1);
		spinner = new JSpinner(spinModel);
		spinner.setBounds(498, 481, 43, 23);
		spinner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(spinner);
		
		btnCart = new Source.MyButton();
		btnCart.setText("Add to Cart");
		btnCart.setFocusPainted(false);
		btnCart.setBounds(408, 518, 133, 36);
		btnCart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		((MyButton) btnCart).setRedius(10);
		btnCart.setBorder(null);;
		panel.add(btnCart);
		btnCart.addActionListener(this);
		btnCart.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnCart.setBackground(new Color(25, 118, 211));
                btnCart.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                btnCart.setForeground(new Color(25, 118, 211));
                btnCart.setBackground(new Color(255, 255, 255));
            }
        });
			
		btnBuy = new MyButton();
		btnBuy.setText("Buy now");;
		btnBuy.setFocusPainted(false);
		btnBuy.setBounds(565, 518, 133, 36);
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
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==homebtn) {
			this.setVisible(false);
			new Form1(username);
		}
		if(e.getSource()==btnCart) {
			String quantity=String.valueOf(spinner.getValue());
			new CartData(username,bookName,quantity,price);
			JOptionPane.showMessageDialog(null, "Book has been added to cart.", "Boi Jatra!",
				JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			new Form1(username);
		}
		if(e.getSource()==btnBuy) {
			this.setVisible(false);
			new Payment1(username);
		}
		if(e.getSource()==cart) {
			this.setVisible(false);
			new Cart(username);
		}
		if(e.getSource()==backBtn) {
			this.setVisible(false);
			new Form1(username);
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
