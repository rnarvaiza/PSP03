package EJ01;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {
    static final String HOST = "192.168.0.12";
    static final int Puerto=2000;
    public Cliente( ) {
        Scanner sc = new Scanner(System.in);
        try{
            Socket sCliente = new Socket( HOST , Puerto );
            OutputStream outputStream = sCliente.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sCliente.getInputStream()));
            String messageIn = "";
            messageIn = in.readLine();
            System.out.println(messageIn);
            String messageOut = "";
            messageOut = sc.next();
            writer.print(messageOut);
            writer.flush();
            sCliente.close();
            writer.close();
            in.close();
        } catch( IOException e) {
            System.out.println( e.getMessage() );
        }
    }
    public static void main( String[] arg ) {
        new Cliente();
    }
}