package ex2;

public class Main {
	
	private static void printArray(int [] arr){
		System.out.print("My Array is: ");
		for (int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		MedianOf3 median = new MedianOf3();
		QuickSort quick = new QuickSort();
		
		double timeMedian = 0;
		double timeQuick = 0;
		
		for (int j=0; j<1; j++){
			int size = 100;
			int[] intArray1 = new int [size];
			int k=1;
			for (int i=0; i<size; i++){
				intArray1[i] = i*i;
				k = k*k;
			}
			
			int[] intArray2 = new int [intArray1.length];
			for (int i=0; i<intArray1.length; i++){
				intArray2[i] = intArray1[i];
			}
			
			//System.out.print("<---MedianOf3--->\n");
			//printArray(intArray1);
			long startTimeMedian = System.nanoTime();
		    median.sort(intArray1);
		    long endTimeMedian = System.nanoTime();
		    //printArray(intArray1);
		    
		    //System.out.print("\n<---QuickSort--->\n");
		    //printArray(intArray2);
		    long startTimeQuick = System.nanoTime();
		    quick.sort(intArray2);
		    long endTimeQuick = System.nanoTime();
		    //printArray(intArray2);
		    
		    double estTimeMedian = (endTimeMedian - startTimeMedian)/(1000000000.0);
			//System.out.println("\nMedianOf3 time: "+estTimeMedian);
			double estTimeQuick = (endTimeQuick - startTimeQuick)/(1000000000.0);
			//System.out.println("QuickSort time: "+estTimeQuick);
			
			if (j == 0){
				timeMedian = estTimeMedian;
				timeQuick = estTimeQuick;
			}
			else{
				if (timeQuick < estTimeQuick){
					timeQuick = estTimeQuick;
					timeMedian = estTimeMedian;
				}
			}
		}
		System.out.printf("QuickSort all time: %.7f\nMedianOf3 all time: %.7f",timeQuick,timeMedian);
	}

}
