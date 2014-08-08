package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NULL_COLLECTION;

public class ToBeCollectionTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(Collections.<Integer>emptyList()).toBeEmpty();
    expect(NULL_COLLECTION).toBeEmpty();
    expect(NON_EMPTY_COLLECTION).toContain(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Given_Empty_Collection_When_Expect_To_Contain_Item_Should_Fail() throws Exception {
    expect(Collections.<Integer>emptyList()).toContain(5);
  }
}
