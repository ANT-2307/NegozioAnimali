package controller;

import java.util.HashMap;

import model.Animale;

public class CrudService {

	HashMap<Integer,Animale> dbAnimali=new HashMap<>();

	public boolean inserimentoAnimale(Animale animal) {
		dbAnimali.put(animal.chip, animal);
		return true;
	}

	public HashMap<Integer,Animale> getDbAnimali(){
		return dbAnimali;
	}
}
