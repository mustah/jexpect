package com.jexpect;

public interface ToBeBoolean extends ToBe<Boolean>, Not<ToBeBoolean> {

  void toBeTrue();

  void toBeFalse();
}
