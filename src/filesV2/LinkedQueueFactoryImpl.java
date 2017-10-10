package filesV2;

import java.util.Queue;

public class LinkedQueueFactoryImpl<E> implements LinkedQueueFactory{

	@Override
	public FileImpl<E> creerListe() {
		return new FileImpl<E>();
	}

}
