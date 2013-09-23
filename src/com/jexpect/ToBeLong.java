package com.jexpect;

public interface ToBeLong extends ToBe<Long> {

  void toBeLessThan(Long expected);

  void toBeGreaterThan(Long expected);

}
