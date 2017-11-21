package tp.v5;

public class EtatFileImmutableImpl<E> implements EtatFileImmutable<E>{
	private ListeImmutable<E> listeFin;
	private ListeImmutable<E> listeDebut;
	
	private int taille;

	public EtatFileImmutableImpl() {
		ListeImmutable<E> vide = ListeImmutable.vide();
		this.listeFin = vide;
		this.listeDebut = vide;
		this.taille = 0;
	}

	public EtatFileImmutableImpl(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
		this.taille = taille;
		if (listeTete.estVide()) {
			ListeImmutable<E> vide = listeTete;
			listeTete = listeFin.miroir();
			listeFin = vide;
		}
		this.listeDebut = listeTete;
		this.listeFin = listeFin;
	}

	@Override
	public E tete() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.listeDebut.tete();
	}

	@Override
	public FileImmutable<E> reste() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return new FileImmutableImplParEtat<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
	}

	@Override
	public int taille() {
		return this.taille;
	}

	@Override
	public FileImmutable<E> creer() {
		return new FileImmutableImplParEtat<E>();
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		return new FileImmutableImplParEtat<>(this.taille + 1, this.listeDebut,
				ListeImmutable.cons(dernier, this.listeFin));
	}

	@Override
	public String toString() {
		return this.representation();
	}

	private String representation() {
		return this.listeDebut.representation().concat(this.listeFin.representation());
	}
	
}
