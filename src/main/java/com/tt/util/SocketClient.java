package com.tt.util;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		try(Socket socket=new Socket("47.106.123.29", 8080)){
			socket.setKeepAlive(true);
			OutputStream outputStream= socket.getOutputStream();
			outputStream.write(new String("hello world").getBytes("utf-8"));
			outputStream.flush();
		}catch(Exception e){
			System.out.println("socketClient connect error"+e.getMessage());
		}
	}
	

	
}
