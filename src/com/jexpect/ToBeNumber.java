package com.jexpect;

public interface ToBeNumber<N extends Number> extends ToBe<N> {

  void toBeLessThan(N expected);

  void toBeLessThanOrEqual(N expected);

  void toBeGreaterThan(N expected);

  void toBeGreaterThanOrEqual(N expected);
}
