package com.bytedance.android.anniex.worker;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WorkerBridgeCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerBridgeCall;", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "methodName", "", "workerParams", "(Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "params", "getParams", "()Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", StreamTrafficObservable.STREAM_URL, "getUrl", "()Ljava/lang/String;", "convertParamsToJSONObject", "Lorg/json/JSONObject;", "unWrapperParams", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerBridgeCall extends BaseBridgeCall<ReadableMap> {
    private final ReadableMap params;
    private final PlatformType platformType;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerBridgeCall(String str, ReadableMap readableMap) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "methodName");
        this.platformType = PlatformType.WORKER;
        ReadableMap unWrapperParams = unWrapperParams(readableMap);
        this.params = unWrapperParams == null ? (ReadableMap) new JavaOnlyMap() : unWrapperParams;
        this.url = "";
    }

    public PlatformType getPlatformType() {
        return this.platformType;
    }

    /* renamed from: getParams, reason: from getter and merged with bridge method [inline-methods] */
    public ReadableMap m3467getParams() {
        return this.params;
    }

    public String getUrl() {
        return this.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:21:0x0006, B:5:0x0011, B:8:0x0021, B:12:0x002b), top: B:20:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:21:0x0006, B:5:0x0011, B:8:0x0021, B:12:0x002b), top: B:20:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ReadableMap unWrapperParams(ReadableMap params) {
        boolean z;
        boolean z2 = true;
        if (params != null) {
            try {
                if (params.hasKey("namespace")) {
                    z = true;
                    if (z) {
                        String string = params.getString("namespace");
                        Intrinsics.checkNotNullExpressionValue(string, "params.getString(LynxBridgeCall.NAME_SPACE)");
                        setNamespace(string);
                    }
                    if (params != null || !params.hasKey(Constants.KEY_DATA)) {
                        z2 = false;
                    }
                    return !z2 ? params.getMap(Constants.KEY_DATA) : params;
                }
            } catch (Exception unused) {
                return new JavaOnlyMap();
            }
        }
        z = false;
        if (z) {
        }
        if (params != null) {
        }
        z2 = false;
        if (!z2) {
        }
    }

    public JSONObject convertParamsToJSONObject() {
        JavaOnlyMap m3467getParams = m3467getParams();
        JavaOnlyMap javaOnlyMap = m3467getParams instanceof JavaOnlyMap ? m3467getParams : null;
        JSONObject jSONObject = javaOnlyMap != null ? javaOnlyMap.toJSONObject() : null;
        return jSONObject == null ? super.convertParamsToJSONObject() : jSONObject;
    }
}
