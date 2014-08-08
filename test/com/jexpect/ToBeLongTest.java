package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeLongTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(0L).toBe(0L);
    expect(1L).toBe(1L);
    expect(1L).toBeLessThan(9L);
    expect(5L).toBeGreaterThan(2L);
    expect(3L).toBeLessThanOrEqual(3L);
    expect(3L).toBeLessThanOrEqual(10L);
    expect(3L).toBeGreaterThanOrEqual(3L);
    expect(6L).toBeGreaterThanOrEqual(3L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(1L).toBe(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11L).toBeLessThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1L).toBeGreaterThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Or_Equal_Should_Fail() throws Exception {
    expect(6L).toBeLessThanOrEqual(3L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Or_Equal_Should_Fail() throws Exception {
    expect(1L).toBeGreaterThanOrEqual(3L);
  }
}
