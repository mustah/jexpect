package com.jexpect;

public interface ToBeString {

    void toBe(String expected);

    void toBeNull();

    void toBeEmpty();

    void toBeNotEmpty();
}
