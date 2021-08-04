package lab2part1;

public class ShakerSort{
	private Student [] arr;

	public ShakerSort(Student[] arr) {
		this.arr = arr;
	}
	
	public void printArray(){
		int i;
		for(i=0; i<arr.length; i++){
			if (arr[i].roomNumber < 0){
				System.err.println("Index '"+i+"' of array has negative value of room!");
				System.exit(1);
			}
		}
		for(i=0; i<arr.length; i++){
			System.out.print(" "+(i+1)+". "+this.arr[i].roomNumber+" r. "+this.arr[i].surname+" "+this.arr[i].name+"\n");
		}
	}
	
	private void oneBubble(int from, int to){
		int i;
		Student temp = new Student("", "", 0);
		if (from==to){
			return;
		}
		if (from<to){
			for(i=from+1; i<=to; i++){
				if (this.arr[i].roomNumber<this.arr[i-1].roomNumber){
					temp = arr[i];
					this.arr[i]=this.arr[i-1];
					this.arr[i-1]=temp;
				}
			}
		}
		else{
			for(i=from; i>=(to+1); i--){
				if (this.arr[i].roomNumber<this.arr[i-1].roomNumber){
					temp = this.arr[i];
					this.arr[i]=this.arr[i-1];
					this.arr[i-1]=temp;
				}
			}
		}
	}
	
	public void shakeArray(){
		int from = 0;
		int to = this.arr.length-1;
		
		for(int i=0; i<this.arr.length; i++){
			if (this.arr[i].roomNumber < 0){
				System.exit(1);
			}
		}
		
		while(true){
			if(from>to) break;
			oneBubble(from, to);
			to--;
			if(from>to) break;
			oneBubble(to, from);
			from++;
		}
	}

}
