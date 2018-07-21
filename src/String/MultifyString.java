package String;

public class MultifyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("123", "456"));
	}
	
	public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] temp = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++){
        	int a = num1.charAt(i) - '0';
        	for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                temp[i + j] += a * b;
            }
        }
        
        for(int i = 0; i < temp.length; i++){
        	System.out.println(temp[i]);
        }
        
        int carry = 0;
        for(int i = 0; i < temp.length; i++){
        	sb.append((temp[i] + carry) % 10);
        	carry = temp[i] / 10;
        }
        
        
        sb = sb.reverse();
        
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
	
	//public static String multiply(String num1, char c){
		
	//}
	
	public static String add(String num1, String num2){
		StringBuilder sb = new StringBuilder();
		int index1 = num1.length() - 1, index2 = num2.length() - 1;
		boolean carry = false; 
		while(index1 >= 0 && index2 >= 0){
			int temp = Integer.parseInt("" + num1.charAt(index1)) + Integer.parseInt("" + num2.charAt(index2));
			if(carry) temp++;
			
			if(temp > 9){
				temp = temp - 10;
				carry = true;
			}
			else{
				carry = false;
			}
			sb.append(temp);
			index1--;
			index2--;
		}
		
		
		return sb.toString();
	}

}
