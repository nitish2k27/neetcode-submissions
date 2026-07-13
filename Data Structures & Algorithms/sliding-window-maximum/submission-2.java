class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new ArrayDeque<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Process remaining windows
        for (int right = k; right < nums.length; right++) {

            // Maximum of previous window
            list.add(nums[queue.peekFirst()]);

            // Remove indices outside current window
            while (!queue.isEmpty() && queue.peekFirst() <= right - k) {
                queue.pollFirst();
            }

            // Remove smaller elements from the back
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.addLast(right);
        }

        // Add max of last window
        list.add(nums[queue.peekFirst()]);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}