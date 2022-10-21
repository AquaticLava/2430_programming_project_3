import java.util.Arrays;
import java.util.Iterator;

/**
 * //todo, change documentation to match new functionality.
 * //todo figure out how to do in 2^n iterations?
 * Generates all possible variations of a specified length integer array.
 * Lexicographic algorithm is from:
 * https://www.geeksforgeeks.org/lexicographic-permutations-of-string/
 */
public class IterableArrayGenerator implements Iterable<Experiment[]> {
    Experiment[] experiments;
    /**
     * Instantiates a new Iterable array generator.
     *
     * @param experiments the length of the arrays to generate
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
        private int i = 0;
        private boolean firstIteration = true;
        private Experiment[] currentIteration;

        private GeneratorIterator(Experiment[] experiments) {
            currentIteration = experiments;
            size = currentIteration.length;
        }

        private static int findCeil(Experiment[] experiments, int first, int l,
                                    int h) {
            // initialize index of ceiling element
            int ceilIndex = l;

            // Now iterate through rest of the elements and find
            // the smallest character greater than 'first'
            for (int i = l + 1; i <= h; i++)
                if (experiments[i].getId() > first && experiments[i].getId() < experiments[ceilIndex].getId())
                    ceilIndex = i;

            return ceilIndex;
        }

        @Override
        public boolean hasNext() {
            for (i = size - 2; i >= 0; --i) {
                if (currentIteration[i].getId() < currentIteration[i + 1].getId())
                    break;
            }
            return i != -1;
        }

        @Override
        public Experiment[] next() {
            if (firstIteration) {
                firstIteration = false;
                return Arrays.copyOf(currentIteration, currentIteration.length);
            }
            int ceilIndex = findCeil(currentIteration, currentIteration[i].getId(), i + 1,
                    size - 1);

            // Swap first and second characters
            Experiment temp = currentIteration[i];
            currentIteration[i] = currentIteration[ceilIndex];
            currentIteration[ceilIndex] = temp;

            // Sort the string on right of 'first char'
            Arrays.sort(currentIteration, i + 1, size);


            return Arrays.copyOf(currentIteration, currentIteration.length);
        }
    }
}
