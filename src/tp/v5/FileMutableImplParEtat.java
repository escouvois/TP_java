package tp.v5;

import java.util.Iterator;
/**
 * Implémentation d'une file mutable suivant un patron de conception état
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW
 * @param <E>
 */
public class FileMutableImplParEtat<E> implements FileMutable<E>{
	
	EtatFileMutable<E> etat = new EtatFileMutableImpl<>();

	@Override
	public E premier() {
		return etat.premier();
	}

	@Override
	public FileMutable<E> suivants() {
		return etat.suivants();
	}

	@Override
	public boolean estVide() {
		return etat.estVide();
	}

	@Override
	public int taille() {
		return etat.taille();
	}

	@Override
	public FileMutable<E> creer() {
		return etat.creer();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			FileMutableImplParEtat<E> tmp = FileMutableImplParEtat.this;

			@Override
			public boolean hasNext() {
				return !tmp.estVide();
			}

			@Override
			public E next() {
				E temp = tmp.premier();
				tmp = (FileMutableImplParEtat<E>) tmp.suivants();
				return temp;
			}
			
		};
	}

	@Override
	public void ajouter(E element) {
		etat.ajouter(element);
	}

	@Override
	public void retirer() {
		etat.retirer();
	}

	@Override
	public FileMutable<E> creerCopie() {
		return etat.creerCopie();
	}

	@Override
	public String toString() {
		return this.representation();
	}
}
