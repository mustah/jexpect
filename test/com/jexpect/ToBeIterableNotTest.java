package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NON_EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NULL_ITERABLE;

public class ToBeIterableNotTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() {
    expect(NON_EMPTY_ITERABLE).not().toBeEmpty();
    expect(NON_EMPTY_ITERABLE).not().not().toContain(12);
    expect(EMPTY_ITERABLE).not().not().toBeEmpty();
    expect(NULL_ITERABLE).not().not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Empty_Iterable_Is_Expected_Not_To_Be_Empty_Should_Fail() {
    expect(NULL_ITERABLE).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Empty_Iterable_Is_Expected_No_To_Be_Empty_Should_Fail() {
    expect(EMPTY_ITERABLE).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Non_Empty_Iterable_Not_Not_To_Be_Empty_Should_Fail() {
    expect(NON_EMPTY_ITERABLE).not().not().toBeEmpty();
  }
}
