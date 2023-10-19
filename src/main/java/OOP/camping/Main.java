package OOP.camping;

import utils.Input;

public class Main {
  public static void camp() {
    Camp camp;
    int totalAge1 = 0;
    int totalAge2 = 0;


    System.out.println("Enter amount of children in group1, group2");
    camp = new Camp(Input.nextInt(), Input.nextInt());

    for (int i = 0; i < camp.getNum1(); i++) {
      System.out.println("enter age");
      totalAge1 += Input.nextInt();
    }

    for (int i = 0; i < camp.getNum2(); i++) {
      System.out.println("enter age");
      totalAge2 += Input.nextInt();
    }

    System.out.println(camp);

    System.out.println("Avg ages in group1 " + totalAge1 / camp.getNum1());
    System.out.println("Avg ages in group2 " + totalAge2 / camp.getNum2());

  }

  @SuppressWarnings("SpellCheckingInspection")
  public static void camp2() {
    MultiCamp einat, sfhaim;
    double distanceE, distanceS;
    int age;

    einat = new MultiCamp("Einat");
    sfhaim = new MultiCamp("Sfhaim");

    System.out.println("Please enter age");
    age = Input.nextInt();
    while (age != -999 && einat.hasSpace() && sfhaim.hasSpace()) {
      if (8 <= age && age <= 15) System.out.println("Your Not in age range");
      else {
        System.out.println("Please enter distance from Einat, Sfhaim");
        distanceE = Input.nextDouble();
        distanceS = Input.nextDouble();
        if (distanceE < distanceS) (einat.hasSpace() ? einat : sfhaim).insertKid(age);
        else (sfhaim.hasSpace() ? sfhaim : einat).insertKid(age);
      }

      if (einat.hasSpace() && sfhaim.hasSpace()) {
        System.out.println("Please enter age");
        age = Input.nextInt();
      }
    }

    System.out.println(sfhaim);
    System.out.println(einat);
  }
}
