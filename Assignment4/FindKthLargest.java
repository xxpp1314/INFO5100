import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < len; i ++){
            minHeap.add(nums[i]);
        }
        for(int i = 0; i < len - k; i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args){

        int[] nums = {3, 2, 1, 5, 6, 4};
        FindKthLargest solution = new FindKthLargest();
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
