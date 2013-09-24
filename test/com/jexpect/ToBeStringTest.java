package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeStringTest {

  private static final String NULL_STRING = null;
  private static final String EMPTY_STRING = "";

  @Test
  public void To_Be_String() throws Exception {
    expect("must").toBe("must");
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_Fails() throws Exception {
    expect("must").toBe("mattias");
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_With_Expected_Null() throws Exception {
    expect("must").toBe(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_With_Actual_Null() throws Exception {
    expect(NULL_STRING).toBe("mattias");
  }

  @Test
  public void To_Be_Null() throws Exception {
    expect(NULL_STRING).toBeNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Null_Fail() throws Exception {
    expect(EMPTY_STRING).toBeNull();
  }

  @Test
  public void Expect_Empty_To_Be_Empty() throws Exception {
    expect(EMPTY_STRING).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Nonempty_To_Be_Empty_Should_Fail() throws Exception {
    expect("s").toBeEmpty();
  }

  @Test
  public void Expect_Not_To_Be_Empty() throws Exception {
    expect("s").not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Empty_Not_To_Be_Empty_Should_Fail() throws Exception {
    expect(EMPTY_STRING).not().toBeEmpty();
  }

  @Test
  public void Expect_Actual_To_Not_Be_As_Expected() throws Exception {
    expect("a").not().toBe("b");
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Actual_To_Not_Be_As_Expected_Should_Fail_When_They_Are_Same() throws Exception {
    expect("a").not().toBe("a");
  }

  @Test
  public void Expect_Actual_As_Null_To_Not_Be_As_Expected() throws Exception {
    expect(null).not().toBe("a");
  }

  @Test
  public void Expect_Actual_To_Not_Be_Null() throws Exception {
    expect("a").not().toBe(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Null_To_Be_Null_Should_Fail() throws Exception {
    expect(NULL_STRING).toBe(null);
  }
}
