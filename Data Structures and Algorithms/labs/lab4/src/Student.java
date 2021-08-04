package lab4s2;

public class Student {
	String name;
	String city;
	String surname;
	boolean malegender;
	int course;
	int year;
	
	public Student(String name, String surname, String city, boolean malegender, int course, int year){
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.course = course;
		this.malegender = malegender;
		this.year = year;
	}
	
	public void printStudent(){
		System.out.print(name+" "+surname+": gender: ");
		if (malegender==true){
			System.out.print("male, ");
		}
		else{
			System.out.print("female, ");
		}
		System.out.print("city: "+city+", course: "+course+", birthday year: "+year+"\n");
	}
}
