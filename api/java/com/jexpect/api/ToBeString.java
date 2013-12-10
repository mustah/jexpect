package com.jexpect.api;

public interface ToBeString extends ToBe<String>, Not<ToBeString> {

  void toBeNull();

  void toBeEmpty();
}
