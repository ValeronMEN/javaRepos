package lab3s2;

public class Hashtable {
	private MyList [] table;
	private int size = 0;
	private final int defaultSize = 19;
	private final double A = Math.sqrt(5) - 2;
	private int m = defaultSize;
	
	public Hashtable(){
		this.table = new MyList[this.defaultSize];
		int i;
		for(i=0; i<defaultSize; i++){
			table[i] = new MyList();
		}
	}
	
	public Hashtable(int userSize){
		this.table = new MyList [userSize];
		this.m = userSize;
		int i;
		for(i=0; i<userSize; i++){
			table[i] = new MyList();
		}
	}
	
	public boolean isEmpty(){
		if (this.size != 0){
			return false;
		}
		return true;
	}
	
	public int size(){
		return size;
	}
	
	public boolean contains(int key){
		int i, hashKey = hash(key);
		for(i=0; i<table[hashKey].getSize(); i++){
			if(table[hashKey].getFromIndex(i).getKey()==key){
				return true;
			}
		}
		return false;
	}
	
	public Rectangle get(int key){
		int hashKey = hash(key);
		int i;
		for (i=0; i<table[hashKey].getSize(); i++){
			if (table[hashKey].getFromIndex(i).getKey()==key){
				return table[hashKey].getFromIndex(i).getValue();
			}
		}
		return null;
	}
	
	private int hash(int key){
		int result = (int)((double)((double)(key * this.A)-(int)(key * this.A))*this.m);
		return result;
	}
	
	public Rectangle put(Rectangle value){
		int key = value.calculateArea();
		return put(key, value);
	}

	public Rectangle put(int key, Rectangle value) {
		if (value.calculateArea()!=key){
			System.err.println(key+" - bad key of rectangle!\n");
			System.exit(1);
		}
		int hashKey = hash(key);
		int i;
		for(i=0; i<table[hashKey].getSize(); i++){
			if (table[hashKey].getFromIndex(i).getKey()==key){
				Rectangle toReturn = table[hashKey].getFromIndex(i).getValue();
				table[hashKey].getFromIndex(i).setValue(value);
				return toReturn;
			}
		}
		Entry newEntry = new Entry(value);
		table[hashKey].addLast(newEntry);
		this.size++;
		return null;

	}

	public Rectangle remove(int key) {
		int hashKey = hash(key);
		int i;
		for(i=0; i<table[hashKey].getSize(); i++){
			if (table[hashKey].getFromIndex(i).getKey()==key){
				Rectangle toDelete = new Rectangle(0, 0, 0, 0);
				toDelete = table[hashKey].getFromIndex(i).getValue();
				table[hashKey].deleteIndex(i);
				this.size--;
				return toDelete;
			}
		}
		return null;
	}
	
	public void output(){
		System.out.println("Size of non-void elements is "+this.size);
		int i, j, z=1;
		for (i=0; i<this.m; i++){
			for (j=0; j<table[i].getSize(); j++){
				System.out.println(z+". Area: "+table[i].getFromIndex(j).getValue().calculateArea()+"; HashKey: "+i+";");
				table[i].getFromIndex(j).getValue().view();
				z++;
			}
		}
	}
}
