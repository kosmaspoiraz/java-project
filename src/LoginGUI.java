import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class LoginGUI implements ActionListener {

    // create labels
    JFrame frame;

    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");

    // create fields
    JTextField usernameTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("LOGIN");
    JButton backButton = new JButton("BACK");

    // create window
    LoginGUI() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Login For Code Vault");
        frame.setBounds(240, 40, 380, 800);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        // specific location of labels
        usernameLabel.setBounds(20, 20, 100, 70);
        emailLabel.setBounds(20, 270, 100, 70);
        passwordLabel.setBounds(20, 320, 100, 70);

        // specific location of fields
        usernameTextField.setBounds(180, 43, 165, 23);
        emailTextField.setBounds(180, 293, 165, 23);
        passwordField.setBounds(180, 343, 165, 23);

        loginButton.setBounds(70, 650, 100, 35);
        backButton.setBounds(220, 650, 100, 35);

    }

    public void addComponentsToFrame() {
        frame.add(usernameLabel);
        frame.add(emailLabel);
        frame.add(passwordLabel);

        frame.add(usernameTextField);
        frame.add(emailTextField);
        frame.add(passwordField);

        frame.add(loginButton);
        frame.add(backButton);

    }

    public void actionEvent() {
        loginButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosmas", "root",
                        "AEKktg96!");
                String query = " INSERT INTO users (user_username, user_name, user_surname, user_age, user_phone, user_email, user_password, user_country, user_gender)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // PreparedStatement Pstatement = connection.prepareStatement(query);

                // Pstatement.setString(1, usernameTextField.getText());
                // Pstatement.setString(2, nameTextField.getText());
                // Pstatement.setString(3, surNameTextField.getText());
                // Pstatement.setString(4,
                // String.valueOf(Integer.parseInt(ageField.getText())));
                // Pstatement.setString(5, phoneTextField.getText());
                // Pstatement.setString(6, emailTextField.getText());
                // Pstatement.setString(7, new String(passwordField.getPassword()));
                // Pstatement.setString(8, countryTextField.getText());
                // Pstatement.setString(9, genderComboBox.getSelectedItem().toString());

                // Checking for the Password match
                // if (passwordField.getPassword() == confirmPasswordField.getPassword()
                // && Integer.parseInt(ageField.getText()) >= 18) {
                // Pstatement.executeUpdate();
                // JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                // } else {
                // if (Integer.parseInt(ageField.getText()) < 18) {
                // JOptionPane.showMessageDialog(null, "You are so young to play lottery
                // games");
                // }
                // if (!(passwordField.getPassword() == confirmPasswordField.getPassword())) {
                // JOptionPane.showMessageDialog(null, "Please check your password");
                // }
                // }

                connection.close();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if (e.getSource() == backButton) {
            // Clearing Fields
            System.exit(0);
        }

        if (e.getSource() == "") {
            new Choices();
        }
    }
}
