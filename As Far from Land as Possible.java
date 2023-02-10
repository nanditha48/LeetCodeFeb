class Solution {
    
    class Point {
        int x;
        int y;
 
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }
 
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int maxDistance(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        for(int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        
        Queue<Point> openList = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    openList.add(new Point(j, i));
                    cost[i][j] = 0; 
                }
            }
        }
        
        if(openList.size() == 0 || openList.size() == grid.length * grid[0].length) {
            return -1;
        }
        
        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};//x,y
        while(openList.size() > 0) {
            Point curr = openList.poll();
            for(int[] d : direction) {
                int nextY = curr.y + d[1];
                int nextX = curr.x + d[0]; 
                if(nextY < grid.length &&nextY >= 0
                  && nextX < grid[0].length && nextX >=0
                  && cost[nextY][nextX] > cost[curr.y][curr.x] + 1) {
                    cost[nextY][nextX] = cost[curr.y][curr.x] + 1;
                    openList.add(new Point(nextX, nextY));
                }
                
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < cost.length; i++) {
            //System.out.println(Arrays.toString(cost[i]));
            for(int j = 0; j < cost[0].length; j++) {
                max = Math.max(cost[i][j], max);
            }
        }
        return max;
    }
}
