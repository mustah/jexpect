package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NON_EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NULL_ITERABLE;

/**
 * <br> User: must <br> Date: 27/01/14
 */
public class ToBeIterableTest {

  @Test
  public void Expected_To_Be_Empty_Should_Pass_When_Actual_Iterable_Is_Null() {
    expect(NULL_ITERABLE).toBeEmpty();
  }

  @Test
  public void Expected_To_Be_Empty_Should_Pass_When_Actual_Iterable_Is_Empty() {
    expect(EMPTY_ITERABLE).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Be_Empty_Should_Fail_When_Iterable_Is_Containing_Elements() {
    expect(NON_EMPTY_ITERABLE).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Null() {
    expect(NULL_ITERABLE).toContain(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Empty() {
    expect(EMPTY_ITERABLE).toContain(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Element_Is_Not_Contained() {
    expect(NON_EMPTY_ITERABLE).toContain(1);
  }

  @Test
  public void Expected_To_Contain_Element_Should_Not_Fail_When_Actual_Element_Is_Contained() {
    expect(NON_EMPTY_ITERABLE).toContain(3);
  }

  @Test
  public void Expected_To_Contain_Element_Should_Not_Fail_When_Actual_Element_Is_Contained_At_The_Tail_Of_Iterable() {
    expect(NON_EMPTY_ITERABLE).toContain(12);
  }

  @Test
  public void Non_Empty_Iterable_Is_Expected_Not_To_Be_Empty_Should_Pass() {
    expect(NON_EMPTY_ITERABLE).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Empty_Iterable_Is_Expected_Not_To_Be_Empty_Should_Fail() {
    expect(NULL_ITERABLE).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Empty_Iterable_Is_Expected_No_To_Be_Empty_Should_Fail() {
    expect(EMPTY_ITERABLE).not().toBeEmpty();
  }
}
