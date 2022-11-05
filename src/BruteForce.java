import java.util.LinkedList;
import java.util.List;

public class BruteForce {

    public static List<Experiment> findBest(Experiment[] experiments, int maxWeight) {
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
