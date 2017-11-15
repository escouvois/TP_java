package tp.v2;

public interface FileImmutable<E> extends File<E> {

	/* 
	 * Accesseurs
	 */
	FileImmutable<E> suivants();
	
	/*
	 * Fabriques
	 */
	FileImmutable<E> creer();

	/**
	 * Méthode pour créer une file immutable et un élément
	 * @param dernier : L'élement à ajouter
	 * @return FileImmutable : la nouvelle file créée avec l'élément.
	 */
	FileImmutable<E> creer(E dernier);
	
	/*
	 * Services
	 */
	
	/**
	 * Ajoute un élément à la fin de la liste.
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {
		return creer(dernierDansFile);
	}
	
	/**
	 * Renvoie la liste sans la tête.
	 */
	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
	}
	
	// Complexité O(|secondeFile|)
	@Override
	default FileImmutable<E> ajout(File<E> secondeFile){
		FileImmutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}

}
