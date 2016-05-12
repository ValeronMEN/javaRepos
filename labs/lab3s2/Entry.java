package lab3s2;

public class Entry {
	private int key;
	private Rectangle value;

	public Entry(Rectangle rec){
		this.key = rec.calculateArea();
		this.value = rec;
	}
	
	public Entry(){
		this.key = -1; // defunct value of area
		this.value = null;
	}
	
	public int getKey(){
		return key;
	}
	
	public Rectangle getValue(){
		return value;
	}
}
