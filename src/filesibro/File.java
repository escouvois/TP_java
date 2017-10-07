package filesibro;


/**
 * Interface représentant une File.
 *
 * @author Lucas TAILLEBOURG, Ibrahima SOW, Bastien ESCOUVOIS.
 * @param <E>
 */
public interface File<E> {

    /**
     * Retire la tête de la file.
     */
    void retirerTete();


    /**
     * Insère un élément en queue de file.
     * @param e élément à insérer.
     */
    void insererQueue(E e);

    /**
     * Retourne la longueur de la file.
     * @return entier, longueur de la file.
     */
    int longueur();

    boolean estVide();
}