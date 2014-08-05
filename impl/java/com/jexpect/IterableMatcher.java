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

  boolean containsNot(T item) {
    return !contains(item);
  }

  boolean contains(T item) {
    if (iterable != null) {
      for (T t : iterable) {
        if (t.equals(item)) {
          return true;
        }
      }
    }
    return false;
  }
}
