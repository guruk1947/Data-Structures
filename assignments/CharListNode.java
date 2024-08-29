package assignments;

public class CharListNode {

	private char data;
	private CharListNode next=null;
	public CharListNode(char data) {
		super();
		this.data = data;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public CharListNode getNext() {
		return next;
	}
	public void setNext(CharListNode next) {
		this.next = next;
	}
	
}
