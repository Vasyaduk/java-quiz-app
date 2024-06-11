package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    public Score(String name, int score) {
        // Set up the main frame
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add an image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(225, 50, 300, 250);
        add(image);

        // Heading label
        JLabel heading = new JLabel("Thank you " + name + " for playing Java Quiz");
        heading.setBounds(50, 320, 650, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // Score label
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(50, 360, 650, 30);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblscore.setHorizontalAlignment(SwingConstants.CENTER);
        lblscore.setForeground(new Color(30, 144, 254));
        add(lblscore);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(315, 420, 120, 40);
        exitButton.setBackground(new Color(30, 144, 254));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        exitButton.addActionListener(this);
        add(exitButton);

        // Set the frame to be visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0); // Close the program
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
