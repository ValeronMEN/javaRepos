package ex2;

public class QuickSort {
	    private void quickSort(int [] arr, int lo, int hi){
	    	if (lo < hi){
	    		int q = partitionHoare(arr, lo, hi);
	    		quickSort(arr, lo, q-1);
	    		quickSort(arr, q+1, hi);
	    	}
	    }
	    
	    public void sort(int [] arr){
	    	quickSort(arr, 0, arr.length-1);
	    }
	    
	    private int partitionHoare(int [] arr, int lo, int hi){
	    	int pivot = arr[lo];
	    	int i = lo;
	    	int j = hi + 1;
	    	while (true){
	    		while (++i <= hi && arr[i] < pivot)
	    			;
	    		while (--j >= lo && arr[j] > pivot)
	    			;
	    		if (i < j){
	    			swap (arr, i, j);
	    		}
	    		else{
	    			break;
	    		}
	    	}
	    	swap (arr, lo, j);
	    	return j;
	    }
	    
	    private void swap(int [] arr, int lo, int hi){
	    	int temp = arr[lo];
	    	arr[lo] = arr[hi];
	    	arr[hi] = temp;
	    }
}
