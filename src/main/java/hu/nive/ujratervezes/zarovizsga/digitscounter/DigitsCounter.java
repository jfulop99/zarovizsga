package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    int getCountOfDigits(String s) {

        if (s == null || s.isBlank()) {
            return 0;
        }
        Set<Character> numbers = new HashSet<>();
        for (Character item:s.toCharArray()) {
            if (item >= '0' && item <= '9')
            numbers.add(item);
        }
        return numbers.size();
    }

}
