package com.bytedance.android.monitorV2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.monitorV2.base.IExceptionHandler;
import com.bytedance.android.monitorV2.base.IReportInterceptor;
import com.bytedance.android.monitorV2.checker.ApmReportChecker;
import com.bytedance.android.monitorV2.checker.EventChecker;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.debug.MonitorDebugConfig;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.hybridSetting.DefaultHybridSettingManager;
import com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImpl;
import com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2;
import com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager;
import com.bytedance.android.monitorV2.hybridSetting.JsonOptConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.lifecycle.MonitorLifecycleManager;
import com.bytedance.android.monitorV2.listener.EventDebugTools;
import com.bytedance.android.monitorV2.listener.IBusinessEventListener;
import com.bytedance.android.monitorV2.listener.IHybridEventListener;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.standard.ContainerType;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.MonitorUtils;
import com.bytedance.android.monitorV2.util.PackageUtils;
import com.bytedance.android.monitorV2.util.ReflectUtils;
import com.bytedance.android.monitorV2.util.TouchUtil;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.apm.ApmContext;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.salamander.anniex.ISLMonitorReportListener;
import com.bytedance.salamander.anniex.SLAnnieXMonitorManager;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HybridMultiMonitor {
    private static final String TAG = "HybridMultiMonitor";
    private static volatile HybridMultiMonitor instance;
    private volatile Application application;
    private DebugSpListener debugSpListener;
    private IExceptionHandler exceptionHandler;
    private IHybridSettingManager hybridSettingManager;
    private List<IReportInterceptor> interceptorList;
    private ISLMonitorReportListener slMonitorReportListener;
    private TouchTraceCallback touchTraceCallback;
    private boolean isInitialized = false;
    private boolean isRegisterTouchCallback = false;
    private CustomMonitor normalCustomMonitor = new CustomMonitor();
    private List<IHybridEventListener> eventListenerList = EventChecker.INSTANCE.getEventListenerList();
    private List<IBusinessEventListener> businessListenerList = EventChecker.INSTANCE.getBusinessEventListener();

    public static HybridMultiMonitor getInstance() {
        if (instance == null) {
            synchronized (HybridMultiMonitor.class) {
                if (instance == null) {
                    instance = new HybridMultiMonitor();
                }
            }
        }
        return instance;
    }

    public void init(Application application) {
        init(application, true);
    }

    public void init(Application application, boolean z) {
        if (application == null || this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        this.application = application;
        if (z) {
            try {
                registerTouchCallback();
            } catch (Throwable th) {
                ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
                return;
            }
        }
        MonitorLog.m29i(TAG, "init sdkinfo: 9.0.0, " + AnnieXMonitorConstants.INSTANCE.getANNIEX_VERSION_CODE() + ", " + AnnieX.isDebug());
        MonitorLog.m29i(TAG, "init hostinfo: " + PackageUtils.getVersionName() + ", " + PackageUtils.getVersionCode());
        initComponent();
        initFileRecord();
        initDebugEnvir();
    }

    public void registerTouchCallback() {
        if (this.application == null || this.isRegisterTouchCallback) {
            return;
        }
        this.touchTraceCallback = new TouchTraceCallback();
        this.application.registerActivityLifecycleCallbacks(this.touchTraceCallback);
        this.application.registerActivityLifecycleCallbacks(MonitorLifecycleManager.INSTANCE);
        this.isRegisterTouchCallback = true;
    }

    public void setConfig(HybridSettingInitConfig hybridSettingInitConfig) {
        setConfig(hybridSettingInitConfig, false);
    }

    public void setConfig(HybridSettingInitConfig hybridSettingInitConfig, boolean z) {
        IHybridSettingManager hybridSettingManagerImpl;
        if (JsonOptConfig.isJsonOptEnable()) {
            if (HybridSettingManagerImplV2.INSTANCE.isInitialized().get()) {
                return;
            } else {
                hybridSettingManagerImpl = new HybridSettingManagerImplV2(hybridSettingInitConfig);
            }
        } else {
            hybridSettingManagerImpl = new HybridSettingManagerImpl(hybridSettingInitConfig);
        }
        initHybridSetting(hybridSettingManagerImpl, z);
        initEventConsumer(hybridSettingInitConfig);
        initInternalMonitor(this.application, hybridSettingInitConfig);
    }

    private void initEventConsumer(final HybridSettingInitConfig hybridSettingInitConfig) {
        try {
            HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.HybridMultiMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    SharedPreferences sharedPreferences;
                    ValidationReport.INSTANCE.setInitConfig(hybridSettingInitConfig);
                    if (HybridMultiMonitor.this.application == null || (sharedPreferences = HybridMultiMonitor.this.application.getSharedPreferences(MonitorGlobalSp.MONITOR_DEBUG_SP, 4)) == null) {
                        return;
                    }
                    HybridMultiMonitor.this.debugSpListener = new DebugSpListener();
                    sharedPreferences.registerOnSharedPreferenceChangeListener(HybridMultiMonitor.this.debugSpListener);
                    MonitorDebugConfig.setSampleOff(sharedPreferences.getBoolean(MonitorDebugConfig.SP_KEY_HDT_SAMPLE, false));
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
    }

    private void initInternalMonitor(Context context, HybridSettingInitConfig hybridSettingInitConfig) {
        if (context == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", hybridSettingInitConfig.getDeviceId());
            jSONObject.put("host_aid", hybridSettingInitConfig.getAid());
            jSONObject.put("sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
            jSONObject.put("channel", hybridSettingInitConfig.getChannel());
            jSONObject.put("app_version", hybridSettingInitConfig.getVersionCode());
            jSONObject.put("update_version_code", hybridSettingInitConfig.getUpdateVersionCode());
        } catch (JSONException e) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, e);
        }
        if (hybridSettingInitConfig.getConfigUrls() != null) {
            SDKMonitorUtils.setConfigUrl(InternalWatcher.INTERNAL_AID, hybridSettingInitConfig.getConfigUrls());
        }
        if (hybridSettingInitConfig.getDefaultReportUrls() != null) {
            SDKMonitorUtils.setDefaultReportUrl(InternalWatcher.INTERNAL_AID, hybridSettingInitConfig.getDefaultReportUrls());
        }
        SDKMonitorUtils.initMonitor(context.getApplicationContext(), InternalWatcher.INTERNAL_AID, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.android.monitorV2.HybridMultiMonitor.2
            public Map<String, String> getCommonParams() {
                return null;
            }

            public String getSessionId() {
                return null;
            }
        });
    }

    private void initHybridSetting(IHybridSettingManager iHybridSettingManager, boolean z) {
        if (iHybridSettingManager != null) {
            this.hybridSettingManager = iHybridSettingManager;
            try {
                iHybridSettingManager.init(this.application, z);
            } catch (Throwable th) {
                ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            }
        }
    }

    public void updateSampleConfigsFromNet() {
        IHybridSettingManager iHybridSettingManager = this.hybridSettingManager;
        if (iHybridSettingManager != null) {
            iHybridSettingManager.loopUpdate();
        }
    }

    public IHybridSettingManager getHybridSettingManager() {
        IHybridSettingManager iHybridSettingManager = this.hybridSettingManager;
        return iHybridSettingManager != null ? iHybridSettingManager : DefaultHybridSettingManager.getInstance();
    }

    private void initFileRecord() {
        registerReportInterceptor(new IReportInterceptor() { // from class: com.bytedance.android.monitorV2.HybridMultiMonitor.3
            @Override // com.bytedance.android.monitorV2.base.IReportInterceptor
            public void onReport(String str, String str2, String str3, JSONObject jSONObject) {
                if (HybridMultiMonitor.isOutputFile()) {
                    MonitorLog.m29i(HybridMultiMonitor.TAG, "fileRecord, outputFile: " + HybridMultiMonitor.isOutputFile() + ", service: " + str + ", eventType: " + str2);
                    MonitorUtils.outputFile(str2, jSONObject);
                }
            }
        });
    }

    private void initDebugEnvir() {
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.HybridMultiMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                MonitorDebugConfig.init(HybridMultiMonitor.this.getApplication());
            }
        });
    }

    public Application getApplication() {
        return this.application;
    }

    public void wrapTouchTraceCallback(Activity activity) {
        TouchTraceCallback touchTraceCallback;
        if (activity == null || !this.isRegisterTouchCallback || (touchTraceCallback = this.touchTraceCallback) == null) {
            return;
        }
        touchTraceCallback.wrapWindowCallback(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class TouchTraceCallback implements Application.ActivityLifecycleCallbacks {
        private Set<Integer> traceSet;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        private TouchTraceCallback() {
            this.traceSet = new HashSet();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            wrapWindowCallback(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            wrapWindowCallback(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            removeTrace(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wrapWindowCallback(Activity activity) {
            try {
                if (isNeedWrap(activity)) {
                    this.traceSet.add(Integer.valueOf(activity.hashCode()));
                    Window window = activity.getWindow();
                    window.setCallback(new TouchWindowCallback(window.getCallback()));
                }
            } catch (Exception e) {
                ExceptionUtil.handleException(e);
            }
        }

        private void removeTrace(Activity activity) {
            this.traceSet.remove(Integer.valueOf(activity.hashCode()));
        }

        private boolean isNeedWrap(Activity activity) {
            if (activity == null) {
                return false;
            }
            return !this.traceSet.contains(Integer.valueOf(activity.hashCode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class TouchWindowCallback implements Window.Callback {
        private Window.Callback callback;

        private TouchWindowCallback(Window.Callback callback) {
            this.callback = callback;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.callback.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return this.callback.dispatchKeyShortcutEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            TouchUtil.touch(motionEvent);
            return this.callback.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.callback.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.callback.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return this.callback.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            return this.callback.onCreatePanelMenu(i, menu);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            return this.callback.onPreparePanel(i, view, menu);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            return this.callback.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.callback.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.callback.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            this.callback.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean z) {
            this.callback.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            this.callback.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            this.callback.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            this.callback.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            return this.callback.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent searchEvent) {
            return this.callback.onSearchRequested(searchEvent);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.callback.onWindowStartingActionMode(callback);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return this.callback.onWindowStartingActionMode(callback, i);
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode actionMode) {
            this.callback.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode actionMode) {
            this.callback.onActionModeFinished(actionMode);
        }
    }

    @Deprecated
    public void setCustomReportMonitor(IHybridMonitor iHybridMonitor) {
        MonitorLog.m27e(TAG, "Deprecated method");
        this.normalCustomMonitor.setMonitor(iHybridMonitor);
    }

    @Deprecated
    public IHybridMonitor getCustomReportMonitor() {
        return this.normalCustomMonitor.getMonitor();
    }

    @Deprecated
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i) {
        customReport(str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, i, null);
    }

    @Deprecated
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i, IHybridMonitor iHybridMonitor) {
        customReport(new CustomInfo.Builder(str3).setUrl(str).setBid(str2).setCategory(jSONObject).setMetric(jSONObject2).setExtra(jSONObject3).setBidInfo(new JSONObject()).setCommon(jSONObject4).setSample(i).build());
    }

    public void customReport(CustomInfo customInfo) {
        if (disableCustomReport3450()) {
            return;
        }
        if (customInfo.getMonitorId() == null || ContainerDataCache.INSTANCE.getAttachedView(customInfo.getMonitorId()) == null) {
            DataReporter.INSTANCE.reportCustomEvent(new CustomEvent(customInfo), true);
            return;
        }
        ContainerType attachedView = ContainerDataCache.INSTANCE.getAttachedView(customInfo.getMonitorId());
        if (attachedView != null) {
            String type = attachedView.getType();
            if (type.equals("web")) {
                WebViewMonitorHelper.getInstance().customReport(attachedView.getContainer(), customInfo);
            } else if (type.equals("lynx")) {
                LynxViewMonitor.INSTANCE.getINSTANCE().customReport(attachedView.getContainer(), customInfo);
            }
        }
    }

    private boolean disableCustomReport3450() {
        return !IConditionCallKt.enableHybridMultiCustomReport();
    }

    private void initComponent() {
        HybridMonitorExecutor.INSTANCE.getExecutor().execute(new Runnable() { // from class: com.bytedance.android.monitorV2.HybridMultiMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HybridMultiMonitor.this.m13xdba03288();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initComponent$0$com-bytedance-android-monitorV2-HybridMultiMonitor */
    public /* synthetic */ void m13xdba03288() {
        injectWebOffline();
        injectFalconX();
        injectForest();
    }

    private void injectWebOffline() {
        try {
            Class<?> cls = Class.forName("com.bytedance.webx.monitor.weboffline.NewWebOfflineMonitor");
            ReflectUtils.invokeMethod(cls, "beginMonitor", ReflectUtils.invokeMethod(cls, "getInstance", new Object[0]));
        } catch (ClassNotFoundException unused) {
            MonitorLog.m29i(TAG, "Not Found NewWebOfflineMonitor");
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
    }

    private void injectFalconX() {
        try {
            Class<?> cls = Class.forName("com.bytedance.webx.monitor.falconx.NewFalconXMonitor");
            ReflectUtils.invokeMethod(cls, "beginMonitor", ReflectUtils.invokeMethod(cls, "getInstance", new Object[0]));
        } catch (ClassNotFoundException unused) {
            MonitorLog.m29i(TAG, "Not Found NewFalconXMonitor");
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
    }

    private void injectForest() {
        try {
            Class<?> cls = Class.forName("com.bytedance.android.monitorV2.forest.ForestMonitorHelper");
            ReflectUtils.invokeMethod(cls, "startMonitor", ReflectUtils.getStaticFieldValue(cls, "INSTANCE"));
        } catch (ClassNotFoundException unused) {
            MonitorLog.m29i(TAG, "Not Found ForestMonitorHelper");
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
    }

    public void registerReportInterceptor(IReportInterceptor iReportInterceptor) {
        if (iReportInterceptor == null) {
            return;
        }
        if (this.interceptorList == null) {
            this.interceptorList = new CopyOnWriteArrayList();
        }
        this.interceptorList.add(iReportInterceptor);
    }

    public void unregisterReportInterceptor(IReportInterceptor iReportInterceptor) {
        List<IReportInterceptor> list;
        if (iReportInterceptor == null || (list = this.interceptorList) == null || list.size() == 0) {
            return;
        }
        this.interceptorList.remove(iReportInterceptor);
    }

    public void notifyReportInterceptor(String str, String str2, String str3, JSONObject jSONObject) {
        List<IReportInterceptor> list = this.interceptorList;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (IReportInterceptor iReportInterceptor : this.interceptorList) {
            if (iReportInterceptor != null) {
                try {
                    iReportInterceptor.onReport(str, str2, str3, jSONObject);
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
        }
    }

    public void setExceptionHandler(IExceptionHandler iExceptionHandler) {
        this.exceptionHandler = iExceptionHandler;
    }

    public IExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public static void setDebuggable(boolean z) {
        MonitorDebugConfig.setDebuggable(z);
    }

    public static void setDebuggable(boolean z, boolean z2) {
        MonitorDebugConfig.setDebuggable(z, z2);
    }

    public static boolean isDebuggable() {
        return MonitorDebugConfig.isDebuggable();
    }

    public static void setOutputFile(boolean z) {
        MonitorDebugConfig.setOutputFile(z);
    }

    public static void setOutputFile(boolean z, boolean z2) {
        MonitorDebugConfig.setOutputFile(z, z2);
    }

    public static boolean isOutputFile() {
        return MonitorDebugConfig.isOutputFile();
    }

    public void registerSLListener(ISLMonitorReportListener iSLMonitorReportListener) {
        this.slMonitorReportListener = iSLMonitorReportListener;
    }

    public void registerHybridEventListener(IHybridEventListener iHybridEventListener) {
        if (iHybridEventListener == null) {
            return;
        }
        synchronized (iHybridEventListener) {
            this.eventListenerList.add(iHybridEventListener);
        }
    }

    public void unregisterHybridEventListener(IHybridEventListener iHybridEventListener) {
        List<IHybridEventListener> list;
        if (iHybridEventListener == null || (list = this.eventListenerList) == null || list.size() == 0) {
            return;
        }
        synchronized (iHybridEventListener) {
            this.eventListenerList.remove(iHybridEventListener);
        }
    }

    public void registerBusinessEventListener(IBusinessEventListener iBusinessEventListener) {
        if (iBusinessEventListener == null) {
            return;
        }
        synchronized (iBusinessEventListener) {
            this.businessListenerList.add(iBusinessEventListener);
        }
    }

    public void unregisterBusinessEventListener(IBusinessEventListener iBusinessEventListener) {
        List<IBusinessEventListener> list;
        if (iBusinessEventListener == null || (list = this.businessListenerList) == null || list.size() == 0) {
            return;
        }
        synchronized (iBusinessEventListener) {
            this.businessListenerList.remove(iBusinessEventListener);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class DebugSpListener implements SharedPreferences.OnSharedPreferenceChangeListener {
        private final IHybridEventListener listener;

        private DebugSpListener() {
            this.listener = new EventDebugTools();
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (sharedPreferences.getBoolean(MonitorDebugConfig.SP_KEY_HDT_VALIDATION, false)) {
                HybridMultiMonitor.this.unregisterHybridEventListener(this.listener);
                HybridMultiMonitor.this.registerHybridEventListener(this.listener);
                if (HybridMultiMonitor.this.slMonitorReportListener != null) {
                    SLAnnieXMonitorManager.Companion.getInstance().unregisterReportListener(HybridMultiMonitor.this.slMonitorReportListener);
                    SLAnnieXMonitorManager.Companion.getInstance().registerReportListener(HybridMultiMonitor.this.slMonitorReportListener);
                }
                ApmContext.setDebugMode(true);
            } else {
                HybridMultiMonitor.this.unregisterHybridEventListener(this.listener);
                if (HybridMultiMonitor.this.slMonitorReportListener != null) {
                    SLAnnieXMonitorManager.Companion.getInstance().unregisterReportListener(HybridMultiMonitor.this.slMonitorReportListener);
                }
                ApmContext.setDebugMode(false);
            }
            ApmReportChecker.INSTANCE.setImmediateReport(sharedPreferences.getBoolean(MonitorDebugConfig.SP_KEY_HDT_IMMEDIATE, false));
            MonitorDebugConfig.setSampleOff(sharedPreferences.getBoolean(MonitorDebugConfig.SP_KEY_HDT_SAMPLE, false));
            MonitorDebugConfig.setSkipWhiteListInjectCheck(sharedPreferences.getBoolean(MonitorDebugConfig.SP_KEY_HDT_SKIP_INJECT_CHECK, false));
        }
    }
}
