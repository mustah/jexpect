package com.jexpect.exception_messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;

public class ToBeCollectionTest {

  public static final List<Integer> NULL_COLLECTION = null;
  public static final List<Integer> NON_EMPTY_COLLECTION = new ArrayList<Integer>();

  static {
    NON_EMPTY_COLLECTION.add(5);
    NON_EMPTY_COLLECTION.add(10);
  }

  @Test
  public void Given_Non_Empty_Collection_When_Expect_To_Be_Empty_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection to be empty", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NON_EMPTY_COLLECTION).toBeEmpty();
      }
    }));
  }

  @Test
  public void Given_Empty_Collection_When_Expect_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection does not contain item: 5", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(Collections.<Integer>emptyList()).toContain(5);
      }
    }));
  }

  @Test
  public void Given_Null_Collection_When_Expect_To_Contain_Item_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected collection does not contain item: 5", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_COLLECTION).toContain(5);
      }
    }));
  }
}
