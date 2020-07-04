// Time Complexity : O(2n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was under the impression of comparing both the neighbors together but this is different.
/* Your code here along with comments explaining your approach: Make a single pass from start to end comparing whether the current neighbor has more
rating than the left neighbor and if this is the case, increment the candies count for the current neighbor. Then make a right to left side,
if the rating of current neighbor is higher than the left neighbor, and if the candies is lesser update the count more than the candies that the neighbor has.
*/
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){return 0;}
        int[] candies = new int[ratings.length];
         Arrays.fill(candies, 1);
        for(int i = 0; i < ratings.length-1; i++) {
            if(ratings[i] > ratings[i+1]){                                            // left to right pass rating check
                candies[i] = candies[i+1]+1;
            }
        }
        for(int i = candies.length-1; i > 0; i--){
            if(ratings[i] > ratings[i-1]){                                              // right to left pass rating check
                candies[i] = Math.max(candies[i],candies[i-1] + 1);                     // update candies
            }
        }
        return IntStream.of(candies).sum();
    }
}