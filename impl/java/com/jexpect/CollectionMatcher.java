package com.jexpect;

import java.util.Collection;

class CollectionMatcher<T> {

  private final Collection<T> collection;

  CollectionMatcher(Collection<T> collection) {
    this.collection = collection;
  }

  boolean isEmpty() {
    return collection == null || collection.isEmpty();
  }

  boolean isNotEmpty() {
    return !isEmpty();
  }

  boolean contains(T item) {
    return collection != null && collection.contains(item);
  }

  boolean containsNot(T item) {
    return !contains(item);
  }
}
