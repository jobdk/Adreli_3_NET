package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ClientModel;
import model.Person;
import service.F1CreateNewPersonImpl;
import service.F2ListPersonsImpl;
import service.F3SavePersonsImpl;
import service.F4DownloadPersonsImpl;
import service.F5SortPersonsInMemoryImpl;
import service.F6NumberingServiceImpl;
import service.F7LeaveProgramImpl;
/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */
public class ControllClient implements Runnable {
	private ClientModel client;
	
	
	/**
	 * @param client
	 */
	public ControllClient(ClientModel client) {
		this.client = client;
	}
	
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			this.menu();
		}
	}
	
	/**
	 * {@link #menu()} bildet die Benutzeroberfläche. Zudem werden unter
	 *  anderem die Klassen {@link F1CreateNewPersonImpl},
	 *   {@link F2ListPersonsImpl}, {@link F3SavePersonsImpl}, 
	 *   {@link F4DownloadPersonsImpl}, {@link F5SortPersonsInMemoryImpl}, 
	 *   {@link F6NumberingServiceImpl} und {@link F7LeaveProgramImpl}
	 *   aufgerufen.
	 */
	public void menu() {
		System.out.println(" ____________________________________________");
		System.out.println("|                                            |");
		System.out.println("|	   ADRELI - Adressverwaltung         |");
		System.out.println("|--------------------------------------------|");
	    System.out.println("|       Wollen Sie...                        |");
		System.out.println("|                                            |");
		System.out.println("|             Eine neue Person aufnehmen > 1 |");
		System.out.println("|                      Records auflisten > 2 |");
		System.out.println("|          Records in eine Datei sichern > 3 |");
		System.out.println("|          Records aus einer Datei laden > 4 |");
		System.out.println("|            in-memory Records sortieren > 5 |");
		System.out.println("|               Datei Zeilen nummerieren > 6 |");
		System.out.println("|                 Das Programm verlassen > 7 |");
		System.out.println("|____________________________________________|");
		System.out.println();
		try {
			Scanner sc = new Scanner(System.in);
			int auswahl = sc.nextInt();
			switch (auswahl) {
				case 1 :
					this.client.setCreateNewPersonImpl
					(new F1CreateNewPersonImpl
							(new Person(), new ArrayList<>()));
					this.client.getCreateNewPersonImpl().personAufnehmen();
					/*Person personList [] = this.client.
					 * getCreateNewPersonImpl().getPersonList().
					 * toArray(new Person[this.client.getCreateNewPersonImpl().
					 * getPersonList().size()]);
					for (Person person : personList) {
						this.client.getPersonList().add(person);
					}*/
					this.client.getPersonList().addAll(this.client.
							getCreateNewPersonImpl().getPersonList());
				break;
				case 2 :
					this.client.setListPersonsImpl(new F2ListPersonsImpl(
							this.client.getPersonList()));
					this.client.getListPersonsImpl().listPersons();
				break;
				case 3 :
					this.client.setSavePersonsImpl(new F3SavePersonsImpl(
							this.client.getPersonList()));
					this.client.getSavePersonsImpl().personSichern();
				break;
				case 4 :
					this.client.setDownloadPersonsImpl(
							new F4DownloadPersonsImpl(new ArrayList<>()));
					this.client.getDownloadPersonsImpl().personenLaden();
						for(Person person : this.client.
								getDownloadPersonsImpl().getPersonList()) {
							this.client.getPersonList().add(person);
						}
				break;
				case 5 :
					this.client.setSortPersonsInMemoryImpl(
							new F5SortPersonsInMemoryImpl(
									this.client.getPersonList()));
					this.client.getSortPersonsInMemoryImpl().
					personenSortieren();
				break;
				case 6 :
					this.client.setNumberingServiceImpl(
							new F6NumberingServiceImpl());
					this.client.getNumberingServiceImpl().numbering();
				break;
				case 7 :
					this.client.setLeaveProgramImpl(new F7LeaveProgramImpl());
					this.client.getLeaveProgramImpl().programmVerlassen();
				break;
				default : System.out.println
							("Sie haben keine Zahl von 1-7 eingegeben!");
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("Keine Zahl eingegeben!");
		}
	}
}
