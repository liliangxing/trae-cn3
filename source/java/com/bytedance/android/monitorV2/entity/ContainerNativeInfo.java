package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/ContainerNativeInfo;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ContainerNativeInfo extends BaseNativeInfo {
    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }

    public ContainerNativeInfo() {
        super("containerError");
    }

    @Override // com.bytedance.android.monitorV2.base.BaseNativeInfo
    public String toString() {
        return "event_type:" + this.eventType;
    }
}
