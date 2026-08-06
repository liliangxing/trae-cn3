package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PvData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/PvData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "invokeTime", "", "getInvokeTime", "()J", "setInvokeTime", "(J)V", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class PvData extends BaseNativeInfo {
    private long invokeTime;

    public PvData() {
        super("navigationStart");
        this.invokeTime = System.currentTimeMillis();
    }

    public final long getInvokeTime() {
        return this.invokeTime;
    }

    public final void setInvokeTime(long j) {
        this.invokeTime = j;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonUtils.safePut(jsonObject, "invoke_ts", this.invokeTime);
    }
}
