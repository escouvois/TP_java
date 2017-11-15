package tp.v1.filesV1;

/**
 * Interface de fabrique de file.
 * 
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * @param <E>
 */
public interface LinkedQueueFactory<E> {
	
	/**
	 * Creer une file.
	 * @return la file creee.
	 */
	FileImpl<E> creerFile();
}
