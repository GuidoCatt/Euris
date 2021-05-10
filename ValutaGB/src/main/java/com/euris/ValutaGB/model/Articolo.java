package com.euris.ValutaGB.model;

import com.euris.ValutaGB.util.IMappablePro;

public class Articolo implements IMappablePro{

	private int id;
	private String nome;
	private String costo;
	
	public Articolo(int id, String nome, String costo) {
		super();
		this.id = id;
		this.nome = nome;
		this.costo = costo;
	}
	
	// Il costruttore mi serve per l' IMappablePro
	public Articolo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	// ---------------------------------------- METODI ACCESSORI -------------------------------------------------
	
	// metodo per ottenere il coefficiente delle varie monete
	private int coefficiente(String s) {
		return Integer.parseInt(s.substring(0, s.length() - 1));
	}
	
	public int getPound() {
		String[] valuta = costo.split(",");
		return coefficiente(valuta[0]);
	}
	
	public int getShilling() {
		String[] valuta = costo.split(",");
		return coefficiente(valuta[1]);
	}
	
	public int getPence() {
		String[] valuta = costo.split(",");
		return coefficiente(valuta[2]);
	}
	
	// trasformo tutto in pence (int) per i calcoli
	public int allToPence() {
		return getPound()*240 + getShilling()*12 + getPence();
	}
	
	// e ritrasformo in stringa per fornire un risultato
	static public String allFromPence(int pence) {
		int s = pence / 12;
		int p = pence % 12;
		int P = s / 20;
		s = s % 20;
		return P + "p," + s + "s," + p + "d";
	}
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", nome=" + nome + ", costo=" + costo + "]";
	}
	
	
}
