package operators;

public class Operators {
	public static int count(int a, int b){
		int sum = 0;
		if(a % 2 == 0){
			sum =a * b;
		}
		else{
			sum = a + b;
		}
		return sum;
		
	}
	
	public static String koordinats(int x, int y){
		String otvet = null;
		if(x > 1 && y > 1){
			otvet = "First!";
		}
		if(x > 1 && y < 1){
			otvet = "4!";
		}
		if(x < 1 && y < 1){
			otvet = "3!";
		}
		if(x < 1 && y > 1){
			otvet = "2!";
		}
			
		return otvet;
		
	}
}