package util;

import pojo.ListNode;
import pojo.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inputer {
    public static final Scanner cin = new Scanner(System.in);

    public static <T> T[] nextArray(Class<T> tClass) {
        String[] array = nextArray(cin.next());
        if (tClass == String.class) {
            List<String> list = new ArrayList<>();
            Arrays.stream(array).forEach(x -> list.add(x.replaceAll("\"", "")));
            return toArray(list, tClass);
        }
        if (tClass == Integer.class) {
            List<Integer> list = new ArrayList<>();
            Arrays.stream(array).forEach(x -> list.add("null".equals(x) ? null : Integer.valueOf(x)));
            return toArray(list, tClass);
        }
        return toArray(new ArrayList<>(), tClass);
    }

    public static int[] nextArray() {
        return Arrays.stream(nextArray(cin.next())).mapToInt(Integer::parseInt).toArray();
    }

    public static <T> List<T> nextList(Class<T> tClass) {
        return Arrays.asList(nextArray(tClass));
    }

    public static TreeNode nextTree() {
        Integer[] array = nextArray(Integer.class);
        List<TreeNode> treeNodeList = array.length > 0 ? new ArrayList<>(array.length) : null;
        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            TreeNode node = array[i] == null ? null : new TreeNode(array[i]);
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        for (int i = 0; i * 2 + 1 < array.length; i++) {
            TreeNode node = treeNodeList.get(i);
            if (node == null) continue;
            node.left = treeNodeList.get(2 * i + 1);
            if (i * 2 + 2 < array.length)
                node.right = treeNodeList.get(2 * i + 2);
        }
        return root;
    }

    public static ListNode nextNode() {
        Integer[] array = nextArray(Integer.class);
        ListNode root = null;
        ListNode cur = null;
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            if (i == 0) {
                root = node;
                cur = root;
                continue;
            }
            cur.next = node;
            cur = node;
        }
        return root;
    }

    private static String[] nextArray(String input) {
        return input.substring(1, input.length() - 1).split(",");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T> T[] toArray(List list, Class tClass) {
        return (T[]) list.toArray((T[]) Array.newInstance(tClass, list.size()));
    }
}
