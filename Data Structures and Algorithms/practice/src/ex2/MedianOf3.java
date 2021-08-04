package ex2;

public class MedianOf3 {
		  public void sort(int[] arr) {
			  quickSort(arr, 0, arr.length - 1);
		  }

		  public static void quickSort(int[] arr, int left, int right) {
			  int size = right - left + 1;
			    if (size <= 3){
			    	manualSort(arr, left, right);
			    }
			    else{
				    int q = partitionMedian(arr, left, right);
				    quickSort(arr, left, q - 1);
				    quickSort(arr, q + 1, right);
			    }
		  }

		  public static int medianOf3(int[] arr, int left, int right) {
			  int center = (left + right) / 2;

			  if (arr[left] > arr[center]){
				  swap(arr, left, center);
			  }

			  if (arr[left] > arr[right]){
				  swap(arr, left, right);
			  }
			      
			  if (arr[center] > arr[right]){
				  swap(arr, center, right);
			  }
			  
			  swap(arr, center, right - 1);
			  return arr[right - 1];
		  }

		  public static void swap(int[] arr, int in1, int in2) {
			  int temp = arr[in1];
			  arr[in1] = arr[in2];
			  arr[in2] = temp;
		  }

		  public static int partitionMedian(int[] arr, int left, int right) {
			    double median = medianOf3(arr, left, right);
			    int i = left;
			    int j = right - 1;

			    while (true) {
			    	while (arr[++i] < median)
				        ;
				    while (arr[--j] > median)
				        ;
				    if (i >= j){
				    	 break;
				    }
				    else{
				    	swap(arr, i, j);
				    }    
			    }
			    swap(arr, i, right - 1);
			    return i;
		  }

		  public static void manualSort(int[] arr, int left, int right) {
			    int size = right - left + 1;
			    if (size <= 1){
			    	return;
			    }
			    if (size == 2){
			    	if (arr[left] > arr[right]){
			    		swap(arr, left, right);
			    	}   
			    	return;
			    }
			    else {
			    	if (arr[left] > arr[right - 1]){
			    		swap(arr, left, right - 1);
			    	}
				    if (arr[left] > arr[right]){
				    	swap(arr, left, right);
				    }
				    if (arr[right - 1] > arr[right]){
				    	swap(arr, right - 1, right);
				    }  
			    }
		  }
}
