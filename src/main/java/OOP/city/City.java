package OOP.city;

@SuppressWarnings("unused")
public class City {
    public static int legalCities(CameraInfo[] cameras) {
        int legal = 0;

        int[] count = new int[100];
        for (int c : count) {
            c = 0;
        }

        for (var camera : cameras) {
            if (!camera.allGood()) {
                count[camera.city]++;
            }
        }

        for (var c : count) {
            if (c == 0)
                legal++;
        }

        return legal;
    }

}
