package com.bytedance.iesgurd.statistic.model;

import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.notification.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StatisticUpdateData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010:\u001a\u00020;R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014¨\u0006<"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/StatisticUpdateData;", "", "()V", "accessKey", "", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "apiVersion", "getApiVersion", "setApiVersion", "channels", "getChannels", "setChannels", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errorMsg", "getErrorMsg", "setErrorMsg", "groupName", "getGroupName", "setGroupName", "httpStatus", "getHttpStatus", "setHttpStatus", "isIntercept", "setIntercept", "isRetry", "", "()Z", "setRetry", "(Z)V", "logId", "getLogId", "setLogId", "optionParams", "Lcom/bytedance/geckox/GeckoUpdateParams;", "getOptionParams", "()Lcom/bytedance/geckox/GeckoUpdateParams;", "setOptionParams", "(Lcom/bytedance/geckox/GeckoUpdateParams;)V", "probeHeader", "getProbeHeader", "setProbeHeader", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "syncTaskId", "getSyncTaskId", "setSyncTaskId", "upload", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StatisticUpdateData {
    private String apiVersion;
    private int errCode;
    private String errorMsg;
    private int httpStatus;
    private int isIntercept;
    private boolean isRetry;
    private String logId;
    private GeckoUpdateParams optionParams;
    private String probeHeader;
    private int syncTaskId;
    private ReqType reqType = ReqType.NORMAL;
    private String accessKey = "";
    private String channels = "";
    private String groupName = "";

    public final ReqType getReqType() {
        return this.reqType;
    }

    public final void setReqType(ReqType reqType) {
        Intrinsics.checkParameterIsNotNull(reqType, "<set-?>");
        this.reqType = reqType;
    }

    public final int getHttpStatus() {
        return this.httpStatus;
    }

    public final void setHttpStatus(int i) {
        this.httpStatus = i;
    }

    /* renamed from: isIntercept, reason: from getter */
    public final int getIsIntercept() {
        return this.isIntercept;
    }

    public final void setIntercept(int i) {
        this.isIntercept = i;
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

    public final int getSyncTaskId() {
        return this.syncTaskId;
    }

    public final void setSyncTaskId(int i) {
        this.syncTaskId = i;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getChannels() {
        return this.channels;
    }

    public final void setChannels(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.channels = str;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.groupName = str;
    }

    public final GeckoUpdateParams getOptionParams() {
        return this.optionParams;
    }

    public final void setOptionParams(GeckoUpdateParams geckoUpdateParams) {
        this.optionParams = geckoUpdateParams;
    }

    public final String getProbeHeader() {
        return this.probeHeader;
    }

    public final void setProbeHeader(String str) {
        this.probeHeader = str;
    }

    /* renamed from: isRetry, reason: from getter */
    public final boolean getIsRetry() {
        return this.isRetry;
    }

    public final void setRetry(boolean z) {
        this.isRetry = z;
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_version", this.apiVersion);
        jSONObject.put("http_status", this.httpStatus);
        jSONObject.put("err_msg", this.errorMsg);
        jSONObject.put("req_type", this.reqType.getType());
        jSONObject.put("is_intercept", this.isIntercept);
        jSONObject.put("err_code", this.errCode);
        jSONObject.put("x_tlb_probe", this.probeHeader);
        int i = this.syncTaskId;
        if (i != 0) {
            jSONObject.put("sync_task_id", i);
        }
        String str = this.logId;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put("x_tt_logid", this.logId);
        }
        if (this.accessKey.length() > 0) {
            jSONObject.put("access_key", this.accessKey);
        }
        if (this.channels.length() > 0) {
            jSONObject.put("channels", this.channels);
        }
        if (this.groupName.length() > 0) {
            jSONObject.put("group_name", this.groupName);
        }
        if (this.isRetry) {
            jSONObject.put("is_retry", 1);
        }
        GeckoUpdateParams geckoUpdateParams = this.optionParams;
        if (geckoUpdateParams != null) {
            jSONObject.put("lazy_model", geckoUpdateParams.getOnDemand());
            if (geckoUpdateParams.getPriority() != IESGurdUpdatePriority.MIDDLE) {
                jSONObject.put("download_priority", geckoUpdateParams.getPriority());
            }
            if (geckoUpdateParams.getTag().length() > 0) {
                jSONObject.put(Constants.NOTIFICATION_TAG, geckoUpdateParams.getTag());
            }
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_query_pkgs", jSONObject);
    }
}
