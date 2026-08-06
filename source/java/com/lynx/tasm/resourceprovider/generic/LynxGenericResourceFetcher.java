package com.lynx.tasm.resourceprovider.generic;

import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* loaded from: classes7.dex */
public abstract class LynxGenericResourceFetcher {
    public void cancel(LynxResourceRequest lynxResourceRequest) {
    }

    public abstract void fetchResource(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<byte[]> lynxResourceCallback);

    public abstract void fetchResourcePath(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<String> lynxResourceCallback);

    public void fetchStream(LynxResourceRequest lynxResourceRequest, StreamDelegate streamDelegate) {
    }

    public void fetchBytecode(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<byte[]> lynxResourceCallback) {
        lynxResourceCallback.onResponse(LynxResourceResponse.onFailed(new Throwable("fetchBytecode is not implemented.")));
    }
}
