package tp.v1.filesV2;

/**
 * Interface de fabrique de file.
 * 
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * @param <E>
 */
public interface LinkedQueueFactory<E> {
	
	/**
	 * Cr�er une file.
	 * @return la file cr��e.
	 */
	FileImpl<E> creerFile();
}
