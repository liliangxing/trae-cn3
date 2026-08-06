package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class DispatchStrategy {
    private static final String TAG = "DispatchStrategy";
    private DispatchStrategyType mDispatchStrategyType;

    /* loaded from: classes2.dex */
    public enum DispatchStrategyType {
        UNKNOWN_DISPATCH_STRATEGY,
        STATIC_DISPATCH_STRATEGY,
        WRR_DISPATCH_STRATEGY,
        CONSERVATIVE_DISPATCH_STRATEGY,
        OPTIMIZED_DISPATCH_STRATEGY,
        ROUTE_SELECTION_DISPATCH_STRATEGY,
        REQUEST_HEADER_DISPATCH_STRATEGY,
        DISPATCH_STRATEGY_SUPPORTED_LAST
    }

    public abstract void dispatchRequestHeaders(URLRequest uRLRequest);

    public abstract String getTargetUrl(Uri uri);

    public abstract boolean needRequestResultFeedback();

    public abstract void notifyRequestResult(String str, boolean z, int i);

    public DispatchStrategy(DispatchStrategyType dispatchStrategyType) {
        this.mDispatchStrategyType = dispatchStrategyType;
    }

    public DispatchStrategyType getDispatchStrategyType() {
        return this.mDispatchStrategyType;
    }

    /* renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType;

        static {
            int[] iArr = new int[DispatchStrategyType.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType = iArr;
            try {
                iArr[DispatchStrategyType.STATIC_DISPATCH_STRATEGY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static DispatchStrategy factory(DispatchStrategyType dispatchStrategyType, JSONObject jSONObject, String str, long j, int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[dispatchStrategyType.ordinal()];
        if (i2 == 1) {
            return new StaticDispatchStrategy(jSONObject);
        }
        if (i2 == 2) {
            return new RequestHeaderDispatchStrategy(jSONObject);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "dispatch strategy " + dispatchStrategyType + " is not supported, fallback to default strategy");
        }
        return new DefaultDispatchStrategy();
    }
}
