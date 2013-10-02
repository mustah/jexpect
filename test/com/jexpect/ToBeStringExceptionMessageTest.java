package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class ToBeStringExceptionMessageTest {

  @Test
  public void When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    try {
      expect("foo").toBeEmpty();
      fail();
    } catch (Exception e) {
      assertEquals("Expected to be empty, but found: foo", e.getMessage());
    }

    try {
      expect(null).toBeEmpty();
      fail();
    } catch (Exception e) {
      assertEquals("Expected to be empty, but found: null", e.getMessage());
    }
  }
}
