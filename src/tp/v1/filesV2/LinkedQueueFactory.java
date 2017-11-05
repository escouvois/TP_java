package tp.v1.filesV2;

/**
 * Interface de fabrique de file.
 * 
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * @param <E>
 */
public interface LinkedQueueFactory<E> {
	
	/**
	 * Créer une file.
	 * @return la file créée.
	 */
	FileImpl<E> creerFile();
}
