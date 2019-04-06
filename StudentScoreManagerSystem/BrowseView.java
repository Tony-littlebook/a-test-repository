import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

public class BrowseView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
    private JTable table;
    private Vector<String> column;
	private Vector<Vector<String>> row = null;
	BrowseView(){
		row = new Vector<Vector<String>>();
		column = new Vector<String>();
	    String[] string = new String[]{"name", "id", "Chinese", "Mathematic",
	    		            "English", "Integrated Science", "Total Scores"};
	    for(int i = 0; i < 7; ++i)
	    	column.add(string[i]);
	    MySqlDatabase mySqlHelper = new MySqlDatabase();
	    Statement stmt = mySqlHelper.getStatement();
	    String sql = "select * from score order by id";
	    try {
	        ResultSet rs = stmt.executeQuery(sql);  
            while(rs.next()){
        	    Vector<String> hang = new Vector<String>();
                hang.add(rs.getString("name"));
                hang.add(rs.getString("id"));
                hang.add(rs.getString("Chinese"));
                hang.add(rs.getString("Mathematic"));
                hang.add(rs.getString("English"));
                hang.add(rs.getString("Integrated_Science"));
                hang.add(rs.getString("Total_Scores"));
                row.add(hang);
           }
           mySqlHelper.close();
           table = new JTable(row, column);
   		   scrollPane = new JScrollPane(table);
   		   this.add(scrollPane);
   		   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   		   this.setBounds(500, 300, 850, 600);
   		   this.setVisible(true);
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}
}
