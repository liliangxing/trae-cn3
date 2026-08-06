package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle;
import com.bytedance.pia.core.api.utils.IConsumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PiaWorkerBridgeHandle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J6\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaWorkerBridgeHandle;", "Lcom/bytedance/pia/core/api/bridge/IWorkerBridgeHandle;", "()V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "callbackRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "Lorg/json/JSONObject;", "bindContext", "", "onDestroy", "onEvaluateJavascript", "script", "onLoadUrl", "url", "onWorkerBridgeCall", "name", "params", "callback", "tryInterceptWorkerBridgeCallback", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaWorkerBridgeHandle implements IWorkerBridgeHandle {
    private static final String BRIDGE_CALLBACK_FUNCTION = "._handleMessageFromToutiao(";
    private static final String BRIDGE_CALLBACK_PREFIX = "__pia_jsb2_glue__";
    private BulletContext bulletContext;
    private final ConcurrentHashMap<String, IConsumer<JSONObject>> callbackRegistry = new ConcurrentHashMap<>();

    public final void bindContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        this.bulletContext = bulletContext;
    }

    public final void onLoadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, "javascript", false, 2, (Object) null)) {
            tryInterceptWorkerBridgeCallback(url);
        }
    }

    public final void onEvaluateJavascript(String script) {
        Intrinsics.checkNotNullParameter(script, "script");
        tryInterceptWorkerBridgeCallback(script);
    }

    private final void tryInterceptWorkerBridgeCallback(String script) {
        String str = script;
        if (StringsKt.contains$default(str, BRIDGE_CALLBACK_FUNCTION, false, 2, (Object) null) && StringsKt.contains$default(str, BRIDGE_CALLBACK_PREFIX, false, 2, (Object) null)) {
            try {
                JSONObject jSONObject = new JSONObject(StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(script, BRIDGE_CALLBACK_FUNCTION, (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null));
                String string = jSONObject.getString("__callback_id");
                if (string == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(string, "params.getString(\"__callback_id\") ?: return");
                JSONObject optJSONObject = jSONObject.optJSONObject("__params");
                if (optJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"__params\")");
                    if (optJSONObject.has("__data")) {
                        optJSONObject.put("data", optJSONObject.get("__data"));
                    }
                } else {
                    optJSONObject = new JSONObject();
                    optJSONObject.put("code", -4);
                    optJSONObject.put("msg", "[GLUE] invalid result format!");
                }
                IConsumer<JSONObject> remove = this.callbackRegistry.remove(string);
                if (remove == null) {
                } else {
                    remove.accept(optJSONObject);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle
    public void onWorkerBridgeCall(String url, String name, JSONObject params, IConsumer<JSONObject> callback) {
        IBridge3Registry bridge3Registry;
        try {
            if (name != null && params != null && callback != null) {
                this.callbackRegistry.put(BRIDGE_CALLBACK_PREFIX + params.optString("__callback_id"), callback);
                BulletContext bulletContext = this.bulletContext;
                if (bulletContext != null && (bridge3Registry = bulletContext.getBridge3Registry()) != null) {
                    bridge3Registry.handle(name, params, new Callback() { // from class: com.bytedance.ies.bullet.web.pia.PiaWorkerBridgeHandle$onWorkerBridgeCall$2
                        @Override // com.bytedance.ies.bullet.core.kit.bridge.Callback
                        public void invoke(Object... args) {
                            Intrinsics.checkNotNullParameter(args, "args");
                        }
                    });
                }
            } else {
                if (callback == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", -3);
                callback.accept(jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle
    public void onDestroy() {
        this.bulletContext = null;
        this.callbackRegistry.clear();
    }
}
