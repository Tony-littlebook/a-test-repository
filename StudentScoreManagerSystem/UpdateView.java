import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.*;
public class UpdateView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel numLabel;
    private JTextField queryText;
    private JButton queryButton;
    private JLabel nameLabel, name;
    private JLabel[] label;
    private JTextField[] textField;
    private JButton commitButton;
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    UpdateView(){
    	numLabel = new JLabel("学号：");
    	numLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	queryText = new JTextField();
    	queryButton = new JButton("确认");
        nameLabel = new JLabel("姓名：");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        name = new JLabel();
        label = new JLabel[4];
        textField = new JTextField[4];
        String[] s = new String[] {"Chinese:", "Mathematic:", "English:", "Integrated Science:"};
        for(int i = 0; i < 4; ++i) {
        	label[i] = new JLabel(s[i]);
        	label[i].setHorizontalAlignment(SwingConstants.CENTER);
        	textField[i] = new JTextField();
        }
        commitButton = new JButton("commit update");
        
        queryButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String text = queryText.getText();
        		if(text.isEmpty()) {
        			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "invalid query!", 
        					"System Message", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		MySqlDatabase mySqlHelper = new MySqlDatabase();
        		Statement stmt = mySqlHelper.getStatement();
        		String sql = "select name, Chinese, Mathematic, English, "
        				+ "Integrated_Science from score where id = "+Integer.valueOf(text);
        		try {
        			ResultSet rs = stmt.executeQuery(sql);
        			if(!rs.next()) {
        				JOptionPane.showMessageDialog(new JFrame().getContentPane(), "this id doesn't exist!", 
            					"System Message",JOptionPane.INFORMATION_MESSAGE);
        				setNull();
        			}
        			while(rs.next()){
        			    name.setText(rs.getString("name"));
        			    textField[0].setText(rs.getString("Chinese"));
        			    textField[1].setText(rs.getString("Mathematic"));
        			    textField[2].setText(rs.getString("English"));
        			    textField[3].setText(rs.getString("Integrated_Science"));
        			}
        			
        		}catch(SQLException se) {
        			se.printStackTrace();
        	    }
        		mySqlHelper.close();
        	}
        });
        
        commitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String text = queryText.getText();
        		if(text.isEmpty()) {
        			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "invalid query!", 
        					"System Message", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		MySqlDatabase mySqlHelper = new MySqlDatabase();
        		String sql = "update score set Chinese = ?, Mathematic = ?, English = ?,"
        				+ " Integrated_Science = ?, Total_Scores = ? where id = "+Integer.valueOf(text);
        		try {
        			PreparedStatement ps = mySqlHelper.getConnection().prepareStatement(sql);
        			ps.setInt(1, Integer.valueOf(textField[0].getText()));
        		    ps.setInt(2, Integer.valueOf(textField[1].getText()));
        		    ps.setInt(3, Integer.valueOf(textField[2].getText()));
        		    ps.setInt(4, Integer.valueOf(textField[3].getText()));
        		    int totalScores = 0;
        		    for(int i = 0; i < 4; ++i)
        		    	totalScores += Integer.valueOf(textField[i].getText());
        	        ps.setInt(5, totalScores);
        	        
        	        ps.executeUpdate();
        	        
        	        JOptionPane.showMessageDialog(new JFrame().getContentPane(), "update operation succeed!!", 
        					"System Message",JOptionPane.INFORMATION_MESSAGE);
        		}catch(SQLException se) {
        			se.printStackTrace();
        		}
        		mySqlHelper.close();
        		
        		setNull();
        		
        	}
        });
        
        panel1 = new JPanel(new GridLayout(1,5));
        panel1.add(numLabel);
        panel1.add(queryText);
        panel1.add(queryButton);
        panel1.add(nameLabel);
        panel1.add(name);
        
        panel2 = new JPanel(new GridLayout(4,2));
        
        for(int i = 0; i < 4; ++i) {
        	panel2.add(label[i]);
        	panel2.add(textField[i]);
        }
        
        panel3 = new JPanel();
        panel3.add(commitButton);
        
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3,BorderLayout.SOUTH);
        
        this.setTitle("Update");
        this.setBounds(600, 300, 600, 280);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void setNull() {
    	queryText.setText(null);
		name.setText(null);
		for(int i = 0; i < 4; ++i)
			textField[i].setText(null);
    }
    
}
