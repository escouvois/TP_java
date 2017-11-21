package tp.v5;

public class EtatFileMutableImpl<E> implements EtatFileMutable<E> {
	
	ListeMutable<E> liste;
	ListeMutable<E> fin;
	private int taille;
	
	public EtatFileMutableImpl() {
		this.liste = ListeMutable.vide();
		this.fin = null;
		this.taille = 0;
	}
	
	@Override
	public void ajouter(E element) {
		if (this.estVide()) {
			ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.liste);
			this.liste = nouvelElement;
			this.fin = nouvelElement;
			this.taille++;
			return;
		}
		ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.fin.reste());
		this.fin.changerReste(nouvelElement);
		this.fin = nouvelElement;
		this.taille++;
	}

	@Override
	public int taille() {
		return this.taille;
	}

	@Override
	public void retirer() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		this.liste = this.liste.reste();
		this.taille--;
	}

	@Override
	public E premier() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.liste.tete();
	}

	@Override
	public FileMutable<E> creerCopie() {
		FileMutable<E> file = creer();
		return file.ajout(this);
	}

	@Override
	public FileMutable<E> creer() {
		return new EtatFileMutableImpl();
	}


}
