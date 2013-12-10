package com.jexpect.api;

public interface ToBeCollection<T> extends Not<ToBeCollection<T>> {

  void toBeEmpty();

  void toContain(T item);
}
