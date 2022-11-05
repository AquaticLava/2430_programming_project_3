import java.util.ArrayList;
import java.util.List;


/**
 * @author Yanzhuo Li
 * use dynamic programming method to solve the knapsack problem
 * 
 */
		
public class OptimalPayload {
	Experiment[] experiments;
	public OptimalPayload(Experiment[] experiments) {
		this.experiments = experiments;
	}

	/**
	 * input the max weight and total number of experiments
	 * return the optimal option.
	 */
	private ArrayList<Experiment> optimal(int payload, int numOfExperiment) {
		if (payload < 0 || numOfExperiment < 0)
			return new ArrayList<>();
		ArrayList<Experiment> ExperimentList1 = optimal(payload - experiments[numOfExperiment].getWeight(), numOfExperiment - 1);
		if(payload >= experiments[numOfExperiment].getWeight())   ExperimentList1.add(experiments[numOfExperiment]);
		ArrayList<Experiment> ExperimentList2 = optimal(payload, numOfExperiment - 1);
		return biggerRate(ExperimentList1, ExperimentList2);
	}

	/**
	 * display the max total rates of the optimal option and the list of optimal option.
	 * @param  payload: the max number of total weight
	 */
	public List<Experiment> getOptimal(int payload) {
		return optimal(payload, experiments.length - 1);
	}

     /**
      * compare the total rate of two lists of experiments
      * return the bigger rates one
      */
	private ArrayList<Experiment> biggerRate(ArrayList<Experiment> a, ArrayList<Experiment> b) {
		int rate1 = 0;
		int rate2 = 0;
		for (Experiment el : a) {
			rate1 += el.getRating();
		}
		for (Experiment el : b) {
			rate2 += el.getRating();
		}
		if (rate1 >= rate2)
			return a;
		else
			return b;
	}
}
