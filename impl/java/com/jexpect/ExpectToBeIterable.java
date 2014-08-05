package com.jexpect;

import com.jexpect.util.IterableMatcher;

class ExpectToBeIterable<T> implements ToBeCollection<T> {

  private final IterableMatcher<T> matcher;

  ExpectToBeIterable(IterableMatcher<T> matcher) {
    this.matcher = matcher;
  }

  @Override
  public void toBeEmpty() {
    if (matcher.isNotEmpty()) {
      throw new IllegalArgumentException("Expected to be empty, but found items.");
    }
  }

  @Override
  public void toContain(T expected) {
    if (matcher.containsNot(expected)) {
      throw new IllegalArgumentException(String.format("Item <%s> was not found.", expected));
    }
  }

  @Override
  public ToBeCollection<T> not() {
    return new ExpectedToBeIterableNot<>(matcher);
  }

  private static class ExpectedToBeIterableNot<T> implements ToBeCollection<T> {

    private final IterableMatcher<T> matcher;

    private ExpectedToBeIterableNot(IterableMatcher<T> matcher) {
      this.matcher = matcher;
    }

    @Override
    public void toBeEmpty() {
      if (matcher.isEmpty()) {
        throw new IllegalArgumentException("Expected not to be empty, but was actually empty.");
      }
    }

    @Override
    public void toContain(T expected) {
      if (matcher.contains(expected)) {
        throw new IllegalArgumentException(String.format("Expected not to contain item <%s>, but was contained.", expected));
      }
    }


    @Override
    public ToBeCollection<T> not() {
      return new ExpectToBeIterable<>(matcher);
    }
  }
}
