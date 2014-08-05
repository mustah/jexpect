package com.jexpect.util;

public class IterableMatcher<T> {

  private final Iterable<T> iterable;

  public IterableMatcher(Iterable<T> iterable) {
    this.iterable = iterable;
  }

  public boolean isEmpty() {
    return iterable == null || !iterable.iterator().hasNext();
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public boolean containsNot(T expected) {
    return !contains(expected);
  }

  public boolean contains(T expected) {
    if (iterable != null) {
      for (T item : iterable) {
        if (item.equals(expected)) {
          return true;
        }
      }
    }
    return false;
  }
}
