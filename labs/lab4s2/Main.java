package lab4s2;

public class Main {

	public static void main(String[] args) {
		MyTree tree = new MyTree();
		System.out.println("Size of tree: "+tree.size());
		
		Student st1 = new Student("Valeriy", "Grey", "Kyiv", true, 1);
		Student st2 = new Student("Misha", "Blue", "Kyiv", true, 1);
		Student st3 = new Student("Lena", "Green", "Kharkov", false, 2);
		Student st4 = new Student("Igor", "Yellow", "Lvov", true, 3);
		Student st5 = new Student("Dima", "Black", "Kyiv", true, 1);
		Student temp;
		
		tree.insert(1, st1);
		tree.insert(67, st2);
		temp = tree.insert(67, st3);
		if (temp != null){
			System.out.println("This student had same id - "+ temp.name+" "+temp.surname);
		}
		tree.insert(6, st4);
		tree.insert(0, st5);
		System.out.println("Size of tree: "+tree.size()+"\n");
		
		tree.traverse();
		
		int specId = 67;
		tree.remove(specId);
		
		tree.traverse();
	}

}
