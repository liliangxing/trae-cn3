package com.bytedance.vmsdk.worker;

/* loaded from: classes6.dex */
public interface IWorkerExceptionDelegate {
    void onError(int i, String str);

    /* loaded from: classes6.dex */
    public enum ErrorCode {
        VMSDK_ERROR_CODE_UNKNOW(-1),
        VMSDK_ERROR_CODE_SUCCESS(0),
        VMSDK_ERROR_CODE_JNI(100),
        VMSDK_ERROR_CODE_JS(200),
        VMSDK_ERROR_CODE_SCRIPT_EMPTY(300);

        public int mValue;

        ErrorCode(int i) {
            this.mValue = i;
        }

        public static ErrorCode toErrorCode(int i) {
            for (ErrorCode errorCode : values()) {
                if (i == errorCode.mValue) {
                    return errorCode;
                }
            }
            return VMSDK_ERROR_CODE_UNKNOW;
        }
    }
}
