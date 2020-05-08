import java.util.Arrays;

/*
 * [선택정렬(Selection Sort)] 
 * - 선택 정렬 알고리즘은 잘못된 위치게 들어가 있는 원소를 찾아 그것을 올바른 위치로 옮겨 주는 원소 교환을 사용하여 정렬을 수행
 * - 먼저 제일 작은 원소를 찾아 첫 번째 위치에 있는 원소와 교환하고 다음에는 두 번째로 작은 원소를 찾아 두 번째 위치에 있는 원소와 교환
 * - 이렇게 매번 나머지 a[i], ... , a[n] 원소 중에서 가장 작은 원소를 선택해서 a[i] 원소와 교환하는 작업을 모든 원소가 올바른 위치에 있게 될 때까지 계속하면 오름차순 정렬이 수행
 * - N개의 원소 각각에 대해 N-1번의 비교를 해야 되기 때문에 전체 비교 횟수는 N(N-1)/2가 되어 전체 시간 복잡도는 O(N^2)
 */

public class SelectionSort {
	public static void main(String[] args) {
		int[] data = new int[]{ 3, 2, 5, 1, 4 };
		
		for(int i=0;i<5;i++){
			int min = i;
			
			for(int j=i+1;j<5;j++)
				if(data[j] < data[min]) min = j;
		
			int temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
		
		System.out.print(Arrays.toString(data));
	}
}