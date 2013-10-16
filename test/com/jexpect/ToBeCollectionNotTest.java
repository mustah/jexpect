package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessageWhenFailed;
import static com.jexpect.Expect.expect;
import static com.jexpect.ToBeCollectionTest.NON_EMPTY_COLLECTION;
import static com.jexpect.ToBeCollectionTest.NULL_COLLECTION;
import static junit.framework.Assert.assertEquals;

public class ToBeCollectionNotTest {

  @Test
  public void Given_Non_Empty_Collection_When_Expect_Not_To_Be_Empty_Should_Not_Fail() throws Exception {
    expect(NON_EMPTY_COLLECTION).not().toBeEmpty();
  }

  @Test
  public void Given_Empty_Or_Null_Collection_When_Expect_Not_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection not to be empty", getMessageWhenFailed(new Command() {
      @Override
      public void execute() {
        expect(Collections.<Integer>emptyList()).not().toBeEmpty();
      }
    }));

    assertEquals("Expected collection not to be empty", getMessageWhenFailed(new Command() {
      @Override
      public void execute() {
        expect(NULL_COLLECTION).not().toBeEmpty();
      }
    }));
  }
}
