/**
 * Represents a load for a space shuttle
 */
public class Experiment implements Comparable<Experiment>{
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

    @Override
    public String toString() {
        return  experimentName + "(" + id + ") " +
                "rating:" + rating + " " +
                weight + "kg";
    }

    @Override
    public int compareTo(Experiment other) {
        return Integer.compare(this.id, other.id);
    }
}
