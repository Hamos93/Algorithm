import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] data, int left, int right) {
		// 정렬할 범위가 2개 이상의 데이터라면
		if(left < right) {
			// 피벗을 기준으로 2개의 리스트로 분할, 반환 값은 피벗의 위치
			int p = partition(data, left, right);

			// left에서 피벗 위치 바로 앞까지를 대상으로 순환 호출 (단, 피벗은 제외)
			quickSort(data, left, p - 1);
			// 피벗 위치 바로 다음부터 right까지를 대상으로 순환 호출 (단, 피벗은 제외)
			quickSort(data, p + 1, right);
		}
	}

	public static int partition(int[] data, int left, int right) {
		System.out.println("quickSort(" + left + ", "+ right + ") 호출 " );
		int low = left;
		int high = right + 1;

		// 정렬할 리스트의 가장 왼쪽 데이터를 피벗으로 선택
		int pivot = data[left];

		// low와 high가 교차할 때까지 계속 반복
		do {
			// data[low]가 피벗보다 작으면 계속 low를 증가
			do
				low++;
			while(low <= right && data[low] < pivot);

			// data[high]가 피벗보다 크면 high를 감소
			do
				high--;
			while(left <= high && pivot < data[high]);

			// low와 high가 아직 교차하지 않았으면 data[low]와 data[high]를 교환
			if(low < high) {
				int temp = data[low];
				data[low] = data[high];
				data[high] = temp;
			}
		}while(low < high);

		// data[left]와 data[high]를 교환
		int temp = data[left];
		data[left] = data[high];
		data[high] = temp;

		// 피벗의 위치인 high를 반환 
		return high;
	}

	public static void main(String[] args) {
		int[] data = new int[10];

		for(int i=0;i<10;i++)
			data[i] = (int)(Math.random() * 100) + 1;

		System.out.println("[정렬 전 데이터]: " + Arrays.toString(data));

		quickSort(data, 0, data.length - 1);

		System.out.println("[정렬 후 데이터]: " + Arrays.toString(data));
	}
}