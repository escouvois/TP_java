package tp.v6;

import tp.v5.IdentifiableParIteration;
import tp.v5.RepresentableParIteration;

public interface EtatFileImmutable<E> extends 
	EtatFile<EtatFileImmutable<E>, E>,
	IdentifiableParIteration<EtatFileImmutable<?>, E>,
	RepresentableParIteration<E>	
{

	/* 
	 * Accesseurs
	 */
	
	/*
	 * Fabriques
	 */
	EtatFileImmutable<E> creer(E dernier);
	
}
