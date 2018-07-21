package Tools;

import java.util.*;

public class Tools{

	public void log(List<Object> l){
		for(Object o : l) log(o);
		System.out.println();
	}
	
	public void log(Object o){
		System.out.println(o);
	}
	
	public void log(Object[] list){
		for(Object o : list) 
			System.out.print(o + " ");
		System.out.println();
	}
}
