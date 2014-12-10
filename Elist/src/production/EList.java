package production;

public interface EList 
{
	public int size();
	public void init(int[] ar);
	public int[] toArray();
	public void addStart(int a);
	public void addEnd(int a);
	public void addPos(int a, int pos);
	public void delStart();
	public void delEnd();
	public void delPos (int pos);
	public int minValue(); 
	public int maxValue();  
	public int minIndex(); 
	public int maxIndex(); 
	public void reverse();
	public void changeparts();
	public void sortBubble(); 
	public void sortSelect(); 
	public void sortInsert();
}