import java.util.Scanner;

public class NumberGuessingQ {

	/*
	* 	 * 寫一個猜數字遊戲的程序（沒玩過這個遊戲的可以參考猜數字）。
		 * 該程序首先生成一個介於 0 和 99 之間的秘密數字，包括 0 和 99。
		 * 然後程序要求玩家猜一個數字。如果輸入值等於秘密數字，則玩家獲勝。
		 * 如果不是，則根據輸入相應地更新範圍。
		 * （例如，假設密碼是 42。如果玩家第一次輸入 50，那麼程序會在屏幕上顯示 (0, 49)。）
		 * 當只剩下一個整數時，玩家輸掉遊戲。
		 * 另外，確保玩家輸入的數字在可行範圍內；否則，要求用戶重做輸入。
	 */
	public static void main(String[] args) { 
				
		int ans = (int)(Math.random()*100); 
		int min = 0, max = 99;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("(" + min + "," + max + ")?");
			int userinput = sc.nextInt();
			
			while (userinput > max || userinput < min) {
				System.out.println("Out of range. Try again?");
				userinput = sc.nextInt();
			}
			
			if (userinput == ans) {
				System.out.println("bingo.");
				break;
			} else if (userinput > ans) {
					max = userinput - 1;
			} else {
					min = userinput + 1;
			}
			
			if (max == min) {
				System.out.println("GG");
				break;
			}
		}
		sc.close();
	}
				

		
}


