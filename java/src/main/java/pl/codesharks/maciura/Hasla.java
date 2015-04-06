package pl.codesharks.maciura;

import pl.codesharks.maciura.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Matura 2008 | Zadanie 5
 */
@SuppressWarnings({"UnusedDeclaration", "SpellCheckingInspection"})
public class Hasla {

    ArrayList<String> dane = new ArrayList<>();
    public static final String INPUT_FILE = "slowa.txt";

    public Hasla() {
        boolean ok = loadData();
        if(ok){
            System.out.println("Dane z pliku: \"" + INPUT_FILE + "\" załadowano pomyślnie");
        }else{
            System.err.println("Błąd przy ładowaniu danych z pliku: " + INPUT_FILE );
        }
    }

    public static boolean czyPalindrom(String str) {
        boolean czyJest = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                czyJest = false;
            }
        }
        return czyJest;
    }

    public void start() {
        long startTime = System.nanoTime();


        System.out.println("B)");
        System.out.println("Nowe Hasła:");
        final ArrayList<String> passwords = createPasswords(dane);

        System.err.println("Wyświetlanie Pominięte. Odkomentuj, aby wyświetlic TUTAJ");
        /*for (String x : passwords) {
            System.out.println(x);
        }*/

        System.out.println("Pierwsze:");
        final ArrayList<String> AResult = A(passwords);

        for (String x : AResult) {
            System.out.println(x);
        }

        System.out.println("Drugie:");
        Pair<String, String> BResult = BminMax(passwords);
        System.out.println("min:" + BResult.getKey() + " Max:" + BResult.getValue());

        System.out.println("Trzecie:");
        final int CResult = CLengthSum(passwords);
        System.out.println(CResult);


        System.out.println("Computing took: " + (System.nanoTime() - startTime) / 1000000d + "ms");

        System.out.println("Saving to disk...");
        try {
            final String NEWLINE = "\r\n";
            {
                File haslaB = new File("hasla_b.txt");
                if (!haslaB.exists()) {
                    if (!haslaB.createNewFile()) {
                        System.err.println("Cannot create hasla_b.tx");
                    }
                }
                FileWriter fw = new FileWriter(haslaB, false);
                for (String x : passwords) {
                    fw.append(x);
                    fw.append(NEWLINE);
                }
                fw.close();
            }
            {
                File slowaB = new File("slowa_b.txt");
                if (!slowaB.exists()) {
                    if (!slowaB.createNewFile()) {
                        System.err.println("Cannot create slowa_b.txt");
                    }
                }

                FileWriter fw = new FileWriter(slowaB, false);
                fw.append("1.==========").append(NEWLINE);
                for (String x : AResult) {
                    fw.append(x);
                    fw.append(NEWLINE);
                }
                fw
                        .append("2.==========").append(NEWLINE)
                        .append("min:").append(BResult.getKey()).append(NEWLINE)
                        .append("min:").append(BResult.getValue()).append(NEWLINE);

                fw.append("3.=========").append(NEWLINE).append(String.valueOf(CResult));
                fw.close();
            }
            System.out.println("Done! < OK >");
            System.out.println("Wszystkie odpowiedzi w odpowiednich plikach .txt < OK >");
        } catch (IOException e) {
            System.out.println("\t\t\tI/O operation <ERROR>");
            System.err.println(e.toString());
        }
    }

    private boolean loadData() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(INPUT_FILE);

        if (is != null) {

            try (Scanner scanner = new Scanner(is)) {
                while (scanner.hasNextLine()) {
                    dane.add(scanner.nextLine());
                }
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Podaj wszystkie hasła o długości 12
     */
    public ArrayList<String> A(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();
        for (String str : data) {
            if (str.length() == 12) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * Najkrótsze i najdłuższe hasło
     *
     * @return para najkrótsze,najdłuzsze
     */
    public Pair<String, String> BminMax(ArrayList<String> data) {

        String min = data.get(0), max = data.get(0);

        int minLength = min.length();
        int maxLength = max.length();

        for (String x : data) {
            if (x.length() > maxLength) {
                max = x;
                maxLength = x.length();
            } else if (x.length() < minLength) {
                min = x;
                minLength = x.length();
            }
        }
        return new Pair<>(min, max);
    }

    /**
     * Liczy sumę długości wszystkich haseł
     */
    public int CLengthSum(ArrayList<String> data) {
        int sum = 0;
        for (String aData : data) {
            sum += aData.length();
        }
        return sum;
    }

    public ArrayList<String> createPasswords(ArrayList<String> data) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : data) {
            result.add(createPassword(str));
        }
        return result;
    }

    public String longestFirstPalindrom(String str) {
        String sbstr = "";
        String palindrom = "";
        for (int i = 0; i < str.length(); i++) {
            sbstr = str.substring(0, i);
            if (czyPalindrom(sbstr)) {
                palindrom = sbstr;
            }
        }
        // on index "i", we've got first one, that is not a Palindrom
        return palindrom;
    }

    public String createPassword(String str) {
        StringBuilder password = new StringBuilder();

        String lfp = longestFirstPalindrom(str);
        StringBuilder rest = new StringBuilder(str.substring(lfp.length()));

        password.append(rest.reverse());
        password.append(lfp);
        password.append(rest.reverse());
        return password.toString();
    }
}
