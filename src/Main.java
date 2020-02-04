// Leon Cadotte, 7Shifts Exercise
// Code to run Junit tests from main found from: https://www.baeldung.com/junit-tests-run-programmatically-from-java
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class Main {
    public static void main(String[] args){
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(StringCalculatorTest.class);
    }
}
