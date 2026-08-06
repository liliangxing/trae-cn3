package com.bytedance.android.monitorV2.standard;

import android.view.View;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: ContainerStandardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J=\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\fH&J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H&J*\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\"\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\rH&¨\u0006 "}, d2 = {"Lcom/bytedance/android/monitorV2/standard/ContainerStandardAction;", "", "customReport", "", "view", "Landroid/view/View;", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "getPerformance", "waitCompleteData", "", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "handleCollectEvent", "field", "", "value", "handleContainerError", "monitorId", TraceStatsConsts.STATS_BASE_MODULE, "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "error", "Lcom/bytedance/android/monitorV2/standard/ContainerError;", "handleNativeInfo", "type", "jsonObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ContainerStandardAction {
    void customReport(View view, CustomInfo customInfo);

    void getPerformance(View view, int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback);

    EngineInfo getUnifyInfo(View view);

    void handleCollectEvent(View view, String field, Object value);

    void handleContainerError(View view, String monitorId, ContainerBase base, ContainerError error);

    void handleNativeInfo(View view, String type, JSONObject jsonObject);
}
