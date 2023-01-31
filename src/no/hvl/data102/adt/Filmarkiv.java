package no.hvl.data102.adt;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmtab;
	private int antall = 0;

	public Filmarkiv(int y) {
		filmtab = new Film[y];
		antall = 0;

	}

	public void utvid() {
		Film[] tab = new Film[filmtab.length * 2];

		for (int i = 0; i < filmtab.length; i++) {
			tab[i] = filmtab[i];

		}
		filmtab = tab;

	}

	@Override
	public Film finnFilm(int nr) {
		Film film = null;
		for (int i = 0; i < filmtab.length; i++) {

			if (nr == filmtab[i].getFilmnr()) {
				film = filmtab[i];
			}

		}
		return film;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (nyFilm != null && antall == filmtab.length) {
			utvid();
		}
		filmtab[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (antall == 0) {
			System.out.println("Tabellen er tom");
		}

		boolean funnet = false;
		for (int i = 0; i < filmtab.length && !funnet; i++) {
			
			if (filmtab[i].getFilmnr() == filmnr) {
				filmtab[i] = filmtab[filmtab.length - 1];
				filmtab[filmtab.length - 1] = null;
				antall--;
				funnet = true;
			}
		}
		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] soktab = new Film[antall];
		int index = 0;

		for (int i = 0; i < filmtab.length; i++) {
			if (filmtab[i].getTittel().contains(delstreng)) {
				soktab[index] = filmtab[i];
				index++;
			}
		}
		trimTab(soktab, index);

		return soktab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] soktab = new Film[antall];
		int index = 0;

		for (int i = 0; i < filmtab.length; i++) {
			if (filmtab[i].getProdusent().contains(delstreng)) {
				soktab[index] = filmtab[i];
				index++;
			}
		}
		trimTab(soktab, index);

		return soktab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int teller = 0;

		for (int i = 0; i < filmtab.length; i++) {
			if (filmtab[i].getSjanger().equals(sjanger)) {
				teller++;
			}

		}

		return teller;
	}

	@Override
	public int antall() {

		return antall;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

}
