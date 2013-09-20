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

  @Test
  public void Expect_False_To_Be_True() throws Exception {
    try {
      expect(false).toBeTrue();
      Assert.fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void Expect_True_To_Be_False() throws Exception {
    try {
      expect(true).toBeFalse();
      Assert.fail();
    } catch (Exception e) {
    }
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
