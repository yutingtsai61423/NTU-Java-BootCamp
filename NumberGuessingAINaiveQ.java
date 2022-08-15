public class NumberGuessingAINaiveQ {

	public static void main(String[] args) { 
		/*
		 * 寫一個猜數字遊戲的程序（沒玩過這個遊戲的可以參考猜數字）。
		 * 該程序首先生成一個介於 0 和 99 之間的秘密數字，包括 0 和 99。
		 * 然後程序要求玩家猜一個數字。如果輸入值等於秘密數字，則玩家獲勝。
		 * 如果不是，則根據輸入相應地更新範圍。
		 * （例如，假設密碼是 42。如果玩家第一次輸入 50，那麼程序會在屏幕上顯示 (0, 49)。）
		 * 當只剩下一個整數時，玩家輸掉遊戲。
		 * 另外，確保玩家輸入的數字在可行範圍內；否則，要求用戶重做輸入。
		 * 添加一些策略（AI？）來玩這個遊戲，並通過使用這些策略 1e5 次來計算每個獲勝率
		 * 例如，天真的策略是隨機猜測一個數字，其結果約為 66%。
		 */
		/* input:
		 * 用 userinput = (int)(Math.random()*100)
		 * 
		 * algorithm:
		 * 
		 * for i = 0  i < 1e5 i++ {
		 * 	counter = 紀錄總共 在玩了 1e5次遊戲 答對1e5次後  一共花了幾次猜測
		 * }
		 * 
		 * 計算勝率 1e5/counter
		 * 
		 * output :　獲勝率
		 */
		
		

		int counter = 0;
		
		for ( int i = 0; i < 1e5; i++) {
			int min = 0, max = 99;
			int ans = (int)(Math.random()*100); 			
			while (true) {
							
				//System.out.println("(" + min + "," + max + ")?");
				int userinput = (int)(Math.random()*(max+1-min))+ min ; 

				if (userinput == ans) {
					//System.out.println("you win");
					counter ++;
					break;
				} else {
					if (userinput > ans) {
						max = userinput - 1;
					} else {
						min = userinput + 1;
					}
				}
				if (max == min) {
					//System.out.println("you lose");
					break;
				}
				
			}
		}
		System.out.println("一共玩了100000次，猜贏了" + counter + "次");
		System.out.println("獲勝率=" + ((double)counter/1e5)*100 + "%");
		
	}
}


