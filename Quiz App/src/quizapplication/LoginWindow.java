package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame implements ActionListener {

    JButton btnStart; 
    JTextField txtName;

    LoginWindow() {
        
        setBounds(300, 100, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Java Quizlet");

        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image img = icon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imgLabel = new JLabel(scaledIcon);
        imgLabel.setBounds(0, 0, 600, 500);
        add(imgLabel);

        // Add heading
        JLabel lblHeading = new JLabel("Java Quizlet");
        lblHeading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        lblHeading.setForeground(new Color(30, 144, 254));
        lblHeading.setBounds(630, 60, 400, 45);
        add(lblHeading);

        // Add name label
        JLabel lblName = new JLabel("Enter Your Name");
        lblName.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        lblName.setForeground(new Color(30, 144, 254));
        lblName.setBounds(660, 150, 300, 20);
        add(lblName);

        JPanel namePanel = new JPanel();
        namePanel.setBounds(660, 180, 300, 45);
        namePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        namePanel.setLayout(new BorderLayout());

        // Add text field for name input
        txtName = new JTextField();
        txtName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        namePanel.add(txtName);
        add(namePanel);

        // Add start button
        btnStart = new JButton("Start");
        btnStart.setBounds(660, 250, 120, 40);
        btnStart.setBackground(new Color(30, 144, 254));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFont(new Font("Arial", Font.BOLD, 16));
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(this);
        add(btnStart);

        setSize(1000, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) { // Added action for Start button
            String userName = txtName.getText();
            if (!userName.trim().isEmpty()) {
                setVisible(false);
                new Quiz(userName);
            } else {
                JOptionPane.showMessageDialog(this, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
