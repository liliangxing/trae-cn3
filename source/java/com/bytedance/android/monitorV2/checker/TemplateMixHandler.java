package com.bytedance.android.monitorV2.checker;

import com.bytedance.android.monitorV2.checker.AbsMixHandler;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PerfMixHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/TemplateMixHandler;", "Lcom/bytedance/android/monitorV2/checker/AbsMixHandler;", "()V", "canHandle", "", "accessor", "Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "realHandle", "", "settle", "fmpEnd", "", "result", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TemplateMixHandler extends AbsMixHandler {
    @Override // com.bytedance.android.monitorV2.checker.AbsMixHandler
    public boolean canHandle(JsonAccessor accessor) {
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        return true;
    }

    @Override // com.bytedance.android.monitorV2.checker.AbsMixHandler
    public void realHandle(JsonAccessor accessor) {
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Long duration = accessor.duration("res_load_perf.res_load_finish", "res_load_perf.res_load_start", 0L);
        long longValue = duration != null ? duration.longValue() : 0L;
        if (longValue > 0) {
            decreaseAdd(new AbsMixHandler.SubPerf(longValue, accessor));
        }
    }

    @Override // com.bytedance.android.monitorV2.checker.AbsMixHandler
    public void settle(long fmpEnd, JSONObject result) {
        JsonAccessor data;
        Intrinsics.checkNotNullParameter(result, "result");
        AbsMixHandler.SubPerf firstElement = getFirstElement();
        JsonUtils.safePut(result, PerfMixHandler.RES_TEMPLATE_DUR, createNewResDur((firstElement == null || (data = firstElement.getData()) == null) ? null : data.getData(), PerfMixHandler.RES_TEMPLATE_DUR));
    }
}
