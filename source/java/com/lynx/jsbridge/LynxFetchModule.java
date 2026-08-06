package com.lynx.jsbridge;

import android.content.Context;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.jsbridge.network.HttpStreamingDelegate;
import com.lynx.jsbridge.network.LynxFetchModuleEventSender;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.LynxHttpRequestCallback;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxFetchModule extends LynxModule {
    public static final String NAME = "LynxFetchModule";
    private static final AtomicLong streamingCounter = new AtomicLong();
    private static final String streamingEventNamePrefix = "LynxFetchModuleStreamingEvent";
    private final LynxFetchModuleEventSender mSender;

    public LynxFetchModule(Context context, Object obj) {
        super(context);
        this.mSender = (LynxFetchModuleEventSender) obj;
    }

    private void request(ILynxHttpService iLynxHttpService, HttpRequest httpRequest, final String str, final Callback callback) {
        iLynxHttpService.request(httpRequest, new LynxHttpRequestCallback() { // from class: com.lynx.jsbridge.LynxFetchModule.1
            public void invoke(HttpResponse httpResponse) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put("url", str);
                javaOnlyMap.put("body", httpResponse.getHttpBody() != null ? httpResponse.getHttpBody() : new byte[0]);
                javaOnlyMap.put("headers", httpResponse.getHttpHeaders() != null ? httpResponse.getHttpHeaders() : "");
                javaOnlyMap.put("status", Integer.valueOf(httpResponse.getStatusCode()));
                javaOnlyMap.put("statusText", httpResponse.getStatusText() != null ? httpResponse.getStatusText() : "");
                javaOnlyMap.put("lynxExtension", httpResponse.getCustomInfo() != null ? httpResponse.getCustomInfo() : new JavaOnlyMap());
                callback.invoke(javaOnlyMap);
            }
        });
    }

    private void requestStreaming(ILynxHttpService iLynxHttpService, HttpRequest httpRequest, final String str, final Callback callback) {
        final String str2 = streamingEventNamePrefix + streamingCounter.getAndIncrement();
        iLynxHttpService.requestStreaming(httpRequest, new LynxHttpRequestCallback() { // from class: com.lynx.jsbridge.LynxFetchModule.2
            public void invoke(HttpResponse httpResponse) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put("url", str);
                javaOnlyMap.put("body", new byte[0]);
                javaOnlyMap.put("headers", httpResponse.getHttpHeaders() != null ? httpResponse.getHttpHeaders() : "");
                javaOnlyMap.put("status", Integer.valueOf(httpResponse.getStatusCode()));
                javaOnlyMap.put("statusText", httpResponse.getStatusText() != null ? httpResponse.getStatusText() : "");
                JavaOnlyMap customInfo = httpResponse.getCustomInfo() != null ? httpResponse.getCustomInfo() : new JavaOnlyMap();
                customInfo.putString("streamingId", str2);
                javaOnlyMap.put("lynxExtension", customInfo);
                callback.invoke(javaOnlyMap);
            }
        }, new HttpStreamingDelegate(str2, this.mSender));
    }

    @LynxMethod
    public void fetch(ReadableMap readableMap, Callback callback, Callback callback2) {
        String string = readableMap.getString("url", "");
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setHttpMethod(readableMap.getString(DefaultLogicExecutor.EVENT_METHOD, ""));
        httpRequest.setUrl(string);
        httpRequest.setOriginUrl(readableMap.getString(ClientData.KEY_ORIGIN, ""));
        httpRequest.setHttpHeaders((JavaOnlyMap) readableMap.getMap("headers", new JavaOnlyMap()));
        httpRequest.setHttpBody(readableMap.getByteArray("body", new byte[0]));
        JavaOnlyMap javaOnlyMap = (JavaOnlyMap) readableMap.getMap("lynxExtension", new JavaOnlyMap());
        httpRequest.setCustomConfig(javaOnlyMap);
        boolean z = javaOnlyMap.getBoolean("useStreaming", false);
        ILynxHttpService iLynxHttpService = (ILynxHttpService) LynxServiceCenter.inst().getService(ILynxHttpService.class);
        if (iLynxHttpService == null) {
            JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
            javaOnlyMap2.put("message", "Lynx Http Service not registered");
            callback2.invoke(javaOnlyMap2);
        } else if (!z) {
            request(iLynxHttpService, httpRequest, string, callback);
        } else {
            requestStreaming(iLynxHttpService, httpRequest, string, callback);
        }
    }
}
