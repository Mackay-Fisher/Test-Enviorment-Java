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
        boolean a_negative = a < 0;
        boolean b_negative = b < 0;
        int min = 0;
        if (a_negative) {
            a = -a;
        }
        if (b_negative) {
            b = -b;
        }
        if (a == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            //find gcd of a and b
            int gcd = 1;
            if(a<b){
                min = a;
            } else {
                min = b;
            }
            for (int i = 1; i <=min; i++) {
                if (a % i == 0 && b % i == 0) {
                    gcd = i;
                }
            }
            if(a_negative || b_negative){
                a = -a;
            }
            a = a / gcd;
            b = b / gcd;
            this.numerator = a;
            this.denominator = b;
        }
    }

    Rational(Rational r){
        this(r.numerator, r.denominator);
    }

    public Rational opposite(){
        return new Rational(-this.numerator, this.denominator);
    }

    public Rational reciprocal(){
        //check to make sure numerator is not 0
        if(this.numerator == 0){
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        return new Rational(this.denominator, this.numerator);
    }

    public Rational times(Rational r){
        return new Rational(this.numerator * r.numerator, this.denominator * r.denominator);
    }

    public Rational dividedBy(Rational r){
        return this.times(r.reciprocal());
    }

    public Rational plus(Rational r){
        return new Rational(this.numerator * r.denominator + r.numerator * this.denominator, this.denominator * r.denominator);
    }

    public Rational minus(Rational r){
        return this.plus(r.opposite());
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational() {
        this(0, 1);
    }

    public int numerator() {
        return this.numerator;
     }
     
     public int denominator() {
        return this.denominator;
     }
}
