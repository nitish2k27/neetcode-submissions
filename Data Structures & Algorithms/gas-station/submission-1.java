class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalcost = 0;
        int totalgas=0;
        int currtank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalcost += cost[i];
            totalgas +=gas[i];
            currtank =currtank+gas[i]-cost[i];

            if (currtank < 0) {
                start = i + 1;
                currtank = 0;
            }
        }

        if (totalgas < totalcost){
            return -1;
        }
        return start;
    }
}