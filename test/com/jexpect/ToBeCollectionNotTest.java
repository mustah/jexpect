package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NULL_COLLECTION;
import static org.junit.Assert.assertNotNull;

public class ToBeCollectionNotTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(NON_EMPTY_COLLECTION).not().toBeEmpty();
    expect(NULL_COLLECTION).not().toContain(10);
    expect(NULL_COLLECTION).not().toContain(null);
    expect(Collections.<Integer>emptyList()).not().toContain(10);
    assertNotNull(expect(NULL_COLLECTION).not().not());
  }
}
