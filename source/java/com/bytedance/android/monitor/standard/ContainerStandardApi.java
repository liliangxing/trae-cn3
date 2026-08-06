package com.bytedance.android.monitor.standard;

import android.view.View;
import com.bytedance.android.monitor.DataMonitor;
import com.bytedance.android.monitor.base.BaseNativeInfo;
import com.bytedance.android.monitor.base.IMonitorData;
import com.bytedance.android.monitor.base.IReportData;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerNativeInfo;
import com.bytedance.android.monitor.entity.NativeCommon;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.util.NavigationUtil;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorDefault;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerStandardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0007J \u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/android/monitor/standard/ContainerStandardApi;", "", "()V", "TAG", "", "actionMap", "", "Lcom/bytedance/android/monitor/standard/ContainerStandardAction;", "containerDataCache", "Lcom/bytedance/android/monitor/standard/ContainerDataCache;", "attach", "", "monitorId", "ct", "Lcom/bytedance/android/monitor/standard/ContainerType;", "collectBoolean", "field", "value", "", "collectInt", "", "collectLong", "", "collectString", "generateIDForContainer", "handleCollect", "invalidateID", "isContainerBase", "registerAction", "name", "action", "reportContainerError", "view", "Landroid/view/View;", "error", "Lcom/bytedance/android/monitor/standard/ContainerError;", "reportContainerErrorWithoutContainerType", "mContainerCommon", "Lcom/bytedance/android/monitor/entity/ContainerCommon;", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerStandardApi {
    public static final String TAG = "ContainerStandardApi";
    public static final ContainerStandardApi INSTANCE = new ContainerStandardApi();
    private static final ContainerDataCache containerDataCache = ContainerDataCache.INSTANCE;
    private static Map<String, ContainerStandardAction> actionMap = new LinkedHashMap();

    private ContainerStandardApi() {
    }

    public final String generateIDForContainer() {
        String generateID = NavigationUtil.generateID();
        MonitorLog.m10v("ContainerStandardApi", "generateIDForContainer [monitorId:" + generateID + ']');
        Intrinsics.checkExpressionValueIsNotNull(generateID, "monitorId");
        return generateID;
    }

    public final void collectString(String monitorId, String field, String value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        Intrinsics.checkParameterIsNotNull(value, "value");
        MonitorLog.m10v("ContainerStandardApi", "collectString [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, value);
    }

    public final void collectInt(String monitorId, String field, int value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        MonitorLog.m10v("ContainerStandardApi", "collectInt [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Integer.valueOf(value));
    }

    public final void collectLong(String monitorId, String field, long value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        MonitorLog.m10v("ContainerStandardApi", "collectLong [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Long.valueOf(value));
    }

    public final void collectBoolean(String monitorId, String field, boolean value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        MonitorLog.m10v("ContainerStandardApi", "collectBoolean [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Boolean.valueOf(value));
    }

    private final void handleCollect(String monitorId, String field, Object value) {
        ContainerStandardAction containerStandardAction;
        if (isContainerBase(field)) {
            containerDataCache.putContainerBase(monitorId, field, value);
        } else {
            containerDataCache.putContainerInfo(monitorId, field, value);
        }
        ContainerType attachedView = containerDataCache.getAttachedView(monitorId);
        if (attachedView == null || (containerStandardAction = actionMap.get(attachedView.getType())) == null) {
            return;
        }
        containerStandardAction.handleCollectEvent(attachedView.getContainer(), field, value);
    }

    public final void attach(String monitorId, ContainerType ct) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(ct, "ct");
        MonitorLog.m10v("ContainerStandardApi", "attach [monitorId:" + monitorId + "][containerType:" + ct.getType() + ']');
        containerDataCache.attach(monitorId, ct);
    }

    private final void reportContainerErrorWithoutContainerType(final ContainerCommon mContainerCommon, final ContainerError error) {
        DataMonitor.monitor(new IReportData() { // from class: com.bytedance.android.monitor.standard.ContainerStandardApi$reportContainerErrorWithoutContainerType$iReportData$1
            @Override // com.bytedance.android.monitor.base.IReportData
            public String getContainerType() {
                return "";
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public String getEventType() {
                return "containerError";
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public JSONObject getJsBase() {
                return null;
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public JSONObject getJsInfo() {
                return null;
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public BaseNativeInfo getNativeInfo() {
                return new ContainerNativeInfo();
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public IMonitorData getNativeBase() {
                NativeCommon nativeCommon = new NativeCommon();
                nativeCommon.virtualAid = ContainerError.this.getVirtualAid();
                nativeCommon.containerType = null;
                return nativeCommon;
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public IMonitorData getContainerInfo() {
                return ContainerError.this.toContainerInfo();
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public IMonitorData getContainerBase() {
                return mContainerCommon;
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public String getBiz() {
                return ContainerError.this.getBiz();
            }
        }, new TTLiveWebViewMonitorDefault());
    }

    public final void reportContainerError(View view, String monitorId, ContainerError error) {
        ContainerCommon containerCommon;
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(error, "error");
        MonitorLog.m10v("ContainerStandardApi", "reportContainerError [monitorId:" + monitorId + "][errorCode:" + error.getErrCode() + "][errorMsg:" + error.getErrorMsg() + ']');
        ContainerDataCache containerDataCache2 = containerDataCache;
        ContainerType attachedView = containerDataCache2.getAttachedView(monitorId);
        if (view != null) {
            containerCommon = containerDataCache2.getContainerCommonByView(view);
        } else {
            containerCommon = new ContainerCommon((Map<String, ? extends Object>) containerDataCache2.getContainerBase(monitorId));
        }
        if (attachedView != null && actionMap.get(attachedView.getType()) != null) {
            ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
            if (containerStandardAction == null) {
                Intrinsics.throwNpe();
            }
            containerStandardAction.handleContainerError(view, containerCommon, error);
            return;
        }
        reportContainerErrorWithoutContainerType(containerCommon, error);
    }

    public final void invalidateID(String monitorId) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        MonitorLog.m10v("ContainerStandardApi", "invalidateID [monitorId:" + monitorId + ']');
        containerDataCache.clearDataById(monitorId);
    }

    public final boolean isContainerBase(String field) {
        Intrinsics.checkParameterIsNotNull(field, "field");
        int hashCode = field.hashCode();
        return hashCode != -907987551 ? hashCode != -245775970 ? hashCode == 855478153 && field.equals("container_name") : field.equals("template_res_type") : field.equals("schema");
    }

    public final void registerAction(String name, ContainerStandardAction action) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(action, "action");
        actionMap.put(name, action);
    }
}
