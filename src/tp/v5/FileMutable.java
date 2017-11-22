package tp.v5;

public interface FileMutable<E>
		extends File<FileMutable<E>, E>, IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E> {
	/*
	 * Accesseurs
	 */
	void ajouter(E element);
	void retirer();
	
	/*
	 * Fabrique
	 */
	FileMutable<E> creerCopie();
	
	/*
	 * Services
	 */
	@Override
	default
	FileMutable<E> ajout(E dernierDansFile){
		this.ajouter(dernierDansFile);
		return this;
	}
		
	@Override
	default FileMutable<E> retrait(){
		this.retirer();
		return this;
	}	
	
}
