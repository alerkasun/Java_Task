import java.util.Iterator;


public interface DList 
{	
	public void init(int[] arr);
	public Iterator<Integer> iterator();
	public int size();
	public int[] toArray();
	public void addStart(int n);
	public void addEnd(int n);
	public void addPos(int pos,int val);
	public void delStart();
	public void delEnd();
	public void delPos(int pos);
	public int getMin();
	public int getMax();
	public int getMinIndex();
	public int getMaxIndex();
	public void reverse();
	public void partChange();
	public int evenSum();
	public int oddSum();
	public void sortBuble();
	public void sortSelect();
	public void sortInsert();
}