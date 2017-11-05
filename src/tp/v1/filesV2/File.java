package tp.v1.filesV2;

/**
 * Interface propos�e pour manipuler une file g�n�rique.
 * 
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * 
 * @param <E>
 */
public interface File<E> {

	/**
	 * Retourne et supprime l'�l�ment en t�te de file.
	 * Complexit� en O(1).
	 * 
	 * @return l'�l�ment supprim� en t�te de file
	 */
	E remove();

	/**
	 * Ajoute un objet en queue de file.
	 * Complexit� en O(1).
	 * 
	 * @param e	objet � ajouter
	 */
	void add(E e);

	/**
	 * Retourne la t�te de la file.
	 * Complexit� en O(1).
	 * 
	 * @return la t�te de la file
	 */
	E getHead();

	/**
	 * Retourne la longueur de la file.
	 * Complexit� en O(1).
	 * 
	 * @return la longueur de la file
	 */
	int length();
}
