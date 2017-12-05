package tp.v6;

import java.util.Iterator;

public interface EtatImmutableAvecInversionParesseuse<E> extends EtatFileImmutable<E> {
	
	/*
	 * Accesseurs
	 */
	
	@Override
	default public E premier() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	default public EtatFileImmutable<E> suivants(){
		throw new UnsupportedOperationException();
	}
	
	@Override
	default public int taille() {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Service
	 */
	
	@Override
	default Iterator<E> iterator() {
		return new IterateurEtatFileImmutable(this);
	}
	
	
	/*
	 * Fabrique
	 */
	
	@Override
	EtatFileImmutable<E> creer();
	
}
