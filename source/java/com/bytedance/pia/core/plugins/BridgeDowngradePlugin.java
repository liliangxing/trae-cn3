package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BridgeDowngradePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0014J$\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J-\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\r2\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010!0 \"\u0004\u0018\u00010!H\u0014¢\u0006\u0002\u0010\"R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006%"}, d2 = {"Lcom/bytedance/pia/core/plugins/BridgeDowngradePlugin;", "Lcom/bytedance/pia/core/runtime/PiaPlugin;", "runtime", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "(Lcom/bytedance/pia/core/runtime/PiaRuntime;Lcom/bytedance/pia/core/PiaManifest;)V", "commonBridgeHandle", "Lcom/bytedance/pia/core/utils/CacheHandle;", "Lcom/bytedance/pia/core/plugins/BridgeDowngradePlugin$BridgeCall;", PiaPropsPlugin.PROPS_NAME_MANIFEST, "()Lcom/bytedance/pia/core/PiaManifest;", "getName", "", "handleDowngradeBridge", "", "name", "params", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "callback", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "jsonToArray", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "array", "Lorg/json/JSONArray;", "jsonToMap", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "json", "Lorg/json/JSONObject;", "onEvent", ISignalReportService.BODY_KEY_EVENT, "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "BridgeCall", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BridgeDowngradePlugin extends PiaPlugin {
    public static final String NAME = "bridgeDowngrade";
    private final CacheHandle<BridgeCall> commonBridgeHandle;
    private final PiaManifest manifest;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeDowngradePlugin(PiaRuntime piaRuntime, PiaManifest piaManifest) {
        super(piaRuntime);
        Intrinsics.checkNotNullParameter(piaRuntime, "runtime");
        Intrinsics.checkNotNullParameter(piaManifest, ErrorType.MANIFEST);
        this.manifest = piaManifest;
        this.commonBridgeHandle = new CacheHandle<>();
    }

    public final PiaManifest getManifest() {
        return this.manifest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onEvent(String event, final Object... args) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        Intrinsics.checkNotNullParameter(args, "args");
        if (Intrinsics.areEqual(PiaRuntime.EVENT_ON_BIND_BRIDGE_HANDLE, event)) {
            this.commonBridgeHandle.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.plugins.BridgeDowngradePlugin$onEvent$1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(final BridgeDowngradePlugin.BridgeCall bridgeCall) {
                    PiaRuntime piaRuntime;
                    Object obj = args[0];
                    IWorkerBridgeHandle iWorkerBridgeHandle = obj instanceof IWorkerBridgeHandle ? (IWorkerBridgeHandle) obj : null;
                    if (iWorkerBridgeHandle != null) {
                        piaRuntime = this.runtime;
                        String uri = piaRuntime.getOriginUrl().toString();
                        String method = bridgeCall.getMethod();
                        JavaOnlyMap params = bridgeCall.getParams();
                        JavaOnlyMap javaOnlyMap = params instanceof JavaOnlyMap ? params : null;
                        JSONObject jSONObject = javaOnlyMap != null ? javaOnlyMap.toJSONObject() : null;
                        final BridgeDowngradePlugin bridgeDowngradePlugin = this;
                        iWorkerBridgeHandle.onWorkerBridgeCall(uri, method, jSONObject, new IConsumer() { // from class: com.bytedance.pia.core.plugins.BridgeDowngradePlugin$onEvent$1.2
                            @Override // com.bytedance.pia.core.api.utils.IConsumer
                            public final void accept(JSONObject jSONObject2) {
                                JavaOnlyMap jsonToMap;
                                Callback callback = BridgeDowngradePlugin.BridgeCall.this.getCallback();
                                if (callback != null) {
                                    jsonToMap = bridgeDowngradePlugin.jsonToMap(jSONObject2);
                                    callback.invoke(new Object[]{jsonToMap});
                                }
                            }
                        });
                        return;
                    }
                    Callback callback = bridgeCall.getCallback();
                    if (callback != null) {
                        JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
                        javaOnlyMap2.put("code", -2);
                        Unit unit = Unit.INSTANCE;
                        callback.invoke(new Object[]{javaOnlyMap2});
                    }
                }
            });
        }
    }

    public final void handleDowngradeBridge(String name, ReadableMap params, Callback callback) {
        this.commonBridgeHandle.offer(new BridgeCall(name, params, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JavaOnlyMap jsonToMap(JSONObject json) {
        if (json == null) {
            return null;
        }
        Iterator<String> keys = json.keys();
        Map javaOnlyMap = new JavaOnlyMap();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = json.opt(next);
            if (opt instanceof JSONObject) {
                javaOnlyMap.put(next, jsonToMap((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                javaOnlyMap.put(next, jsonToArray((JSONArray) opt));
            } else if (opt == JSONObject.NULL) {
                javaOnlyMap.put(next, null);
            } else {
                javaOnlyMap.put(next, opt);
            }
        }
        return javaOnlyMap;
    }

    private final JavaOnlyArray jsonToArray(JSONArray array) {
        if (array == null) {
            return null;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int length = array.length();
        for (int i = 0; i < length; i++) {
            Object opt = array.opt(i);
            if (opt instanceof JSONObject) {
                javaOnlyArray.add(jsonToMap((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                javaOnlyArray.add(jsonToArray((JSONArray) opt));
            } else {
                javaOnlyArray.add(opt);
            }
        }
        return javaOnlyArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BridgeDowngradePlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/pia/core/plugins/BridgeDowngradePlugin$BridgeCall;", "", "method", "", "params", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "callback", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "(Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Lcom/bytedance/vmsdk/jsbridge/utils/Callback;)V", "getCallback", "()Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "setCallback", "(Lcom/bytedance/vmsdk/jsbridge/utils/Callback;)V", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "getParams", "()Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "setParams", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class BridgeCall {
        private Callback callback;
        private String method;
        private ReadableMap params;

        public BridgeCall(String str, ReadableMap readableMap, Callback callback) {
            this.method = str;
            this.params = readableMap;
            this.callback = callback;
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final String getMethod() {
            return this.method;
        }

        public final ReadableMap getParams() {
            return this.params;
        }

        public final void setCallback(Callback callback) {
            this.callback = callback;
        }

        public final void setMethod(String str) {
            this.method = str;
        }

        public final void setParams(ReadableMap readableMap) {
            this.params = readableMap;
        }
    }
}
