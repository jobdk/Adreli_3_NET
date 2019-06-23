package service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */


public class F7LeaveProgramImpl {
	/**
	 * {@link #programmVerlassen()} beendet den Client.
	 */
	public void programmVerlassen() {
		System.out.println("Das Programm wurde verlassen!");
		try {
			InetSocketAddress inetSocketAddress = 
					new InetSocketAddress("141.28.138.139", 56789);
			Socket client = new Socket();
			client.connect(inetSocketAddress);
			DataOutputStream dos = 
					new DataOutputStream(client.getOutputStream());
			dos.writeUTF("verlassen");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		Thread.currentThread().interrupt();
		System.exit(0);
	}
}
