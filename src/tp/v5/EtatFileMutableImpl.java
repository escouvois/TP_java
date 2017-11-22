package tp.v5;

import java.util.Iterator;
/**
 * Implémentation d'une liste mutable
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW
 * @param <E> type
 */
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
		Iterator<E> iterListe = liste.iterator();
		while (iterListe.hasNext()) {
			file.ajout(iterListe.next());
		}
		Iterator<E> iterFin = fin.iterator();
		while (iterFin.hasNext()) {
			file.ajout(iterFin.next());
		}
		
		return file;
	}

	@Override
	public FileMutable<E> creer() {
		return new FileMutableImplParEtat<E>();
	}


}
