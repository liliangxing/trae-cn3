package com.bytedance.reparo.core.exception;

/* loaded from: classes4.dex */
public class PatchInstallException extends PatchException {
    public static final int ERROR_TYPE_SIGNATURE_VERIFY_FAILED = 1;
    public static final int ERROR_TYPE_UNKNOWN = 0;

    public PatchInstallException(String str) {
        this(str, 0);
    }

    public PatchInstallException(String str, int i) {
        super(str, i);
    }

    public PatchInstallException(String str, Throwable th) {
        this(str, th, 0);
    }

    public PatchInstallException(String str, Throwable th, int i) {
        super(str, th, i);
    }
}
