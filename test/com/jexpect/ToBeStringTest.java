package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_STRING;
import static com.jexpect.util.DataRepository.NULL_STRING;

public class ToBeStringTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(NULL_STRING).toBeNull();
    expect(EMPTY_STRING).toBeEmpty();
    expect("must").toBe("must");
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_Should_Fail() throws Exception {
    expect("must").toBe("mattias");
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_With_Expected_Null_Should_Fail() throws Exception {
    expect("must").toBe(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_String_With_Actual_Null() throws Exception {
    expect(NULL_STRING).toBe("mattias");
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Empty_String_To_Be_Null_Should_Fail() throws Exception {
    expect(EMPTY_STRING).toBeNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Null_To_Be_Empty_Should_Fail() throws Exception {
    expect(NULL_STRING).toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Nonempty_To_Be_Empty_Should_Fail() throws Exception {
    expect("s").toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Null_To_Be_Null_Should_Fail() throws Exception {
    expect(NULL_STRING).toBe(null);
  }
}
