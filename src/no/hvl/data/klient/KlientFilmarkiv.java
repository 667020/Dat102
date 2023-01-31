package no.hvl.data.klient;

import no.hvl.data102.adt.Filmarkiv;
import no.hvl.data102.adt.FilmarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		
			FilmarkivADT filma = new Filmarkiv(100);
			Meny meny = new Meny(filma);
			meny.start();
			
			System.out.println();
	}
}
