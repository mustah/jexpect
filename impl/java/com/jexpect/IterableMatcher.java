package com.jexpect;

class IterableMatcher<T> {

  private final Iterable<T> iterable;

  IterableMatcher(Iterable<T> iterable) {
    this.iterable = iterable;
  }

  boolean isEmpty() {
    return iterable == null || !iterable.iterator().hasNext();
  }

  boolean isNotEmpty() {
    return !isEmpty();
  }

  boolean containsNot(T expected) {
    return !contains(expected);
  }

  boolean contains(T expected) {
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
