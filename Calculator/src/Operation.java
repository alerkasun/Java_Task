
public class Operation {
public static int Result(int a, int b, String op ){
	int res = 0;
	
	if(op.equals("+")){
		res = a + b ;
	}
	
	if(op.equals("-")){
		res = a - b ;
	}
	
	if(op.equals("*")){
		res = a * b ;
	}
	
	if(op.equals("/")){
		res = a / b ;
	}
	return res;
}
}
