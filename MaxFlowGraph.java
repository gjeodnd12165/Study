import java.util.*;

/**
 * It is using Edmond-Karp algorithm to get the answer.
 */
public class MaxFlowGraph {
    public int INF = 1000000000;
    public final int MAX_V;
    public ArrayList<Edge> adj[];
    
    public MaxFlowGraph(int MAX_V){
        this.MAX_V = MAX_V;
        this.adj = new ArrayList[MAX_V];
        for(int i = 0;i < MAX_V;i++) adj[i] = new ArrayList<>();
    }

    //더 나은 방법이 있을 것 같음
    public void addEdge(int v, int u, int w){
        Edge e1 = new Edge(u,w), e2 = new Edge(v,0);
        e1.dual = e2;
        e2.dual = e1;
        adj[v].add(e1);
        adj[u].add(e2);
    }
    public void addBidirectionalEdge(int v, int u, int w){
        Edge e1 = new Edge(u,w), e2 = new Edge(v,w);
        e1.dual = e2;
        e2.dual = e1;
        adj[v].add(e1);
        adj[u].add(e2);
    }


    public int maxFlow(int start, int end){
        int total = 0, s = start, e = end;
        while(true){
            int[] prev = new int[MAX_V];
            Edge[] path = new Edge[MAX_V]; // 경로 상의 간선들을 저장하여 나중에 참조
            Arrays.fill(path,new Edge());
            Arrays.fill(prev,-1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(s);
            while(!q.isEmpty() && prev[e] == -1){
                int curr = q.poll();
                for(Edge edge : adj[curr]){
                    int next = edge.to;
                    if(edge.spare() > 0 && prev[next] == -1){
                        q.offer(next);
                        prev[next] = curr;
                        path[next] = edge;
                        if(next == e) break;
                    }
                }
            }
            if(prev[e] == -1) break;

            int flow = INF;
            for(int i = e;i != s;i = prev[i]){
                flow = Math.min(flow, path[i].spare());
            }

            for(int i = e;i != s;i = prev[i]){
                path[i].addFlow(flow);
            }

            total += flow;
        }
        return total;
    }

    /**
     * @apiNote It returns muliple lines of contents.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < MAX_V;i++){
            if(adj[i].size() == 0) continue;
            sb.append(i+" : ");
            for(Edge e : adj[i]){
                sb.append(e.toString()+", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }
        return sb.toString();
    }

    private class Edge{
        int to, c, f;
        Edge dual;
        Edge(){
            this(-1,0);
        }
        Edge(int to, int c){
            this.to = to;
            this.c = c;
            this.f = 0;
            this.dual = null;
        }
        int spare(){
            return c - f;
        }
        void addFlow(int ef){
            f += ef;
            dual.f -= ef;
        }
        @Override
        public String toString() {
            return f+"/"+c+"=>"+to;
        }
    }

}
