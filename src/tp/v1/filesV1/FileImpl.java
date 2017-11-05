package tp.v1.filesV1;

import tp.v1.exceptions.EmptyQueueException;

public class FileImpl<E> implements File<E> {

	private Maillon first;
	private Maillon last;

	private class Maillon {
		E item;
		Maillon next;
		
		public Maillon getNext(){
			return this.next;
		}
	}

	public FileImpl() {
		this.first = null;
		this.last = null;
	}

	@Override
	public E remove() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("La liste est vide.");
		Maillon toRemoved = this.first;
		this.first = this.first.next;
		if (isEmpty())
			this.last = null;
		return toRemoved.item;
	}

	@Override
	public E first() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("La liste est vide.");
		return this.first.item;
	}

	@Override
	public void add(E e) {
		Maillon old = this.last;
		this.last = new Maillon();
		this.last.next = null;
		this.last.item = e;
		if (isEmpty()) {
			this.first = this.last;
		} else {
			old.next = this.last;
		}
	}

	@Override
	public int length() {
		int i = 0;

		if (this.first != null) {
			i++;
			while (this.first.next != null)
				i++;
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

}