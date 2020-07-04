// Time Complexity : O(2n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult to come up with deriving formulae approach and maxCount clubbing tasks
/* Your code here along with comments explaining your approach: Get the task with max occurances and the tasks with maxFreq as max count of tasks.
Use hashmap to help you with that. Calculate number of partitions, empty spots, pending items and idle spots using and deriving mathematical formulas.
Club the same frequency tasks as a single task that updates the formulas. Return the tasks length plus idle times as result.*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){return 0;}
        HashMap<Character, Integer> store = new HashMap<>();
        int partitions = 0, maxFreq = 0, maxCount  = 0, empty = 0, pending  = 0;
        for(int i = 0; i < tasks.length; i++){
            char c = tasks[i];
            store.put(c, store.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, store.get(c));                                             // Get the max frequency of the tasks
        }
        for(char c : store.keySet()){
            if(store.get(c) ==  maxFreq){
                maxCount++;                                                                     // Get the number of tasks having the max frequency
        }
        partitions = maxFreq-1;                                                                 // No of partitions would be highest frequency -1
        empty = (n - maxCount+1) * partitions;                                              // Find the number of empty spots
        pending = (tasks.length) - (maxFreq)*maxCount;                                              // Find the pending number of items
        int idle = Math.max(0, empty - pending);                                        // Put the idle time (positive)
        return tasks.length + idle;                                                     // Return the total length
}
}