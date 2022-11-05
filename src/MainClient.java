import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jake
 */
public class MainClient {
    static final double BILLION = 1_000_000_000;
    static final int maxWeight = 700;
    static final Experiment[] experiments = {
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
            new Experiment(12,"Yeast Fermentation",27,4)
    };

    public static void main(String[] args) {
        //weight based selection
        System.out.println("weight based selection");
        System.out.println("======================");
        Experiment[] mostWeight = Weight.mostByWeight(maxWeight, experiments);
        cleanOutput(Arrays.asList(mostWeight), "mostWeight");

        //rating based selection
        System.out.println("rating based selection");
        System.out.println("======================");
        Experiment[] rating = Weight.bestRatings(maxWeight, experiments);
        cleanOutput(Arrays.asList(rating), "rating");

        //ratio based selection
        System.out.println("ratio based selection");
        System.out.println("=====================");
        Experiment[] ratioSet = Ratio.selectByRatio(experiments);
        cleanOutput(Arrays.asList(ratioSet), "ratio");


        //brute force method
        System.out.println("brute force method");
        System.out.println("==================");
        List<Experiment> bestCombo = BruteForce.findBest(experiments, maxWeight);
        cleanOutput(bestCombo, "brute");

        //optimal payload method
        System.out.println("optimal payload method");
        System.out.println("======================");
        OptimalPayload optimalPayload = new OptimalPayload(experiments);
        cleanOutput(optimalPayload.getOptimal(maxWeight), "optimal");
    }

    private static void cleanOutput(Iterable<Experiment> experiments, String approach){
        System.out.printf("total rating: %4d\n",getRating(experiments));
        System.out.printf("total weight: %4dkg\n",getWeight(experiments));
        speedTest(approach);
        System.out.print("    [");
        for (Experiment exp : experiments) {
            System.out.print(exp.getExperimentName() + ", ");
        }
        System.out.printf("\b\b");
        System.out.print("]");
        System.out.println();
        System.out.println();
    }


    private static void speedTest(String approach){
        long start = System.nanoTime();
        switch (approach) {
            case "mostWeight" -> Weight.mostByWeight(700, experiments);
            case "rating" -> Weight.bestRatings(maxWeight, experiments);
            case "ratio" -> Ratio.selectByRatio(experiments);
            case "brute" -> BruteForce.findBest(experiments, maxWeight);
            case "optimal" -> {
                OptimalPayload optimalPayload = new OptimalPayload(experiments);
                optimalPayload.getOptimal(maxWeight);
            }
            default -> throw new IllegalStateException("Unexpected value: " + approach);
        }
        System.out.printf("%s approach speed: %4f s\n", approach, (System.nanoTime() - start) / BILLION);
    }

    private static int getRating(Iterable<Experiment> bestCombo) {
        int rating = 0;

        for (Experiment e : bestCombo) {
            rating += e.getRating();
        }

        return rating;
    }

    private static int getWeight(Iterable<Experiment> bestCombo) {
        int weight = 0;

        for (Experiment e: bestCombo) {
            weight += e.getWeight();
        }

        return weight;
    }



}
