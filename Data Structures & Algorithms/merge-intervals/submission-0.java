class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: If there are no intervals or just one, no merging is needed
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        List<int[]> list = new ArrayList<>();
        
        // If we do not sort, we would have to compare every interval with every other interval O(N^2)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] tocompare = intervals[0];
        list.add(tocompare); // FIX 1: Must add the first interval to seed the list!

        for (int i = 1; i < intervals.length; i++) {
            if (tocompare[1] >= intervals[i][0]) {
                // NOTE: Java stores OBJECT REFERENCES (memory addresses) in the list, not copies.
                // Since 'tocompare' points to the same array object already inside 'list',
                // modifying 'tocompare[1]' instantly updates the value inside the list. 
                tocompare[1] = Math.max(tocompare[1], intervals[i][1]);
            } else {
                tocompare = intervals[i];
                list.add(tocompare);
            }
        }    
        return list.toArray(new int[list.size()][]);
    }
}