package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeStringTest {

  private static final String NULL_STRING = null;
  private static final String EMPTY_STRING = "";

  @Test
  public void To_Be_String() throws Exception {
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

  @Test
  public void To_Be_Null() throws Exception {
    expect(NULL_STRING).toBeNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Empty_String_To_Be_Null_Should_Fail() throws Exception {
    expect(EMPTY_STRING).toBeNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Null_To_Be_Empty_Should_Fail() throws Exception {
    expect(NULL_STRING).toBeEmpty();
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

  @Test
  public void When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be empty, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBeEmpty();
                   }
                 }));
  }

  @Test
  public void Given_Null_When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    final String nullString = null;

    assertEquals("Expected to be empty, but found: null",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(nullString).toBeEmpty();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be null, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBeNull();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be bar, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBe("bar");
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_To_Be_As_Actual_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be foo, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").not().toBe("foo");
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be empty, but found: ",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("").not().toBeEmpty();
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be null, but found: null",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(null).not().toBeNull();
                   }
                 }));
  }
}
