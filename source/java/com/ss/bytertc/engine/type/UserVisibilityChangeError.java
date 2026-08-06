package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum UserVisibilityChangeError {
    OK(0),
    UNKNOWN(1),
    TOO_MANY_VISIBLE_USER(2);

    private int value;

    UserVisibilityChangeError(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static UserVisibilityChangeError fromId(int type) {
        for (UserVisibilityChangeError userVisibilityChangeError : values()) {
            if (userVisibilityChangeError.value() == type) {
                return userVisibilityChangeError;
            }
        }
        return UNKNOWN;
    }
}
