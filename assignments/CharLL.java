package assignments;


public class CharLL {

CharListNode head;
	
	public CharLL() {
		head = null;
	}
	public void insertFirst(char d) {
		CharListNode new_node = new CharListNode(d);
		if(head==null) {
			head = new_node;
			return;
		}
		new_node.setNext(head);
		head = new_node;
		return;
	}
	public void insertLast(char d) {
		CharListNode new_node = new CharListNode( d);
		if(head==null) {
			head=new_node;
			return ;
		}
		CharListNode iter = head;
		
		while(iter!=null) {
			if(iter.getNext()==null) {
				iter.setNext(new_node);
				break;
			}else
			iter = iter.getNext();
		}
	}
		
	public void setHead(CharListNode head) {
		this.head = head;
	}
	public void insertByPos(char d, char pos) {
		CharListNode new_node = new CharListNode(d);
		if(head==null) {
			head=new_node;
			return;
		}
		if(pos==1) {
			new_node.setNext(head);
			return;
		}
		CharListNode itr =head;
		for(char i=1; i<pos-1 && itr.getNext()!=null; i++,itr=itr.getNext());
		new_node.setNext(itr.getNext());
		itr.setNext(new_node);
				
	}
	
	public char deleteFirst() {
		char d='z';
		CharListNode deletable;
		if(head==null)
			return d;
		if(head.getNext()==null) {
			d=head.getData();
			head=null;
			return d;
		}
		deletable=head;
		d=head.getData();
		head=head.getNext();
		deletable=null;
		return d;
	}
	
	public char deleteLast() {
		char d='z';
		CharListNode deletable;
		if(head==null)
			return d;
		if(head.getNext()==null) {
			d=head.getData();
			head=null;
			return d;
		}
		CharListNode itr=head;
		while(itr.getNext().getNext()!=null) {
			itr=itr.getNext();
		}
		deletable=itr.getNext();
		d=deletable.getData();
		deletable=null;
		itr.setNext(deletable);
		return d;
	}
	
	public char deleteByPos(char pos) {
		char d='z';
		CharListNode deletable;
		if(head==null)
			return d;
		if(pos==1) {
			d=head.getData();
			deletable=head;
			head=head.getNext();
			deletable=null;
			return d;
		}
		CharListNode itr= head;
		for(char i=1; i<pos-1 && itr.getNext()!=null; i++, itr=itr.getNext());
		if(itr.getNext()!=null) {
			deletable=itr.getNext();
			d=deletable.getData();
			itr.setNext(deletable.getNext());
			deletable=null;
		}
		return d;
	}
	public void insertBefore(char d, char before) {
		CharListNode new_node= new CharListNode(d);
		if(head==null)
			return;
		if(head.getData()==before) {
			new_node.setNext(head);
			head=new_node;
			return;
		}
		CharListNode itr= head;
		while(itr.getNext()!=null && itr.getNext().getData()!=before) {
			itr=itr.getNext();
		}
		if(itr.getNext()!=null) {
			new_node.setNext(itr.getNext());
			itr.setNext(new_node);
		}
	}
	
	public void insertSorted(char d) {
		CharListNode new_node = new CharListNode(d);
		if(head==null || d<head.getData()) {
			new_node.setNext(head);
			head=new_node;
			return;
		}
		CharListNode itr=head;
		while(itr.getNext()!=null && d>itr.getNext().getData()) {
			itr=itr.getNext();
		}
		new_node.setNext(itr.getNext());
		itr.setNext(new_node);
		
	}
	public char count() {
		char cnt=0;
		if(head==null)
			return 0;
		CharListNode itr=head;
		while(itr!=null) {
			cnt++;
			itr=itr.getNext();
		}
		return cnt;
	}
	public void reverseList() {
		CharListNode prev=null, next, itr=head;
		while(itr!=null) {
			next=itr.getNext();
			itr.setNext(prev);
			prev=itr;
			itr=next;
		}
		head=prev;
	}
	public void displayAlternate() {
		if(head==null) {
			System.out.println("Empty list");
			return;
		}
		CharListNode itr= head;
		while(itr!=null) {
			System.out.println(itr.getData()+" ");
			if(itr.getNext()!=null) {
				itr=itr.getNext().getNext();
			}else {
				itr=itr.getNext();
			}
		}
	}
		
	public String toString() {
		if(head==null) {
			return "list is empty ";	
		}
		CharListNode iter = head;
		String str = "List: ";
		while(iter!=null) {
			str = str + " -> "+iter.getData();
			iter = iter.getNext();
		}
		return str;
	}

	public void recursiveReverse() {
		
	}
	
	public CharListNode getHead() {
		return head;
	}
	public static void main(String[] args) {
		
	}
}
