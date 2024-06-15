package listedList;

public class DblyNode {

	private DblyNode prev=null, next=null;
	int data=0;
	public DblyNode(int data) {
		super();
		this.data = data;
	}
	public DblyNode getPrev() {
		return prev;
	}
	public void setPrev(DblyNode prev) {
		this.prev = prev;
	}
	public DblyNode getNext() {
		return next;
	}
	public void setNext(DblyNode next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
