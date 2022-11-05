import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Generates a list of experiments based on the ratio of rating to weight
 * expressed by r/w.
 * @author jieli
 *
 */
public class Ratio {

	//Empty constructor
	public Ratio() { }
	
	/**
	 * Creates a subset of experiments based off the ratio of rating to weight. Pulls off the largest ratio experiment
	 * until reaching one above the maximum number of experiments, cuts the tail, rebuilds the array, and returns
	 * the subset.
	 * @param experiments The set of experiments to draw from.
	 * @return A subset containing the max number of experiments organized by ratio of rating to weight.
	 */
	public static Experiment[] selectByRatio(Experiment[] experiments) {
		if(experiments.length == 0) throw new ArrayIndexOutOfBoundsException("Set of experiments needs to have something in it.");
		
		PriorityQueue<Experiment> ratioQueue = new PriorityQueue<>(experiments.length, Experiment.BY_WEIGHT_RATING_RATIO);
		Experiment[] ratioSet = new Experiment[experiments.length];
		
		for(Experiment e : experiments) {
			ratioQueue.add(e);
		}
		
		int totalWeight = 0;
		int i = 0;
		while(totalWeight <= 700) {
			totalWeight += ratioQueue.peek().getWeight();
			ratioSet[i++] = ratioQueue.poll();
		}
		
		if(totalWeight > 700) {
			ratioSet[i - 1] = null;
		}
		
		Experiment[] finalRatioSet = new Experiment[i - 1];
		for(int j = 0; j < i - 1; j++) {
			finalRatioSet[j] = ratioSet[j];
		}
		return finalRatioSet;
	}
}
