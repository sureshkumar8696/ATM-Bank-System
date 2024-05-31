package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawl, miniStatement, pinChange, fastCash, balance, exit;
    String pinNumber;
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));

        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Balance");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnq(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
