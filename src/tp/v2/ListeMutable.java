package tp.v2;

public interface ListeMutable<E> extends Liste<E> {

	/*
	 * Accesseurs.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}

	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}

	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	default ListeMutable<E> miroir() {
		// TODO
		return null;
	}

	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {
		return new ListeMutable<E>() {
			// TODO Définir les méthodes utiles.
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
					Liste<E> tmp = cons(tete, reste);

					public boolean hasNext() {
						return !tmp.estVide();
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

			public ListeMutable<E> miroir() {
				ListeMutable<E> retour = vide();
				ListeMutable<E> tmp = this;
				while (!tmp.estVide()) {
					retour = cons(tmp.tete(), retour);
					tmp = tmp.reste();
				}

				return retour;

			}

			public String toString() {
				return (tete.toString() + " " + reste.toString());
			}

			public void changerReste(ListeMutable<E> reste) {
				this.reste = reste;
			}

			public void changerTete(E tete) {
				this.tete = tete;
			}
		};
	}

	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			// TODO Définir les méthodes utiles.

			public boolean casVide() {
				return true;
			}

			public ListeMutable<E> miroir() {
				return this;
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
