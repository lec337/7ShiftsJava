import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Leon Cadotte, 7Shifts Exercise
public class StringCalculator {

    /**
     * converts the input string numbers into an array of integers
     * @param input: String of the form "//<delimiter>\nx<delimiter>y<delimiter>z..." where x,y,z are numbers and <delimiter> is
     *             a custom, special sequence of characters used to separate numbers, input cannot be the empty string, input can contain
     *             newlines, delimiter cannot be the newline or a number
     * @return integer array containing the numbers from the input string
     * @throws NumberFormatException if input is an empty string, or a string number cannot be converted to an integer,
     * @throws IllegalArgumentException if input isn't lead by valid delimiter
     */
    protected static int[] inputToInt(String input) throws NumberFormatException, IllegalArgumentException{
        if(input.isEmpty()){
            throw new NumberFormatException("Cannot convert an empty string to integers");
        }
        // extract the custom delimiter using a regular expression
        Matcher m = Pattern.compile("(^//.+\n)").matcher(input);
        if(! m.find()){
            // no matches for the general delimiter pattern were found in the input
            throw new IllegalArgumentException("Input: " + input + " has invalid delimiter format");
        }
        // get the delimiter
        String delimiter = m.group(0);
        // remove the leading delimiter from input
        input = input.substring(delimiter.length());
        // delimiter contains leading '//' and ending '\n', remove these
        delimiter = delimiter.replaceAll("^//","");
        delimiter = delimiter.replaceAll("\n$","");

        // determine if the delimiter contains any digits
        m = Pattern.compile("([0-9]+)").matcher(delimiter);
        if(m.find()){
            // found digits in delimiter
            throw new NumberFormatException("Delimiter: " + delimiter + " is invalid, contains digits");
        }

        // delimiter may contain several special characters like '*'. '?', etc, we need to escape these characters
        // or else they will be improperly interpreted as regex patterns
        delimiter = delimiter.replaceAll("\\W","\\\\$0");

        // convert each number from 'input' to an integer
        String[] stringNumbers = input.split(delimiter);
        System.out.println(Arrays.toString(stringNumbers));
        int[] integerNumbers = new int[stringNumbers.length];
        for(int i=0;i<stringNumbers.length;i++){
            try {
                // remove newlines from individual strings if any exist
                String currentStr = stringNumbers[i].replaceAll("\n","");
                integerNumbers[i] = Integer.parseInt(currentStr);
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
