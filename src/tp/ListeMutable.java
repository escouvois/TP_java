package tp.v2;

import java.util.Iterator;

public interface ListeMutable<E> extends Liste<E> {

	//Accesseurs/Mutateurs
	default E tete() {
		throw new UnsupportedOperationException();
	}

	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Méthode pour changer le reste de la liste
	 * @param reste Nouveau reste à changer par l'ancien
	 */
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Méthode pour changer la tête de la liste
	 * @param tete Nouvelle tête à changer par l'ancienne
	 */
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	//Services
	default ListeMutable<E> miroir() {
		ListeMutable<E> retour = vide();
		ListeMutable<E> tmp = this;
		Iterator<E> itr = this.iterator();

		if(!tmp.estVide() && !itr.hasNext())
			retour = cons(tmp.tete(), retour);
		else{
			while (itr.hasNext() && tmp.tete()!=null) {
				retour = cons(tmp.tete(), retour);
				tmp = tmp.reste();
			}
		}

		return retour;
	}

	//Fabriques

	/**
	 * Méthode pour créer une nouvelle liste Mutable
	 * @param t Tête de la liste
	 * @param r Reste de la liste
	 * @param <E> Type de la liste
	 * @return Nouvelle liste créée
	 */
	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {
		return new ListeMutable<E>() {
			private E tete = t;
			private ListeMutable<E> reste = r;

			public E tete() {
				return tete;
			}

			public ListeMutable<E> reste() {
				return reste;
			}

			public boolean casCons() {
				return true;
			}

			public int taille() {
				return 1 + reste.taille();
			}

			public boolean estVide() {
				return false;
			}

			public IterateurListe<E> iterator() {
				return new IterateurListe<E>() {
					Liste<E> tmp = Liste.cons(tete, reste);

					public boolean hasNext() {
						return !tmp.reste().estVide();
					}

					public E next() {
						if (!hasNext()) {
							throw new UnsupportedOperationException();
						}
						E tmp2 = tmp.tete();
						tmp = tmp.reste();
						return tmp2;
					}
				};
			}

			public String toString() {
				return (tete.toString().concat(reste.toString()));
			}

			public void changerReste(ListeMutable<E> reste) {
				this.reste = reste;
			}

			public void changerTete(E tete) {
				this.tete = tete;
			}
		};
	}

	/**
	 * Méthode pour créer une nouvelle liste vide
	 * @param <E> Type de la liste à créer
	 * @return Nouvelle liste créée
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			
			public E tete(){
				return null;
			}
			
			public ListeMutable<E> reste(){
				return null;
			}
			
			public boolean casVide() {
				return true;
			}

			public ListeMutable<E> miroir() {
				return null;
			}

			public String toString() {
				return "vide";
			}

			public IterateurListe<E> iterator() {
				return new IterateurListe<E>() {

					public boolean hasNext() {
						return false;
					}

					public E next() {
						return null;
					}
				};
			}
		};
	}

}
