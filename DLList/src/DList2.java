import java.util.Arrays;
import java.util.Iterator;


public class DList2 implements DList, Iterable 
{	
	private int[] array = new int[100];
	private int rear = 0;
	private int front = 0;
	
	public void init(int[] arr)
	{		
		if (arr==null || arr.length==0)
		{
			return;
		}
			
		rear = rear - arr.length/2;
		front = rear + arr.length;
		
		for (int i=rear;i<front;i++)
		{
			array[i] = arr[i-rear];
		}
	}
	
	public DList2()
	{
		rear = array.length/2;
		front = rear;
	}
	
	private void resize()
	{
		int[] tarr = toArray();
		array = new int[array.length*30/100+array.length];
		init(tarr);
	}
	
	public int size()
	{
		if (array==null || array.length==0)
		{
			return 0;
		}
		return front-rear;
	}
	
	public int[] toArray()
	{
		if (size() ==0)
		{
			return new int[0];
		}
		
		int index = size();
		
		int[] arr = new int[index];
		
		for (int i=0; i<index; i++)
		{
			arr[i] = array[rear+i];
		}
		return arr;
	}
	
	public void addStart(int n)
	{
		rear--;
		array[rear] = n;
	}

	public void addEnd (int n)
	{
		
		array[front] = n;
		front++;
	}

	public void addPos (int pos,int val)
	{
		
		if (size()==0 || size()<pos || pos<=0)
		{
			return;
		}
		
		if (pos>size())
		{
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		pos--;
		if (pos<size()/2)
		{
			for(int i=rear;i<=rear+pos;i++)
			{
				array[i-1] = array[i];
			}
			array[rear+pos-1] = val;
			rear--;
		}
		else
		{
			for(int i=front;i>rear+pos-1;i--)
			{
				
				array[i+1] = array[i];
			}
			array[rear+pos] = val;
			front++;
		}
	}

	public void delStart()
	{
		if (size()>0)
		{
			rear++;
		}
	}

	public void delEnd ()
	{
		if (size()>0)
		{
			front--;
		}
	}

	public void delPos (int pos)
	{
		if (size()==0 || size()<pos || pos<=0)
		{
			return;
		}
		if (pos>size())
		{
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		pos--;
		if (pos<size()/2)
		{
			for (int i=rear+pos;i>rear;i--)
			{
				array[i] = array[i-1];
			}
			rear++;
		}
		else
		{
			for(int i=rear+pos;i<front;i++)
			{
				array[i] = array[i+1];
			}
			front--;
		}
	}

	public int getMin ()
	{
		int index = size();
		
		int min = 0;
		
		if (array == null || index == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return toArray()[0];
		}
		
		min = array[rear];
		
		for (int i=rear; i< front; i++)
		{
			if (array[i]<min)
			{
				min = array[i];
			}
		}
		return min;
	}

	public int getMax()
	{
		int index = size();
		
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int max = 0;
		max = array[rear];
		for (int i=rear; i<front;i++)
		{
			if (max<array[i])
			{
				max = array[i];
			}
		}
		
		return max;
	}

	public int getMinIndex ()
	{
		int index = size();
		
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int min = 0;
		int ind = 0;
		min = array[rear];
		
		for (int i=rear; i<front;i++)
		{
			if (min>array[i])
			{
				min = array[i];
				ind = i-rear;
			}
		}
		return ind+1;
	}

	public int getMaxIndex ()
	{	
		if (array == null || size() == 0)
		{
			return 0;
		}
		int max = 0;
		int ind = 0;
		max = array[rear];
		
		for (int i=rear; i<front;i++)
		{
			if (max<array[i])
			{
				max = array[i];
				ind = i-rear;
			}
		}
		return ind+1;
	}

	public void reverse ()
	{
		if (array == null || size() == 0 || size() == 1) 
		{
			return;	
		}
		for (int i =rear; i< rear+size()/2; i++) 
		{
			array[i] = array[i] + array[front-i+rear-1];
			array[front-i+rear-1] = array[i] - array[front-i+rear-1];
			array[i] = array[i] - array[front-i+rear-1];
	    }
	}

	public void partChange ()
	{
		int index = size();
		
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
	    int hlen = index /2;
		int cpos = hlen + index % 2;
		for (int i = rear; i < rear+index/2; i++) {
		  int t = array[i];
		  array[i] = array[cpos + i];
		  array[cpos + i] = t;
		}
	}

	public int evenSum ()
	{
		int index = size();
		
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int sum = 0;
		
		for (int i=rear; i<rear+index; i++)
		{
			if (array[i]%2 == 0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	public int oddSum ()
	{
		int index = size();
		
		if (array == null || index == 0)
		{
			return 0;
		}
		
		int sum = 0;
		
		for (int i=rear; i<rear+index; i++)
		{
			if (array[i]%2 != 0)
			{
				sum +=array[i];
			}
		}
		return sum;
	}

	public void sortBuble ()
	{
		int index = size();
		
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		
		for (int i =rear+index-1;i>rear; i--)
		{
			for (int a =rear; a < i; a++)
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

	public void sortSelect ()
	{
		int index = size();
	
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		for (int i=rear;i<rear+index;i++)
		{
			int min = array[i];
			int ind = i;
				for (int a=i+1; a<rear+index;a++)
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

	public void sortInsert ()
	{
		int index = size();
		
		if (array == null || index == 0 || index == 1)
		{
			return;
		}
		
		int b = 0;
		for (int i=rear+1; i<rear+index;i++)
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
	public Iterator iterator() 
	{	
		return new DListIterator();
	}
	
	public class DListIterator implements Iterator {
		private int ipos = 0;
		
		public DListIterator()
		{
			ipos = rear;
		}
		
		@Override
		public boolean hasNext()
		{
			return ipos > front;
		}

		@Override
		public Object next() 
		{
			return array[ipos++];
		}

		@Override
		public void remove() {

			
		}
	}
}
