
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HappyNumber().run();
	}
	
	void run(){
		for(int i = 0 ; i < 100; i++)
			System.out.println(isHappy(i));
	}
	
	
	public boolean isHappy(int n) {
        int[] digits = new int[8];
        
        
        while(n > 9){
        	
        	int i = 0;
        	while(n != 0){
        		digits[i] = n % 10;
        		n = n / 10;
        		i++;
        	}
        
        	int temp = 0;
        	for(int j = 0; j < i; j++) temp += digits[j] * digits[j];
        	//System.out.println(temp);
        	n = temp;
        
        }
        
        if(n == 1) return true;
    	else return false;
        
    }

}
