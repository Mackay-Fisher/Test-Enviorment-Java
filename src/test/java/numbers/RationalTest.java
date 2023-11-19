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

        Rational a = new Rational(2, 3);
        Rational b = new Rational(5, 7);
        Rational divide = a.dividedBy(b);
        assertThat("2 * 7 = 14", divide.numerator(), is(14));
        assertThat("3 * 5 = 15", divide.denominator(), is(15));

        Rational x = new Rational(2, 3);
        Rational y = new Rational(0, 4);
        assertThrows(IllegalArgumentException.class, ()->x.dividedBy(y));

        Rational c = new Rational(2, 3);
        Rational d = new Rational(5, 7);
        Rational plus = c.plus(d);
        assertThat("2 * 7 + 5 * 3 = 29", plus.numerator(), is(29));
        assertThat("3 * 7 = 21", plus.denominator(), is(21));

        Rational e = new Rational(2, 3);
        Rational f = new Rational(5, 7);
        Rational minus = e.minus(f);
        assertThat("2 * 7 - 5 * 3 = -1", minus.numerator(), is(-1));
        assertThat("3 * 7 = 21", minus.denominator(), is(21));


        Rational g = new Rational(2, 3);
        Rational h = g.raisedToThePowerOf(4);
        assertThat("2^4 = 16", h.numerator(), is(16));
        assertThat("3^4 = 81", h.denominator(), is(81));

        Rational i = new Rational(2, 3);
        Rational j = i.raisedToThePowerOf(0);
        assertThat("2^0 = 1", j.numerator(), is(1));
        assertThat("3^0 = 1", j.denominator(), is(1));

        Rational k = new Rational(2, 3);
        Rational l = k.raisedToThePowerOf(-2);
        assertThat("3^2 = 9", l.numerator(), is(9));
        assertThat("2^2 = 4", l.denominator(), is(4)); 
        
        Rational m = new Rational(2, 3);
        Rational n = new Rational(1,2);
        boolean equal = m.equals(n);
        assertThat("2/3 != 1/2", equal, is(false));

        Rational o = new Rational(2, 3);
        Rational p1 = new Rational(2, 3);
        boolean equal1 = o.equals(p1);
        assertThat("2/3 == 2/3", equal1, is(true));

        Rational q1 = new Rational(2, 3);
        Rational r = new Rational(2, 3);
        boolean greaterThan = q1.greaterThan(r);
        assertThat("2/3 > 2/3", greaterThan, is(false));

        Rational s = new Rational(2, 3);
        Rational t = new Rational(1, 2);
        boolean greaterThan1 = s.greaterThan(t);
        assertThat("2/3 > 1/2", greaterThan1, is(true));


        Rational u = new Rational(2, 3);
        boolean greaterThan2 = u.greaterThan(.6);
        assertThat("2/3 > 0.6", greaterThan2, is(true));

        Rational v = new Rational(2, 3);
        boolean greaterThan3 = v.greaterThan(.7);
        assertThat("2/3 > 0.7", greaterThan3, is(false));

        Rational u1 = new Rational(2, 3);
        Rational v1 = new Rational(1, 2);
        boolean lessThan = u1.lessThan(v1);
        assertThat("2/3 < 1/2", lessThan, is(false));

        Rational w = new Rational(1, 2);
        Rational x1 = new Rational(2, 3);
        boolean lessThan1 = w.lessThan(x1);
        assertThat("2/3 < 1/2", lessThan1, is(true));

        Rational y1 = new Rational(2, 3);
        boolean leeThan2 = y1.lessThan(.6);
        assertThat("2/3 < 0.6", leeThan2, is(false));

        Rational z = new Rational(2, 3);
        boolean leeThan3 = z.lessThan(.7);
        assertThat("2/3 < 0.7", leeThan3, is(true));

        Rational a1 = new Rational(2, 3);
        boolean isZero = a1.isZero();
        assertThat("2/3 is not zero", isZero, is(false));

        Rational b1 = new Rational(0, 3);
        boolean isZero1 = b1.isZero();
        assertThat("0/3 is zero", isZero1, is(true));

        Rational c1 = new Rational(2, 3);
        boolean isOne = c1.isOne();
        assertThat("2/3 is not one", isOne, is(false));

        Rational d1 = new Rational(1, 1);
        boolean isOne1 = d1.isOne();
        assertThat("1/1 is one", isOne1, is(true));


        Rational e1 = new Rational(2, 3);
        boolean isMinusOne = e1.isMinusOne();
        assertThat("2/3 is not minus one", isMinusOne, is(false));

        Rational f1 = new Rational(-1, 1);
        boolean isMinusOne1 = f1.isMinusOne();
        assertThat("-1/1 is minus one", isMinusOne1, is(true));

        Rational g1 = new Rational(2, 3);
        String str = g1.toString();
        assertThat("2/3 is not minus one", str, is("2/3"));

        Rational h1 = new Rational(-1, 1);
        String str1 = h1.toString();
        assertThat("-1/1 is minus one", str1, is("-1"));

        Rational i1 = new Rational(2, 3);
        boolean isMinusOne2 = i1.isMinusOne();
        assertThat("2/3 is not minus one", isMinusOne2, is(false));

        Rational j1 = new Rational(-1, 1);
        boolean isMinusOne3 = j1.isMinusOne();
        assertThat("-1/1 is minus one", isMinusOne3, is(true));

        Rational k1 = new Rational(1, -1);
        boolean isMinusOne4 = k1.isMinusOne();
        assertThat("1/-1 is minus one", isMinusOne4, is(true));

        Rational l1 = new Rational(-1, -1);
        boolean isMinusOne5 = l1.isMinusOne();
        assertThat("-1/-1 is minus one", isMinusOne5, is(false));

        



        //Add more rigirous testings here

    }
}
