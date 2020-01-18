import java.util.Arrays;

public class Homogeneous {
	private static int[] data;
	private static int[] res;
	
	// 중복조합(Homogeneous): 순서가 중요하지 않고 (123 == 321), 중복을 허용하는 경우
	private static void homogeneous(int n, int r, int depth, int start){
		if(depth == r){
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=start;i<n;i++){
			res[depth] = data[i];
			homogeneous(n, r, depth + 1, i);
		}
	}
	
	public static void main(String[] args) {
		int N = 5;
		int R = 3;
		
		data = new int[]{ 1, 2, 3, 4, 5 };
		res = new int[R];
		
		homogeneous(N, R, 0, 0);
	}
}