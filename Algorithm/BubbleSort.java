import java.util.Arrays;

/*
 * [버블정렬(Bubble Sort)]
 * - 버블 정렬 알고리즘은 배열을 검사하여 두 인접한 원소가 오름차순 정렬 순서에 맞지 않으면 이들을 서로 교환
 * - 마치 거품이 물 위로 올라가는 것 같이 루프를 한 번 반복할 때마다 가장 큰 값을 가진 원소가 가장 뒤쪽으로 이동
 * - N개의 원소 각각에 대해 N-1번의 비교를 해야 되기 때문에 전체 비교 횟수는 N(N-1)/2가 되어 전체 시간 복잡도는 O(N^2)
 */

public class BubbleSort {
	public static void main(String[] args) {
		int[] data = new int[]{ 3, 2, 5, 1, 4 };
		
		for(int i=4;0<=i;i--){
			for(int j=0;j<i;j++){
				if(data[j+1] < data[j]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
		System.out.print(Arrays.toString(data));
	}
}
