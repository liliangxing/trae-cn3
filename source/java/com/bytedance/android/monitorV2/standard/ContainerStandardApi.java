package com.bytedance.android.monitorV2.standard;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerNativeInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.NavigationUtil;
import com.bytedance.applog.server.Api;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerStandardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0004J9\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00112!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\r0&J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u0004J \u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J*\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0017J\u000e\u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u00104\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0007J \u00106\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00107\u001a\u000208J \u00109\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010/2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/android/monitorV2/standard/ContainerStandardApi;", "", "()V", "TAG", "", "actionMap", "", "Lcom/bytedance/android/monitorV2/standard/ContainerStandardAction;", "containerDataCache", "Lcom/bytedance/android/monitorV2/standard/ContainerDataCache;", "handler", "Landroid/os/Handler;", "addContext", "", "monitorId", Api.KEY_ENCRYPT_RESP_KEY, "value", "", "attach", "ct", "Lcom/bytedance/android/monitorV2/standard/ContainerType;", "batchCollect", "fields", "Lorg/json/JSONObject;", "collectBoolean", "field", "", "collectInt", "collectLong", "", "collectString", "customReport", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "generateIDForContainer", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "handleCollect", "handleNativeInfo", "view", "Landroid/view/View;", "type", "jsonObject", "invalidateID", "isContainerBase", "registerAction", "action", "reportContainerError", "error", "Lcom/bytedance/android/monitorV2/standard/ContainerError;", "reportContainerErrorWithoutContainerType", "containerBase", "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "viewForContainerID", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerStandardApi {
    public static final String TAG = "ContainerStandardApi";
    public static final ContainerStandardApi INSTANCE = new ContainerStandardApi();
    private static final ContainerDataCache containerDataCache = ContainerDataCache.INSTANCE;
    private static Map<String, ContainerStandardAction> actionMap = new LinkedHashMap();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private ContainerStandardApi() {
    }

    public final String generateIDForContainer() {
        String generateID = NavigationUtil.generateID();
        MonitorLog.m29i("ContainerStandardApi", "generateIDForContainer [monitorId:" + generateID + ']');
        Intrinsics.checkNotNullExpressionValue(generateID, "monitorId");
        return generateID;
    }

    public final void collectString(String monitorId, String field, String value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        MonitorLog.m29i("ContainerStandardApi", "collectString [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, value);
    }

    public final void collectInt(String monitorId, String field, int value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        MonitorLog.m29i("ContainerStandardApi", "collectInt [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Integer.valueOf(value));
    }

    public final void collectLong(String monitorId, String field, long value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        MonitorLog.m29i("ContainerStandardApi", "collectLong [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Long.valueOf(value));
    }

    public final void collectBoolean(String monitorId, String field, boolean value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        MonitorLog.m29i("ContainerStandardApi", "collectBoolean [monitorId:" + monitorId + "][field:" + field + "][value:" + value + ']');
        handleCollect(monitorId, field, Boolean.valueOf(value));
    }

    public final void batchCollect(String monitorId, JSONObject fields) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(fields, "fields");
        MonitorLog.m29i("ContainerStandardApi", "batchCollect [monitorId:" + monitorId + ']');
        Iterator<String> keys = fields.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "fields.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            ContainerStandardApi containerStandardApi = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(next, "it");
            Object obj = fields.get(next);
            Intrinsics.checkNotNullExpressionValue(obj, "fields[it]");
            containerStandardApi.handleCollect(monitorId, next, obj);
        }
    }

    public final void addContext(String monitorId, String key, String value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        MonitorLog.m29i("ContainerStandardApi", "addContainerContext [monitorId:" + monitorId + "][field:" + key + "][value:" + value + ']');
        containerDataCache.putContainerContext(monitorId, key, value);
    }

    public final void addContext(String monitorId, String key, int value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        MonitorLog.m29i("ContainerStandardApi", "addContainerContext [monitorId:" + monitorId + "][field:" + key + "][value:" + value + ']');
        containerDataCache.putContainerContext(monitorId, key, Integer.valueOf(value));
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
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(ct, "ct");
        MonitorLog.m29i("ContainerStandardApi", "attach [" + monitorId + "] containerType:" + ct.getType());
        ContainerDataCache containerDataCache2 = containerDataCache;
        containerDataCache2.attach(monitorId, ct);
        containerDataCache2.putContainerBase(monitorId, ContainerStandardConst.FIELD_CONTAINER_ID, monitorId);
        containerDataCache2.putContainerBase(monitorId, "container_type", ct.getType());
    }

    private final void reportContainerErrorWithoutContainerType(String monitorId, ContainerBase containerBase, ContainerError error) {
        CommonEvent commonEvent = new CommonEvent("containerError");
        commonEvent.onEventCreated();
        commonEvent.setNativeInfo(new ContainerNativeInfo());
        NativeCommon nativeCommon = new NativeCommon();
        nativeCommon.virtualAid = error.getVirtualAid();
        ContainerDataCache containerDataCache2 = containerDataCache;
        Object obj = containerDataCache2.getContainerInfo(monitorId).get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            nativeCommon.url = str;
        }
        Object obj2 = containerDataCache2.getContainerInfo(monitorId).get("native_page");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 != null) {
            nativeCommon.nativePage = str2;
        }
        Object obj3 = containerDataCache2.getContainerInfo(monitorId).get("container_type");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        if (str3 != null) {
            nativeCommon.containerType = str3;
        }
        commonEvent.setNativeBase(nativeCommon);
        commonEvent.setContainerInfo(error.toContainerInfo());
        commonEvent.setContainerBase(containerBase);
        commonEvent.onEventUpdated();
        DataReporter.reportCommonEvent$default(DataReporter.INSTANCE, commonEvent, null, null, 4, null);
    }

    public final void reportContainerError(View view, String monitorId, ContainerError error) {
        ContainerBase containerBase;
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(error, "error");
        MonitorLog.m29i("ContainerStandardApi", "reportContainerError [monitorId:" + monitorId + "][errorCode:" + error.getErrCode() + "][errorMsg:" + error.getErrorMsg() + ']');
        ContainerDataCache containerDataCache2 = containerDataCache;
        ContainerType attachedView = containerDataCache2.getAttachedView(monitorId);
        if (view != null) {
            containerBase = containerDataCache2.getContainerBaseByView(view);
        } else {
            containerBase = new ContainerBase((Map<String, ? extends Object>) containerDataCache2.getContainerBase(monitorId));
        }
        if (attachedView != null && actionMap.get(attachedView.getType()) != null) {
            ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
            Intrinsics.checkNotNull(containerStandardAction);
            containerStandardAction.handleContainerError(view, monitorId, containerBase, error);
            return;
        }
        reportContainerErrorWithoutContainerType(monitorId, containerBase, error);
    }

    public final void invalidateID(final String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        handler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.standard.ContainerStandardApi$invalidateID$1
            @Override // java.lang.Runnable
            public final void run() {
                ContainerDataCache containerDataCache2;
                MonitorLog.m29i("ContainerStandardApi", "invalidateID [monitorId:" + monitorId + ']');
                containerDataCache2 = ContainerStandardApi.containerDataCache;
                containerDataCache2.clearDataById(monitorId);
            }
        });
    }

    public final boolean isContainerBase(String field) {
        Intrinsics.checkNotNullParameter(field, "field");
        switch (field.hashCode()) {
            case -1573000044:
                return field.equals(ContainerStandardConst.FIELD_VIEW_TYPE);
            case -907987551:
                return field.equals("schema");
            case -245775970:
                return field.equals("template_res_type");
            case -77002359:
                return field.equals(ContainerStandardConst.FIELD_CLIENT_COMPONENT);
            case 97555:
                return field.equals("biz");
            case 351608024:
                return field.equals("version");
            case 855478153:
                return field.equals("container_name");
            case 946461684:
                return field.equals(ContainerStandardConst.FIELD_CORE_VIEW_TYPE);
            case 2138439450:
                return field.equals(ContainerStandardConst.FIELD_CONTAINER_VERSION);
            default:
                return false;
        }
    }

    public final View viewForContainerID(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        ContainerType attachedView = containerDataCache.getAttachedView(monitorId);
        if (attachedView != null) {
            return attachedView.getContainer();
        }
        return null;
    }

    public final void registerAction(String name, ContainerStandardAction action) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(action, "action");
        actionMap.put(name, action);
    }

    public final void customReport(CustomInfo customInfo) {
        Unit unit;
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
        ContainerDataCache containerDataCache2 = containerDataCache;
        String monitorId = customInfo.getMonitorId();
        Intrinsics.checkNotNullExpressionValue(monitorId, "customInfo.monitorId");
        ContainerType attachedView = containerDataCache2.getAttachedView(monitorId);
        Unit unit2 = null;
        if (attachedView != null) {
            String type = attachedView.getType();
            if (Intrinsics.areEqual(type, "web") ? true : Intrinsics.areEqual(type, "lynx")) {
                ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
                if (containerStandardAction != null) {
                    containerStandardAction.customReport(attachedView.getContainer(), customInfo);
                    unit = Unit.INSTANCE;
                }
            } else {
                HybridMultiMonitor.getInstance().customReport(customInfo);
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            HybridMultiMonitor.getInstance().customReport(customInfo);
        }
    }

    public final void handleNativeInfo(View view, String monitorId, String type, JSONObject jsonObject) {
        Unit unit;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (monitorId == null) {
            MonitorLog.m27e("ContainerStandardApi", "handleNativeInfo, monitorId is null");
            return;
        }
        ContainerType attachedView = containerDataCache.getAttachedView(monitorId);
        Unit unit2 = null;
        if (attachedView != null) {
            String type2 = attachedView.getType();
            if (Intrinsics.areEqual(type2, "lynx") ? true : Intrinsics.areEqual(type2, "web")) {
                ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
                if (containerStandardAction != null) {
                    containerStandardAction.handleNativeInfo(attachedView.getContainer(), type, jsonObject);
                    unit = Unit.INSTANCE;
                }
            } else {
                MonitorLog.m27e("ContainerStandardApi", "handleNativeInfo, type not register");
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            MonitorLog.m27e("ContainerStandardApi", "handleNativeInfo, attachedView is null");
        }
    }

    public final void getPerformance(String monitorId, int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        ContainerType attachedView = containerDataCache.getAttachedView(monitorId);
        Unit unit2 = null;
        if (attachedView != null) {
            String type = attachedView.getType();
            if (Intrinsics.areEqual(type, "lynx") ? true : Intrinsics.areEqual(type, "web")) {
                ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
                if (containerStandardAction != null) {
                    containerStandardAction.getPerformance(attachedView.getContainer(), waitCompleteData, performanceCallback);
                    unit = Unit.INSTANCE;
                }
            } else {
                MonitorLog.m27e("ContainerStandardApi", "handleNativeInfo, type not register");
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            MonitorLog.m27e("ContainerStandardApi", "getPerformance, attachedView is null");
        }
    }

    public final EngineInfo getUnifyInfo(String monitorId) {
        Unit unit;
        EngineInfo unifyInfo;
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        ContainerType attachedView = containerDataCache.getAttachedView(monitorId);
        if (attachedView != null) {
            String type = attachedView.getType();
            if (Intrinsics.areEqual(type, "lynx") ? true : Intrinsics.areEqual(type, "web")) {
                ContainerStandardAction containerStandardAction = actionMap.get(attachedView.getType());
                return (containerStandardAction == null || (unifyInfo = containerStandardAction.getUnifyInfo(attachedView.getContainer())) == null) ? new EngineInfo(new NativeCommon()) : unifyInfo;
            }
            MonitorLog.m27e("ContainerStandardApi", "getUnifyInfo, type not register");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            MonitorLog.m27e("ContainerStandardApi", "getUnifyInfo, attachedView is null");
        }
        return new EngineInfo(new NativeCommon());
    }
}
