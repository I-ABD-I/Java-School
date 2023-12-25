package main;

import static utils.LinkedListUtils.removeAll;

import utils.LinkedListUtils;

public class Main {

    public static void main(String[] args) {
        var list = LinkedListUtils.build(87, 2, 3, 45, 6, 1, 2, 3, 5, 6, 7);
        System.out.println(removeAll(list, 3));
    }
}
