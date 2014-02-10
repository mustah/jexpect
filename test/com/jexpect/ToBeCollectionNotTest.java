package com.jexpect;

import java.util.Collections;

import org.junit.Test;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.DataRepository.NON_EMPTY_COLLECTION;
import static com.jexpect.util.DataRepository.NULL_COLLECTION;
import static org.junit.Assert.assertNotNull;

public class ToBeCollectionNotTest {

  @Test
  public void Given_Non_Empty_Collection_When_Expect_Not_To_Be_Empty_Should_Pass() throws Exception {
    expect(NON_EMPTY_COLLECTION).not().toBeEmpty();
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
  public void Given_Any_Collection_When_Consecutive_Expect_Not_Not_Functions_Are_Called_Then_Result_Should_Not_Be_Null() throws Exception {
    assertNotNull(expect(NULL_COLLECTION).not().not());
  }
}
