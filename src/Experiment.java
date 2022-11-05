import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Represents a load for a space shuttle
 * @author Eric & Sione
 */
public class Experiment implements Comparable<Experiment> {
	private int id;
	private String experimentName;
	private int weight;
	private int rating;

	public static final Comparator<Experiment> BY_WEIGHT = new ComparatorByWeight();
	public static final Comparator<Experiment> BY_RATING = new ComparatorByRating();
	public static final Comparator<Experiment> BY_WEIGHT_RATING_RATIO = new ComparatorByWeightToRatingRatio();

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

	public double getRatio() {
		double weight = getWeight();
		double rating = getRating();
		return weight / rating;
	}

	@Override
	public String toString() {
		double weight = getWeight();
		double rating = getRating();
		double ratio = weight / rating;
		DecimalFormat decFormat = new DecimalFormat("#.##");
		return "\n" + experimentName + "(" + id + ") " + " Rating:" + rating + "  Weight:" + weight + "kg  W/R Ratio:"
				+ decFormat.format(ratio);
	}

	@Override
	public int compareTo(Experiment other) {
		return Integer.compare(this.id, other.id);
	}

	/**
	 * compares experiments by weight
	 * 
	 * @author sione
	 *
	 */
	private static class ComparatorByWeight implements Comparator<Experiment> {
		@Override
		public int compare(Experiment o1, Experiment o2) {
			return Integer.compare(o1.weight, o2.weight);
		}

	}

	/**
	 * compares experiments by rating
	 * 
	 * @author sione
	 *
	 */
	private static class ComparatorByRating implements Comparator<Experiment> {
		@Override
		public int compare(Experiment o1, Experiment o2) {
			return Integer.compare(o1.rating, o2.rating);
		}

	}

	/**
	 * compares experiments by weight to rating ratio
	 * 
	 * @author sione
	 */
	private static class ComparatorByWeightToRatingRatio implements Comparator<Experiment> {
		@Override
		public int compare(Experiment o1, Experiment o2) {
			double o1weight = o1.weight;
			double o1rating = o1.rating;

			double o2weight = o2.weight;
			double o2rating = o2.rating;

			return Double.compare(o1weight / o1rating, o2weight / o2rating);
		}

	}
}
