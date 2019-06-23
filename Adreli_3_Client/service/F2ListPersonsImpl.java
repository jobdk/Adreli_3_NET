package service;

import java.util.List;
import java.util.Scanner;

import model.Person;
/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F2ListPersonsImpl {
	private List<Person> personList;
	
	/**
	 * @param personList
	 */
	public F2ListPersonsImpl(List<Person> personList) {
		this.personList = personList;
	}

	
	public void listPersons() {
		int anzahl = this.personList.size();
		for (Person person : this.personList) {
			this.listPersonView(person);
			Scanner scanner = new Scanner(System.in);
			if (anzahl > 1) {
				System.out.println("Es gibt noch "+(--anzahl)+" Datensätze.");
				System.out.println("Weiter mit \"Enter\"");
				String eingabe = scanner.nextLine();
			}
			else {
				System.out.println("Keine Datensätze mehr da!");
				System.out.println("Weiter mit \"Enter\"");
				String eingabe = scanner.nextLine();
			}
		}
	}
	
	
	/**
	 * {@link #listPersonView(Person)} gibt die Datensätze aus der 
	 *  ArrayList aus
	 * @param person
	 */
	public void listPersonView(Person person) {
		 System.out.println(Person.AUSGABE[0].concat(person.getName()));
		 System.out.println(Person.AUSGABE[1].concat(person.getVorname()));
		 System.out.println(Person.AUSGABE[2].concat(person.getAnrede()));
		 System.out.println(Person.AUSGABE[3].concat(person.getStrasse()));
		 System.out.println(Person.AUSGABE[4].concat(person.getPlz()));
		 System.out.println(Person.AUSGABE[5].concat(person.getOrt()));
		 System.out.println(Person.AUSGABE[6].concat(person.getTelefon()));
		 System.out.println(Person.AUSGABE[7].concat(person.getFax()));
		 System.out.println(Person.AUSGABE[8].concat(person.getBemerkung())
				 +"\n");
	}
}
