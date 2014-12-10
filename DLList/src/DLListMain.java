import java.util.Arrays;
import java.util.Iterator;


public class DLListMain {

	public static void main(String[] args)
	{
		LDList2 dLList = new LDList2();
		int[] ar = {1,2,3,4,5,6,7};
		dLList.addEnd(1);
		dLList.addEnd(2);
		dLList.addEnd(2);
		dLList.addEnd(23);
		
		System.out.println(Arrays.toString(dLList.toArray()));
		
	}

}
