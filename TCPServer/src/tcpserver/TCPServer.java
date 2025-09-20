package tcpserver;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpserver {
    public static void main(String[] args) {
        //SERVER APLIKACIJA
        //Server socket      
        try (ServerSocket sServer = new ServerSocket(5000);
            //1000 u zagradi je broj porta
             Socket on = sServer.accept();
            /*metoda accept vraca objekat tipa Socket
            to je klijentski socket i sluzi da bi se 
            procitao unos korisnika*/
                BufferedReader bis = new BufferedReader(new InputStreamReader(on.getInputStream()));         
                //sledeca linija sluzi da server vrati neku poruku klijentu
                BufferedOutputStream bos = new BufferedOutputStream(on.getOutputStream());)
        {
           //Citanje klijent-poruke se vrsi pomocu
           String line = bis.readLine();          
           while(line != null && !line.equals(""))
           {
               System.out.println(line);
               line = bis.readLine();
           }
           //Citanje server-poruke
           bos.write("Hello from java TCP server:".getBytes());
        } catch (IOException ex) {
            System.out.println("Error in connection: " + ex.getMessage());
        }
    }
    
}

