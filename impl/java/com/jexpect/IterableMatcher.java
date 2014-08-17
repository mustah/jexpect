package com.jexpect;

class IterableMatcher<T> {

  private final Iterable<T> iterable;

  IterableMatcher(Iterable<T> iterable) {
    this.iterable = iterable;
  }

  Integer getSizeOfIterable() {
    return iterable != null ? size(null) : null;
  }

  Iterable<T> getIterable() {
    return iterable;
  }

  boolean hasSize(int expected) {
    return iterable != null && size(expected) == expected;
  }

  boolean hasNotSize(int expected) {
    return !hasSize(expected);
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

  private int size(Integer expected) {
    int size = 0;
    for (T t : iterable) {
      size++;
      if (expected != null && size > expected) break;
    }
    return size;
  }
}
