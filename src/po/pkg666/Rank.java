package po.pkg666;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Artur
 */
public class Rank {
    public void zapisz(Result res, String file) throws IOException{
        FileOutputStream fos = new FileOutputStream( file );
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(res);
    }
    public Result odczytaj(String file) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream( file ));
        if( ois.available() > 0 ){
            return (Result)ois.readObject();
        }
        else{
           System.out.println("badsanfoaoaf");
           return new Result(); 
        }
    }
}
