package com.bytedance.android.monitor.entity;

import com.bytedance.android.monitor.base.BaseNativeInfo;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsbInfoData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/monitor/entity/JsbInfoData;", "Lcom/bytedance/android/monitor/base/BaseNativeInfo;", "()V", "bridgeName", "", "getBridgeName", "()Ljava/lang/String;", "setBridgeName", "(Ljava/lang/String;)V", "callbackTime", "", "getCallbackTime", "()J", "setCallbackTime", "(J)V", WiseOpenHianalyticsData.UNION_COSTTIME, "getCostTime", "setCostTime", "fireEventTime", "getFireEventTime", "setFireEventTime", "invokeTime", "getInvokeTime", "setInvokeTime", SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "getProtocolVersion", "setProtocolVersion", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "getStatusCode", "()I", "setStatusCode", "(I)V", "statusDescription", "getStatusDescription", "setStatusDescription", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "toString", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class JsbInfoData extends BaseNativeInfo {
    private String bridgeName;
    private long callbackTime;
    private long costTime;
    private long fireEventTime;
    private long invokeTime;
    private String protocolVersion;
    private int statusCode;
    private String statusDescription;

    public JsbInfoData() {
        super("jsbPerf");
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final void setBridgeName(String str) {
        this.bridgeName = str;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i) {
        this.statusCode = i;
    }

    public final String getStatusDescription() {
        return this.statusDescription;
    }

    public final void setStatusDescription(String str) {
        this.statusDescription = str;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final void setProtocolVersion(String str) {
        this.protocolVersion = str;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(long j) {
        this.costTime = j;
    }

    public final long getInvokeTime() {
        return this.invokeTime;
    }

    public final void setInvokeTime(long j) {
        this.invokeTime = j;
    }

    public final long getCallbackTime() {
        return this.callbackTime;
    }

    public final void setCallbackTime(long j) {
        this.callbackTime = j;
    }

    public final long getFireEventTime() {
        return this.fireEventTime;
    }

    public final void setFireEventTime(long j) {
        this.fireEventTime = j;
    }

    @Override // com.bytedance.android.monitor.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        JsonUtils.safePut(jsonObject, "bridge_name", this.bridgeName);
        JsonUtils.safePut(jsonObject, "status_code", this.statusCode);
        JsonUtils.safePut(jsonObject, "status_description", this.statusDescription);
        JsonUtils.safePut(jsonObject, "protocol_version", this.protocolVersion);
        JsonUtils.safePut(jsonObject, "cost_time", this.costTime);
        JsonUtils.safePut(jsonObject, "invoke_ts", this.invokeTime);
        JsonUtils.safePut(jsonObject, "callback_ts", this.callbackTime);
        JsonUtils.safePut(jsonObject, "fireEvent_ts", this.fireEventTime);
    }

    public String toString() {
        return "JsbInfoData(bridgeName=" + this.bridgeName + ", statusCode=" + this.statusCode + ", statusDescription=" + this.statusDescription + ", protocolVersion=" + this.protocolVersion + ", costTime=" + this.costTime + ", invokeTime=" + this.invokeTime + ", callbackTime=" + this.callbackTime + ", fireEventTime=" + this.fireEventTime + ')';
    }
}
