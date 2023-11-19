package numbers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RationalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RationalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RationalTest.class );
    }



    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Rational test2 = new Rational(2);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", test2.numerator(), is(2));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", test2.denominator(), is(1));
        
        Rational test1 = new Rational();

        assertThat("the numerator should be 0", test1.numerator(), is(0));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", test1.denominator(), is(1));
        // Given no preconditions
        Rational value = new Rational(48, -72);
        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.numerator(), is(-2));
        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.denominator(), is(3));

        Rational original = new Rational(2, 3);
// When I create a `Rational` value as a copy of the original `Rational` value
        Rational value2 = new Rational(original);
        // Then the copy's value should have numerator 2
        assertThat("the numerator should be 2", value2.numerator(), is(2));
        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value2.denominator(), is(3));

        Rational value3 = new Rational(2, 3);
        Rational opposite = value3.opposite();
        assertThat("the opposite of 2 is -2", opposite.numerator(), is(-2));
        assertThat("the denominator should be 3", opposite.denominator(), is(3));


        Rational value4 = new Rational(2, 3);
        Rational reciprocal = value4.reciprocal();
        assertThat("the numerator should be 3", reciprocal.numerator(), is(3));
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));

        Rational value5 = new Rational(0);
        assertThrows(IllegalArgumentException.class, value5::reciprocal);

        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.times(q);
        assertThat("2 * 5 = 10", result.numerator(), is(10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));



        //Add more rigirous testings here

    }
}
