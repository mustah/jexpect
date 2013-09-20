package com.jexpect;


import org.junit.Test;

import junit.framework.Assert;

public class ExpectTest {

  @Test
  public void Expect_True_To_Be_True() throws Exception {
    try {
      Expect.expect(true).toBeTrue();
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void Expect_False_To_Be_True() throws Exception {
    try {
      Expect.expect(false).toBeTrue();
      Assert.fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void Expect_True_To_Be_False() throws Exception {
    try {
      Expect.expect(true).toBeFalse();
      Assert.fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void Expect_False_To_Be_False() throws Exception {
    try {
      Expect.expect(false).toBeFalse();
    } catch (Exception e) {
      Assert.fail();
    }
  }
}
