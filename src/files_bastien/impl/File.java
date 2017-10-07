package files_bastien.impl;

import files_bastien.exception.EmptyQueueException;

/**
 * Interface représentant une File.
 * 
 * @author Lucas TAILLEBOURG, Ibrahima SOW, Bastien ESCOUVOIS.
 * @param <E>
 */
public interface File<E> {
	
	/**
	 * Retire la tête de la file.
	 * @throws EmptyQueueException 
	 */
	E remove() throws EmptyQueueException;

	/**
	 * Retourne la tete de la file.
	 * 
	 * @return tete de file
	 * @throws EmptyQueueException 
	 */
	E first() throws EmptyQueueException;

	/**
	 * Insère un élément en queue de file.
	 * @param e élément à insérer.
	 */
	void add(E e);

	/**
	 * Retourne la longueur de la file.
	 * @return entier, longueur de la file.
	 */
	int length();

	/**
	 * Retourne vrai si la liste est vide, faux sinon.
	 * @return vrai si la liste est vide, faux sinon
	 */
	boolean isEmpty();
}
