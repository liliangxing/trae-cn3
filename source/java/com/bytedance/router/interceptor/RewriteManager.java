package com.bytedance.router.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.router.RouteIntent;
import com.bytedance.router.util.Logger;
import com.bytedance.router.util.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RewriteManager implements IInterceptor {
    private Map<String, String> mRewriteMap = null;
    private Object mLockObject = new Object();

    public void setRewriteMap(Map<String, String> map) {
        synchronized (this.mLockObject) {
            if (map == null) {
                this.mRewriteMap = Collections.EMPTY_MAP;
            } else {
                this.mRewriteMap = map;
            }
        }
    }

    public void addRewriteValue(String str, String str2) {
        synchronized (this.mLockObject) {
            if (this.mRewriteMap == null) {
                this.mRewriteMap = new HashMap();
            }
            this.mRewriteMap.put(str, str2);
        }
    }

    @Override // com.bytedance.router.interceptor.IInterceptor
    public boolean onInterceptRoute(Context context, RouteIntent routeIntent) {
        Logger.m350d("RewriteManager#RouteIntent-originUrl: " + routeIntent.getOriginUrl());
        Logger.m350d("RewriteManager#RouteIntent-outputUrl: " + routeIntent.getUrl());
        new RouteIntent.Builder(routeIntent.getUrl()).build();
        return false;
    }

    @Override // com.bytedance.router.interceptor.IInterceptor
    public boolean matchInterceptRules(RouteIntent routeIntent) {
        Map<String, String> map;
        String originUrl = routeIntent.getOriginUrl();
        if (TextUtils.isEmpty(originUrl)) {
            return false;
        }
        String routeUrl = Util.getRouteUrl(originUrl);
        if (!TextUtils.isEmpty(routeUrl) && (map = this.mRewriteMap) != null && map.size() != 0) {
            String str = this.mRewriteMap.get(routeUrl);
            if (!TextUtils.isEmpty(str)) {
                routeIntent.setUrl(str);
                return true;
            }
        }
        return false;
    }

    public String getRewriteUrl(String str) {
        Map<String, String> map = this.mRewriteMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
