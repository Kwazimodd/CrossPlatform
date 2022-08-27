package edu.crossplatforms.l1.factory;

import edu.crossplatforms.l1.fractions.BigIntFraction;
import edu.crossplatforms.l1.fractions.IFraction;
import edu.crossplatforms.l1.fractions.IntFraction;

import java.math.BigInteger;

public class FractionsFactory {
    public static IFraction getFractionByValuesIfSize(int size, int num, int den) {
        return (size > 15)
                ? new BigIntFraction(BigInteger.valueOf(num), BigInteger.valueOf(den))
                : new IntFraction(num, den);
    }
}
