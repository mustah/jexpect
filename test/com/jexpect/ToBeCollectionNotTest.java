package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.ToBeCollectionTest.NON_EMPTY_COLLECTION;
import static com.jexpect.ToBeCollectionTest.NULL_COLLECTION;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ToBeCollectionNotTest {

  @Test
  public void Given_Non_Empty_Collection_When_Expect_Not_To_Be_Empty_Should_Pass() throws Exception {
    expect(NON_EMPTY_COLLECTION).not().toBeEmpty();
  }

  @Test
  public void Given_Empty_Or_Null_Collection_When_Expect_Not_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection not to be empty", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(Collections.<Integer>emptyList()).not().toBeEmpty();
      }
    }));

    assertEquals("Expected collection not to be empty", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_COLLECTION).not().toBeEmpty();
      }
    }));
  }

  @Test
  public void Given_Null_Collection_When_Expect_Not_To_Contain_Item_Should_Pass() throws Exception {
    expect(NULL_COLLECTION).not().toContain(10);
  }

  @Test
  public void Given_Empty_Collection_When_Expect_Not_To_Contain_Item_Should_Pass() throws Exception {
    expect(Collections.<Integer>emptyList()).not().toContain(10);
  }

  @Test
  public void Given_Null_Collection_When_Expect_Not_To_Contain_Null_Item_Should_Pass() throws Exception {
    expect(NULL_COLLECTION).not().toContain(null);
  }

  @Test
  public void Given_Collection_When_Expect_To_Not_Contain_Item_Does_Contain_It_Should_Fail() throws Exception {
    assertEquals("Expected collection not to contain item: 10", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_COLLECTION).not().toContain(10);
      }
    }));
  }

  @Test
  public void Given_Any_Collection_When_Consecutive_Expect_Not_Not_Functions_Are_Called_Then_Result_Should_Not_Be_Null() throws Exception {
    assertNotNull(expect(NULL_COLLECTION).not().not());
  }
}
