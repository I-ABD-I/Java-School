package dataStructs.linkedlist.birthdays;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static AllBirthday buildAllBirthday() {
        AllBirthday allBirthday = new AllBirthday();
        int day = 0;
        int month = 0;
        String name = "";
        System.out.println("Enter Day ");
        day = reader.nextInt();
        System.out.println("Enter Name ");
        name = reader.next();
        System.out.println("Enter Month");
        month = reader.nextInt();

        while (day != -1 && month != -1 && name != "-1") {
            allBirthday.addBirthday(new Birthday(day, name), month);
            System.out.println("Enter Day ");
            day = reader.nextInt();
            System.out.println("Enter Name ");
            name = reader.next();
            System.out.println("Enter Month");
            month = reader.nextInt();
        }

        return allBirthday;
    }

    public static void birthdayMain() {
        AllBirthday allBirthday = buildAllBirthday();
        System.out.println("the month with most birthdays is " + allBirthday.biggestBirthday());
    }

    public static void main(String[] args) {
        birthdayMain();
    }

}
