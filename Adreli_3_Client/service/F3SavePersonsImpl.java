package service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.ClientModel;
import model.Person;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F3SavePersonsImpl {
	private List<Person> personList;
	
	
	/**
	 * @param personList
	 */
	public F3SavePersonsImpl(List<Person> personList) {
		this.personList = personList;
	}
	
	
	/**
	 * {@link #personSichern()} sendet die Inhalte der ArrayList
	 * an den Server.
	 */
	public void personSichern() {
		try {
			//InetSocketAddress inetSocketAddress = 
			//new InetSocketAddress("141.28.143.254", 56789);
			InetSocketAddress inetSocketAddress = 
					new InetSocketAddress("141.28.138.139", 56789);
			Socket client = new Socket();
			client.connect(inetSocketAddress);
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			dos.writeUTF("savePersons");
			ObjectOutputStream oos = new ObjectOutputStream(
					client.getOutputStream());
			oos.writeObject(this.personList);
			oos.flush();
			client.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe.toString());
		}
	}
}
