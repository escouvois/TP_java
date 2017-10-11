package filesV1;

import files.exception.EmptyQueueException;

public class Test {

	public static void main(String[] args) {
		FileImpl<Integer> file = new LinkedQueueFactoryImpl<Integer>().creerFile();
		
		
		file.add(new Integer(1));
		file.add(new Integer(2));
		
		System.out.println(file.toString());
		
		try {
			file.remove();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		
		System.out.println(file.toString());
		System.out.println(file.length());
		
		
		FileImpl<Integer> f = new FileImpl<Integer>();
		f.add(2);
		f.add(3);
		System.out.println(f.length());
		System.out.println(f.isEmpty());
		try {
			System.out.println(f.first());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(f.remove());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.add(4);
		try {
			System.out.println(f.remove());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.length());
		try {
			System.out.println(f.first());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
