package com.bytedance.android.service.manager.permission.boot;

/* loaded from: classes3.dex */
public class PushPermissionBootShowResult {
    public static final int RESULT_CODE_NOT_SHOW_EXCEPTION = 6;
    public static final int RESULT_CODE_NOT_SHOW_FREQUENCY = 3;
    public static final int RESULT_CODE_NOT_SHOW_HAS_SHOWING = 1;
    public static final int RESULT_CODE_NOT_SHOW_MODEL_NEED_NOT_SHOW = 5;
    public static final int RESULT_CODE_NOT_SHOW_NETWORK_ERR = 4;
    public static final int RESULT_CODE_NOT_SHOW_SYS_NOTIFICATION_ARE_ENABLED = 2;
    public static final int RESULT_CODE_SHOW = 0;
    public int resultCode;
    public String resultMsg;

    public String toString() {
        return "resultCode:" + this.resultCode + " resultMsg:" + this.resultMsg;
    }
}
