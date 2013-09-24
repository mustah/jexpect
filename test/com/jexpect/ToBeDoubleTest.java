package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeDoubleTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect(10d).toBe(10d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(10d).toBe(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_When_Actual_Is_Null_Fail() throws Exception {
    expect(10d).toBe(null);
  }

  @Test
  public void To_Be_Less_Than() throws Exception {
    expect(1d).toBeLessThan(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11d).toBeLessThan(9d);
  }

  @Test
  public void To_Be_Greater_Than() throws Exception {
    expect(11d).toBeGreaterThan(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1d).toBeGreaterThan(9d);
  }

  /*@Test
  public void Not_To_Be_Greater_Than() throws Exception {
    expect(0d).not().toBeGreaterThan(10d);
  }
  @Test(expected = IllegalArgumentException.class)
  public void Not_To_Be_Greater_Than_Should_Fail() throws Exception {
    expect(111d).not().toBeGreaterThan(10d);
  }

  @Test
  public void Not_To_Be_Less_Than() throws Exception {
    expect(11d).not().toBeLessThan(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Not_To_Be_Less_Than_Should_Fail() throws Exception {
    expect(1d).not().toBeLessThan(9d);
  }

  @Test
  public void Not_To_Be() throws Exception {
    expect(19d).not().toBe(9d);
  }*/
}
