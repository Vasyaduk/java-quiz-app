package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;

    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;
    Timer countdownTimer;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz3.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1440, 400);
        add(l1);

        qno = new JLabel("1");
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 550, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 580, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 610, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        populateQuestionsAndAnswers();
        start(count);

        setVisible(true);

        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                repaint();
                if (timer < 0) {
                    timer = 20;
                    enableOptions();
                    if (count == 8) {
                        next.setEnabled(false);
                        submit.setEnabled(true);
                    }
                    if (count == 9) {
                        recordAnswer();
                        calculateScore();
                        setVisible(false);
                        new Score(name, score);
                    } else {
                        recordAnswer();
                        count++;
                        start(count);
                    }
                }
            }
        });
        countdownTimer.start();
    }

    private void populateQuestionsAndAnswers() {
        
        questions[0][0] = "What is the output of the following code snippet?\nint x = 5;\nSystem.out.println(x++);";
        questions[0][1] = "5";
        questions[0][2] = "6";
        questions[0][3] = "4";
        questions[0][4] = "Compilation Error";

        questions[1][0] = "Which of the following is not a primitive data type in Java?";
        questions[1][1] = "int";
        questions[1][2] = "float";
        questions[1][3] = "string";
        questions[1][4] = "char";

        questions[2][0] = "Which keyword is used to define a constant in Java?";
        questions[2][1] = "static";
        questions[2][2] = "final";
        questions[2][3] = "const";
        questions[2][4] = "constant";

        questions[3][0] = "What does JVM stand for?";
        questions[3][1] = "Java Virtual Machine";
        questions[3][2] = "Java Visual Machine";
        questions[3][3] = "Java Virtual Memory";
        questions[3][4] = "Just Virtual Machine";

        questions[4][0] = "Which of the following access modifiers restricts access the most?";
        questions[4][1] = "public";
        questions[4][2] = "protected";
        questions[4][3] = "default";
        questions[4][4] = "private";

        questions[5][0] = "What is the result of 8 % 3?";
        questions[5][1] = "2";
        questions[5][2] = "3";
        questions[5][3] = "2.67";
        questions[5][4] = "1";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "exports";

        questions[7][0] = "What is the parent class of all classes in Java?";
        questions[7][1] = "Object";
        questions[7][2] = "Parent";
        questions[7][3] = "Super";
        questions[7][4] = "Root";

        questions[8][0] = "Which loop is guaranteed to execute at least once?";
        questions[8][1] = "for loop";
        questions[8][2] = "while loop";
        questions[8][3] = "do-while loop";
        questions[8][4] = "switch case";

        questions[9][0] = "What is the correct way to declare a static method in Java?";
        questions[9][1] = "static void methodName()";
        questions[9][2] = "void static methodName()";
        questions[9][3] = "methodName() static void";
        questions[9][4] = "void methodName() static";

        
        answers[0][0] = "5";
        answers[1][0] = "string";
        answers[2][0] = "final";
        answers[3][0] = "Java Virtual Machine";
        answers[4][0] = "private";
        answers[5][0] = "2";
        answers[6][0] = "import";
        answers[7][0] = "Object";
        answers[8][0] = "do-while loop";
        answers[9][0] = "static void methodName()";
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            ans_given = 1;
            recordAnswer();
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            recordAnswer();
            calculateScore();
            setVisible(false);
            new Score(name, score);
        }
    }

    private void recordAnswer() {
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
    }

    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][0])) {
                score += 10;
            }
        }
    }

    private void enableOptions() {
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        displayTimer(g);
    }

    private void displayTimer(Graphics g) {
        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
    }

    @SuppressWarnings("deprecation")
    private void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setLabel(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setLabel(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setLabel(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setLabel(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
        timer = 20; 
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
