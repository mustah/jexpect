package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;
import com.jexpect.ToBeInteger;
import com.jexpect.ToBeString;

public final class ExpectFactory {

    private ExpectFactory() {
    }

    public static ToBeBoolean newToBoolean(boolean actual) {
        return new ExpectToBeBoolean(actual);
    }

    public static ToBeInteger newToInteger(int actual) {
        return new ExpectToBeInteger(actual);
    }

    public static ToBeString newToString(String actual) {
        return new ExpectedToBeString(actual);
    }
}
