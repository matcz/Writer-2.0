 import java.io.*;
 
public class Soubory implements Serializable
{
    public static void save(String [] [] d)
    {
        try
        {
            File a = new File("test.wrt");
            FileOutputStream b = new FileOutputStream(a);
            ObjectOutputStream c = new ObjectOutputStream(b);
            Object e = new Object();
            e = (Object)d;
            c.writeObject(e);
            c.close();
        }
        catch(IOException e){}
    }
    public static String [] [] load()
    {
        String [] [] d = new String [0] [0];
        try
        {
            try
            {    
                try
                {
                    File a = new File("test.wrt");
                    FileInputStream b = new FileInputStream(a);
                    ObjectInputStream c = new ObjectInputStream(b);
                    d = (String [] [])c.readObject();
                    c.close();
                }
                catch(ClassNotFoundException e){}
            }
            catch(WriteAbortedException e){}
        }
        catch(IOException e){}
        return d;
    }
}
