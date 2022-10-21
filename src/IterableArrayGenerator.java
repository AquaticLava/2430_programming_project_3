import java.util.Arrays;
import java.util.Iterator;

/**
 * //todo, adapt to shuttle problem.
 * Generates all possible variations of a specified length integer array.
 * Lexicographic algorithm is from:
 * https://www.geeksforgeeks.org/lexicographic-permutations-of-string/
 */
public record IterableArrayGenerator(int generatorLength) implements Iterable<Integer[]> {

    /**
     * Instantiates a new Iterable array generator.
     *
     * @param generatorLength the length of the arrays to generate
     */
    public IterableArrayGenerator {
    }

    @Override
    public Iterator<Integer[]> iterator() {
        return new GeneratorIterator(generatorLength);
    }

    private static class GeneratorIterator implements Iterator<Integer[]> {

        private int size;
        private int i = 0;
        private boolean firstIteration = true;
        private Integer[] currentIteration;

        private GeneratorIterator(int length) {
            this.size = length;
            Integer[] ints = new Integer[size];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = j + 1;
            }
            currentIteration = ints;
        }

        private static int findCeil(Integer[] ints, int first, int l,
                                    int h) {
            // initialize index of ceiling element
            int ceilIndex = l;

            // Now iterate through rest of the elements and find
            // the smallest character greater than 'first'
            for (int i = l + 1; i <= h; i++)
                if (ints[i] > first && ints[i] < ints[ceilIndex])
                    ceilIndex = i;

            return ceilIndex;
        }

        @Override
        public boolean hasNext() {
            for (i = size - 2; i >= 0; --i) {
                if (currentIteration[i] < currentIteration[i + 1])
                    break;
            }
            return i != -1;
        }

        @Override
        public Integer[] next() {
            if (firstIteration) {
                firstIteration = false;
                return Arrays.copyOf(currentIteration, currentIteration.length);
            }
            int ceilIndex = findCeil(currentIteration, currentIteration[i], i + 1,
                    size - 1);

            // Swap first and second characters
            Integer temp = currentIteration[i];
            currentIteration[i] = currentIteration[ceilIndex];
            currentIteration[ceilIndex] = temp;

            // Sort the string on right of 'first char'
            Arrays.sort(currentIteration, i + 1, size);


            return Arrays.copyOf(currentIteration, currentIteration.length);
        }
    }
}
