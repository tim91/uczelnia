package org.simulator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Osoba {
	
	@Id
	@GeneratedValue
	private int id;
	private String imię;
	private String nazwisko;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImię() {
		return imię;
	}

	public void setImię(String imię) {
		this.imię = imię;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
}
