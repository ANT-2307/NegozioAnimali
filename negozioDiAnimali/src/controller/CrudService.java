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

	public Animale getAnimale(int chipCercato) {
		if (dbAnimali.containsKey(chipCercato)) {
			return dbAnimali.get(chipCercato);
		}
		else {
			return null;
		}
	}
	
	public boolean rimuoviAnimale(int chipCercato) {
		if (dbAnimali.containsKey(chipCercato)) {
			dbAnimali.remove(chipCercato);
			return true;
		}
		else {
			return false;
		}
	}
}




