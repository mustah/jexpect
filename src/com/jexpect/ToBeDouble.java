package com.jexpect;

public interface ToBeDouble extends ToBe<Double> {

  void toBeLessThan(double expected);

  void toBeGreaterThan(double expected);

}
