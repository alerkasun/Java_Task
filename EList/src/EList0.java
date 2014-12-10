import java.util.Arrays;
import java.util.Iterator;


public class EList0 implements EList {
	private int[] array= null;
	
	@Override
	public Iterator<Integer> iterator()
	{
		return null;
	}
	
	public EList0()
	{
		array = new int[0];
	}
	
	@Override
	public void init(int[] arr)
	{
		array = arr;
	}

	@Override
	public int size()
	{
	if (array == null || array.length == 0)
	{
		return 0;
	}
		return array.length;
	}

	@Override
	public int[] toArray()
	{
		if (array == null || size() == 0)
		{
			return new int[0];
		}
		return array;
	}

	@Override
	public void addStart(int n)
	{
		if (array == null)
		{
			return;
		}
		
		int[] arr = new int[array.length + 1];
		arr[0] = n;
		for (int i=1; i<arr.length ;i++)
		{
			arr[i] = array[i-1];
		}
		array = arr;
	}

	@Override
	public void addEnd(int n)
	{
		int[] arr = new int[size() + 1];
		for (int i=0; i<size();i++)
		{
			arr[i] = array[i];
		}
		arr[size()] = n;
		array = arr;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if(pos <=0 || pos > size())
		{
			return;
		}
		pos--;
		
		int[] tarr = new int[size()+1];
		for (int i=0;i<size();i++)
		{
			tarr[i] = array[i];
		}
		for (int i=size()-1;i>=pos;i--)
		{
			tarr[i+1] = tarr[i];
		}
		tarr[pos] = val;
		array = tarr;
	}

	@Override
	public void delStart() 
	{
		if (size()==0)
		{
			return;
		}
		int[] tarr = new int[size()-1];
		for(int i=1;i<size();i++)
		{
			tarr[i-1] = array[i];
		}
		array = tarr;
	}

	@Override
	public void delEnd() 
	{
		if (size() == 0)
		{
			return;
		}
		
		int[] tarr = new int[size()-1];
		for (int i=0; i<tarr.length;i++)
		{
			tarr[i] = array[i];
		}
		array = tarr;
	}

	@Override
	public void delPos(int pos)
	{
		if (size()==0 || pos>size() || pos<=0)
		{
			return;
		}
		
		pos--;
		for (int i=pos;i<size()-1;i++)
		{
			array[i] = array[i+1];
		}
		
		int[] tarr = new int[size()-1];
		
		for (int i=0; i<tarr.length;i++)
		{
			tarr[i] = array[i];
		}
		array = tarr;
	}

	@Override
	public int getMin() {
		if (size() == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return array[0];
		}
		
		int min = array[0];
		
		for (int i=0; i<array.length;i++)
		{
			if (min>array[i])
			{
				min = array[i];
			}
		}
		
		return min;
	}

	@Override
	public int getMax() {
		if (size() == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return array[0];
		}
		
		int max = array[0];
	
		for (int i=0; i<array.length;i++)
		{
			if (max<array[i])
			{
				max = array[i];
			}
		}
		
		return max;
	}

	@Override
	public int getMinIndex()
	{
		if (size() == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return 1;
		}
		
		int min = 0;
		int ind = 0;
		
		min = array[0];
		for (int i=0; i<size();i++)
		{
			if (min>array[i])
			{
				min = array[i];
				ind = i;
			}
		}
		return ind+1;
	}

	@Override
	public int getMaxIndex() 
	{
		if (size() == 0)
		{
			return 0;
		}
		if (array.length == 1)
		{
			return 1;
		}
		
		int max = 0;
		int ind = 0;
		
		max = array[0];
		for (int i=0; i<array.length;i++)
		{
			if (max<array[i])
			{
				max = array[i];
				ind = i;
			}
		}
		return ind+1;
	}

	@Override
	public void reverse() 
	{
		if (size()== 0 || size() == 1) 
		{
			return;
		}

		for (int i = 0; array.length/2 > i; i++) {
	        int tmp = array[i];
	        array[i] = array[array.length - i - 1];
	        array[array.length - i - 1] = tmp;
	    }
	}

	@Override
	public void partChange() {
		
		if (size() == 0 || array.length == 1)
		{
			return;
		}
	    int hlen = array.length /2;
		int cpos = hlen + array.length % 2;
		for (int i = 0; i < hlen; i++) {
		  int t = array[i];
		  array[i] = array[cpos + i];
		  array[cpos + i] = t;
		}
	}

	@Override
	public int evenSum() {
		if (size() ==0)
		{
			return 0;
		}
		int sum = 0;
		for(int i=0; i<array.length;i++)
		{
			if(array[i]%2==0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	@Override
	public int oddSum() {
		if (size() ==0)
		{
			return 0;
		}
		int sum = 0;
		for(int i=0; i<array.length;i++)
		{
			if(array[i]%2 != 0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	@Override
	public void sortBuble() 
	{
		if (size() ==0 || array.length == 1)
		{
			return;
		}
		
		for (int i = array.length-1;i>0; i--)
		{
			for (int a =0; a < i; a++)
			{
				if (array[a]>array[a+1])
				{
					int tmp = array[a];
					array[a] = array[a+1];
					array[a+1] = tmp;
				}
			}
		}
		
	}

	@Override
	public void sortSelect()
	{
		if (size() == 0 || array.length == 1)
		{
			return;
		}
		
		int b = 0;
		for (int i=1; i<array.length;i++)
		{
			int tmp = array[i];
			 for ( b=i-1;b>=0 && array[b]>tmp; b--)
			 {
				 array[b+1]=array[b];
			 }
			array[b+1] = tmp;
			
		}
		
	}

	@Override
	public void sortInsert() 
	{
		if (size() ==0 || array.length == 1)
		{
			return;
		}
		for (int i=0;i<array.length;i++)
		{
			int min = array[i];
			int ind = i;
				for (int a=i+1; a<array.length;a++)
				{
					if (array[a]<min)
					{
						min = array[a];
						ind = a;
					}
				}
			if (i != ind)
			{
				int tmp = array[i];
				array[i] = min;
				array[ind] = tmp;
			}
		}
	}

	
}
