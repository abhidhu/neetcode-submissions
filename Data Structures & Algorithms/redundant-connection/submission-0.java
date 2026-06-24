class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] rank=new int[edges.length];
        int[] parent=new int[edges.length];
        for(int i=0; i<edges.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            if(find(x-1, parent)==find(y-1, parent)){
                return edges[i];
            }
            union(x-1, y-1, parent, rank);
        }
        return new int[0];
    }

    private int find(int x, int[] parent){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank){
        int rootx = find(x, parent);
        int rooty = find(y, parent);
        if(rootx == rooty){
            return;
        }
        if(rank[rootx]==rank[rooty]){
            rank[rootx]++;
            parent[rooty]=parent[rootx];
            return;
        }else if(rank[rooty]<rank[rootx]){
            parent[rooty]=parent[rootx];
        }else{
            parent[rootx]=parent[rooty];
        }
    }
}