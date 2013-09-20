package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeFloatTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect(10.0f).toBe(10.0f);
  }

  @Test
  public void testToBeLessThan() throws Exception {

  }

  @Test
  public void testToBeGreaterThan() throws Exception {

  }
}
