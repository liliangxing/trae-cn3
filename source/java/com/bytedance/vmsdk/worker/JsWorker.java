package com.bytedance.vmsdk.worker;

import android.util.Log;
import com.bytedance.vmsdk.BuildConfig;
import com.bytedance.vmsdk.VmSdk;
import com.bytedance.vmsdk.inspector_new.InspectorClientNew;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.net.INetCallback;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.registry.JavaScriptFunction;
import com.bytedance.vmsdk.registry.JavaScriptModule;
import com.bytedance.vmsdk.registry.JavaScriptRegistry;
import com.bytedance.vmsdk.settings.SettingsManager;
import com.bytedance.vmsdk.worker.devtool.WorkerDevTool;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JsWorker {
    private static final String CACHE_PATH = "/woker_code_cache.bin";
    public static final String DEFAULT_BIZ_NAME = "unknown_android";
    private static final long QJS = 0;
    private static final String TAG = "VMSDK_JsWorker";

    /* renamed from: V8 */
    private static final long f6V8 = 1;
    private static boolean isInitialised;
    private IWorkerExceptionDelegate mExceptionDelegate;
    private JavaScriptRegistry mJavaScriptModuleRegistry;
    private JSModuleManager mModuleManager;
    private IWorkerCallback mOnErrorCallback;
    private IWorkerCallback mOnMessageCallback;
    private IWorkerDelegate mWorkerDelegate;
    private AtomicLong mNativeWorkerPtr = new AtomicLong(0);
    private WorkerDevTool mDevTool = null;
    private InspectorClientNew mInspectorClientNew = null;
    private EngineType mEngineType = EngineType.QUICKJS;
    private int mSrcID = -1;
    private boolean isIcuInitialised = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum EngineType {
        QUICKJS,
        V8
    }

    private native void nativeBind(long j, int i, int i2);

    private static native long nativeCreateWorker(JsWorker jsWorker, long j, JSModuleManager jSModuleManager, String str, boolean z, String str2, boolean z2);

    private native void nativeEvaluateCodeCache(long j, byte[] bArr);

    private static native void nativeEvaluateJavaScript(long j, String str, String str2, boolean z);

    private static native byte[] nativeGenCodeCache(String str, long j);

    private native long nativeGetNapiEnv(long j);

    private static native void nativeInitInspector(long j, long j2);

    private static native void nativeInitInspectorFactory(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitQJSWebAssembly(long j, long j2);

    private native Object nativeInvokeJavaScriptFunction(long j, String str, JavaOnlyArray javaOnlyArray, char c);

    private native Object nativeInvokeJavaScriptModule(long j, String str, String str2, JavaOnlyArray javaOnlyArray, char c);

    private native void nativeOnCloseInspectorSession(long j);

    private native void nativeOnInspectorMessage(long j, String str);

    private native void nativeOnJSRunner(long j, Runnable runnable);

    private native void nativeOnJSRunnerAtFront(long j, Runnable runnable);

    private native void nativeOnJSRunnerDelay(long j, Runnable runnable, long j2);

    private native void nativeOnOpenInspectorSession(long j);

    private native void nativeOnPlatformRunner(long j, Runnable runnable);

    private native void nativeOnWorkerRunner(long j, Runnable runnable);

    private static native void nativePostMessage(long j, String str);

    private static native void nativeRegisterDelegateFunction(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReject(long j, String str, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeResolve(long j, Response response, long j2);

    private native void nativeSetExceptionDelegate(long j, IWorkerExceptionDelegate iWorkerExceptionDelegate);

    private native void nativeSetProperties(long j, JavaOnlyMap javaOnlyMap);

    private native void nativeSetupLoader(long j, String str);

    private static native void nativeTerminate(long j);

    private static native void nativeV8PipeInit(long j, long[] jArr);

    @Deprecated
    public static void v8pipeInit(long[] jArr) {
    }

    public static boolean initialize() {
        String[] strArr = {"quick", "napi", "worker"};
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            try {
                System.loadLibrary(strArr[i]);
            } catch (Throwable th) {
                Log.d(TAG, "initialize error: " + th.getMessage());
                z = true;
            }
        }
        initDevtool();
        isInitialised = !z;
        return !z;
    }

    public static long getWasmRegisterFunctionPtr() {
        try {
            return ((Long) Class.forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly").getMethod("registerWebAssembly", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            Log.e(TAG, "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
            return 0L;
        }
    }

    public static boolean initializeWithoutThrow() {
        String[] strArr = {"quick", "napi", "worker"};
        for (int i = 0; i < 3; i++) {
            System.loadLibrary(strArr[i]);
        }
        isInitialised = true;
        return true;
    }

    public static boolean isIsInitialised() {
        return isInitialised;
    }

    public boolean isIsIcuInitialised() {
        return this.isIcuInitialised;
    }

    public static boolean preLoadPlugin(String str) {
        return VmSdk.preloadPlugin(str);
    }

    public static boolean initializeWithPlugin(String str) {
        try {
            boolean loadQuickJsLibrary = VmSdk.loadQuickJsLibrary();
            boolean loadWorkerLibrary = VmSdk.loadWorkerLibrary(str);
            if (!isInitialised) {
                isInitialised = loadQuickJsLibrary && loadWorkerLibrary;
            }
            return loadQuickJsLibrary && loadWorkerLibrary;
        } catch (Throwable th) {
            Log.d(TAG, "initializeWithPlugin error: " + th.getMessage());
            return false;
        }
    }

    public static boolean initializeWithPlugin2(String str) {
        try {
            boolean loadWorkerLibrary = VmSdk.loadWorkerLibrary(str);
            if (!isInitialised) {
                isInitialised = loadWorkerLibrary;
            }
            return loadWorkerLibrary;
        } catch (Throwable th) {
            Log.d(TAG, "initializeWithPlugin error: " + th.getMessage());
            return false;
        }
    }

    public JsWorker(InitParams initParams) {
        init(initParams.jsModuleManager(), initParams.engineType(), initParams.codeCachePath(), initParams.enableMultiThread(), initParams.bizName(), initParams.enableInspector(), initParams.enableIcu(), initParams.initWasm(), initParams.usePlatformThread());
    }

    @Deprecated
    public JsWorker() {
        init(null, EngineType.QUICKJS, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager) {
        init(jSModuleManager, EngineType.QUICKJS, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager, EngineType engineType) {
        init(jSModuleManager, engineType, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager, EngineType engineType, boolean z) {
        init(jSModuleManager, engineType, null, z, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager, EngineType engineType, String str) {
        init(jSModuleManager, engineType, str + CACHE_PATH, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager, EngineType engineType, String str, boolean z) {
        init(jSModuleManager, engineType, str + CACHE_PATH, z, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager jSModuleManager, EngineType engineType, String str, boolean z, String str2) {
        init(jSModuleManager, engineType, str + CACHE_PATH, z, str2, false, false, false, false);
    }

    private void init(JSModuleManager jSModuleManager, EngineType engineType, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!isInitialised) {
            initialize();
        }
        long j = engineType == EngineType.QUICKJS ? 0L : 1L;
        this.mEngineType = engineType;
        this.mNativeWorkerPtr.set(nativeCreateWorker(this, j, jSModuleManager, !SettingsManager.inst().getSettingsFromCache("vmsdk_enable_codecache") ? null : str, z, str2, z5));
        if (z3) {
            registerICU();
        }
        this.mJavaScriptModuleRegistry = new JavaScriptRegistry();
        this.mModuleManager = jSModuleManager;
        if (z2) {
            this.mDevTool = new WorkerDevTool(this);
            this.mInspectorClientNew = new InspectorClientNew(this);
        }
        if (z4) {
            long wasmRegisterFunctionPtr = getWasmRegisterFunctionPtr();
            if (wasmRegisterFunctionPtr != 0) {
                initWebAssembly(wasmRegisterFunctionPtr, this.mEngineType);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("biz_name", str2);
            jSONObject.put("init_worker", true);
            jSONObject.put("vmsdk_android_version", VmSdk.getVmsdkAndroidVersion());
            Log.d(TAG, "new jsworker: " + jSONObject + " vmsdk_android_version: " + VmSdk.getVmsdkAndroidVersion());
            VmSdkMonitor.monitorEvent("JsWorker", jSONObject, (JSONObject) null, (JSONObject) null);
        } catch (Throwable th) {
            Log.e(TAG, "vmsdk monitor data upload error: " + th.getMessage());
        }
    }

    public void registerModule(String str, Class<? extends JSModule> cls, Object obj) {
        if (this.mModuleManager == null || !isRunning()) {
            return;
        }
        this.mModuleManager.registerModule(str, cls, obj);
    }

    public JSModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    public long getNativePtr() {
        return this.mNativeWorkerPtr.get();
    }

    public void evaluateJavaScript(String str) {
        if (isRunning()) {
            WorkerDevTool workerDevTool = this.mDevTool;
            if (workerDevTool != null) {
                workerDevTool.onWorkerLoaded("default.js");
            }
            nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), str, "default.js", false);
        }
    }

    public void setupLoader(String str) {
        if (isRunning()) {
            nativeSetupLoader(this.mNativeWorkerPtr.get(), str);
        }
    }

    public void evaluateJavaScript(String str, String str2) {
        if (isRunning()) {
            WorkerDevTool workerDevTool = this.mDevTool;
            if (workerDevTool != null) {
                workerDevTool.onWorkerLoaded(str2);
            }
            nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), str, str2, false);
        }
    }

    public void evaluateJavaScriptWithException(String str, String str2) {
        if (isRunning()) {
            WorkerDevTool workerDevTool = this.mDevTool;
            if (workerDevTool != null) {
                workerDevTool.onWorkerLoaded(str2);
            }
            nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), str, str2, true);
        }
    }

    public static byte[] genCodeCache(String str, EngineType engineType) {
        return nativeGenCodeCache(str, engineType == EngineType.QUICKJS ? 0L : 1L);
    }

    public void evaluateCodeCache(byte[] bArr) {
        if (isRunning()) {
            nativeEvaluateCodeCache(this.mNativeWorkerPtr.get(), bArr);
        }
    }

    public void postOnJSRunner(Runnable runnable) {
        if (isRunning()) {
            nativeOnJSRunner(this.mNativeWorkerPtr.get(), runnable);
        }
    }

    public void postOnWorkerRunner(Runnable runnable) {
        if (isRunning()) {
            nativeOnWorkerRunner(this.mNativeWorkerPtr.get(), runnable);
        }
    }

    public void postOnJSRunnerAtFront(Runnable runnable) {
        if (isRunning()) {
            nativeOnJSRunnerAtFront(this.mNativeWorkerPtr.get(), runnable);
        }
    }

    public void postOnJSRunnerDelay(Runnable runnable, long j) {
        if (this.mNativeWorkerPtr.get() != 0) {
            nativeOnJSRunnerDelay(this.mNativeWorkerPtr.get(), runnable, j);
        }
    }

    public long getNapiEnv() {
        if (this.mNativeWorkerPtr.get() != 0) {
            return nativeGetNapiEnv(this.mNativeWorkerPtr.get());
        }
        return 0L;
    }

    protected void postOnPlatformRunner(Runnable runnable) {
        if (this.mNativeWorkerPtr.get() != 0) {
            nativeOnPlatformRunner(this.mNativeWorkerPtr.get(), runnable);
        }
    }

    private void registerICU() {
        boolean z;
        try {
            System.loadLibrary("icu");
            z = true;
        } catch (Exception e) {
            Log.e(TAG, "fail to load libicu.so: " + e.getMessage());
            z = false;
        }
        if (z) {
            postOnJSRunner(new Runnable() { // from class: com.bytedance.vmsdk.worker.JsWorker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JsWorker.this.m2632lambda$registerICU$0$combytedancevmsdkworkerJsWorker();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$registerICU$0$com-bytedance-vmsdk-worker-JsWorker, reason: not valid java name */
    public /* synthetic */ void m2632lambda$registerICU$0$combytedancevmsdkworkerJsWorker() {
        boolean z;
        long nativeGetNapiEnv = nativeGetNapiEnv(this.mNativeWorkerPtr.get());
        if (nativeGetNapiEnv != 0) {
            try {
                z = false;
                Class.forName("com.bytedance.vmsdk.icu.RegisterICU").getMethod("nativeRegisterICUInNapiEnv", Long.TYPE).invoke(null, Long.valueOf(nativeGetNapiEnv));
            } catch (Exception e) {
                Log.e(TAG, "Register ICU api in Napi failed [ " + e.getClass().getSimpleName() + ", " + e.getMessage() + ", " + e.getCause() + " ]");
                z = true;
            }
            if (z) {
                return;
            }
            Log.i(TAG, "register icu api in napi success");
            this.isIcuInitialised = true;
            return;
        }
        Log.e(TAG, "napi_env is nullptr");
    }

    public void setGlobalProperties(JavaOnlyMap javaOnlyMap) {
        if (javaOnlyMap == null || javaOnlyMap.size() <= 0 || !isRunning()) {
            return;
        }
        nativeSetProperties(this.mNativeWorkerPtr.get(), javaOnlyMap);
    }

    public <T extends JavaScriptModule> T getJavaScriptModule(Class<T> cls) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptModule(this, cls);
    }

    public <T extends JavaScriptFunction> T getJavaScriptFunction(Class<T> cls) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptFunction(this, cls);
    }

    public Object invokeJavaScriptModule(String str, String str2, JavaOnlyArray javaOnlyArray, char c) {
        if (isRunning()) {
            return nativeInvokeJavaScriptModule(this.mNativeWorkerPtr.get(), str, str2, javaOnlyArray, c);
        }
        return null;
    }

    public Object invokeJavaScriptFunction(String str, JavaOnlyArray javaOnlyArray, char c, boolean z) {
        if (isRunning()) {
            return nativeInvokeJavaScriptFunction(this.mNativeWorkerPtr.get(), str, javaOnlyArray, c);
        }
        return null;
    }

    public void terminate() {
        if (this.mOnMessageCallback != null) {
            this.mOnMessageCallback = null;
        }
        if (this.mOnErrorCallback != null) {
            this.mOnErrorCallback = null;
        }
        WorkerDevTool workerDevTool = this.mDevTool;
        if (workerDevTool != null) {
            workerDevTool.destroy();
            this.mDevTool = null;
        }
        InspectorClientNew inspectorClientNew = this.mInspectorClientNew;
        if (inspectorClientNew != null) {
            inspectorClientNew.release();
            this.mInspectorClientNew = null;
        }
        JSModuleManager jSModuleManager = this.mModuleManager;
        if (jSModuleManager != null) {
            jSModuleManager.destroy();
            this.mModuleManager = null;
        }
        if (this.mNativeWorkerPtr.get() != 0) {
            isInitialised = false;
            long andSet = this.mNativeWorkerPtr.getAndSet(0L);
            if (andSet != 0) {
                nativeTerminate(andSet);
            }
        }
    }

    public void postMessage(String str) {
        if (isRunning()) {
            nativePostMessage(this.mNativeWorkerPtr.get(), str);
        }
    }

    public void setOnMessageCallback(IWorkerCallback iWorkerCallback) {
        this.mOnMessageCallback = iWorkerCallback;
    }

    public void setOnErrorCallback(IWorkerCallback iWorkerCallback) {
        this.mOnErrorCallback = iWorkerCallback;
    }

    public void setWorkerDelegate(IWorkerDelegate iWorkerDelegate) {
        this.mWorkerDelegate = iWorkerDelegate;
        if (iWorkerDelegate != null) {
            nativeRegisterDelegateFunction(this.mNativeWorkerPtr.get());
        }
    }

    public void setDelegate(IWorkerExceptionDelegate iWorkerExceptionDelegate) {
        if (iWorkerExceptionDelegate == null || this.mNativeWorkerPtr.get() == 0) {
            return;
        }
        this.mExceptionDelegate = iWorkerExceptionDelegate;
        nativeSetExceptionDelegate(this.mNativeWorkerPtr.get(), iWorkerExceptionDelegate);
    }

    public IWorkerExceptionDelegate getDelegate() {
        return this.mExceptionDelegate;
    }

    public boolean isRunning() {
        return this.mNativeWorkerPtr.get() != 0;
    }

    public EngineType EngineType() {
        return this.mEngineType;
    }

    public static boolean initDevtool() {
        try {
            Long l = (Long) Class.forName("com.bytedance.vmsdk.devtool.DevtoolManager").getMethod("initialize", new Class[0]).invoke(null, new Object[0]);
            if (l == null || l.longValue() == 0) {
                return false;
            }
            nativeInitInspectorFactory(l.longValue());
            return true;
        } catch (Throwable th) {
            Log.i(TAG, "[Devtool] Initialize devtool failed:", th);
            return false;
        }
    }

    public void initInspector(long j) {
        nativeInitInspector(this.mNativeWorkerPtr.get(), j);
    }

    public static String getCacheFilePath(String str) {
        return str + CACHE_PATH;
    }

    public void initV8Pipe(long[] jArr) {
        if (jArr == null || jArr.length <= 3) {
            return;
        }
        nativeV8PipeInit(this.mNativeWorkerPtr.get(), jArr);
    }

    /* renamed from: id */
    public int m24id() {
        return this.mSrcID;
    }

    public void bind(int i, int i2) {
        this.mSrcID = i;
        nativeBind(this.mNativeWorkerPtr.get(), i, i2);
        Log.d(TAG, "JsWorker id : " + i + ", " + i2);
    }

    public InspectorClientNew getInspectorClient() {
        return this.mInspectorClientNew;
    }

    public void setInspectorClient(InspectorClientNew inspectorClientNew) {
        this.mInspectorClientNew = inspectorClientNew;
    }

    public void onOpenInspectorSession() {
        if (isRunning()) {
            nativeOnOpenInspectorSession(this.mNativeWorkerPtr.get());
        }
    }

    public void onInspectorMessage(String str) {
        if (isRunning()) {
            nativeOnInspectorMessage(this.mNativeWorkerPtr.get(), str);
        }
    }

    public void onCloseInspectorSession() {
        if (isRunning()) {
            nativeOnCloseInspectorSession(this.mNativeWorkerPtr.get());
        }
    }

    private void SendInspectorResponse(String str) {
        InspectorClientNew inspectorClientNew = this.mInspectorClientNew;
        if (inspectorClientNew != null) {
            inspectorClientNew.sendResponse(str);
        }
    }

    public void initWebAssembly(final long j, EngineType engineType) {
        if (!BuildConfig.ENABLE_WASM.booleanValue()) {
            Log.w("vmsdk", "Wasm not enabled in worker");
            return;
        }
        try {
            if (engineType == EngineType.QUICKJS) {
                postOnJSRunner(new Runnable() { // from class: com.bytedance.vmsdk.worker.JsWorker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JsWorker.nativeInitQJSWebAssembly(j, JsWorker.this.mNativeWorkerPtr.get());
                    }
                });
            } else {
                Log.i("vmsdk", "JS runtimes other than QJS are not supported in vmsdk playground to init WebAssembly");
            }
        } catch (Exception e) {
            Log.e("vmsdk", "Could not init WebAssembly in vmsdk playground [ " + e.getMessage() + ", " + e.getCause() + " ]");
        }
    }

    private void onMessage(String str) {
        IWorkerCallback iWorkerCallback = this.mOnMessageCallback;
        if (iWorkerCallback != null) {
            iWorkerCallback.execute(str);
        }
        Log.d(TAG, "Message from native: " + str);
    }

    private void onError(String str) {
        IWorkerCallback iWorkerCallback = this.mOnErrorCallback;
        if (iWorkerCallback != null) {
            iWorkerCallback.execute(str);
        }
        Log.e(TAG, "Error from native: " + str);
    }

    private String FetchJsWithUrlSync(String str) {
        IWorkerDelegate iWorkerDelegate = this.mWorkerDelegate;
        if (iWorkerDelegate == null) {
            return "";
        }
        String fetchWithUrlSync = iWorkerDelegate.fetchWithUrlSync(str);
        Log.d(TAG, "FetchJsWithUrlSync js: " + fetchWithUrlSync);
        return fetchWithUrlSync;
    }

    private void Fetch(String str, String str2, byte[] bArr, final long j) {
        JSONObject jSONObject;
        if (this.mWorkerDelegate != null) {
            try {
                if (str2.isEmpty()) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str2);
                }
                Log.d(TAG, "Fetch params: " + str2);
                this.mWorkerDelegate.loadAsync(new Request(str, jSONObject, bArr), new INetCallback<Response>() { // from class: com.bytedance.vmsdk.worker.JsWorker.2
                    @Override // com.bytedance.vmsdk.net.INetCallback
                    public void execute(Response response) {
                        if (JsWorker.this.isRunning()) {
                            JsWorker.nativeResolve(JsWorker.this.mNativeWorkerPtr.get(), response, j);
                        }
                    }
                }, new INetCallback<Throwable>() { // from class: com.bytedance.vmsdk.worker.JsWorker.3
                    @Override // com.bytedance.vmsdk.net.INetCallback
                    public void execute(Throwable th) {
                        if (JsWorker.this.isRunning()) {
                            JsWorker.nativeReject(JsWorker.this.mNativeWorkerPtr.get(), th.getMessage(), j);
                        }
                    }
                });
            } catch (JSONException e) {
                Log.e(TAG, "fail to convert json: " + e.getMessage());
            }
        }
    }

    private boolean workDelegateExists() {
        return this.mWorkerDelegate != null;
    }
}
