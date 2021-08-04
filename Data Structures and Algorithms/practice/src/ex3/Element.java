package ex3;

public class Element {
	private int id;
	private int data;
	
	public Element(int id, int data){
		this.data = data;
		this.id = id;
	}
	
	public int getData(){
		return this.data;
	}
	
	public int getId(){
		return this.id;
	}
}
