package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import com.jexpect.util.Lists;

import static com.jexpect.Expect.expect;

/**
 * <br> User: must <br> Date: 27/01/14
 */
public class ToBeIterableTest {

  private static final Iterable<Integer> NULL_ITERABLE = null;
  private static final Iterable<Integer> EMPTY_ITERABLE = Collections.emptyList();
  private static final Iterable<Integer> ITERABLE = Lists.newArrayList(3, 10, 12);

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
    expect(ITERABLE).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Null() {
    expect(NULL_ITERABLE).toContain(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_To_Contain_Element_Should_Fail_When_Actual_Iterable_Is_Empty() {
    expect(EMPTY_ITERABLE).toContain(3);
  }
}
