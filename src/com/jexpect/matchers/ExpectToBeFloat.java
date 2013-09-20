package com.jexpect.matchers;

import com.jexpect.ToBeFloat;

class ExpectToBeFloat implements ToBeFloat {

  private final float actual;

  ExpectToBeFloat(float actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(float expected) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void toBeLessThan(float expected) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void toBeGreaterThan(float expected) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
