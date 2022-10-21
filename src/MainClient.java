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
        //Currently, the generator creates 12! permutations.
        //Use at your own risk.
        //(optimal score is 53)
        //TODO simplify this mess.
        int MAX_WEIGHT = 700;
        //This is here to make it easy to disable generation.
        List<Experiment> bestCombo = new LinkedList<>();
        bestCombo = findBest(experiments, MAX_WEIGHT);

        System.out.println(getRating(bestCombo) + " " + bestCombo);
    }

    private static int getRating(List<Experiment> bestCombo) {
        int rating = 0;

        for (Experiment e : bestCombo) {
            rating += e.getRating();
        }

        return rating;
    }

    private static List<Experiment> findBest(Experiment[] experiments, int MAX_WEIGHT) {
        int bestComboRating = 0;
        List<Experiment> bestCombo = new LinkedList<>();
        for (Experiment[] e : new IterableArrayGenerator(experiments)) {
            int totalRating = 0;
            int totalWeight = 0;
            List<Experiment> current = new LinkedList<>();
            for (Experiment experiment : e) {
                totalWeight += experiment.getWeight();
                if (totalWeight > MAX_WEIGHT){
                    break;
                }
                current.add(experiment);
                totalRating += experiment.getRating();
            }
            if (totalRating > bestComboRating){
                bestCombo = current;
                bestComboRating = totalRating;
            }
        }
        return bestCombo;
    }
}
