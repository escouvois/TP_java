package tp.v1.filesV2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Implémentation d'une file générique en utilisant les LinkedQueue.
 * @author Bastien ESCOUVOIS
 * @param <E>
 */
public class FileImpl<E> implements File<E> {

	private Queue<E> file;
	
	/**
	 * Constructeur qui instancie une file en utilisant le constructeur LinkedBlockingQueue.
	 */
	public FileImpl() {
		this.file = new LinkedBlockingQueue<E>();
	}
	
	@Override
	public E remove() {
		return this.file.remove();
	}

	@Override
	public void add(E e) {
		
		this.file.add(e);
		
	}

	@Override
	public E getHead() {
		return this.file.peek();
	}

	@Override
	public int length() {
		return this.file.size();
	}
	
	@Override
	public String toString() {
		return file.toString();
	}
}
