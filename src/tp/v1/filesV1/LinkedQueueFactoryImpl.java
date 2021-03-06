package tp.v1.filesV1;

/**
 * Implementation de la fabrique de file.
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW.
 * @param <E>
 */
public class LinkedQueueFactoryImpl<E> implements LinkedQueueFactory{

	@Override
	public FileImpl<E> creerFile() {
		return new FileImpl<E>();
	}

}
