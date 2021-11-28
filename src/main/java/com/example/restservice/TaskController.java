package com.example.restservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/task")
    public List task(@RequestParam(value = "num", defaultValue = "1") Integer num) {
        return  nextBigger(num);
    }

    static void swap(int ar[], int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    private List nextBigger(Integer num) {
        int i;
        List<Object> result = new ArrayList<>();
        String temp = Integer.toString(num);


        int[] ar = new int[temp.length()];
        for (int j = 0; j < temp.length(); j++) {
            ar[j] = temp.charAt(j) - '0';
        }

        int n = ar.length;

        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0) {
            String string = "Not Possible";
            List<Character> chars = new ArrayList<>();

            for (char ch: string.toCharArray()) {
                result.add(ch);
            }        }
        else {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1).'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++){
                result.add(ar[i]);

               }
            }

        return result;
    }
}