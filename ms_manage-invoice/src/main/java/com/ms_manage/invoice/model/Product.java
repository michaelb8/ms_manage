package com.ms_manage.invoice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("id")
	private int id;
	private String name;
	private String beschreibung;
	private double preis;
	private String bild;
	private boolean aktiv;
	
		
	public Product() {
		super();
	}

	public Product(int id, String name, String beschreibung, double preis, String bild, boolean aktiv) {
		super();
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = bild;
		this.aktiv = aktiv;
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

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getBild() {
		return bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	
}
