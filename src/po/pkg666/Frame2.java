package po.pkg666;



import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Frame2 extends JFrame {
    public Frame2(long time, int result, int length) throws FileNotFoundException, ClassNotFoundException, IOException {
        super("Wynik"); 
        setSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea a = new JTextArea();
        
        Rank plik = new Rank();
        Result rekord = plik.odczytaj("best.txt");
        boolean pobiles = false;
        if( result > rekord.points  )
            pobiles = true;
        else if( result == rekord.points && time < rekord.time )
            pobiles = true;
        
        String napis = "Nie pobiles rekordu :(";
        if( pobiles )
            napis = "Pobiles rekord!";
        
        a.setText("Poprawnych znaków: " + result + "\n\n\n" + (result*100)/length + 
                "% poprawnosci\n\n\n" + "W czasie: " + time/1000 + "s\n\n\n" + 
                "Srednie tepo to: " + (result/(time/1000))*60 + " znakow na minute!\n\n\n"
                + "Dotychczasowy rekord to: " + rekord.points + " w " + rekord.time/1000 + "s\n\n\n"
                + napis
        );
        a.setEditable(false);
        if( pobiles ){
            rekord.points = result;
            rekord.time = time;
        }
        System.out.println(rekord.points + " " + rekord.time + " " + length);
        plik.zapisz(rekord, "best.txt");
        
        add(a);
        setVisible(true);
    }
}