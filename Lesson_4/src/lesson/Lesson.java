package lesson;

public class Lesson {
	public static int[] konkat_array(int []a, int []b){
		if(a==null)
			{
			return b;
			}
	 	if(b==null){
	 		return a;
	 	}
	 	int[] res=new int[a.length + b.length];
	 	System.arraycopy(a, 0, res, 0, a.length);
	 	System.arraycopy(b, 0, res, a.length, b.length);
	 	return res;
		
	}
}