package com.jexpect.api;

public interface ToBeBoolean extends ToBe<Boolean>, Not<ToBeBoolean> {

  void toBeTrue();

  void toBeFalse();
}
