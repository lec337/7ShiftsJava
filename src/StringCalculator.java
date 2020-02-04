// Leon Cadotte, 7Shifts Exercise
public class StringCalculator {

    /**
     * converts the input string numbers into an array of integers
     * @param input: String of the form "x,y,z..." where x,y,z are numbers, input cannot be the empty string
     * @return integer array containing the numbers from the input string
     * @throws NumberFormatException if input is an empty string, or a string number cannot be converted to an integer
     */
    protected static int[] inputToInt(String input) throws NumberFormatException{
        if(input.isEmpty()){
            throw new NumberFormatException("Cannot convert an empty string to integers");
        }
        // convert each number from 'input' to an integer
        String[] stringNumbers = input.split(",");
        int[] integerNumbers = new int[stringNumbers.length];
        for(int i=0;i<stringNumbers.length;i++){
            try {
                integerNumbers[i] = Integer.parseInt(stringNumbers[i]);
            }catch(NumberFormatException e){
                throw new NumberFormatException("Cannot convert string number: " + stringNumbers[i]
                + " to an integer");
            }
        }
        return integerNumbers;
    }

    /**
     * Adds up the numbers in the string 'numbers', returns the integer resulting
     * @param numbers: String of the form "x,y,z..." where x,y,z are numbers, if the empty string is input, 0 is returned
     * @return integer, result of adding the integers in the string 'numbers', or 0 if numbers is the empty string
     */
    public static int Add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        int[] arguments = inputToInt(numbers);
        // add arguments
        int sum = 0;
        for(int arg : arguments){
            sum += arg;
        }
        return sum;
    }


}
