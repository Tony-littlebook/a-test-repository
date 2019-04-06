import java.sql.*;
public class MySqlDatabase {
	// JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentsystem?useSSL=false&serverTimezone=UTC";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "666666";
    
    private Connection conn = null;
    private Statement stmt = null;
    
    MySqlDatabase(){
    	try {
    		// ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
           //System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
    	}catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }
    }
    
    public Statement getStatement() {
    	return stmt;
    }
    
    public Connection getConnection(){
    	return conn;
    }
    
    public boolean close() {
    	try{
            if(stmt!=null) stmt.close();
        }catch(SQLException se2){
        	se2.printStackTrace();
        	return false;
        }
        try{
            if(conn!=null) conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
}
