package com.jexpect;

public interface ToBeNumber<NUMBER> extends ToBe<NUMBER> {

  void toBeLessThan(NUMBER expected);

  void toBeGreaterThan(NUMBER expected);
}
