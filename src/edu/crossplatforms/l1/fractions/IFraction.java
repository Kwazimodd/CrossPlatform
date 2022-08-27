package edu.crossplatforms.l1.fractions;

public interface IFraction {
    IFraction lowest();
    IFraction add(IFraction other);
    Number getNum();
    Number getDen();
}
