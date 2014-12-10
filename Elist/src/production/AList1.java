package production;

public class AList1 implements EList
{
	private int[] arr = new int[100];
	private int index = 0;

	public void EList (int[] array)
	{
		init(array);
	} 

	@Override
	public int size() 
	{
		return index;
	}
	
	@Override
	public void init(int[] array)
	{
		if(array == null || array.length == 0)
		{
			index = 0;
			return;
		}
		index = array.length;
		for (int i=0; i<index; i++)
		{
			arr[i] = array[i];
		}
	}

	@Override
	public int[] toArray()
	{
		int[] array = new int[index];
		for (int i=0; i<index; i++)
		{
			array[i] = arr[i];
		}
		return array;
	}

	@Override
	public void addStart (int a)
	{
		if (index == 100)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=index; i>0; i--)
			{
				arr[i] = arr[i-1];
			}
			arr[0] = a;
			index++;
		}
	}

	@Override
	public void addPos (int a, int pos)
	{
		if (index == 100)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=index; i>=pos; i--)
			{
				arr[i+1] = arr[i];
			}
			arr[pos] = a;
			index++;
		}
	}

	@Override
	public void addEnd (int a)
	{
		if (index == 100)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			arr[index++] = a;
		}
	}

	@Override
	public void delStart ()
	{
		if (index == 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=0; i<index; i++)
			{
				arr[i] = arr[i+1];
			}
			index--;
		}
	}

	@Override
	public void delPos (int pos)
	{
		if (index == 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=pos; i>index; i++)
			{
				arr[i] = arr[i+1];
			}
			index--;
		}
	}

	@Override
	public void delEnd ()
	{
		if (index == 0)
		{
			return;
		}
		else
		{
			index--;
		}
	}

	@Override
	public int minValue () 
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int vivod = arr[0];
			//			for (int i=start; i<end; i++) 
			//			{
			//				if (vivod > arr[i])
			//				{
			//					vivod = arr[i];
			//				}
			//			}

			return vivod;
		}
	}

	@Override
	public int maxValue ()  
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int vivod = arr[0];
			//			for (int i=start; i<end; i++) 
			//			{
			//				if (vivod < arr[i]) 
			//				{
			//					vivod = arr[i];
			//				}
			//			}

			return vivod;
		}
	}

	@Override
	public int minIndex () 
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int vivod = arr[0];
			int index = 0;
			//			for (int i=start; i<end; i++) 
			//			{
			//				if (vivod > arr[i])
			//				{
			//					vivod = arr[i];
			//					index = i;
			//				}
			//			}

			vivod = index;
			return vivod;
		}
	}

	@Override
	public int maxIndex () 
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int vivod = 0;
			int index = 0;
			//			for (int i=start; i<end; i++) 
			//			{
			//				if (vivod < arr[i])
			//				{
			//					vivod = arr[i];
			//					index = i;
			//				}
			//			}

			vivod = index;
			return vivod;
		}
	}

	@Override
	public void reverse()
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			//			for (int i=start; i<end-start/2; i++)
			//			{
			//				int temp = arr[i];
			//				arr[i] = arr[end-start-i-1];
			//				arr[end-start-i-1] = temp;
			//			}
		}
	} 

	@Override
	public void changeparts ()
	{
		if (arr == null || arr.length%2 != 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=0; i<arr.length/2; i++)
			{
				int temp = arr[i];
				arr[i] = arr[arr.length/2+i];
				arr[arr.length/2+i] = temp;
			}
		}
	}

	@Override
	public void sortBubble () 
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int ii = 0;
			while (true)
			{
				int in = 0;
				for (int i=0; i<arr.length-1; i++) 
				{
					if (arr[i] > arr[i+1]) 
					{
						ii = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = ii;
						in = 1;
					}
				}
				if (in == 0)
				{
					break;
				}
			}
		}
	}


	@Override
	public void sortSelect () 
	{
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int i=0;
			int p = 0;
			int ii = 0;
			int cc = 0;
			int x = 0;
			int index = 0;

			while (true)
			{
				for (i=p; i<arr.length; i++) 
				{
					if (i == p)
					{
						cc = arr[p];
					}
					if (cc > arr[i])
					{
						cc = arr[i];
						index = i;
					}
				}
				int s = 0;
				for (i=0; i<arr.length-1; i++) 
				{
					if (arr[i] < arr[i+1])
					{
						s++;
					}
				}
				if (s == arr.length-1)
				{
					break;
				}
				ii = arr[x];
				arr[x] = arr[index];
				arr[index] = ii;
				p++;
				x++;
			}
		}
	}


	@Override
	public void sortInsert ()
	{	
		if (arr == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for (int i=0; i<arr.length; i++)
			{
				for (int i2=0; i2<=i; i2++)
				{
					if (arr[i] < arr[i2])
					{
						//System.out.println ("ïðîâåðêà ---  " + i +" < "+i2 );
						int m = arr[i2];
						int m2 = arr[i];
						for (int i3=arr.length-1; i3>=0; i3--)
						{
							if(i3 <= i && i3 >= i2+1)
							{
								arr[i3] = arr[i3-1];
							}
						}
						arr[i2] = m2;
						arr[i2+1] = m;	
					}
				}
			}
		}
	}


}