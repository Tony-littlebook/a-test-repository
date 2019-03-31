package test;

import java.sql.*;

public class mysqldemo {
 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "666666";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            /*
            //插入操作
            sql = "INSERT INTO dept(deptno, dname, loc) VALUES(50, 'MANAGER', 'BEIJING')";
            stmt.executeUpdate(sql);
            System.out.println("插入操作成功！");
            //删除操作
            sql ="DELETE FROM dept WHERE deptno = 50";
            int res =  stmt.executeUpdate(sql);
            if(res == 1)
            	System.out.println("删除操作成功！");
            else
            	System.out.println("删除操作失败！");
            //更新操作
            sql = "UPDATE dept SET dname = 'MANAGER' WHERE deptno = 20";
            stmt.executeUpdate(sql);
            sql = "UPDATE dept SET dname = 'RESEARCHING' WHERE deptno = 25";
            stmt.executeUpdate(sql);
            sql = "UPDATE dept SET deptno = 20 WHERE deptno = 25";
            stmt.executeUpdate(sql);
            System.out.println("更新操作成功！");
            */
            //数据库查询语句
            sql = "SELECT deptno, dname, loc FROM dept";
            ResultSet rs = stmt.executeQuery(sql);  
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
    
                // 输出数据
                System.out.print("deptno: " + deptno);
                System.out.print(", dname: " + dname);
                System.out.print(", loc: " + loc);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
