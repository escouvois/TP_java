package tp.v6;

import correction.v5.ListeImmutable;

public class Miroir<E> {

	private ListeImmutable<E> source;
	private ListeImmutable<E> miroir;

	public Miroir(ListeImmutable<E> fin) {
		this.source = fin;
	}

	public boolean estInversible() {
		return source.taille() > 1;
	}

	public void inverser() {
		if (!source.estVide()) {
			this.miroir = miroir.creer(source.tete());
			source = source.reste();
		}
		if (estInversible()) {
			this.miroir = miroir.creer(source.tete());
			source = source.reste();
		}
	}

	public ListeImmutable<E> miroir() {
		if(!source.estVide()) {
			return this.miroir;
		}else {
			throw new IllegalStateException("La liste source n'est pas vide.");
		}
		
	}
}
