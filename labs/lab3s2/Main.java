package lab3s2;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.exersize1();
		main.exersize23();
	}
	
	private void exersize1(){
		System.out.printf("Test 1:\n");
		Rectangle myrec1 = new Rectangle(17, 8, 8, 9);
		Rectangle myrec2 = new Rectangle(86, 5, 56, 6);
		Rectangle myrec3 = new Rectangle(44, 8, 7, 0);
		
		HashtableOpen hsop = new HashtableOpen(41);
		hsop.put(myrec1);
		hsop.put(myrec2);
		hsop.put(0, myrec3);
		//hsop.put(100000, myrec3);
		hsop.output();
		
		int mykey1 = myrec1.calculateArea();
		int mykey2 = 45;
		
		if(hsop.contains(mykey1)){
			System.out.printf("\n  > "+mykey1+" key contains!\n");
		}
		if(hsop.contains(mykey2)){
			System.out.printf("  > "+mykey2+" key contains!\n");
		}
		
		if(hsop.get(mykey1).calculateArea()==mykey1){
			System.out.printf("  > "+mykey1+" key return to main!\n\n");
		}
		if(hsop.get(mykey1).calculateArea()==mykey2){
			System.out.printf("  > "+mykey2+" key return to main!\n\n");
		}
		
		hsop.remove(mykey1);
		hsop.output();
	}
	
	private void exersize23(){
		System.out.printf("\nTests 2-3:\n");
		Rectangle myrec1 = new Rectangle(17, 8, 8, 9);
		Rectangle myrec2 = new Rectangle(86, 5, 73, 1);
		Rectangle myrec3 = new Rectangle(44, 8, 10, 9);
		Rectangle myrec4 = new Rectangle(44, 8, 9, 8);
		
		//Hashtable hsop = new Hashtable(41);
		Hashtable hsop = new Hashtable();
		hsop.put(myrec1);
		hsop.put(myrec2);
		hsop.put(90, myrec3);
		//hsop.put(90000, myrec3);
		hsop.put(myrec4); // it will replace myrec1
		hsop.output();
		
		int mykey1 = myrec1.calculateArea();
		int mykey2 = 45;
		
		if(hsop.contains(mykey1)){
			System.out.printf("\n  > "+mykey1+" key contains!\n");
		}
		if(hsop.contains(mykey2)){
			System.out.printf("  > "+mykey2+" key contains!\n");
		}
		
		if(hsop.get(mykey1).calculateArea()==mykey1){
			System.out.printf("  > "+mykey1+" key return to main!\n\n");
		}
		if(hsop.get(mykey1).calculateArea()==mykey2){
			System.out.printf("  > "+mykey2+" key return to main!\n\n");
		}
		
		hsop.remove(mykey1);
		hsop.output();
	}

}
