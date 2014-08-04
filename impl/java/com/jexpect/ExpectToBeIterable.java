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
  public void toContain(T expected) {
    if (!itemFoundIn(actual, expected)) {
      throw new IllegalArgumentException(String.format("Item <%s> was not found.", expected));
    }
  }

  @Override
  public ToBeCollection<T> not() {
    return new ExpectedToBeIterableNot<>(actual);
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
    public void toContain(T expected) {
      if (itemFoundIn(actual, expected)) {
        throw new IllegalArgumentException(String.format("Expected not to contain item <%s>, but was contained.", expected));
      }
    }

    @Override
    public ToBeCollection<T> not() {
      return new ExpectToBeIterable<>(actual);
    }
  }

  private static <T> boolean itemFoundIn(Iterable<T> actual, T expected) {
    if (actual != null) {
      for (T item : actual) {
        if (item.equals(expected)) {
          return true;
        }
      }
    }
    return false;
  }
}
