package com.bytedance.android.monitor;

import android.app.Activity;
import android.app.Application;
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
import com.bytedance.android.monitor.base.IExceptionHandler;
import com.bytedance.android.monitor.base.IReportInterceptor;
import com.bytedance.android.monitor.debug.MonitorDebugConfig;
import com.bytedance.android.monitor.entity.CustomInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.setting.DefaultSettingManager;
import com.bytedance.android.monitor.setting.ISettingManager;
import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.android.monitor.util.MonitorUtils;
import com.bytedance.android.monitor.util.ReflectUtils;
import com.bytedance.android.monitor.util.TouchUtil;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HybridMonitor {
    private static volatile HybridMonitor instance;
    private Application application;
    private IExceptionHandler exceptionHandler;
    private List<IReportInterceptor> interceptorList;
    private ISettingManager settingManager;
    private TouchTraceCallback touchTraceCallback;
    private boolean isInitialized = false;
    private boolean isRegisterTouchCallback = false;
    private CustomMonitor normalCustomMonitor = new CustomMonitor();
    public boolean AB_TEST = false;

    public static HybridMonitor getInstance() {
        if (instance == null) {
            synchronized (HybridMonitor.class) {
                if (instance == null) {
                    instance = new HybridMonitor();
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
            registerTouchCallback();
        }
        initComponent();
        initFileRecord();
        initDebugEnvir();
    }

    public void registerTouchCallback() {
        if (this.application == null || this.isRegisterTouchCallback) {
            return;
        }
        TouchTraceCallback touchTraceCallback = new TouchTraceCallback();
        this.touchTraceCallback = touchTraceCallback;
        this.application.registerActivityLifecycleCallbacks(touchTraceCallback);
        this.isRegisterTouchCallback = true;
    }

    public void initSetting(ISettingManager iSettingManager) {
        if (iSettingManager != null) {
            this.settingManager = iSettingManager;
            try {
                iSettingManager.init(this.application);
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
    }

    public ISettingManager getSettingManager() {
        ISettingManager iSettingManager = this.settingManager;
        return iSettingManager != null ? iSettingManager : DefaultSettingManager.getInstance();
    }

    public void clearSetting() {
        ISettingManager iSettingManager = this.settingManager;
        if (iSettingManager != null) {
            iSettingManager.reset();
            this.settingManager = null;
        }
    }

    private void initFileRecord() {
        registerReportInterceptor(new IReportInterceptor() { // from class: com.bytedance.android.monitor.HybridMonitor.1
            @Override // com.bytedance.android.monitor.base.IReportInterceptor
            public void onReport(String str, String str2, String str3, JSONObject jSONObject) {
                if (HybridMonitor.isOutputFile()) {
                    MonitorUtils.outputFile(str2, jSONObject);
                }
            }
        });
    }

    private void initDebugEnvir() {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.HybridMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                MonitorDebugConfig.init(HybridMonitor.this.getApplication());
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

    public void setCustomReportMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        this.normalCustomMonitor.setMonitor(iTTLiveWebViewMonitor);
    }

    public ITTLiveWebViewMonitor getCustomReportMonitor() {
        return this.normalCustomMonitor.getMonitor();
    }

    @Deprecated
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        this.normalCustomMonitor.report(str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, z);
    }

    @Deprecated
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z, ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        this.normalCustomMonitor.report(str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, z, iTTLiveWebViewMonitor);
    }

    public void customReport(CustomInfo customInfo) {
        this.normalCustomMonitor.report(customInfo);
    }

    private void initComponent() {
        injectWebOffline();
        injectFalconX();
    }

    private void injectWebOffline() {
        MonitorExecutor.INSTANCE.getExecutor().execute(new Runnable() { // from class: com.bytedance.android.monitor.HybridMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Class<?> cls = Class.forName("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");
                    ReflectUtils.invokeMethod(cls, "beginMonitor", ReflectUtils.invokeMethod(cls, "getInstance", new Object[0]));
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    private void injectFalconX() {
        MonitorExecutor.INSTANCE.getExecutor().execute(new Runnable() { // from class: com.bytedance.android.monitor.HybridMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Class<?> cls = Class.forName("com.bytedance.webx.monitor.falconx.FalconXMonitor");
                    ReflectUtils.invokeMethod(cls, "beginMonitor", ReflectUtils.invokeMethod(cls, "getInstance", new Object[0]));
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
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
                iReportInterceptor.onReport(str, str2, str3, jSONObject);
            }
        }
    }

    public void registerDisableReportInfo(String str, List<String> list) {
        DisableListDataManager.get().registerDisableReportInfo(str, list);
    }

    public void clearDisableReportInfo(String str) {
        DisableListDataManager.get().clear(str);
    }

    public void DisableReportInfo() {
        DisableListDataManager.get().clearAll();
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

    public void setAbTestEnable(boolean z) {
        this.AB_TEST = z;
    }

    public boolean isAbTestEnable() {
        return this.AB_TEST;
    }
}
