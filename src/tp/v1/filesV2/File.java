package tp.v1.filesV2;

/**
 * Interface proposée pour manipuler une file générique.
 * 
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * 
 * @param <E>
 */
public interface File<E> {

	/**
	 * Retourne et supprime l'élément en tête de file.
	 * Complexité en O(1).
	 * 
	 * @return l'élément supprimé en tête de file
	 */
	E remove();

	/**
	 * Ajoute un objet en queue de file.
	 * Complexité en O(1).
	 * 
	 * @param e	objet à ajouter
	 */
	void add(E e);

	/**
	 * Retourne la tête de la file.
	 * Complexité en O(1).
	 * 
	 * @return la tête de la file
	 */
	E getHead();

	/**
	 * Retourne la longueur de la file.
	 * Complexité en O(1).
	 * 
	 * @return la longueur de la file
	 */
	int length();
}
