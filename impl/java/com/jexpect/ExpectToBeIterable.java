package com.jexpect;

class ExpectToBeIterable<T> implements ToBeCollection<T> {

  private final Iterable<T> actual;

  ExpectToBeIterable(Iterable<T> actual) {
    this.actual = actual;
  }

  @Override
  public void toBeEmpty() {
    if (actual != null && actual.iterator().hasNext()) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toContain(T item) {
    if (actual == null || !actual.iterator().hasNext() || item == null) {
      throw new IllegalArgumentException("not yet fully implemented");
    }
  }

  @Override
  public ToBeCollection<T> not() {
    throw new IllegalArgumentException("not yet fully implemented ");
  }
}
