/*
 * [에라토스테네스의 체]
 * 에라토스테네스의 체를 사용하여 N 이하의 자연수 중에서 소수 판별
 * 1. 2 ~ N까지 모든 수가 존재
 * 2. 아직 지워지지 않은 수 중에서 가장 작은 수 찾기 -> 그 수는 소수(prime)
 * 3. 가장 작은 수의 배수를 모두 제거
 */
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		int N = 10000;

		boolean[] prime = new boolean[N + 1];
		prime[0] = true;
		prime[1] = true;

		for(int i=2;i<=N;i++) {
			if(!prime[i]) {
				for(int j=i+i;j<=N;j+=i) {
					if(!prime[j]) prime[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(!prime[i]) {
				cnt++;
				
				sb.append(i + " ");
			}
		}
		
		System.out.println("[1부터 " + N + "까지의 모든 소수]: " + cnt + "개");
		System.out.print(sb.toString().trim());
	}
}