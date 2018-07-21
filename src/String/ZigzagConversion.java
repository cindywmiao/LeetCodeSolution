package String;

public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(convert("PAYPALISHIRING", 4));
	}
	public static String convert(String s, int nRows) {
        if(s == null || s.length() == 0 || s.length() == 1) return s;
        if(nRows == 0 || nRows == 1 ) return s; 
        StringBuilder sb = new StringBuilder();
        
        for(int level = 0; level < nRows; level++){
        	if(level != 0 && level != nRows - 1){
        		int index = level;
        		while(index < s.length() ){
        			sb.append(s.charAt(index));
        			if(index + 2 * (nRows - 1 - level) < s.length())
        				sb.append(s.charAt(index + 2 * (nRows - 1 - level)));
        			index += 2 * (nRows - 1);
        		}
        	}
        	else {
        		int index = level;
        		while(index < s.length()){
        			sb.append(s.charAt(index));
        			index += 2 * (nRows - 1);
        		}
        	}
        }
        
        return sb.toString();
    }

}
