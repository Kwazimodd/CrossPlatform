package edu.crossplatforms.l1.fractions;

import edu.crossplatforms.l1.utils.NumberUtil;

import java.math.BigInteger;

public class BigIntFraction implements IFraction {
    private final BigInteger num;
    private final BigInteger den;

    public BigIntFraction(BigInteger num, BigInteger den) {
        this.num = num;
        this.den = den;
    }

    private BigIntFraction(IFraction other) {
        this.num = new BigInteger(other.getNum().toString());
        this.den = new BigInteger(other.getDen().toString());
    }

    private BigInteger countResultDen(BigInteger otherDen) {
        BigInteger resultDen = (den.multiply(otherDen));
        resultDen = resultDen.divide(NumberUtil.gcd(den, otherDen));
        return resultDen;
    }

    @Override
    public IFraction lowest() {
        BigInteger gcd = NumberUtil.gcd(den, num);
        return new BigIntFraction(num.divide(gcd), den.divide(gcd));
    }

    @Override
    public IFraction add(IFraction other) {
        BigIntFraction otherBigInt = new BigIntFraction(other);
        BigInteger resultDen = countResultDen(otherBigInt.den);

        BigInteger thisTmp = resultDen.divide(den);
        thisTmp = thisTmp.multiply(num);

        BigInteger otherTmp = resultDen.divide(otherBigInt.den);
        otherTmp = otherTmp.multiply(otherBigInt.num);

        BigInteger resultNum = thisTmp.add(otherTmp);
        return new BigIntFraction(resultNum, resultDen).lowest();
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
