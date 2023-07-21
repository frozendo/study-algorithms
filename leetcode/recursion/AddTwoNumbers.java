/**
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example 1:
     Input: l1 = [2,4,3], l2 = [5,6,4]
     Output: [7,0,8]

     Explanation: 342 + 465 = 807.

 Example 2:
     Input: l1 = [0], l2 = [0]
     Output: [0]

 Example 3:
    Input: l1 = [9,9,9,9], l2 = [9,9]
    Output: [8,9,0,0,1]

 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers execute = new AddTwoNumbers();
        execute.run();
    }

    public void run() {
        ListNode root1Case1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3)));
        ListNode root2Case1 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4)));

        ListNode root1Case2 = new ListNode(0);
        ListNode root2Case2 = new ListNode(0);

        ListNode root1Case3 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9))));
        ListNode root2Case3 = new ListNode(9,
                new ListNode(9));

        this.printResult(this.mySolution(root1Case1, root2Case1));
        this.printResult(this.mySolution(root1Case2, root2Case2));
        this.printResult(this.mySolution(root1Case3, root2Case3));
    }

    public void printResult(ListNode result) {
        System.out.print(result.val);
        ListNode item = result.next;
        while (item != null) {
            System.out.print("," + item.val);
            item = item.next;
        }
        System.out.println();
        System.out.println();
    }

    public ListNode mySolution(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int sum = 0;
        ListNode nextL1 = null;
        ListNode nextL2 = null;

        if (l1 != null) {
            sum += l1.val;
            nextL1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            nextL2 = l2.next;
        }

        if (sum > 9) {
            sum = sum % 10;
            if (nextL1 != null) {
                nextL1.val++;
            } else if (nextL2 != null) {
                nextL2.val++;
            } else {
                return new ListNode(sum, new ListNode(1, null));
            }
        }

        return new ListNode(sum, this.mySolution(nextL1, nextL2));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}