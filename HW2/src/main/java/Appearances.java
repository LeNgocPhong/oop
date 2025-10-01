import java.util.*;

public class Appearances {

    /**
     * Returns the number of elements that appear the same number
     * of times in both collections. Static method. (see handout).
     * @return number of same-appearance elements
     */
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<T, Integer> freqA = getFrequencyMap(a);
        Map<T, Integer> freqB = getFrequencyMap(b);

        int count = 0;
        // duyệt qua tất cả phần tử có trong ít nhất một collection
        Set<T> allKeys = new HashSet<>();
        allKeys.addAll(freqA.keySet());
        allKeys.addAll(freqB.keySet());

        for (T key : allKeys) {
            int fa = freqA.getOrDefault(key, 0);
            int fb = freqB.getOrDefault(key, 0);
            if (fa == fb && fa != 0) {
                count++;
            }
        }

        return count;
    }

    private static <T> Map<T, Integer> getFrequencyMap(Collection<T> coll) {
        Map<T, Integer> freq = new HashMap<>();
        for (T item : coll) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        return freq;
    }

//    public static void main(String[] args) {
//        List<String> a = Arrays.asList("apple", "banana", "apple", "pear", "pear");
//        List<String> b = Arrays.asList("apple", "apple", "banana", "pear", "pear", "pear");
//
//        System.out.println(sameCount(a, b)); // output = 2 ("apple" và "banana" không trùng, nhưng "pear" thì khác -> kết quả đúng sẽ là 1)
//    }
}
