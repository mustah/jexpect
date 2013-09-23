package com.jexpect;

public interface ToBeDouble extends ToBe<Double> {

  void toBeLessThan(Double expected);

  void toBeGreaterThan(Double expected);

}
