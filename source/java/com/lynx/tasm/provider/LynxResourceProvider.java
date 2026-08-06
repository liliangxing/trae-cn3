package com.lynx.tasm.provider;

import com.lynx.tasm.behavior.LynxContext;

/* loaded from: classes7.dex */
public abstract class LynxResourceProvider<T, C> {
    public void cancel(LynxResourceRequest<T> lynxResourceRequest) {
    }

    public void request(LynxResourceRequest<T> lynxResourceRequest, LynxResourceCallback<C> lynxResourceCallback) {
    }

    public void request(LynxResourceRequest<T> lynxResourceRequest, LynxResourceCallback<C> lynxResourceCallback, LynxContext lynxContext) {
        request(lynxResourceRequest, lynxResourceCallback);
    }
}
