package tp.v1.filesV2;

public class Test {
	
	/**
	 * Point d'entrée de l'application.
	 * @param args
	 */
	public static void main(String[] args) {
		FileImpl<Integer> file = new LinkedQueueFactoryImpl<Integer>().creerFile();
		
		
		file.add(new Integer(1));
		file.add(new Integer(2));
		
		System.out.println(file.toString());
		
		file.remove();
		
		System.out.println(file.toString());
		System.out.println(file.length());
		
	}
	
}
