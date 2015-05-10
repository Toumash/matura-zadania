package pl.codesharks.matura.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

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

    public static int[] toIntArray(Integer[] tab) {
        int[] result = new int[tab.length];
        for (int i = 0, length = tab.length; i < length; i++) {
            result[i] = tab[i];
        }
        return result;
    }

    /**
     * Converts one dimensional array of type <code>T</code> to <code>ArrayList<T></code>
     */
    public static <T> ArrayList<T> toArrayList(T[] s) {
        return new ArrayList<>(Arrays.asList(s));
    }

    public static <K> ArrayList<Pair<K, K>> toPairArrayList(K[][] tab) {
        ArrayList<Pair<K, K>> newTab = new ArrayList<>(tab.length);
        for (K[] aTab : tab) {
            newTab.add(new Pair<>(aTab[0], aTab[1]));
        }
        return newTab;
    }

    public static <E> ArrayList<ArrayList<E>> toArrayList(E[][] tab) {
        ArrayList<ArrayList<E>> newTab = new ArrayList<>(tab.length);
        for (E[] aTab : tab) {
            ArrayList<E> innerArray = new ArrayList<>(aTab.length);
            java.util.Collections.addAll(innerArray, aTab);
            newTab.add(innerArray);
        }
        return newTab;
    }

    public static <T> void displayArray(T[][] t) {
        for (T[] tab : t) {
            for (T e : tab) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static <T> void displayArray(ArrayList<ArrayList<T>> t) {
        for (ArrayList<T> tab : t) {
            for (T e : tab) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
