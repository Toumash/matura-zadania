package pl.codesharks.maciura.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsUtils {

    /**
     * Converts an array of Integer objects to an array of integer primitives
     */
    public static int[] toIntArray(List<Integer> integerList) {
        int[] intArray = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            intArray[i] = integerList.get(i);
        }
        return intArray;
    }

    /**
     * Converts one dimensional array of type <code>T</code> to <code>ArrayList<T></code>
     */
    public static <T> ArrayList<T> toArrayList(T[] s) {
        return new ArrayList<>(Arrays.asList(s));
    }

    public static <K> ArrayList<Pair<K, K>> toArrayList(K[][] tab) {
        ArrayList<Pair<K, K>> newTab = new ArrayList<>(tab.length);
        for (K[] aTab : tab) {
            newTab.add(new Pair<>(aTab[0], aTab[1]));
        }
        return newTab;
    }
}
