package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeNumberNotTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(8d).not().toBe(9d);
    expect(8d).not().toBe(9d);
    expect(5d).not().toBeLessThan(2d);
    expect(3d).not().toBeLessThan(2d);
    expect(3d).not().toBeLessThan(-2d);
    expect(5d).not().toBeLessThan(5d);
    expect(10d).not().toBeLessThanOrEqual(5d);
    expect(10d).not().toBeLessThanOrEqual(10d);
    expect(10d).not().toBeGreaterThan(50d);
    expect(50d).not().toBeGreaterThan(50d);
    expect(30d).not().toBeGreaterThanOrEqual(50d);
    expect(5d).not().not().toBe(5d);
    expect(5d).not().not().toBeLessThan(10d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Not_To_Be_Same_But_They_Are_To_Fail_Then_Exception_Should_Be_Thrown() throws Exception {
    expect(9d).not().toBe(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Not_Be_Less_Than_To_Fail_Then_Exception_Should_Be_Thrown() throws Exception {
    expect(5d).not().toBeLessThan(10d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Not_To_Be_Less_Than_Or_Equal_To_Fail() throws Exception {
    expect(5d).not().toBeLessThanOrEqual(10d);
  }
}
