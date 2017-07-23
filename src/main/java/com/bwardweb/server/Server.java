package com.bwardweb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		int portNumber = 81;
		System.out.println("Server starting");
		
		try(
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
			
			String inputLine, outputLine;
			
			/*while(true){
				int numLines=getNumLines(in);
				
				if(numLines > 0){
					outputLine = "HTTP/1.0 200 OK";
					out.println(outputLine);
					outputLine="Content-type: text/html";
					out.println(outputLine);
					outputLine="<H1>Success!</H1>";
					out.println(outputLine);
					out.println("");
				}
				flushReader(in);
				numLines = 0;
			}*/
			
			while((inputLine = in.readLine()) !=null){
				outputLine = "HTTP/1.0 200 OK";
				out.println(outputLine);
				outputLine="Content-type: text/html";
				out.println(outputLine);
				out.println("");
				outputLine="<H1>Success!</H1>";
				out.println(outputLine);
				out.println("");
				
				if(inputLine .equals("quit")){
					break;
				}
				clientSocket.close();
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Server exiting");

	}
	
	private static int getNumLines(BufferedReader in) throws IOException{
		int count =0;
		while(in.readLine() !=null){
			count++;
		}
		return count;
	}
	
	public static void flushReader(BufferedReader in) throws IOException{
		while(in.readLine()!=null){			
		}
	}
}
