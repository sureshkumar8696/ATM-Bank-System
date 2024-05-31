package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawl, miniStatement, pinChange, fastCash, balance, exit;
    String pinNumber;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));

        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Rs 10000");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn con = new Conn();
            try {
                if (pinNumber != "") {
                    ResultSet rs = con.s.executeQuery("select * from bank where pinnumber = '" + pinNumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balnace");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "','Withdraw', '" + amount
                            + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Account Not Found Login Again");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
