package Activité;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread {
  private int nbclient;
  private static final int PORT=600;
  
  public static void main(String[] args) {
	  new ServerMT().start();
  }
  public void run()  {
	  try {
		  System.out.println("demarrage su server");
		   ServerSocket ss =new ServerSocket(PORT);
		   while(true) {
			   Socket s = ss.accept();
			   Clientprocess p = new Clientprocess(s,++nbclient);
			   System.out.println("le client num"+nbclient+"est connecté");
			   
			   new PrintWriter(s.getOutputStream(),true).println("Bienvenu "+nbclient);
			   
		   }
	  }catch (Exception e) {
		e.printStackTrace();
	}
  }

}
