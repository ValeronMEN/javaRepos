package lab3s2;

public class Hashtable {
	private MyList [] table;
	private int size = 0;
	private final int defaultSize = 5;
	private final double A = (Math.sqrt(5) - 1)/2;
	private int m = defaultSize;
	
	public Hashtable(){
		this.table = new MyList[this.defaultSize];
	}
	
	public Hashtable(int userSize){
		this.table = new MyList [userSize];
		this.m = userSize;
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
		if (table[hashKey]!=null){
			for(i=0; i<table[hashKey].getSize(); i++){
				if(table[hashKey].getFromIndex(i).getKey()==key){
					return true;
				}
			}
		}
		return false;
	}
	
	public Rectangle get(int key){
		int hashKey = hash(key);
		if (table[hashKey]!=null){
			int i;
			for (i=0; i<table[hashKey].getSize(); i++){
				if (table[hashKey].getFromIndex(i).getKey()==key){
					return table[hashKey].getFromIndex(i).getValue();
				}
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
		if (table[hashKey]!=null){
			int i;
			for(i=0; i<table[hashKey].getSize(); i++){
				if (table[hashKey].getFromIndex(i).getKey()==key){
					Rectangle toReturn = table[hashKey].getFromIndex(i).getValue();
					//table[hashKey].deleteIndex(i);
					//Entry newEntry = new Entry(value);
					//table[hashKey].addIndex(newEntry, i);
					table[hashKey].getFromIndex(i).setValue(value);
					return toReturn;
				}
			}
			Entry newEntry = new Entry(value);
			table[hashKey].addFirst(newEntry);
			this.size++;
			return null;
		}
		table[hashKey] = new MyList();
		Entry newEntry = new Entry(value);
		table[hashKey].addFirst(newEntry);
		this.size++;
		return null;

	}

	public Rectangle remove(int key) {
		int hashKey = hash(key);
		int i;
		if (table[hashKey]!=null){
			for(i=0; i<table[hashKey].getSize(); i++){
				if (table[hashKey].getFromIndex(i).getKey()==key){
					Rectangle toDelete = table[hashKey].getFromIndex(i).getValue();
					table[hashKey].deleteIndex(i);
					this.size--;
					if (table[hashKey].isEmpty()==true){
						table[hashKey] = null;
					}
					return toDelete;
				}
			}
		}
		return null;
	}
	
	public void output(){
		System.out.println("Size of non-void elements is "+this.size+"\n"
				+ "Size of hashtable is "+this.m);
		int i, j;
		for (i=0; i<this.m; i++){
			if (table[i]!=null){
				System.out.printf(i+". ");
				for (j=0; j<table[i].getSize(); j++){
					if (j!=0){
						System.out.printf("   ");
					}
					System.out.println("Key: "+table[i].getFromIndex(j).getValue().calculateArea()+";");
					table[i].getFromIndex(j).getValue().view();
				}
			}
			else{
				System.out.println(i+". Empty;");
			}
		}
	}
}
