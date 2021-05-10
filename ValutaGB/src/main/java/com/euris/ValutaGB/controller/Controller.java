package com.euris.ValutaGB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.euris.ValutaGB.dao.IDao;
import com.euris.ValutaGB.model.Articolo;

@RestController()
@RequestMapping("/articoli")
public class Controller {
	
	@Autowired
	private IDao dao;
	
	@GetMapping()
	public List<Articolo> get(){
		return dao.articoli();
	}
	
	@GetMapping("/{id}")
	public Articolo get(@PathVariable int id) {
		return dao.articolo(id);
	}
	
	@PostMapping
	public void add(@RequestBody Articolo articolo) {
		dao.add(articolo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Articolo articolo) {
		dao.update(articolo);
	}
	
	@GetMapping("/somma/{id1}/{id2}")
	public String somma (@PathVariable int id1, @PathVariable int id2) {	
		return dao.sum(dao.articolo(id1), dao.articolo(id2));
	}
	
	@GetMapping("/multi/{id}/{a}")
	public String multi (@PathVariable int id, @PathVariable int a) {
		return dao.multi(dao.articolo(id), a);	
	}
	
	@GetMapping("/div/{id}/{a}")
	public String div (@PathVariable int id, @PathVariable int a) {
		return dao.div(dao.articolo(id), a);
	}
	
	

}