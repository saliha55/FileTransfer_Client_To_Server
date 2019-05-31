/*Name: Saliha Mohammad Hanif Shaikh
  This is a client side code
  which sends csv file to server */


import java.io.*;
import java.net.*;

public class Client { 
    
    public static void main(String[] args) throws Exception{
        
        //Create a client socket using given ip address and port number
        Socket socket = new Socket("127.0.0.10", 3000);
        byte[] contents = new byte[10000];
        
        //create a file object by FileOutputStream
        FileOutputStream ostream = new FileOutputStream("Test.csv");
        BufferedOutputStream bostream = new BufferedOutputStream(ostream);
        InputStream is = socket.getInputStream();
        
       
        int bytesRead = 0; 
        
        while((bytesRead=is.read(contents))!=-1)
            bostream.write(contents, 0, bytesRead);  //sends file to server
        
        //close all sockets and objects
        bostream.flush(); 
        socket.close(); 
        
        System.out.println("File saved successfully!");
    }
}
