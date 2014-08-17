package com.jexpect;

class ExpectToBeIterable<T> implements ToBeCollection<T> {

  private final IterableMatcher<T> matcher;

  ExpectToBeIterable(IterableMatcher<T> matcher) {
    this.matcher = matcher;
  }

  @Override
  public void toBeEmpty() {
    if (matcher.isNotEmpty()) {
      throw new IllegalArgumentException(String.format("Expected iterable to be empty, but found <%s>.", matcher.getIterable()));
    }
  }

  @Override
  public void toContain(T expected) {
    if (matcher.containsNot(expected)) {
      throw new IllegalArgumentException(String.format("Item <%s> was not found.", expected));
    }
  }

  @Override
  public void toHaveSize(int expected) {
    if (matcher.hasNotSize(expected)) {
      throw new IllegalArgumentException(String.format("Expected iterable to have size: <%s>, but actual size was <%s>.", expected, matcher.getSizeOfIterable()));
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
    public void toHaveSize(int expected) {
      if (matcher.hasSize(expected)) {
        throw new IllegalArgumentException(String.format("Expected iterable not to have size: <%s>, but actual size was <%s>.", expected, expected));
      }
    }

    @Override
    public ToBeCollection<T> not() {
      return new ExpectToBeIterable<>(matcher);
    }
  }
}
