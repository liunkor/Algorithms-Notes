import java.util.Objects;

/**
 * A rational number class
 */
public class Rational {
    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Invalid argument");
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            numerator = -Math.abs(numerator);
        }
        else {
            numerator = Math.abs(numerator);
        }
        denominator = Math.abs(denominator);

        long bgcd = gcd(Math.abs(numerator), Math.abs(denominator));
        if (bgcd > 1) {
            numerator = numerator / bgcd;
            denominator = denominator / bgcd;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * rational number a plus rational number b   e.g 1/5 + 6/13  1/8 + 3/4
     * @param b other Rational object
     * @return
     */
    public Rational plus(Rational b) {
        if (this.equals(b))
            return new Rational(this.numerator*2, this.denominator);
        else if (this.denominator == b.denominator) {
            long newNumerator = this.numerator + b.numerator;
            return new Rational(newNumerator, this.denominator);
        }
        else {
            long newDenominator = this.denominator * b.denominator;
            long newNumerator = this.numerator * b.denominator + b.numerator * this.denominator;
            return new Rational(newNumerator, newDenominator);
        }
    }

    public Rational minus(Rational b) {
        if (this.equals(b))
            return new Rational(0, denominator);
        return this.plus(new Rational(-b.numerator, b.denominator));
    }

    public Rational times(Rational b) {
        if (b == null)
            throw new IllegalArgumentException("Invalid argument");
        return new Rational(numerator * b.numerator,
                denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        if (b == null)
            throw new IllegalArgumentException("Invalide argument");
        if (b.numerator == 0)
            throw new IllegalArgumentException("The divider cann't be 0.");
        return new Rational(numerator * b.denominator,
                denominator * b.numerator);
    }

    @Override
    public String toString() {
        if (numerator == 0) return "0";
        if (numerator == denominator) return "1";
        if (numerator == -denominator) return "-1";
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Rational)) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator &&
                denominator == rational.denominator;
    }

    // find the best common divisor of p and q
    public long gcd(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        Rational rational1 = new Rational(25, 125);
        System.out.println(rational1);
        Rational rational2 = new Rational(-2, 5);
        System.out.println(rational2);
        System.out.println(rational1.times(rational2));
    }
}
