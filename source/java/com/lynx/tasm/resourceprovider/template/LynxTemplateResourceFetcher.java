package com.lynx.tasm.resourceprovider.template;

import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;

/* loaded from: classes7.dex */
public abstract class LynxTemplateResourceFetcher {
    public abstract void fetchSSRData(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<byte[]> lynxResourceCallback);

    public abstract void fetchTemplate(LynxResourceRequest lynxResourceRequest, LynxResourceCallback<TemplateProviderResult> lynxResourceCallback);
}
