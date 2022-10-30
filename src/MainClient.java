import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainClient {
    public static void main(String[] args) {
        Experiment[] experiments = {
                new Experiment(1,"Cloud Patterns",36,5),
                new Experiment(2,"Solar Flares",264,9),
                new Experiment(3,"Solar Power",188,6),
                new Experiment(4,"Binary Stars",203,8),
                new Experiment(5,"Relativity",104,8),
                new Experiment(6,"Seed Viability",7,4),
                new Experiment(7,"Sun Spots",90,2),
                new Experiment(8,"Mice Tumors",65,8),
                new Experiment(9,"Microgravity Plant Growth",75,5),
                new Experiment(10,"Micrometeorites",170,9),
                new Experiment(11,"Cosmic Rays",80,7),
                new Experiment(12,"Yeast Fermentation",27,4),
        };

        int maxWeight = 700;
        List<Experiment> bestCombo = findBest(experiments, maxWeight);

        System.out.println(getRating(bestCombo) + " " + bestCombo);

        OptimalPayload optimalPayload = new OptimalPayload(experiments);
        optimalPayload.displayOptimal(maxWeight);
    }

    private static int getRating(List<Experiment> bestCombo) {
        int rating = 0;

        for (Experiment e : bestCombo) {
            rating += e.getRating();
        }

        return rating;
    }

    private static List<Experiment> findBest(Experiment[] experiments, int maxWeight) {
        List<Experiment> bestCombo = new LinkedList<>();
        int bestComboRating = 0;

        for (Experiment[] e : new IterableArrayGenerator(experiments)) {
            List<Experiment> current = new LinkedList<>();
            int totalRating = 0;
            int totalWeight = 0;

            for (Experiment experiment : e) {
                totalWeight += experiment.getWeight();

                if (totalWeight > maxWeight){
                    break;
                }

                totalRating += experiment.getRating();
                current.add(experiment);
            }

            if (totalRating > bestComboRating){
                bestCombo = current;
                bestComboRating = totalRating;
            }
        }

        return bestCombo;
    }
}
