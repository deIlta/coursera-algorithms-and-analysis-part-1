package Week_1.ProgrammingAssignment_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSortAndCountingInversions {

    private int[] auxArray;      // auxiliary array;

    public long sort(int[] array)
    {
        auxArray = new int[array.length];
        long number = sortAndCountInversions(array, 0, array.length - 1);
        System.out.println(number);
        // display(array);
        
        return number;
    }

    private void display(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }

    private long sortAndCountInversions(int[] array, int begin, int end)
    {
        if(begin == end) return 0;

        int middle = (end + begin) / 2;

        return sortAndCountInversions(array, begin, middle) + sortAndCountInversions(array, middle + 1, end) +
                mergeAndCountInversions(array, begin, middle, end);
    }

    private long mergeAndCountInversions(int[] array, int begin, int middle, int end)
    {
        long count = 0;
        int i = begin;
        int j = middle + 1;

        // copy to auxiliary array array[begin..end];
        for (int l = begin; l <= end; l++)
        {
            auxArray[l] = array[l];
        }

        // merging; compare numbers in auxiliary array and write to array;
        for (int l = begin; l <= end ; l++) {

            if(i > middle)
            {
                count += (middle - i + 1);
                array[l] = auxArray[j++];
            }
            else if(j > end) array[l] = auxArray[i++];
            else if(auxArray[i] < auxArray[j]) // I FOUND IT! (here i do the mistake: array[i] < array[j])
                array[l] = auxArray[i++];
            else {
                count += (middle - i + 1);
                array[l] = auxArray[j++];
            }

        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        MergeSortAndCountingInversions sort = new MergeSortAndCountingInversions();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of file: ");
        String location = scanner.next();

        int[] array = new int[100000];
        BufferedReader reader = new BufferedReader(new FileReader(new File(location)));

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort.sort(array);

    }

}
