package tp.v5;


public interface FileImmutable<E>
		extends File<FileImmutable<E>, E>, IdentifiableParIteration<FileImmutable<E>, E>, RepresentableParIteration<E> {
	
	// Fabrique d'une file formée de la file cible et 
    // d'un nouveau dernier élément
	FileImmutable<E> creer(E dernier); 
	
	/*
	 * Services
	 */
	default FileImmutable<E> ajout(E dernierDansFile) {
		return this.creer(dernierDansFile);
	}
	default FileImmutable<E> retrait() {
		return this.suivants();
	}
}
