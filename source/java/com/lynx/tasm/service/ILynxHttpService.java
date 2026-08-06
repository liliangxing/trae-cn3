package com.lynx.tasm.service;

import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpStreamingDelegate;

/* loaded from: classes7.dex */
public interface ILynxHttpService extends IServiceProvider {
    void request(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback);

    void requestStreaming(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback, HttpStreamingDelegate httpStreamingDelegate);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxHttpService.class;
    }
}
