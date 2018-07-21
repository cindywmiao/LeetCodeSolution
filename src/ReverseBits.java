
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReverseBits().run();
	}
	
	void run(){
		int x = 294967295;
		System.out.println(reverseBits(x));
	}

	public int reverseBits(int n) {
        int res = 0, i = 0;
        boolean[] bits = new boolean[32];
        while(n != 0){
            if(n % 2 != 0) bits[i] = true;
            n = n / 2;
            i++;
        } 

        for(boolean b : bits){
        	res = res * 2 + (b ? 1 : 0);
        }
        
        return res;
    }
}
