package controller;

import java.util.ArrayList;

import model.ClientModel;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class StartUser {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread user = new Thread(new ControllClient(new ClientModel(
				new ArrayList<>())));
		user.start();
	}
}
