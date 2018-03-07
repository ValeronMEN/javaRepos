package lab4s2;

public class Main {

	public static void main(String[] args) {
		MyTree tree = new MyTree();
		System.out.println("Size of tree: "+tree.size());
		
		Student st1 = new Student("Valeriy", "Grey", "Kyiv", true, 2, 1998);
		Student st2 = new Student("Misha", "Blue", "Kyiv", true, 1, 1999);
		Student st3 = new Student("Lena", "Green", "Kharkov", false, 2, 1997);
		Student st4 = new Student("Igor", "Yellow", "Lvov", true, 3, 1999);
		Student st5 = new Student("Dima", "Black", "Kyiv", true, 1, 1998);
		Student st6 = new Student("Johnny", "Pink", "Kharkov", true, 1, 1974);
		Student st7 = new Student("Karl", "Red", "Kyiv", true, 2, 1998);
		Student st8 = new Student("Max", "Orange", "Kyiv", true, 1, 1998);
		Student st9 = new Student("Margo", "Red", "Kyiv", false, 2, 1998);
		Student st10 = new Student("Nastya", "Jam", "Kyiv", false, 2, 1998);
		Student temp;
		
		tree.insert(2, st1); //
		tree.insert(67, st2); 
		temp = tree.insert(67, st3); //
		if (temp != null){
			System.out.println("This student had same id - "+ temp.name+" "+temp.surname);
		}
		tree.insert(6, st4); //
		tree.insert(1, st5); //
		tree.insert(9, st6); //
		tree.insert(85, st9); //
		tree.insert(88, st7); //
		tree.insert(82, st8); //
		tree.insert(0, st10); //
		System.out.println("Size of tree: "+tree.size()+"\n");
		
		tree.traverse();
		
		int specId = 67;
		tree.remove(specId);
		System.out.println("'"+specId+"' id was deleted: \n");
		
		tree.traverse();
		
		int size = tree.remove(1, 2016);
		System.out.println("Difference between sizes of tree: "+size+"\n");
		
		tree.traverse();
	}

}
