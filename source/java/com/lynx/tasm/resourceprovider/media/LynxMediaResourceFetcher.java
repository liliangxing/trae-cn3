package com.lynx.tasm.resourceprovider.media;

import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.io.Closeable;

/* loaded from: classes7.dex */
public abstract class LynxMediaResourceFetcher {
    public void fetchImage(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<Closeable> lynxResourceCallback) {
    }

    public abstract String shouldRedirectUrl(LynxResourceRequest lynxResourceRequest);

    public OptionalBool isLocalResource(String str) {
        return OptionalBool.UNDEFINED;
    }
}
