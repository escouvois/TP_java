package files_bastien.impl;

import files_bastien.exception.EmptyQueueException;

public class FileImpl<E> implements File<E> {

	private int length;
	private Maillon first;
	private Maillon last;

	private class Maillon {
		E item;
		Maillon next;
	}
	
	public FileImpl() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}

	@Override
	public E remove() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("La liste est vide.");
		Maillon toRemoved = this.first;
		this.first = this.first.next;
		length--;
		if (isEmpty())
			this.last = null;
		return toRemoved.item;
	}

	@Override
	public E first() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("La liste est vide.");
		return this.first.item;
	}

	@Override
	public void add(E e) {
		Maillon old = this.last;
		this.last = new Maillon();
		this.last.next = null;
		this.last.item = e;
		if(isEmpty()){
			this.first = this.last;
		}else{
			old.next = this.last;
		}
		this.length++;
	}

	@Override
	public int length() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}
}
