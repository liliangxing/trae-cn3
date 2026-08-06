package com.bytedance.sdk.account.api;

/* loaded from: classes5.dex */
public interface ISendCodeScenario {
    public static final int AUTH = 26;

    @Deprecated
    public static final int BIND = 10;
    public static final int BIND_CODE = 8;
    public static final int BIND_MOBILE_FOR_CONNECT = 32;

    @Deprecated
    public static final int CHANGE = 15;
    public static final int CHANGE_CODE = 13;
    public static final int CHANGE_MOBILE_CODE_PREVIOUS_PHONE = 28;
    public static final int CHANGE_MOBILE_NUM_CODE = 20;
    public static final int CHANGE_MOBILE_VERIFY = 28;
    public static final int CHANGE_MOBILE_WITHOUT_MOBILE = 33;
    public static final int GET_OR_REGISTER_BY_MOBILE = 31;
    public static final int IDENTITY_VERIFICATION = 22;
    public static final int LOCK_ACCOUNT = 29;

    @Deprecated
    public static final int LOGIN = 7;

    @Deprecated
    public static final int LOGIN_PASSWORD_NOTIFY = 19;
    public static final int OPEN_AUTH = 27;
    public static final int OPEN_AUTH_FORCE_BIND = 36;
    public static final int QUICK_LOGIN = 24;

    @Deprecated
    public static final int REGISTER = 3;
    public static final int REGISTER_CODE = 1;
    public static final int RESET = 6;

    @Deprecated
    public static final int RESET_CODE = 4;

    @Deprecated
    public static final int UNBIND = 11;
    public static final int UNLOCK_ACCOUNT = 30;
    public static final int VERIFY_MOBILE_ONLY = 34;
}
