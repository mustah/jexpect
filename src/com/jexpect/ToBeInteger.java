package com.jexpect;

public interface ToBeInteger extends ToBe<Integer> {

  void toBeLessThan(Integer expected);

  void toBeGreaterThan(Integer expected);
}
