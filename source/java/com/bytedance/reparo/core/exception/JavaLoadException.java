package com.bytedance.reparo.core.exception;

/* loaded from: classes4.dex */
public class JavaLoadException extends PatchLoadException {
    public JavaLoadException(String str, int i) {
        super(str, i);
    }

    public JavaLoadException(String str, Throwable th, int i) {
        super(str, th, i);
    }
}
