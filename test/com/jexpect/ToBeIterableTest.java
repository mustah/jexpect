package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NON_EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NULL_ITERABLE;

/**
 * <br> User: must <br> Date: 27/01/14
 */
public class ToBeIterableTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() {
    expect(NULL_ITERABLE).toBeEmpty();
    expect(EMPTY_ITERABLE).toBeEmpty();
    expect(NON_EMPTY_ITERABLE).toContain(3);
    expect(NON_EMPTY_ITERABLE).toContain(12);
    expect(NON_EMPTY_COLLECTION).toHaveSize(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Null() {
    expect(NULL_ITERABLE).toContain(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Be_Empty_Should_Fail_When_Iterable_Is_Containing_Elements() {
    expect(NON_EMPTY_ITERABLE).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Empty() {
    expect(EMPTY_ITERABLE).toContain(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Element_Is_Not_Contained() {
    expect(NON_EMPTY_ITERABLE).toContain(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_To_Have_Size_Should_Fail_When_Size_Is_Not_The_Same() {
    expect(NON_EMPTY_ITERABLE).toHaveSize(11);
  }
}
