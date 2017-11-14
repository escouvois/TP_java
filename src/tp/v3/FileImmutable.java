package tp.v3;

public interface FileImmutable<E> extends File<E> {

	/* 
	 * Accesseurs
	 */
	FileImmutable<E> suivants();
	
	/*
	 * Fabriques
	 */
	FileImmutable<E> creer();
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
}
