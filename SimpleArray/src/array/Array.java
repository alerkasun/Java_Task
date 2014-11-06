package array;

public class Array {
	public static int minElement(int[] array){
		if (array == null) {
			throw new IllegalArgumentException("array must be not null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("array must be not empty");
		}
		int min = array[0];
		for (int i: array) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
	
	public static int maxElement(int[] array){
		if (array == null) {
			throw new IllegalArgumentException("array must be not null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("array must be not empty");
		}
		int max = array[0];
		for (int i: array) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	public static int maxIndexElement(int[] array){
		if (array == null) {
			throw new IllegalArgumentException("array must be not null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("array must be not empty");
		}
		int maxIndex=0;
		int max=0;
			for(int i=0;i<array.length;i++)
			{
				if(max<array[i]) 
				{
					max=array[i];
					maxIndex=i;
				}
			}
		return maxIndex;
		}
	
	public static int minIndexElement(int[] array){
		if (array == null) {
			throw new IllegalArgumentException("array must be not null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("array must be not empty");
		}
		int minIndex=0;
		int min=0;
			for(int i=0;i<array.length;i++)
			{
				if(min>array[i]) 
				{
					min=array[i];
					minIndex=i;
				}
			}
		return minIndex;
		}
	
	public static int sumOddElement(int[] array){
		int sum = 0;
		for(int i=0;i<array.length;i++){
			if (array[i] % 2 ==0)
			sum += i;
		}
		return sum;
		
	}
	
}


   