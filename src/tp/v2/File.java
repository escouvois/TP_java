package tp.v2;

public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */

	/**
	 * Méthode pour donner le premier élément de la file
	 * @return E : Un élément contenant le premier élément de la file
	 */
	E premier();

	/**
	 * Méthode pour déterminer la file qui suit après le premier élément
	 * @return File : Une file contenant la file courrante excepté la tête
	 */
	File<E> suivants();

	/**
	 * Méthode pour déterminer si la file est vide
	 * @return boolean : Un boolean détermiant si la liste est vide
	 */
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabriques
	 */

	/**
	 * Méthode pour créer une nouvelle file
	 * @return File : La nouvelle file créée
	 */
	File<E> creer();
	
	/*
	 * Services
	 */

	/**
	 * Méthode pour ajouter un élément à la queue de la file
	 * @param dernierDansFile : Élément à ajouter
	 * @return File : La nouvelle file contenant l'élément ajouté
	 */
	File<E> ajout(E dernierDansFile);

	/**
	 * Méthode pour retirer la tête de la file
	 * @return File : La nouvelle file sans l'ancienne tête
	 */
	File<E> retrait();

	/**
	 * Méthode pour ajouter une file à la queue de la file
	 * @param secondeFile :  File à ajouter
	 * @return File : La nouvelle file contenant la file ajouté
	 */
	File<E> ajout(File<E> secondeFile);
	
	/**
	 * Méthode recursive permettant d'afficher la liste.
	 * @return String : La représentation sous forme de string de la liste.
	 */
	default String representation() {
		return this.premier().toString().concat(this.suivants().representation());
	}

	/**
	 * De même que pour la representation, on fait une comparaison recursive.
	 * @param file :  La file à comparer
	 * @return boolean : Un boolean exprimant si les files sont équivalentes ou non.
	 */
	default boolean estEgal(File<E> file){
		//Si les deux file sont vides, elles sont égales, de plus, il s'agit d'une condition d'arrêt de la récursivité.
		if(this.estVide() && file.estVide()){
			return true;
		}
		
		//Si une file est vide et pas l'autre, elles ne sont pas égales. Il s'agit aussi d'une condition d'arrêt de la récursivité.
		if(this.estVide() && !file.estVide() || !this.estVide() && file.estVide()){
			return false;
		}
		
		//Si les éléments de têtes sont différents, les files sont différentes.
		if(this.premier() != file.premier()){
			return false;
		}
		
		//Si on n'arrive pas à prouver l'égalité jusqu'ici, on descend d'un niveau dans la récursivité.
		return(this.suivants().estEgal(file.suivants()));
	}
}
