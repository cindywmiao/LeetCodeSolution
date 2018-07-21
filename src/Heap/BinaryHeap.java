package Heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
	private int capacity;
	private int currentsize;
	private List<Integer> array;
	public BinaryHeap(int n){
		capacity = n;
		currentsize = 0;
		array = new ArrayList<Integer>();
	}
	
	public boolean isEmpty(){
		return currentsize == 0;
	}
	
	public boolean isFull(){
		return currentsize + 1 == capacity;
	}
	
	public int left(int i){
		return 2 * i + 1;
	}
	
	public int right(int i){
		return 2 * i + 2;
	}
	
	public int father(int i){
		return (i-1) / 2;
	}
	
	public void insert(int x){		
		//int index = currentsize;    
		array.add(x);
	    trickleUp(currentsize++);
		
		//currentsize++;
	}
	
	public void trickleUp(int index){
		int parent = (index-1) / 2;
		int bottom = array.get(index);

		while( index > 0 &&
				array.get(parent) < bottom){
			array.set(index, array.get(parent));  // move it down
			index = parent;
			parent = (parent-1) / 2;
		}  // end while
		array.set(index, bottom);
    }
	
	public int deleteMin(){
		if(isEmpty()) return -1;
		int min = array.get(0);
		array.set(0, array.get(currentsize--));
		trickDown(0);
		return min;
	}
	
	public void trickDown(int index){
		int child = 0;
		int temp = array.get(index);
		while(index * 2 <= currentsize){
			child = index * 2;
		}
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < currentsize; i++){
			sb.append(array.get(i)).append(" ");
		}
		return sb.toString();
	}
}
