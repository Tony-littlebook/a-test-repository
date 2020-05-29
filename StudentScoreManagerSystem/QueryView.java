import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.*;
public class QueryView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel numLabel;
	private JLabel nameLabel;
	private JLabel radioLabel;
	private JLabel[] label;
	private JButton queryButton;
	private JRadioButton[] radioButton;
	private ButtonGroup sampleRadio;
	
	private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    QueryView(){
    	numLabel = new JLabel();
    	numLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	queryButton = new JButton("Query");
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        radioLabel = new JLabel("highest score");
        radioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        label = new JLabel[7];
        radioButton = new JRadioButton[5];
        String[] s1 = new String[] {"Chinese", "Mathematic", "English", "Integrated Science", "Total Score"};
        for(int i = 0; i < 5; ++i) {
            label[i] = new JLabel();
        	label[i].setHorizontalAlignment(SwingConstants.CENTER);
        	radioButton[i] = new JRadioButton(s1[i]);
        }
        sampleRadio = new ButtonGroup();
        queryButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		MySqlDatabase mySqlHelper = new MySqlDatabase();
        		String[] sql = new String[5];//注意此处不可使用preparedstatement；
        		sql[0] = "select * from score order by Chinese desc limit 1";
        		sql[1] = "select * from score order by Mathematic desc limit 1";
        		sql[2] = "select * from score order by English desc limit 1";
        		sql[3] = "select * from score order by Integrated_Science desc limit 1";
        		sql[4] = "select * from score order by Total_Scores desc limit 1";
        	    try {
        	    	 Statement stmt = mySqlHelper.getStatement();
        		     boolean isSelected = false;
        		     for(int i = 0; i < 5; i++) {
        		    	 if(radioButton[i].isSelected()) {
        		    		 isSelected = true;
        		    		 ResultSet rs = stmt.executeQuery(sql[i]);
        		    		 while(rs.next()) {
        		    		 numLabel.setText("id " + rs.getString("id"));
        		    		 nameLabel.setText("name  " + rs.getString("name"));
             			     label[0].setText("Chinese " + rs.getString("Chinese"));
             			     label[1].setText("Mathematic " + rs.getString("Mathematic"));
             			     label[2].setText("English " + rs.getString("English"));
             			     label[3].setText("Integrated Science " + rs.getString("Integrated_Science"));
             			     label[4].setText("Total Score " + rs.getString("Total_Scores"));
        		    		 }
        		    	 }
        		     }
        		     if(!isSelected) {
        		    	 JOptionPane.showMessageDialog(new JFrame().getContentPane(), "Please select a radio button!", 
             					"System Message", JOptionPane.WARNING_MESSAGE);
             			return;
        		     }
        	    }catch(SQLException se) {
        		     se.printStackTrace();
        	    }
        	    mySqlHelper.close();
        	}
        });
        panel1 = new JPanel(new GridLayout(1,6));
        panel2 = new JPanel(new GridLayout(1,7));
        panel2.add(numLabel);
        panel2.add(nameLabel);
        for(int i = 0; i < 5; ++i) {
            sampleRadio.add(radioButton[i]);
        	panel1.add(radioButton[i]);
        	panel2.add(label[i]);

        }
        panel1.add(radioLabel);
        panel3 = new JPanel();
        panel3.add(queryButton);
        
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3,BorderLayout.SOUTH);
        
        this.setTitle("Query");
        this.setBounds(600, 300, 1000, 280);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        

    }

}
