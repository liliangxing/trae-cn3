package com.bytedance.router.route;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.router.RoutesConfig;
import com.bytedance.router.util.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RouteFactory {
    public static BaseRoute createRoute(String str, String str2, RoutesConfig routesConfig) {
        Class<?> cls = null;
        if (TextUtils.isEmpty(str)) {
            Logger.m352e("RouteFactory#createRoute url is null!!!");
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical()) {
            Logger.m352e("RouteFactory#createRoute url is not illegal!!!");
            return null;
        }
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            Logger.m352e("RouteFactory#createRoute scheme is null!!!");
            return null;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            Logger.m352e("RouteFactory#createRoute host is null!!!");
            return null;
        }
        if (!isSchemeLegal(scheme, routesConfig)) {
            Logger.m352e(String.format("RouteFactory#createRoute router cannot support this scheme protocol: %s\nRouteConfig:\n%s", str, routesConfig.toString()));
            return null;
        }
        if (host.startsWith("bt.")) {
            Class<? extends BaseRoute> routeClass = routesConfig.getRouteClass(host);
            if (routeClass == null) {
                Logger.m352e("RouteFactory#createRoute there is no route for this host: " + host);
                return null;
            }
            try {
                return routeClass.newInstance();
            } catch (Exception e) {
                Logger.m352e("RouteFactory#createRoute routeClass new instance exception!!!");
                e.printStackTrace();
                return null;
            }
        }
        try {
            cls = Class.forName(str2);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (cls != null) {
            if (Service.class.isAssignableFrom(cls)) {
                return new ServiceRoute();
            }
            if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                return new BroadcastRoute();
            }
        }
        return new ActivityRoute();
    }

    private static boolean isSchemeLegal(String str, RoutesConfig routesConfig) {
        if (str.equals(routesConfig.getScheme())) {
            return true;
        }
        String[] otherSchemes = routesConfig.getOtherSchemes();
        if (otherSchemes != null && otherSchemes.length > 0) {
            for (String str2 : otherSchemes) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
