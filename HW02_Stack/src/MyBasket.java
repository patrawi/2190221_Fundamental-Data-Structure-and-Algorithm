import java.util.Iterator;

public class MyBasket {
	MyStack s;

	public MyBasket(MyStack s) {
		super();
		this.s = s;
	
		
	}

	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////

	public void removeKthFromTop(int k) throws Exception {
		if(s.isEmpty()) {
			return;
		}
		
		if(k > s.size()) {
			return;
		}
		if(k < 0) {
			return;
		}
		int index = 0;
		StackArray temp = new StackArray(s.size());
		while(!s.isEmpty()) {
			if(index == k) {
				s.pop();
			} else {
				int data = s.top();
				s.pop();
				temp.push(data);
			}
			index++;
			
		}
		while(!temp.isEmpty()) {
			int data = temp.top();
			temp.pop();
			s.push(data);
	
		}
	}

	public void insertKthFromTop(int data, int k) throws Exception {
		if(k < 0) {
			return;
		}
		if(k > s.size()) {
			return;
		}


		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		StackArray temp = new StackArray(s.size());
		while( k > 0) {
			temp.push(s.top());
			s.pop();
			k--;
		}
		s.push(data);
		while(!temp.isEmpty()) {
			s.push(temp.top());
			temp.pop();
			
		}
	
	}

}
