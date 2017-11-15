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
		if(liste.estVide() && fin.estVide()) return null;
		
		FileMutable<E> result = creer();
		
		if(liste.estVide()) {
			liste = fin.reste();
			return this;
		}
		
		if(fin.estVide()) {
			liste = liste.reste();
			return this;
		}
		
		
		liste = liste.reste();
		return this;
	}

	@Override
	public int taille() {
		return liste.taille() + fin.taille();
	}


	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				return liste.estVide();
			}

			@Override
			public E next() {
				if(!hasNext()) return null;
				if(liste.iterator().hasNext()) {
					return liste.iterator().next();
				}
				if(!liste.iterator().hasNext() && !liste.estVide()) {
					return fin.tete();
				}
				return fin.iterator().next();
			}
		};
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

	@Override
	public FileMutable<E> creer() {
		return null;
	}

}
