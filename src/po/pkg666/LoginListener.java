package po.pkg666;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 
public class LoginListener implements ActionListener {
    //GŁÓWNA RAMKA PROGRAMU
    private final JFrame frame;
    //PANEL LOGOWANIA, POTRZEBNY DO POBRANIA LOGINU I HASŁA
    private LoginPanel loginPanel;
 
    public void setPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
 
    public LoginListener(JFrame frame) {
        this.frame = frame;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if (UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // PANEL Z EDYTOREM HTML
                    JPanel htmlPanel = new HTMLPanel();
                    // USUWAMY PANEL LOGOWANIA
                    frame.getContentPane().removeAll();
                    // DODAJEMY PANEL HTML I ODŚWIEŻAMY WIDOK
                    frame.add(htmlPanel);
                    frame.validate();
                }
            });
        }
    }
}