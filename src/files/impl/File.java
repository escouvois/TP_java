package files.impl;

import files.exception.EmptyQueueException;

/**
 * Interface repr�sentant une File.
 * 
 * @author Lucas TAILLEBOURG, Ibrahima SOW, Bastien ESCOUVOIS.
 * @param <E>
 */
public interface File<E> {
	
	/**
	 * Retire la t�te de la file.
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
	 * Ins�re un �l�ment en queue de file.
	 * @param e �l�ment � ins�rer.
	 */
	File add(E e);

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
