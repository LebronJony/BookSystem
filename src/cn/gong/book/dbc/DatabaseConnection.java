package cn.gong.book.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/booksystem?useUnicode=true&characterEncoding=UTF-8";
    private static final String DBUSER = "root";
    private static final String DBPASS = "aiai1211";

    private Connection conn;
    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return this.conn;
    }
    public void close(){
        if (this.conn !=null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}











