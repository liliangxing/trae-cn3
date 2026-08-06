package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PerfMixData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/PerfMixData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "mixPerformance", "Lorg/json/JSONObject;", "getMixPerformance", "()Lorg/json/JSONObject;", "setMixPerformance", "(Lorg/json/JSONObject;)V", "nativePerformance", "getNativePerformance", "()Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "setNativePerformance", "(Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;)V", "fillInJsonObject", "", "jsonObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class PerfMixData extends BaseNativeInfo {
    private JSONObject mixPerformance;
    private BaseNativeInfo nativePerformance;

    public PerfMixData() {
        super("performance");
        this.mixPerformance = new JSONObject();
    }

    public final BaseNativeInfo getNativePerformance() {
        return this.nativePerformance;
    }

    public final void setNativePerformance(BaseNativeInfo baseNativeInfo) {
        this.nativePerformance = baseNativeInfo;
    }

    public final JSONObject getMixPerformance() {
        return this.mixPerformance;
    }

    public final void setMixPerformance(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.mixPerformance = jSONObject;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        BaseNativeInfo baseNativeInfo = this.nativePerformance;
        JsonUtils.deepCopy(jsonObject, baseNativeInfo != null ? baseNativeInfo.toJsonObject() : null);
        JsonUtils.deepCopy(jsonObject, this.mixPerformance);
    }
}
