import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_AdjacencyList {
	private static int N;
	private static List<Integer>[] adjList;
	
	private static void bfs(int node){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		
		queue.offer(node);
		visit[node] = true;
		
		while(!queue.isEmpty()){
			int curr = queue.poll();
			
			System.out.print(curr + " ");
			
			for(int next:adjList[curr]){
				if(!visit[next]){
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
		
		// ArrayList 1차원 배열 생성
		adjList = new ArrayList[N + 1];
		for(int i=1;i<N+1;i++)
			adjList[i] = new ArrayList<>();
		
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			
			// 정점 간 연결 관계
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(u == -1 && v == -1) break;
			
			adjList[u].add(v);
			adjList[v].add(u);
		}

		bfs(startNode);
	}
}