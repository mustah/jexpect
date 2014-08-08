package com.jexpect.exception_messages;

import java.util.Collections;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NULL_COLLECTION;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;

public class ToBeCollectionTest {
  @Test
  public void Given_Non_Empty_Collection_When_Expect_To_Be_Empty_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection to be empty, but found <[3, 5, 10]>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_COLLECTION).toBeEmpty();
      }
    }));
  }

  @Test
  public void Given_Empty_Collection_When_Expect_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection does not contain item: <5>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(Collections.<Integer>emptyList()).toContain(5);
      }
    }));
  }

  @Test
  public void Given_Null_Collection_When_Expect_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection does not contain item: <5>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_COLLECTION).toContain(5);
      }
    }));
  }
}
