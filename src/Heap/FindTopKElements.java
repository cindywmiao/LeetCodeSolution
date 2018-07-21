package Heap;

import java.util.*;

public class FindTopKElements {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BinaryHeap heap = new BinaryHeap(10);
		System.out.println(heap.toString());
		for(int i = 0; i < 3; i++){
			heap.insert(i);
		}
		System.out.println(heap.toString());
		
	}
	
	public static List<Integer> findTopKElements(int[] num){
		ArrayList<Integer> result = new ArrayList<Integer>();
		return result;
	}

}
