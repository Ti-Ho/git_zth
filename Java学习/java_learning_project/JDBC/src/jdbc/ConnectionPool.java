package jdbc;
//ConnectionPool
import java.util.*;
import java.sql.*;

public class ConnectionPool {
    List<Connection> conns = new ArrayList<>();
    int size;
    public ConnectionPool(){
        size = 5;
        init();
    }
    public ConnectionPool(int size){
        this.size = size;
        init();
    }
    public void init(){
        try{ //这里不能使用try-with-resource的方式,因为这些连接都需要是“活”的,不要被自动关闭了.
            Class.forName("com.mysql.jdbc.Driver");
            for(int i = 0; i < size; ++ i){
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","");
                conns.add(conn);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public synchronized Connection getConnection(){
        while(conns.isEmpty()){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Connection conn = conns.remove(0);
        return conn;
    }
    public synchronized void returnConnection(Connection c){
        conns.add(c);
        this.notifyAll();
    }
}