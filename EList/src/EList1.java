import java.util.Iterator;


public class EList1 implements EList  
{	
	private int[] array = new int[100];
	private int index = 0;
	
	
	public EList1(int[] a)
	{
		for(int i=0; i<a.length;i++)
		{
			array[i] = a[i];
		}
		index = a.length;
	}
	
	@Override
	public Iterator<Integer> iterator()
	{
		return null;
	}
	
	@Override 
	public void init(int[] arr)
	{
		if(arr==null || arr.length==0)
		{
			return;
		}
		for(int i=0;i<arr.length;i++)
		{
			array[i] = arr[i];
		}
		index = arr.length;
	}
		
	public EList1()
	{
	}
	
	private void resize()
	{
		
	}
	
	@Override 
	public int size()
	{
		if(array==null || array.length==0)
		{
			return 0;
		}
		return index;
	}
	
	@Override 
	public int[] toArray()
	{
		int[] arr = new int[index];
		for (int i=0; i<index; i++)
		{
			arr[i] = array[i];
		}
		return arr;
	}
	
	@Override 
	public void addStart(int n)
	{
		for (int i=index; i>0;i--)
		{
			array[i] = array[i-1];
		}
		index++;
		array[0] = n;
	}
	
	@Override 
	public void addEnd (int n)
	{
		array[index] = n;
		index++;
	}
	
	@Override 
	public void addPos (int pos,int val)
	{	
		if(pos<=0 || pos>index)
		{
			return;
		}
		
		pos--;
		for (int i=index; i>=pos;i--)
		{
			array[i+1] = array[i];
		}
		array[pos] = val;
		index++;
	}
	
	@Override 
	public void delStart()
	{
		if(size()==0)
		{
			return;
		}
		for (int i=0; i<index;i++)
		{
			array[i] = array[i+1];
		}
		index--;
	}
	
	@Override 
	public void delEnd ()
	{
		if(size()==0)
		{
			return;
		}
		if (index == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		index--;
	}
	
	@Override 
	public void delPos (int pos)
	{
		if(size()== 0 || pos>index)
		{
			return;
		}
		pos--;
		for (int i=pos; i<index;i++)
		{
			array[i] = array[i+1];
		}
		index--;
	}

	@Override 
	public int getMin ()
	{
		int min = 0;
		if (array == null || index == 0)
		{
			return 0;
		}
		if (index == 1)
		{
			return array[0];
		}
		
		min = array[0];
		for (int i=1; i< index; i++)
		{
			if (array[i]<min)
			{
				min = array[i];
			}
		}
		return min;
	}

	@Override 
	public int getMax()
	{
		if (array == null || index == 0)
		{
			return 0;
		}
		int max = 0;
		max = array[0];
		for (int i=0; i<index;i++)
		{
			if (max<array[i])
			{
				max = array[i];
			}
		}
		
		return max;
	}
	
	@Override 
	public int getMinIndex ()
	{
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int min = 0;
		int ind = 0;
		min = array[0];
		
		for (int i=0; i<index;i++)
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
	public int getMaxIndex ()
	{
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int max = 0;
		int ind = 0;
		max = array[0];
		
		for (int i=0; i<index;i++)
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
	public void reverse ()
	{
		if (array == null || index == 0 || index == 1) 
		{
			return;	
		}

		for (int i = 0; index/2 > i; i++) {
	        int tmp = array[i];
	        array[i] = array[index - i - 1];
	        array[index - i - 1] = tmp;
	    }
	}
	
	@Override 
	public void partChange ()
	{
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
	    int hlen = index /2;
		int cpos = hlen + index % 2;
		for (int i = 0; i < hlen; i++) {
		  int t = array[i];
		  array[i] = array[cpos + i];
		  array[cpos + i] = t;
		}
	}

	@Override 
	public int evenSum ()
	{
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int sum = 0;
		
		for (int i=0; i<index; i++)
		{
			if (array[i]%2 == 0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	@Override 
	public int oddSum ()
	{
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int sum = 0;
		
		for (int i=0; i<index; i++)
		{
			if (array[i]%2 != 0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	@Override 
	public void sortBuble ()
	{
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		
		for (int i = index-1;i>0; i--)
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
	public void sortSelect ()
	{
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		for (int i=0;i<index;i++)
		{
			int min = array[i];
			int ind = i;
				for (int a=i+1; a<index;a++)
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

	@Override 
	public void sortInsert ()
	{
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		
		int b = 0;
		for (int i=1; i<index;i++)
		{
			int tmp = array[i];
			 for ( b=i-1;b>=0 && array[b]>tmp; b--)
			 {
				 array[b+1]=array[b];
			 }
			array[b+1] = tmp;	
		}
	}
}
