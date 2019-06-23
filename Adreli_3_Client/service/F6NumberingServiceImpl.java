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

public class F6NumberingServiceImpl {
	/**
	 * {@link #numbering()} schickt dem Server die Aufforderung
	 *  die Datensätze in der "adreli.csv" Datei zu nummerieren.
	 */
	public void numbering() {
		try {
			InetSocketAddress inetSocketAdress = 
					new InetSocketAddress("localhost", 56789);
			Socket client = new Socket();
			client.connect(inetSocketAdress);
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			dos.writeUTF("nummerieren");
			client.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
