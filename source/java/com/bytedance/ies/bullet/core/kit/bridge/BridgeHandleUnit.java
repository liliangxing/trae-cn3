package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "", "funcName", "", "params", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "reject", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Ljava/lang/Object;Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "getFuncName", "()Ljava/lang/String;", "getParams", "()Ljava/lang/Object;", "getReject", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BridgeHandleUnit {
    private final IGenericBridgeMethod.ICallback callback;
    private final String funcName;
    private final Object params;
    private final Function1<Throwable, Unit> reject;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BridgeHandleUnit copy$default(BridgeHandleUnit bridgeHandleUnit, String str, Object obj, IGenericBridgeMethod.ICallback iCallback, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = bridgeHandleUnit.funcName;
        }
        if ((i & 2) != 0) {
            obj = bridgeHandleUnit.params;
        }
        if ((i & 4) != 0) {
            iCallback = bridgeHandleUnit.callback;
        }
        if ((i & 8) != 0) {
            function1 = bridgeHandleUnit.reject;
        }
        return bridgeHandleUnit.copy(str, obj, iCallback, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFuncName() {
        return this.funcName;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getParams() {
        return this.params;
    }

    /* renamed from: component3, reason: from getter */
    public final IGenericBridgeMethod.ICallback getCallback() {
        return this.callback;
    }

    public final Function1<Throwable, Unit> component4() {
        return this.reject;
    }

    public final BridgeHandleUnit copy(String funcName, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reject, "reject");
        return new BridgeHandleUnit(funcName, params, callback, reject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeHandleUnit)) {
            return false;
        }
        BridgeHandleUnit bridgeHandleUnit = (BridgeHandleUnit) other;
        return Intrinsics.areEqual(this.funcName, bridgeHandleUnit.funcName) && Intrinsics.areEqual(this.params, bridgeHandleUnit.params) && Intrinsics.areEqual(this.callback, bridgeHandleUnit.callback) && Intrinsics.areEqual(this.reject, bridgeHandleUnit.reject);
    }

    public int hashCode() {
        return (((((this.funcName.hashCode() * 31) + this.params.hashCode()) * 31) + this.callback.hashCode()) * 31) + this.reject.hashCode();
    }

    public String toString() {
        return "BridgeHandleUnit(funcName=" + this.funcName + ", params=" + this.params + ", callback=" + this.callback + ", reject=" + this.reject + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BridgeHandleUnit(String funcName, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reject, "reject");
        this.funcName = funcName;
        this.params = params;
        this.callback = callback;
        this.reject = reject;
    }

    public final String getFuncName() {
        return this.funcName;
    }

    public final Object getParams() {
        return this.params;
    }

    public final IGenericBridgeMethod.ICallback getCallback() {
        return this.callback;
    }

    public final Function1<Throwable, Unit> getReject() {
        return this.reject;
    }
}
