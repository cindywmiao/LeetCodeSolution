import java.util.*;
public class LRUCache {

	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		this.len = 0;
	}
	
	private void removeNode(DoubleLinkedListNode n){
		DoubleLinkedListNode curr = n;
		DoubleLinkedListNode pre = curr.pre;
		DoubleLinkedListNode post = curr.next;
		if(pre != null){
			pre.next = post;
		}
		else{
			head = post;
		}
		
		if(post != null){
			post.pre = pre;
		}
		else{
			end = pre;
		}
	}
	
	private void setHead(DoubleLinkedListNode n){
		n.next = head;
		n.pre = null;
		if(head != null){
			head.pre = n;
		}
		
		head = n;
		if(end == null) end = n;
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		}
		else{
			return -1;
		}
	}
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		}
		else{
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
			if(len < capacity){
				setHead(newNode);
				map.put(key, newNode);
				len++;
			}
			else{
				map.remove(end.key);
				end = end.pre;
				if(end != null){
					end.next = null;
				}
				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}

}

