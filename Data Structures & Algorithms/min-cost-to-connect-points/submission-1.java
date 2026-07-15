class Solution {
    public int minCostConnectPoints(int[][] points) {
        //build a array of edge and cost
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<points.length-1;i++){
            for(int j=i+1; j<points.length;j++){
                int[] edge = new int[3];
                edge[0]=i;
                edge[1]=j;
                edge[2]=manhattanDistance(points[i], points[j]);
                arr.add(edge);
            }
        }

        Collections.sort(arr, (a,b)-> a[2]-b[2]);
        int ans=0;
        int[] rank = new int[points.length];
        int[] parent=new int[points.length];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        //now time to proced to find the ans
        int noOfEdgeProcessed=0;
        for(int[] edge: arr){
            if(noOfEdgeProcessed==points.length-1) break;
            if(find(edge[0], parent)==find(edge[1], parent)){
                continue;//can cause cycle
            }
            noOfEdgeProcessed++;
            ans+=edge[2];
            union(edge[0], edge[1], parent, rank);
            
        }
        return ans;

    }

    private int manhattanDistance(int[] x, int[] y){
        return Math.abs(x[0]-y[0]) + Math.abs(x[1]-y[1]);
    }

    //make union method
    private void union(int x, int y, int[] parent, int[] rank){
        int px=find(x, parent);
        int py=find(y, parent);
        if(px==py){
            return;
        }
        int rankX=rank[px];
        int rankY=rank[py];
        if(rankX==rankY){
            rank[px]++;
            parent[py]=parent[px];
            return;
        }else if(rankX<rankY){
            parent[px]=parent[py];
        }else{
            parent[py]=parent[px];
        }
    }
    
    private int find(int x, int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x], parent);
    }

}