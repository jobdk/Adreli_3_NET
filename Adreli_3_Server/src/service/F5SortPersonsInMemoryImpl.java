package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Person;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F5SortPersonsInMemoryImpl {
	private List<Person> personList;
	
	
	/**
	 * @param personList
	 */
	public F5SortPersonsInMemoryImpl(List<Person> personList) {
		this.personList = personList;
	}
	
	
	/**
	 * @return
	 */
	public List<Person> getPersonList() {
		return this.personList;
	}
	
	
	public void personenSortieren() {
		Collections.sort(this.personList, 
				Comparator.comparing(Person::getName));
	}
}
