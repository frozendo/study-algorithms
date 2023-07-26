package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string s, find the length of the longest substring  without repeating characters.

 Example 1:
     Input: s = "abcabcbb"
     Output: 3

     Explanation: The answer is "abc", with the length of 3.

 Example 2:
     Input: s = "bbbbb"
     Output: 1

     Explanation: The answer is "b", with the length of 1.

 Example 3:
     Input: s = "pwwkew"
     Output: 3

     Explanation: The answer is "wke", with the length of 3.
     Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat execute = new LongestSubstringWithoutRepeat();
        String case1 = "abcabcbb";
        String case2 = "bbbbb";
        String case3 = "pwwkew";

        execute.mySolutionCases(case1, case2, case3);
        execute.bestSolutionCases(case1, case2, case3);
    }

    private void mySolutionCases(String case1, String case2, String case3) {
        System.out.println("### Using my solution ###");
        System.out.println("Case 1: " + this.mySolution(case1));
        System.out.println("Case 2: " + this.mySolution(case2));
        System.out.println("Case 3: " + this.mySolution(case3));

        System.out.println();
    }

    private void bestSolutionCases(String case1, String case2, String case3) {
        System.out.println("### Using best solution ###");
        System.out.println("Case 1: " + this.bestSolution(case1));
        System.out.println("Case 2: " + this.bestSolution(case2));
        System.out.println("Case 3: " + this.bestSolution(case3));

        System.out.println();
    }

    /**
     This solution uses brute force to find the longest substring.
     Using two for loops, we create two pointers and pass through all possible matches from left to right.
     The first for controlling the left pointer, starting at the first char of the string.
     The internal for controlling the right pointer, which defines the last index that will be analyzed. This for begins in the position i + 1, with i representing the index of the first for.
     When the second for stops, we increment the index of the first for and start the internal for again.

     Complexity: O(n²)
     */
    private int mySolution(String s) {
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            String analyseString = String.valueOf(s.charAt(i));
            int currentCount = 1;
            for (int j = i + 1; j < s.length(); j++) {
                String addChar = String.valueOf(s.charAt(j));
                if (analyseString.contains(addChar)) {
                    break;
                }
                analyseString = analyseString + addChar;
                currentCount++;
            }
            if (maxCount < currentCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    /**
     To optimize the process, we can use the Map data structure.
     We store the index value of each element in the string.
     When a repeated element is encountered, we update the left pointer by increasing it to (index of the first occurrence of the repeated element + 1).
     This ensures that the repeated element is removed from the current window. By doing this, we solve the problem of unnecessary moves made by the left pointer.

     Simultaneously, we maintain a separate pointer called "longestSubstringCount" to keep track of the longest substring found so far.

     Complexity: O(n)
     */
    private int bestSolution(String s) {
        Map<Character,Integer> uniq= new HashMap<>();
        int left=0,right=0,longestSubstringCount= 0;
        while(right<s.length()) {
            if(uniq.containsKey(s.charAt(right)))
            {
                left = Math.max(uniq.get(s.charAt(right))+1,left);
            }
            uniq.put(s.charAt(right),right);
            longestSubstringCount = Math.max(longestSubstringCount,right-left+1);
            right++;

        }
        return longestSubstringCount;
    }

}
