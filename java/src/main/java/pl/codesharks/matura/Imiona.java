package pl.codesharks.matura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="http://pl.spoj.com/problems/NAMES/">SPOJ - Imiona</a>
 */
public class Imiona {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        Pattern p = Pattern.compile("\\d\\. \\w+ (\\w+)", Pattern.CASE_INSENSITIVE);
        ArrayList<Para> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Matcher m = p.matcher(scanner.nextLine());
            if (m.find()) {
                String x = m.group(1).toUpperCase();
                Para z = new Para();
                z.key = x;
                int index = list.indexOf(z);
                if (index != -1) {
                    list.get(index).value++;
                } else {
                    list.add(z);
                }
            } else {
                System.out.println("fuck you");
            }
        }
        list.sort(new Comparator<Para>() {
            @Override
            public int compare(Para o1, Para o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0, size = list.size(); i < size; i++) {
            System.out.println(list.get(i));
        }
    }

    public static class Para implements Comparable<Para> {
        public String key;
        public int value = 1;

        @Override
        public int compareTo(Para o) {
            if (value < o.value) {
                return 1;
            } else if (value > o.value) {
                return -1;
            } else {
                return key.compareTo(o.key);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Para) {
                return ((Para) o).key.equals(key);
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }
}
