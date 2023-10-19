package OOP.schools;

import utils.Input;
import utils.Tuple;

public class Main {

  public static void schoolsInfo() {
    @SuppressWarnings("unchecked")
    Tuple<School, Integer>[] schools = new Tuple[2];
    String city;
    double nationalAvg = 60;

    System.out.println("Please enter a city");
    city = Input.nextLine();

    System.out.println("Please enter name, graduate percentage");
    schools[0] =
      new Tuple<School, Integer>(new School(Input.nextLine(), city, Input.nextDouble()), null);
    System.out.println("Please enter name, graduate percentage");
    schools[1] =
      new Tuple<School, Integer>(new School(Input.nextLine(), city, Input.nextDouble()), null);

    for (var schoolEnt : schools) {
      School school = schoolEnt.getItem1();
      if (school.getGraduatePercentage() >= 80 && school.getGraduatePercentage() > nationalAvg)
        schoolEnt.setItem2(1);
      else if (school.getGraduatePercentage() >= 70
               && school.getGraduatePercentage() >= nationalAvg) schoolEnt.setItem2(2);
      else schoolEnt.setItem2(3);

      System.out.println(school + "is In Bracket: " + schoolEnt.getItem2());
    }

    if (schools[0].getItem2().equals(schools[1].getItem2()))
      System.out.println("Both Schools Are in the Same Bracket");
  }
}
