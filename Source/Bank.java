package Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;



public class Bank extends JFrame implements ActionListener {

    JTextField cn,ex,cvc,chn;
    Panel panel;
    JLabel pay,l1,l2;
    JButton b1,b2,b3,back;
    ImageIcon i1,i2,i3;
    String username;
	public Bank(String username) {
		super("Bank");
		this.setBounds(0,0,1100, 685);
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
		
		pay= new JLabel(new ImageIcon("image/bank1.png"));
		pay.setBounds(0,0,546,685);
		panel.add(pay);
	

		back = new JButton(new ImageIcon("image/back.png"));
		back.setBounds(10,10,35,35);
		back.addActionListener(this);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		panel.add(back);

		l1 = new JLabel(new ImageIcon("image/vissa.png"));
		l1.setBounds(750,235,70,50);
		panel.add(l1);

		l2 = new JLabel(new ImageIcon("image/master.png"));
		l2.setBounds(820,235,70,50);
		panel.add(l2);

		cn = new MyTextField();
		cn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cn.setOpaque(false);
		cn.setBounds(690, 280, 280, 40);
		((MyTextField) cn).setHint("Enter Card Number");
		panel.add(cn);

		ex = new MyTextField();
		ex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ex.setOpaque(false);
		ex.setBounds(690, 330, 130, 40);
		((MyTextField) ex).setHint("MM/YY");
		panel.add(ex);

		cvc = new MyTextField();
		cvc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cvc.setOpaque(false);
		cvc.setBounds(840, 330, 130, 40);
		((MyTextField) cvc).setHint("CVC/CVV");
		panel.add(cvc);

		chn = new MyTextField();
		chn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chn.setOpaque(false);
		chn.setBounds(690, 380, 280, 40);
		((MyTextField) chn).setHint("Card Holder Name");
		panel.add(chn);

		b1 = new JButton("Procced");
		b1.setBounds(690, 430,130,40);
		b1.setBorder(null);
		b1.setFont(new Font("Algreya", Font.BOLD, 18));
		b1.setForeground(new Color(25, 118, 211));
		b1.setBackground(new Color(255, 255, 255));
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		panel.add(b1);

		b2 = new MyButton();
		b2.setText("Cancel");
		b2.setBounds(840, 430,130,40);
		b2.setBorder(null);
		b2.setFont(new Font("Algreya", Font.BOLD, 18));
		b2.setForeground(new Color(255,0,0 ));
		b2.setBackground(new Color(255, 255, 255));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		panel.add(b2);

		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(25, 118, 211));
				b1.setForeground(new Color(255, 255, 255));
			}

			public void mouseExited(MouseEvent e) {
				b1.setForeground(new Color(25, 118, 211));
				b1.setBackground(new Color(255, 255, 255));
			}
		});

		b2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(255,0,0));
				b2.setForeground(new Color(255, 255, 255));
			}

			public void mouseExited(MouseEvent e) {
				b2.setForeground(new Color(255, 0,0));
				b2.setBackground(new Color(255, 255, 255));
			}
		});




    }


    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == b1) {
            if (cn.getText().equals("") || ex.getText().equals("") || cvc.getText().equals("") || chn.getText().equals("")) {
                showMessageDialog(null, " You need to fill all information", "Message",-1);
			}

			else {
				showMessageDialog(null, "Payment Complete", "Thank You", -1);
                    this.setVisible(false);
					new Form1(username);
			}
        }
        if (e.getSource() == b2){
            this.setVisible(false);
			new Payment1(username);
        }
    }

}