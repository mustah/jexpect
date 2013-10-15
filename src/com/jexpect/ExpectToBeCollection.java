package com.jexpect;

import java.util.Collection;

public class ExpectToBeCollection<T> implements ToBeCollection<T> {

  private final Collection<T> collection;

  public ExpectToBeCollection(Collection<T> collection) {
    this.collection = collection;
  }

  @Override
  public void toBeEmpty() {
    if (collection != null && !collection.isEmpty()) {
      throw new IllegalArgumentException("Expected collection to be empty");
    }
  }
}
