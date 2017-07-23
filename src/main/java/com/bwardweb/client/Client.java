package com.bwardweb.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		int portNumber = 81;
		String hostName = "localhost";
		
		try(Socket socket = new Socket(hostName,portNumber);
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
			
			String userInput;
			while((userInput = console.readLine())!=null){
				out.println(userInput);
				System.out.println(in.readLine());
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

}
