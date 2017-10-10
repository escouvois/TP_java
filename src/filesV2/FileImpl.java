package filesV2;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileImpl<E> implements File<E> {

	private Queue<E> file;
	
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
