package filesV2;

public interface File<E> {

	E remove();
	void add(E e);
	E getHead();
	int length();	
}
