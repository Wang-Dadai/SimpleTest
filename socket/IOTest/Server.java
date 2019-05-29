package IOTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	
	public static void main(String[] args) {
		try {
			System.out.println("Server start at "+new Date());
			ServerSocket serverSocket = new ServerSocket(8001);
			Socket socket = serverSocket.accept();
			new Thread(new receiver(socket)).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class receiver implements Runnable{

		private Socket socket;
		
		public receiver(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
			DataInputStream inputFormClient = new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
			while(true){
				double radius = inputFormClient.readDouble();
				double area = radius*radius*Math.PI;
				System.out.println("Radius received from client:"+radius);
				System.out.println("local port: " + socket.getLocalPort());
				System.out.println("the area is :"+area);
				outputToClient.writeDouble(area);
				
			}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
}
