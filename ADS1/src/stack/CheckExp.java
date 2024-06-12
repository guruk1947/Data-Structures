package stack;

public class CheckExp {

	private static boolean match(char c1,char c2) {
		if(((c1=='(') && (c2==')')) || ((c1=='[') && (c2==']')) || ((c1=='{') && (c2=='}')))
			return true;
		return false;
	}
	public static boolean check(String exp) {
		char c1, c2;
		CharStack st = new CharStack();
		for(int i=0;i<exp.length();i++) {
			c2=exp.charAt(i);
			if((c2=='[') || (c2=='{') || (c2=='('))
				st.push(c2);
			if((c2==']') || (c2=='}') || (c2==')'))
			{
				if(st.isEmpty())
				{	System.out.println("closing are Extra..");
				   	return false;}
				c1=st.pop();
				if(!match(c1,c2))
				{
					System.out.println("mismatch..");
					return false;
				}
			}	
		}
		if(st.isEmpty()) {
			return true;
		}else {
			System.out.println("Opening are Extra..");
			return false;

		}
	}
	public static void main(String[] args) {
		boolean b = check("[2*(3+2)]");
		if(b)
			System.out.println("Exp is valid..");
		else {
			System.out.println("Exp is invalid..");
		}
	}
}
