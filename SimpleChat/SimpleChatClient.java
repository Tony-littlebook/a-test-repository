import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleChatClient extends JFrame{
	private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JTextField textField;
    private JButton button;
    private JPanel panel;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    
    SimpleChatClient(){
    	this.setTitle("Simple Chat Client");
    	panel = new JPanel();
    	
    	textField = new JTextField(20);
    	textField.requestFocus();
    	
    	button = new JButton("send");
    	button.addActionListener(new ButtonSendListener());
    	
    	textArea = new JTextArea();
    	textArea.setLineWrap(true);
    	textArea.setEditable(false);
    	
    	JScrollPane scrollPane = new JScrollPane(textArea);
    	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	
    	panel.add(textField);
    	panel.add(button);
    	
    	setUpNetworking();
    	Thread readerThread = new Thread(new IncomingReader());
    	readerThread.start();
    	
    	this.add(scrollPane, BorderLayout.CENTER);
    	this.add(panel, BorderLayout.SOUTH);
    	this.setBounds(800, 300, 400, 400);
    	this.setVisible(true);
    	
    }
    
    private class ButtonSendListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String text = textField.getText();
    		if(text == null) return;
    		else {
    			try {
    				writer.println(text);
    				writer.flush();
    			} catch(Exception ex) {
    				ex.printStackTrace();
    			}
    			textField.setText("");
    			textField.requestFocus();
    		}
    	}
    }
    
    private void setUpNetworking() {
    	try {
    		socket = new Socket("127.0.0.1", 5000);
    		InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
    		reader = new BufferedReader(streamReader);
    		writer = new PrintWriter(socket.getOutputStream());
    	} catch(IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    private class IncomingReader implements Runnable{
    	public void run() {
    		String message;
    		try {
    			while((message = reader.readLine()) != null) {
    				textArea.append(message + "\n");
    			}
    		} catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    
    public static void main(String[] args) {
    	SimpleChatClient myClient = new SimpleChatClient();
    	//myClient.setResizable(false);
    	
    	
    }
}
