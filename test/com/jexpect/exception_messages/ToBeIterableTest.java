package com.jexpect.exception_messages;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NON_EMPTY_ITERABLE;
import static com.jexpect.util.DataRepository.NULL_ITERABLE;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static org.junit.Assert.assertEquals;

public class ToBeIterableTest {

  @Test
  public void When_Non_Empty_Iterable_Is_Expected_ToBeEmpty_Fails_Then_Exception_Should_Have_Message()
    throws Exception {
    assertEquals("Expected iterable to be empty, but found <[3, 10, 12]>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_ITERABLE).toBeEmpty();
      }
    }));
  }

  @Test
  public void When_Null_Iterable_Is_Expected_To_Contain_Item_Fails_Then_Exception_Should_Have_Message()
    throws Exception {
    assertEquals("Item <12> was not found.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_ITERABLE).toContain(12);
      }
    }));
  }

  @Test
  public void When_Empty_Iterable_Is_Expected_To_Contain_Item_Fails_Then_Exception_Should_Have_Message()
    throws Exception {
    assertEquals("Item <1> was not found.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(EMPTY_ITERABLE).toContain(1);
      }
    }));
  }

  @Test
  public void When_Expected_To_Contain_Item_Fails_The_Exception_Should_Have_Message() throws Exception {
    assertEquals("Item <5> was not found.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_ITERABLE).toContain(5);
      }
    }));
  }

  @Test
  public void Given_Null_Iterable_When_Expect_To_Have_Size_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected iterable to have size: <3>, but actual size was <null>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_ITERABLE).toHaveSize(3);
      }
    }));
  }

  @Test
  public void Given_None_Empty_Iterable_When_Expect_To_Have_Size_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected iterable to have size: <1>, but actual size was <3>.", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_ITERABLE).toHaveSize(1);
      }
    }));
  }
}
