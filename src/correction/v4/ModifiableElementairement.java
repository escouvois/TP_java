package correction.v4;

public interface ModifiableElementairement<K, E>{ 
	K ajout(E e);
	K retrait();
}
