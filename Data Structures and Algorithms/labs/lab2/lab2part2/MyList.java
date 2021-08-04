package lab2part2;

public class MyList {
	private int size;
	private Node head;
	
	public MyList(){
		size=0;
	}
	
	void addFirst(Student data){
		Node newNode = new Node(data);
		if (size!=0){
			newNode.next = head;
		}
		head = newNode;
		size++;
	}
	
	void addLast(Student data){
		Node newNode = new Node(data);
		if (size==0){
			head = newNode;
		}
		else{
			Node tail = head;
			while(tail.next!=null){
				tail = tail.next;
			}
			tail.next = newNode;
		}
		size++;
	}
	
	void addIndex(Student data, int index){
		if (index < 0 || index > size){
			System.out.println("Invalid index");
			return;
		}
		if (index==0){
			addFirst(data);
			return;
		}
		if (index==size){
			addLast(data);
			return;
		}
		Node current = head;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		Node newNode = new Node(data);
		newNode.next = current.next;
		current.next = newNode;
		size++;
	}
	
	void view(){
		if (size==0){
			System.out.println("My linked list is empty");
			return;
		}
		Node current = head;
		System.out.print("My linked list is: ");
		while(current!=null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println("");
	}
	
	Student deleteFirst(){
		if (size==0){
			return null;
		}
		Student toDelete = head.data; 
		head = head.next;
		size--;
		return toDelete;
	}
	
	Student deleteIndex(int index){
		if (index<0||index>=size){
			System.out.println("Invalid index");
			return null;
		}
		if(index==0){
			return deleteFirst();
		}
		Node current = head;
		for (int i = 1; i < index; i++){
			current = current.next;
		}
		Node deleteNode = current.next;
		current.next = deleteNode.next;
		size--;
		return deleteNode.data;
	}
	
	Student deleteLast(){
		return deleteIndex(size-1);
	}
	
	int getSize(){
		return size;
	}
	
	Student getFromIndex(int index){
		if (index<0||index>=size){
			System.out.println("Invalid index");
			return null;
		}
		if(index==0){
			return head.data;
		}
		Node current = head;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current.data;
	}
	
	void insertionSort(){
		for(int i = 1; i<size; i++){
			for (int j = i; j > 0 && getFromIndex(j).roomNumber < getFromIndex(j-1).roomNumber; j--){
				swap(j, j-1);
			}
		}
	}
	
	void swap(int index1, int index2){
		Student temp1 = new Student(null, null, 0);
		Student temp2 = new Student(null, null, 0);
		temp1 = deleteIndex(index1);
		temp2 = deleteIndex(index2);
		addIndex(temp1, index2);
		addIndex(temp2, index1);
	}
	
	boolean isEmpty(){
		if (size==0){
			return true;
		}
		return false;
	}
}
