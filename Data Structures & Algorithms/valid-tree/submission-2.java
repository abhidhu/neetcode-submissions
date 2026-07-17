class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank= new int[n];
        for(int i=0;i<n;i++)
          parent[i]=i;

        for(int i=0; i<edges.length;i++){
            int x = edges[i][0];
            int y=edges[i][1];
            if(find(x, parent)==find(y, parent)) return false;//cycle
            merge(x, y, parent, rank);
        }
        int p =find(0, parent);

        for(int i=1;i<n;i++){
            if(p!=find(i, parent)) return false;//forest
        }

        return true;
    }


    private void merge(int x, int y, int[] parent, int[] rank){
        int px=find(x, parent);
        int py=find(y, parent);

        if(px==py) return;

        int rx=rank[px];
        int ry=rank[py];

        if(rx==ry){
            rank[px]++;
            parent[py]=px;
        } else if (rx>ry){
             parent[py]=px;
        }else{
            parent[px]=py;
        }
    }
    private int find(int x, int[] parents){
        if(x==parents[x]) return x;
        return parents[x]=find(parents[x], parents);
    }
}
