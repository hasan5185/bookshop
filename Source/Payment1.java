package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment1 extends JFrame implements ActionListener {
	
    Panel panel;
    JLabel pay,l1,l2;
    JButton b1,b2,b3,back;
	
    String username;
	
	public Payment1(String username) {
		super("Payment1");
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
		
		pay= new JLabel(new ImageIcon("image/payOnline1.png"));
		pay.setBounds(0,0,546,685);
		panel.add(pay);

		back = new JButton(new ImageIcon("image/back.png"));
		back.setBounds(1000,10,35,35);
		back.addActionListener(this);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		panel.add(back);

		b1 = new JButton(new ImageIcon("image/card1.png"));
		b1.setBounds(640,250,150,150);
		b1.addActionListener(this);
		panel.add(b1);

		b2 = new JButton(new ImageIcon("image/bkash1.png"));
		b2.setBounds(850,250,150,150);
		b2.addActionListener(this);
		panel.add(b2);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            this.setVisible(false);
            new Bank(username);
        }
        else if(e.getSource() == b2)
        {
            this.setVisible(false);
            new Bkash(username);
        }
        else if(e.getSource() == back){
			this.setVisible(false);
			new Form1(username);
        }

    }

}
