package Data;
import java.util.*;

public class SnakeGame {
	int width, height, length, count;
	int[][] food;
    LinkedList<int[]> position;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
    	this.width = width;
    	this.height = height;
    	this.food = food;
    	int[] start = new int[2];
    	start[0] = 0;
    	start[1] = 0;
    	position = new LinkedList<>();
    	position.offer(start);
    	length = 0;
    	count = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	if(length < 0) return -1;
    	int[] node = position.getLast();
    	int x = node[0], y = node[1];
        if(direction.equals("R")) y++;
        else if(direction.equals("L")) y--;
        else if(direction.equals("U")) x--;
        else if(direction.equals("D")) x++;
        
        if(x < 0 || x >= height || y < 0 || y >= width){
        	length = -1;
        	return length;
        }
        
        int[] p = new int[2];
        p[0] = x;
        p[1] = y;
        if(position.contains(p)) return -1;
        
        if(food[count][0] == x && food[count][1] == y){
            length++;
            count++;  
        } 
        else{
        	position.poll();
        }
        position.offer(p);
        return length;
    }
}
