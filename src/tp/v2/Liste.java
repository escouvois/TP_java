package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}

	default E tete() {
		throw new UnsupportedOperationException();
	}

	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}

	default boolean casCons() {
		return false;
	}

	default public int taille() {
		return 0;
	}

	default public boolean estVide() {
		return this.taille() == 0;
	}

	/*
	 * Services
	 */
	default Iterator<E> iterator() {
		return new IterateurListe<E>(); 
	}

	default Liste<E> miroir() {
		throw new UnsupportedOperationException();
	}
	/*
	 * Fabriques (statiques)
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
