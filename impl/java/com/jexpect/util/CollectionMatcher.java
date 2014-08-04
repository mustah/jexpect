package com.jexpect.util;

import java.util.Collection;

public class CollectionMatcher<T> {

  private final Collection<T> collection;

  public CollectionMatcher(Collection<T> collection) {
    this.collection = collection;
  }

  public boolean isEmpty() {
    return collection == null || collection.isEmpty();
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public boolean contains(T item) {
    return collection != null && collection.contains(item);
  }

  public boolean containsNot(T item) {
    return !contains(item);
  }
}
