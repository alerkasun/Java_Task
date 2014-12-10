import java.util.Arrays;
import java.util.Iterator;


public class LDList2 implements DList {

	class Node
	{
		int data;
		Node next;
		Node prev;
		
		public Node(int val)
		{
			data = val;
		}
		public Node()
		{
		}
	}
	public LDList2()
	{
	}
	
	public Node begin = null;
	public Node end = null; 

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
			begin = null;
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
		if(begin==null)
		{
			return 0;
		}
		int cnt = 0;
		Node node = begin;
		
		while(node!=null)
		{
			node = node.next;
			cnt++;
		}
		
		return cnt;
	}

	@Override
	public int[] toArray() 
	{
		if(begin==null)
		{
			return new int[0];
		}
		
		int[] arr = new int[4];
		Node nd = begin;
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
		Node node = new Node(n);
		node.next = begin;
		begin = node;
		
		node.prev = null;
		if(end == null)
		{
			end = node;
		}
	
	}

	@Override
	public void addEnd(int n) 
	{
		if(end==null)
		{
			addStart(n);
			return;
		}
		Node node = new Node(n);
		end.next = node;
		node.prev = end;
		node.next = null;
		end = node;
	}
	
	private void addFirstE(int n)
	{
		Node node = new Node(n);
		
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if(pos<=0 || pos>size())
		{
			return;
		}
		
		if(begin == null || pos==1)
		{		
			Node nd = new Node(val);
			nd.next = begin;
			begin = nd;
			return;
		}
		
		Node nd = begin;
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
		if (begin == null)
		{
			return;
		}
		begin = begin.next;	
	}

	@Override
	public void delEnd() {
		if (begin == null)
		{
			return;
		}
		if (size()==1)
		{
			delStart();
		}
		
		Node nd = begin;
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
		if (begin == null)
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
		
		Node nd = begin;
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
		if(begin==null)
		{
			return 0;
		}
		int min = 0;
		
		Node nd = begin;
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
		if(begin==null)
		{
			return 0;
		}
		
		int max = 0;
		Node nd = begin;
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
		if(begin==null)
		{
			return 0;
		}
		int min = 0;
		int minI = 0;
		int i = 0;
		
		Node nd = begin;
		min = nd.data;
		while(nd != null)
		{
			if(nd.data<min)
			{
				min = nd.data;
				minI = i;
			}
			i++;
			nd = nd.next;
		}
		return minI+1;
	}

	@Override
	public int getMaxIndex()
	{
		if(begin==null)
		{
			return 0;
		}
		int max = 0;
		int maxI = 0;
		int i = 0;
		
		Node nd = begin;
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
		if(begin == null)
		{
			return;
		}
		Node node = begin;
		
		if(size()==2)
		{
			Node n = begin.next;
			begin.next = null;
			n.next = begin;
			begin = n;
			return;
		}
		
		while(node.next!=null)
		{
			Node next = node.next;
			node.next = next.next;
			next.next = begin;
			begin = next;		
		}
	}

	@Override
	public void partChange() 
	{
		if(begin == null || size()==1)
		{
			return;
		}
		if(size()==2)
		{
			Node n = begin.next;
			begin.next = null;
			n.next = begin;
			begin = n;
			return;
		}
		Node node = begin;
		Node tmpNode = null;
		int m = size()/2;
		int i = 2;
		while(node.next!=null)
		{
			node = node.next;
			if(i==m)
			{
				tmpNode = node;
			}
			i++;
		}
		node.next = begin;
		begin = tmpNode.next;
		tmpNode.next = null;
		
	}

	@Override
	public int evenSum() 
	{
		if(begin == null)
		{
			return 0;
		}
		
		int sm = 0;
		Node nd = begin;
		
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
		if(begin == null)
		{
			return 0;
		}
		
		int sm = 0;
		Node nd = begin;
		
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
	public void sortBuble() 
	{
		
		for(int i=1;i<size();++i)
		{
			Node node = begin;
			Node prev = begin;
			
			while(node.next!=null)
			{
				if(node.data > node.next.data)
				{
					if(node == begin)
					{
						Node n = node;
						node = node.next;
						n.next = node.next;
						node.next = n;
						begin = node;
					}
					else
					{
						Node n = node;
						node = node.next;
						prev.next = node;
						n.next = node.next;
						node.next = n;
					}
				}
				prev = node;
				node = node.next;
			}
		
		}
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
