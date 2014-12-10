package production;

public class AList0 implements EList
{
	private int [] arr = null;
	AList0()
	{
		arr = new int[0];
	}
	
	AList0(int [] array)
	{
		arr = array;
	}
	
	
	@Override
	public int size() {
		if (arr == null || arr.length == 0)
		{
			return 0;
		}
		return arr.length;
	}

	@Override
	public void init(int[] ar) {
		if(ar == null || ar.length == 0)
		{
			return;
		}
		arr = ar;
		
	}

	@Override
	public int[] toArray() {
		if(arr == null || arr.length == 0)
		{
			return new int[0];
		}
		return arr;
	}

	@Override
	public void addStart(int a) {
		if(arr == null)
		{
			arr = new int[0];
		}
		int[] tmpArr = new int[size()+1];
		for(int i =1; i <tmpArr.length; i++)
		{
			tmpArr[i] = arr[i-1];
		}
		tmpArr[0] = a;
		arr = tmpArr;
	}

	@Override
	public void addEnd(int a)
	{
		int[] array = new int[size() + 1];
		for (int i=0; i<size();i++)
		{
			array[i] = arr[i];
		}
		array[size()] = a;
		arr = array;
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
			tarr[i] = arr[i];
		}
		for (int i=size()-1;i>=pos;i--)
		{
			tarr[i+1] = tarr[i];
		}
		tarr[pos] = val;
		arr = tarr;
	}

	@Override
	public void delStart() {
		{
			if (size()==0)
			{
				return;
			}
			int[] tarr = new int[size()-1];
			for(int i=1;i<size();i++)
			{
				tarr[i-1] = arr[i];
			}
			arr = tarr;
		}
	}

	@Override
	public void delEnd() {
		if (size() == 0)
		{
			return;
		}
		
		int[] tarr = new int[size()-1];
		for (int i=0; i<tarr.length;i++)
		{
			tarr[i] = arr[i];
		}
		arr = tarr;
	}

	@Override
	public void delPos(int pos) {
		if (size()==0 || pos>size() || pos<=0)
		{
			return;
		}
		
		pos--;
		for (int i=pos;i<size()-1;i++)
		{
			arr[i] = arr[i+1];
		}
		
		int[] tarr = new int[size()-1];
		
		for (int i=0; i<tarr.length;i++)
		{
			tarr[i] = arr[i];
		}
		arr = tarr;
		
	}

	@Override
	public int minValue() {
		if (size() == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return arr[0];
		}
		
		int min = arr[0];
		
		for (int i=0; i<arr.length;i++)
		{
			if (min>arr[i])
			{
				min = arr[i];
			}
		}
		
		return min;
	}

	@Override
	public int maxValue() {
		if (size() == 0)
		{
			return 0;
		}
		if (size() == 1)
		{
			return arr[0];
		}
		
		int max = arr[0];
	
		for (int i=0; i<arr.length;i++)
		{
			if (max<arr[i])
			{
				max = arr[i];
			}
		}
		
		return max;
	}

	@Override
	public int minIndex() {
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
		
		min = arr[0];
		for (int i=0; i<size();i++)
		{
			if (min>arr[i])
			{
				min = arr[i];
				ind = i;
			}
		}
		return ind+1;
	}

	@Override
	public int maxIndex() {
		if (size() == 0)
		{
			return 0;
		}
		if (arr.length == 1)
		{
			return 1;
		}
		
		int max = 0;
		int ind = 0;
		
		max = arr[0];
		for (int i=0; i<arr.length;i++)
		{
			if (max<arr[i])
			{
				max = arr[i];
				ind = i;
			}
		}
		return ind+1;
	}

	@Override
	public void reverse() {
		if (size()== 0 || size() == 1) 
		{
			return;
		}

		for (int i = 0; arr.length/2 > i; i++) {
	        int tmp = arr[i];
	        arr[i] = arr[arr.length - i - 1];
	        arr[arr.length - i - 1] = tmp;
	    }
	}

	@Override
	public void changeparts() {
		if (size() == 0 || arr.length == 1)
		{
			return;
		}
	    int hlen = arr.length /2;
		int cpos = hlen + arr.length % 2;
		for (int i = 0; i < hlen; i++) {
		  int t = arr[i];
		  arr[i] = arr[cpos + i];
		  arr[cpos + i] = t;
		}
	}

	@Override
	public void sortBubble() {
		{
			if (size() ==0 || arr.length == 1)
			{
				return;
			}
			
			for (int i = arr.length-1;i>0; i--)
			{
				for (int a =0; a < i; a++)
				{
					if (arr[a]>arr[a+1])
					{
						int tmp = arr[a];
						arr[a] = arr[a+1];
						arr[a+1] = tmp;
					}
				}
			}
			
		}
		
	}

	public void sortSelect()
	{
		if (size() == 0 || arr.length == 1)
		{
			return;
		}
		
		int b = 0;
		for (int i=1; i<arr.length;i++)
		{
			int tmp = arr[i];
			 for ( b=i-1;b>=0 && arr[b]>tmp; b--)
			 {
				 arr[b+1]=arr[b];
			 }
			arr[b+1] = tmp;
			
		}
		
	}

	@Override
	public void sortInsert() 
	{
		if (size() ==0 || arr.length == 1)
		{
			return;
		}
		for (int i=0;i<arr.length;i++)
		{
			int min = arr[i];
			int ind = i;
				for (int a=i+1; a<arr.length;a++)
				{
					if (arr[a]<min)
					{
						min = arr[a];
						ind = a;
					}
				}
			if (i != ind)
			{
				int tmp = arr[i];
				arr[i] = min;
				arr[ind] = tmp;
			}
		}
	}

}