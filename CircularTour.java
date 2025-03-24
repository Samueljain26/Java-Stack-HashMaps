public class CircularTour {
    public static int findStartingPoint(int petrol[], int distance[]) {
        int start = 0, surplus = 0, totalSurplus = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netGain = petrol[i] - distance[i];
            surplus += netGain;
            totalSurplus += netGain;

            // If surplus goes negative, reset start to next pump
            if (surplus < 0) {
                start = i + 1;
                surplus = 0; 
            }
        }
        
        // If total petrol is less than total distance, return -1
        return (totalSurplus < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        int petrol[] = {4, 6, 7, 4};
        int distance[] = {6, 5, 2, 5};
        
        int startIndex = findStartingPoint(petrol, distance);
        System.out.println("Starting Petrol Pump Index: " + startIndex);
    }
}
