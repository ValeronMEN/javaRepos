package ex1;

public class Main {

	public static void main(String[] args) {
		MyList list = new MyList();
		
		/*
		for (int i=120000; i>0; i--){
			list.addLast(i);
		}
		*/
		
		for (int i=0; i<120000; i++){
			list.addLast(i);
		}
		
		/*
		for (int i=120000; i>0; i--){
			int j = (int) (Math.random()*100);
			list.addLast(j);
		}
		*/
		
		//list.view();
		long startTime = System.nanoTime();
		list.selectionSort();
		long endTime = System.nanoTime();
		//list.view();
		
		double estTime = (endTime - startTime)/(1000000000.0);
		System.out.println(estTime);
	}
}
