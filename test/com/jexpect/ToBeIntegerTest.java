package com.jexpect;

import org.junit.Test;

import junit.framework.Assert;

import static com.jexpect.Expect.expect;

/**
 * <br> User: must <br> Date: 2013-09-20
 */
public class ToBeIntegerTest {

  @Test
  public void Expect_Number_To_Be_Less_Than() throws Exception {
    try {
      expect(10).toBeLessThan(11);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void Expect_Number_To_Be_Greater_Than() throws Exception {
    try {
      expect(12).toBeGreaterThan(11);
    } catch (Exception e) {
      Assert.fail();
    }
  }
}
