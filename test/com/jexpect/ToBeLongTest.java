package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeLongTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect((long) 10).toBe(10L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect((long) 10).toBe(9L);
  }

  @Test
  public void To_Be_Less_Than() throws Exception {
    expect((long) 1).toBeLessThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect((long) 11).toBeLessThan(9L);
  }

  @Test
  public void To_Be_Greater_Than() throws Exception {
    expect((long) 10).toBeGreaterThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect((long) 1).toBeGreaterThan(9L);
  }
}
