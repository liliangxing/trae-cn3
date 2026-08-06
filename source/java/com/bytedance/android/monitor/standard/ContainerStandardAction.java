package com.bytedance.android.monitor.standard;

import android.view.View;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;

/* compiled from: ContainerStandardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitor/standard/ContainerStandardAction;", "", "handleCollectEvent", "", "view", "Landroid/view/View;", "field", "", "value", "handleContainerError", TraceStatsConsts.STATS_BASE_MODULE, "Lcom/bytedance/android/monitor/entity/ContainerCommon;", "error", "Lcom/bytedance/android/monitor/standard/ContainerError;", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public interface ContainerStandardAction {
    void handleCollectEvent(View view, String field, Object value);

    void handleContainerError(View view, ContainerCommon base, ContainerError error);
}
