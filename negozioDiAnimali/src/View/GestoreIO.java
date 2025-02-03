package View;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import model.Animale;

public class GestoreIO {

	@SuppressWarnings("resource")
	public int leggiInt(String messaggio) {
		System.out.println(messaggio);
		Scanner input=new Scanner(System.in);
		return Integer.parseInt(input.nextLine());
	}

	@SuppressWarnings("resource")
	public String leggiStringa(String messaggio) {
		System.out.println(messaggio);
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}

	public Date leggiData(String messaggio) {
		System.out.println(messaggio);
		int giorno= leggiInt("Inserisci il giorno: ");
		int mese= leggiInt("Inserisci il mese: ");
		int anno= leggiInt("Inserisci l'anno");
		LocalDate ld = LocalDate.of(anno, mese, giorno);
		return Date.valueOf(ld);
	}
	
	public void menu() {
		System.out.println("****MENU****");
		System.out.println("1) Inserisci animale: ");
		System.out.println("2) Vedi gli animali: ");
		System.out.println("3) Cerca un animale: " );
		System.out.println("4) Modifica un animale: ");
		System.out.println("5) Rimuovi un animale: ");
		System.out.println("6) Esci");
		System.out.println("************");
	}
	
	public void formAnimale(Animale nuovoAnimale) {
		nuovoAnimale.chip=leggiInt("Inserisci il chip: ");
		nuovoAnimale.razza=leggiStringa("Inserisci la razza: ");
		nuovoAnimale.taglia=leggiStringa("Inserisci la taglia: ");
		nuovoAnimale.dataDiNascita=leggiData("Inserisci la data di nascita: ");
		nuovoAnimale.sesso=leggiStringa("Inserisci il sesso: ");
	}
	
	public void schedaAnimale(Animale animal) {
		System.out.println("****SCHEDA ANIMALE****");
		System.out.println("CHIP: "+animal.chip);
		System.out.println("RAZZA: "+animal.razza);
		System.out.println("TAGLIA: "+animal.taglia);
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println("DATA DI NASCITA: "+sdf.format(animal.dataDiNascita));
		System.out.println("SESSO: "+animal.sesso);
		System.out.println("**********************");
	}
	
	public void visualizzaDbAnimali(HashMap<Integer,Animale> Animali) {
		for(Animale valore:Animali.values()) {
			schedaAnimale(Animali.get(valore.chip));
		}
	}
	
	public void checkOp(String nomeOp,boolean risultatoOp) {
		if (risultatoOp) {
			System.out.println(nomeOp+" eseguito/a con successo!!");
		}
		else {
			System.out.println(nomeOp+" annullato/a!!");
		}
	}
}
