package tp.v5;
/**
 * Interface d'une liste immutable
 * @author Bastien ESCOUVOIS, Lucas TAILLEBOURG, Ibrahima SOW
 * @param <E> type de l'état
 */
public interface EtatFileImmutable<E>  {
	
	/*
	 * Accesseurs
	 */
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	
	int taille();
	
	public FileImmutable<E> creer();
	
	E tete();

	FileImmutable<E> reste();

	FileImmutable<E> creer(E dernier);
}
