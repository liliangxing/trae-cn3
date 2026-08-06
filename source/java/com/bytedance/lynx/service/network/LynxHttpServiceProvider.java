package com.bytedance.lynx.service.network;

import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpStreamingDelegate;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.LynxHttpRequestCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxHttpServiceProvider implements ILynxHttpService {
    public void request(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback) {
        LynxHttpService.getInstance().request(httpRequest, lynxHttpRequestCallback);
    }

    public void requestStreaming(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback, HttpStreamingDelegate httpStreamingDelegate) {
        LynxHttpService.getInstance().requestStreaming(httpRequest, lynxHttpRequestCallback, httpStreamingDelegate);
    }
}
