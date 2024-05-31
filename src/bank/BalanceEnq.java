package bank;

import javax.swing.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnq extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;

    BalanceEnq(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);

        image.add(back);
        int balance = 0;
        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                } else {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnq("").setVisible(true);
    }
}
