package model;
/*
 * Vermutlich dananch Getter Methoden
 * Diese im Hauptmnü implementieren
 */
import java.util.ArrayList;
import java.util.List;

import service.F1CreateNewPersonImpl;
import service.F4DownloadPersonsImpl;
import service.F7LeaveProgramImpl;
import service.F2ListPersonsImpl;
import service.F6NumberingServiceImpl;
import service.F3SavePersonsImpl;
import service.F5SortPersonsInMemoryImpl;


/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ClientModel {
	
	private F1CreateNewPersonImpl createNewPersonImpl;
	private F4DownloadPersonsImpl downloadPersonsImpl;
	private F7LeaveProgramImpl leaveProgramImpl;
	private F2ListPersonsImpl listPersonsImpl;
	private F6NumberingServiceImpl numberingServiceImpl;
	private F3SavePersonsImpl savePersonsImpl;
	private F5SortPersonsInMemoryImpl sortPersonsInMemoryImpl;
	private List<Person> personList;
	
	
	/**
	 * @param personList
	 */
	public ClientModel(List<Person> personList) {
		this.personList = personList;
	}

	
	/**
	 * @return
	 */
	public F1CreateNewPersonImpl getCreateNewPersonImpl() {
		return createNewPersonImpl;
	}

	
	/**
	 * @param createNewPersonImpl
	 */
	public void setCreateNewPersonImpl
	(F1CreateNewPersonImpl createNewPersonImpl) {
		this.createNewPersonImpl = createNewPersonImpl;
	}

	
	/**
	 * @return
	 */
	public F4DownloadPersonsImpl getDownloadPersonsImpl() {
		return downloadPersonsImpl;
	}

	
	/**
	 * @param downloadPersonsImpl
	 */
	public void setDownloadPersonsImpl
	(F4DownloadPersonsImpl downloadPersonsImpl) {
		this.downloadPersonsImpl = downloadPersonsImpl;
	}

	
	/**
	 * @return
	 */
	public F7LeaveProgramImpl getLeaveProgramImpl() {
		return leaveProgramImpl;
	}

	
	/**
	 * @param leaveProgramImpl
	 */
	public void setLeaveProgramImpl(F7LeaveProgramImpl leaveProgramImpl) {
		this.leaveProgramImpl = leaveProgramImpl;
	}

	
	/**
	 * @return
	 */
	public F2ListPersonsImpl getListPersonsImpl() {
		return listPersonsImpl;
	}
	
	
	/**
	 * @param listPersonsImpl
	 */
	public void setListPersonsImpl(F2ListPersonsImpl listPersonsImpl) {
		this.listPersonsImpl = listPersonsImpl;
	}

	
	/**
	 * @return
	 */
	public F6NumberingServiceImpl getNumberingServiceImpl() {
		return numberingServiceImpl;
	}

	
	/**
	 * @param numberingServiceImpl
	 */
	public void setNumberingServiceImpl
	(F6NumberingServiceImpl numberingServiceImpl) {
		this.numberingServiceImpl = numberingServiceImpl;
	}

	
	/**
	 * @return
	 */
	public F3SavePersonsImpl getSavePersonsImpl() {
		return savePersonsImpl;
	}

	
	/**
	 * @param savePersonsImpl
	 */
	public void setSavePersonsImpl(F3SavePersonsImpl savePersonsImpl) {
		this.savePersonsImpl = savePersonsImpl;
	}

	
	/**
	 * @return
	 */
	public F5SortPersonsInMemoryImpl getSortPersonsInMemoryImpl() {
		return sortPersonsInMemoryImpl;
	}

	
	/**
	 * @param sortPersonsInMemoryImpl
	 */
	public void setSortPersonsInMemoryImpl
	(F5SortPersonsInMemoryImpl sortPersonsInMemoryImpl) {
		this.sortPersonsInMemoryImpl = sortPersonsInMemoryImpl;
	}

	
	/**
	 * @return
	 */
	public List<Person> getPersonList() {
		return personList;
	}

	
	/**
	 * @param personList
	 */
	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}
}
