package com.jexpect;

class ExpectToBeIterable<T> implements ToBeCollection<T> {

  private final Iterable<T> actual;

  ExpectToBeIterable(Iterable<T> actual) {
    this.actual = actual;
  }

  @Override
  public void toBeEmpty() {
    if (actual != null && actual.iterator().hasNext()) {
      throw new IllegalArgumentException("Expected to be empty, but found items.");
    }
  }

  @Override
  public void toContain(T item) {
    if (!itemFound(item)) {
      throw new IllegalArgumentException(String.format("Item <%s> was not found.", item));
    }
  }

  @Override
  public ToBeCollection<T> not() {
    return new ExpectedToBeIterableNot<T>(actual);
  }

  private boolean itemFound(T item) {
    if (actual != null) {
      for (T anActual : actual) {
        if (anActual.equals(item)) {
          return true;
        }
      }
    }
    return false;
  }

  private static class ExpectedToBeIterableNot<T> implements ToBeCollection<T> {

    private final Iterable<T> actual;

    private ExpectedToBeIterableNot(Iterable<T> actual) {
      this.actual = actual;
    }

    @Override
    public void toBeEmpty() {
      if (actual == null || !actual.iterator().hasNext()) {
        throw new IllegalArgumentException("Expected not to be empty, but was actually empty.");
      }
    }

    @Override
    public void toContain(T item) {

    }

    @Override
    public ToBeCollection<T> not() {
      return null;
    }
  }
}
