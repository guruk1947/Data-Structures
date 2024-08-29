package assignments;

import stack.CharStack;

public class StringPalindrome {

	public static void main(String[] args) {
		String str="ABCBa";
		int flag=0;
		CharStack s= new CharStack();
		for(int i=0; i<=str.length()-1; i++) {
			if(i<=str.length()/2-1) {
				s.push(str.charAt(i));
				if(i==str.length()/2-1 && str.length()%2!=0)
					i++;
			}
			else {
				
				if(s.pop()!=str.charAt(i)) {
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
			System.out.println("String is palindrome...");
		else
			System.out.println("String is not palindeome...");
		
	}
}
