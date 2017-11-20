package tp.v5.immutable;

import java.util.Iterator;

import tp.v5.ListeImmutable;

public class FileImmutableImpl<E> implements FileImmutable<E>{
	
	EtatFileImmutableImpl<E> etat = new EtatFileImmutableImpl<E>();

	public FileImmutableImpl(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
		
		etat =  new EtatFileImmutableImpl<E>(taille, listeTete, listeFin);
	}

	public FileImmutableImpl() {
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
