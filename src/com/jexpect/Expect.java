package com.jexpect;

public class Expect {

  private final boolean b;

  private Expect(final boolean b) {
    this.b = b;
  }

  public static Expect expect(boolean b) {
    return new Expect(b);
  }

  public void toBeTrue() {
    if (!b) {
      throw new IllegalArgumentException();
    }
  }

  public void toBeFalse() {
    if (b) {
      throw new IllegalArgumentException();
    }
  }
}
