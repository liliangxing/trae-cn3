package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020$R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "", "()V", "callFromJsDuration", "", "getCallFromJsDuration", "()J", "callFromJsTS", "callbackEndDuration", "getCallbackEndDuration", "callbackEndTS", "callbackStartDuration", "getCallbackStartDuration", "callbackStartTS", "decodeEndDuration", "getDecodeEndDuration", "decodeEndTS", "encodeEndDuration", "getEncodeEndDuration", "encodeEndTS", "isReady", "", "()Z", "jsStartTS", "methodCallDuration", "getMethodCallDuration", "methodCallTS", "onCallFromJs", "", "ts", "onCallbackEnd", "onCallbackStart", "onDecodeEnd", "onEncodeEnd", "onMethodCall", "toJSON", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BridgePerfData {
    private long callFromJsTS;
    private long callbackEndTS;
    private long callbackStartTS;
    private long decodeEndTS;
    private long encodeEndTS;
    private long jsStartTS;
    private long methodCallTS;

    public final long getCallFromJsDuration() {
        return this.callFromJsTS - this.jsStartTS;
    }

    public final long getDecodeEndDuration() {
        return this.decodeEndTS - this.jsStartTS;
    }

    public final long getMethodCallDuration() {
        return this.methodCallTS - this.jsStartTS;
    }

    public final long getCallbackStartDuration() {
        return this.callbackStartTS - this.jsStartTS;
    }

    public final long getEncodeEndDuration() {
        return this.encodeEndTS - this.jsStartTS;
    }

    public final long getCallbackEndDuration() {
        return this.callbackEndTS - this.jsStartTS;
    }

    public final boolean isReady() {
        return this.jsStartTS > 0 && this.callFromJsTS > 0 && this.decodeEndTS > 0 && this.methodCallTS > 0 && this.callbackStartTS > 0 && this.encodeEndTS > 0 && this.callbackEndTS > 0;
    }

    public static /* synthetic */ void onCallFromJs$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onCallFromJs(j);
    }

    public final void onCallFromJs(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.jsStartTS = ts;
        this.callFromJsTS = ts;
    }

    public static /* synthetic */ void onDecodeEnd$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onDecodeEnd(j);
    }

    public final void onDecodeEnd(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.decodeEndTS = ts;
    }

    public static /* synthetic */ void onMethodCall$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onMethodCall(j);
    }

    public final void onMethodCall(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.methodCallTS = ts;
    }

    public static /* synthetic */ void onCallbackStart$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onCallbackStart(j);
    }

    public final void onCallbackStart(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.callbackStartTS = ts;
    }

    public static /* synthetic */ void onEncodeEnd$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onEncodeEnd(j);
    }

    public final void onEncodeEnd(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.encodeEndTS = ts;
    }

    public static /* synthetic */ void onCallbackEnd$default(BridgePerfData bridgePerfData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        bridgePerfData.onCallbackEnd(j);
    }

    public final void onCallbackEnd(long ts) {
        if (ts <= 0) {
            ts = System.currentTimeMillis();
        }
        this.callbackEndTS = ts;
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put("on_call_from_js", getCallFromJsDuration());
            jSONObject.put("on_decode_end", getDecodeEndDuration());
            jSONObject.put("on_method_call", getMethodCallDuration());
            jSONObject.put("on_callback_start", getCallbackStartDuration());
            jSONObject.put("on_encode_end", getEncodeEndDuration());
            Result.m10253constructorimpl(jSONObject.put("on_callback_end", getCallbackEndDuration()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        return jSONObject;
    }
}
