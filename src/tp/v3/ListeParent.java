package tp.v3;

import java.util.Iterator;

public interface ListeParent<E> extends Iterable<E> {

	default public ListeParent<E> miroir(ListeParent<E> liste){
		
		for (E e : liste) {
			
		}
	}
	
}
