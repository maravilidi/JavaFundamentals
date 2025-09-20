package tcpclient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    /*
    KLIJENT, slanje poruka serveru
    */
    public static void main(String[] args){
        /*pravimo OBICAN soket (ne kao i u prethodnom primeru sa TCP-om 
        gde je bio SERVER socket*/
    try(Socket on = new Socket("www.google.com", 80);
        /*CILJ je da se zahtev posalje google serveru, zato je adresa servera ta
        i port 80*/
        /*ULAZNI I IZLAZNI TOKOVI POTREBNI ZA SLANJE I PRIMANJE PORUKE*/
            BufferedReader bis = new BufferedReader(new InputStreamReader(on.getInputStream()));
            BufferedOutputStream bos = new BufferedOutputStream(on.getOutputStream());)       
    {    
        bos.write(("GET /search?q=java HTTP/1.1\r\n" +   // pretraga po kljucnoj reci java (linija iznad)
                   "Host: www.google.com\r\n" +
                   "Connection: close\r\n" +
                   "\r\n").getBytes());
        //pretraga po kljucnoj reci java (linija iznad)
        bos.flush();
        
      
        // logika za citanje odgovora ispod
        String line = bis.readLine();
        while(line != null) 
        {
            System.out.println(line);
            line = bis.readLine();
        }
    }
    catch (IOException ex) {
        System.out.println("Error " + ex.getMessage());
    }
    }
    
}
