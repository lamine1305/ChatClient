package com.company;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)  {

        try {
                Socket s = new Socket("localhost", 1234);
                System.out.println("Veuillez vous identifier ");

                InputStream in = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bfr= new BufferedReader(isr);

                OutputStream out = s.getOutputStream();
                PrintWriter pw=new PrintWriter(out,true);

                Scanner sc = new Scanner(System.in);
                String nom = sc.next();
                System.out.println("je m'apelle "+nom +" ********");
                pw.println(nom);
                String retour=bfr.readLine();
                System.out.println("le retour serveur  " + retour);
                System.out.println("DEBUT DE LA CONVERSATION AVEC LE SERVEUR . . .");
                while (true)
               {
                   String receiveMessage =bfr.readLine();
                   System.out.println("Le serveur dit :"+receiveMessage);
                   System.out.println("le client dit ");
                   String sendMessage =sc.next();
                   pw.println(sendMessage);
              }
            }
        catch (IOException e)
        {
        e.printStackTrace();
        }

    }
}
