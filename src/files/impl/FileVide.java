package files.impl;

public class FileVide<E> implements File<E> {
	
	@Override
	public File add(E e) {
		return new FabFileImpl().creerFile().add(e);
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
