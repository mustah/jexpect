package com.jexpect;

public interface ToBeFloat extends ToBe<Float> {

  void toBeLessThan(Float expected);

  void toBeGreaterThan(Float expected);

}
