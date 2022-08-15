import java.util.Scanner;

public class ContagionControlQ {

	public static void main(String[] args) {
		/*
		 * 病毒COVID-19（又名武漢冠狀病毒）是通過與感染者的密切接觸傳播的。
		 * 現在您將設計一種算法來查找從一個人到另一個人的病毒鏈，識別並隔離這些人。
		 * 為簡單起見，設 N 為公民的數量，每個用 0、1、2、...、N-1 表示。
		 * 然後每個公民寫下他/她接觸的公民。
		 * 為避免手動輸入這些數字，請使用混洗算法生成 0、1、2、...、N - 1 的隨機序列進行測試。
		 * 請注意，所有元素都是不同的。
		 * 例如，考慮 N = 16 並從第一個公民開始。一個可能的輸出如下所示。
		 * */

		/*input(1)
		 *enter number of citizens
		 * 用Scanner sc 
		 * int N = sc.nextInt();接收輸入的數字
		 * 
		 */
		System.out.println("Enter number of citizens:");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		/*algorithm(1)
		 * 建立int[] array = new array[N] (編號 0~N-1)
		 * 把值依序存入array[0~n-1]
		 * shuffle algorithm 隨機產生index 並依序交換
		 * array[0] 隨機選一個index 8 跟他交換值  [0]=8 [1]=1        [8]=0  [11]=11
		 * 
		 * for(  array[i] i從0開始 到N-1 )		 i=2時 index要隨機從2~N-1隨機抽 
		 * 要交換的index = Math.random*(N-i)+i 
		 * tmp=array[i]
		 * array[i]=array[index]
		 * array[index]=tmp
		 * 
		 *output(1)
		 * id=		 
		 * for迴圈印出id 0~N-1
		 * contactee=
		 * for 印出 array[換過位置的]
		 */

		int[] array = new int[N];
		
		System.out.print("\tId\t");
		for ( int i = 0; i < array.length; i++) {
			array[i] = i;
			System.out.print(array[i] + "\t");
		}
		
		System.out.print("\n Contactee\t");
		for ( int i =0; i < array.length; i++) {
			int index = (int)(Math.random()*(N-i)+i); 
			int tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
			System.out.print(array[i] + "\t");
		}	
		/* input(2)
		 * sysout: Enter infected
		 * new int indexInfected[0] = sc.nextInt()
		 * 檢查 array[indexInfected[0]] 是否存在indexInfected陣列 
		 * 若有 停止 並輸出陣列元素(被隔離的人)
		 * 若否 存入indexInfected[1] 
		 * 
		 * 並檢查array[indexInfected[1]] 是否存在indexInfected陣列
		 * 若有 停止 並輸出陣列元素(被隔離的人)
		 * 若否 存入indextIfected[2]
		 * 
		 * 並檢查array[indexInfected[2]] 是否存在indexInfected陣列
		 * 若有 停止 並輸出陣列元素(被隔離的人)
		 * 若否 存入indextIfected[3]
		 * 
		 * 上一個array[indexInfected]的值value 是下一個的索引值array[array[indexInfected]] 
		 *  把indexInfected或存入新陣列(長度N)
		 * 
		 * */
		System.out.println("\n-----------------\nEnter id of infected citizen:");
		int[] indexInfected = new int[N];
		
		for (int i = 0; i < indexInfected.length; i++) {
			indexInfected[i]=-1;
		}
		
		indexInfected[0] = sc.nextInt();
		System.out.print("These citizens are to be self-isolated in the following 14 days:\n");
		
		boolean flag = false;
		loop:
		for (int i = 0; i < array.length; i++) { 
			for (int index2 : indexInfected) {
				if (index2 == array[indexInfected[i]]) {
																
					flag = true;
					break loop;
				}
			}
			if(!flag) {
					indexInfected[i+1]=array[indexInfected[i]];
				}
		}
		
		for (int i = 0; i < indexInfected.length; i++) {
			if(indexInfected[i]<0) 
				break;
			else
				System.out.print(indexInfected[i] + " ");
		}
		

//		int infectedArrTail = 1;
//		// will not change
//		int captin = sc.nextInt();  // 上面 array
//		indexInfected[0] = captin;
//		int candidate = array[captin];
//
//		System.out.print(captin + " ");
//		
//		while (candidate != captin) {
//			System.out.print(candidate + " ");
//			
//			// Not repeat yet, insert candidate to infected array
//			indexInfected[infectedArrTail++] = candidate;
//			candidate = array[candidate];
//		}
	}

}
