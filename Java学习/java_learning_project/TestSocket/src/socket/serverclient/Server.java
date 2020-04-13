/*
* 客户端的端口地址是系统分配的
* 服务端的端口号是固定的
* */

package socket.serverclient;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]){
        try{
            //服务端打开端口8888
            ServerSocket ss =  new ServerSocket(8888);

            //在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在8888端口");
            Socket s = ss.accept();

            System.out.println("有连接过来 " + s);

            s.close();
            ss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
