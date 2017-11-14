package tp.v2;

import tp.v1.exceptions.EmptyQueueException;

public class FileMutableDoubleListe<E> {
	ListeMutable<E> liste = ListeMutable.vide();
	ListeMutable<E> fin = ListeMutable.vide();
	
	public void ajouter(E element) {
		fin = ListeMutable.cons(element, fin);
		
		if(liste.casVide()) {
			liste = fin.miroir();
			fin = ListeMutable.vide();
		}
	}
	
	public void depiler() throws EmptyQueueException {
		if(liste.casVide()) {
			throw new EmptyQueueException("La liste est vide");
		}
		liste = liste.reste();
		if(liste.casVide()) {
			liste = fin.miroir();
			fin = ListeMutable.vide();
		}
	}
}
