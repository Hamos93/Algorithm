import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] data = new int[10];
		
		for(int i=0;i<10;i++)
			data[i] = (int)(Math.random() * 100) + 1;
		
		System.out.println("[정렬 전 데이터]: " + Arrays.toString(data));
		
		/* 삽입정렬 */
		// 인덱스 1부터 시작 -> 맨 앞의 요소는 이미 정렬된 상태
		for(int i=1;i<10;i++) {
			// 현재 삽입될 숫자
			int key = data[i];
			
			// 현재 정렬된 배열은 (i-1)까지이므로 i-1번째부터 역순으로 진행
			int j = i - 1;
			while(0 <= j && key < data[j]) {
				data[j + 1] = data[j];
				j--;
			}

			data[j + 1] = key;
		}

		System.out.println("[정렬 후 데이터]: " + Arrays.toString(data));
	}
}