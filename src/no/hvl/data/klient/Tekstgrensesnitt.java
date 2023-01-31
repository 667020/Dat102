package no.hvl.data.klient;

import java.util.Scanner;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Følg stegene for å legge inn en ny film.");
		// leser inn filmnr
		System.out.println("Skriv inn filmnr:");
		int filmnr = Integer.parseInt(scanner.nextLine());

		// leser inn produsent
		System.out.println("Skriv inn produsent");
		String produsent = scanner.nextLine();

		// leser inn tittel
		System.out.println("Skriv inn tittel på film");
		String tittel = scanner.nextLine();

		// leser inn lanseringsår
		System.out.println("Skriv inn lanseringsår");
		int lanseringsaar = Integer.parseInt(scanner.nextLine());

		// leser inn sjanger
		System.out.println("Skriv inn et av disse sjangrene");

		for (int i = 0; i < Sjanger.antall(); i++) {
			System.out.print(Sjanger.values()[i] + ", ");
		}

		String sjangerstreng = scanner.nextLine().toUpperCase();
		Sjanger sjanger = Sjanger.valueOf(sjangerstreng);

		// leser inn selskap
		System.out.println("Skriv inn selskapet som produserte filmen");
		String filmselskap = scanner.nextLine();

		// lukker scanner
		scanner.close();

		// lager objekt film med input fra bruker

		return new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] hjelpeTab = filma.soekTittel(delstreng);

		for (int i = 0; i < hjelpeTab.length; i++) {
			visFilm(hjelpeTab[i]);
		}

	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] hjelpeTab = filma.soekProdusent(delstreng); 

		for (int i = 0; i < hjelpeTab.length; i++) {
			visFilm(hjelpeTab[i]);
		}
		
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		// TODO
	}
	// … Ev. andre metoder
}
