package String;

/**

 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

 P      A       H       N
 A  P   L   S   I   I   G
 Y      I       R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);


 Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

 Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:
         P          I           N
         A      L   S       I   G
         Y  A       H   R
         P          I

 Example 3:
    Input: s = "A", numRows = 1
    Output: "A"
 */

public class ZigZagString {

    /**
     I try to use just one for loop, that is responsible to run through the string received as parameter.
     We start get the substring from the first index of the String until the index equivalent to the numRows parameter number.
     There we start the for loop, with i = numRows. In this way our loop will run (s.length() - numRows) number of times.
     As we walk through the string, we try to put the current letter (s.charAt(i)) in the correct position at the result string.
     To do this, when we are going up in the zigzap string, we add the multiFactor value to our number. When we are going down in the zigzag, we remove the multifactor from our number.
     In this way, we can calculate the correct position to the char that we are get now by getting result.length() - number.
     With the endIndex calculated, we use substring method to rebuild the result string, putting the current char at the correct position.
     In the end, we have the result string in the way we want.
     */

    public String mysolution(String s, int numRows) {

        if (numRows == 1 || s.length() < numRows) {
            return s;
        }

        String result = s.substring(0, numRows);
        int countRows = numRows - 1;
        int number = 1;
        int multiFactor = 2;
        boolean goDown = countRows == 1;

        for (int i = numRows; i < s.length(); i++) {
            int endIndex = result.length() - number;

            if (number <= 0) {
                endIndex = result.length();
                number--;
                multiFactor += 2;
            }
            result = result.substring(0, endIndex) + s.charAt(i) + result.substring(endIndex);

            if (goDown) {
                number -= multiFactor;
                countRows++;
                goDown = countRows < numRows;
            } else {
                number += multiFactor;
                countRows--;
                goDown = countRows == 1;
            }
        }

        return result;

    }

    /**
     Here, first different is that we use a char array to store the result, instead of a string.
     We start this array empty, and we put char in this array in the correct order, from left to right.
     To do that, we get the interval between the letter in zigzag.
        This interval represents the difference between two char that will be next to each other in the result in the original string.
        For example, with the string 'PAYPALISHIRING' and 3 rows, H and N will be next to each other in the result.
        In the original string, they are separated for 3 chars
        Using the formula, we have 2 * 3 - 2, that is equal to 4, and this number represents the difference between H and N positions.
     After get the interval, we start the loops.
     The first loop run from zero to numRows, and represents our rows in the zigzag string.
     Inside this loop, we calculate a step, that will be using to check if we have to get letters that represent our stairs in the zigzag string.
        For example,  with the string 'PAYPALISHIRING' and 3 rows, the letters P, S and I are using to go from the bottom to up of the next colunm.
     With these numbers calculate, we are able to fill our char array.
     Import to note that in the first and in the last row, we don't use the step number.
     */
    public String betterSolution(String s, int numRows) {
        int length = s.length();
        if(length <= numRows || numRows == 1) return s;
        char[] zig = new char[length];
        int interval = 2*numRows - 2;
        int count = 0;
        for(int i=0;i<numRows;i++){
            int step = interval-2*i;
            for(int j=i;j<length ;j+=interval){
                zig[count++] = s.charAt(j);
                if(step>0 && step < interval && j+step<length){
                    zig[count++] = s.charAt(j+step);
                }
            }
        }
        return new String(zig);
    }

    private void runMySolution() {
        System.out.println("##### My Solution results #####");

        String wordToTest = "PAYPALISHIRING";
        String caseOne = this.mysolution(wordToTest, 3);
        String caseTwo = this.mysolution(wordToTest, 4);
        String caseThree = this.mysolution("A", 1);
        String caseFour = this.mysolution("A", 2);
        String caseFive = this.mysolution("AB", 1);
        String caseSix = this.mysolution(wordToTest, 5);

        System.out.println("Case One Result = " + caseOne);
        System.out.println("Case Two Result = " + caseTwo);
        System.out.println("Case Three Result = " + caseThree);
        System.out.println("Case Four Result = " + caseFour);
        System.out.println("Case Five Result = " + caseFive);
        System.out.println("Case Six Result = " + caseSix);

        System.out.println();
    }

    private void runBetterSolution() {
        System.out.println("##### Better Solution results #####");

        String wordToTest = "PAYPALISHIRING";
        String caseOne = this.betterSolution(wordToTest, 3);
        String caseTwo = this.betterSolution(wordToTest, 4);
        String caseThree = this.betterSolution("A", 1);
        String caseFour = this.betterSolution("A", 2);
        String caseFive = this.betterSolution("AB", 1);
        String caseSix = this.betterSolution(wordToTest, 5);

        System.out.println("Case One Result = " + caseOne);
        System.out.println("Case Two Result = " + caseTwo);
        System.out.println("Case Three Result = " + caseThree);
        System.out.println("Case Four Result = " + caseFour);
        System.out.println("Case Five Result = " + caseFive);
        System.out.println("Case Six Result = " + caseSix);

        System.out.println();
    }

    public static void main(String[] args) {

        ZigZagString execute = new ZigZagString();
        execute.runMySolution();
        execute.runBetterSolution();

    }

}
