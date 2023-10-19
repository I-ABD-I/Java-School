package OOP.students;

import utils.Input;

public class Main {
  public static void finalGrade() {
    System.out.println("Please Enter a Name");
    Student student = new Student(Input.nextLine());
    System.out.println("Please Enter 2 Grades");
    student.addGrd(Input.nextInt());
    student.addGrd(Input.nextInt());
    if (student.getGrd().get(0) < student.getGrd().get(1))
      System.out.println(.9 * student.getGrd().get(1) + .1 * student.getGrd().get(0));
    else System.out.println(.5 * student.getGrd().get(0) + .5 * student.getGrd().get(1));
  }

  public static void finalGrade2() {
    Student student;
    double finalGrade = 0;

    System.out.println("Please enter a name");
    student = new Student(Input.nextLine());
    System.out.println("Please enter 3 Grades");
    student.addGrd(Input.nextInt());
    student.addGrd(Input.nextInt());
    student.addGrd(Input.nextInt());
    finalGrade = student.getGrd().get(0) + student.getGrd().get(1) + student.getGrd().get(2)
                 - student.minGrd();
    finalGrade /= 2;
    if (finalGrade == student.minGrd()) finalGrade += 5;
    System.out.println("The Final Grade is: " + finalGrade);
  }

  public static void allowedGrades(Student stud1) {
    for (int value : stud1.getGrd()) {
      if (0 > value || value > 100) {
        System.out.println("Illegal Grade");
        return;
      }
    }
    System.out.println("All Grades Are Allowed");
  }

  public static void countFail() {
    Student st1;
    Student st2;
    int countFail1 = 0;
    int countFail2 = 0;


    System.out.println("Please enter names for the 2 students");

    st1 = new Student(Input.nextLine());
    st2 = new Student(Input.nextLine());

    System.out.println("How much grades " + st1.getName() + " has");
    int temp = Input.nextInt();
    for (int i = 0; i < temp; i++) {
      System.out.println("Enter Grade");
      st1.addGrd(Input.nextInt());

      if (st1.getGrd().get(st1.getGrd().size() - 1) < 55) countFail1++;
    }

    System.out.println("How much grades " + st2.getName() + " has");
    temp = Input.nextInt();
    for (int i = 0; i < temp; i++) {
      System.out.println("Enter Grade");
      st1.addGrd(Input.nextInt());

      if (st2.getGrd().get(st2.getGrd().size() - 1) < 55) countFail2++;
    }

    System.out.println(st1.getName() + " Failed " + countFail1 + "Subjects");
    System.out.println(st2.getName() + " Failed " + countFail2 + "Subjects");
  }


}
