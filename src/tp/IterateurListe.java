package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	//Accesseurs

	/**
	 * Méthode déterminant si la liste possède un prochain élément
	 * @return Boolean déterminant si la liste possède un prochain élément
	 */
	@Override
	public boolean hasNext() {
		return false;
	}


	/**
	 * Méthode retournant le prochain élément de la liste
	 * @return Prochain élément de la liste
	 */
	@Override
	public E next() {
		return null;
	}

}
