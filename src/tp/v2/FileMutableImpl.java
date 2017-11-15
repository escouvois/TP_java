package tp.v2;

import java.util.Iterator;

public class FileMutableImpl<E> implements FileMutable<E> {
	ListeMutable<E> liste = ListeMutable.vide();
	ListeMutable<E> fin = ListeMutable.vide();

	@Override
	public E premier() {
		return liste.tete();
	}

	@Override
	public FileMutable<E> suivants() {
		return null;
	}

	@Override
	public int taille() {
		return liste.taille() + fin.taille();
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouter(E element) {
		fin = fin.miroir();
		fin = ListeMutable.cons(element, fin);
		fin = fin.miroir();
	}

	@Override
	public void retirer() {
		if (liste.casVide()) {
			liste = fin.miroir();
			fin = ListeMutable.vide();
		}
	}

	@Override
	public FileMutable<E> creer() {
		return null;
	}

	@Override
	public FileMutable<E> creerCopie() {
		FileMutable<E> copie = this;
		return copie;
	}

	
	/**
	 * Ajouter une liste à la liste
	 * @param secondeFile
	 */
	@Override
	public void ajouter(File<E> secondeFile) {
		for(E e : secondeFile){
            ajouter(e);
        }
	}

}
