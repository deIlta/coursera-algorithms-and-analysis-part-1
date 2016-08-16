package Week_2.ProgrammingAssignment_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class QuickSort
{
    public int sortAndCountComparisonWithBeginPivot (int[] array)
    {
        return sortBeginPivot(array, 0, array.length - 1);
    }

    public int sortAndCountComparisonWithEndPivot (int[] array)
    {
        return sortEndPivot(array, 0, array.length - 1);
    }

    public int sortAndCountComparisonWithMiddlePivot (int[] array)
    {
        return sortMiddlePivot (array, 0, array.length - 1);
    }

    private int sortMiddlePivot(int[] array, int begin, int end)
    {
        if(begin >= end) return 0;

        int comp = end - begin;
        sortMiddle(array, begin, end);
        int pivotIndex = partition(array, begin, end);
        comp += sortMiddlePivot(array, begin, pivotIndex - 1);
        comp += sortMiddlePivot(array, pivotIndex + 1, end);
        return comp;
    }

    private int sortBeginPivot(int[] array, int begin, int end)
    {
        if(begin >= end) return 0;

        int comp = end - begin;
        int pivotIndex = partition(array, begin, end);
        comp += sortBeginPivot(array, begin, pivotIndex - 1);
        comp += sortBeginPivot(array, pivotIndex + 1, end);
        return comp;
    }

    private int sortEndPivot(int[] array, int begin, int end)
    {
        if(begin >= end) return 0;

        int comp = end - begin;
        swap(array, end, begin);
        int pivotIndex = partition(array, begin, end);
        comp += sortEndPivot(array, begin, pivotIndex - 1);
        comp += sortEndPivot(array, pivotIndex + 1, end);
        return comp;
    }

    private int sort(int[] array, int begin, int end)
    {
        if(begin >= end) return 0;

        int comp = end - begin;
        // sortMiddle(array, begin, end); // 3 quetsion;
        // swap(array, end, begin);       // 2 question;
        int pivotIndex = partition(array, begin, end); // 1 question;
        comp += sort(array, begin, pivotIndex - 1);
        comp += sort(array, pivotIndex + 1, end);
        return comp;
    }

    private int partition(int[] array, int begin, int end)
    {
        int pivot = array[begin];
        int i = begin + 1;
        for (int j = begin + 1; j <= end; j++)
        {
            if(array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, begin, i - 1);

        return i - 1;
    }

    // select middle value (VALUE!!)
    private void sortMiddle(int[] array, int begin, int end)
    {
        int middle = begin + ( end - begin ) / 2;


        if(array[begin] >= array[middle] && array[begin] >= array[end])
        {
            if(array[middle] >= array[end]) swap(array, middle, begin);
            else swap(array, end, begin);
        }
        else if(array[middle] >= array[begin] && array[middle] >= array[end])
        {
            if(array[end] >= array[begin]) swap(array, begin, end);
        }
        else if( array[middle] >= array[begin]) {
            swap(array, begin, middle);
        }
    }

    private void swap(int[] array, int elem1, int elem2)
    {
        int tempt = array[elem1];
        array[elem1] = array[elem2];
        array[elem2] = tempt;
    }

    public static void main(String[] args) throws Exception
    {
        QuickSort quickSort = new QuickSort();

        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\QuickSort.txt")));

        int[] array1 = new int[10000];
        int[] array2 = new int[10000];
        int[] array3 = new int[10000];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        System.out.println("Begin pivot: " + quickSort.sortAndCountComparisonWithBeginPivot(array1));
        System.out.println("End pivot: " + quickSort.sortAndCountComparisonWithEndPivot(array2));
        System.out.println("Middle pivot: " + quickSort.sortAndCountComparisonWithMiddlePivot(array3));
    }
}
