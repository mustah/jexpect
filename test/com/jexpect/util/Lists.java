package com.jexpect.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <br> User: must <br> Date: 27/01/14
 */
public final class Lists {

  private Lists() {
  }

  public static <E> List<E> newArrayList(E... elements) {
    List<E> list = new ArrayList<>();
    if (elements != null) {
      Collections.addAll(list, elements);
    }
    return list;
  }
}
