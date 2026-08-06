package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.PreloadConfig;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusInitDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00018Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003Jq\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\tHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse;", "", "isSucceed", "", ApmTrafficStats.TTNET_RESPONSE, "Ljava/io/InputStream;", "jsonResponse", "Lorg/json/JSONObject;", "msg", "", "geckoVersion", "fetchUrl", "requestLogId", "fromRetry", "networkLogicVersion", "(ZLjava/io/InputStream;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getFetchUrl", "()Ljava/lang/String;", "setFetchUrl", "(Ljava/lang/String;)V", "getFromRetry", "()Z", "setFromRetry", "(Z)V", "getGeckoVersion", "setGeckoVersion", "setSucceed", "getJsonResponse", "()Lorg/json/JSONObject;", "setJsonResponse", "(Lorg/json/JSONObject;)V", "getMsg", "setMsg", "getNetworkLogicVersion", "setNetworkLogicVersion", "getRequestLogId", "setRequestLogId", "getResponse", "()Ljava/io/InputStream;", "setResponse", "(Ljava/io/InputStream;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "GeckoVersionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArgusGeckoResponse {
    private String fetchUrl;
    private boolean fromRetry;
    private String geckoVersion;
    private boolean isSucceed;
    private JSONObject jsonResponse;
    private String msg;
    private String networkLogicVersion;
    private String requestLogId;
    private InputStream response;

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSucceed() {
        return this.isSucceed;
    }

    /* renamed from: component2, reason: from getter */
    public final InputStream getResponse() {
        return this.response;
    }

    /* renamed from: component3, reason: from getter */
    public final JSONObject getJsonResponse() {
        return this.jsonResponse;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGeckoVersion() {
        return this.geckoVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFetchUrl() {
        return this.fetchUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRequestLogId() {
        return this.requestLogId;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getFromRetry() {
        return this.fromRetry;
    }

    /* renamed from: component9, reason: from getter */
    public final String getNetworkLogicVersion() {
        return this.networkLogicVersion;
    }

    public final ArgusGeckoResponse copy(boolean isSucceed, InputStream response, JSONObject jsonResponse, String msg, String geckoVersion, String fetchUrl, String requestLogId, boolean fromRetry, String networkLogicVersion) {
        return new ArgusGeckoResponse(isSucceed, response, jsonResponse, msg, geckoVersion, fetchUrl, requestLogId, fromRetry, networkLogicVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusGeckoResponse)) {
            return false;
        }
        ArgusGeckoResponse argusGeckoResponse = (ArgusGeckoResponse) other;
        return this.isSucceed == argusGeckoResponse.isSucceed && Intrinsics.areEqual(this.response, argusGeckoResponse.response) && Intrinsics.areEqual(this.jsonResponse, argusGeckoResponse.jsonResponse) && Intrinsics.areEqual(this.msg, argusGeckoResponse.msg) && Intrinsics.areEqual(this.geckoVersion, argusGeckoResponse.geckoVersion) && Intrinsics.areEqual(this.fetchUrl, argusGeckoResponse.fetchUrl) && Intrinsics.areEqual(this.requestLogId, argusGeckoResponse.requestLogId) && this.fromRetry == argusGeckoResponse.fromRetry && Intrinsics.areEqual(this.networkLogicVersion, argusGeckoResponse.networkLogicVersion);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isSucceed) * 31;
        InputStream inputStream = this.response;
        int hashCode2 = (hashCode + (inputStream == null ? 0 : inputStream.hashCode())) * 31;
        JSONObject jSONObject = this.jsonResponse;
        int hashCode3 = (hashCode2 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str = this.msg;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.geckoVersion;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fetchUrl;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.requestLogId;
        int hashCode7 = (((hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.fromRetry)) * 31;
        String str5 = this.networkLogicVersion;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ArgusGeckoResponse(isSucceed=" + this.isSucceed + ", response=" + this.response + ", jsonResponse=" + this.jsonResponse + ", msg=" + this.msg + ", geckoVersion=" + this.geckoVersion + ", fetchUrl=" + this.fetchUrl + ", requestLogId=" + this.requestLogId + ", fromRetry=" + this.fromRetry + ", networkLogicVersion=" + this.networkLogicVersion + ')';
    }

    public ArgusGeckoResponse(boolean z, InputStream inputStream, JSONObject jSONObject, String str, String str2, String str3, String str4, boolean z2, String str5) {
        this.isSucceed = z;
        this.response = inputStream;
        this.jsonResponse = jSONObject;
        this.msg = str;
        this.geckoVersion = str2;
        this.fetchUrl = str3;
        this.requestLogId = str4;
        this.fromRetry = z2;
        this.networkLogicVersion = str5;
    }

    public final boolean isSucceed() {
        return this.isSucceed;
    }

    public final void setSucceed(boolean z) {
        this.isSucceed = z;
    }

    public final InputStream getResponse() {
        return this.response;
    }

    public final void setResponse(InputStream inputStream) {
        this.response = inputStream;
    }

    public final JSONObject getJsonResponse() {
        return this.jsonResponse;
    }

    public final void setJsonResponse(JSONObject jSONObject) {
        this.jsonResponse = jSONObject;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public /* synthetic */ ArgusGeckoResponse(boolean z, InputStream inputStream, JSONObject jSONObject, String str, String str2, String str3, String str4, boolean z2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : inputStream, (i & 4) != 0 ? null : jSONObject, (i & 8) != 0 ? null : str, (i & 16) != 0 ? GeckoVersionId.UNSET.getString() : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? false : z2, (i & 256) == 0 ? str5 : null);
    }

    public final String getGeckoVersion() {
        return this.geckoVersion;
    }

    public final void setGeckoVersion(String str) {
        this.geckoVersion = str;
    }

    public final String getFetchUrl() {
        return this.fetchUrl;
    }

    public final void setFetchUrl(String str) {
        this.fetchUrl = str;
    }

    public final String getRequestLogId() {
        return this.requestLogId;
    }

    public final void setRequestLogId(String str) {
        this.requestLogId = str;
    }

    public final boolean getFromRetry() {
        return this.fromRetry;
    }

    public final void setFromRetry(boolean z) {
        this.fromRetry = z;
    }

    public final String getNetworkLogicVersion() {
        return this.networkLogicVersion;
    }

    public final void setNetworkLogicVersion(String str) {
        this.networkLogicVersion = str;
    }

    /* compiled from: ArgusInitDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse$GeckoVersionId;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "UNSET", "PKG_NOT_FOUND", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public enum GeckoVersionId {
        UNSET("-2"),
        PKG_NOT_FOUND("-1");

        private final String string;

        GeckoVersionId(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }
}
