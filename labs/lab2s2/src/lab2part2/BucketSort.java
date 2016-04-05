package lab2part2;

public class BucketSort {
	private Student arr[];
	
	public BucketSort(Student arr[]){
		this.arr = arr;
	}
	
	public void PrintArray(){
		int i;
		for(i=0; i<arr.length; i++){
			if (arr[i].roomNumber < 0){
				System.out.println("Error. Negative value of room!");
				//System.err.println("Error. Negative value of room!");
				return;
			}
		}
		for(i=0; i<arr.length; i++){
			System.out.print(" "+(i+1)+". "+arr[i].roomNumber+" r. "+arr[i].surname+" "+arr[i].name+"\n");
		}
	}
	
	public void Sorting(){
		if (arr.length == 0){
			return;
		}
		int maxRoom = arr[0].roomNumber;
		int i, j=0;
		for(i=0; i<arr.length; i++){
			if(arr[i].roomNumber>maxRoom){
				maxRoom = arr[i].roomNumber;
			}
			if(arr[i].roomNumber<0){
				return;
			}
		}
		//int nBuckets = maxRoom + 1;
		int nBuckets = Math.round(maxRoom/100)+1;
		MyList buckets[] = new MyList[nBuckets];
		
		for(i=0; i<buckets.length; i++){
			buckets[i] = new MyList();
		}
		for(i=0; i<this.arr.length; i++){
			//buckets[arr[i].roomNumber].addLast(arr[i]);
			int b = Math.round(arr[i].roomNumber / 100);
			buckets[b].addLast(arr[i]);
		}
		for(i=0; i<buckets.length; i++){
			buckets[i].insertionSort();
		}
		for(i=0; i<buckets.length; i++){
			while(!buckets[i].isEmpty()){
				arr[j++] = buckets[i].deleteFirst();
			}
		}
	}
}
