package String;

public class ReverseInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("//" + reverseWords("    1  3   5  ") + "\\");
	}
	
	public static String reverseWords(String s) {
        
        if(s == null || s.equals("")){
            return s;
        }
        
        s = s.trim();
        
        StringBuilder res = new StringBuilder();
        String[] arr = s.split(" ");
        
        System.out.println("************");
        for(int i = 0; i < arr.length; i++) System.out.println(arr[i]);
        System.out.println("************");
        for(int i = arr.length -1; i >= 0; i--){
            if(!arr[i].equals("")){
                if(i == 0)
                    res.append(arr[i]);
                else res.append(arr[i]).append(" ");
            }
        }
    
        return res.toString();
    }

}
