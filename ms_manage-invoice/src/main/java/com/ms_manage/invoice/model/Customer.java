package com.ms_manage.invoice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	@JsonProperty("id")
	private int id;
	private String name;
	private String strasse;
	private String plz;
	private String ort;
	private String telefon;
	private String email;
	private String iban;
	private String bic;
	
	public Customer() {
		super();
	}
	public Customer(int id, String name, String strasse, String plz, String ort, String telefon, String email,
			String iban, String bic) {
		super();
		this.id = id;
		this.name = name;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.telefon = telefon;
		this.email = email;
		this.iban = iban;
		this.bic = bic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", strasse=" + strasse + ", plz=" + plz + ", ort=" + ort + "]";
	}
	
}
