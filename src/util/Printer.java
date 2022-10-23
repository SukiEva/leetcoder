package util;

import pojo.ListNode;
import pojo.TreeNode;

import java.util.Arrays;

public class Printer {
    public static void print() {
        print("Hello world!");
    }

    public static <T> void print(T x) {
        if (x.getClass().isArray()) System.out.println(Arrays.deepToString((Object[]) x));
        else System.out.println(x);
    }

    public static void print(TreeNode root) {
        BTreePrinter.print(root);
    }

    public static void print(ListNode head) {
        if (head == null) return;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
