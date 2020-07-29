package gld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? b - a : Integer.bitCount(b) - Integer.bitCount(a));


        for (int i = 0; i < n; i++) {
            for (int j = i -1; j >= 0; j--) {
                if ((arr[i] & arr[j]) == arr[i]) {
                    arr[j] = arr[i];
                }


            }
        }
        int size = Arrays.stream(arr).distinct().collect(Collectors.toList()).size();
        System.out.println(size - 1);
    }
}
