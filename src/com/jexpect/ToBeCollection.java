package com.jexpect;

public interface ToBeCollection<T> {

  void toBeEmpty();

  void toContain(T item);
}