package chinni;

public class JewelsandStones {
	
	static int jands(String J,String s){
		int count=0;
		for(int i=0;i<J.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(J.charAt(i)==s.charAt(j)) {
					count++;
				}
				
			}
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c=jands("aA","aAAbbbb");
		System.out.println(c);

	}

}
