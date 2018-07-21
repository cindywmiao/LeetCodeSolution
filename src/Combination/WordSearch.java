package Combination;

import DP.Tools;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		Tools t = new Tools();
		t.log(exist(board, "ABCCED"));
		t.log(exist(board, "SEE"));
		t.log(exist(board, "ABCB"));
	}
	
	public static boolean exist(char[][] board, String word) {
		if(board == null || word == null || board.length == 0 || board[0].length == 0 || word.length() == 0) return false;
        boolean result = false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] achar = word.toCharArray(); 
        
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        		if(visited[i][j]) {
        			continue;
        		}
        		else{
        			int index = 0;
        			while(index < achar.length){
        				if(achar[index] == board[i][j]){
        					result = 
        							check(visited, board, achar, i, j, 0, index == 0 ? 0 : index - 1) &&
        							check(visited, board, achar, i, j, index == achar.length - 1? index : index - 1, achar.length - 1);
        				}
        			}
        			visited[i][j] = true;
        		}
        	}
        }
        return result;
    }
	
	public static boolean check(boolean[][] visited, char[][] board, char[] achar, int i, int j, int start, int end){
		
		
		return false;
	}

}
