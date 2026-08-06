package com.bytedance.pia.core.worker.binding;

import android.content.Context;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.WorkerUtils;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseModule extends JSModule {
    public static final String NAME = "BaseModule";
    private static final String ON_BRIDGE_MESSAGE = "globalThis.__PIA_NATIVE__.onWorkerBridgeMessage();";
    private static final String ON_MESSAGE = "globalThis.__PIA_NATIVE__.onWorkerMessage();";
    public static final String PROPS_BUSINESS = "businessProps";
    private static final String PROPS_SETTINGS = "settings";
    private final ConcurrentLinkedQueue<JavaOnlyMap> localBridgeMessages;
    private final ConcurrentLinkedQueue<JavaOnlyMap> localMessages;
    private final CacheHandle<ReadableMap> remoteBridgeMessages;
    private final CacheHandle<ReadableMap> remoteMessages;
    private final Worker worker;

    public BaseModule(Context context, Object obj) {
        super(context, obj);
        this.remoteMessages = new CacheHandle<>();
        this.localMessages = new ConcurrentLinkedQueue<>();
        this.remoteBridgeMessages = new CacheHandle<>();
        this.localBridgeMessages = new ConcurrentLinkedQueue<>();
        this.worker = (Worker) obj;
    }

    @JSMethod
    public void log(String str, int i) {
        try {
            if (i == 0) {
                Logger.m175d(this.worker.getLogTag() + str);
            } else if (i == 1) {
                Logger.m181i(this.worker.getLogTag() + str);
            } else if (i == 2) {
                Logger.m187w(this.worker.getLogTag() + str);
            } else if (i == 3) {
                Logger.m178e(this.worker.getLogTag() + str);
            } else {
                Logger.m184v(this.worker.getLogTag() + str);
            }
            ((PiaRuntime) this.worker.getContext()).sendEvent(PiaRuntime.EVENT_ON_WORKER_LOG, str, Integer.valueOf(i));
        } catch (Throwable th) {
            Logger.m188w("Worker invoke log error:", th);
        }
    }

    @JSMethod
    public void terminate() {
        this.worker.terminate();
    }

    @JSMethod
    public void terminateWithResult(ReadableMap readableMap) {
        if (readableMap == null) {
            this.worker.terminate();
        } else {
            this.worker.terminateWithResult(WorkerUtils.toJson(readableMap));
        }
    }

    @JSMethod
    public String getHref() {
        return this.worker.getLocation().toString();
    }

    @JSMethod
    public String getUserAgent() {
        return this.worker.getUserAgent();
    }

    @JSMethod
    public WritableMap getGlobalProps() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("settings", new JavaOnlyMap());
        Map<String, ?> globalProps = this.worker.getGlobalProps();
        if (globalProps != null) {
            javaOnlyMap.put(PROPS_BUSINESS, WorkerUtils.toJavaOnlyMap(GsonUtils.getGson().toJsonTree(globalProps).getAsJsonObject()));
        } else {
            javaOnlyMap.put(PROPS_BUSINESS, new JavaOnlyMap());
        }
        return javaOnlyMap;
    }

    @JSMethod
    public void trace(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt != null) {
                    if (opt instanceof Number) {
                        this.worker.getContext().getTracer().report(next, ((Long) opt).longValue());
                    } else {
                        this.worker.getContext().getTracer().reportExtra(next, opt);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public String getWorkerName() {
        return this.worker.getName();
    }

    @JSMethod
    public void postMessage(ReadableMap readableMap) {
        if (readableMap != null) {
            this.remoteMessages.offer(readableMap);
            return;
        }
        throw new NullPointerException("message can not be null!");
    }

    public void setMessageHandle(IConsumer<ReadableMap> iConsumer) {
        this.remoteMessages.setConsumer(iConsumer);
    }

    @JSMethod
    public WritableMap getMessage() {
        return this.localMessages.poll();
    }

    public void sendWorkerMessage(JavaOnlyMap javaOnlyMap) {
        this.localMessages.offer(javaOnlyMap);
        this.worker.loadScript(ON_MESSAGE);
    }

    @JSMethod
    public void postBridgeMessage(ReadableMap readableMap) {
        if (readableMap != null) {
            this.remoteBridgeMessages.offer(readableMap);
        }
    }

    public void setBridgeMessageHandle(IConsumer<ReadableMap> iConsumer) {
        this.remoteBridgeMessages.setConsumer(iConsumer);
    }

    @JSMethod
    public WritableMap getBridgeMessage() {
        return this.localBridgeMessages.poll();
    }

    public void sendWorkerBridgeMessage(JavaOnlyMap javaOnlyMap) {
        this.localBridgeMessages.offer(javaOnlyMap);
        this.worker.loadScript(ON_BRIDGE_MESSAGE);
    }

    @JSMethod
    void importScriptsAsync(String str, final Callback callback, final Callback callback2) {
        this.worker.loadScriptAsync(str, new IConsumer() { // from class: com.bytedance.pia.core.worker.binding.BaseModule$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                BaseModule.lambda$importScriptsAsync$0(callback, (String) obj);
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.worker.binding.BaseModule$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                BaseModule.lambda$importScriptsAsync$1(callback2, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$importScriptsAsync$0(Callback callback, String str) {
        if (callback != null) {
            callback.invoke(new Object[]{str});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$importScriptsAsync$1(Callback callback, String str) {
        if (callback != null) {
            callback.invoke(new Object[]{str});
        }
    }
}
