import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] data = new int[10];
		
		for(int i=0;i<10;i++)
			data[i] = (int)(Math.random() * 100) + 1;
		
		System.out.println("[정렬 전 데이터]: " + Arrays.toString(data));
		
		/* 선택정렬 */
		for(int i=0;i<10;i++) {
			// 최솟값을 저장할 인덱스
			int idx = i;
			
			// 최솟값 탐색
			for(int j=i+1;j<10;j++)
				if(data[j] < data[idx]) idx = j;
			
			System.out.println("[" + data[i] + "] [" + data[idx] + "] 교환");
			
			int temp = data[i];
			data[i] = data[idx];
			data[idx] = temp;
		}

		System.out.println("[정렬 후 데이터]: " + Arrays.toString(data));
	}
}