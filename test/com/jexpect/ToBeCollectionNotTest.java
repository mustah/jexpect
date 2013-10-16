package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.ToBeCollectionTest.NON_EMPTY_COLLECTION;
import static com.jexpect.ToBeCollectionTest.NULL_COLLECTION;

public class ToBeCollectionNotTest {

  @Test
  public void Given_Non_Empty_Collection_When_Expect_Not_To_Be_Empty_Should_Not_Fail() throws Exception {
    expect(NON_EMPTY_COLLECTION).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Given_Null_Collection_When_Expect_Not_To_Be_Empty_Should_Fail() throws Exception {
    expect(NULL_COLLECTION).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGivenEmptyCollectionWhenExpectNotToBeEmptyShouldFail() throws Exception {
    expect(Collections.<Integer>emptyList()).not().toBeEmpty();
  }
}
