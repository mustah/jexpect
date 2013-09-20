package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeBooleanTest {

  @Test
  public void Expect_True_To_Be_True_Should_Not_Throw() throws Exception {
    expect(true).toBeTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_False_To_Be_True() throws Exception {
    expect(false).toBeTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_True_To_Be_False() throws Exception {
    expect(true).toBeFalse();
  }

  @Test
  public void Expect_False_To_Be_False_Should_Not_Throw() throws Exception {
    expect(false).toBeFalse();
  }
}
