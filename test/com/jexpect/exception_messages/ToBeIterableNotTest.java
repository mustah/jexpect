package com.jexpect.exception_messages;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NON_EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NULL_ITERABLE;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static org.junit.Assert.assertEquals;

public class ToBeIterableNotTest {
  @Test
  public void When_Null_Iterable_Is_Expected_Not_To_Be_Empty_Should_Fail_And_Exception_Should_Have_Error_Message() throws Exception {
    assertEquals("Expected not to be empty, but was actually empty.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_ITERABLE).not().toBeEmpty();
      }
    }));
  }

  @Test
  public void When_Empty_Iterable_Is_Expected_Not_To_Be_Empty_Should_Fail_And_Exception_Should_Have_Error_Message() throws Exception {
    assertEquals("Expected not to be empty, but was actually empty.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(EMPTY_ITERABLE).not().toBeEmpty();
      }
    }));
  }

  @Test
  public void When_Iterable_Is_Expected_Not_To_Contain_Item_Fails_Then_Exception_Should_Have_Error_Message() throws Exception {
    assertEquals("Expected not to contain item <10>, but was contained.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_ITERABLE).not().toContain(10);
      }
    }));

    assertEquals("Expected not to contain item <12>, but was contained.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_ITERABLE).not().toContain(12);
      }
    }));
  }
}
