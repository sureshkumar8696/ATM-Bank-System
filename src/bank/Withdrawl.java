package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton back, withdrawl;
    String pinNumber;

    Withdrawl(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
            } else {
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '" + pinNumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Withdraw")) {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if ((balance - Integer.parseInt(number)) > 0) {
                        String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw','"
                                + number
                                + "')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}