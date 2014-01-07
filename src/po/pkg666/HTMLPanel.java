package po.pkg666;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 
public class HTMLPanel extends JPanel {
    //POLE DO WPISYWANIA KODU HTML
    private final JTextArea textArea = new JTextArea();
    //POLE Z WYGENEROWANYM KODEM
    private final JTextArea editorPane = new JTextArea();
    private Scanner odczyt = null;
    private String tmp = "";
    private long startTime = 0;
 
    public HTMLPanel() {
        super();
        setLayout(new BorderLayout());
        createPanels();
    }
 
    private void createPanels() {
        //NIE CHCEMY, ABY MOŻNA BYŁO EDYTOWAĆ WYGENEROWANY HTML
        FileReader fr = null;
        String linia = "";

   // OTWIERANIE PLIKU:
   try {
     fr = new FileReader("tekst.txt");
   } catch (FileNotFoundException e) {
       System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
       System.exit(1);
   }

   BufferedReader bfr = new BufferedReader(fr);
   // ODCZYT KOLEJNYCH LINII Z PLIKU:
   try {
        while((linia = bfr.readLine()) != null ){
            linia = linia + '\n';
            tmp = tmp + linia;
        }
    } catch (IOException e) {
        System.out.println("BŁĄD ODCZYTU Z PLIKU!");
        System.exit(2);
   }
        editorPane.setText(tmp);
        startTime = System.currentTimeMillis();
        
        editorPane.setEditable(false);
        //PRZYCISK GENEROWANIA PODGLĄDU
        JButton actionButton = new JButton("Koniec");
        actionButton.addActionListener(new ConvertListener());
        //PANEL POMOCNICZY DO ROZKŁADU ELEMENTÓW
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        textArea.setBackground(Color.lightGray);
        //DODAJEMY KOMPONENTY TEKSTOWE DO POMOCNICZEGO PANELU
        helpPanel.add(editorPane);
        helpPanel.add(textArea);
        //DODAJEMY WSZYSTKO DO GŁÓWNEGO PANELU
        this.add(helpPanel, BorderLayout.CENTER);
        this.add(actionButton, BorderLayout.SOUTH);
    }
 
    class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //ZMIANY WYGLĄDU WYWOŁUJEMY W WĄTKU DYSTRYBUCJI ZDARZEŃ
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    //  Policz wynik i podaj w nowym okienku, po czym wszystko zamknij
                    // porównaj tmp z text
                    int result = 0;
                    int length = text.length();
                    for(int i = 0; i < text.length() ; i++){
                        if(text.charAt(i) == tmp.charAt(i))
                            result++;
                    }
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    // Stwarzaj nowe okienko + usuń to stare
                    Frame2 k = new Frame2(elapsedTime,result,length);
                }
            });
        }
    }
}