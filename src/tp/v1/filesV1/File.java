package tp.v1.filesV1;

import tp.v1.exceptions.EmptyQueueException;

/**
 * Interface representant une File.
 * 
 * @author Lucas TAILLEBOURG, Ibrahima SOW, Bastien ESCOUVOIS.
 * @param <E> type générique
 */
public interface File<E> {
	
	/**
	 * Retire la tete de la file.
	 * @throws EmptyQueueException la file est vide
	 */
	E remove() throws EmptyQueueException;

	/**
	 * Retourne la tete de la file.
	 * 
	 * @throws EmptyQueueException la file est vide
	 */
	E first() throws EmptyQueueException;

	/**
	 * Ins�re un element en queue de file.
	 * @param e element a inserer.
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