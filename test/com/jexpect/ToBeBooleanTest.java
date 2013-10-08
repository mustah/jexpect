package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessageWhenFailed;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeBooleanTest {

  @Test
  public void Expect_True_To_Be_Actual() throws Exception {
    expect(true).toBe(true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_True_To_Be_Actual_Fail() throws Exception {
    expect(true).toBe(false);
  }

  @Test(expected = NullPointerException.class)
  public void Expect_True_To_Be_Null_Should_Fail() throws Exception {
    expect(true).toBe(null);
  }

  @Test
  public void Expect_True_To_Be_True() throws Exception {
    expect(true).toBeTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_False_To_Be_True() throws Exception {
    expect(false).toBeTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_True_To_Be_False_Should_Fail() throws Exception {
    expect(true).toBeFalse();
  }

  @Test
  public void Expect_False_To_Be_False() throws Exception {
    expect(false).toBeFalse();
  }

  @Test
  public void True_Not_To_Be_False() throws Exception {
    expect(true).not().toBeFalse();
  }

  @Test
  public void False_Not_To_Be_True() throws Exception {
    expect(false).not().toBeTrue();
  }

  @Test
  public void Expect_False_Not_To_Be_True() throws Exception {
    expect(false).not().toBe(true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_False_Not_To_Be_False_Should_Fail() throws Exception {
    expect(false).not().toBe(false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void True_Not_To_Be_True_Should_Fail() throws Exception {
    expect(true).not().toBeTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void False_Not_To_Be_False_Should_Fail() throws Exception {
    expect(false).not().toBeFalse();
  }

  @Test(expected = NullPointerException.class)
  public void True_Not_To_Be_Null_Should_Fail() throws Exception {
    expect(true).not().toBe(null);
  }

  @Test
  public void When_Expected_False_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be false, but found: true",
                 getMessageWhenFailed(new Command() {
                   @Override
                   public void execute() {
                     expect(true).toBeFalse();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_True_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be true, but found: false",
                 getMessageWhenFailed(new Command() {
                   @Override
                   public void execute() {
                     expect(false).toBeTrue();
                   }
                 }));
  }

  @Test
  public void When_Expected_Actual_To_Be_Same_As_Expected_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be true, but found: false",
                 getMessageWhenFailed(new Command() {
                   @Override
                   public void execute() {
                     expect(false).toBe(true);
                   }
                 }));

    assertEquals("Expected to be false, but found: true",
                 getMessageWhenFailed(new Command() {
                   @Override
                   public void execute() {
                     expect(true).toBe(false);
                   }
                 }));
  }
}
