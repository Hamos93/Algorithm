
public class ArrayCreateByValueListExample2 {
	private static int add(int[] scores) {
		int sum = 0;
		for(int i=0;i<3;i++)
			sum += scores[i];
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] scores;
		
		// 배열 선언 후 값 목록 대입 시 new 연산자 사용
		scores = new int[] { 83, 90, 87 };
		
		int sum1 = 0;
		for(int i=0;i<3;i++)
			sum1 += scores[i];
		
		System.out.println("총합: " + sum1);
		
		// 배열을 매개변수로 가지는 메서드 호출 시 new 연산자 사용
		int sum2 = add(new int[] { 83, 90, 87 });
		System.out.println("총합: " + sum2 + "\n");
	}
}