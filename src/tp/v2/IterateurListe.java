package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	/**
	 * Méthode pour déterminer si la liste possède un prochain élément
	 * @return boolean : Un boolean pour déterminer si la liste possède un prochain élément
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Méthode pour renvoyer le prochain élément de la liste
	 * @return E : Prochain élément de la liste
	 */
	@Override
	public E next() {
		return null;
	}

}
