package tp.v5;

public interface FileMutable<E>
		extends File<FileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E> {

	
	
	/*
	 * Services
	 */
	@Override
	FileMutable<E> ajout(E dernierDansFile); 
		/*
		 * this.ajouter(dernierDansFile);
		 * return this;
		 */
		
	@Override
	FileMutable<E> retrait();
		/*
		 * this.retirer();
		 * return this;
		 */
		
	
}
