class Solution {
    public int islandPerimeter(int[][] grid) {
        int landpices=0;
        int neighbourtolandpices=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    landpices++;
                    if(j+1<grid[0].length&&grid[i][j+1]==1){
                        neighbourtolandpices++;
                    }
                    if(i+1<grid.length&&grid[i+1][j]==1){
                        neighbourtolandpices++;
                    }
                }
            }
        }
        return landpices*4-neighbourtolandpices*2;
    }
}