package tp.v6;

import tp.v5.ListeImmutable;

public class Miroir<E> {
	
	private ListeImmutable<E> source;
	private ListeImmutable<E> miroir;
	
	public Miroir(ListeImmutable<E> source) {
		this.source = source;
	}
	
	public boolean estInversible() {
		return false;
	}
	
	public void inverser() {
		
	}
	
	public ListeImmutable<E> miroir(){
		return null;
	}
}
