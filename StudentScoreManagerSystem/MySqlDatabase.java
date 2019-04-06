import java.sql.*;
public class MySqlDatabase {
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentsystem?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "666666";
    
    private Connection conn = null;
    private Statement stmt = null;
    
    MySqlDatabase(){
    	try {
    		// 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
           //System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
    	}catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
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
