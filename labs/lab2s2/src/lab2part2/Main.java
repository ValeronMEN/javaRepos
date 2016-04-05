package lab2part2;

public class Main {

	public static void main(String[] args) {
		Student arr[] = new Student[]{
				new Student("Valeriy", "Babenko", 231),
				new Student("Arthur", "Pirozhkov", 112),
				new Student("Igor", "Grishenko", 209),
				new Student("Mykhailo", "Ivanov", 301),
				new Student("Behrang", "Behvandi", 221),
				new Student("Sasha", "Voloshenko", 325),
				new Student("Fedya", "Andrienko", 220),
				new Student("Max", "Honchar", 113),
				new Student("Denis", "Medvedsky", 134),
				new Student("Kolya", "Sherstiuk", 113),
			};
		
		BucketSort cl = new BucketSort(arr);
		System.out.println("Unsorted array is:");
		cl.PrintArray();
		cl.Sorting();
		System.out.println("\nSorted array is:");
		cl.PrintArray();
	}
}
