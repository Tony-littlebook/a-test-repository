import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer {
    ArrayList<PrintWriter> clientOutputStreams;
    
    private class ClientHander implements Runnable{
    	BufferedReader reader;
    	Socket socket;
    	
    	public ClientHander(Socket clientSocket) {
    		try {
    			socket = clientSocket;
    			InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
    			reader = new BufferedReader(isReader);
    		} catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    	
    	public void run() {
    		String message;
    		try {
    			while((message = reader.readLine()) != null) {
    				System.out.println(message);
    				Iterator<PrintWriter> it = clientOutputStreams.iterator();
    				while(it.hasNext()) {
    					PrintWriter writer = (PrintWriter) it.next();
    					writer.println(message);
    					writer.flush();
    				}
    			}
    		} catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    
    public void go() {
    	clientOutputStreams = new ArrayList<PrintWriter>();
    	
    	try {
    		ServerSocket serverSocket = new ServerSocket(5000);
    		
    		while(true) {
    			Socket clientSocket = serverSocket.accept();
    			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
    			clientOutputStreams.add(writer);
    			
    			Thread thread = new Thread(new ClientHander(clientSocket));
    			thread.start();
    			
    			System.out.println("got a connection");
    		}
    	}catch(Exception ex) {
			ex.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	SimpleChatServer myServer= new SimpleChatServer();
    	myServer.go();
    }
}
