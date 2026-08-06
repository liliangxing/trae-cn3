package com.lynx.tasm;

import com.lynx.jsbridge.LynxEmbeddedModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.group.ILynxViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DefaultLogicExecutor implements ILynxLogicExecutor {
    private static final String APP_SERVICE_PATH = "/app-service.js";
    public static final String EVENT_ARGS = "args";
    public static final String EVENT_METHOD = "method";
    public static final String GLOBAL_EVENT_METHOD = "sendGlobalEvent";
    public static final String GLOBAL_EVENT_NAME = "name";
    public static final String GLOBAL_EVENT_PARAMS = "params";
    public static final String LIFECYCLE_EVENT_ON_DATA_CHANGED = "onDataChanged";
    public static final String LIFECYCLE_EVENT_ON_DESTROY = "onDestroy";
    public static final String LIFECYCLE_EVENT_ON_LOAD = "onLoad";
    private static final String LOGIC_JS_PATH = "/logic.js";
    private static final String MODULE_NAME = "embeddedModule";
    private static final String TAG = "DefaultLogicExecutor";
    private final Object mInitLock;
    private WeakReference<ILynxViewGroup> mLynxViewGroupRef;
    private volatile LynxBackgroundRuntime mRuntime;

    public DefaultLogicExecutor() {
        this.mInitLock = new Object();
        this.mLynxViewGroupRef = new WeakReference<>(null);
    }

    public DefaultLogicExecutor(ILynxViewGroup iLynxViewGroup) {
        this.mInitLock = new Object();
        this.mLynxViewGroupRef = new WeakReference<>(iLynxViewGroup);
    }

    public void init(ILynxViewGroup iLynxViewGroup) {
        this.mLynxViewGroupRef = new WeakReference<>(iLynxViewGroup);
    }

    private void initLynxBackgroundRuntimeIfNeeded(LynxContext lynxContext) {
        if (this.mRuntime == null) {
            synchronized (this.mInitLock) {
                if (this.mRuntime == null) {
                    TraceEvent.beginSection(TraceEventDef.LOGIC_EXECUTOR_INIT);
                    ILynxViewGroup iLynxViewGroup = this.mLynxViewGroupRef.get();
                    if (iLynxViewGroup == null) {
                        LLog.m2577e(TAG, "LynxViewGroup not found");
                        return;
                    }
                    LynxBackgroundRuntimeOptions lynxRuntimeOptions = iLynxViewGroup.getLynxRuntimeOptions();
                    TemplateBundle templateBundleNonBlocking = iLynxViewGroup.getTemplateBundleNonBlocking();
                    if (lynxRuntimeOptions != null && templateBundleNonBlocking != null && lynxContext != null) {
                        lynxRuntimeOptions.registerModule(LynxEmbeddedModule.NAME, LynxEmbeddedModule.class, iLynxViewGroup);
                        this.mRuntime = new LynxBackgroundRuntime(lynxContext, lynxRuntimeOptions, iLynxViewGroup.isDebuggable());
                        String str = LOGIC_JS_PATH;
                        String url = templateBundleNonBlocking.getUrl();
                        if (url != null && (url.startsWith("/") || url.startsWith("http"))) {
                            str = url + LOGIC_JS_PATH;
                        }
                        this.mRuntime.evaluateTemplateBundle(str, templateBundleNonBlocking, APP_SERVICE_PATH);
                        TraceEvent.endSection(TraceEventDef.LOGIC_EXECUTOR_INIT);
                    }
                    LLog.m2577e(TAG, "init LynxBackgroundRuntime failed.");
                }
            }
        }
    }

    @Override // com.lynx.tasm.ILynxLogicExecutor
    public void onLynxEvent(LynxView lynxView, ReadableMap readableMap) {
        if (readableMap.hasKey(EVENT_METHOD)) {
            initLynxBackgroundRuntimeIfNeeded(lynxView.getLynxContext());
            if (this.mRuntime == null) {
                return;
            }
            processEvent(lynxView, readableMap);
        }
    }

    private void processEvent(LynxView lynxView, ReadableMap readableMap) {
        String string = readableMap.getString(EVENT_METHOD);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(GLOBAL_EVENT_NAME, string);
            TraceEvent.beginSection(TraceEventDef.LOGIC_EXECUTOR_EVENT, hashMap);
        }
        if (string == GLOBAL_EVENT_METHOD) {
            String string2 = readableMap.getString(GLOBAL_EVENT_NAME);
            JavaOnlyArray javaOnlyArray = (JavaOnlyArray) readableMap.getArray("params");
            javaOnlyArray.pushInt(lynxView.getLynxViewId());
            this.mRuntime.sendGlobalEvent(string2, javaOnlyArray);
        } else {
            JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
            if (readableMap.getType(EVENT_ARGS) == ReadableType.TemplateData) {
                javaOnlyArray2.pushTemplateData(readableMap.getTemplateData(EVENT_ARGS));
            } else if (readableMap.getType(EVENT_ARGS) == ReadableType.Map) {
                javaOnlyArray2.pushMap((JavaOnlyMap) readableMap.getMap(EVENT_ARGS));
            }
            javaOnlyArray2.pushInt(lynxView.getLynxViewId());
            this.mRuntime.callFunction(MODULE_NAME, string, javaOnlyArray2);
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(TraceEventDef.LOGIC_EXECUTOR_EVENT);
        }
    }

    @Override // com.lynx.tasm.ILynxLogicExecutor
    public void destroy() {
        if (this.mRuntime != null) {
            this.mRuntime.destroy();
            this.mRuntime = null;
        }
    }
}
