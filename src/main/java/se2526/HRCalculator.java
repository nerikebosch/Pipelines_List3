package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if(age>120 || age < 0){
            throw new IllegalArgumentException(
                    "Age out of bounds"
            );
        }

        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm){
        int maxHR = calculateMaxHR(age);
        double percentage = (double) bpm / maxHR;

        if (percentage < 0.5) {
            return "Below Zone";
        } else if (percentage < 0.6) {
            return "Zone 1: Warm-up/Maintenance";
        } else if (percentage < 0.7) {
            return "Zone 2: Fat Burn/Fitness training";
        } else if (percentage < 0.8) {
            return "Zone 3: Aerobic(Endurance training)";
        } else if (percentage < 0.9) {
            return "Zone 4: Anaerobic(Hardcore training)";
        } else if (percentage <= 1.0) {
            return "Zone 5: Maximum effort";
        } else {
            return "Above Max";
        }
    }
}
