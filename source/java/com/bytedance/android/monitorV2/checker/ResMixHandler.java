package com.bytedance.android.monitorV2.checker;

import com.bytedance.android.monitorV2.checker.AbsMixHandler;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PerfMixHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/ResMixHandler;", "Lcom/bytedance/android/monitorV2/checker/AbsMixHandler;", "()V", "resCount", "", "resDurAvg", "", "resDurSum", "canHandle", "", "accessor", "Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "realHandle", "", "settle", "fmpEnd", "result", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResMixHandler extends AbsMixHandler {
    private int resCount;
    private long resDurAvg;
    private long resDurSum;

    @Override // com.bytedance.android.monitorV2.checker.AbsMixHandler
    public boolean canHandle(JsonAccessor accessor) {
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        String str = accessor.getStr("res_info.res_type", "");
        return getResTypeFilter().contains(str != null ? str : "");
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
        int i;
        Intrinsics.checkNotNullParameter(result, "result");
        ArrayList arrayList = new ArrayList();
        List<AbsMixHandler.SubPerf> elements = getElements();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = elements.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long long$default = JsonAccessor.getLong$default(((AbsMixHandler.SubPerf) next).getData(), "res_load_perf.res_load_finish", null, 2, null);
            if (((long$default != null ? long$default.longValue() : 0L) < fmpEnd ? 1 : 0) != 0) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = arrayList2;
        int size = arrayList3.size();
        this.resCount = size;
        if (size > 0) {
            for (Object obj : arrayList3) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AbsMixHandler.SubPerf subPerf = (AbsMixHandler.SubPerf) obj;
                if (i < getTopN()) {
                    arrayList.add(createNewResDur(subPerf.getData().getData(), PerfMixHandler.SUB_RES_DUR));
                }
                this.resDurSum += subPerf.getCost();
                i = i2;
            }
            this.resDurAvg = this.resDurSum / this.resCount;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "res_dur_avg", this.resDurAvg);
        JsonUtils.safePut(jSONObject, "res_count", this.resCount);
        JsonUtils.safePut(jSONObject, "res_dur_sum", this.resDurSum);
        JsonUtils.safePut(jSONObject, "sub_res_dur_list", new JSONArray((Collection) arrayList));
        JsonUtils.safePut(result, PerfMixHandler.SUB_RES_DUR, jSONObject);
    }
}
