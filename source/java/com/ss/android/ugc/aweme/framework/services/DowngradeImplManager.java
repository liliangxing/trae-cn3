package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.bytedance.bmf_mods_api.AdaptiveGradingAPIDefault;
import com.bytedance.bmf_mods_api.ColorHistAPIDefault;
import com.bytedance.bmf_mods_api.ColorShiftAPIDefault;
import com.bytedance.bmf_mods_api.DenoiseAPIDefault;
import com.bytedance.bmf_mods_api.HydraHDRAPIDefault;
import com.bytedance.bmf_mods_api.NoiseDetectAPIDefault;
import com.bytedance.bmf_mods_api.NoiseDetectCallbackAPIDefault;
import com.bytedance.bmf_mods_api.NoiseLiveAPIDefault;
import com.bytedance.bmf_mods_api.NoiseLiveCallbackAPIDefault;
import com.bytedance.bmf_mods_api.VideoBrightAPIDefault;
import com.bytedance.bmf_mods_api.VideoBrightCallBackAPIDefault;
import com.bytedance.bmf_mods_api.VideoOCLSRAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRLutAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRLutDspAPIDefault;
import com.bytedance.bmf_mods_api.VideoSRRaisrAPIDefault;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreLiveAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPIDefault;
import com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPIDefault;
import com.bytedance.ies.web.jsbridge2.JsBridge2ConfigDefault;
import com.bytedance.pia.core.spi.ConfigTask;
import com.bytedance.timon.foundation.impl.AndroidLoggerImpl;
import com.bytedance.timon.foundation.impl.AppLogImpl;
import com.bytedance.timon.foundation.impl.EventMonitorDowngradeImpl;
import com.bytedance.timon.foundation.impl.ExceptionMonitorImpl;
import com.bytedance.timon.foundation.impl.SPStoreImpl;
import com.bytedance.timon.ruler.adapter.impl.RulerBusinessEmptyImpl;
import com.bytedance.timonbase.TimonLifecycleServiceDowngradeImp;
import com.fackbook.drawee.DraweeConfigOutServiceDowngrade;
import com.ss.android.ugc.quota.BDNetworkTagConfigDefault;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DowngradeImplManager {
    private Map<String, ServiceProvider> downgradeImplMap = new ConcurrentHashMap();
    private Map<String, Object> staticDowngradeImplCache = new ConcurrentHashMap();
    final Map<String, String> componentsMap = new ConcurrentHashMap();
    final Set<String> downgradeComponents = Collections.synchronizedSet(new HashSet());
    final Set<String> staticDowngradeNotExistSet = Collections.synchronizedSet(new HashSet());

    private void addServiceComponent(String str, String str2) {
        this.componentsMap.put(str, str2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingleInstanceHolder {
        private static final DowngradeImplManager INSTANCE = new DowngradeImplManager();

        private SingleInstanceHolder() {
        }
    }

    public static DowngradeImplManager getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public <T> T getDowngradeImpl(Class<T> cls) {
        String name = cls.getName();
        ServiceProvider serviceProvider = this.downgradeImplMap.get(name);
        if (serviceProvider != null) {
            return (T) serviceProvider.get();
        }
        T t = (T) this.staticDowngradeImplCache.get(name);
        return (t != null || this.staticDowngradeNotExistSet.contains(name)) ? t : (T) getStaticDowngradeImpl(cls);
    }

    private <T> T getStaticDowngradeImpl(Class<T> cls) {
        switch (cls.getName().hashCode()) {
            case -1971258211:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveCallbackAPI")) {
                    T t = (T) new NoiseLiveCallbackAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseLiveCallbackAPI", t);
                    return t;
                }
                break;
            case -1891048851:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.ColorShiftAPI")) {
                    T t2 = (T) new ColorShiftAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ColorShiftAPI", t2);
                    return t2;
                }
                break;
            case -1859502304:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI")) {
                    T t3 = (T) new VideoSuperResolutionAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI", t3);
                    return t3;
                }
                break;
            case -1788325683:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoSRRaisrAPI")) {
                    T t4 = (T) new VideoSRRaisrAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRRaisrAPI", t4);
                    return t4;
                }
                break;
            case -1748441402:
                if (cls.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig")) {
                    T t5 = (T) new BDNetworkTagConfigDefault();
                    putStaticDowngradeImplCache("com.ss.android.ugc.quota.IBDNetworkTagConfig", t5);
                    return t5;
                }
                break;
            case -1689796830:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveAPI")) {
                    T t6 = (T) new NoiseLiveAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseLiveAPI", t6);
                    return t6;
                }
                break;
            case -1614766624:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI")) {
                    T t7 = (T) new VqscoreLiveCallbackAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI", t7);
                    return t7;
                }
                break;
            case -1364971920:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoOCLSRAPI")) {
                    T t8 = (T) new VideoOCLSRAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoOCLSRAPI", t8);
                    return t8;
                }
                break;
            case -1317882728:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutDspAPI")) {
                    T t9 = (T) new VideoSRLutDspAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRLutDspAPI", t9);
                    return t9;
                }
                break;
            case -1077200566:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.AdaptiveGradingAPI")) {
                    T t10 = (T) new AdaptiveGradingAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.AdaptiveGradingAPI", t10);
                    return t10;
                }
                break;
            case -767436525:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoBrightAPI")) {
                    T t11 = (T) new VideoBrightAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoBrightAPI", t11);
                    return t11;
                }
                break;
            case -703329023:
                if (cls.getName().equals("com.fackbook.drawee.IDraweeConfigOutService")) {
                    return (T) new DraweeConfigOutServiceDowngrade();
                }
                break;
            case -570979083:
                if (cls.getName().equals("com.bytedance.pia.core.spi.api.IPiaConfigTask")) {
                    T t12 = (T) new ConfigTask();
                    putStaticDowngradeImplCache("com.bytedance.pia.core.spi.api.IPiaConfigTask", t12);
                    return t12;
                }
                break;
            case -268569559:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.IEventMonitor")) {
                    T t13 = (T) new EventMonitorDowngradeImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IEventMonitor", t13);
                    return t13;
                }
                break;
            case 26004728:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.HydraHDRAPI")) {
                    T t14 = (T) new HydraHDRAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.HydraHDRAPI", t14);
                    return t14;
                }
                break;
            case 174990420:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.IExceptionMonitor")) {
                    T t15 = (T) new ExceptionMonitorImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IExceptionMonitor", t15);
                    return t15;
                }
                break;
            case 437708184:
                if (cls.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService")) {
                    T t16 = (T) new RulerBusinessEmptyImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService", t16);
                    return t16;
                }
                break;
            case 477254501:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveAPI")) {
                    T t17 = (T) new VqscoreLiveAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreLiveAPI", t17);
                    return t17;
                }
                break;
            case 642369832:
                if (cls.getName().equals("com.bytedance.ies.web.jsbridge2.IJsBridge2Config")) {
                    return (T) new JsBridge2ConfigDefault();
                }
                break;
            case 682082159:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI")) {
                    T t18 = (T) new VqscoreProcessCallbackAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI", t18);
                    return t18;
                }
                break;
            case 800642807:
                if (cls.getName().equals("com.bytedance.timonbase.ITMLifecycleService")) {
                    T t19 = (T) new TimonLifecycleServiceDowngradeImp();
                    putStaticDowngradeImplCache("com.bytedance.timonbase.ITMLifecycleService", t19);
                    return t19;
                }
                break;
            case 922519942:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectCallbackAPI")) {
                    T t20 = (T) new NoiseDetectCallbackAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseDetectCallbackAPI", t20);
                    return t20;
                }
                break;
            case 1053771019:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectAPI")) {
                    T t21 = (T) new NoiseDetectAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.NoiseDetectAPI", t21);
                    return t21;
                }
                break;
            case 1159930051:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.ColorHistAPI")) {
                    T t22 = (T) new ColorHistAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.ColorHistAPI", t22);
                    return t22;
                }
                break;
            case 1309034040:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.IStore")) {
                    T t23 = (T) new SPStoreImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IStore", t23);
                    return t23;
                }
                break;
            case 1406324460:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.IAppLog")) {
                    T t24 = (T) new AppLogImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.IAppLog", t24);
                    return t24;
                }
                break;
            case 1678604719:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.DenoiseAPI")) {
                    T t25 = (T) new DenoiseAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.DenoiseAPI", t25);
                    return t25;
                }
                break;
            case 1720079129:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger")) {
                    T t26 = (T) new AndroidLoggerImpl();
                    putStaticDowngradeImplCache("com.bytedance.timon.foundation.interfaces.ILogger", t26);
                    return t26;
                }
                break;
            case 1771368059:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutAPI")) {
                    T t27 = (T) new VideoSRLutAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoSRLutAPI", t27);
                    return t27;
                }
                break;
            case 1790875022:
                if (cls.getName().equals("com.bytedance.bmf_mods_api.VideoBrightCallbackAPI")) {
                    T t28 = (T) new VideoBrightCallBackAPIDefault();
                    putStaticDowngradeImplCache("com.bytedance.bmf_mods_api.VideoBrightCallbackAPI", t28);
                    return t28;
                }
                break;
        }
        this.staticDowngradeNotExistSet.add(cls.getName());
        return null;
    }

    private void putStaticDowngradeImplCache(String str, Object obj) {
        this.staticDowngradeImplCache.put(str, obj);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider) {
        this.downgradeImplMap.put(cls.getName(), serviceProvider);
    }

    public void downgradeComponent(String str) {
        if (TextUtils.isEmpty(str) || this.downgradeComponents.contains(str)) {
            return;
        }
        this.downgradeComponents.add(str);
    }

    public boolean isServiceForceDowngrade(Class cls) {
        String str = this.componentsMap.get(cls.getName());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.downgradeComponents.contains(str);
    }
}
