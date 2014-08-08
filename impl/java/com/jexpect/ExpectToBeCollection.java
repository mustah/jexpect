package com.jexpect;

class ExpectToBeCollection<T> implements ToBeCollection<T> {

  private final CollectionMatcher<T> matcher;

  ExpectToBeCollection(CollectionMatcher<T> matcher) {
    this.matcher = matcher;
  }

  @Override
  public void toBeEmpty() {
    if (matcher.isNotEmpty()) {
      throw new IllegalArgumentException(String.format("Expected collection to be empty, but found <%s>.", matcher.getCollection()));
    }
  }

  @Override
  public void toContain(T expected) {
    if (matcher.containsNot(expected)) {
      throw new IllegalArgumentException(String.format("Expected collection does not contain item: <%s>.", expected));
    }
  }

  @Override
  public ToBeCollection<T> not() {
    return new ExpectToBeCollectionNot<>(matcher);
  }

  private static class ExpectToBeCollectionNot<T> implements ToBeCollection<T> {

    private final CollectionMatcher<T> matcher;

    ExpectToBeCollectionNot(CollectionMatcher<T> matcher) {
      this.matcher = matcher;
    }

    @Override
    public void toBeEmpty() {
      if (matcher.isEmpty()) {
        throw new IllegalArgumentException(String.format("Expected collection not to be empty, but found <%s>.", matcher.getCollection()));
      }
    }

    @Override
    public void toContain(T expected) {
      if (matcher.contains(expected)) {
        throw new IllegalArgumentException(String.format("Expected collection not to contain item <%s>, but was contained.", expected));
      }
    }

    @Override
    public ToBeCollection<T> not() {
      return new ExpectToBeCollection<>(matcher);
    }
  }
}
