package com.cs3750;

import java.net.ServerSocket;

class ServerHandler extends Thread {
	private ServerSocket server;
	
	public ServerHandler() {
		server = null;
	}
	
	public void run() {
		System.out.println("ServerHandler is running");
		try {
			server = new ServerSocket(20202);
			server.setSoTimeout(360 * 1000);
			
			while (true) {
				new Client(server.accept());
				System.out.println("accepted client");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) {
					server.close();
				}
			} catch (Exception e) {}
		}
	}
}