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
	 * Renvoie la liste sans la tête.
	 */
	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
	}
}
