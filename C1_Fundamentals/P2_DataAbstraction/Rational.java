package P2_DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by rliu on 8/27/16.
 */
public class Rational implements Comparator<Rational> {
    public static final Rational ZERO = new Rational(0, 1);
    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator is 0");
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            long g = gcd(numerator, denominator);
            this.numerator = numerator / g;
            this.denominator = denominator / g;
        }
    }

    public static void main(String[] args) {
        Rational a = new Rational(5, 12);
        Rational b = new Rational(5, 8);
        Rational c = new Rational(0, 1);
        StdOut.println(a.plus(b));
        StdOut.println(a.minus(b));
        StdOut.println(a.times(b));
        StdOut.println(a.divides(b));
    }

    public Rational plus(Rational b) {
        if (compare(this, ZERO) == 0)
            return b;
        if (compare(b, ZERO) == 0)
            return this;
        long g = gcd(this.denominator, b.denominator);
        long f = gcd(this.numerator, b.numerator);
        long den = this.denominator / g * b.denominator / g;
        long num = this.numerator / f * b.denominator / g + this.denominator / g * b.numerator / f;

        return new Rational(num * f, den * g);
    }

    public Rational minus(Rational b) {
        if (compare(this, ZERO) == 0)
            return new Rational(-b.numerator, b.denominator);
        if (compare(b, ZERO) == 0)
            return this;

        long g = gcd(this.denominator, b.denominator);
        long f = gcd(this.numerator, b.numerator);
        long den = this.denominator / g * b.denominator / g;
        long num = this.numerator / f * b.denominator / g - this.denominator / g * b.numerator / f;

        return new Rational(num * f, den * g);
    }

    public Rational times(Rational b) {
        if (compare(this, ZERO) == 0 || compare(b, ZERO) == 0)
            return ZERO;
//        long den = this.denominator * b.denominator;
//        long num = this.numerator * b.numerator;
//        long g = gcd(num, den);
        long g = gcd(this.numerator, b.denominator);
        long f = gcd(this.denominator, b.numerator);
        long den = (this.denominator / f) * (b.denominator / g);
        long num = (this.numerator / g) * (b.numerator / f);
        return new Rational(num, den);

    }

    public Rational divides(Rational b) {
        if (compare(this, ZERO) == 0)
            return ZERO;
        Rational bR = new Rational(b.denominator, b.denominator);
        return this.times(bR);
    }

    public boolean equals(Rational that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        return compare(this, that) == 0;
    }

    public String toString() {
        return numerator + "/" + denominator;

    }

    public long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    @Override
    public int compare(Rational o1, Rational o2) {
        long a = o1.numerator * o2.denominator;
        long b = o1.denominator * o2.numerator;
        if (a > b)
            return 1;
        if (a < b)
            return -1;
        else
            return 0;
    }
}
