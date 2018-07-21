import java.util.*;
public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Combination().run();
	}
	
	void run(){
		List<List<Integer>> result = combinationSum3(3, 6);
		for(int i = 0; i < result.size(); i++){
			for(int j  = 0; j <  result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	void log(Object o){
		System.out.println(o);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, k, n, n, visited, new ArrayList<Integer>());
        return result;
    }
    
    void dfs(List<List<Integer>> result, int k, int rest, int n, boolean[] visited, List<Integer> item){
    	
    	if(k == 1){
    		
            if(!visited[rest]){
                item.add(rest);
                result.add(new ArrayList<Integer>(item));
            }
        }
        else{
            for(int i = item.size() == 0 ? 1 : item.get(item.size() - 1) + 1; i < n; i++){
                if(!visited[i] && i <= rest){
                    item.add(i);
                    visited[i] = true;
                    k--;
                    log("rest" + (rest - i));
                    dfs(result, k, rest - i, n, visited, item);
                    visited[i] = false;
                    item.remove(item.size() - 1);
                }
            }
        }
    }

}
