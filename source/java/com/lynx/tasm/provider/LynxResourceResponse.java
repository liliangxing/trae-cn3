package com.lynx.tasm.provider;

/* loaded from: classes7.dex */
public class LynxResourceResponse<T> {
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;
    private int mCode;
    private T mData;
    private Throwable mError;

    public Throwable getError() {
        return this.mError;
    }

    private LynxResourceResponse(int i, Throwable th) {
        this.mCode = i;
        this.mError = th;
    }

    private LynxResourceResponse(T t) {
        this.mData = t;
    }

    public static LynxResourceResponse failed(int i, Throwable th) {
        return new LynxResourceResponse(i, th);
    }

    public static <T> LynxResourceResponse<T> success(T t) {
        LynxResourceResponse<T> lynxResourceResponse = new LynxResourceResponse<>(t);
        ((LynxResourceResponse) lynxResourceResponse).mCode = 0;
        return lynxResourceResponse;
    }

    public T getData() {
        return this.mData;
    }

    public boolean success() {
        return this.mData != null;
    }

    public int getCode() {
        return this.mCode;
    }
}
