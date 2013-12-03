package com.jexpect;

import java.util.Collection;

class ExpectToBeCollection<T> implements ToBeCollection<T> {

  private final Collection<T> collection;

  ExpectToBeCollection(Collection<T> collection) {
    this.collection = collection;
  }

  @Override
  public void toBeEmpty() {
    if (collection != null && !collection.isEmpty())
      throw new IllegalArgumentException("Expected collection to be empty");
  }

  @Override
  public void toContain(T item) {
    if (collection == null || !collection.contains(item))
      throw new IllegalArgumentException("Expected collection does not contain item: " + item);
  }

  @Override
  public ToBeCollection<T> not() {
    return new ExpectToBeCollectionNot<T>(collection);
  }

  private static class ExpectToBeCollectionNot<T> implements ToBeCollection<T> {

    private final Collection<T> collection;

    public ExpectToBeCollectionNot(Collection<T> collection) {
      this.collection = collection;
    }

    @Override
    public void toBeEmpty() {
      if (collection == null || collection.isEmpty())
        throw new IllegalArgumentException("Expected collection not to be empty");
    }

    @Override
    public void toContain(T item) {
      if (collection != null && collection.contains(item))
        throw new IllegalArgumentException("Expected collection not to contain item: " + item);
    }

    @Override
    public ToBeCollection<T> not() {
      return new ExpectToBeCollection<T>(collection);
    }
  }
}
