package func;

public class Function {
	public static String week(int n)
	{
		String day = "";
			if(n == 0){
				day = "Monday";
			}
			if(n == 1){
				day = "Tuesday";
			}
			if(n == 2){
				day = "Wednesday";
			}
			if(n == 3){
				day = "Thursday";
			}
			if(n == 4){
				day = "Friday";
			}
			if(n == 5){
				day = "Saturday";
			}
			if(n == 6){
				day = "Sunday";
			}
			if(n > 6 || n < 0){
				day = "Wrong day number";
			}
		return day;
	}
	
	public static String spel_number(int n)
	{
		String number = "";
		return number;
		
	}
	

}
