package tp.v2;

public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */
	E premier();
	File<E> suivants();
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabriques
	 */
	File<E> creer();
	
	/*
	 * Services
	 */
	File<E> ajout(E dernierDansFile);
	File<E> retrait();
	File<E> ajout(File<E> secondeFile);
	
	/**
	 * On fait une méthode recursive.
	 * @return la représentation sous forme de string de la liste
	 */
	default String representation() {
		return this.premier().toString().concat(this.suivants().representation());
	}

	/**
	 * De même que pour la representation, on fait une comparaison recursive.
	 * 
	 * @param file :  la file à comparer
	 * @return boolean : un boolean exprimant si les files sont équivalentes ou non.
	 */
	default boolean estEgal(File<E> file){
		//Si les deux file sont vides, elles sont égales, de plus, il s'agit d'une fin de récursivité.
		if(this.estVide() && file.estVide()){
			return true;
		}
		
		//Si une file est vide et pas l'autre, elles ne sont pas égales, il s'agit azussi d'une fin de récursivité.
		if(this.estVide() && !file.estVide() || !this.estVide() && file.estVide()){
			return false;
		}
		
		//Si les éléments de têtes sont différents, les files sont différentes.
		if(this.premier() != file.premier()){
			return false;
		}
		
		//Si on arrive pas a prouver l'égalité jusqu'ici, on descend d'un niveau dans la récursivité.
		return(this.suivants().estEgal(file.suivants()));
	}
}