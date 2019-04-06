import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox; 
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DeleteView extends JFrame{
	private static final long serialVersionUID = 1L;
    private JLabel label;
    private JButton button;
    private JTextField textField;
    private JCheckBox checkBox;
    DeleteView(){
    	label = new JLabel("id:");
    	label.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	button = new JButton("commit");
    	button.addActionListener(new ButtonListener());
    	
    	textField  = new JTextField();
    	
    	checkBox = new JCheckBox("by name");
    	checkBox.addChangeListener(new checkListener());
    	
    	JPanel p1 = new JPanel();
    	p1.add(checkBox);
    	
    	JPanel p2 = new JPanel(new GridLayout(1, 2));
    	p2.add(label);
    	p2.add(textField );
    	
    	JPanel p3 = new JPanel();
    	p3.add(button);
    	
    	this.add(p1, BorderLayout.NORTH);
    	this.add(p2, BorderLayout.CENTER);
    	this.add(p3, BorderLayout.SOUTH);
    	this.setTitle("Delete");
    	this.setBounds(600, 400, 250, 150);
    	this.setVisible(true);
    	this.setResizable(false);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private class ButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String text = textField .getText();
    		if(text.isEmpty()) {
    			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "text can not be null!", 
    					"System Message", JOptionPane.WARNING_MESSAGE);
    			return;
    		}
    		MySqlDatabase mySqlHelper = new MySqlDatabase();
    		String sql;
    		PreparedStatement ps;
    		try {
    			if(label.getText() == "id:") {
    				sql = "delete from score where id = ?";
    				ps = mySqlHelper.getConnection().prepareStatement(sql);
    			    ps.setInt(1, Integer.valueOf(text));
    			}
    			else {
    				sql = "delete from score where name = ?";
    				ps = mySqlHelper.getConnection().prepareStatement(sql);
    				ps.setString(1, text.trim());
    			}
    			ps.executeUpdate();
    		    
    		    JOptionPane.showMessageDialog(new JFrame().getContentPane(), "delete operation succeed!!", 
    					"System Message",JOptionPane.INFORMATION_MESSAGE);
    		    
    		}catch(SQLException se) {
    			se.printStackTrace();
    		}
    		textField .setText(null);
    	}
    	
    }
    
    private class checkListener implements ChangeListener{
    	public void stateChanged(ChangeEvent e) {
    		if(checkBox.isSelected())
    			label.setText("name:");
    		else
    			label.setText("id:");
    	}
    }
}
