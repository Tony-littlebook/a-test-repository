import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWidget extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton[] buttno;
	private JPanel p;
    MainWidget(){
    	this.setTitle("Student Socer Manager System");
    	
    	p = new JPanel(new GridLayout(2, 3, 20, 20));
   
    	
    	String[] string = new String[]{"insert", "delete", "query", "update", "browse", "exit"};
    	buttno = new JButton[6];
    	for(int i = 0; i < 6; ++i) {
    		buttno[i] = new JButton(string[i]);
    		buttno[i].addActionListener(this);
    		p.add(buttno[i]);
    	}
    	
    	this.add(p, BorderLayout.CENTER);
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setBounds(600, 300, 600, 150);
    	this.setResizable(false);
    	//this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
    	String label = e.getActionCommand();
    	if(label.equals("insert"))
    		new InsertView();
    	else if(label.equals("delete"))
    		new DeleteView();
    	else if(label.equals("query"))
    		new QueryView();
    	else if(label.equals("update"))
    		new UpdateView();
    	else if(label.equals("browse"))
    		new BrowseView();
    	else
    		System.exit(0);
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MainWidget myWidget = new MainWidget();
    	myWidget.setVisible(true);
    }
}
