package com.jexpect;

public interface ToBeInteger {

  void toBe(int expected);

  void toBeLessThan(int expected);

  void toBeGreaterThan(int expected);
}
