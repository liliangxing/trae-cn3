package com.lynx.jsbridge.network;

import com.lynx.react.bridge.Callback;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.LynxHttpRequestCallback;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxHttpRunner {
    public static final int SDK_ERROR_STATUS_CODE = 499;

    public static boolean isHttpServiceRegistered() {
        return LynxServiceCenter.inst().getService(ILynxHttpService.class) != null;
    }

    public static void request(HttpRequest httpRequest, final Callback callback) {
        ILynxHttpService service = LynxServiceCenter.inst().getService(ILynxHttpService.class);
        if (service == null) {
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setStatusCode(SDK_ERROR_STATUS_CODE);
            httpResponse.setStatusText("Lynx Http Service not registered");
            callback.invoke(httpResponse);
            return;
        }
        service.request(httpRequest, new LynxHttpRequestCallback() { // from class: com.lynx.jsbridge.network.LynxHttpRunner.1
            public void invoke(HttpResponse httpResponse2) {
                Callback.this.invoke(httpResponse2);
            }
        });
    }
}
