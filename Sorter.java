import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorter {
    public static void main(String[] args) {

        runTest();
        /* Scanner input = new Scanner(System.in);
        String valueLine = input.nextLine();
        input.close(); */

        /* String[] strings = valueLine.split(" ");
        int[] vals = new int[strings.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < strings.length; i++) {
            vals[i] = (Integer.parseInt(strings[i]));
            if (vals[i] > max) {
                max = vals[i];
            }
        }

        int[] temp = new int[max];
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[i]; j++) {
                temp[j]++;
            }
        }
        
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();

        ArrayList<Integer> sorted = new ArrayList<>();
        int idxptr = temp.length - 1;
        while (temp[0] != 0) {
            int removed = 0;
            for (int tempptr = 0; tempptr <= idxptr; tempptr++) {
                temp[tempptr]--;
                removed++;
            }
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();

            while (idxptr >= 0 && temp[idxptr] == 0) {
                idxptr--;
            }
            sorted.add(removed);
        }
        
        for (int i = 0; i < sorted.size(); i++) 
            System.out.print(sorted.get(i) + " "); */
    }

    public static void sorter(Integer[] numbers) {

        //find largest valued element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        //create temporary array that holds number of blocks in each column
        int[] temp = new int[max];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                temp[j]++;
            }
        }

        //start subtracting blocks from the end, and count subtractions
        //number of subtractions per pass is equivalent to next sorted
        //element to add to sorted list. Use index pointer to adjust end
        //of temporary array as needed.
        ArrayList<Integer> sorted = new ArrayList<>();
        int idxptr = temp.length - 1;
        while (temp[0] != 0) {
            int removed = 0;
            for (int tempptr = 0; tempptr <= idxptr; tempptr++) {
                temp[tempptr]--;
                removed++;
            }
            while (idxptr >= 0 && temp[idxptr] == 0) {
                idxptr--;
            }
            sorted.add(removed);
        }
        
        /* for (int i = 0; i < sorted.size(); i++) 
            System.out.print(sorted.get(i) + " "); */
    }

    public static Integer[] generateNumbers(int a, int b) {
        Integer[] numbers = new Integer[b - a + 1];
        for (int i = a; i <= b; i++) {
            numbers[i - a] = i;
        }
        Collections.shuffle(Arrays.asList(numbers));
        return numbers;
    }

    public static void runTest() {
        for (int i = 1; i <= 10000000; i *= 2) {
            long startTime = System.nanoTime();
            sorter(generateNumbers(1, i));
            long endTime = System.nanoTime();

            float duration = (endTime - startTime) / 1000000;
            System.out.println("Sorting randomized list of numbers from 1 to " + 
            i + "   \ttook " + duration + "\t milliseconds");
        }
    }
}