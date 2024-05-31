package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("NEW PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repinText = new JLabel("Re-ENTER PIN:");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(165, 360, 180, 25);
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = pin.getText();
            String rpin = repin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == change) {
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter new PIN");

                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");

                }

                Conn conn = new Conn();
                String query = "update bank set pinnumber ='" + rpin + "'where pinnumber='" + pinNumber + "' ";
                String query1 = "update login set pinnumber ='" + rpin + "'where pinnumber='" + pinNumber + "' ";
                String query2 = "update signupthree set pinnumber ='" + rpin + "'where pinnumber='" + pinNumber + "' ";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
