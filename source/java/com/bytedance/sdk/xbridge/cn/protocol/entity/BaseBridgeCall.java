package com.bytedance.sdk.xbridge.cn.protocol.entity;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: BaseBridgeCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u009a\u0001\u001a\u00030\u0084\u0001H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\u0005R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\u0005R\u001e\u00101\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u00048FX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u001a\u00109\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001a\u0010<\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R&\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R\u001a\u0010H\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\u0005R\u0011\u0010K\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010 R\u001a\u0010M\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010P\"\u0004\bT\u0010RR\u001a\u0010U\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR\u001a\u0010W\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR\u001a\u0010Y\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010P\"\u0004\bZ\u0010RR\u001a\u0010[\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010 \"\u0004\b]\u0010\u0005R\u001a\u0010^\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010 \"\u0004\b`\u0010\u0005R\u001a\u0010a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010 \"\u0004\bc\u0010\u0005R\u001a\u0010d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010 \"\u0004\bf\u0010\u0005R\u001e\u0010g\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\bh\u00103\"\u0004\bi\u00105R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010 R\u001a\u0010k\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010 \"\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0015R\u001a\u0010p\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0015\"\u0004\br\u0010\u0017R\u001a\u0010s\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0015\"\u0004\bu\u0010\u0017R\u001a\u0010v\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010P\"\u0004\bx\u0010RR\u001a\u0010y\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u000f\"\u0004\b{\u0010\u0011R\u0012\u0010|\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u0015\u0010\u007f\u001a\u00030\u0080\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\"\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u0089\u0001\u001a\u00020NX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010P\"\u0005\b\u008b\u0001\u0010RR\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0092\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0015\"\u0005\b\u0094\u0001\u0010\u0017R\u0014\u0010\u0095\u0001\u001a\u00020\u0004X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010 R\u001d\u0010\u0097\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u000f\"\u0005\b\u0099\u0001\u0010\u0011¨\u0006\u009b\u0001"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "INPUT", "", "methodName", "", "(Ljava/lang/String;)V", "appId", "", "getAppId", "()Ljava/lang/Integer;", "setAppId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "authCode", "getAuthCode", "()I", "setAuthCode", "(I)V", "authEndTime", "", "getAuthEndTime", "()J", "setAuthEndTime", "(J)V", "authErrorCode", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "getAuthErrorCode", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "setAuthErrorCode", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;)V", "authFeId", "getAuthFeId", "()Ljava/lang/String;", "setAuthFeId", "authFeIdMapper", "getAuthFeIdMapper", "setAuthFeIdMapper", "authMessage", "getAuthMessage", "setAuthMessage", "authMode", "getAuthMode", "setAuthMode", "authStartTime", "getAuthStartTime", "setAuthStartTime", "authUrl", "getAuthUrl", "setAuthUrl", "beforeMethodHandleStartTime", "getBeforeMethodHandleStartTime", "()Ljava/lang/Long;", "setBeforeMethodHandleStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "bid", "getBid", "bigIntStrategy", "getBigIntStrategy", "setBigIntStrategy", "code", "getCode", "setCode", "extraMap", "", "getExtraMap", "()Ljava/util/Map;", "setExtraMap", "(Ljava/util/Map;)V", "feAuthConfigSource", "getFeAuthConfigSource", "setFeAuthConfigSource", "feGroupAuthType", "getFeGroupAuthType", "setFeGroupAuthType", "id", "getId", "ignoreJSBError", "", "getIgnoreJSBError", "()Z", "setIgnoreJSBError", "(Z)V", "isAuthAllow", "setAuthAllow", "isLatch", "setLatch", "isPreInit", "setPreInit", "isUsePiperData", "setUsePiperData", "lynxTasmFeId", "getLynxTasmFeId", "setLynxTasmFeId", "message", "getMessage", "setMessage", "methodAccess", "getMethodAccess", "setMethodAccess", "methodAuthType", "getMethodAuthType", "setMethodAuthType", "methodHandleStartTime", "getMethodHandleStartTime", "setMethodHandleStartTime", "getMethodName", LynxBridgeCall.NAME_SPACE, "getNamespace", "setNamespace", "nativeCallStartTime", "getNativeCallStartTime", "nativeCallbackStartTime", "getNativeCallbackStartTime", "setNativeCallbackStartTime", "nativeCallbackTime", "getNativeCallbackTime", "setNativeCallbackTime", "needReportAuth", "getNeedReportAuth", "setNeedReportAuth", "packageVersion", "getPackageVersion", "setPackageVersion", "params", "getParams", "()Ljava/lang/Object;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "requestTrackings", "Lorg/json/JSONObject;", "getRequestTrackings", "()Lorg/json/JSONObject;", "setRequestTrackings", "(Lorg/json/JSONObject;)V", "success", "getSuccess", "setSuccess", "threadType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "getThreadType", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "setThreadType", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;)V", "timestamp", "getTimestamp", "setTimestamp", "url", "getUrl", "webAuthUrlType", "getWebAuthUrlType", "setWebAuthUrlType", "convertParamsToJSONObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseBridgeCall<INPUT> {
    private Integer appId;
    private int authCode;
    private long authEndTime;
    private AuthErrorCode authErrorCode;
    private String authFeId;
    private String authFeIdMapper;
    private String authMessage;
    private String authMode;
    private long authStartTime;
    private String authUrl;
    private Long beforeMethodHandleStartTime;
    private final String bid;
    private int bigIntStrategy;
    private int code;
    private Map<String, Object> extraMap;
    private int feAuthConfigSource;
    private String feGroupAuthType;
    private final String id;
    private boolean ignoreJSBError;
    private boolean isAuthAllow;
    private boolean isLatch;
    private boolean isPreInit;
    private boolean isUsePiperData;
    private String lynxTasmFeId;
    private String message;
    private String methodAccess;
    private String methodAuthType;
    private Long methodHandleStartTime;
    private final String methodName;
    private String namespace;
    private final long nativeCallStartTime;
    private long nativeCallbackStartTime;
    private long nativeCallbackTime;
    private boolean needReportAuth;
    private int packageVersion;
    private JSONObject requestTrackings;
    private boolean success;
    private IDLXBridgeMethod.XBridgeThreadType threadType;
    private long timestamp;
    private int webAuthUrlType;

    public abstract INPUT getParams();

    public abstract PlatformType getPlatformType();

    public abstract String getUrl();

    public BaseBridgeCall(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        this.methodName = methodName;
        this.timestamp = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.id = uuid;
        this.namespace = "";
        this.bid = "default_bid";
        this.nativeCallStartTime = System.currentTimeMillis();
        this.nativeCallbackTime = System.currentTimeMillis();
        this.nativeCallbackStartTime = System.currentTimeMillis();
        this.code = -1000;
        this.message = "Get message before callback";
        this.authFeId = "";
        this.authFeIdMapper = "";
        this.appId = 0;
        this.isAuthAllow = true;
        this.methodAccess = IDLXBridgeMethod.Access.PRIVATE.getValue();
        this.authErrorCode = AuthErrorCode.UN_KNOWN;
        this.packageVersion = -1;
        this.authStartTime = System.currentTimeMillis();
        this.authEndTime = System.currentTimeMillis();
        this.authMessage = "";
        this.methodAuthType = "";
        this.feGroupAuthType = "";
        this.authMode = "";
        this.lynxTasmFeId = "";
        this.needReportAuth = true;
        this.extraMap = new LinkedHashMap();
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void setNamespace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.namespace = str;
    }

    public final String getBid() {
        if (!StringsKt.isBlank(this.namespace)) {
            return this.namespace;
        }
        return this.bid;
    }

    public final long getNativeCallStartTime() {
        return this.nativeCallStartTime;
    }

    public final Long getMethodHandleStartTime() {
        return this.methodHandleStartTime;
    }

    public final void setMethodHandleStartTime(Long l) {
        this.methodHandleStartTime = l;
    }

    public final Long getBeforeMethodHandleStartTime() {
        return this.beforeMethodHandleStartTime;
    }

    public final void setBeforeMethodHandleStartTime(Long l) {
        this.beforeMethodHandleStartTime = l;
    }

    public final long getNativeCallbackTime() {
        return this.nativeCallbackTime;
    }

    public final void setNativeCallbackTime(long j) {
        this.nativeCallbackTime = j;
    }

    public final long getNativeCallbackStartTime() {
        return this.nativeCallbackStartTime;
    }

    public final void setNativeCallbackStartTime(long j) {
        this.nativeCallbackStartTime = j;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final IDLXBridgeMethod.XBridgeThreadType getThreadType() {
        return this.threadType;
    }

    public final void setThreadType(IDLXBridgeMethod.XBridgeThreadType xBridgeThreadType) {
        this.threadType = xBridgeThreadType;
    }

    public final String getAuthFeId() {
        return this.authFeId;
    }

    public final void setAuthFeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authFeId = str;
    }

    public final String getAuthFeIdMapper() {
        return this.authFeIdMapper;
    }

    public final void setAuthFeIdMapper(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authFeIdMapper = str;
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final void setAppId(Integer num) {
        this.appId = num;
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final void setAuthUrl(String str) {
        this.authUrl = str;
    }

    /* renamed from: isAuthAllow, reason: from getter */
    public final boolean getIsAuthAllow() {
        return this.isAuthAllow;
    }

    public final void setAuthAllow(boolean z) {
        this.isAuthAllow = z;
    }

    public final String getMethodAccess() {
        return this.methodAccess;
    }

    public final void setMethodAccess(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.methodAccess = str;
    }

    public final AuthErrorCode getAuthErrorCode() {
        return this.authErrorCode;
    }

    public final void setAuthErrorCode(AuthErrorCode authErrorCode) {
        Intrinsics.checkNotNullParameter(authErrorCode, "<set-?>");
        this.authErrorCode = authErrorCode;
    }

    public final int getPackageVersion() {
        return this.packageVersion;
    }

    public final void setPackageVersion(int i) {
        this.packageVersion = i;
    }

    public final long getAuthStartTime() {
        return this.authStartTime;
    }

    public final void setAuthStartTime(long j) {
        this.authStartTime = j;
    }

    public final long getAuthEndTime() {
        return this.authEndTime;
    }

    public final void setAuthEndTime(long j) {
        this.authEndTime = j;
    }

    public final int getAuthCode() {
        return this.authCode;
    }

    public final void setAuthCode(int i) {
        this.authCode = i;
    }

    public final String getAuthMessage() {
        return this.authMessage;
    }

    public final void setAuthMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authMessage = str;
    }

    public final String getMethodAuthType() {
        return this.methodAuthType;
    }

    public final void setMethodAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.methodAuthType = str;
    }

    public final int getFeAuthConfigSource() {
        return this.feAuthConfigSource;
    }

    public final void setFeAuthConfigSource(int i) {
        this.feAuthConfigSource = i;
    }

    public final String getFeGroupAuthType() {
        return this.feGroupAuthType;
    }

    public final void setFeGroupAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feGroupAuthType = str;
    }

    public final String getAuthMode() {
        return this.authMode;
    }

    public final void setAuthMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authMode = str;
    }

    public final String getLynxTasmFeId() {
        return this.lynxTasmFeId;
    }

    public final void setLynxTasmFeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lynxTasmFeId = str;
    }

    public final int getWebAuthUrlType() {
        return this.webAuthUrlType;
    }

    public final void setWebAuthUrlType(int i) {
        this.webAuthUrlType = i;
    }

    public final JSONObject getRequestTrackings() {
        return this.requestTrackings;
    }

    public final void setRequestTrackings(JSONObject jSONObject) {
        this.requestTrackings = jSONObject;
    }

    /* renamed from: isUsePiperData, reason: from getter */
    public final boolean getIsUsePiperData() {
        return this.isUsePiperData;
    }

    public final void setUsePiperData(boolean z) {
        this.isUsePiperData = z;
    }

    public final int getBigIntStrategy() {
        return this.bigIntStrategy;
    }

    public final void setBigIntStrategy(int i) {
        this.bigIntStrategy = i;
    }

    public final boolean getNeedReportAuth() {
        return this.needReportAuth;
    }

    public final void setNeedReportAuth(boolean z) {
        this.needReportAuth = z;
    }

    public final boolean getIgnoreJSBError() {
        return this.ignoreJSBError;
    }

    public final void setIgnoreJSBError(boolean z) {
        this.ignoreJSBError = z;
    }

    /* renamed from: isLatch, reason: from getter */
    public final boolean getIsLatch() {
        return this.isLatch;
    }

    public final void setLatch(boolean z) {
        this.isLatch = z;
    }

    /* renamed from: isPreInit, reason: from getter */
    public final boolean getIsPreInit() {
        return this.isPreInit;
    }

    public final void setPreInit(boolean z) {
        this.isPreInit = z;
    }

    public final Map<String, Object> getExtraMap() {
        return this.extraMap;
    }

    public final void setExtraMap(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraMap = map;
    }

    public JSONObject convertParamsToJSONObject() {
        return new JSONObject();
    }
}
