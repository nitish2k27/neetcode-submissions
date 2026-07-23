class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int min=0;
        int[][] Dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int size=queue.size();//it is basically to make suure that every evry minutue all roteeen oragnes are taken acare if two are rotten in prev iteration then make sure both are checked here;
            for(int i=0;i<size;i++){
                int[] poped=queue.poll();
                int row=poped[0];
                int col=poped[1];
                for(int[] dir:Dir){
                    int nrow=row+dir[0];
                    int ncol=col+dir[1];
                    if(nrow>=0&&nrow<grid.length&&ncol>=0&&ncol<grid[0].length&&grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        fresh--;
                         queue.offer(new int[]{nrow, ncol});
                    }
                }     
            }
            if(!queue.isEmpty()){
                min++;
            }
        }
        return fresh==0?min:-1;
    }
}