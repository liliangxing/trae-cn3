package com.bytedance.router.listener.error;

import com.bytedance.router.RouteIntent;

/* loaded from: classes4.dex */
public interface ErrorListener {
    void onError(ErrorType errorType, RouteIntent routeIntent, Exception exc);
}
