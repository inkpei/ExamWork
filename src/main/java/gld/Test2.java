package gld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test2 {
    static HashMap<String, Integer> map = new HashMap<>();
    static String[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        arr = scanner.nextLine().split(" ");

        for (String i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        while (judge()) {
            oprate(getMin());
        }
        System.out.println(Arrays.stream(arr).filter(tmp -> !tmp.equals("#")).collect(Collectors.joining(" ")));
    }

    static int getMin() {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                min = Math.min(min, Integer.parseInt(e.getKey()));
            }
        }
        return min;
    }

    static void oprate(int min) {
        String s = String.valueOf(min);
        map.put(s, map.get(s) - 2);
        if (map.get(s) < 1) map.remove(s);
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flag == 0 && arr[i].equals(s)) {
                arr[i] = "#";
                flag++;
            }
            if (flag == 1 && arr[i].equals(s)) {
                arr[i] = String.valueOf(Integer.parseInt(arr[i]) * 2);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                flag++;
            }
        }
    }

    static boolean judge() {
        for (Integer value : map.values()) {
            if (value >1) return true;
        }
        return false;
    }
}
