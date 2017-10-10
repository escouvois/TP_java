package filesV2;

public class Test {
	
	public static void main(String[] args) {
		FileImpl<Integer> file = new LinkedQueueFactoryImpl<Integer>().creerListe();
		
		
		file.add(new Integer(1));
		file.add(new Integer(2));
		
		System.out.println(file.toString());
		
		file.remove();
		
		System.out.println(file.toString());
		System.out.println(file.length());
		
	}
	
}
