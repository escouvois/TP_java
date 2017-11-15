package tp.v2;

import java.util.Iterator;

public class FileImmutableImpl<E> implements FileImmutable<E> {
	Liste<E> liste = Liste.vide();
	Liste<E> fin = Liste.vide();

	@Override
	public E premier() {
		if (!liste.estVide()) {
			return liste.tete();
		} else {
			return fin.tete();
		}
	}

	@Override
	public int taille() {
		return liste.taille() + fin.taille();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			FileImmutableImpl<E> tmp = FileImmutableImpl.this;

			@Override
			public boolean hasNext() {
				return !tmp.suivants().estVide();
			}

			@Override
			public E next() {
				E temp = tmp.premier();
				tmp = (FileImmutableImpl<E>) tmp.suivants();
				return temp;
			}
		};
	}

	@Override
	public FileImmutable<E> suivants() {
		if(liste.estVide() && fin.estVide()) return null;
		
		FileImmutable<E> result = creer();
		
		if(liste.estVide()) {
			for (E e : fin.reste()) {
				result = creer(e);
			}
			return result;
		}
		if(fin.estVide()) {
			for (E e : liste.reste()) {
				result = creer(e);
			}
			return result;
		}
		
		
		for (E e : liste.reste()) {
			result = creer(e);
		}
		for (E e : fin) {
			result = creer(e);
		}
		
		return result;
		
	}
	

	@Override
	public FileImmutable<E> creer() {
		return new FileImmutableImpl<>();
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		FileImmutable<E> result = creer();
		
		if(liste.estVide()) {
			
			fin = Liste.cons(dernier, fin);
			liste = fin.miroir();
			fin = Liste.vide();
			return this;
		}
		fin = Liste.cons(dernier, fin);
		
		return this;
	}

}
