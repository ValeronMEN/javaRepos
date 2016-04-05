package lab2part1;

public class ShakerSort{
	public Student [] arr;

	public ShakerSort(Student[] arr) {
		this.arr = arr;
	}
	
	public void PrintArray(){
		int i;
		for(i=0; i<arr.length; i++){
			if (arr[i].roomNumber < 0){
				System.out.println("Error. Negative value of room!");
				return;
			}
		}
		for(i=0; i<arr.length; i++){
			System.out.print(" "+(i+1)+". "+arr[i].roomNumber+" r. "+arr[i].surname+" "+arr[i].name+"\n");
		}
	}
	
	public void OneBubble(int from, int to){
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
	
	public void ShakeArray(){
		int from = 0;
		int to = this.arr.length-1;
		
		for(int i=0; i<arr.length; i++){
			if (arr[i].roomNumber < 0){
				return;
			}
		}
		
		while(true){
			if(from>to) break;
			OneBubble(from, to);
			to--;
			if(from>to) break;
			OneBubble(to, from);
			from++;
		}
	}

}
