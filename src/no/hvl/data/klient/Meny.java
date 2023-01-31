package no.hvl.data.klient;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer
		filmarkiv.leggTilFilm(new Film(1, "Stepehen Norrington", "Blade", 1998, Sjanger.ACTION, "filmfront"));
		filmarkiv.leggTilFilm(new Film(2,"Peter Jackson","The lord of the rings",2002, Sjanger.EVENTYR, "New line cinema")); 
		filmarkiv.leggTilFilm(new Film(3,"George Lucas","Star Wars",1977, Sjanger.SCIFI, "Lucas art")); 
		
		
	}
}
