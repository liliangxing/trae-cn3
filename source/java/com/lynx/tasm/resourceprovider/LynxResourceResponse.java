package com.lynx.tasm.resourceprovider;

/* loaded from: classes7.dex */
public final class LynxResourceResponse<T> {
    private T data;
    private Throwable error;
    private ResponseState state;

    /* loaded from: classes7.dex */
    public enum ResponseState {
        FAILED,
        SUCCESS
    }

    private LynxResourceResponse() {
    }

    public ResponseState getState() {
        return this.state;
    }

    public Throwable getError() {
        return this.error;
    }

    public T getData() {
        return this.data;
    }

    public static LynxResourceResponse onFailed(Throwable th) {
        LynxResourceResponse lynxResourceResponse = new LynxResourceResponse();
        lynxResourceResponse.state = ResponseState.FAILED;
        lynxResourceResponse.error = th;
        return lynxResourceResponse;
    }

    public static <T> LynxResourceResponse<T> onSuccess(T t) {
        LynxResourceResponse<T> lynxResourceResponse = new LynxResourceResponse<>();
        ((LynxResourceResponse) lynxResourceResponse).state = ResponseState.SUCCESS;
        ((LynxResourceResponse) lynxResourceResponse).data = t;
        return lynxResourceResponse;
    }
}
