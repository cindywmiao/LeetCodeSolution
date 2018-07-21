package Sort;

public class BubbleSort {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[] num = {4,6,8,9,0,1,3,2,7};
		bubbleSort(num);
		for(int i : num) System.out.print(i + " ");
		System.out.println();
		int[] num2 = {4,6,8,9,0,1,3,2,7};
		selectSort(num2);
		for(int i : num2) System.out.print(i + " ");
	}
	
	public static void bubbleSort(int[] a){
		int temp=0;  
	    for(int i=1;i<a.length;i++){  
	       int j=i-1;  
	       temp=a[i];  
	       for(;j>=0&&temp<a[j];j--){  
	           a[j+1]=a[j];  
	       }  
	       a[j+1]=temp;  
	    } 
	}
	
	public static void selectSort(int[] a){
		int position=0;  
	    for(int i=0;i<a.length;i++){       
	    	int j=i+1;  
	        position=i;  
	        int temp=a[i];  
	        for(;j<a.length;j++){  
	              if(a[j]<temp){  
	                 temp=a[j];  
	                 position=j;  
	              }  
	        }  
	        a[position]=a[i];  
	        a[i]=temp;  
	   }  
	}

}
