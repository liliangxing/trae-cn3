package com.bytedance.forest;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.delegates.ReportDelegate;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ResourceReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015JY\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00180\u00182\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/forest/ResourceReporter;", "", "()V", "TAG", "", "reportDelegates", "", "Lcom/bytedance/forest/delegates/ReportDelegate;", "customReport", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "eventName", "category", "Lorg/json/JSONObject;", "metrics", "extra", "sampleLevel", "", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "customReport$forest_release", "onReportResult", "data", "", "onReportResult$forest_release", "registerReportDelegate", "delegate", "unregisterReportDelegate", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourceReporter {
    public static final String TAG = "ResourceReporter";
    public static final ResourceReporter INSTANCE = new ResourceReporter();
    private static final List<ReportDelegate> reportDelegates = new ArrayList();

    private ResourceReporter() {
    }

    public final void registerReportDelegate(ReportDelegate delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        List<ReportDelegate> list = reportDelegates;
        synchronized (list) {
            list.add(delegate);
        }
    }

    public final void unregisterReportDelegate(ReportDelegate delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        List<ReportDelegate> list = reportDelegates;
        synchronized (list) {
            list.remove(delegate);
        }
    }

    public final void onReportResult$forest_release(String eventName, Map<String, ? extends Map<String, ? extends Object>> data, Map<String, ? extends Object> extra, Response response, ForestPipelineContext context) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(context, "context");
        List<ReportDelegate> list = reportDelegates;
        synchronized (list) {
            for (ReportDelegate reportDelegate : list) {
                try {
                    Result.Companion companion = Result.Companion;
                    reportDelegate.onReportResult(eventName, data, extra, response);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    ForestLogger.print$default(context.getLogger(), 6, TAG, "custom report error", false, th2, null, 40, null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void customReport$forest_release(Response response, String eventName, JSONObject category, JSONObject metrics, JSONObject extra, int sampleLevel, ForestPipelineContext context) {
        Object obj;
        String str;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(metrics, "metrics");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        Intrinsics.checkParameterIsNotNull(context, "context");
        List<ReportDelegate> list = reportDelegates;
        synchronized (list) {
            for (ReportDelegate reportDelegate : list) {
                try {
                    Result.Companion companion = Result.Companion;
                    String originUrl = response.getRequest().getOriginUrl();
                    String groupId = response.getRequest().getGroupId();
                    String str2 = null;
                    if (!(groupId.length() > 0)) {
                        groupId = null;
                    }
                    if (groupId != null) {
                        str = groupId;
                    } else {
                        Object obj2 = response.getRequest().getCustomParams().get("rl_container_uuid");
                        if (obj2 instanceof String) {
                            str2 = obj2;
                        }
                        str = str2;
                    }
                    reportDelegate.customReport(response, eventName, originUrl, null, str, category, metrics, extra, sampleLevel);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    ForestLogger.print$default(context.getLogger(), 6, TAG, "custom report error", false, th2, null, 40, null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
