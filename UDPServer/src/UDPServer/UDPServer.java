package UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPServer {

    public static void main(String[] args) {
        //USER DATAGARAM PROTOCOL, nije sigurno gde ce poruka zavrsiti
        
        try(DatagramSocket dServer = new DatagramSocket(5000);)
        {
            //za skladistenje poruka koristi se byte ali nije prepor da bude vise od 512b
            byte[] buff = new byte[128];
            DatagramPacket p = new DatagramPacket(buff, buff.length);
            //Parametri u konstruktoru buff-lokacija, a buff.length-duzina skladista
            //sledeca linija-SLUSANJE
            dServer.receive(p);
                //CUTANJE
            String message = new String(p.getData(), 0, p.getLength());
            //u konstruktoru 1.pristigla poruka koja je u sus niz bajtova i navodi se 2.pocetna 
            //pozicija odakle se cita i 3.ukupnu duzinu niza
            System.out.println(message);
            
        } catch (SocketException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
        	Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
