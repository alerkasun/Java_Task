import java.util.Arrays;
import java.util.Iterator;


public class LDList1 implements EList {

	class Node
	{
		int data;
		Node next;
		
		public Node(int val)
		{
			data = val;
		}
	}
	
	Node root = null;

	@Override
	public Iterator<Integer> iterator()
	{
		return new DListIterator();
	}
	
	class DListIterator implements Iterator
	{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void init(int[] arr) 
	{
		if(arr==null || arr.length==0)
		{
			root = null;
			return;
		}
		
		for (int i=arr.length-1;i>=0;i--)
		{
			addStart(arr[i]);
		}	
	}

	@Override
	public int size()
	{
		if(root==null)
		{
			return 0;
		}
		int cnt = 0;
		Node nd = root;
		
		while(nd!=null)
		{
			nd = nd.next;
			cnt++;
		}
		return cnt;
	}

	@Override
	public int[] toArray() 
	{
		if(root==null)
		{
			return new int[0];
		}
		
		int[] arr = new int[size()];
		Node nd = root;
		int i =0;
		while(nd != null)
		{
			arr[i] = nd.data;
			i++;
			nd = nd.next;
		}
		
		return arr;
	}

	@Override
	public void addStart(int n) 
	{
		Node nd = new Node(n);
		nd.next = root;
		root = nd;
	}

	@Override
	public void addEnd(int n) 
	{
		if(root == null)
		{
			Node nd = new Node(n);
			nd.next = root;
			root = nd;
			return;
		}
		
		Node nd = root;
		
		while(nd != null)
		{
			if(nd.next == null)
			{
				Node tnd = new Node(n);
				nd.next =tnd;
				tnd.next = null;
				return;
			}
			nd = nd.next;
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if(pos<=0 || pos>size())
		{
			return;
		}
		
		if(root == null || pos==1)
		{		
			Node nd = new Node(val);
			nd.next = root;
			root = nd;
			return;
		}
		
		Node nd = root;
		pos--;
		int i =1;
		while (nd != null)
		{
			if (i==pos)
			{
				Node tnd = new Node(val);
				tnd.next = nd.next;
				nd.next = tnd;
				return;
			}
			nd = nd.next;
			i++;
		}
	}

	@Override
	public void delStart()
	{
		if (root == null)
		{
			return;
		}
		root = root.next;	
	}

	@Override
	public void delEnd() {
		if (root == null)
		{
			return;
		}
		if (size()==1)
		{
			delStart();
		}
		
		Node nd = root;
		int i =1;
		while(nd != null)
		{
			if (i==size()-1)
			{
				nd.next = null;
				return;
			}
			nd = nd.next;
			i++;
		}
		
	}

	@Override
	public void delPos(int pos) 
	{
		if (root == null)
		{
			return;
		}
		if (pos<=0 || pos>size())
		{
			return;
		}
		if(pos==1)
		{
			delStart();
		}
		
		Node nd = root;
		int i = 1;
		while(nd != null)
		{
			if(i==pos-1)
			{
				Node tnd = nd.next;
				nd.next = tnd.next;
				return;
			}
			nd = nd.next;
			i++;
		}
	}

	@Override
	public int getMin() 
	{
		if(root==null)
		{
			return 0;
		}
		int min = 0;
		
		Node nd = root;
		min = nd.data;
		while(nd!=null)
		{
			if(nd.data<min)
			{
				min = nd.data;
			}
			nd = nd.next;
		}
		return min;
	}

	@Override
	public int getMax() 
	{
		if(root==null)
		{
			return 0;
		}
		
		int max = 0;
		Node nd = root;
		max = nd.data;
		
		while(nd!=null)
		{
			if(nd.data>max)
			{
				max = nd.data;
			}
			nd = nd.next;
		}
		return max;
	}

	@Override
	public int getMinIndex() 
	{
		if(root==null)
		{
			return 0;
		}
		int min = 0;
		int minI = 0;
		int i = 0;
		
		Node nd = root;
		min = nd.data;
		while(nd != null)
		{
			if(nd.data<min)
			{
				min = nd.data;
				minI = i;
				System.out.println(minI);
			}
			i++;
			nd = nd.next;
		}
		return minI+1;
	}

	@Override
	public int getMaxIndex()
	{
		if(root==null)
		{
			return 0;
		}
		int max = 0;
		int maxI = 0;
		int i = 0;
		
		Node nd = root;
		max = nd.data;
		while(nd!=null)
		{
			if(nd.data>max)
			{
				max = nd.data;
				maxI = i;
			}
			i++;
			nd = nd.next;
		}
		return maxI+1;
	}

	@Override
	public void reverse() 
	{
		
		
	}

	@Override
	public void partChange() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int evenSum() 
	{
		if(root == null)
		{
			return 0;
		}
		
		int sm = 0;
		Node nd = root;
		
		while(nd != null)
		{
			if(nd.data%2==0)
			{
				sm += nd.data;
			}
			nd = nd.next;
		}
		return sm;
	}

	@Override
	public int oddSum()
	{
		if(root == null)
		{
			return 0;
		}
		
		int sm = 0;
		Node nd = root;
		
		while(nd != null)
		{
			if(nd.data%2 != 0)
			{
				sm += nd.data;
			}
			nd = nd.next;
		}
		return sm;
	}

	@Override
	public void sortBuble() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortInsert() {
		// TODO Auto-generated method stub
		
	}

}
