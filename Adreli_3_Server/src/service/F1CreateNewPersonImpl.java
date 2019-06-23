package service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Person;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F1CreateNewPersonImpl {
	private Person person;
	private List<Person> personList;
	
	/**
	 * @param person
	 * @param personList
	 */
	public F1CreateNewPersonImpl(Person person, List<Person> personList) {
		this.person = person;
		this.personList = personList;
	}
	
	
	/**
	 * @return
	 */
	public List<Person> getPersonList() {
		return this.personList;
	}
	
	
	/**
	 * {@link #personAufnehmen()} ruft die Methoden {@link #eingabeName()}
	 * , {@link #eingabeVorname()}, {@link #eingabeAnrede()},
	 *  {@link #eingabeStrasse()}, {@link #eingabePlz()},
	 *  {@link #eingabeOrt()}, {@link #eingabeTelefon()},
	 *  {@link #eingabeFax()} und {@link #eingabeBemerkung()} auf um 
	 *  den entsprechenden Datensatz einzugeben.
	 */
	public void personAufnehmen() {
		System.out.println("Geben sie bitte die Daten ein:"+"\n");
		this.eingabeName();
		this.eingabeVorname();
		this.eingabeAnrede();
		this.eingabeStrasse();
		this.eingabePlz();
		this.eingabeOrt();
		this.eingabeTelefon();
		this.eingabeFax();
		this.eingabeBemerkung();
		boolean weiter1;
		do {
			System.out.println("Stimmt's (J/N)");
			Scanner sc = new Scanner(System.in);
			String eingabe1 = sc.nextLine();
			if (eingabe1.matches("[nN]")) {
				weiter1 = false;
				this.personAufnehmen();
			}
			else if (eingabe1.matches("[jJ]")) {
				weiter1 = false;
				this.personList.add(this.person);
				boolean weiter2 = true;
				do {
					System.out.println("Noch eine Person aufnehmen? (J/N)");
					String eingabe2 = sc.nextLine();
					if (eingabe2.matches("[Jj]")) {
						this.personAufnehmen();
						weiter2 = false;
					}
					else if (eingabe2.matches("[nN]")) {
						weiter2 = false;
					}
				}
				while (weiter2);
			}
			else {
				weiter1 = true;
			}
		}
		while (weiter1);
	}
	
	
	public void eingabeName() {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[0]);
		this.person.setName(sc.nextLine().trim().replaceAll(" +", " "));
		if (!Pattern.matches("([A-ZÜÖÄa-züöäß -])+", this.person.getName())) {
			this.eingabeName();
		}
	}
	
	
	public void eingabeVorname() {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[1]);
		this.person.setVorname(sc.nextLine().trim().replaceAll(" +", " "));
		if (!Pattern.matches("([A-ZÜÖÄa-züöäß -])+", this.person.getName())) {
			this.eingabeVorname();
		}
	}
	
	
	public void eingabeOrt( ) {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[5]);
		this.person.setOrt(sc.nextLine().trim().replaceAll(" +"," "));
		if (!Pattern.matches("([A-ZÜÖÄa-züöäß -])+", this.person.getName())) {
			this.eingabeOrt();
		}
	}
	
	
	public void eingabeAnrede() {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[2]);
		this.person.setAnrede(sc.nextLine().trim().replaceAll(" +"," "));
		String upperAnrede = this.person.getAnrede().toUpperCase();
		if (!Pattern.matches("(HERR|FRAU|DIVERS)",upperAnrede)) {
			this.eingabeAnrede();
		}
	}
	
	
	public void eingabeStrasse() {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[3]);
		this.person.setStrasse(sc.nextLine().trim().replaceAll(" +", " "));
		if (!Pattern.matches("([A-Za-zäöüß -])*(\\d){1,4}([ ])*([A-Za-z])?",
				this.person.getStrasse())) {
			this.eingabeStrasse();
		}
	}
	
	
	public void eingabeBemerkung() {
		Scanner sc = new Scanner(System.in);
		System.out.print(Person.AUSGABE[8]);
		this.person.setBemerkung(sc.nextLine().trim().replaceAll(" +", " "));
	}
	
	
	public void eingabePlz() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(Person.AUSGABE[4]);
		this.person.setPlz(scanner.nextLine().trim().replaceAll(" +",""));
		if (!Pattern.matches("\\d{5}", this.person.getPlz())) {
			this.eingabePlz();
		}
	}
	
	
	public void eingabeTelefon() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(Person.AUSGABE[6]);
		this.person.setTelefon(scanner.nextLine().trim().replaceAll(" +",""));
		if (!Pattern.matches("(\\+)?(\\d){2}?(\\(0\\))?([0-9 -])+",
				this.person.getTelefon())) {
			this.eingabeTelefon();
		}
	}
	
	
	public void eingabeFax() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(Person.AUSGABE[7]);
		this.person.setFax(scanner.nextLine().trim().replaceAll(" +",""));
		if (!Pattern.matches("(\\+)?(\\d){2}?(\\(0\\))?([0-9 -])+", 
				this.person.getFax())) {
			this.eingabeFax();
		}
	}
}
