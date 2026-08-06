package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.timonbase.scene.PageDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AuthResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003JK\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010_\u001a\u00020\u00032\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u000eHÖ\u0001J\t\u0010b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R\u001c\u0010>\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u001a\u0010A\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00108\"\u0004\bE\u0010:R\u001a\u0010F\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010IR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0013\"\u0004\bS\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "", "passed", "", "interrupt", PageDataManager.EXTRA_STATUS, "", AccountMonitorConstants.CommonParameter.ERROR, "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "successCode", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;", "needReport", "(ZZLjava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;Z)V", "authCode", "", "getAuthCode", "()I", "authFeId", "getAuthFeId", "()Ljava/lang/String;", "setAuthFeId", "(Ljava/lang/String;)V", "authFeIdMapper", "getAuthFeIdMapper", "setAuthFeIdMapper", "authMode", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthMode;", "getAuthMode", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthMode;", "setAuthMode", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthMode;)V", "authMsg", "getAuthMsg", "authUrl", "getAuthUrl", "setAuthUrl", "callNamespace", "getCallNamespace", "setCallNamespace", "getErrorCode", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "setErrorCode", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;)V", "feAuthConfigSource", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "getFeAuthConfigSource", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "setFeAuthConfigSource", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;)V", "feAuthGroup", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "getFeAuthGroup", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "setFeAuthGroup", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;)V", "getInterrupt", "()Z", "setInterrupt", "(Z)V", "lynxTasmFeId", "getLynxTasmFeId", "setLynxTasmFeId", "methodAuthType", "getMethodAuthType", "setMethodAuthType", "methodName", "getMethodName", "setMethodName", "getNeedReport", "setNeedReport", "packageVersion", "getPackageVersion", "setPackageVersion", "(I)V", "getPassed", "setPassed", "requestTrackings", "Lorg/json/JSONObject;", "getRequestTrackings", "()Lorg/json/JSONObject;", "setRequestTrackings", "(Lorg/json/JSONObject;)V", "getStatus", "setStatus", "getSuccessCode", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;", "setSuccessCode", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class AuthResult {
    private String authFeId;
    private String authFeIdMapper;
    private AuthMode authMode;
    private String authUrl;
    private String callNamespace;
    private AuthErrorCode errorCode;
    private FeAuthConfigSource feAuthConfigSource;
    private AuthBridgeAccess feAuthGroup;
    private boolean interrupt;
    private String lynxTasmFeId;
    private AuthBridgeAccess methodAuthType;
    private String methodName;
    private boolean needReport;
    private int packageVersion;
    private boolean passed;
    private JSONObject requestTrackings;
    private String status;
    private AuthSuccessCode successCode;

    public static /* synthetic */ AuthResult copy$default(AuthResult authResult, boolean z, boolean z2, String str, AuthErrorCode authErrorCode, AuthSuccessCode authSuccessCode, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = authResult.passed;
        }
        if ((i & 2) != 0) {
            z2 = authResult.interrupt;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            str = authResult.status;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            authErrorCode = authResult.errorCode;
        }
        AuthErrorCode authErrorCode2 = authErrorCode;
        if ((i & 16) != 0) {
            authSuccessCode = authResult.successCode;
        }
        AuthSuccessCode authSuccessCode2 = authSuccessCode;
        if ((i & 32) != 0) {
            z3 = authResult.needReport;
        }
        return authResult.copy(z, z4, str2, authErrorCode2, authSuccessCode2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getPassed() {
        return this.passed;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getInterrupt() {
        return this.interrupt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final AuthErrorCode getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5, reason: from getter */
    public final AuthSuccessCode getSuccessCode() {
        return this.successCode;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getNeedReport() {
        return this.needReport;
    }

    public final AuthResult copy(boolean passed, boolean interrupt, String status, AuthErrorCode errorCode, AuthSuccessCode successCode, boolean needReport) {
        return new AuthResult(passed, interrupt, status, errorCode, successCode, needReport);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthResult)) {
            return false;
        }
        AuthResult authResult = (AuthResult) other;
        return this.passed == authResult.passed && this.interrupt == authResult.interrupt && Intrinsics.areEqual(this.status, authResult.status) && this.errorCode == authResult.errorCode && this.successCode == authResult.successCode && this.needReport == authResult.needReport;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.passed) * 31) + Boolean.hashCode(this.interrupt)) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        AuthErrorCode authErrorCode = this.errorCode;
        int hashCode3 = (hashCode2 + (authErrorCode == null ? 0 : authErrorCode.hashCode())) * 31;
        AuthSuccessCode authSuccessCode = this.successCode;
        return ((hashCode3 + (authSuccessCode != null ? authSuccessCode.hashCode() : 0)) * 31) + Boolean.hashCode(this.needReport);
    }

    public String toString() {
        return "AuthResult(passed=" + this.passed + ", interrupt=" + this.interrupt + ", status=" + this.status + ", errorCode=" + this.errorCode + ", successCode=" + this.successCode + ", needReport=" + this.needReport + ')';
    }

    public AuthResult(boolean z, boolean z2, String str, AuthErrorCode authErrorCode, AuthSuccessCode authSuccessCode, boolean z3) {
        this.passed = z;
        this.interrupt = z2;
        this.status = str;
        this.errorCode = authErrorCode;
        this.successCode = authSuccessCode;
        this.needReport = z3;
        this.packageVersion = -1;
        this.feAuthConfigSource = FeAuthConfigSource.UN_KNOWN;
        this.callNamespace = "";
        this.methodName = "";
    }

    public /* synthetic */ AuthResult(boolean z, boolean z2, String str, AuthErrorCode authErrorCode, AuthSuccessCode authSuccessCode, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : authErrorCode, (i & 16) != 0 ? null : authSuccessCode, (i & 32) != 0 ? true : z3);
    }

    public final boolean getPassed() {
        return this.passed;
    }

    public final void setPassed(boolean z) {
        this.passed = z;
    }

    public final boolean getInterrupt() {
        return this.interrupt;
    }

    public final void setInterrupt(boolean z) {
        this.interrupt = z;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final AuthErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(AuthErrorCode authErrorCode) {
        this.errorCode = authErrorCode;
    }

    public final AuthSuccessCode getSuccessCode() {
        return this.successCode;
    }

    public final void setSuccessCode(AuthSuccessCode authSuccessCode) {
        this.successCode = authSuccessCode;
    }

    public final boolean getNeedReport() {
        return this.needReport;
    }

    public final void setNeedReport(boolean z) {
        this.needReport = z;
    }

    public final int getPackageVersion() {
        return this.packageVersion;
    }

    public final void setPackageVersion(int i) {
        this.packageVersion = i;
    }

    public final int getAuthCode() {
        AuthErrorCode authErrorCode = this.errorCode;
        if (authErrorCode != null) {
            return authErrorCode.getCode();
        }
        AuthSuccessCode authSuccessCode = this.successCode;
        if (authSuccessCode == null) {
            authSuccessCode = AuthSuccessCode.UN_SET;
        }
        return authSuccessCode.getCode();
    }

    public final String getAuthMsg() {
        String str = this.status;
        AuthErrorCode authErrorCode = this.errorCode;
        AuthSuccessCode authSuccessCode = this.successCode;
        if (str != null) {
            return str;
        }
        String msg = authErrorCode != null ? authErrorCode.getMsg() : null;
        if (msg != null) {
            return msg;
        }
        String msg2 = authSuccessCode != null ? authSuccessCode.getMsg() : null;
        return msg2 == null ? "" : msg2;
    }

    public final AuthBridgeAccess getMethodAuthType() {
        return this.methodAuthType;
    }

    public final void setMethodAuthType(AuthBridgeAccess authBridgeAccess) {
        this.methodAuthType = authBridgeAccess;
    }

    public final FeAuthConfigSource getFeAuthConfigSource() {
        return this.feAuthConfigSource;
    }

    public final void setFeAuthConfigSource(FeAuthConfigSource feAuthConfigSource) {
        Intrinsics.checkNotNullParameter(feAuthConfigSource, "<set-?>");
        this.feAuthConfigSource = feAuthConfigSource;
    }

    public final AuthBridgeAccess getFeAuthGroup() {
        return this.feAuthGroup;
    }

    public final void setFeAuthGroup(AuthBridgeAccess authBridgeAccess) {
        this.feAuthGroup = authBridgeAccess;
    }

    public final String getAuthFeId() {
        return this.authFeId;
    }

    public final void setAuthFeId(String str) {
        this.authFeId = str;
    }

    public final String getAuthFeIdMapper() {
        return this.authFeIdMapper;
    }

    public final void setAuthFeIdMapper(String str) {
        this.authFeIdMapper = str;
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public final AuthMode getAuthMode() {
        return this.authMode;
    }

    public final void setAuthMode(AuthMode authMode) {
        this.authMode = authMode;
    }

    public final String getCallNamespace() {
        return this.callNamespace;
    }

    public final void setCallNamespace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callNamespace = str;
    }

    public final String getLynxTasmFeId() {
        return this.lynxTasmFeId;
    }

    public final void setLynxTasmFeId(String str) {
        this.lynxTasmFeId = str;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final void setMethodName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.methodName = str;
    }

    public final JSONObject getRequestTrackings() {
        return this.requestTrackings;
    }

    public final void setRequestTrackings(JSONObject jSONObject) {
        this.requestTrackings = jSONObject;
    }
}
