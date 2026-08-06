package com.bytedance.router;

import android.text.TextUtils;
import com.bytedance.router.route.BaseRoute;
import com.bytedance.router.route.BroadcastRoute;
import com.bytedance.router.route.ServiceRoute;
import com.bytedance.router.util.Logger;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class RoutesConfig {
    private Set<String> mOtherSchemeSet;
    private String[] mOtherSchemes;
    private Map<String, Class<? extends BaseRoute>> mRouteMap;
    private String mScheme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoutesConfig(String str) {
        this.mRouteMap = null;
        this.mScheme = str;
        HashMap hashMap = new HashMap();
        this.mRouteMap = hashMap;
        hashMap.put(RouterConstant.HOST_SERVICE, ServiceRoute.class);
        this.mRouteMap.put(RouterConstant.HOST_BROADCAST, BroadcastRoute.class);
    }

    public RoutesConfig withOtherSchemes(String[] strArr) {
        this.mOtherSchemes = strArr;
        if (strArr == null || strArr.length == 0) {
            this.mOtherSchemeSet = null;
        } else {
            Set<String> set = this.mOtherSchemeSet;
            if (set != null) {
                set.clear();
            } else {
                this.mOtherSchemeSet = new HashSet();
            }
            this.mOtherSchemeSet.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public RoutesConfig withSupportRoute(String str, Class<? extends BaseRoute> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            Logger.w("RoutesConfig#withHostRoute() host or routeClass is null!!!");
            return this;
        }
        if (this.mRouteMap == null) {
            this.mRouteMap = new HashMap();
        }
        this.mRouteMap.put(str, cls);
        return this;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public String[] getOtherSchemes() {
        return this.mOtherSchemes;
    }

    public boolean supportScheme(String str) {
        if (str == null || str.length() == 0 || str.equals(this.mScheme)) {
            return true;
        }
        Set<String> set = this.mOtherSchemeSet;
        return set != null && set.contains(str);
    }

    public Class<? extends BaseRoute> getRouteClass(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mRouteMap.get(str);
    }

    public String toString() {
        StringBuilder append = new StringBuilder("scheme:").append(this.mScheme).append("\nother schemes: ");
        String[] strArr = this.mOtherSchemes;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                append.append(str).append(',');
            }
            append.append(UpdateDialogNewBase.TYPE);
        }
        Map<String, Class<? extends BaseRoute>> map = this.mRouteMap;
        int size = map != null ? map.size() : 0;
        append.append(String.format("other supported routes: %s routes\n", Integer.valueOf(size)));
        if (size > 0) {
            for (Map.Entry<String, Class<? extends BaseRoute>> entry : this.mRouteMap.entrySet()) {
                append.append("\t").append(entry.getKey()).append(Constants.COLON_SEPARATOR).append(entry.getValue().getName()).append('\n');
            }
        }
        return append.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoutesConfig defaultConfig() {
        return new RoutesConfig(RouterConstant.SCHEME).withOtherSchemes(RouterConstant.DEFAULT_HISTORY_SCHEME).withSupportRoute(RouterConstant.HOST_SERVICE, ServiceRoute.class).withSupportRoute(RouterConstant.HOST_BROADCAST, BroadcastRoute.class);
    }
}
