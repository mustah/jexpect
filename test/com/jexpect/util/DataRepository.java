package com.jexpect.util;

import java.util.Collections;
import java.util.List;

/**
 * <br> User: must <br> Date: 10/02/14
 */
public final class DataRepository {

  public static final Iterable<Integer> NULL_ITERABLE = null;
  public static final Iterable<Integer> EMPTY_ITERABLE = Collections.emptyList();
  public static final Iterable<Integer> NON_EMPTY_ITERABLE = Lists.newArrayList(3, 10, 12);

  public static final String NULL_STRING = null;
  public static final String EMPTY_STRING = "";

  public static final List<Integer> NULL_COLLECTION = null;
  public static final List<Integer> NON_EMPTY_COLLECTION = Lists.newArrayList(3, 5, 10);

  private DataRepository() {
  }
}
