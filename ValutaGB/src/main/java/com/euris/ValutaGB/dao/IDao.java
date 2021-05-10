package com.euris.ValutaGB.dao;

import java.util.List;

import com.euris.ValutaGB.model.Articolo;

public interface IDao {

	List<Articolo> articoli();
	
	Articolo articolo(int id);
	
	void add(Articolo articolo);
	
	void update(Articolo articolo);
	
	void delete(int id);
	
	String sum (Articolo articolo1, Articolo articolo2);
	
	String multi (Articolo articolo1, int fattore);
	
	String div (Articolo articolo1, int divisore);
}
