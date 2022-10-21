/**
 * Represents a load for a space shuttle
 */
public class Experiment {
    private int id;
    private String experimentName;
    private int weight;
    private int rating;


    public Experiment(int id, String experimentName, int weight, int rating) {
        this.id = id;
        this.experimentName = experimentName;
        this.weight = weight;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public int getWeight() {
        return weight;
    }

    public int getRating() {
        return rating;
    }
}
