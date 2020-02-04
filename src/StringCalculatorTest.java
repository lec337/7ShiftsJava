// Leon Cadotte, 7Shifts Exercise

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    /**
     * Tests the inputToInt method of StringCalculator
     */
    @Test
    public void inputToIntTest(){
        String[] testInputs = {"//,\n1,2,3","//@\n56","// \n1 1 1 1 1 1 1 1 1 1","//?\n4312?","//-\n2-3-45\n-\n7\n","////\n6//4\n"};
        int[][] expectedReturn = {{1,2,3},{56},{1,1,1,1,1,1,1,1,1,1},{4312},{2,3,45,7},{6,4}};
        for(int i=0; i<testInputs.length; i++){
            assertArrayEquals(expectedReturn[i],StringCalculator.inputToInt(testInputs[i]));
        }

        // test that exceptions are thrown in the case of bad input
        String[] exceptionInputs = {"//;\n","//,\n12ds,5,2","//,\n67,a21,89","\n","\n\n\n\n\n","//,\n\nd\n12","//,\n6\ng,\n4rt\n",
            "//\n","//9\n89791","//j9l\n6j9l7j9l", "1,2,3"};
        boolean exceptionThrown = false;
        for(int i=0;i<exceptionInputs.length;i++){
            try{
                StringCalculator.inputToInt(exceptionInputs[i]);
            }catch (IllegalArgumentException e){
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
        String[] testInputs = {"//,\n1,2,3","//+\n1+1","//b\n464b1b0","////\n1//1//1//1//1//1//1//1//1//1", "//?\n2?","",
                    "//***^%\n1\n4***^%\n5***^%0","//ghy\n\n5\n\n\n8ghy\n5ghy3ghy1ghy1","//.*\n4\n.*5"};
        int[] expectedReturn = {6,2,465,10,2,0,19,68,9};
        for(int i=0; i<testInputs.length; i++){
            assertEquals(expectedReturn[i],StringCalculator.Add(testInputs[i]));
        }
    }
}
