package tp.v6;

import correction.v5.ListeImmutable;

public class EtatFileImmutableAvecInversionParesseuseNonVide<E> implements EtatImmutableAvecInversionParesseuse<E> {

	/*
	 * Invariant : la taille de ld est strictement positive, 
	 * tout miroir (paresseux) dans fm n'est pas vide, 
	 * le nombre d'éléments dans ld et fm est strictement supérieur à la taille de lf.
	 */

	FileImmutable<Miroir<E>> fm;
	ListeImmutable<E> ld;
	ListeImmutable<E> lf;
	int taille;

	/*
	 * Constructeur
	 */

	public EtatFileImmutableAvecInversionParesseuseNonVide(int taille, FileImmutable<Miroir<E>> fm,
			ListeImmutable<E> ld, ListeImmutable<E> lf) {

		this.taille = taille;

		// On vérifie les invariants à la construction
		if (lf.taille() >= this.taille - lf.taille()) {
			this.ld = ld;
			this.fm = fm.ajout(new Miroir<>(lf));
			this.lf = ListeImmutable.vide();
		} else {
			this.lf = lf;
		}

		if (ld.estVide()) {
			this.ld = fm.premier().miroir();
			this.fm = fm.suivants();
		} else {
			this.ld = ld;
			this.fm = fm;
		}

	}

	/*
	 * Accesseurs
	 */

	@Override
	public E premier() {
		return this.ld.tete();
	}

	@Override
	public EtatFileImmutable<E> suivants() {
		throw new IllegalStateException();
	}

	@Override
	public int taille() {
		return this.taille;
	}

	/*
	 * Fabrique
	 */

	@Override
	public EtatFileImmutable<E> creer(E dernier) {
		return new EtatFileImmutableAvecInversionParesseuseNonVide<>(this.taille + 1, this.fm, this.ld,
				this.lf.creer(dernier));
	}

	@Override
	public EtatFileImmutable<E> creer() {
		return new EtatFileImmutableAvecInversionParesseuseVide<>();
	}

}
