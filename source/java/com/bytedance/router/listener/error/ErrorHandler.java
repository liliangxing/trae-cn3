package com.bytedance.router.listener.error;

import com.bytedance.router.RouteIntent;
import com.bytedance.router.SmartRouter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ErrorHandler {
    public static void noticeError(ErrorType errorType, RouteIntent routeIntent, String str) {
        if (str == null) {
            str = "no message";
        }
        ErrorListener errorListener = SmartRouter.getErrorListener();
        if (errorListener != null) {
            errorListener.onError(errorType, routeIntent, new SmartRouterException(str));
        }
    }

    public static void noticeError(String str) {
        if (str == null) {
            str = "no message";
        }
        ErrorListener errorListener = SmartRouter.getErrorListener();
        if (errorListener != null) {
            errorListener.onError(null, null, new SmartRouterException(str));
        }
    }
}
