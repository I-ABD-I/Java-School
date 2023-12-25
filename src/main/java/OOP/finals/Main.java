package OOP.finals;

import utils.Input;

@SuppressWarnings("unused")
public class Main {
    public static void bagrutCS() {
        BagrutSubject bs1;
        String schoolName;
        int students;
        int failed;
        int failedCount = 0;
        double globalFailPercentage;

        System.out.println("Please enter testAvg, schoolAvg, students, failed");
        bs1 = new BagrutSubject("CS",
                899222,
                Input.nextDouble(),
                Input.nextDouble(),
                Input.nextInt(),
                Input.nextInt());

        globalFailPercentage = ((double) bs1.getFailed() / bs1.getStudents()) * 100;
        for (int i = 0; i < 150; i++) {
            System.out.println("Please enter School name, students, failed");
            schoolName = Input.nextLine();
            students = Input.nextInt();
            failed = Input.nextInt();

            if (((double) failedCount / students) * 100 > globalFailPercentage) {
                System.out.println(schoolName);
                failedCount++;
            }

            System.out.println("The Amount Of Failed Schools Is: " + failedCount);
        }
    }

    public static void bagrutCS2() {
        BagrutSubject bs2;
        String schoolName;
        double schoolAvg;
        double testAvg;
        double absDiff;
        int avgCount = 0;

        System.out.println("Please enter testAvg, schoolAvg, students, failed");
        bs2 = new BagrutSubject("CS",
                899222,
                Input.nextDouble(),
                Input.nextDouble(),
                Input.nextInt(),
                Input.nextInt());

        absDiff = Math.abs(bs2.getSchoolAvg() - bs2.getTestAvg());

        for (int i = 0; i < 150; i++) {
            System.out.println("Please Enter School, schoolAvg, testAvg");
            schoolName = Input.nextLine();
            schoolAvg = Input.nextDouble();
            testAvg = Input.nextDouble();

            if (Math.abs(schoolAvg - testAvg) > absDiff)
                avgCount++;
            if (testAvg > bs2.getTestAvg())
                System.out.println(schoolName + ": " + (testAvg - bs2.getTestAvg()));
        }

    }
}
