import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//import java.util.Arrays;
//
public class alg {
    static int[] prefix(String sample){
        //String s      =    aabaab";
        //               "aabaab"
        int[] values = new int [sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;                                                                                                                                                              //сравнивание отдельных символов
            while(i+j<sample.length() && sample.charAt(j)==sample.charAt(i+j)){                                                                                                         //идём в обратном попрядке, сравниваем максимум
                values[i+j] = Math.max(values[i+j], j+1);                                                                                                                               //вё начинается сначала, то есть суфикс мы сравниваем с его начала, а приставка сначала тоже
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> Search (String text, String textSearch){
        ArrayList<Integer> found = new ArrayList<>();
        int [] pref = prefix(textSearch);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<text.length()){
            if(textSearch.charAt(j)==text.charAt(i)){
                i++;
                j++;
            }
            if(j==textSearch.length()){
                found.add(i-j);         //мы в кноце найденого слова минус его длина
                j = pref[j-1];
            }
            else if(i<text.length() && textSearch.charAt(j) != text.charAt(i)){
                if(j!=0){
                    j = pref[j-1];
                }
                else{
                    i = i+1;
                }
            }
            count++;

        }
        System.out.println("КМП поиск: " + count);
        return found;
    }

    public static ArrayList<Integer> searchNaive(String text, String textSearch){
        ArrayList<Integer> f = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while(j<textSearch.length() && i+j<text.length() && textSearch.charAt(j)==text.charAt(i+j)){
                count++;
                j++;
            }
            if(j==textSearch.length()){
                f.add(i);
            }
        }
        System.out.println("Простой поиск: " + count);
        return f;
    }




    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String textSearch = scan.nextLine();
        String text = scan.nextLine();
        System.out.println(Arrays.toString(prefix(textSearch)));
        System.out.println(Arrays.toString(Search(text, textSearch).toArray()));
        System.out.println(Arrays.toString(searchNaive(text, textSearch).toArray()));
    }
}

//    public static int[] indexesOf(char[] pattern, char[] text)
//    {
//        int[] pfl = pfl(pattern);
//        int[] indexes = new int[text.length];
//        int size = 0;
//        int k = 0;
//        for (int i = 0; i < text.length; ++i)
//        {
//            while (pattern[k] != text[i] && k > 0)
//            {
//                k = pfl[k - 1];
//            }
//            if (pattern[k] == text[i])
//            {
//                k = k + 1;
//                if (k == pattern.length)
//                {
//                    indexes[size] = i + 1 - k;
//                    size += 1;
//                    k = pfl[k - 1];
//                }
//            }
//            else
//            {
//                k = 0;
//            }
//        }
//        return Arrays.copyOfRange(indexes, 0, size);
//    }
//
//    public static int[] pfl(char[] text)
//    {
//        int[] pfl = new int[text.length];
//        pfl[0] = 0;
//
//        for (int i = 1; i < text.length; ++i)
//        {
//            int k = pfl[i - 1];
//            while (text[k] != text[i] && k > 0)
//            {
//                k = pfl[k - 1];
//            }
//            if (text[k] == text[i])
//            {
//                pfl[i] = k + 1;
//            }
//            else
//            {
//                pfl[i] = 0;
//            }
//        }
//
//        return pfl;
//    }
//}
