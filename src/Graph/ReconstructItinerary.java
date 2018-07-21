package Graph;
import java.util.*;

public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets1 = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<String> ans = findItinerary(tickets1);
		for(String s : ans) System.out.print(s + " ");
		System.out.println();
		List<String> ans2 = findItinerary(tickets2);
		for(String s : ans2) System.out.print(s + " ");
		System.out.println();
	}
	
	public static List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		List<String> route = new LinkedList<>();
		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		visit("JFK", targets, route);
		return route;
	}


	private static void visit(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
		while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
			visit(targets.get(airport).poll(), targets, route);
		route.add(0, airport);
	}
	
	public List<String> findItinerary2(String[][] tickets) {
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
	    List<String> route = new LinkedList<>();
	    Stack<String> stack = new Stack<>();
	    stack.push("JFK");
	    while (!stack.empty()) {
	        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	        route.add(0, stack.pop());
	    }
	    return route;
	}

}
