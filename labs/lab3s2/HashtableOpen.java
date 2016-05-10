package lab3s2;

public class HashtableOpen {
	private Entry [] table;
	private int size = 0;
	private final int defaultSize = 19;
	private final double A = Math.sqrt(5) - 2;
	private int m = defaultSize;
	
	public HashtableOpen(){
		this.table = new Entry[this.defaultSize];
		
		int i;
		for(i=0; i<defaultSize; i++){
			table[i] = new Entry();
		}
	}
	
	public HashtableOpen(int userSize){
		this.table = new Entry [userSize];
		this.m = userSize;
		int i;
		for(i=0; i<userSize; i++){
			table[i] = new Entry();
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
		int i;
		for(i=0; i<m; i++){
			if(table[i].getKey()==key){
				return true;
			}
		}
		return false;
	}
	
	public Rectangle get(int key){;
		int i;
		for (i=0; i<m; i++){
			if (table[i].getKey()==key){
				return table[i].getValue();
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
		for(i=0; i<m; i++){
			if (table[i].getKey()==key){
				Rectangle toReturn = table[i].getValue();
				table[i].setValue(value);
				return toReturn;
			}
		}
		Entry newEntry = new Entry(value);
		table[hashKey] = newEntry;
		this.size++;
		return null;

	}

	public Rectangle remove(int key){
		int i;
		for(i=0; i<m; i++){
			if (table[i].getKey()==key){
				Rectangle toDelete = new Rectangle(0, 0, 0, 0);
				toDelete = table[i].getValue();
				table[i].setKey(-1);
				this.size--;
				return toDelete;
			}
		}
		return null;
	}
	
	public void output(){
		System.out.println("Size of non-void elements is "+this.size);
		int i, j=1;
		for(i=0; i<this.m; i++){
			if (table[i].getKey() != (-1)){
				System.out.println(j+". Area: "+table[i].getValue().calculateArea() + "; HashKey: "+i+";");
				table[i].getValue().view();
				j++;
			}
		}
	}
}