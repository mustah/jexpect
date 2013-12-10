package com.jexpect.api;

public interface ToBeNumber<N extends Number> extends ToBe<N>, Not<ToBeNumber<N>> {

  void toBeLessThan(N expected);

  void toBeLessThanOrEqual(N expected);

  void toBeGreaterThan(N expected);

  void toBeGreaterThanOrEqual(N expected);
}
