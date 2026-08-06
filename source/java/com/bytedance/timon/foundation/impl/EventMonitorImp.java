package com.bytedance.timon.foundation.impl;

import android.app.Application;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventMonitorImp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J.\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J,\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J6\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/timon/foundation/impl/EventMonitorImp;", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "context", "Landroid/app/Application;", Constant.KEY_CHANNEL, "", "deviceId", "hostAId", "", "timonAppId", AccountMonitorConstants.NEW_SDK_VERSION_KEY, "hostVersionName", "hostUpdateVersionCode", "", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDeviceId", "()Ljava/lang/String;", "monitorInstance", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "kotlin.jvm.PlatformType", "getMonitorInstance", "()Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "monitorInstance$delegate", "Lkotlin/Lazy;", "monitorDuration", "", "serviceName", ReportConstant.COMMON_INIT_DURATION, "Lorg/json/JSONObject;", "logExtra", "monitorEvent", "category", "metric", "monitorStatusAndDuration", PageDataManager.EXTRA_STATUS, "monitorStatusAndEvent", "monitorStatusRate", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EventMonitorImp implements IEventMonitor {
    private final String deviceId;
    private final long hostUpdateVersionCode;
    private final String hostVersionName;

    /* renamed from: monitorInstance$delegate, reason: from kotlin metadata */
    private final Lazy monitorInstance;
    private final String sdkVersion;
    private final String timonAppId;

    public final SDKMonitor getMonitorInstance() {
        return (SDKMonitor) this.monitorInstance.getValue();
    }

    public EventMonitorImp(final Application application, final String str, String str2, final int i, String str3, String str4, String str5, long j) {
        Intrinsics.checkParameterIsNotNull(application, "context");
        Intrinsics.checkParameterIsNotNull(str, Constant.KEY_CHANNEL);
        Intrinsics.checkParameterIsNotNull(str2, "deviceId");
        Intrinsics.checkParameterIsNotNull(str3, "timonAppId");
        Intrinsics.checkParameterIsNotNull(str4, AccountMonitorConstants.NEW_SDK_VERSION_KEY);
        Intrinsics.checkParameterIsNotNull(str5, "hostVersionName");
        this.deviceId = str2;
        this.timonAppId = str3;
        this.sdkVersion = str4;
        this.hostVersionName = str5;
        this.hostUpdateVersionCode = j;
        this.monitorInstance = LazyKt.lazy(new Function0<SDKMonitor>() { // from class: com.bytedance.timon.foundation.impl.EventMonitorImp$monitorInstance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SDKMonitor m1041invoke() {
                String str6;
                String str7;
                long j2;
                String str8;
                String str9;
                String str10;
                String str11;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("device_id", EventMonitorImp.this.getDeviceId());
                jSONObject.put(Constant.KEY_HOST_AID, i);
                jSONObject.put(Constant.KEY_CHANNEL, str);
                str6 = EventMonitorImp.this.sdkVersion;
                jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, str6);
                str7 = EventMonitorImp.this.hostVersionName;
                jSONObject.put(Constant.KEY_APP_VERSION, str7);
                j2 = EventMonitorImp.this.hostUpdateVersionCode;
                jSONObject.put(Constant.KEY_UPDATE_VERSION_CODE, j2);
                str8 = EventMonitorImp.this.timonAppId;
                SDKMonitorUtils.setConfigUrl(str8, CollectionsKt.listOf("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));
                str9 = EventMonitorImp.this.timonAppId;
                SDKMonitorUtils.setDefaultReportUrl(str9, CollectionsKt.listOf(ReportConstant.DEFAULT_URL_REPORT));
                Application application2 = application;
                str10 = EventMonitorImp.this.timonAppId;
                SDKMonitorUtils.initMonitor(application2, str10, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.timon.foundation.impl.EventMonitorImp$monitorInstance$2.1
                    public String getSessionId() {
                        return null;
                    }

                    public Map<String, String> getCommonParams() {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("device_id", EventMonitorImp.this.getDeviceId());
                        linkedHashMap.put(Constant.KEY_HOST_AID, String.valueOf(i));
                        linkedHashMap.put(Constant.KEY_CHANNEL, str);
                        return linkedHashMap;
                    }
                });
                str11 = EventMonitorImp.this.timonAppId;
                return SDKMonitorUtils.getInstance(str11);
            }
        });
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorDuration(String serviceName, JSONObject duration, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        getMonitorInstance().monitorDuration(serviceName, duration, logExtra);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        getMonitorInstance().monitorEvent(serviceName, category, logExtra, metric);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusAndDuration(String serviceName, int status, JSONObject duration, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        getMonitorInstance().monitorStatusAndDuration(serviceName, status, duration, logExtra);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusAndEvent(String serviceName, int status, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        getMonitorInstance().monitorStatusAndEvent(serviceName, status, category, metric, logExtra);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusRate(String serviceName, int status, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        getMonitorInstance().monitorStatusRate(serviceName, status, logExtra);
    }
}
