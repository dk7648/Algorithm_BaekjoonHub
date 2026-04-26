class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int max = 0;
        for(int i=0; i<triangle.length; i++) {
            for(int k=0; k<triangle[i].length; k++) {
                int t = 0;
                if(i < 1) continue;
                else if(k < 1) triangle[i][k] += triangle[i-1][k];
                else if(k+1 == triangle[i].length) triangle[i][k] += triangle[i-1][k-1];
                else {
                    triangle[i][k] += Math.max(triangle[i-1][k-1], triangle[i-1][k]);
                }
                max = Math.max(max, triangle[i][k]);
            }
        }
        System.out.println(max);
        return max;
    }
}