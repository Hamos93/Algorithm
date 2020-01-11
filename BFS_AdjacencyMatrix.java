import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_AdjacencyMatrix {
	private static int N;
	private static int[][] adjMatrix;
	
	private static void bfs(int startNode){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		
		queue.offer(startNode);
		visit[startNode] = true;
		
		while(!queue.isEmpty()){
			int curr = queue.poll();
			
			System.out.print(curr + " ");
			
			for(int next=1;next<N+1;next++){
				if(!visit[next] && adjMatrix[curr][next] == 1){
					queue.offer(next);
					visit[next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 시작 정점
		int startNode = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N + 1][N + 1];
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			
			// 정점 간 연결 관계
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(u == -1 && v == -1) break;
			
			adjMatrix[u][v] = adjMatrix[v][u] = 1;
		}
		
		bfs(startNode);
	}
}