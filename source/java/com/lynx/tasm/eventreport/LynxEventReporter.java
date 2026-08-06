package com.lynx.tasm.eventreport;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.p001ui.image.TraceEventDef;
import com.lynx.tasm.service.ILynxEventReporterService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.ss.android.common.applog.AppLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxEventReporter {
    public static final int INSTANCE_ID_UNKNOWN = -1;
    public static final String LYNX_SDK_ERROR_EVENT = "lynxsdk_error_event";
    public static final String PROP_NAME_ENABLE_SSR = "enable_ssr";
    public static final String PROP_NAME_LYNX_SDK_VERSION = "lynx_sdk_version";
    public static final String PROP_NAME_RELATIVE_PATH = "relative_path";
    public static final String PROP_NAME_THREAD_MODE = "thread_mode";
    public static final String PROP_NAME_URL = "url";
    private static final String REMOVE_GENERIC_INFO = "LynxEventReporter::removeGenericInfo";
    private static final String TAG = "LynxEventReporter";
    private static final String UPDATE_GENERIC_INFO = "LynxEventReporter::updateGenericInfo";
    private HashMap<Integer, HashMap<String, Object>> mAllExtraParams;
    private HashMap<Integer, HashMap<String, Object>> mAllGenericInfos;
    private ILynxEventReportObserver mEventReporterService;
    private volatile boolean mIsNativeLibraryLoaded;
    private final CopyOnWriteArrayList<ILynxEventReportObserver> mObserverList;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface PropsBuilder {
        Map<String, Object> build();
    }

    private native void nativeRunOnReportThread(Object obj, long j);

    public static LynxEventReporter getInstance() {
        return LynxEventReporterSingletonHolder.sInstance;
    }

    public static void onEvent(final String str, final Map<String, Object> map, final int i) {
        if (str != null) {
            if (i >= 0 || map != null) {
                if (TraceEvent.isTracingStarted()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event_name", str);
                    hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
                    TraceEvent.beginSection("LynxEventReporter::OnEvent", hashMap);
                }
                runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        LynxEventReporter.getInstance().handleEvent(i, str, map);
                    }
                });
                TraceEvent.endSection("LynxEventReporter::OnEvent");
            }
        }
    }

    public static void onEvent(final String str, final int i, final PropsBuilder propsBuilder) {
        if (str != null) {
            if (i >= 0 || propsBuilder != null) {
                if (TraceEvent.isTracingStarted()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event_name", str);
                    hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
                    TraceEvent.beginSection("LynxEventReporter::OnEvent", hashMap);
                }
                runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        LynxEventReporter.lambda$onEvent$1(LynxEventReporter.PropsBuilder.this, i, str);
                    }
                });
                TraceEvent.endSection("LynxEventReporter::OnEvent");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onEvent$1(PropsBuilder propsBuilder, int i, String str) {
        Map<String, Object> build = propsBuilder != null ? propsBuilder.build() : null;
        if (i >= 0 || build != null) {
            getInstance().handleEvent(i, str, build);
        }
    }

    public static void updateGenericInfo(final String str, final Object obj, final int i) {
        if (str == null || obj == null || i < 0) {
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppLog.KEY_ENCRYPT_RESP_KEY, str);
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            hashMap.put("value", obj.toString());
            TraceEvent.beginSection(UPDATE_GENERIC_INFO, hashMap);
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$updateGenericInfo$2(i, str, obj);
            }
        });
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateGenericInfo$2(int i, String str, Object obj) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(i)).put(str, obj);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void updateGenericInfo(final Map<String, Object> map, final int i) {
        if (map == null || map.isEmpty() || i < 0) {
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
            TraceEvent.beginSection(UPDATE_GENERIC_INFO, hashMap);
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$updateGenericInfo$3(i, map);
            }
        });
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateGenericInfo$3(int i, Map map) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(i)).putAll(map);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void removeGenericInfo(final int i) {
        if (i < 0) {
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            TraceEvent.beginSection(REMOVE_GENERIC_INFO, hashMap);
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$removeGenericInfo$4(i);
            }
        });
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$removeGenericInfo$4(int i) {
        TraceEvent.beginSection(REMOVE_GENERIC_INFO);
        getInstance().mAllGenericInfos.remove(Integer.valueOf(i));
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    public static void putExtraParams(final Map<String, Object> map, final int i) {
        if (map == null || i < 0) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$putExtraParams$5(i, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$putExtraParams$5(int i, Map map) {
        LynxEventReporter lynxEventReporter = getInstance();
        HashMap<String, Object> hashMap = lynxEventReporter.mAllExtraParams.get(Integer.valueOf(i));
        if (hashMap == null) {
            lynxEventReporter.mAllExtraParams.put(Integer.valueOf(i), new HashMap<>(map));
        } else {
            hashMap.putAll(map);
        }
    }

    public static void moveExtraParams(final int i, final int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$moveExtraParams$6(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$moveExtraParams$6(int i, int i2) {
        LynxEventReporter lynxEventReporter = getInstance();
        HashMap<String, Object> hashMap = lynxEventReporter.mAllExtraParams.get(Integer.valueOf(i));
        if (hashMap != null) {
            HashMap<String, Object> hashMap2 = lynxEventReporter.mAllExtraParams.get(Integer.valueOf(i2));
            if (hashMap2 != null) {
                hashMap2.putAll(hashMap);
            } else {
                lynxEventReporter.mAllExtraParams.put(Integer.valueOf(i2), hashMap);
            }
            lynxEventReporter.mAllExtraParams.remove(Integer.valueOf(i));
        }
    }

    public static void clearCache(final int i) {
        if (i < 0) {
            return;
        }
        delayRunOnReportThread(new Runnable() { // from class: com.lynx.tasm.eventreport.LynxEventReporter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                LynxEventReporter.lambda$clearCache$7(i);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clearCache$7(int i) {
        LynxEventReporter lynxEventReporter = getInstance();
        lynxEventReporter.mAllGenericInfos.remove(Integer.valueOf(i));
        lynxEventReporter.mAllExtraParams.remove(Integer.valueOf(i));
    }

    public static void addObserver(ILynxEventReportObserver iLynxEventReportObserver) {
        getInstance().addObserverInternal(iLynxEventReportObserver);
    }

    private void addObserverInternal(ILynxEventReportObserver iLynxEventReportObserver) {
        if (iLynxEventReportObserver == null || this.mObserverList.contains(iLynxEventReportObserver)) {
            return;
        }
        this.mObserverList.add(iLynxEventReportObserver);
    }

    public static void removeObserver(ILynxEventReportObserver iLynxEventReportObserver) {
        getInstance().removeObserverInternal(iLynxEventReportObserver);
    }

    private void removeObserverInternal(ILynxEventReportObserver iLynxEventReportObserver) {
        if (iLynxEventReportObserver != null) {
            this.mObserverList.remove(iLynxEventReportObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEvent(int i, String str, Map<String, Object> map) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            hashMap.put("event_name", str);
            TraceEvent.beginSection("LynxEventReporter::handleEvent", hashMap);
        }
        if (str == null) {
            LLog.e(TAG, "event name is null.");
            TraceEvent.endSection("LynxEventReporter::handleEvent");
            return;
        }
        HashMap hashMap2 = new HashMap();
        HashMap<String, Object> hashMap3 = this.mAllGenericInfos.get(Integer.valueOf(i));
        if (hashMap3 != null) {
            hashMap2.putAll(hashMap3);
        }
        if (map != null) {
            hashMap2.putAll(map);
        }
        Map<String, ? extends Object> unmodifiableMap = Collections.unmodifiableMap(hashMap2);
        HashMap<String, Object> hashMap4 = this.mAllExtraParams.get(Integer.valueOf(i));
        Map<String, ? extends Object> unmodifiableMap2 = hashMap4 != null ? Collections.unmodifiableMap(hashMap4) : null;
        setupEventReporterServiceIfNeeded();
        Iterator<ILynxEventReportObserver> it = this.mObserverList.iterator();
        while (it.hasNext()) {
            it.next().onReportEvent(str, i, unmodifiableMap, unmodifiableMap2);
        }
        TraceEvent.endSection("LynxEventReporter::handleEvent");
    }

    private void setupEventReporterServiceIfNeeded() {
        if (this.mEventReporterService != null) {
            return;
        }
        ILynxEventReportObserver iLynxEventReportObserver = (ILynxEventReportObserver) LynxServiceCenter.inst().getService(ILynxEventReporterService.class);
        this.mEventReporterService = iLynxEventReportObserver;
        if (iLynxEventReportObserver == null) {
            LLog.e(TAG, "eventReporter service not found or event name is null.");
        } else {
            addObserverInternal(iLynxEventReportObserver);
        }
    }

    private static HashMap<String, Object> getGenericInfoInternal(Integer num) {
        HashMap<String, Object> hashMap = getInstance().mAllGenericInfos.get(num);
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put(PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        getInstance().mAllGenericInfos.put(num, hashMap2);
        return hashMap2;
    }

    public static HashMap<String, Object> getGenericInfoWithExtraParams(Integer num) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (num.intValue() < 0) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = getInstance().mAllExtraParams.get(num);
        if (hashMap2 != null) {
            hashMap.putAll(hashMap2);
        }
        HashMap<String, Object> genericInfoInternal = getGenericInfoInternal(num);
        if (genericInfoInternal != null) {
            hashMap.putAll(genericInfoInternal);
        }
        return hashMap;
    }

    public static void runOnReportThread(Runnable runnable) {
        if (!getInstance().mIsNativeLibraryLoaded) {
            getInstance().mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
        }
        if (getInstance().mIsNativeLibraryLoaded) {
            getInstance().nativeRunOnReportThread(runnable, 0L);
        }
    }

    public static void delayRunOnReportThread(Runnable runnable, long j) {
        if (!getInstance().mIsNativeLibraryLoaded) {
            getInstance().mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
        }
        if (getInstance().mIsNativeLibraryLoaded) {
            getInstance().nativeRunOnReportThread(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxEventReporterSingletonHolder {
        private static final LynxEventReporter sInstance = new LynxEventReporter();

        private LynxEventReporterSingletonHolder() {
        }
    }

    private LynxEventReporter() {
        this.mObserverList = new CopyOnWriteArrayList<>();
        this.mIsNativeLibraryLoaded = false;
        this.mAllGenericInfos = new HashMap<>();
        this.mAllExtraParams = new HashMap<>();
    }

    protected static void onEvent(int i, String str, ReadableMap readableMap) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            hashMap.put("event_name", str);
            TraceEvent.beginSection("LynxEventReporter::OnEvent", hashMap);
        }
        getInstance().handleEvent(i, str, readableMap.asHashMap());
        TraceEvent.endSection("LynxEventReporter::OnEvent");
    }

    protected static void updateGenericInfo(int i, ReadableMap readableMap) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(i));
            TraceEvent.beginSection(UPDATE_GENERIC_INFO, hashMap);
        }
        getGenericInfoInternal(Integer.valueOf(i)).putAll(readableMap.asHashMap());
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    protected static void callRunnable(Object obj) {
        if (obj instanceof Runnable) {
            ((Runnable) obj).run();
        } else {
            LLog.e(TAG, "runnable[" + (obj == null ? "null" : obj.getClass()) + "] must be an instance of Runnable.");
        }
    }
}
