package com.ss.android.ugc.aweme.framework.services;

import com.bytedance.timon.clipboard.suite.TMClipboardLifecycleServiceImpl;
import com.bytedance.timon.ext.alog.AlogLoggerImpl;
import com.bytedance.timon.ext.keva.KevaStoreImpl;
import com.bytedance.timon.foundation.impl.LocalTimonLogger;
import com.bytedance.timon.upc.upc_adapter_impl.UpcBusinessServiceImpl;
import com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl;
import com.bytedance.timonbase.TMBaseLifecycleService;
import com.bytedance.trae.abtest.AbTestInitiator;
import com.bytedance.trae.abtest.impl.AbTestImpl;
import com.bytedance.trae.apm.impl.ApmImpl;
import com.bytedance.trae.apm.impl.ApmTraceImpl;
import com.bytedance.trae.apm.impl.ExtraParamsImpl;
import com.bytedance.trae.apm.impl.GodzillaImpl;
import com.bytedance.trae.apm.impl.LoggerImpl;
import com.bytedance.trae.apm.impl.NpthImpl;
import com.bytedance.trae.applog.impl.ApplogImpl;
import com.bytedance.trae.applog.impl.MultiInstanceAppLogServiceImpl;
import com.bytedance.trae.applog.task.AppLogInitiator;
import com.bytedance.trae.common.security.impl.SecurityServiceImpl;
import com.bytedance.trae.image.ImageInitiator;
import com.bytedance.trae.login.service.DouyinLoginServiceImpl;
import com.bytedance.trae.login.service.LoginServiceImpl;
import com.bytedance.trae.network.quota.BDNetworkTagConfigImpl;
import com.bytedance.trae.push.impl.IPushServiceImpl;
import com.bytedance.trae.service.AppHostImpl;
import com.bytedance.trae.service.TraeSdkCommonDependImpl;
import com.bytedance.trae.settings.impl.SettingsServiceImpl;
import com.bytedance.trae.settings.impl.feature.FeatureCapabilityServiceImpl;
import com.bytedance.trae.update.IBitsUpdateImpl;
import com.bytedance.upc.common.CommonBusinessService;
import com.bytedance.upc.common.CommonService;
import com.bytedance.upc.common.device.DeviceInfoService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class StaticServiceImplManager {
    private Map<String, Object> serviceImplCache = new ConcurrentHashMap();
    final Set<String> serviceImplNotExistSet = Collections.synchronizedSet(new HashSet());
    private Map<String, Set<Object>> serviceImplSetCache = new ConcurrentHashMap();
    final Set<String> serviceImplSetNotExistSet = Collections.synchronizedSet(new HashSet());

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> cls, ServiceTypeFilter serviceTypeFilter) {
        return null;
    }

    private Set getStaticServiceImplSetRealStub0(Class cls) {
        String str;
        HashSet hashSet;
        ImageInitiator multiInstanceAppLogServiceImpl;
        switch (cls.getName().hashCode()) {
            case -1870782390:
                str = "com.bytedance.trae.applog.api.IMultiInstanceAppLogService";
                if (!cls.getName().equals("com.bytedance.trae.applog.api.IMultiInstanceAppLogService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new MultiInstanceAppLogServiceImpl();
                break;
            case -1802483777:
                str = "com.bytedance.trae.apm.api.IGodzilla";
                if (!cls.getName().equals("com.bytedance.trae.apm.api.IGodzilla")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new GodzillaImpl();
                break;
            case -1773014112:
                str = "com.bytedance.upc.IUpcLifecycleService";
                if (!cls.getName().equals("com.bytedance.upc.IUpcLifecycleService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new CommonService();
                break;
            case -1748441402:
                str = "com.ss.android.ugc.quota.IBDNetworkTagConfig";
                if (!cls.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new BDNetworkTagConfigImpl();
                break;
            case -1743430635:
                str = "com.bytedance.trae.settings.api.feature.IFeatureCapabilityService";
                if (!cls.getName().equals("com.bytedance.trae.settings.api.feature.IFeatureCapabilityService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new FeatureCapabilityServiceImpl();
                break;
            case -1728051052:
                str = "com.bytedance.trae.utils.logger.ILogger";
                if (!cls.getName().equals("com.bytedance.trae.utils.logger.ILogger")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new LoggerImpl();
                break;
            case -1472983218:
                str = "com.bytedance.upc.common.ICommonBusinessService";
                if (!cls.getName().equals("com.bytedance.upc.common.ICommonBusinessService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new CommonBusinessService();
                break;
            case -1465274161:
                str = "com.bytedance.trae.update.IBitsUpdate";
                if (!cls.getName().equals("com.bytedance.trae.update.IBitsUpdate")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new IBitsUpdateImpl();
                break;
            case -1183767787:
                str = "com.bytedance.trae.apm.api.IApm";
                if (!cls.getName().equals("com.bytedance.trae.apm.api.IApm")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new ApmImpl();
                break;
            case -776198914:
                str = "com.bytedance.timon.foundation.interfaces.ITimonLogger";
                if (!cls.getName().equals("com.bytedance.timon.foundation.interfaces.ITimonLogger")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new LocalTimonLogger();
                break;
            case -748100791:
                str = "com.bytedance.trae.applog.api.IApplog";
                if (!cls.getName().equals("com.bytedance.trae.applog.api.IApplog")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new ApplogImpl();
                break;
            case -595224454:
                str = "com.bytedance.trae.common.security.api.SecurityService";
                if (!cls.getName().equals("com.bytedance.trae.common.security.api.SecurityService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new SecurityServiceImpl();
                break;
            case -541154163:
                str = "com.larus.abtest.api.IAbTest";
                if (!cls.getName().equals("com.larus.abtest.api.IAbTest")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new AbTestImpl();
                break;
            case -432618427:
                str = "com.bytedance.trae.platform.ITraeSdkCommonDepend";
                if (!cls.getName().equals("com.bytedance.trae.platform.ITraeSdkCommonDepend")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new TraeSdkCommonDependImpl();
                break;
            case -131066764:
                str = "com.bytedance.trae.login.api.IDouyinLoginService";
                if (!cls.getName().equals("com.bytedance.trae.login.api.IDouyinLoginService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new DouyinLoginServiceImpl();
                break;
            case 15152000:
                str = "com.bytedance.trae.login.api.ILoginService";
                if (!cls.getName().equals("com.bytedance.trae.login.api.ILoginService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new LoginServiceImpl();
                break;
            case 87483518:
                str = "com.bytedance.trae.push.api.IPushService";
                if (!cls.getName().equals("com.bytedance.trae.push.api.IPushService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new IPushServiceImpl();
                break;
            case 375149696:
                str = "com.bytedance.upc.IUpcBusinessService";
                if (!cls.getName().equals("com.bytedance.upc.IUpcBusinessService")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new CommonBusinessService());
                multiInstanceAppLogServiceImpl = new DeviceInfoService();
                break;
            case 478867373:
                str = "com.bytedance.trae.apm.api.IExtraParams";
                if (!cls.getName().equals("com.bytedance.trae.apm.api.IExtraParams")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new ExtraParamsImpl();
                break;
            case 586719852:
                str = "com.bytedance.trae.settings.api.ISettingsService";
                if (!cls.getName().equals("com.bytedance.trae.settings.api.ISettingsService")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new SettingsServiceImpl();
                break;
            case 708608273:
                str = "com.larus.init.IAbTestInitiator";
                if (!cls.getName().equals("com.larus.init.IAbTestInitiator")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new AbTestInitiator();
                break;
            case 793955194:
                str = "com.bytedance.trae.image.api.IImageInitiator";
                if (!cls.getName().equals("com.bytedance.trae.image.api.IImageInitiator")) {
                    return null;
                }
                hashSet = new HashSet();
                multiInstanceAppLogServiceImpl = new ImageInitiator();
                break;
            case 800642807:
                if (!cls.getName().equals("com.bytedance.timonbase.ITMLifecycleService")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new TMClipboardLifecycleServiceImpl());
                hashSet.add(new UpcLifecycleServiceImpl());
                hashSet.add(new TMBaseLifecycleService());
                str = "com.bytedance.timonbase.ITMLifecycleService";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1039963182:
                if (!cls.getName().equals("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new UpcBusinessServiceImpl());
                str = "com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1290379635:
                if (!cls.getName().equals("com.bytedance.upc.common.device.IDeviceInfoService")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new DeviceInfoService());
                str = "com.bytedance.upc.common.device.IDeviceInfoService";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1309034040:
                if (!cls.getName().equals("com.bytedance.timon.foundation.interfaces.IStore")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new KevaStoreImpl());
                str = "com.bytedance.timon.foundation.interfaces.IStore";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1475570770:
                if (!cls.getName().equals("com.bytedance.trae.applog.init.IAppLogInitiator")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new AppLogInitiator());
                str = "com.bytedance.trae.applog.init.IAppLogInitiator";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1720079129:
                if (!cls.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new AlogLoggerImpl());
                str = "com.bytedance.timon.foundation.interfaces.ILogger";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1735885616:
                if (!cls.getName().equals("com.bytedance.trae.apm.api.IApmTrace")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new ApmTraceImpl());
                str = "com.bytedance.trae.apm.api.IApmTrace";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1793988989:
                if (!cls.getName().equals("com.bytedance.trae.common.apphost.AppHost")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new AppHostImpl());
                str = "com.bytedance.trae.common.apphost.AppHost";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            case 1958291871:
                if (!cls.getName().equals("com.bytedance.trae.apm.api.INpth")) {
                    return null;
                }
                hashSet = new HashSet();
                hashSet.add(new NpthImpl());
                str = "com.bytedance.trae.apm.api.INpth";
                putStaticServiceImplSetCache(str, hashSet);
                return hashSet;
            default:
                return null;
        }
        hashSet.add(multiInstanceAppLogServiceImpl);
        putStaticServiceImplSetCache(str, hashSet);
        return hashSet;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingleInstanceHolder {
        private static final StaticServiceImplManager INSTANCE = new StaticServiceImplManager();

        private SingleInstanceHolder() {
        }
    }

    public static StaticServiceImplManager getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public <T> T getStaticServiceImpl(Class<T> cls) {
        String name = cls.getName();
        T t = (T) this.serviceImplCache.get(name);
        return (t != null || this.serviceImplNotExistSet.contains(name)) ? t : (T) getStaticServiceImplReal(cls);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> cls) {
        String name = cls.getName();
        Set<T> set = (Set) this.serviceImplSetCache.get(name);
        return (set != null || this.serviceImplSetNotExistSet.contains(name)) ? set : getStaticServiceImplSetReal(cls);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> cls, String str) {
        String str2 = cls.getName() + "_spi_" + str;
        Set<T> set = (Set) this.serviceImplSetCache.get(str2);
        return (set != null || this.serviceImplSetNotExistSet.contains(str2)) ? set : getStaticServiceImplSetReal(cls, str);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> cls, ServiceTypeFilter serviceTypeFilter) {
        return getStaticServiceImplSetReal(cls, serviceTypeFilter);
    }

    private <T> T getStaticServiceImplReal(Class<T> cls) {
        switch (cls.getName().hashCode()) {
            case -1870782390:
                if (cls.getName().equals("com.bytedance.trae.applog.api.IMultiInstanceAppLogService")) {
                    T t = (T) new MultiInstanceAppLogServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.applog.api.IMultiInstanceAppLogService", t);
                    return t;
                }
                break;
            case -1802483777:
                if (cls.getName().equals("com.bytedance.trae.apm.api.IGodzilla")) {
                    T t2 = (T) new GodzillaImpl();
                    putStaticServiceImplCache("com.bytedance.trae.apm.api.IGodzilla", t2);
                    return t2;
                }
                break;
            case -1773014112:
                if (cls.getName().equals("com.bytedance.upc.IUpcLifecycleService")) {
                    T t3 = (T) new CommonService();
                    putStaticServiceImplCache("com.bytedance.upc.IUpcLifecycleService", t3);
                    return t3;
                }
                break;
            case -1748441402:
                if (cls.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig")) {
                    return (T) new BDNetworkTagConfigImpl();
                }
                break;
            case -1743430635:
                if (cls.getName().equals("com.bytedance.trae.settings.api.feature.IFeatureCapabilityService")) {
                    T t4 = (T) new FeatureCapabilityServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.settings.api.feature.IFeatureCapabilityService", t4);
                    return t4;
                }
                break;
            case -1728051052:
                if (cls.getName().equals("com.bytedance.trae.utils.logger.ILogger")) {
                    T t5 = (T) new LoggerImpl();
                    putStaticServiceImplCache("com.bytedance.trae.utils.logger.ILogger", t5);
                    return t5;
                }
                break;
            case -1472983218:
                if (cls.getName().equals("com.bytedance.upc.common.ICommonBusinessService")) {
                    T t6 = (T) new CommonBusinessService();
                    putStaticServiceImplCache("com.bytedance.upc.common.ICommonBusinessService", t6);
                    return t6;
                }
                break;
            case -1465274161:
                if (cls.getName().equals("com.bytedance.trae.update.IBitsUpdate")) {
                    T t7 = (T) new IBitsUpdateImpl();
                    putStaticServiceImplCache("com.bytedance.trae.update.IBitsUpdate", t7);
                    return t7;
                }
                break;
            case -1183767787:
                if (cls.getName().equals("com.bytedance.trae.apm.api.IApm")) {
                    T t8 = (T) new ApmImpl();
                    putStaticServiceImplCache("com.bytedance.trae.apm.api.IApm", t8);
                    return t8;
                }
                break;
            case -776198914:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.ITimonLogger")) {
                    T t9 = (T) new LocalTimonLogger();
                    putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.ITimonLogger", t9);
                    return t9;
                }
                break;
            case -748100791:
                if (cls.getName().equals("com.bytedance.trae.applog.api.IApplog")) {
                    T t10 = (T) new ApplogImpl();
                    putStaticServiceImplCache("com.bytedance.trae.applog.api.IApplog", t10);
                    return t10;
                }
                break;
            case -595224454:
                if (cls.getName().equals("com.bytedance.trae.common.security.api.SecurityService")) {
                    T t11 = (T) new SecurityServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.common.security.api.SecurityService", t11);
                    return t11;
                }
                break;
            case -541154163:
                if (cls.getName().equals("com.larus.abtest.api.IAbTest")) {
                    T t12 = (T) new AbTestImpl();
                    putStaticServiceImplCache("com.larus.abtest.api.IAbTest", t12);
                    return t12;
                }
                break;
            case -432618427:
                if (cls.getName().equals("com.bytedance.trae.platform.ITraeSdkCommonDepend")) {
                    T t13 = (T) new TraeSdkCommonDependImpl();
                    putStaticServiceImplCache("com.bytedance.trae.platform.ITraeSdkCommonDepend", t13);
                    return t13;
                }
                break;
            case -131066764:
                if (cls.getName().equals("com.bytedance.trae.login.api.IDouyinLoginService")) {
                    T t14 = (T) new DouyinLoginServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.login.api.IDouyinLoginService", t14);
                    return t14;
                }
                break;
            case 15152000:
                if (cls.getName().equals("com.bytedance.trae.login.api.ILoginService")) {
                    T t15 = (T) new LoginServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.login.api.ILoginService", t15);
                    return t15;
                }
                break;
            case 87483518:
                if (cls.getName().equals("com.bytedance.trae.push.api.IPushService")) {
                    T t16 = (T) new IPushServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.push.api.IPushService", t16);
                    return t16;
                }
                break;
            case 375149696:
                if (cls.getName().equals("com.bytedance.upc.IUpcBusinessService")) {
                    T t17 = (T) new DeviceInfoService();
                    putStaticServiceImplCache("com.bytedance.upc.IUpcBusinessService", t17);
                    return t17;
                }
                break;
            case 478867373:
                if (cls.getName().equals("com.bytedance.trae.apm.api.IExtraParams")) {
                    T t18 = (T) new ExtraParamsImpl();
                    putStaticServiceImplCache("com.bytedance.trae.apm.api.IExtraParams", t18);
                    return t18;
                }
                break;
            case 586719852:
                if (cls.getName().equals("com.bytedance.trae.settings.api.ISettingsService")) {
                    T t19 = (T) new SettingsServiceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.settings.api.ISettingsService", t19);
                    return t19;
                }
                break;
            case 708608273:
                if (cls.getName().equals("com.larus.init.IAbTestInitiator")) {
                    T t20 = (T) new AbTestInitiator();
                    putStaticServiceImplCache("com.larus.init.IAbTestInitiator", t20);
                    return t20;
                }
                break;
            case 793955194:
                if (cls.getName().equals("com.bytedance.trae.image.api.IImageInitiator")) {
                    T t21 = (T) new ImageInitiator();
                    putStaticServiceImplCache("com.bytedance.trae.image.api.IImageInitiator", t21);
                    return t21;
                }
                break;
            case 800642807:
                if (cls.getName().equals("com.bytedance.timonbase.ITMLifecycleService")) {
                    T t22 = (T) new UpcLifecycleServiceImpl();
                    putStaticServiceImplCache("com.bytedance.timonbase.ITMLifecycleService", t22);
                    return t22;
                }
                break;
            case 1039963182:
                if (cls.getName().equals("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService")) {
                    T t23 = (T) new UpcBusinessServiceImpl();
                    putStaticServiceImplCache("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService", t23);
                    return t23;
                }
                break;
            case 1290379635:
                if (cls.getName().equals("com.bytedance.upc.common.device.IDeviceInfoService")) {
                    T t24 = (T) new DeviceInfoService();
                    putStaticServiceImplCache("com.bytedance.upc.common.device.IDeviceInfoService", t24);
                    return t24;
                }
                break;
            case 1309034040:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.IStore")) {
                    T t25 = (T) new KevaStoreImpl();
                    putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.IStore", t25);
                    return t25;
                }
                break;
            case 1475570770:
                if (cls.getName().equals("com.bytedance.trae.applog.init.IAppLogInitiator")) {
                    T t26 = (T) new AppLogInitiator();
                    putStaticServiceImplCache("com.bytedance.trae.applog.init.IAppLogInitiator", t26);
                    return t26;
                }
                break;
            case 1720079129:
                if (cls.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger")) {
                    T t27 = (T) new AlogLoggerImpl();
                    putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.ILogger", t27);
                    return t27;
                }
                break;
            case 1735885616:
                if (cls.getName().equals("com.bytedance.trae.apm.api.IApmTrace")) {
                    T t28 = (T) new ApmTraceImpl();
                    putStaticServiceImplCache("com.bytedance.trae.apm.api.IApmTrace", t28);
                    return t28;
                }
                break;
            case 1793988989:
                if (cls.getName().equals("com.bytedance.trae.common.apphost.AppHost")) {
                    T t29 = (T) new AppHostImpl();
                    putStaticServiceImplCache("com.bytedance.trae.common.apphost.AppHost", t29);
                    return t29;
                }
                break;
            case 1958291871:
                if (cls.getName().equals("com.bytedance.trae.apm.api.INpth")) {
                    T t30 = (T) new NpthImpl();
                    putStaticServiceImplCache("com.bytedance.trae.apm.api.INpth", t30);
                    return t30;
                }
                break;
        }
        this.serviceImplNotExistSet.add(cls.getName());
        return null;
    }

    private void putStaticServiceImplCache(String str, Object obj) {
        this.serviceImplCache.put(str, obj);
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> cls) {
        Set<T> staticServiceImplSetRealStub0 = getStaticServiceImplSetRealStub0(cls);
        if (staticServiceImplSetRealStub0 != null) {
            return staticServiceImplSetRealStub0;
        }
        this.serviceImplSetNotExistSet.add(cls.getName());
        return null;
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> cls, String str) {
        this.serviceImplSetNotExistSet.add(cls.getName() + "_spi_" + str);
        return null;
    }

    private void putStaticServiceImplSetCache(String str, Set<Object> set) {
        if (this.serviceImplSetCache.containsKey(str)) {
            return;
        }
        this.serviceImplSetCache.put(str, set);
    }
}
