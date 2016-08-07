package Week_1.ProgrammingAssignment_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by comp on 07.08.2016.
 */
public class MergeSortAndCountingInversionsTest {

    private MergeSortAndCountingInversions countingInversions = new MergeSortAndCountingInversions();

    @Test
    public void testLittlePositiveNumberedArray()
    {
        Assert.assertEquals("Error in testing positive numbered array", 3, countingInversions.sort(new int[] {3, 2, 1}));
    }

    @Test
    public void testSortedArray()
    {

        Assert.assertEquals("Error in testing positive numbered array", 0, countingInversions.sort(new int[] {1223, 42342, 653645}));
    }

}
