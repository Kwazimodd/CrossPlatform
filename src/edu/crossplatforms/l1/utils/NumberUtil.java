package edu.crossplatforms.l1.utils;

import edu.crossplatforms.l1.fractions.BigIntFraction;
import edu.crossplatforms.l1.fractions.IFraction;
import edu.crossplatforms.l1.fractions.IntFraction;

import java.math.BigInteger;
import java.util.Objects;

public class NumberUtil {
    private NumberUtil() {
    }

    public static String getHarmonicSum(int size) throws IllegalArgumentException {
        if (size <= 0) throw new IllegalArgumentException("Size must be greater then 0");
        IFraction sum = (size > 15)
                ? new BigIntFraction(BigInteger.ONE, BigInteger.ONE)
                : new IntFraction(1, 1);

        for(int i = 2; i <= size; i++) {
            IFraction fraction = (size > 15)
                    ? new BigIntFraction(BigInteger.ONE, BigInteger.valueOf(i))
                    : new IntFraction(1, i);
            sum = sum.add(fraction);
        }

        return sum.toString();
    }

    public static int gcd(int a, int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
    }
}
