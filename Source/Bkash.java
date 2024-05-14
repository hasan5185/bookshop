package Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import static javax.swing.JOptionPane.showMessageDialog;


public class Bkash extends JFrame implements ActionListener {
	
    MyTextField cn,ex,cvc,chn;
    Panel panel;
    JLabel pay;
    JButton b1,b2,b3,back;
    String username;
	
	public Bkash(String username) {
		super("Bkash");
		this.setBounds(0,0,1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.username=username;
		
		panel = new Panel();
		panel.setBackground(new Color(102, 153, 153));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		pay= new JLabel(new ImageIcon("image/bkash.png"));
		pay.setBounds(0,0,1100,685);
		panel.add(pay);
		
		JPanel c=new JPanel();
		c.setBackground(new Color(255, 255, 255));
		panel.add(c);
		c.setLayout(null);
		
		cn = new MyTextField();
		cn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cn.setOpaque(false);
		cn.setBounds(643, 142, 311, 57);
		((MyTextField) cn).setHint("User name");
		c.add(cn);

		b1 = new JButton();
		b1.setText("Confirm");
		b1.setBounds(838,540,199,45);
		b1.setBorder(null);
		b1.setBackground(Color.decode("#808080"));
		b1.addActionListener(this);
		panel.add(b1);
   

		b2 = new JButton();
		b2.setText("Close");
		b2.setBounds(635,540,200,45);
		b2.setBorder(null);
		b2.setBackground(Color.decode("#808080"));
		b2.addActionListener(this);
		panel.add(b2);

		
		this.setVisible(true);
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