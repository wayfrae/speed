package com.cs3750;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread {
	private BufferedReader in;
	private BufferedWriter out;
	private Socket socket;
	
	public Client(Socket socket) {
		in = null;
		out = null;
		this.socket = socket;
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				if (in.ready()) {
					String line = in.readLine();
					System.out.println(line);
					out.write("From server: " + line);
					out.newLine();
					out.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				
				if (out != null) {
					out.close();
				}
				
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {}
			
			interrupt();
		}
	}
}
