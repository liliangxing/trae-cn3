package com.bytedance.sdk.account.save.entity;

/* loaded from: classes5.dex */
public class LoginType {
    public static final int SERVER_TYPE_AUTH = 2;
    public static final int SERVER_TYPE_EMAIL = 4;
    public static final int SERVER_TYPE_MOBILE = 1;
    public static final int SERVER_TYPE_PASSWORD = 3;
    public static final int TYPE_AUTH = 6;

    @Deprecated
    public static final int TYPE_LATEST_ONE_KEY = 7;
    public static final int TYPE_MAIL = 4;
    public static final int TYPE_PHONE_CODE = 2;
    public static final int TYPE_PHONE_ONE_KEY = 1;
    public static final int TYPE_PHONE_PASSWORD = 3;
    public static final int TYPE_USERNAME_PASSWORD = 5;

    public static boolean isInLoginType(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7;
    }

    public static int serverType(int i) {
        int i2 = 1;
        if (i != 1 && i != 2) {
            i2 = 3;
            if (i != 3 && i != 5) {
                return i == 6 ? 2 : 4;
            }
        }
        return i2;
    }
}
