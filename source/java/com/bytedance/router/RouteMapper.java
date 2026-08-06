package com.bytedance.router;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.router.util.Logger;
import com.bytedance.router.util.Util;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class RouteMapper {
    private static final String MAP_JAVA_FORMAT = "com.bytedance.router.generator.mapping.SmartrouterMapping$$%s";
    private static final String ROUTER_CONFIG = "smartrouter_config";
    private Context mContext;
    private Map<String, String> mRouteMap;
    private Map<String, String> mOriginMap = null;
    private Object mRouteMapLock = new Object();

    public RouteMapper() {
        this.mRouteMap = null;
        this.mRouteMap = new HashMap();
    }

    public void init(Context context) {
        Logger.d("RouteMapper#init RouteMapper");
        this.mContext = context;
        synchronized (this.mRouteMapLock) {
            new IMappingInitializer() { // from class: com.bytedance.router.mapping.SmartRouter$$Mapping
                @Override // com.bytedance.router.IMappingInitializer
                public void init(Map<String, String> map) {
                }
            }.init(this.mRouteMap);
        }
        Logger.d(String.format("RouteMapper#loadMappingByRouter routes: %d .", Integer.valueOf(this.mRouteMap.size())));
    }

    public void updateMapping(Map<String, String> map) {
        synchronized (this.mRouteMapLock) {
            if (this.mOriginMap == null) {
                HashMap hashMap = new HashMap();
                this.mOriginMap = hashMap;
                hashMap.putAll(this.mRouteMap);
                this.mRouteMap.putAll(map);
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.putAll(this.mOriginMap);
                hashMap2.putAll(map);
                this.mRouteMap = hashMap2;
            }
        }
    }

    public boolean loadModuleMapping(String str) {
        return loadModuleMapping(str, null);
    }

    public boolean loadModuleMapping(String str, ClassLoader classLoader) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String format = String.format(MAP_JAVA_FORMAT, str);
        try {
            Object newInstance = (classLoader == null ? Class.forName(format) : Class.forName(format, true, classLoader)).newInstance();
            if (newInstance instanceof IMappingInitializer) {
                synchronized (this.mRouteMapLock) {
                    ((IMappingInitializer) newInstance).init(this.mRouteMap);
                }
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        return false;
    }

    public String getTargetClass(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = this.mRouteMap.get(Util.getRealRouteUrl(str));
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mRouteMap.get(Util.getRouteUrl(str));
        }
        Logger.d("RouteMapper#getTargetClass url: " + str + "  |  targetClass: " + str2);
        return str2;
    }

    public String getTargetModelClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = this.mRouteMap.get(Util.getRealRouteUrl(str) + "::model");
        return TextUtils.isEmpty(str2) ? this.mRouteMap.get(Util.getRouteUrl(str) + "::model") : str2;
    }
}
