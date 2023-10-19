package OOP.doctors;

import utils.Input;

import java.util.function.BiFunction;

public class Main {
  public static void doctors() {
    BiFunction<Doctor[], String, Doctor> getDoctorByID = (doctors, s) -> {
      for (Doctor doctor : doctors) {
        if (doctor.getId().equals(s)) return doctor;
      }
      return null;
    };

    System.out.println("Please enter the amount of doctors");
    Doctor[] doctors = new Doctor[Input.nextInt()];

    System.out.println("Please enter id and rating");
    String id = Input.nextLine();
    int rating = Input.nextInt();
    Doctor doc;

    while (!id.equals("000")) {
      doc = getDoctorByID.apply(doctors, id);
      if (doc != null) {
        doc.newRating(rating);
      }
      System.out.println("Please enter id and rating");
      id = Input.nextLine();
      rating = Input.nextInt();
    }

    System.out.println("Please enter an area and mastery");
    String area = Input.nextLine();
    String mastery = Input.nextLine();

    double maxAvg = 0;
    for (var doctor : doctors) {
      if (doctor.getArea().equals(area) && doctor.getMastery().equals(mastery))
        maxAvg = Math.max(maxAvg, doctor.getAvg());
    }

    for (var doctor : doctors) {
      if (doctor.getArea().equals(area) && doctor.getMastery().equals(mastery)
          && doctor.getAvg() == maxAvg) System.out.println(doctor.getName());
    }
  }
}
