package udp_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDP_Client {
    public static void main(String[] args) {
try(DatagramSocket dClient = new DatagramSocket();)
    {
        //kreira se buffer za poruku i pretvara String u niz bajtova
        byte[] message = new byte[128];
        message = "Hello from UDP client".getBytes();
        InetSocketAddress ep = new InetSocketAddress("127.0.0.1", 1000);
        DatagramPacket p = new DatagramPacket(message, message.length, ep);
        dClient.send(p);    
    }
    catch(SocketException ex) 
    {
            System.out.println("Error" + ex.getMessage());
    }   catch (IOException ex) {
            Logger.getLogger(UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
