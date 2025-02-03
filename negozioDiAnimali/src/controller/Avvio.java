package controller;

import java.util.HashMap;

import View.GestoreIO;
import model.Animale;

public class Avvio {

	public static void main(String[] args) {
		
		GestoreIO gio=new GestoreIO();
		CrudService crud=new CrudService();
		
		
		boolean flag=true;
		while (flag) {
			Animale animale= new Animale();
			boolean risultatoOp=false;
			gio.menu();
			int scelta=gio.leggiInt("Scegli un'opzione: ");
			switch(scelta) {
			case 1:
				animale=new Animale();
				gio.formAnimale(animale);
				risultatoOp=crud.inserimentoAnimale(animale);
				gio.checkOp("Inserimento", risultatoOp);
				gio.leggiStringa("Premi un tasto per continuare...");
				break;
			case 2:
				HashMap<Integer,Animale> dbAnimali=crud.getDbAnimali();
				gio.visualizzaDbAnimali(dbAnimali);
				gio.leggiStringa("Premi un tasto per continuare...");
				break;
			case 3:
				int chipCercato=gio.leggiInt("Inserisci il chip dell'animale da cercare: ");
				gio.schedaAnimale(crud.getAnimale(chipCercato));
				gio.leggiStringa("Premi un tasto per continuare...");
				break;
			case 4:
				
				break;
			case 5:
				int chipRimozione=gio.leggiInt("Inserisci il chip dell'animale da rimuovere: ");
				risultatoOp=crud.rimuoviAnimale(chipRimozione);
				gio.checkOp("Rimozione", risultatoOp);
				break;
			case 6:
				gio.leggiStringa("Grazie per aver usato questo programma! Premi un tasto per continuare...");
				flag=false;
				break;
			default:
				gio.leggiStringa("Scelta non contemplata! Premi un tasto per continuare...");
				break;
			}
		}
	}

}
