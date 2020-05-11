package ArrayManipulation;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulation {

    //https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

    public static long arrayManipulation(int arrayLength, int[][] queries) {
        List<Integer> listToManipulate = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            listToManipulate.add(0);
        }
        for (int[] query : queries) {
            for (int i = query[0] - 1; i < query[1]; i++) {
                listToManipulate.set(i, listToManipulate.get(i) + query[2]);
            }
        }
        return listToManipulate.stream().mapToLong(Integer::longValue).max().getAsLong();
    }

}
