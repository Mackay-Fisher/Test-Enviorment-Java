package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{
    private int numerator;
    private int denominator;


    Rational(int a, int b){
        this.numerator = a;
        this.denominator = b;
    }

    public int numerator() {
        return this.numerator;
     }
     
     public int denominator() {
        return this.denominator;
     }
}
