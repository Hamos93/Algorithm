import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] data = new int[10];
		
		for(int i=0;i<10;i++)
			data[i] = (int)(Math.random() * 100) + 1;
		
		System.out.println("[정렬 전 데이터]: " + Arrays.toString(data));
		
		/* 버블정렬 */
		for(int i=9;0<=i;i--) {
			for(int j=0;j<i;j++) {
				// 인접한 요소를 비교 후 교환
				if(data[j+1] < data[j]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}

		System.out.println("[정렬 후 데이터]: " + Arrays.toString(data));
	}
}