package com.ttnet.org.chromium.base.library_loader;

/* loaded from: classes7.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int i) {
        super("errorCode=" + i);
    }

    public ProcessInitException(int i, Throwable th) {
        super("errorCode=" + i, th);
    }
}
