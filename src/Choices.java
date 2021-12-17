import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Choices implements ActionListener {

    JFrame frame;

    JButton register1Button = new JButton("REGISTER");
    JButton loginButton = new JButton("LOGIN");
    JButton exitButton = new JButton("EXIT");

    Choices() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Choices");
        frame.setBounds(240, 240, 510, 150);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {

        register1Button.setBounds(20, 20, 150, 50);
        loginButton.setBounds(170, 20, 150, 50);
        exitButton.setBounds(320, 20, 150, 50);

    }

    public void addComponentsToFrame() {

        frame.add(register1Button);
        frame.add(loginButton);
        frame.add(exitButton);

    }

    public void actionEvent() {

        register1Button.addActionListener(this);
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == register1Button) {
            new RegistrationGUI();
        }

        if (e.getSource() == loginButton) {
            new LoginGUI();
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }

    }
}
