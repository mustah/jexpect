package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_STRING;
import static com.jexpect.util.DataRepository.NULL_STRING;
import static org.junit.Assert.assertNotNull;

public class ToBeStringTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(NULL_STRING).toBeNull();
    expect(EMPTY_STRING).toBeEmpty();
    expect(NULL_STRING).not().toBe("a");
    expect("must").toBe("must");
    expect("s").not().toBeEmpty();
    expect("a").not().toBe("b");
    expect("a").not().toBe(null);
  }

  @Test
  public void Given_Any_String_Then_Consecutive_Expect_Not_Not_Functions_Should_Not_Be_Null() throws Exception {
    assertNotNull(expect("foo").not().not());
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
  public void Expect_Empty_Not_To_Be_Empty_Should_Fail() throws Exception {
    expect(EMPTY_STRING).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Actual_To_Not_Be_As_Expected_Should_Fail_When_They_Are_Same() throws Exception {
    expect("a").not().toBe("a");
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Null_To_Be_Null_Should_Fail() throws Exception {
    expect(NULL_STRING).toBe(null);
  }
}
