import java.util.Arrays;

public class MergeSort {
	private static int[] data;
	private static int[] result;

	/* 합병정렬 */
	public static void mergeSort(int left, int right) {
		if(left < right) {
			/* 리스트의 균등 분할 */
			int mid = (left + right) / 2;
			
			/* 부분 리스트 정렬 */
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			
			/* 합병 */
			merge(left, mid, right);
		}
	}

	/* 합병 */
	public static void merge(int left, int mid, int right) {
		int i = left;	 /* 왼쪽 배열에 대한 인덱스 */
		int j = mid + 1; /* 오른쪽 배열에 대한 인덱스 */
		int k = left;    /* 정렬될 배열에 대한 인덱스 */

		/* 분할 정렬된 배열 합병 */
		while(i <= mid && j <= right) {
			if(data[i] <= data[j]) result[k++] = data[i++];
			else result[k++] = data[j++];
		}

		/* 남아있는 원소 일괄복사 */
		if(mid < i) {
			for(int idx=j;idx<=right;idx++)
				result[k++] = data[idx];
		}else {
			for(int idx=i;idx<=mid;idx++)
				result[k++] = data[idx];
		}
		
		/* 배열 result[]를 배열 data[]로 재복사 */
		for(int idx=left;idx<=right;idx++)
			data[idx] = result[idx];
	}

	public static void main(String[] args) {
		data = new int[10];
		/* 합병정렬은 합병 과정에서 추가적인 공간이 필요 */
		result = new int[data.length];
		
		for(int i=0;i<10;i++)
			data[i] = (int)(Math.random() * 100) + 1;
		
		System.out.println("[정렬 전 데이터]: " + Arrays.toString(data));

		mergeSort(0, data.length - 1);

		System.out.println("[정렬 후 데이터]: " + Arrays.toString(data));
	}
}