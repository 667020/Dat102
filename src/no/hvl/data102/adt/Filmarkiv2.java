package no.hvl.data102.adt;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		if (start == null)
			return null;

		LinearNode<Film> tempNode = start;
		Film node = null;

		for (int i = 0; i < antall; i++) {

			if (nr == tempNode.getElement().getFilmnr()) {

				node = tempNode.getElement();
			}
			tempNode = tempNode.getNeste();

		}

		return node;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);

		if (start == null) {
			start = nyNode;
		}

		LinearNode<Film> tempNode = start;

		while (tempNode.getNeste() != null) {
			nyNode = tempNode.getNeste();
		}
		tempNode.setNeste(nyNode);
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false; 
		if (start == null) {
			slettet = false; 
		}
		
		if(start.getElement().getFilmnr()==filmnr) {
			start = start.getNeste(); 
		}
		
		
		
		
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

}
