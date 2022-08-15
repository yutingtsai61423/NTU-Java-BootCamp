import java.util.Scanner;

public class NumberGuessingDesignPatternsQ {

	public static void main(String[] args) {
		/*lab5:*/
		
//		Player player = new SuperAI();
//		Game start = new Game(player);
//		start.run();

		/*lab 5-1*/
		int N = 100;
		simulation(new NaiveAI(), N);
		simulation(new BinarySearchAI(), N);
		simulation(new SuperAI(), N);	
	}
	
	public static void simulation(Player p, int N) {
		int wins = 0;
		for( int i = 0; i < N; i++) {
			Game curr_game = new Game(p);
			curr_game.run();
			if(curr_game.hasWon()) wins++;
		}
		System.out.printf("%15s (%.4f) \n",p.getClass().getName(), (double)wins/N);
	}
}



interface Protocal {
	public int next(int low, int high);
}

class Player implements Protocal {
	private String name;
	public int next(int low, int high) {
		return -1;
	}
	public void reset() {}
}

class HumanPlayer extends Player {
	private Scanner sc;
	public HumanPlayer(){
		sc = new Scanner(System.in); 
	}
	public int next(int low, int high) {
		int number = sc.nextInt();
		return number;
	}
}

class NaiveAI extends Player {
	public int next(int low, int high) {
		int number = (int)(Math.random()*(high+1-low)+low); 
		return number;
	}
}

class BinarySearchAI extends NaiveAI {
	public int next(int low, int high) {
		int number = (int)(low + high)/2;
		return number;
	}
}

class SuperAI extends NaiveAI {
	private int counter = 0;
	public int next(int low, int high) {
		int number = counter++;
		return number;
	}
	public void reset() {
		counter = 0;
	}
}

class Game {
	/*fields*/
	private int secret_number;
	private int high;
	private int low;
	private boolean win_flag = false;
	private Player player;
	
	/*method*/
	public Game(Player player) {
		this.player = player;
	}
	public void set_secret_number() {
		secret_number = (int)(Math.random()*100); 
		low = 0;
		high = 99;
	}
	
	public void run() {
		this.set_secret_number();
		
		while (true) {
//			System.out.println("(" + low + "," + high + ")?");
			int userinput = player.next(low,high);
			
			while (userinput > high || userinput < low) {
//				System.out.println("Out of range. Try again?");
				userinput = player.next(low,high);
			}
			
			if (userinput == secret_number) {
//				System.out.println("bingo.");
				win_flag = true;
				player.reset();
				break;
			} else if (userinput > secret_number) {
					high = userinput - 1;
					
			} else {
					low = userinput + 1;
			}
			
			if (high == low) {
//				System.out.println("GG");
				player.reset();
				break;
			}
		}

		
	}
	public boolean hasWon() {
		if(win_flag)return true;
		else return false;
	}
}
