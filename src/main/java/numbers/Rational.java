package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    private int numerator;
    private int denominator;
    Rational(int a){
        this.numerator = a;
        this.denominator = 1;
    }

    Rational(){
        this.numerator = 0;
        this.denominator = 1;
    }

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
