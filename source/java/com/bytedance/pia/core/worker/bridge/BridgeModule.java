package com.bytedance.pia.core.worker.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.PiaBridge;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.WorkerUtils;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BridgeModule extends JSModule {
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
    private static final String KEY_MSG = "msg";
    public static final String NAME = "bridge";
    private final PiaBridge bridge;

    public BridgeModule(Context context, Object obj) {
        super(context, obj);
        this.bridge = (PiaBridge) obj;
    }

    @JSMethod
    public void call(final String str, final ReadableMap readableMap, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            returnResult(callback, invalidParams());
        }
        ReadableMap map = readableMap.getMap("data");
        this.bridge.call(str, map != null ? WorkerUtils.toJson(map) : null, new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.worker.bridge.BridgeModule.1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public void accept(JsonObject jsonObject) {
                if (callback == null) {
                    return;
                }
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put("code", 1);
                if (jsonObject != null) {
                    javaOnlyMap.put("data", WorkerUtils.toJavaOnlyMap(jsonObject));
                }
                callback.invoke(new Object[]{javaOnlyMap});
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.worker.bridge.BridgeModule$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                BridgeModule.this.m786lambda$call$0$combytedancepiacoreworkerbridgeBridgeModule(str, readableMap, callback, (PiaMethod.Error) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$call$0$com-bytedance-pia-core-worker-bridge-BridgeModule, reason: not valid java name */
    public /* synthetic */ void m786lambda$call$0$combytedancepiacoreworkerbridgeBridgeModule(String str, ReadableMap readableMap, Callback callback, PiaMethod.Error error) {
        if (error instanceof PiaMethod.UnregisteredError) {
            PiaPlugin plugin = ((PiaRuntime) this.bridge.getContext()).getPlugin(BridgeDowngradePlugin.NAME);
            if (plugin instanceof BridgeDowngradePlugin) {
                ((BridgeDowngradePlugin) plugin).handleDowngradeBridge(str, readableMap.getMap("rawData"), callback);
                return;
            }
        }
        if (callback == null) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (error != null) {
            javaOnlyMap.put("code", Integer.valueOf(error.getCode()));
            javaOnlyMap.put("msg", error.getMessage());
        } else {
            javaOnlyMap.put("code", 0);
        }
        callback.invoke(new Object[]{javaOnlyMap});
    }

    private void returnResult(Callback callback, JavaOnlyMap javaOnlyMap) {
        if (callback != null) {
            callback.invoke(new Object[]{javaOnlyMap});
        }
    }

    static JavaOnlyMap invalidParams() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("code", -3);
        return javaOnlyMap;
    }
}
