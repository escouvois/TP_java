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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileImmutable<E> creer() {
		return new FileImmutableImpl<>();
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		// TODO Auto-generated method stub
		return null;
	}

}
