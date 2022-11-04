import java.util.ArrayList;


/*
 * author Yanzhuo Li 
 * use dynamic programming method to solve the knapsack problem
 * 
 */
		
public class OptimalPayload {
	//the list of experiment options
	Experiment[] Experiments = {new Experiment(2, "Solar Flares", 264, 9), new Experiment(12, "Yeast Fermentation", 27, 4),
			new Experiment(1, "Cloud Patterns", 36, 5), new Experiment(8, "Mice Tumors", 65, 8),
			new Experiment(9, "Microgravity Plant Growth", 75, 5), new Experiment(11, "Cosmic Rays", 80, 7), new Experiment(7, "Sun Spots", 90, 2),
			new Experiment(5, "Relativity", 104, 8), new Experiment(6, "Seed Viability", 7, 4), new Experiment(10, "Micrometeorites", 170, 9), new Experiment(3, "Solar Power", 188, 6),
			new Experiment(4, "Binary Stars", 203, 8)};
	



	/*
	 * input the max weight and total number of experiments
	 * return the optimal option.
	 */
	private ArrayList<Experiment> optimal(int payload, int numOfExperiment) {
		if (payload < 0 || numOfExperiment < 0)
			return new ArrayList<Experiment>();
		ArrayList<Experiment> ExperimentList1 = optimal(payload - Experiments[numOfExperiment].getWeight(), numOfExperiment - 1);
		if(payload >= Experiments[numOfExperiment].getWeight())   ExperimentList1.add(Experiments[numOfExperiment]);
		ArrayList<Experiment> ExperimentList2 = optimal(payload, numOfExperiment - 1);
		return biggerRate(ExperimentList1, ExperimentList2);
	}

	/*
	 * display the max total rates of the optimal option and the list of optimal option.
	 * @param  payload: the max number of total weight
	 *         numOfExperiment: the total number experiments of the list
	 */
	
	public void displayOptimal(int payload, int numOfExperiment) {
		ArrayList<Experiment> optimalList = optimal(payload, numOfExperiment);
		String s = "";
		int rate = 0;
		int weight = 0;
		for (Experiment el : optimalList) {
			s = s + el.getExperimentName() + ", ";
			rate += el.getRating();
			weight += el.getWeight();
		}
		System.out.println("Optimal Loading: " + s + "\n" + "Total Rate: " + rate + "\n" + "Total Weight: " + weight );
	}

     /*
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

	public static void main(String[] args) {
		OptimalPayload a = new OptimalPayload();
		a.displayOptimal(700, 11);
	}

}
