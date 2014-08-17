package com.jexpect.exception_messages;

import java.util.Collections;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NULL_COLLECTION;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;

public class ToBeCollectionNotTest {

  @Test
  public void Given_Empty_Or_Null_Collection_When_Expect_Not_To_Contain_Item_Should_Fail_And_Have_Error_Message()
    throws Exception {
    assertEquals("Expected collection not to be empty, but found <[]>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(Collections.<Integer>emptyList()).not().toBeEmpty();
      }
    }));

    assertEquals("Expected collection not to be empty, but found <null>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_COLLECTION).not().toBeEmpty();
      }
    }));
  }

  @Test
  public void Given_Collection_When_Expect_To_Not_Contain_Item_Does_Contain_It_Should_Fail() throws Exception {
    assertEquals("Expected collection not to contain item <10>, but was contained.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_COLLECTION).not().toContain(10);
      }
    }));
  }

  @Test
  public void Given_None_Empty_Collection_When_Expect_Not_To_Have_Size_Should_Fail_And_Have_Error_Message()
    throws Exception {
    assertEquals("Expected collection not to have size: <3>, but actual size was <3>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_COLLECTION).not().toHaveSize(3);
      }
    }));
  }
}
