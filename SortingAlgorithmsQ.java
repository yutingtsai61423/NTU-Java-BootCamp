import java.util.Arrays;

public class SortingAlgorithmsQ {

	/* 要分別simulating 模擬 size= i*e3  // i= 1 2 4 8 16 32 64 種size的資料 
	 * 
	 * 當size=1000
	 * int[] data = new int[1000];
	 * 
	 * 裝1000(size)筆資料
	 * 	for (i =0 ~ i < size )
	 * 			data[i]= (int)(Math.random*size)
	 * 
	 * 
	 * @main
	 * 計時 long startTime = System.nanoTime();
	 * 傳入data[]氣泡排序method 傳回排好的陣列 new一個bubble= int[] 接
	 * 計時 long estimatetime = System.nanoTime() - startTime;
	 * 
	 * 計時 long startTime = System.nanoTime();
	 * 傳入data[]選擇排序method 傳回排好的陣列 new一個selection= int[] 接
	 * 計時 long estimatetime = System.nanoTime() - startTime;
	 * 
	 * 計時 long startTime = System.nanoTime();
	 * 傳入data[]插入排序method 傳回排好的陣列 new一個insertion= int[] 接
	 * 計時 long estimatetime = System.nanoTime() - startTime;
	 * 
	 * 計時 long startTime = System.nanoTime();
	 * 傳入data[]Arrays.sort() 傳回排好的陣列 new一個Arraysort= int[] 接
	 * 計時 long estimatetime = System.nanoTime() - startTime;
	 * 
	 * 印出
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
			System.out.println("simulating Arrays.sort:......done");		
			System.out.println("simulating Bubble sort:......done");
			System.out.println("simulating Selection sort:......done");
			System.out.println("simulating Insertionn sort:......done");
			System.out.println("Benchmark (time unit: ms)");
			System.out.printf("%7s%15s%18s%18s%15s\n", "size","Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort");
			for ( int i = 1000; i<=64000; i=i*2) {
				double bubbletime = bubbletime(creatArray(i));
				double selectiontime = selectiontime(creatArray(i));
				double insertiontime = insertiontime(creatArray(i));
				double arraystime = arraystime(creatArray(i));
				System.out.printf("%7d%15.3f%18.3f%18.3f%15.3f\n", i, bubbletime, selectiontime, insertiontime, arraystime);

			}					
	}
	
	public static int[] bubble(int[] data) { //test ok
		for (int i = 0; i < data.length-1; i++) {
			for (int j = 0; j < data.length-i-1; j++) {
				if (data[j] > data[j+1]) {
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
		return data;
	}
	
	public static int[] selection(int[] data) {
		//find min index
		for (int i = 0;  i< data.length-1; i++) {
			int candidate = i;
			for (int j = i+1; j < data.length; j++) {
				if (data[j] < data[candidate]) {
					candidate = j;
				}
		//swap
			}
			int tmp = data[i];
			data[i] = data[candidate];
			data[candidate] = tmp;
		}

		return data;
	}
	
	public static int[] insertion(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int key = data[i];
			int j = i;
			while((j-1)>=0 && data[j-1] > key) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = key;
		}

		return data;
	}
	
	public static int[] creatArray(int size) {
		int[] data = new int[size];
		for ( int i = 0; i < data.length; i++) {
			data[i] = (int)(Math.random()*(data.length));
		}
		return data;
	}
	
	public static double bubbletime(int[] data) {
		long Time0 = System.nanoTime();
		bubble(data);
		long Time1 = System.nanoTime() - Time0;
		return Time1*(1e-6);
	}
	
	public static double insertiontime(int[] data) {
		long Time0 = System.nanoTime();
		insertion(data);
		long Time1 = System.nanoTime() - Time0;
		return Time1*(1e-6);
	}
	
	public static double selectiontime(int[] data) {
		long Time0 = System.nanoTime();
		selection(data);
		long Time1 = System.nanoTime() - Time0;
		return Time1*(1e-6);
	}
	
	public static double arraystime(int[] data) {
		long Time0 = System.nanoTime();
		Arrays.sort(data);
		long Time1 = System.nanoTime() - Time0;
		return Time1*(1e-6);
	}
}
