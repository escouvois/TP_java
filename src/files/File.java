package files;

/**
 * Interface repr�sentant une File.
 * 
 * @author Lucas TAILLEBOURG, Ibrahima SOW, Bastien ESCOUVOIS.
 * @param <E>
 */
public interface File<E> {
	
	/**
	 * Retire la t�te de la file.
	 */
	void retirerTete();

	/**
	 * Retourne la tete de la file.
	 * 
	 * @return tete de file
	 */
	E tete();

	/**
	 * Ins�re un �l�ment en queue de file.
	 * @param e �l�ment � ins�rer.
	 */
	void insererQueue(E e);

	/**
	 * Retourne la longueur de la file.
	 * @return entier, longueur de la file.
	 */
	int longueur();

	boolean estVide();
}
