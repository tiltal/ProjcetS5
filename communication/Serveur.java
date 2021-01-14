package communication;

import java.io.*;
import java.net.*;

import donneesDynamique.University;

public class Serveur implements Runnable{
   private static final int PORT = 8952;
   Socket socket;
   ServerSocket server;
   private Receptor recep;
    
   public Serveur(){
       this.recep = new Receptor();
      try {
    server = new ServerSocket(PORT);
      } catch (IOException e) {
    e.printStackTrace();
      }
   }
    
   public void run() {
      try{
    while(!server.isClosed()){
       socket = server.accept();
       Thread t = new Thread(new Runnable() {
          @Override
              public void run() {
        try{
           BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           boolean socketOuvert = true;
           while (socketOuvert) {
              try{
             String input = plec.readLine();
             if(input != null){            
            	 recep.transmettre(input);
             }
              }catch(SocketException se){                        socketOuvert=false;
              }
           }
        socket.close();
        } catch (IOException e) {e.printStackTrace();}            }
     });
     t.start();
   }
}catch (IOException e){e.printStackTrace();}
}
    

}
