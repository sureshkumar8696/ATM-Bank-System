package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, income, education;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel religionLabel = new JLabel("Religion: ");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String[] valReligion = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        // Category
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String[] valCategory = { "General", "OBC", "SC", "ST", "Other" };
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        // Income
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String[] incomeCategory = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Up to 10,00,000" };
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        // Education
        JLabel educationLabel = new JLabel("Qualification: ");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        String[] educationValues = { "Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", "Others" };
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 340, 200, 30);
        add(occupationLabel);

        String[] occupationValues = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others" };
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        // PAN
        JLabel panLabel = new JLabel("Pan Number: ");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 390, 200, 30);
        add(panLabel);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        // Aadhar
        JLabel aadharLabel = new JLabel("Aadhar Number: ");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 440, 200, 30);
        add(aadharLabel);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 440, 400, 30);
        add(aadhar);

        // Senior Citizen
        JLabel seniorCitizenLabel = new JLabel("Senior Citizen: ");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizenLabel.setBounds(100, 490, 200, 30);
        add(seniorCitizenLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        // Existing Account
        JLabel existingAccountLabel = new JLabel("Existing Account: ");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 540, 200, 30);
        add(existingAccountLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 590, 80, 30);
        add(next);

        next.addActionListener(this); // Added action listener for the button

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 700);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religionString = religion.getSelectedItem().toString();
        String categoryString = category.getSelectedItem().toString();
        String incomeString = income.getSelectedItem().toString();
        String educationString = education.getSelectedItem().toString();
        String occupationString = occupation.getSelectedItem().toString();
        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }
        String panCard = pan.getText();
        String aadharCard = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + religionString + "','" + categoryString
                    + "','" + incomeString + "','" + educationString + "','" + occupationString + "','" + panCard + "','"
                    + aadharCard + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Form Submitted Successfully");
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
