package com.lynx.tasm;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.JSModule;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.RuntimeLifecycleListener;
import com.lynx.jsbridge.network.LynxFetchModuleEventSender;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.CleanupReference;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.component.DynamicComponentFetcher;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxBackgroundRuntime implements ILynxErrorReceiver {
    public static final int STATE_ATTACHED = 4;
    public static final int STATE_DESTROYED = 2;
    public static final int STATE_INVALID = 8;
    public static final int STATE_START = 0;
    private static final String TAG = "LynxBackgroundRuntime";
    private CleanupReference mCleanupReference;
    private LynxDevtool mDevTool;
    private long mInspectorObserverPtr;
    private JSProxy mJSProxy;
    private volatile String mLastScriptUrl;
    private LynxModuleFactory mModuleFactory;
    private long mNativePtr;
    private LynxBackgroundRuntimeOptions mOptions;
    private Map<Double, PlatformCallBack> mPlatformCallBackMap;
    private LynxResourceLoader mResourceLoader;
    private CopyOnWriteArrayList<LynxBackgroundRuntimeClient> mRuntimeClients;
    private int mState;
    private final Object mStateLock;

    private native long nativeCreateBackgroundRuntimeWrapper(LynxResourceLoader lynxResourceLoader, LynxModuleFactory lynxModuleFactory, long j, long j2, String str, String str2, String[] strArr, String str3, int i, long j3, boolean z);

    private native void nativeDestroyRuntime(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroyWrapper(long j);

    private native void nativeEvaluateScript(long j, String str, byte[] bArr);

    private native void nativeEvaluateTemplateBundle(long j, String str, long j2, String str2);

    private native void nativeGetSessionStorageItem(long j, String str, PlatformCallBack platformCallBack);

    private native void nativeSetPresetData(long j, boolean z, long j2);

    private native void nativeSetSessionStorageItem(long j, String str, long j2, boolean z);

    private native double nativeSubscribeSessionStorage(long j, String str, PlatformCallBack platformCallBack);

    private native void nativeTransitionToFullRuntime(long j);

    private native void nativeUnsubscribeSessionStorage(long j, String str, double d);

    public LynxBackgroundRuntime(Context context, LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions) {
        this(context, lynxBackgroundRuntimeOptions, false);
    }

    public LynxBackgroundRuntime(Context context, LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions, boolean z) {
        this.mCleanupReference = null;
        this.mNativePtr = 0L;
        this.mInspectorObserverPtr = 0L;
        this.mLastScriptUrl = "";
        this.mStateLock = new Object();
        this.mRuntimeClients = new CopyOnWriteArrayList<>();
        this.mPlatformCallBackMap = new HashMap();
        if (!LynxEnv.inst().isNativeLibraryLoaded()) {
            LLog.m2577e(TAG, "LynxBackgroundRuntime constructor called before LynxEnv init");
            this.mState = 8;
            return;
        }
        this.mState = 0;
        this.mOptions = lynxBackgroundRuntimeOptions;
        this.mModuleFactory = new LynxModuleFactory(context);
        LynxFetchModuleEventSender lynxFetchModuleEventSender = new LynxFetchModuleEventSender();
        lynxFetchModuleEventSender.setWeakRuntime(this);
        this.mModuleFactory.registerModule(LynxFetchModule.NAME, LynxFetchModule.class, lynxFetchModuleEventSender);
        this.mModuleFactory.addModuleParamWrapper(lynxBackgroundRuntimeOptions.getWrappers());
        this.mModuleFactory.registerModuleAuthValidator(lynxBackgroundRuntimeOptions.getModuleAuthValidator());
        if (LynxEnv.inst().isLynxDebugEnabled()) {
            initDevtool(context, z);
        }
        LynxGroup lynxGroup = lynxBackgroundRuntimeOptions.getLynxGroup();
        String id = lynxGroup != null ? lynxGroup.getID() : LynxGroup.SINGNLE_GROUP;
        String[] preloadJSPaths = lynxGroup != null ? lynxGroup.getPreloadJSPaths() : null;
        boolean z2 = lynxGroup != null && lynxGroup.enableJSGroupThread();
        String str = z2 ? id : "";
        this.mResourceLoader = new LynxResourceLoader(lynxBackgroundRuntimeOptions, (DynamicComponentFetcher) null, this, lynxBackgroundRuntimeOptions.templateResourceFetcher, lynxBackgroundRuntimeOptions.genericResourceFetcher);
        long whiteBoardPtr = lynxGroup == null ? 0L : lynxGroup.getWhiteBoardPtr();
        int calcRuntimeFlags = LynxBackgroundRuntimeOptions.calcRuntimeFlags(false, lynxBackgroundRuntimeOptions.useQuickJSEngine(), false, lynxBackgroundRuntimeOptions.isEnableUserBytecode(), Boolean.valueOf(z2), Boolean.valueOf(lynxBackgroundRuntimeOptions.isPendingCoreJsLoad()));
        TemplateData globalProps = lynxBackgroundRuntimeOptions.getGlobalProps();
        this.mNativePtr = nativeCreateBackgroundRuntimeWrapper(this.mResourceLoader, this.mModuleFactory, this.mInspectorObserverPtr, whiteBoardPtr, id, str, preloadJSPaths, lynxBackgroundRuntimeOptions.getBytecodeSourceUrl(), calcRuntimeFlags, globalProps != null ? globalProps.getNativePtr() : 0L, z);
        this.mInspectorObserverPtr = 0L;
        TemplateData presetData = lynxBackgroundRuntimeOptions.getPresetData();
        if (presetData != null) {
            nativeSetPresetData(this.mNativePtr, presetData.isReadOnly(), presetData.getNativePtr());
        }
        this.mJSProxy = new JSProxy(this, str);
        this.mCleanupReference = new CleanupReference(this, new CleanupOnUiThread(this.mNativePtr, this.mJSProxy), true);
    }

    public void addLynxBackgroundRuntimeClient(LynxBackgroundRuntimeClient lynxBackgroundRuntimeClient) {
        if (this.mRuntimeClients.contains(lynxBackgroundRuntimeClient)) {
            return;
        }
        this.mRuntimeClients.add(lynxBackgroundRuntimeClient);
    }

    public void removeLynxBackgroundRuntimeClient(LynxBackgroundRuntimeClient lynxBackgroundRuntimeClient) {
        if (this.mRuntimeClients.contains(lynxBackgroundRuntimeClient)) {
            this.mRuntimeClients.remove(lynxBackgroundRuntimeClient);
        }
    }

    public void evaluateJavaScript(String str, String str2) {
        LynxDevtool lynxDevtool;
        synchronized (this.mStateLock) {
            if (this.mState == 0 && (lynxDevtool = this.mDevTool) != null) {
                lynxDevtool.attachToDebugBridge(str);
                this.mDevTool.onLoadFromURL(str, "", null, null, null);
            }
        }
        if (this.mNativePtr != 0) {
            this.mLastScriptUrl = str;
            nativeEvaluateScript(this.mNativePtr, str, str2.getBytes(Charset.forName(Utf8Charset.NAME)));
        }
    }

    public void evaluateTemplateBundle(String str, TemplateBundle templateBundle, String str2) {
        LynxDevtool lynxDevtool;
        synchronized (this.mStateLock) {
            if (this.mState == 0 && (lynxDevtool = this.mDevTool) != null) {
                lynxDevtool.attachToDebugBridge(str);
                this.mDevTool.onLoadFromURL(str, "", null, null, null);
            }
        }
        if (this.mNativePtr == 0 || !templateBundle.isValid()) {
            return;
        }
        this.mLastScriptUrl = str;
        nativeEvaluateTemplateBundle(this.mNativePtr, str, templateBundle.getNativePtr(), str2);
    }

    public void callFunction(String str, String str2, JavaOnlyArray javaOnlyArray) {
        LLog.m2578i(TAG, "LynxContext callFunction, module: " + str + ", method: " + str2);
        this.mJSProxy.callFunction(str, str2, javaOnlyArray);
    }

    public String getLastScriptUrl() {
        return this.mLastScriptUrl;
    }

    public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        LLog.m2578i(TAG, "LynxContext sendGlobalEvent " + str + " with this: " + toString());
        JSModule jSModule = this.mJSProxy.getJSModule("GlobalEventEmitter");
        JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
        javaOnlyArray2.pushString(str);
        javaOnlyArray2.pushArray(javaOnlyArray);
        jSModule.fire("emit", javaOnlyArray2);
    }

    public void destroy() {
        synchronized (this.mStateLock) {
            if (this.mState != 0) {
                LLog.m2577e(TAG, "call destroy on invalid state, will be ignored, state: " + this.mState);
                return;
            }
            LynxDevtool lynxDevtool = this.mDevTool;
            if (lynxDevtool != null) {
                lynxDevtool.destroy();
                this.mDevTool = null;
            }
            nativeDestroyRuntime(this.mNativePtr);
            this.mState = 2;
        }
    }

    public int getState() {
        int i;
        synchronized (this.mStateLock) {
            i = this.mState;
        }
        return i;
    }

    public void setSessionStorageItem(String str, TemplateData templateData) {
        if (this.mNativePtr == 0 || templateData == null || TextUtils.isEmpty(str)) {
            return;
        }
        LLog.m2576d(TAG, "setSessionStorageItem with key: " + str);
        templateData.flush();
        if (templateData.getNativePtr() == 0) {
            LLog.m2577e(TAG, "setSessionStorageItem with zero data! key: " + str);
        } else {
            nativeSetSessionStorageItem(this.mNativePtr, str, templateData.getNativePtr(), templateData.isReadOnly());
        }
    }

    public void getSessionStorageItem(String str, PlatformCallBack platformCallBack) {
        if (this.mNativePtr == 0 || platformCallBack == null || TextUtils.isEmpty(str)) {
            return;
        }
        LLog.m2576d(TAG, "getSessionStorageItem with key: " + str);
        nativeGetSessionStorageItem(this.mNativePtr, str, platformCallBack);
    }

    public double subscribeSessionStorage(String str, PlatformCallBack platformCallBack) {
        if (this.mNativePtr == 0 || platformCallBack == null || TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        LLog.m2576d(TAG, "subscribeSessionStorage with key: " + str);
        double nativeSubscribeSessionStorage = nativeSubscribeSessionStorage(this.mNativePtr, str, platformCallBack);
        this.mPlatformCallBackMap.put(Double.valueOf(nativeSubscribeSessionStorage), platformCallBack);
        return nativeSubscribeSessionStorage;
    }

    public void unsubscribeSessionStorage(String str, double d) {
        if (this.mNativePtr == 0 || -1.0d == d || TextUtils.isEmpty(str)) {
            return;
        }
        nativeUnsubscribeSessionStorage(this.mNativePtr, str, d);
        this.mPlatformCallBackMap.remove(Double.valueOf(d));
    }

    @Override // com.lynx.tasm.ILynxErrorReceiver
    public void onErrorOccurred(LynxError lynxError) {
        Iterator<LynxBackgroundRuntimeClient> it = this.mRuntimeClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(lynxError);
        }
    }

    public void onModuleMethodInvoked(String str, String str2, int i) {
        Iterator<LynxBackgroundRuntimeClient> it = this.mRuntimeClients.iterator();
        while (it.hasNext()) {
            it.next().onModuleMethodInvoked(str, str2, i);
        }
    }

    public void onEvaluateJavaScriptEnd(String str) {
        Iterator<LynxBackgroundRuntimeClient> it = this.mRuntimeClients.iterator();
        while (it.hasNext()) {
            it.next().onEvaluateJavaScriptEnd(str);
        }
    }

    public boolean attachToLynxView() {
        synchronized (this.mStateLock) {
            if (this.mState != 0) {
                LLog.m2577e(TAG, "build LynxView using an invalid LynxBackgroundRuntime, state: " + this.mState + ", runtime: " + this);
                return false;
            }
            this.mState = 4;
            return true;
        }
    }

    public LynxModuleFactory getModuleFactory() {
        return this.mModuleFactory;
    }

    public LynxBackgroundRuntimeOptions getLynxRuntimeOptions() {
        return this.mOptions;
    }

    public LynxDevtool getDevtool() {
        return this.mDevTool;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    private void initDevtool(Context context, boolean z) {
        this.mDevTool = new LynxDevtool(context, z);
        LynxGroup lynxGroup = this.mOptions.getLynxGroup();
        String id = lynxGroup != null ? lynxGroup.getID() : LynxGroup.SINGNLE_GROUP;
        boolean z2 = lynxGroup != null && lynxGroup.enableJSGroupThread();
        LynxDevtool lynxDevtool = this.mDevTool;
        if (!z2) {
            id = "";
        }
        this.mInspectorObserverPtr = lynxDevtool.onBackgroundRuntimeCreated(id);
    }

    public void addRuntimeLifecycleListener(RuntimeLifecycleListener runtimeLifecycleListener) {
        if (runtimeLifecycleListener == null || this.mNativePtr == 0) {
            LLog.m2580w(TAG, "add a null lifecycle listener or runtime has been destroy.");
        } else {
            this.mJSProxy.addLifecycleListener(runtimeLifecycleListener);
        }
    }

    public void transitionToFullRuntime() {
        long j = this.mNativePtr;
        if (j == 0) {
            LLog.m2580w(TAG, "add a null lifecycle listener or runtime has been destroy.");
        } else {
            nativeTransitionToFullRuntime(j);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class CleanupOnUiThread implements Runnable {
        private JSProxy mJSProxy;
        private long mNativePtr;

        public CleanupOnUiThread(long j, JSProxy jSProxy) {
            this.mNativePtr = j;
            this.mJSProxy = jSProxy;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mNativePtr == 0) {
                return;
            }
            LLog.m2580w(LynxBackgroundRuntime.TAG, "destory wrapper " + this.mNativePtr);
            LynxBackgroundRuntime.nativeDestroyWrapper(this.mNativePtr);
            this.mNativePtr = 0L;
            this.mJSProxy.destroy();
        }
    }
}
