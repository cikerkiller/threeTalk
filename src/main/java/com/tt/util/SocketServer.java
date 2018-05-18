package com.tt.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	private static ServerSocket serverSocket;
	
	static {
		try {
			serverSocket=new ServerSocket(8000,3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void service(){
		while(true){
			try(Socket socket=serverSocket.accept()){
				System.out.println("new socket connect :"+socket.getInetAddress());
				InputStream inputStream=socket.getInputStream();
				int b;
				while((b=inputStream.read())!=-1){
					System.out.print((char)b);
				}
				System.out.println();
			}catch(Exception e){
				System.out.println("connect is error:"+e.getMessage());
			}
		}
	}
	
	
	public static void main(String[] args) {
		SocketServer server=new SocketServer();
		server.service();
	}
}
