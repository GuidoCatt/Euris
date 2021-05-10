package com.euris.ValutaGB.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.euris.ValutaGB.model.Articolo;
import com.euris.ValutaGB.util.BasicDao;


@Repository
public class DaoMySQL extends BasicDao implements IDao {

	public DaoMySQL(@Value("${db.address}") String dbAddress,
			@Value("${db.user}") String user,
			@Value("${db.password}") String password) {
		super(dbAddress, user, password);
	}

	// ------------------------------------------- CRUD ------------------------------------------
	
	@Override
	public List<Articolo> articoli() {
		List<Articolo> ris = new ArrayList<>();

		List<Map<String, String>> maps = getAll("SELECT * FROM articoli");

		for (Map<String, String> map : maps) {
			Articolo a = new Articolo();
			a.fromMap(map);
			ris.add(a);
		}

		return ris;
	}

	@Override
	public Articolo articolo(int id) {
		Articolo ris = null;
		Map<String, String> map = getOne("SELECT * FROM articoli WHERE id = ?", id);
		
		if (map != null) {
			ris = new Articolo();
			ris.fromMap(map);
		}
		
		return ris;
	}

	@Override
	public void add(Articolo articolo) {
		execute("INSERT INTO articoli (nome, costo) VALUES (?, ?)", articolo.getNome(),
				articolo.getCosto());
	}

	@Override
	public void update(Articolo articolo) {
		execute("UPDATE articoli SET nome = ?, costo = ? WHERE id = ?", articolo.getNome(),
				articolo.getCosto(), articolo.getId());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM articoli WHERE id = ?", id);
	}
	
	// -------------------------------------- OPERATORI --------------------------------------------

	@Override
	public String sum(Articolo articolo1, Articolo articolo2) {
			
			int sum = articolo1.allToPence() + articolo2.allToPence();
			
			return Articolo.allFromPence(sum);
	}
	
	@Override
	public String multi(Articolo articolo1, int fattore) {

			int multi = articolo1.allToPence()*fattore;
			
			return Articolo.allFromPence(multi);	
	}

	@Override
	public String div(Articolo articolo1, int divisore) {
			
			int div = articolo1.allToPence() / divisore;
			int resto = articolo1.allToPence() % divisore;
			
		return Articolo.allFromPence(div) + "(" + Articolo.allFromPence(resto) + ")";
	}
	
}