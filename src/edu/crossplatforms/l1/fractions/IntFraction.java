package edu.crossplatforms.l1.fractions;

import edu.crossplatforms.l1.utils.NumberUtil;

public class IntFraction implements IFraction {
    private final int num;
    private final int den;

    public IntFraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    private IntFraction(IFraction other) {
        this.num = other.getNum().intValue();
        this.den = other.getDen().intValue();
    }

    private int countResultDen(int otherDen) {
        return (den * otherDen) / NumberUtil.gcd(den, otherDen);
    }

    @Override
    public IFraction lowest() {
        int gcd = NumberUtil.gcd(num, den);
        return new IntFraction(num/gcd, den/gcd);
    }

    @Override
    public IFraction add(IFraction other) {
        IntFraction otherInt = new IntFraction(other);
        int den3 = countResultDen(otherInt.den);
        int num3 = num * (den3/den) + otherInt.num * (den3/otherInt.den);
        return new IntFraction(num3, den3).lowest();
    }

    @Override
    public Number getNum() {
        return this.num;
    }

    @Override
    public Number getDen() {
        return this.den;
    }

    @Override
    public String toString() {
        return num + " / " + den;
    }
}
