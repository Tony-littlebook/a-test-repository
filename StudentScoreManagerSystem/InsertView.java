import javax.swing.JFrame;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertView extends JFrame{
	private static final long serialVersionUID = 1L;
    InsertView(){
    	JPanel p1 = new JPanel(new GridLayout(2, 6, 20, 20));
    	JPanel p2 = new JPanel();
    	
        JLabel[] label = new JLabel[6];
        String[] string = new String[] {"name:", "id", "Chinese:", "Mathematic:", "English:", "Integrated Science:"};
        JTextField[] textField = new JTextField[6];
        for(int i = 0; i < 6; ++i) {
        	label[i] = new JLabel(string[i], Label.LEFT);
        	textField[i] = new JTextField();
        	p1.add(label[i]);
        	p1.add(textField[i]);
        }
        
        JButton buttno = new JButton("Commit");
        
        p2.add(buttno);
        
        buttno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textField[1].getText().isEmpty()) {
        			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "id can not be null!", 
        					"System Message", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		MySqlDatabase mySqlHelper = new MySqlDatabase();
        		String sql = "insert into score(name, id, Chinese, Mathematic, English, Integrated_Science, Total_Scores) "
        				+ "values(?, ?, ?, ?, ?, ?, ?)";
        		try {
        		    PreparedStatement ps = mySqlHelper.getConnection().prepareStatement(sql);
        		    ps.setString(1, textField[0].getText());
        		    ps.setString(2, textField[1].getText());
        		    ps.setInt(3, Integer.valueOf(textField[2].getText()));
        		    ps.setInt(4, Integer.valueOf(textField[3].getText()));
        		    ps.setInt(5, Integer.valueOf(textField[4].getText()));
        		    ps.setInt(6, Integer.valueOf(textField[5].getText()));
        		    int totalScores = 0;
        		    for(int i = 2; i < 6; ++i)
        		    	totalScores += Integer.valueOf(textField[i].getText());
        		    ps.setInt(7, totalScores);
        		    
        		    ps.executeUpdate();
        		    
        		    JOptionPane.showMessageDialog(new JFrame().getContentPane(), "insert operation succeed!!", 
        					"System Message",JOptionPane.INFORMATION_MESSAGE);
        		}catch (SQLException e1){
        			e1.printStackTrace();
        		}
        		
        		mySqlHelper.close();
        		
        		for(int i = 0; i < 6; ++i)
        			textField[i].setText(null);
        	}
        });
        this.setTitle("Insert");
        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(700, 300, 800, 180);
        this.setResizable(false);
        this.setVisible(true);
    }
}
