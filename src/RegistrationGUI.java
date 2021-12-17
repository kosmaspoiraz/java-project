import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationGUI implements ActionListener {

    // create labels
    JFrame frame;
    String[] gender = { "None", "Male", "Female", "Other" };

    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel nameLabel = new JLabel("NAME");
    JLabel surNameLabel = new JLabel("SURNAME");
    JLabel ageLabel = new JLabel("AGE");
    JLabel phoneLabel = new JLabel("PHONE");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
    JLabel countryLabel = new JLabel("COUNTRY");
    JLabel genderLabel = new JLabel("GENDER");

    // create fields
    JTextField usernameTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField surNameTextField = new JTextField();
    JTextField ageField = new JTextField();
    JTextField phoneTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField countryTextField = new JTextField();
    JComboBox<String> genderComboBox = new JComboBox<>(gender);

    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");

    // create window
    RegistrationGUI() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Registration For Code Vault");
        frame.setBounds(240, 40, 380, 800);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        // specific location of labels
        usernameLabel.setBounds(20, 20, 100, 70);
        nameLabel.setBounds(20, 70, 100, 70);
        surNameLabel.setBounds(20, 120, 100, 70);
        ageLabel.setBounds(20, 170, 100, 70);
        phoneLabel.setBounds(20, 220, 100, 70);
        emailLabel.setBounds(20, 270, 100, 70);
        passwordLabel.setBounds(20, 320, 100, 70);
        confirmPasswordLabel.setBounds(20, 370, 140, 70);
        countryLabel.setBounds(20, 420, 100, 70);
        genderLabel.setBounds(20, 470, 100, 70);

        // specific location of fields
        usernameTextField.setBounds(180, 43, 165, 23);
        nameTextField.setBounds(180, 93, 165, 23);
        surNameTextField.setBounds(180, 143, 165, 23);
        ageField.setBounds(180, 193, 165, 23);
        phoneTextField.setBounds(180, 243, 165, 23);
        emailTextField.setBounds(180, 293, 165, 23);
        passwordField.setBounds(180, 343, 165, 23);
        confirmPasswordField.setBounds(180, 393, 165, 23);
        countryTextField.setBounds(180, 443, 165, 23);
        genderComboBox.setBounds(180, 493, 155, 23);

        registerButton.setBounds(70, 650, 100, 35);
        resetButton.setBounds(220, 650, 100, 35);

    }

    public void addComponentsToFrame() {
        frame.add(usernameLabel);
        frame.add(nameLabel);
        frame.add(surNameLabel);
        frame.add(ageLabel);
        frame.add(phoneLabel);
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(countryLabel);
        frame.add(genderLabel);

        frame.add(usernameTextField);
        frame.add(nameTextField);
        frame.add(surNameTextField);
        frame.add(ageField);
        frame.add(phoneTextField);
        frame.add(emailTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(countryTextField);
        frame.add(genderComboBox);

        frame.add(registerButton);
        frame.add(resetButton);

    }

    public void actionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosmas", "root",
                        "AEKktg96!");
                String query = " INSERT INTO users (user_username, user_name, user_surname, user_age, user_phone, user_email, user_password, user_country, user_gender)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement Pstatement = connection.prepareStatement(query);

                Pstatement.setString(1, usernameTextField.getText());
                Pstatement.setString(2, nameTextField.getText());
                Pstatement.setString(3, surNameTextField.getText());
                Pstatement.setString(4, String.valueOf(Integer.parseInt(ageField.getText())));
                Pstatement.setString(5, phoneTextField.getText());
                Pstatement.setString(6, emailTextField.getText());
                Pstatement.setString(7, new String(passwordField.getPassword()));
                Pstatement.setString(8, countryTextField.getText());
                Pstatement.setString(9, genderComboBox.getSelectedItem().toString());

                // Checking for the Password match
                if (passwordField.getPassword() == confirmPasswordField.getPassword()
                        && Integer.parseInt(ageField.getText()) >= 18) {
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                } else {
                    if (Integer.parseInt(ageField.getText()) < 18) {
                        JOptionPane.showMessageDialog(null, "You are so young to play lottery games");
                    }
                    if (!(passwordField.getPassword() == confirmPasswordField.getPassword())) {
                        JOptionPane.showMessageDialog(null, "Please check your password");
                    }
                }

                connection.close();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if (e.getSource() == resetButton) {
            // Clearing Fields
            nameTextField.setText("");
            surNameTextField.setText("");
            ageField.setText("");
            nameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            countryTextField.setText("");
            genderComboBox.setSelectedItem("None");
        }

        if (e.getSource() == "") {
            new Choices();
        }
    }
}
