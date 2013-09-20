package com.jexpect;

import org.junit.Test;

import junit.framework.Assert;

import static com.jexpect.Expect.expect;

public class ToBeBooleanTest {

  @Test
  public void Expect_True_To_Be_True() throws Exception {
    try {
      expect(true).toBeTrue();
    } catch (Exception e) {
      Assert.fail();
    }
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
  public void Expect_False_To_Be_False() throws Exception {
    try {
      expect(false).toBeFalse();
    } catch (Exception e) {
      Assert.fail();
    }
  }
}
