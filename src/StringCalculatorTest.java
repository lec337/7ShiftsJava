// Leon Cadotte, 7Shifts Exercise

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    /**
     * Tests the inputToInt method of StringCalculator
     */
    @Test
    public void inputToIntTest(){
        String[] testInputs = {"1,2,3","56","1,1,1,1,1,1,1,1,1,1","4312,"};
        int[][] expectedReturn = {{1,2,3},{56},{1,1,1,1,1,1,1,1,1,1},{4312}};
        for(int i=0; i<testInputs.length; i++){
            assertArrayEquals(expectedReturn[i],StringCalculator.inputToInt(testInputs[i]));
        }

        // test that exceptions are thrown in the case of bad input
        String[] exceptionInputs = {"","12ds,5,2","67,a21,89"};
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
        String[] testInputs = {"1,2,3","1,1","465","1,1,1,1,1,1,1,1,1,1", "2,",""};
        int[] expectedReturn = {6,2,465,10,2,0};
        for(int i=0; i<testInputs.length; i++){
            assertEquals(expectedReturn[i],StringCalculator.Add(testInputs[i]));
        }
    }
}
