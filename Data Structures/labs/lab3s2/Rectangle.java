package lab3s2;

public class Rectangle {
	int xcoord;
	int ycoord;
	int length;
	int width;

	public Rectangle(int xcoord, int ycoord, int length, int width){
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.length = length;
		this.width = width;
	}
	
	public int calculateArea(){
		return Math.abs(length * width);
	}
	
	public int calculatePerimeter(){
		return (Math.abs(length) * 2 + Math.abs(width) * 2);
	}
	
	public void view(){
		System.out.println("   Upper left vertex: X" + xcoord + " Y"+ ycoord + ";\n"
				+ "   Upper right vertex: X" + (xcoord+length) + " Y" + ycoord + ";\n"
						+ "   Lower left vertex: X" + xcoord + " Y" + (ycoord-width) + ";\n"
								+ "   Lower right vertex: X" + (xcoord+length) + " Y" + (ycoord-width) + ";\n"
										+ "   Length: " + length + "; Width " + width + ";");
	}
}
