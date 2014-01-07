package po.pkg666;



import java.awt.Dimension;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Frame2 extends JFrame {
    public Frame2(long time, int result, int length) {
        super("Wynik"); 
        setSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea a = new JTextArea();
        a.setText("Poprawnych znaków: " + result + "\n\n\n" + result/length + "% poprawnosci\n\n\n" + "W czasie: " + time/1000 + "s\n\n\n" + "Srednie tepo to: " + (result/(time/1000))*60 + " znakow na minute!");
        a.setEditable(false);
        
        add(a);
        setVisible(true);
    }
}
