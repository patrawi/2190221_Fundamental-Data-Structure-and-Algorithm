import java.util.AbstractList;
public class IntegerList extends CDLinkedList {

	public IntegerList() {
		super();
		
	}

	public IntegerList(int[] a) throws Exception {
		super(a);
		
	}

	/////////////////////////////////////////////////////////
	public void removeOddValue() throws Exception {// remove all odd numbers
		if(isEmpty()) {
			return;
		}
		DListIterator itr1 = new DListIterator(header);
		itr1.next();
		while(itr1.hasNext()) {
			Object data = itr1.currentNode.data;
			if(data == null) {
				break;
			}
			if(((int)data) % 2 != 0) {
	
				removeAt(itr1);
			}
			itr1.next();
		}
		
	}

	public void removeRange(DListIterator itr1, DListIterator itr2, int rangeSize) throws Exception {
		itr1.currentNode.previousNode.nextNode = itr2.currentNode.nextNode;
		itr2.currentNode.nextNode.previousNode = itr1.currentNode.previousNode;
		this.size -= rangeSize;
	}

	public void evenToFront() throws Exception { // move even data to the front (must preserve order)
	DListIterator itr1 = new DListIterator(header);
	DListIterator itr2 = new DListIterator(header);
		if(isEmpty()) {
			return;
		}
		while(itr1.hasNext()) {
			Object odd = itr1.next();
			if(odd == null) {
				return;
			}
			if((int)odd % 2 == 0 ) {
				removeAt(itr1);
				insert(odd,itr2);
				itr2.next();
			}
		}
	
	}

	public int sum() throws Exception {
		DListIterator itr1 = new DListIterator(header);
		if(isEmpty()) {
			return 0;
		}
		int sum = 0;
		itr1.next();
		while(itr1.hasNext()) {
			Object data = itr1.currentNode.data;
			if(data == null) {
				break;
			}
			sum += (int)data;
			itr1.next();
		}
		return sum;// add the value of all data	
	}

	public void appendToBack(IntegerList l) throws Exception { // append list l to the back of this list
		DListIterator start = new DListIterator(l.header.nextNode);
		DListIterator end = new DListIterator(l.header.previousNode);
		DListIterator current = new DListIterator(header);
		DListIterator backcurrent = new DListIterator(header);
		if(isEmpty()) {
			current.currentNode.nextNode = start.currentNode;
			current.currentNode.previousNode = end.currentNode;
			end.currentNode.nextNode = current.currentNode;
			start.currentNode.previousNode = backcurrent.currentNode;
			this.size += l.size();
			return;
	
		}
		backcurrent.previous();
		backcurrent.currentNode.nextNode = start.currentNode;
		current.currentNode.previousNode = end.currentNode;
		start.currentNode.previousNode = backcurrent.currentNode;
		end.currentNode.nextNode = current.currentNode;
		this.size += l.size();
		
		// must be done in constant time. l will not be used again in the future.

	}

	public void insertList(DListIterator itr, IntegerList l) throws Exception {
	if(l.isEmpty()) {
		return;
	}
	DListIterator start = new DListIterator(l.header.nextNode);
	DListIterator end = new DListIterator(l.header.previousNode);
	DListIterator current = new DListIterator(itr.currentNode.nextNode);
	
	itr.currentNode.nextNode = start.currentNode;
	start.currentNode.previousNode = itr.currentNode;
	end.currentNode.nextNode = current.currentNode;
	current.currentNode.previousNode = end.currentNode;
	
	this.size += l.size();
	
	

	
	}
}




