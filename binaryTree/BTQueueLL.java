package binaryTree;



public class BTQueueLL {

BTListNode front=null, rear=null;
	
	public boolean isEmpty() {
		if(front==null)
			return true;
		return false;
	}
	public void enQueue(BTNode d) {
		BTListNode new_node= new BTListNode(d);
		if(front==null) {
			front=rear=new_node;
			return;
		}
		rear.setNext(new_node);
		rear=new_node;
	}
	
	public BTNode deQueue() {
		BTNode d=null;
		if(front==null) 
			return d;
		BTListNode deletable=front;
		d= deletable.getData();
		front=deletable.getNext();
		deletable.setNext(null);
		deletable=null;
		return d;
	}
	@Override
	public String toString() {
		String str="Queue-> ";
		if(front == null)
			return str+"Empty";
		BTListNode itr=front;
		while(itr!=null) {
			str=str+itr.getData()+"->";
			itr=itr.getNext();
		}
		
		return str;
	}
}
