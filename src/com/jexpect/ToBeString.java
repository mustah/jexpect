package com.jexpect;

public interface ToBeString extends ToBe<String> {

  void toBeNull();

  void toBeEmpty();

  void toBeNotEmpty();
}
