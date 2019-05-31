/*Name: Saliha Mohammad Hanif Shaikh
  This is Server side code.
  Ref. Link= http://www.codebytes.in/2014/11/file-transfer-using-tcp-java.html
 */

import java.io.*;
import java.net.*;

public class Server { 
    
    public static void main(String[] args) throws Exception {
    
        //server socket created on port 3000.    
        ServerSocket servSock = new ServerSocket(3000);
        
        //server connect to client socekt
        Socket socket = servSock.accept();
        
        //read file name
        File file = new File("EmployeeData.csv");
        FileInputStream istream = new FileInputStream(file);
        BufferedInputStream bistream = new BufferedInputStream(istream); 
          
        
        OutputStream ostream = socket.getOutputStream();
                
        //read file data
        byte[] contents;
        long fileLength = file.length(); 
        long current = 0;
         
        long start = System.nanoTime();
        while(current!=fileLength){ 
            int size = 10000;
            if(fileLength - current >= size)
                current += size;    
            else{ 
                size = (int)(fileLength - current); 
                current = fileLength;
            } 
            contents = new byte[size]; 
            bistream.read(contents, 0, size); 
            ostream.write(contents);
            System.out.print("File Transfer Complete...");
        }   
        
        ostream.flush(); 
        //close socket connection
        socket.close();
        servSock.close();
        System.out.println("File Sent Succesfully!!!!!");
    }
}
