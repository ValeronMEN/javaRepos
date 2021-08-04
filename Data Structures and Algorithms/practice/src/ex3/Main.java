package ex3;

public class Main{
	
	private static int removeArray(Element [] arr, int id, int size){
		for (int index=0; index<arr.length; index++){
			if (id == arr[index].getId()){
				for(int j=index; j<arr.length-1; j++){
					arr[j] = arr[j+1];
				}
				return size-1;
			}
		}
		System.out.print("Element with this id: '"+id+"' is absent here");
		return size;
	}
	
	private static void printArray(Element [] arr, int size){
		System.out.print("There are numbers in Array:\n");
		for (int i=0; i<size; i++){
			System.out.print(arr[i].getId()+") "+arr[i].getData()+"; ");
		}
		System.out.print("\n");
	}
	
	private static void initArray(Element [] arr, int size){
		for (int i=0; i<size; i++){
			arr[i] = new Element(i, (int)(Math.random()*100));
		}
	}
	
	private static void initTree(Element [] arr, int size, MyTree tree){
		for (int i=size-1; i>=0; i--){
		//for (int i=0; i<size; i++){
			tree.insert(i, arr[i].getData());
		}
	}

	public static void main(String[] args) {
		int size = 9000;
		MyTree tree = new MyTree();
		Element [] myArray = new Element[size];
		
		initArray(myArray, size);
		initTree(myArray, size, tree);
		
		int specId = 0;
		//System.out.println("---Tree---");
		//System.out.println("Size of tree: "+tree.size()+"");
		
		//tree.traverse();
		
		long startTimeTree = System.nanoTime();
		tree.remove(specId);
		long endTimeTree = System.nanoTime();
		
		//System.out.println("\n'"+specId+"' id was deleted... \n");
		
		//tree.traverse();
		
		//System.out.println("\n---Array---");
		//printArray(myArray, size);
		
		long startTimeArray = System.nanoTime();
		int newSize = removeArray(myArray, size-1, size);
		long endTimeArray = System.nanoTime();
		
		//System.out.println("\n'"+specId+"' id was deleted... \n");
		//printArray(myArray, newSize);
		
		double estTimeTree = (endTimeTree - startTimeTree)/(1000000000.0);
		double estTimeArray = (endTimeArray - startTimeArray)/(1000000000.0);
		
		System.out.println("\n\nTree removing time: "+estTimeTree+"\n"+"Array removing time: "+estTimeArray);
		System.out.printf("\n\nTree_ removing time: %.8f\nArray removing time: %.8f",estTimeTree,estTimeArray);
	}
}