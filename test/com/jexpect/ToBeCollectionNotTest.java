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

  @Test(expected = IllegalArgumentException.class)
  public void Given_Nonempty_Collection_When_Expect_To_Contain_Item_Should_Fail() {
    expect(NON_EMPTY_COLLECTION).toContain(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Given_Empty_Collection_When_Expect_To_Contain_Item_Then_It_Should_Fail() {
    expect(Collections.emptyList()).toContain(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Given_Nonempty_Collection_When_Expect_To_Be_Empty_Then_It_Should_Fail() {
    expect(NON_EMPTY_COLLECTION).toBeEmpty();
  }
}
