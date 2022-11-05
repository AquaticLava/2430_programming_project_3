import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sione
 */
public class Weight {
	/**
	 * returns an array of the least amount of experiments you can have based on the
	 * weight of the experiments up to the given weight max and prints weight total,
	 * experiment total, and weight total. The heaviest experiments will be selected
	 * and placed into a returning array getting as close as possible to the
	 * specified weightMax without going over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the least amount of experiments without going over a specified weight.
	 */
	public static Experiment[] leastByWeight(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_WEIGHT);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = copy.length - 1; i > 0; i--) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}

	/**
	 * Returns an array of the most amount of experiments you can have based on the
	 * weight of the experiments up to the given weight max and prints weight total,
	 * experiment total, and rating total and array. The lightest experiments will
	 * be selected and placed into a returning array getting as close as possible to
	 * the specified weightMax without going over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the most amount of experiments without going over a specified weight.
	 */
	public static Experiment[] mostByWeight(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_WEIGHT);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = 0; i < copy.length - 1; i++) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}

	/**
	 * Returns an array of the worst rated experiments you can have based on the
	 * weight of the experiments up to the given weight max and prints rating and
	 * array The lightest experiments will be selected and placed into a returning
	 * array getting as close as possible to the specified weightMax without going
	 * over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the least rated experiments without going over a specified weight.
	 */
	public static Experiment[] worstRatings(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_RATING);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = 0; i < copy.length - 1; i++) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}

	/**
	 * Returns an array of the best rated experiments you can have based on the
	 * weight of the experiments up to the given weight max and prints rating and
	 * array The best rated experiments will be selected and placed into a returning
	 * array getting as close as possible to the specified weightMax without going
	 * over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the most rated experiments without going over a specified weight.
	 */
	public static Experiment[] bestRatings(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_RATING);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = copy.length - 1; i > 0; i--) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}

	/**
	 * Returns an array of the worst weight/rating ratio experiments you can have
	 * based on the weight of the experiments up to the given weight max and prints
	 * rating and array The best rated experiments will be selected and placed into
	 * a returning array getting as close as possible to the specified weightMax
	 * without going over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the worst weight/rating ratio experiments without going over a specified weight.
	 */
	public static Experiment[] worstWeightToRatingRatio(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_WEIGHT_RATING_RATIO);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = copy.length - 1; i > 0; i--) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}

	/**
	 * Returns an array of the best weight/rating ratio experiments you can have
	 * based on the weight of the experiments up to the given weight max and prints
	 * rating and array The best rated experiments will be selected and placed into
	 * a returning array getting as close as possible to the specified weightMax
	 * without going over.
	 * 
	 * @param weightMax the maximum weight.
	 * @return An array of the best weight/rating ratio experiments without going over a specified weight.
	 */
	public static Experiment[] bestWeightToRatingRatio(int weightMax, Experiment[] arr) {

		Experiment[] copy = arr.clone();
		Experiment[] finalArr;
		Arrays.sort(copy, Experiment.BY_WEIGHT_RATING_RATIO);
		ArrayList<Experiment> arrList = new ArrayList<>();
		int totalWeight = 0;
		for (int i = 0; i < copy.length - 1; i++) {

			totalWeight += copy[i].getWeight();
			if (totalWeight <= weightMax) {
				arrList.add(copy[i]);
			} else
				totalWeight -= copy[i].getWeight();
		}

		finalArr = new Experiment[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			finalArr[i] = arrList.get(i);
		}
		return finalArr;
	}
}
