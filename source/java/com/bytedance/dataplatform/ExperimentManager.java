package com.bytedance.dataplatform;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.bdturing.EventReport;
import com.bytedance.dataplatform.applog.AppLogManager;
import com.bytedance.dataplatform.applog.IAppLogService;
import com.bytedance.dataplatform.client.ClientDataSource;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExperimentManager {
    private static IDebugInfoCallback debugInfoCallback;
    private static volatile ExperimentCache experimentCache;
    private static ISettings iSettings;
    private static volatile Future initFuture;
    private static IExperimentListener sExperimentListener;
    private static String sInitUid;
    static final Map<String, Object> stickyCache = new ConcurrentHashMap();
    private static volatile boolean sInited = false;
    private static volatile boolean sHostInited = false;
    private static volatile boolean sRealInited = false;
    private static Object sLock = new Object();
    private static Map<String, String> parameter = new ConcurrentHashMap();
    private static Set<String> extraVids = new ConcurrentSkipListSet();
    private static boolean waitWhenNotInit = false;
    private static boolean libraFirst = false;
    private static final Map<String, String> getExperimentValueInfoCache = new ConcurrentHashMap();

    private ExperimentManager() {
    }

    public static void setContext(Application context) {
        ClientExperimentManager.INSTANCE.setContext(context);
    }

    public static void setThreadPool(ScheduledExecutorService threadPool) {
        Worker.singleThreadPool = threadPool;
    }

    public static void setExposeManager(ExposureManager exposeManager) {
        ClientExperimentManager.INSTANCE.setExposureManager(exposeManager);
    }

    public static void setExperimentListener(IExperimentListener sExperimentListener2) {
        sExperimentListener = sExperimentListener2;
    }

    public static IExperimentListener getExperimentListener() {
        return sExperimentListener;
    }

    public static void setAppLogService(final IAppLogService appLogService, boolean exposureEventEnabled, boolean localStrategyEventEnabled) {
        AppLogManager.setAppLogService(appLogService, exposureEventEnabled, localStrategyEventEnabled);
    }

    public static void initBySdk(final Application application, final String host, final boolean needRefresh, final ISettings settings, final ISerializationService serializationService, final IExposureService exposureService, final INetService netService) {
        if (sHostInited) {
            if (settings != null) {
                iSettings = settings;
                ExperimentPanel.init(application, settings, serializationService, experimentCache);
                return;
            }
            return;
        }
        synchronized (sLock) {
            if (!sHostInited) {
                initFuture = Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExperimentCache unused = ExperimentManager.experimentCache = new ExperimentCache(application, host, needRefresh, serializationService, exposureService, netService, ExperimentManager.parameter, ExperimentManager.extraVids);
                        ISettings unused2 = ExperimentManager.iSettings = settings;
                        ExperimentPanel.init(application, settings, serializationService, ExperimentManager.experimentCache);
                        boolean unused3 = ExperimentManager.sRealInited = true;
                        if (ExperimentManager.sInitUid != null) {
                            ExperimentManager.experimentCache.updateUserId(ExperimentManager.sInitUid);
                        }
                    }
                });
                sHostInited = true;
            }
            sLock.notifyAll();
        }
    }

    public static void init(final Application application, final String host, final boolean needRefresh, final ISettings settings, final ISerializationService serializationService, final IExposureService exposureService, final INetService netService) {
        ClientExperimentManager.INSTANCE.setContext(application);
        if (sInited) {
            if (settings != null) {
                iSettings = settings;
                ExperimentPanel.init(application, settings, serializationService, experimentCache);
                return;
            }
            return;
        }
        synchronized (sLock) {
            if (!sInited) {
                initFuture = Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ExperimentCache unused = ExperimentManager.experimentCache = new ExperimentCache(application, host, needRefresh, serializationService, exposureService, netService, ExperimentManager.parameter, ExperimentManager.extraVids);
                        ISettings unused2 = ExperimentManager.iSettings = settings;
                        ExperimentPanel.init(application, settings, serializationService, ExperimentManager.experimentCache);
                        boolean unused3 = ExperimentManager.sRealInited = true;
                        if (ExperimentManager.sInitUid != null) {
                            ExperimentManager.experimentCache.updateUserId(ExperimentManager.sInitUid);
                        }
                    }
                });
                sInited = true;
                sHostInited = true;
            }
            sLock.notifyAll();
        }
    }

    public static void addExtraParameter(final Map<String, String> extraParameters) {
        boolean z = false;
        for (Map.Entry<String, String> entry : extraParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.equals(parameter.get(key), value)) {
                parameter.put(key, value);
                z = true;
            }
        }
        if (z && sInited) {
            Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentManager.3
                @Override // java.lang.Runnable
                public void run() {
                    ExperimentManager.checkInitFuture();
                    ExperimentManager.experimentCache.refresh(ExperimentManager.parameter);
                }
            });
        }
    }

    public static void addExtraVids(Set<String> vids) {
        extraVids.addAll(vids);
    }

    public static Map<String, String> getExtraParameter() {
        return parameter;
    }

    public static boolean isInit() {
        return sInited;
    }

    public static boolean isRealInit() {
        return sRealInited;
    }

    public static void waitWhenNotInit() {
        waitWhenNotInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkInitFuture() {
        if (!(sInited | sHostInited) && waitWhenNotInit) {
            synchronized (sLock) {
                if (!(sInited | sHostInited)) {
                    try {
                        sLock.wait(GWorker.INTERVAL);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        if (initFuture == null) {
            throw new RuntimeException("ExperimentManager has not been init");
        }
        try {
            initFuture.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getExposureInfo(String key) {
        checkInitFuture();
        return experimentCache.getExposureInfo(key);
    }

    public static String getDebugInfo(String key) {
        checkInitFuture();
        return "local:" + hasLocalCache() + " function:" + getExperimentValueInfoCache.get(key) + " " + experimentCache.getAllExposureInfo();
    }

    public static void setDebugInfoCallback(IDebugInfoCallback callback) {
        debugInfoCallback = callback;
    }

    public static boolean hasLocalCache() {
        checkInitFuture();
        return experimentCache.hasLocalCache();
    }

    public static void refresh() {
        checkInitFuture();
        experimentCache.refresh(null);
    }

    public static void libraFirst(boolean first) {
        libraFirst = first;
    }

    public static <T> T getExperimentValue(String str, Type type, T t, boolean z, boolean z2, ClientDataSource<T> clientDataSource) {
        return (T) getExperimentValue(str, type, t, true, z, z2, false, clientDataSource);
    }

    public static <T> T getExperimentValue(String str, Type type, T t, boolean z, boolean z2) {
        return (T) getExperimentValue(str, type, t, true, z, z2, false, null);
    }

    public static <T> T getExperimentValue(String str, Type type, T t, boolean z, boolean z2, boolean z3, ClientDataSource<T> clientDataSource) {
        return (T) getExperimentValue(str, type, t, z, z2, z3, false, clientDataSource);
    }

    public static <T> T getExperimentValue(String str, Type type, T t, boolean z, boolean z2, boolean z3, boolean z4, ClientDataSource<T> clientDataSource) {
        Object value;
        Object value2;
        Object value3;
        checkInitFuture();
        if (z2) {
            Map<String, Object> map = stickyCache;
            if (map.containsKey(str) && map.get(str).getClass() == type) {
                if (z3) {
                    try {
                        experimentCache.exposureSticky(str);
                    } catch (Exception unused) {
                    }
                }
                return (T) returnValue(str, map.get(str), z2, "sticky", clientDataSource);
            }
        }
        if (!z) {
            return (T) returnValue(str, t, z2, "enable", clientDataSource);
        }
        Object panalValue = ExperimentPanel.getPanalValue(str, type);
        if (panalValue != null) {
            return (T) returnValue(str, panalValue, z2, "panel", clientDataSource);
        }
        if (libraFirst && (value3 = experimentCache.getValue(str, type, null, z3, z4)) != null) {
            return (T) returnValue(str, value3, z2, "libra", clientDataSource);
        }
        ISettings iSettings2 = iSettings;
        if (iSettings2 != null && (value2 = iSettings2.getValue(str, type, null)) != null) {
            return (T) returnValue(str, value2, z2, EventReport.SETTING, clientDataSource);
        }
        if (!libraFirst && (value = experimentCache.getValue(str, type, null, z3, z4)) != null) {
            return (T) returnValue(str, value, z2, "libra", clientDataSource);
        }
        Object value4 = experimentCache.getValue(str, clientDataSource, z3);
        if (value4 != null) {
            return (T) returnValue(str, value4, z2, "client", clientDataSource);
        }
        return (T) returnValue(str, t, z2, "default", clientDataSource);
    }

    public static <T> T getClientExperimentValue(String str, Type type, T t, boolean z, ClientDataSource<T> clientDataSource) {
        try {
            return (T) ClientExperimentManager.INSTANCE.getValue(str, type, t, z, clientDataSource);
        } catch (Exception e) {
            e.printStackTrace();
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T returnValue(String key, T value, boolean isSticky, String from, ClientDataSource<T> clientDataSource) {
        if (isSticky && value != null) {
            stickyCache.put(key, value);
        }
        getExperimentValueInfoCache.put(key, from);
        IDebugInfoCallback iDebugInfoCallback = debugInfoCallback;
        if (iDebugInfoCallback != null) {
            iDebugInfoCallback.debugCallback(key, value, from, getExposureInfo(key), clientDataSource == null ? null : clientDataSource.getClientVidlist());
        }
        return value;
    }

    public static void updateUserId(String userId) {
        if (sRealInited) {
            experimentCache.updateUserId(userId);
        } else {
            sInitUid = userId;
        }
    }

    public static String getUserVids(String uid) {
        checkInitFuture();
        return experimentCache.getUserVids(uid);
    }

    public static JSONObject getLibraExperimentCache() {
        checkInitFuture();
        if (experimentCache != null) {
            return experimentCache.getExperimentCache();
        }
        return null;
    }
}
