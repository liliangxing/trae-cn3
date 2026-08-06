package com.bytedance.iesgurd.statistic.model;

import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StatisticSettingsData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u0006+"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/StatisticSettingsData;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "httpStatus", "getHttpStatus", "setHttpStatus", "isRetry", "", "()Z", "setRetry", "(Z)V", "localVersion", "getLocalVersion", "setLocalVersion", "logId", "getLogId", "setLogId", "probeHeader", "getProbeHeader", "setProbeHeader", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "(Lcom/bytedance/iesgurd/core/ReqType;)V", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "getVersion", "setVersion", "upload", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StatisticSettingsData {
    private int errCode;
    private String errorMsg;
    private int httpStatus;
    private boolean isRetry;
    private String localVersion;
    private String logId;
    private String probeHeader;
    private ReqType reqType = ReqType.NORMAL;
    private String version;

    public final int getHttpStatus() {
        return this.httpStatus;
    }

    public final void setHttpStatus(int i) {
        this.httpStatus = i;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final void setErrCode(int i) {
        this.errCode = i;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    /* renamed from: isRetry, reason: from getter */
    public final boolean getIsRetry() {
        return this.isRetry;
    }

    public final void setRetry(boolean z) {
        this.isRetry = z;
    }

    public final ReqType getReqType() {
        return this.reqType;
    }

    public final void setReqType(ReqType reqType) {
        Intrinsics.checkParameterIsNotNull(reqType, "<set-?>");
        this.reqType = reqType;
    }

    public final String getProbeHeader() {
        return this.probeHeader;
    }

    public final void setProbeHeader(String str) {
        this.probeHeader = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getLocalVersion() {
        return this.localVersion;
    }

    public final void setLocalVersion(String str) {
        this.localVersion = str;
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_version", "settings_v3");
        jSONObject.put("http_status", this.httpStatus);
        jSONObject.put("err_msg", this.errorMsg);
        jSONObject.put("req_type", this.reqType.getType());
        jSONObject.put("err_code", this.errCode);
        jSONObject.put("x_tlb_probe", this.probeHeader);
        jSONObject.put("local_version", this.localVersion);
        jSONObject.put(IPiaCacheProvider.CacheConfig.FIELD_VERSION, this.version);
        String str = this.logId;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put("x_tt_logid", this.logId);
        }
        if (this.isRetry) {
            jSONObject.put("is_retry", 1);
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_query_settings", jSONObject);
    }
}
