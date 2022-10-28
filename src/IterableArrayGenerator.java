import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Generates all combinations of elements in an array.
 *
 * for example a array of {1, 2, 3} would produce:
 * {3},{2},{2,3},{1},{1,3},{1,2},{1,2,3}.
 */
public class IterableArrayGenerator implements Iterable<Experiment[]> {
    Experiment[] experiments;
    /**
     * Instantiates a new Iterable array generator.
     *
     * @param experiments the array to get elements from.
     */
    public IterableArrayGenerator(Experiment[] experiments) {
        this.experiments = experiments;
    }

    @Override
    public Iterator<Experiment[]> iterator() {
        return new GeneratorIterator(experiments);
    }

    private static class GeneratorIterator implements Iterator<Experiment[]> {

        private int size;
        private Integer current = 0;
        String currentAsBinary;
        private Experiment[] experiments;

        private GeneratorIterator(Experiment[] experiments) {
            this.experiments = experiments;
            size = experiments.length;
        }

        @Override
        public boolean hasNext() {
            return current < Math.pow(2,size);
        }

        @Override
        public Experiment[] next() {
            current++;
            List<Experiment> experiment = new LinkedList<>();
            currentAsBinary = Integer.toBinaryString(current);
            for (int i = 0; i < currentAsBinary.length(); i++) {
                if (currentAsBinary.charAt(i) == '1'){
                    experiment.add(experiments[i]);
                }
            }
            return experiment.toArray(new Experiment[0]);
        }
    }
}
