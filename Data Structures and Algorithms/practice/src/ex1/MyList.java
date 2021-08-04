package ex1;

public class MyList {
	private int size;
	private Node head;
	
	public MyList(){
		size=0;
	}
	
	void addFirst(int data){
		Node newNode = new Node(data);
		if (size!=0){
			newNode.next = head;
		}
		head = newNode;
		size++;
	}
	
	void addLast(int data){
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
	
	void addIndex(int data, int index){
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
	
	int deleteFirst(){
		if (size==0){
			System.exit(1);
		}
		int toDelete = head.data; 
		head = head.next;
		size--;
		return toDelete;
	}
	
	int deleteIndex(int index){
		if (index<0||index>=size){
			System.out.println("Invalid index");
			System.exit(1);
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
	
	int deleteLast(){
		return deleteIndex(size-1);
	}
	
	int getSize(){
		return size;
	}
	
	Node getFromIndex(int index){
		if (index<0||index>=size){
			System.out.println("Invalid index");
			System.exit(1);
		}
		if(index==0){
			return head;
		}
		Node current = head;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}
	
	boolean isEmpty(){
		if (size==0){
			return true;
		}
		return false;
	}
	
	void selectionSort(){
		Node currentI = head;
		Node currentJ;
		Node currentMin;
		for (int i=0; i<this.size-1; i++){
			currentMin = currentI;
			currentJ = currentI.next;
			for (int j=i+1; j<this.size; j++){
				if (currentJ.data < currentI.data){
					currentMin = currentJ;
				}
				currentJ = currentJ.next;
			}
			if (currentI != currentMin){
				int tmp = currentI.data;
				currentI.data = currentMin.data;
				currentMin.data = tmp;
			}
		currentI = currentI.next;
		}
	}
}
