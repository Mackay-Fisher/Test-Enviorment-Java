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
        if(r.numerator == 0){
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        else{
            int num = this.numerator * r.denominator;
            int den = this.denominator * r.numerator;
            System.out.println(num + " " + den);
            return new Rational(num, den);
        }
    }

    public Rational plus(Rational r){
        return new Rational(this.numerator * r.denominator + r.numerator * this.denominator, this.denominator * r.denominator);
    }

    public Rational minus(Rational r){
        return this.plus(r.opposite());
    }

    public Rational raisedToThePowerOf(int n){
        if(n == 0){
            return new Rational(1,1);
        }
        if(n < 0){
            return new Rational(this.denominator, this.numerator).raisedToThePowerOf(-n);
        }
        int a = this.numerator;
        int b = this.denominator;
        for(int i = 0; i < n-1; i++){
            this.numerator = this.numerator * a;
            this.denominator = this.denominator * b;
        }
        return new Rational(this.numerator, this.denominator);
    }

    public boolean equals(Object o){
        if(o instanceof Rational){
            Rational r = (Rational) o;
            return this.numerator == r.numerator && this.denominator == r.denominator;
        } else {
            return false;
        }
    }

    public boolean greaterThan(Rational r){
        return this.numerator * r.denominator > r.numerator * this.denominator;
    }

    public boolean lessThan(Rational r){
        return this.numerator * r.denominator < r.numerator * this.denominator;
    }

    public boolean greaterThan(Number n){
        Number a =((double)this.numerator) / ((double)this.denominator);
        return a.doubleValue() > n.doubleValue();
    }

    public boolean lessThan(Number n){
        Number a = ((double)this.numerator) / ((double)this.denominator);
        return a.doubleValue() < n.doubleValue();
    }

    public boolean isZero(){
        return this.numerator == 0;
    }

    public boolean isOne(){
        return this.numerator == this.denominator;
    }

    public boolean isMinusOne(){
        boolean a_negative = this.numerator < 0;
        boolean b_negative = this.denominator < 0;
        if(a_negative){
            this.numerator = -this.numerator;
        }
        if(b_negative){
            this.denominator = -this.denominator;
        }
        if(this.numerator == this.denominator && (a_negative || b_negative)){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        if(this.denominator == 1){
            return "" + this.numerator;
        }else{
            return this.numerator + "/" + this.denominator;
        }
    }


}
