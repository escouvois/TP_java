package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {

	//Accesseurs

	/**
	 * Méthode pour determiner si la liste est vide
	 * @return Boolean déterminant si la liste est vide
	 */
	default boolean casVide() {
		return false;
	}

	/**
	 * Méthode pour retourner la tête de la liste
	 * @return Exception car la méthode doit être redéfini
	 */
	default E tete() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Méthode pour retourner le reste de la liste
	 * @return Exception car la méthode doit être redéfini
	 */
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Méthode pour déterminer si la liste est construite
	 * @return Boolean déterminant si la liste est construite
	 */
	default boolean casCons() {
		return false;
	}

	/**
	 * Méthode déterminant la taille de la liste
	 * @return Entier representant la taille de la liste
	 */
	default public int taille() {
		return 0;
	}

	/**
	 * Méthode pour déterminer si la liste est vide
	 * @return Boolean determinant si la liste est vide
	 */
	default public boolean estVide() {
		return this.taille() == 0;
	}

	//Services

	/**
	 * Itérateur pour parcourir la liste
	 * @return L'itérateur de la liste
	 */
	default Iterator<E> iterator() {
		return new IterateurListe<E>(); 
	}

	/**
	 * Méthode pour renverser la liste
	 * @return Nouvelle liste renversée
	 */
	default Liste<E> miroir() {
		throw new UnsupportedOperationException();
	}

	//Fabriques (statiques)

	/**
	 * Fabrique pour créer une liste vide
	 * @param <E> Type de la liste à créer
	 * @return Nouvelle liste vide qui vient d'être créée
	 */
	public static <E> Liste<E> vide() {
		return new Liste<E>() {

			public boolean casVide() {
				return true;
			}

			public Liste<E> miroir() {
				return this;
			}

			public String toString() {
				return this.toString();
			}

			public Iterator<E> iterator() {
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

	/**
	 * Fabrique pour créer une nouvelle liste contenant au moins un élément
	 * @param t Tête de la liste
	 * @param r Reste de la liste
	 * @param <E> Type de la liste à créer
	 * @return Nouvelle liste créée
	 */
	public static <E> Liste<E> cons(E t, Liste<E> r) {
		return new Liste<E>() {
			public E tete() {
				return t;
			}

			public Liste<E> reste() {
				return r;
			}

			public boolean casCons() {
				return true;
			}

			public int taille() {
				return 1 + r.taille();
			}

			public boolean estVide() {
				return false;
			}

			public Iterator<E> iterator() {
				return new IterateurListe<E>() {
					Liste<E> tmp = cons(t, r);

					public boolean hasNext() {
						return !tmp.estVide();
					}

					public E next() {
						if (!hasNext()) {
							throw new UnsupportedOperationException();
						}
	
						tmp = tmp.reste();
						tmp = cons(tmp.tete(), tmp.reste());
						return tmp.tete();
					}
				};
			}

			public Liste<E> miroir() {
				Liste<E> retour = vide();
				Liste<E> tmp = this;
				Iterator<E> itr = this.iterator();
				while (itr.hasNext()) {
					retour = cons(tmp.tete(), retour);
					tmp = tmp.reste();
				}
				return retour;
			}

			public String toString() {
				return (t.toString() + " " + r.toString());
			}
		};
	}

}
