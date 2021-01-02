import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	private int index = 0;
	private int distance = 0;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}

	// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node other) {
		if(this.distance < other.distance) return -1;
		
		return 1;
	}
}

public class Dijkstra {
	private static final int INF = (int) 1e9;
	private static int N, M;
	private static ArrayList<ArrayList<Node>> graph;
	private static int[] distance;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		// 시작노드로 가기위한 최단경로는 0으로 설정하여 큐에 삽입
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			// 가장 최단거리가 짧은 노드
			Node node = pq.poll();
			
			int cur = node.getIndex();
			int dist = node.getDistance();
			
			// 현재 노드가 이미 방문한 노드라면 무시
			if(distance[cur] < dist) continue;
			
			// 현재 노드와 연결된 다른 인접노드 확인
			for(int i=0;i<graph.get(cur).size();i++) {
				int cost = distance[cur] + graph.get(cur).get(i).getDistance();
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < distance[graph.get(cur).get(i).getIndex()]) {
					distance[graph.get(cur).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(cur).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());

		// 그래프(인접리스트) 및 최단거리 테이블 생성
		graph = new ArrayList<ArrayList<Node>>();
		distance = new int[100001];
		
		for(int i=0;i<=N;i++)
			graph.add(new ArrayList<Node>());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
	
			// u번 노드에서 v번 노드로 가는 비용이 c
			graph.get(u).add(new Node(v, w));
		}
		
		// 최단거리 테이블 무한값으로 초기화
		Arrays.fill(distance, INF);
		
		dijkstra(start);

		// 모든 노드로 가기위한 최단거리 출력
		for(int i=1;i<=N;i++) {
			// 도달할 수 없는 경우 무한(INFINITY) 출력
			if(distance[i] == INF) System.out.println("INFINITY");
			else System.out.println(distance[i]);
		}
	}
}