package lab4s2;

public class Student {
	String name;
	String city;
	String surname;
	boolean malegender;
	//int serial;
	int course;
	
	public Student(String name, String surname, String city, boolean malegender, /*int serial,*/ int course){
		this.name = name;
		this.surname = surname;
		this.city = city;
		//this.serial = serial;
		this.course = course;
		this.malegender = malegender;
	}
}
