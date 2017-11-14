package tp.v2;

import tp.v1.exceptions.EmptyQueueException;

public class FileImmutableDoubleListe<E> {
	Liste<E> liste = Liste.vide();
	Liste<E> fin = Liste.vide();
	
	public void ajout(E element) {
		fin = Liste.cons(element, fin);
		
		if(liste.casVide()) {
			liste = fin.miroir();
			fin = ListeMutable.vide();
		}
	}
	
	public void retrait() throws EmptyQueueException {
		if(liste.casVide()) {
			throw new EmptyQueueException("La liste est vide");
		}
		liste = liste.reste();
		if(liste.casVide()) {
			liste = fin.miroir();
			fin = Liste.vide();
		}
	}
}
