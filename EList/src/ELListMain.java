import java.util.Arrays;
import java.util.Iterator;


public class ELListMain {

	public static void main(String[] args)
	{
		LDList1 dLList = new LDList1();
		int[] ar = {1,2,3,4,5,6,7};
		dLList.init(ar);
		
		dLList.addPos(7, 33);
		System.out.println(Arrays.toString(dLList.toArray()));
		
	}

}
