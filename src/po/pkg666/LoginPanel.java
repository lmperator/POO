package po.pkg666;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class LoginPanel extends JPanel {
    private JTextField nameField; //POLE NA NAZWĘ
    private JPasswordField passField; //POLE NA HASŁO
    private JButton loginButton; //PRZYCISK LOGOWANIA
    private LoginListener listener; //SŁUCHACZ PRZYCISKU
  
    /**
     * @return wprowadzona nazwa użytkownika
     */ 
    @Override
    public String getName() {
        return nameField.getText();
    }
 
    /**
     * @return wprowadzone przez użytkownika hasło
     */
    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }
 
    public LoginPanel(LoginListener listener) {
        super();
        // USTAWIAMY LAYOUT
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        // TWORZYMY KOMPONENTY LOGOWANIA
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }
 
    /**
     * Metoda, która tworzy etykiety i pola do wprowadzania danych.
     */
    private void createComponents() {
        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();
 
        //POMOCNICZY PANEL DO WPROWADZANIA DANYCH
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);
        //TWORZYMY PRZYCISK LOGOWANIA
        loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(listener);
 
        //POMOCNICZY PANEL DO WYŚRODKOWANIA ELEMENTÓW
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);
 
        // DODAJEMY DO GŁÓWNEGO PANELU
        this.add(parentPanel);
    }
}