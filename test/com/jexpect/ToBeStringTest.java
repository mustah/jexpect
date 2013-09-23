package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeStringTest {

  public static final String NULL_STRING = null;
  public static final String EMPTY_STRING = "";

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
  public void To_Be_Empty() throws Exception {
    expect(EMPTY_STRING).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Empty_Fail() throws Exception {
    expect("s").toBeEmpty();
  }

  @Test
  public void To_Be_Not_Empty() throws Exception {
    expect("s").toBeNotEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Not_Empty_Fail() throws Exception {
    expect(EMPTY_STRING).toBeNotEmpty();
  }
}
