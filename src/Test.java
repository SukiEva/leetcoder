import pojo.ListNode;
import util.Inputer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static util.Inputer.nextNode;
import static util.Printer.print;

public class Test {
    static {
        try {
            System.setIn(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            print("input.txt not found");
        }
    }

    public static void main(String[] args) {
        Scanner cin = Inputer.cin;
        ListNode root = nextNode();
        print(root);
    }
}
