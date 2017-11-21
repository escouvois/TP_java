package tp.v5;

import java.util.Iterator;

public class FileImmutableImplParEtat<E> implements FileImmutable<E>{
	
	EtatFileImmutableImpl<E> etat = new EtatFileImmutableImpl<E>();

	public FileImmutableImplParEtat(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
		
		etat =  new EtatFileImmutableImpl<E>(taille, listeTete, listeFin);
	}

	public FileImmutableImplParEtat() {
		etat = new EtatFileImmutableImpl<E>();
	}

	@Override
	public E premier() {
		return etat.tete();
	}

	@Override
	public FileImmutable<E> suivants() {
		return etat.reste();
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
	public FileImmutable<E> creer() {
		return etat.creer();
	}

	@Override
	public Iterator<E> iterator() {
		//TODO
		return null;
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		return etat.creer(dernier);
	}
	
	

}
