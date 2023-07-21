import java.util.Map;
import java.util.HashMap;

/**
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        
    Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]  

    Constraints:

        2 <= nums.length <= 10^4

        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
        Only one valid answer exists.
        
        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
public class TwoSum {

    public static void main(String[] args) {
        int[] arrayCaseOne = {2,7,11,15};
        int targetCaseOne = 9;

        int[] arrayCaseTwo = {3,2,4};
        int targetCaseTwo = 6;

        int[] arrayCaseThree = {3,3};
        int targetCaseThree = 6;


        TwoSum execute = new TwoSum();

        System.out.println("My Solution");
        execute.printResult(execute.mySolution(arrayCaseOne, targetCaseOne));
        execute.printResult(execute.mySolution(arrayCaseTwo, targetCaseTwo));
        execute.printResult(execute.mySolution(arrayCaseThree, targetCaseThree));

        System.out.println();

        System.out.println("Better Solution");
        execute.printResult(execute.betterSolution(arrayCaseOne, targetCaseOne));
        execute.printResult(execute.betterSolution(arrayCaseTwo, targetCaseTwo));
        execute.printResult(execute.betterSolution(arrayCaseThree, targetCaseThree));


    }

    private void printResult(int[] results) {
        System.out.print(results[0] + ",");
        System.out.print(results[1]);
        System.out.println();
    }

    /**
    The brute force approach is simple. 
    Loop through each element x and find if there is another value that equals to target−x.

    Complexity Analysis

        Time complexity: O(n^2)
            For each element, we try to find its complement by looping through the rest of the array which takes O(n) time. Therefore, the time complexity is O(n^2).

        Space complexity: O(1)
            The space required does not depend on the size of the input array, so only constant space is used.
     */
    public int[] mySolution(int[] nums, int target) {
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                int item = nums[y];
                int previousItem = nums[x];
                if (target == (item + previousItem)) {
                    return new int[] { x, y };
                }
            }
        }
        return null;
    }

    /**
    It turns out we can do it in one-pass. 
    While we are iterating and inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table. 
    If it exists, we have found a solution and return the indices immediately.

    Complexity Analysis

        Time complexity: O(n)
            We traverse the list containing nnn elements only once. 
            Each lookup in the table costs only O(1) time.

        Space complexity: O(n)
            The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
    public int[] betterSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

}