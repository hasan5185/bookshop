package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BikashPay extends JFrame  implements ActionListener
{
	Font font = new Font ("Speak pro Light" , Font.PLAIN , 25);
	JPanel panel;
	JTextField cn,ex,cvc,chn;
	JButton b1,b2;
	ImageIcon icon1 = new ImageIcon ("Image/bkash1.jpg");
	
	
	public BikashPay ()
	{
		super("");
		this.setSize(1100,685);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1100,685);
		panel.setOpaque(false);
		this.add(panel);
		this.setLayout(null);
		
		JLabel background = new JLabel(icon1);
		background.setBounds(0,0,1100,685);
		this.add(background);
		
		cn = new JTextField();
        cn.setBounds(674, 409, 325, 55);
		cn.setFont(font);
		panel.add(cn);
		 
		 
		b1 = new JButton();
		b1.setText("Confirm");
		b1.setBounds(850,535,188,50);
		b1.setBorder(null);
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.BLACK);
		b1.addActionListener(this);
		panel.add(b1);
   
		b2 = new JButton();
		b2.setText("Close");
		b2.setBounds(632,535,210,50);
		b2.setBorder(null);
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.BLACK);
		b2.addActionListener(this);
		panel.add(b2);

		this.setVisible(true);
    }
	
	
     public void actionPerformed(ActionEvent e)
    {
            if (e.getSource() == b1) {
                if (cn.getText().equals(""))
					{
						 JOptionPane.showMessageDialog(this, "You need to give your Bikask Number", "Information",
				JOptionPane.INFORMATION_MESSAGE);
                }

                else {
                     JOptionPane.showMessageDialog(null, "Payment Complete", "Thank You",-1);
                    this.setVisible(false);

                }
            }
        if (e.getSource() == b2)
        {
            new MenuCard();
            this.setVisible(false);
        }
        }
    

}