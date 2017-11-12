package tp.v2;

public interface FileMutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */
	
	/**
	 * Retourne la suite de la liste sans la tête actuelle.
	 */
	@Override
	default FileMutable<E> suivants(){
		FileMutable<E> temp = this.creerCopie();
		temp.retirer();
		return temp;
	}

	/**
	 * Ajoute un élement en tête de liste.
	 * @param element : l'élément que l'on ajoute en tête de liste.
	 */
	void ajouter(E element);
	
	/**
	 * Retire la tête de la liste
	 */
	void retirer();
	
	/*
	 * Fabriques
	 */

	FileMutable<E> creer();
	
	/**
	 * Creer une copie de la liste actuelle.
	 * @return
	 */
	FileMutable<E> creerCopie();
	
	
	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		this.ajouter(dernierDansFile);
		return this;
	}
	
	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}
	// Complexité O(|secondeFile|)
	@Override
	default FileMutable<E> ajout(File<E> secondeFile) {
		FileMutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}
	
	// Complexité en O(1).
	void ajouter(File<E> secondeFile);

}
