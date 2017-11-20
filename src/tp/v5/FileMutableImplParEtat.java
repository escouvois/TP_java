package tp.v5;

import java.util.Iterator;

public class FileMutableImplParEtat<E> implements FileMutable<E>{
	
	EtatFileMutable<E> etat = new EtatFileMutableImpl<>();

	@Override
	public E premier() {
		return etat.premier();
	}

	@Override
	public FileMutable<E> suivants() {
		return etat.suivants();
	}

	@Override
	public boolean estVide() {
		return etat.estVide();
	}

	@Override
	public int taille() {
		return etat.taille();
	}

	@Override
	public FileMutable<E> creer() {
		return etat.creer();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouter(E element) {
		etat.ajouter(element);
	}

	@Override
	public void retirer() {
		etat.retirer();
	}

	@Override
	public FileMutable<E> creerCopie() {
		return etat.creerCopie();
	}

}
