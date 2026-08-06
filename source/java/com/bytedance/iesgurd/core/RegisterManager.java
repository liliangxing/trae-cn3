package com.bytedance.iesgurd.core;

import android.os.Looper;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tJ(\u0010\u0010\u001a\u00020\u00112 \u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\t\u0018\u00010\tJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J.\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tJ\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R)\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/iesgurd/core/RegisterManager;", "", "()V", "cacheRegisters", "", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "getCacheRegisters", "()Ljava/util/List;", "customParams", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "getCustomParams", "()Ljava/util/Map;", "registersClass", "", "addParams", "", "accessKey", "params", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "paramMap", "cacheRegister", "register", "getBusinessVersion", "getBusinessVersionWithCommon", LynxMonitorService.KEY_TRIGGER, "", "registerDirAndCustomParams", "registerGecko", "rootDir", "triggerRequest", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RegisterManager {
    public static final RegisterManager INSTANCE = new RegisterManager();
    private static final Set<String> registersClass = new CopyOnWriteArraySet();
    private static final Map<String, ConcurrentHashMap<String, String>> customParams = new ConcurrentHashMap();
    private static final List<IGeckoRegister> cacheRegisters = new CopyOnWriteArrayList();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GeckoGlobalConfig.ENVType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GeckoGlobalConfig.ENVType.DEV.ordinal()] = 1;
            iArr[GeckoGlobalConfig.ENVType.PROD.ordinal()] = 2;
            iArr[GeckoGlobalConfig.ENVType.BOE.ordinal()] = 3;
        }
    }

    private RegisterManager() {
    }

    public final Map<String, ConcurrentHashMap<String, String>> getCustomParams() {
        return customParams;
    }

    public final List<IGeckoRegister> getCacheRegisters() {
        return cacheRegisters;
    }

    public final void registerDirAndCustomParams() {
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        if (inst.getRegisterBySPI()) {
            GeckoLogger.d("register by spi");
            try {
                Result.Companion companion = Result.Companion;
                Looper mainLooper = Looper.getMainLooper();
                Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
                Thread thread = mainLooper.getThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "Looper.getMainLooper().thread");
                ServiceLoader<IGeckoRegister> load = ServiceLoader.load(IGeckoRegister.class, thread.getContextClassLoader());
                Intrinsics.checkExpressionValueIsNotNull(load, "loader");
                for (IGeckoRegister iGeckoRegister : load) {
                    List<IGeckoRegister> list = cacheRegisters;
                    Intrinsics.checkExpressionValueIsNotNull(iGeckoRegister, "it");
                    list.add(iGeckoRegister);
                }
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
        List<IGeckoRegister> list2 = cacheRegisters;
        if (list2.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (IGeckoRegister iGeckoRegister2 : list2) {
            String name = iGeckoRegister2.getClass().getName();
            if (registersClass.contains(name)) {
                sb.append(name + ';');
            } else {
                sb2.append(name + ';');
            }
            register(iGeckoRegister2, false);
        }
        UploadStatistic.INSTANCE.uploadEvent(EventSubType.RIGISTER_CLASS, sb2.toString(), sb.toString(), 0L);
    }

    public final void cacheRegister(IGeckoRegister register) {
        Intrinsics.checkParameterIsNotNull(register, "register");
        cacheRegisters.add(register);
    }

    public final void register(IGeckoRegister register, boolean trigger) {
        int i;
        Intrinsics.checkParameterIsNotNull(register, "register");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "config");
        GeckoGlobalConfig.ENVType env = globalConfig.getEnv();
        String name = register.getClass().getName();
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.GECKO_REGISTER_BY_IREGISTER, "register gecko by IGeckoRegister, env: " + env + ", class: " + name);
        GeckoRegister annotation = register.getClass().getAnnotation(GeckoRegister.class);
        if (annotation == null) {
            GeckoLogger.w("GeckoRegister is invalid, class is " + name);
            return;
        }
        Set<String> set = registersClass;
        if (set.contains(name)) {
            GeckoLogger.w("GeckoRegister already register, class is " + name);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(name, "className");
        set.add(name);
        String testAccessKey = annotation.testAccessKey();
        String boeAccessKey = annotation.boeAccessKey();
        String prodAccessKey = annotation.prodAccessKey();
        boolean z = true;
        if (env != null && (i = WhenMappings.$EnumSwitchMapping$0[env.ordinal()]) != 1) {
            if (i == 2) {
                testAccessKey = prodAccessKey;
            } else if (i == 3) {
                testAccessKey = boeAccessKey;
            }
        }
        if (testAccessKey.length() == 0) {
            GeckoLogger.w("GeckoRegister access key is empty, class is " + name);
            return;
        }
        addParams(testAccessKey, register.registerCustomParams());
        String registerRootDir = register.registerRootDir(globalConfig.getContext());
        String str = registerRootDir;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            GeckoLogger.w("GeckoRegister root dir is empty, class is " + name);
        } else {
            GeckoGlobalManager.inst().registerAccessKey2Dir(testAccessKey, registerRootDir);
        }
        if (trigger) {
            triggerRequest(testAccessKey);
        }
    }

    public final void registerGecko(String accessKey, String rootDir, Map<String, OptionCheckUpdateParams.CustomValue> params) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        boolean z = true;
        if (accessKey.length() == 0) {
            GeckoLogger.d("gecko register failed: accessKey is empty");
            return;
        }
        String str = rootDir;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            GeckoGlobalManager.inst().registerAccessKey2Dir(accessKey, rootDir);
        }
        addParams(accessKey, params);
        triggerRequest(accessKey);
    }

    public final void addParams(String accessKey, Map<String, OptionCheckUpdateParams.CustomValue> params) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        if (params == null || params.isEmpty()) {
            return;
        }
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.GECKO_REGISTER_CUSTOM_PARAMS, "register custom params: " + accessKey + ", " + params);
        Map<String, ConcurrentHashMap<String, String>> map = customParams;
        if (map.get(accessKey) == null) {
            synchronized (map) {
                if (map.get(accessKey) == null) {
                    map.put(accessKey, new ConcurrentHashMap<>());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = map.get(accessKey);
        if (concurrentHashMap == null) {
            Intrinsics.throwNpe();
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = concurrentHashMap;
        for (Map.Entry<String, OptionCheckUpdateParams.CustomValue> entry : params.entrySet()) {
            Object value = entry.getValue().getValue();
            if (value != null) {
                concurrentHashMap2.put(entry.getKey(), value.toString());
            }
        }
    }

    public final String getBusinessVersion(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        ConcurrentHashMap<String, String> concurrentHashMap = customParams.get(accessKey);
        if (concurrentHashMap != null) {
            return concurrentHashMap.get("business_version");
        }
        return null;
    }

    public final String getBusinessVersionWithCommon(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        String businessVersion = getBusinessVersion(accessKey);
        if (businessVersion == null) {
            businessVersion = GlobalManager.INSTANCE.getCommon().getAppVersion();
        }
        return businessVersion != null ? businessVersion : "";
    }

    private final void triggerRequest(String accessKey) {
        if (GlobalManager.INSTANCE.getSettingsFetched().get()) {
            ColdStartManager.INSTANCE.updateIfNeeded(accessKey);
            if (!Intrinsics.areEqual(getBusinessVersion(accessKey), GlobalManager.INSTANCE.getCommon().getAppVersion())) {
                GlobalSettingsManager.fetchGlobalSettings$default(GlobalSettingsManager.INSTANCE, ReqType.REGISTER_LATE, null, 2, null);
            }
        }
    }

    public final void addParams(Map<String, Map<String, OptionCheckUpdateParams.CustomValue>> paramMap) {
        if (paramMap != null) {
            for (Map.Entry<String, Map<String, OptionCheckUpdateParams.CustomValue>> entry : paramMap.entrySet()) {
                INSTANCE.addParams(entry.getKey(), entry.getValue());
            }
        }
    }
}
