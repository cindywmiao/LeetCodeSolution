package Graph;
import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 3;
		int[][] prerequisites = {{0,1},{0,2},{1,2}};
		System.out.println(canFinish2(numCourses, prerequisites));
	}
	
	public static boolean canFinish2(int numCourses, int[][] prerequisites){
		boolean[][] matrix = new boolean[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            if (!matrix[pair[1]][pair[0]])
                indegree[pair[0]]++; //duplicate case
            matrix[pair[1]][pair[0]] = true;
        }
        
        for(int i = 0; i < numCourses; i++) System.out.print(indegree[i] + " ");
        System.out.println();

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i< numCourses; i++) {
            if (indegree[i] == 0){
            	queue.offer(i);
            	//System.out.println(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            System.out.println(course);
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i]) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                    	//System.out.println(i);
                }
            }  
        }
        return count == numCourses;
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] pair : prerequisites){
            if(!map.containsKey(pair[0])) map.put(pair[0], new HashSet<Integer>());
            map.get(pair[0]).add(pair[1]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i= 0; i < numCourses; i++){
            if(!map.containsKey(i)){
                queue.offer(i);
                System.out.println(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
                Set<Integer> value = entry.getValue();
                if(value.contains(course)){
                    value.remove(course);
                    if(value.isEmpty()){
                        queue.offer(entry.getKey());
                        System.out.println(entry.getKey());
                    }
                }
            }
        }
        
        return true;
    }

}
