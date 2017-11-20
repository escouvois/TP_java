package tp.v5;

public interface EtatFileMutable<E> {
	/*
	 * Accesseurs
	 */
	void ajouter(E element);
	void retirer();
	default FileMutable<E> suivants() {
		FileMutable<E> r = creerCopie();
		r.retirer();
		return r;
	}
	E premier(); // Premier de la file
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabrique
	 */
	FileMutable<E> creerCopie(); // Fabrique réalisant une copie de la file
	FileMutable<E> creer();
}
