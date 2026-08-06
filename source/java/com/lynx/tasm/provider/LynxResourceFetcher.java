package com.lynx.tasm.provider;

/* loaded from: classes7.dex */
public abstract class LynxResourceFetcher<T> {
    private static final String TAG = "LynxResourceFetcher";

    public abstract ILynxResourceRequestOperation request(LynxResourceRequest<T> lynxResourceRequest, LynxResourceCallback<ILynxResourceResponseDataInfo> lynxResourceCallback);

    public abstract LynxResourceResponse<ILynxResourceResponseDataInfo> requestSync(LynxResourceRequest<T> lynxResourceRequest);
}
