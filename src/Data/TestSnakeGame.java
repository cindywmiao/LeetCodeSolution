package Data;

public class TestSnakeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] food = {{0,1}};
		SnakeGame snakeGame = new SnakeGame(2, 2, food);
		String[] directions = {"R","D"};
		for(String s : directions){
			System.out.println(snakeGame.move(s));
		}
	}

}
