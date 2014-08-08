package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_STRING;
import static com.jexpect.util.DataRepository.NULL_STRING;

public class ToBeStringNotTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(NULL_STRING).not().toBe("a");
    expect("s").not().toBeEmpty();
    expect("a").not().toBe("b");
    expect("a").not().toBe(null);
    expect("foo").not().not().toBe("foo");
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Empty_Not_To_Be_Empty_Should_Fail() throws Exception {
    expect(EMPTY_STRING).not().toBeEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Actual_To_Not_Be_As_Expected_Should_Fail_When_They_Are_Same() throws Exception {
    expect("a").not().toBe("a");
  }
}
