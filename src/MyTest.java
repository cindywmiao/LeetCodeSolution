import java.util.Random;


public class MyTest {
	
	public static int getIndex(int[] test, int offset){
		int index = 0;
		while(index < test.length){
			if(test[index] > offset) 
				return index;
			else index++;
		}
		return index;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random ran = new Random(); 
		int[] test = new int[10];
		for(int i = 0; i < test.length; i++){
			test[i] = (i - 1 >= 0 ? test[i - 1] : 0) + ran.nextInt(50);
		}
		
		for(int i = 0; i < test.length; i++){
			System.out.print(test[i] + " ");
		}
		System.out.println();
		
		int totalCount = test[test.length - 1];
		

		
		int pageSize = 50, pageIndex = 1, offset = 0;
		while(offset < totalCount){
			offset = pageSize * (pageIndex - 1);
			int start = getIndex(test, offset);
			int end = getIndex(test, offset+ pageSize);
			System.out.println("Offset : " + offset  + " // Start : " + start + " // End : " + end);
			for(int i = start; i <= end; i++){
				int num = 0;
				if(test[i] < offset) num = i > 0 ? test[i] - test[i - 1] : test[i];
				else num = offset - i > 0 ? test[i - 1] : 0;
				System.out.println("	=> " + i  + " num : " + num );
			}
			
			pageIndex++;
			
		}

	}

}
