// Leon Cadotte, 7Shifts Exercise

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    /**
     * Tests the inputToInt method of StringCalculator
     */
    @Test
    public void inputToIntTest(){
        String[] testInputs = {"1,2,3","56","1,1,1,1,1,1,1,1,1,1","4312,","2\n,3,4\n5,\n7","\n6\n"};
        int[][] expectedReturn = {{1,2,3},{56},{1,1,1,1,1,1,1,1,1,1},{4312},{2,3,45,7},{6}};
        for(int i=0; i<testInputs.length; i++){
            assertArrayEquals(expectedReturn[i],StringCalculator.inputToInt(testInputs[i]));
        }

        // test that exceptions are thrown in the case of bad input
        String[] exceptionInputs = {"","12ds,5,2","67,a21,89","\n","\n\n\n\n\n","\nd\n12","6\ng,\n4rt\n"};
        boolean exceptionThrown = false;
        for(int i=0;i<exceptionInputs.length;i++){
            try{
                StringCalculator.inputToInt(exceptionInputs[i]);
            }catch (NumberFormatException e){
                // mark that an exception has been thrown
                exceptionThrown = true;
            }
            // exception should have been thrown
            assertTrue(exceptionThrown);
            // reset exceptionThrown to false so we can detect an exception next iteration
            exceptionThrown = false;
        }
    }

    /**
     * Tests the Add method of StringCalculator
     */
    @Test
    public void AddTest(){
        String[] testInputs = {"1,2,3","1,1","465","1,1,1,1,1,1,1,1,1,1", "2,","","1\n,4,\n5","\n5\n\n\n8,\n5,3,1,1","4\n,5"};
        int[] expectedReturn = {6,2,465,10,2,0,10,68,9};
        for(int i=0; i<testInputs.length; i++){
            assertEquals(expectedReturn[i],StringCalculator.Add(testInputs[i]));
        }
    }
}
