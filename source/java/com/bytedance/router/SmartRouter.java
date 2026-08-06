package com.bytedance.router;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.router.autowire.AutowiredService;
import com.bytedance.router.autowire.ISerializationService;
import com.bytedance.router.interceptor.IInterceptor;
import com.bytedance.router.listener.error.ErrorListener;
import com.bytedance.router.plugin.SupportPluginCallback;
import com.bytedance.router.util.Logger;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SmartRouter {
    private static ErrorListener errorListener;
    private static IRouterIntentAdapter sRouterIntentAdapter;
    private static ISerializationService serializationService;

    public static void init(Context context) {
        RouteManager.getInstance().init(context.getApplicationContext());
    }

    public static boolean canOpen(String str) {
        return RouteManager.getInstance().canOpen(str);
    }

    public static void setDebug(boolean z) {
        Logger.setDebug(z);
    }

    public static boolean isDebug() {
        return Logger.isDebug();
    }

    public static RoutesConfig configRouter(String str) {
        RoutesConfig routesConfig = new RoutesConfig(str);
        RouteManager.getInstance().setConfig(routesConfig);
        return routesConfig;
    }

    public static Intent smartIntent(Intent intent) {
        return SmartIntent.smartIntent(intent);
    }

    public static boolean isSmartIntent(Intent intent) {
        return SmartIntent.isSmartIntent(intent);
    }

    public static SmartBundle smartBundle(Bundle bundle) {
        return new SmartBundle(bundle);
    }

    public static SmartRoute buildRoute(Context context, String str) {
        return new SmartRoute(context).withUrl(str);
    }

    public static SmartRoute buildRoute(Fragment fragment, String str) {
        return new SmartRoute(fragment.getActivity()).withUrl(str);
    }

    public static void addInterceptor(IInterceptor iInterceptor) {
        RouteManager.getInstance().addInterceptor(iInterceptor);
    }

    @Deprecated
    public static void addRewriteMap(Map<String, String> map) {
        RouteManager.getInstance().setRewriteMap(map);
    }

    public static void putRewriteValue(String str, String str2) {
        RouteManager.getInstance().putRewriteValue(str, str2);
    }

    public static void setSupportPluginCallback(SupportPluginCallback supportPluginCallback) {
        RouteManager.getInstance().setSupportPluginCallback(supportPluginCallback);
    }

    public static void autowire(Object obj) {
        AutowiredService.inst().autowire(obj);
    }

    public static void setSerializationService(ISerializationService iSerializationService) {
        serializationService = iSerializationService;
    }

    public static ISerializationService getSerializationService() {
        return serializationService;
    }

    public static void setRouterIntentAdapter(IRouterIntentAdapter iRouterIntentAdapter) {
        if (iRouterIntentAdapter != null) {
            sRouterIntentAdapter = iRouterIntentAdapter;
        }
    }

    public static IRouterIntentAdapter getRouterIntentAdapter() {
        return sRouterIntentAdapter;
    }

    public static void setOnErrorListener(ErrorListener errorListener2) {
        errorListener = errorListener2;
    }

    public static ErrorListener getErrorListener() {
        return errorListener;
    }
}
