package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public interface IMethodInvocationListener {
    public static final int INVALID_CALLBACK_ID = 5;
    public static final int MALFORMED_DATA = 3;
    public static final int NO_SUCH_METHOD = 2;
    public static final int PERMISSION_DENIED = 1;
    public static final int RELEASED = 4;
    public static final int URL_CHANGED = 6;

    void onInvoked(String str, String str2);

    default void onRejected(Js2JavaCall js2JavaCall, int i, Object obj) {
    }

    void onRejected(String str, String str2, int i);

    default void onInvoked(String str, String str2, TimeLineEventSummary timeLineEventSummary) {
        onInvoked(str, str2);
    }

    default void onRejected(String str, String str2, int i, String str3) {
        onRejected(str, str2, i);
    }

    default void onRejected(String str, String str2, int i, String str3, TimeLineEventSummary timeLineEventSummary) {
        onRejected(str, str2, i, str3);
    }
}
