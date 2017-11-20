package tp.v2;

import java.util.Iterator;

public class FileMutableImpl<E> implements FileMutable<E> {
	
	ListeMutable<E> liste = ListeMutable.vide();
	ListeMutable<E> fin = ListeMutable.vide();

	/**
	 * @see tp.v2.File#premier()
	 */
	@Override
	public E premier() {
		return liste.tete();
	}

	/**
	 * @see tp.v2.FileMutable#suivants()
	 */
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

	/**
	 * @see tp.v2.File#taille()
	 */
	@Override
	public int taille() {
		return liste.taille() + fin.taille();
	}


	/**
	 * @see java.lang.Iterable#iterator()
	 */
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

	/**
	 * @see tp.v2.FileMutable#ajouter(java.lang.Object)
	 */
	@Override
	public void ajouter(E element) {
		fin = fin.miroir();
		fin = ListeMutable.cons(element, fin);
		fin = fin.miroir();
	}

	/**
	 * @see tp.v2.FileMutable#retirer()
	 */
	@Override
	public void retirer() {
		if (liste.casVide()) {
			liste = fin.miroir();
			fin = ListeMutable.vide();
		}
	}

	/**
	 * @see tp.v2.FileMutable#creerCopie()
	 */
	@Override
	public FileMutable<E> creerCopie() {
		FileMutable<E> copie = this;
		return copie;
	}

	
	/**
	 * Ajouter une liste à la liste
	 * O(n)
	 * @param secondeFile file à ajouter
	 */
	@Override
	public void ajouter(File<E> secondeFile) {
		for(E e : secondeFile){
            ajouter(e);
        }
	}

	/**
	 * @see tp.v2.FileMutable#creer()
	 */
	@Override
	public FileMutable<E> creer() {
		return null;
	}

}
