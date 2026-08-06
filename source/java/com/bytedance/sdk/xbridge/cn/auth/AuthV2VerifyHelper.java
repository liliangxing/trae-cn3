package com.bytedance.sdk.xbridge.cn.auth;

import android.util.Log;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeCallRecord;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeInfo;
import com.bytedance.sdk.xbridge.cn.auth.bean.JSBAuthMethodAuthTypeSetting;
import com.bytedance.sdk.xbridge.cn.auth.bean.LimitRecord;
import com.bytedance.sdk.xbridge.cn.auth.bean.MethodCallLimitsBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckResult;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.sdk.xbridge.cn.auth.repository.JSBAuthGlobalConfig;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.auth.utils.VerifyUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AuthV2VerifyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0012\u001a\u00020\u0013J0\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001bH\u0002J\"\u0010\"\u001a\u00020\u001b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0002J\u0019\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007H\u0002J\u001a\u00102\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\rJ\u0018\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/AuthV2VerifyHelper;", "", "feAuthConfig", "Lcom/bytedance/sdk/xbridge/cn/auth/FeAuthConfig;", "(Lcom/bytedance/sdk/xbridge/cn/auth/FeAuthConfig;)V", "bridgeLimitRule", "Ljava/util/HashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeCallRecord;", "getFeAuthConfig", "()Lcom/bytedance/sdk/xbridge/cn/auth/FeAuthConfig;", "setFeAuthConfig", "logDep", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/ILogDepend;", "checkMethodPermission", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "authConfig", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "bridgeInfo", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeInfo;", "methodName", "methodAccess", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "checkMethodRequestParams", "checkWebBridgeAuth", "getBridgeAuthTypeWithInfo", "Lkotlin/Pair;", "", "isCallInLimit", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "methodCallLimitConfig", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "isWeb", "isMethodInCallLimitSafeUrls", "safeUrls", "", IWeixinService.ResponseConstants.URL, "isValidLynxAuthUrl", "authUrl", "parseLimitFreq", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "freq", "parseUnit", "", "unit", "(Ljava/lang/String;)Ljava/lang/Long;", "printLog", "", "msg", "realCheckWebBridgeAuth", "setLogDep", "logDepend", "updateCallRecord", "authResult", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AuthV2VerifyHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LimitRecord RECORD_NO_LIMIT = new LimitRecord(1000, 999);
    public static final String TAG = "AuthV2VerifyHelper";
    private final HashMap<String, BridgeCallRecord> bridgeLimitRule;
    private FeAuthConfig feAuthConfig;
    private ILogDepend logDep;

    /* compiled from: AuthV2VerifyHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestCheckAction.values().length];
            try {
                iArr[RequestCheckAction.DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestCheckAction.TOGGLE_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestCheckAction.REPORT_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RequestCheckAction.CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AuthV2VerifyHelper() {
        this(r0, 1, r0);
        FeAuthConfig feAuthConfig = null;
    }

    public AuthV2VerifyHelper(FeAuthConfig feAuthConfig) {
        Intrinsics.checkNotNullParameter(feAuthConfig, "feAuthConfig");
        this.feAuthConfig = feAuthConfig;
        this.bridgeLimitRule = new HashMap<>();
        this.logDep = new ILogDepend() { // from class: com.bytedance.sdk.xbridge.cn.auth.AuthV2VerifyHelper$logDep$1
            @Override // com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend
            public void log(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Log.i(tag, msg);
            }
        };
    }

    public /* synthetic */ AuthV2VerifyHelper(FeAuthConfig feAuthConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FeAuthConfig(null, null, null, 0, null, null, null, 127, null) : feAuthConfig);
    }

    public final FeAuthConfig getFeAuthConfig() {
        return this.feAuthConfig;
    }

    public final void setFeAuthConfig(FeAuthConfig feAuthConfig) {
        Intrinsics.checkNotNullParameter(feAuthConfig, "<set-?>");
        this.feAuthConfig = feAuthConfig;
    }

    /* compiled from: AuthV2VerifyHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/AuthV2VerifyHelper$Companion;", "", "()V", "RECORD_NO_LIMIT", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "getRECORD_NO_LIMIT", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "TAG", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LimitRecord getRECORD_NO_LIMIT() {
            return AuthV2VerifyHelper.RECORD_NO_LIMIT;
        }
    }

    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "checkWebBridgeAuth(methodName, methodAccess)", imports = {}))
    public final AuthResult checkWebBridgeAuth(AuthConfigBean authConfig, BridgeInfo bridgeInfo) {
        Intrinsics.checkNotNullParameter(bridgeInfo, "bridgeInfo");
        printLog("AuthV2VerifyHelper config type :" + (authConfig != null ? authConfig.getType() : null));
        AuthResult realCheckWebBridgeAuth = realCheckWebBridgeAuth(authConfig, bridgeInfo);
        updateCallRecord(realCheckWebBridgeAuth, bridgeInfo);
        return realCheckWebBridgeAuth;
    }

    private final void updateCallRecord(AuthResult authResult, BridgeInfo bridgeInfo) {
        BridgeCallRecord bridgeCallRecord;
        if (authResult.getPassed()) {
            BridgeCallRecord bridgeCallRecord2 = this.bridgeLimitRule.get(bridgeInfo.getBridgeName());
            HashMap<String, BridgeCallRecord> hashMap = this.bridgeLimitRule;
            String bridgeName = bridgeInfo.getBridgeName();
            if (bridgeCallRecord2 != null) {
                bridgeCallRecord = new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), bridgeCallRecord2.getCallTimes() + 1, bridgeCallRecord2.getCallFreqTimes() + 1);
            } else {
                bridgeCallRecord = new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), 1, 1);
            }
            hashMap.put(bridgeName, bridgeCallRecord);
        }
    }

    private final boolean isValidLynxAuthUrl(String authUrl) {
        if (authUrl != null) {
            return StringsKt.startsWith$default(authUrl, "gecko://", false, 2, (Object) null) || StringsKt.startsWith$default(authUrl, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(authUrl, "https://", false, 2, (Object) null);
        }
        return false;
    }

    private final AuthErrorCode isCallInLimit(Map<String, MethodCallLimitsBean> methodCallLimitConfig, BridgeInfo bridgeInfo, boolean isWeb) {
        if (methodCallLimitConfig == null) {
            methodCallLimitConfig = MapsKt.emptyMap();
        }
        MethodCallLimitsBean methodCallLimitsBean = methodCallLimitConfig.get(bridgeInfo.getBridgeName());
        if (methodCallLimitsBean == null) {
            return null;
        }
        if (isWeb && !isMethodInCallLimitSafeUrls(methodCallLimitsBean.getUrl(), bridgeInfo.getUrl())) {
            return AuthErrorCode.WEB_BOT_IN_URL;
        }
        if (!isWeb && isValidLynxAuthUrl(bridgeInfo.getUrl()) && !isMethodInCallLimitSafeUrls(methodCallLimitsBean.getUrl(), bridgeInfo.getUrl())) {
            return AuthErrorCode.WEB_BOT_IN_URL;
        }
        BridgeCallRecord bridgeCallRecord = this.bridgeLimitRule.get(bridgeInfo.getBridgeName());
        if (bridgeCallRecord != null) {
            Integer runtime_call_count = methodCallLimitsBean.getRuntime_call_count();
            int intValue = runtime_call_count != null ? runtime_call_count.intValue() : 0;
            if (intValue != 0 && intValue <= bridgeCallRecord.getCallTimes()) {
                printLog(bridgeInfo.getBridgeName() + " is in call limit times,limit:" + intValue);
                return AuthErrorCode.OVER_CALL_TIMES;
            }
            LimitRecord parseLimitFreq = parseLimitFreq(methodCallLimitsBean.getRuntime_call_frequency());
            if (parseLimitFreq != null && !Intrinsics.areEqual(parseLimitFreq, RECORD_NO_LIMIT)) {
                Long lastCallTimeStamp = bridgeCallRecord.getLastCallTimeStamp();
                long longValue = lastCallTimeStamp != null ? lastCallTimeStamp.longValue() : 0L;
                if (System.currentTimeMillis() - longValue <= parseLimitFreq.getSpendTimestamp() && bridgeCallRecord.getCallFreqTimes() >= parseLimitFreq.getCount()) {
                    printLog(bridgeInfo.getBridgeName() + " is in call limit frequency,has called " + bridgeCallRecord.getCallTimes() + " but limit " + parseLimitFreq.getCount() + " in " + parseLimitFreq.getSpendTimestamp() + "ms");
                    return AuthErrorCode.OVER_CALL_FREQ;
                }
                if (System.currentTimeMillis() - longValue > parseLimitFreq.getSpendTimestamp()) {
                    this.bridgeLimitRule.put(bridgeInfo.getBridgeName(), new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), bridgeCallRecord.getCallTimes(), 0));
                    printLog("bridge:" + bridgeInfo.getBridgeName() + ",reset call record");
                }
            }
        }
        return null;
    }

    private final boolean isMethodInCallLimitSafeUrls(List<String> safeUrls, String url) {
        List<String> list = safeUrls;
        if (list == null || list.isEmpty()) {
            return true;
        }
        if (url == null) {
            return false;
        }
        return VerifyUtils.INSTANCE.verifyUrl$anniex_release(safeUrls, url);
    }

    private final AuthResult realCheckWebBridgeAuth(AuthConfigBean authConfig, BridgeInfo bridgeInfo) {
        if (authConfig == null) {
            printLog("auth config is null,pass");
            return new AuthResult(true, false, null, null, null, false, 62, null);
        }
        AuthErrorCode isCallInLimit = isCallInLimit(authConfig.getMethod_call_limits(), bridgeInfo, true);
        if (isCallInLimit != null) {
            return new AuthResult(false, false, null, isCallInLimit, null, false, 54, null);
        }
        return checkMethodPermission(authConfig, bridgeInfo);
    }

    private final AuthResult checkMethodPermission(AuthConfigBean authConfig, BridgeInfo bridgeInfo) {
        if (authConfig.getExcluded_methods().contains(bridgeInfo.getBridgeName())) {
            printLog(bridgeInfo.getBridgeName() + " is in exclude methods,fail");
            return new AuthResult(false, false, "method in exclude methods", AuthErrorCode.IN_EXCLUDE_METHODS, null, false, 50, null);
        }
        if (authConfig.getIncluded_methods().contains(bridgeInfo.getBridgeName())) {
            printLog(bridgeInfo.getBridgeName() + " is in included methods,pass");
            return new AuthResult(true, false, null, null, null, false, 62, null);
        }
        if (bridgeInfo.getAuth() == AuthBridgeAccess.SECURE) {
            printLog(bridgeInfo.getBridgeName() + " is secure,and not in include method,fail");
            return new AuthResult(false, false, "method is secure,and not in include method,fail", AuthErrorCode.SECURE_NOT_INCLUDE, null, false, 50, null);
        }
        boolean z = authConfig.getGroup().compareTo(bridgeInfo.getAuth()) >= 0;
        if (!z) {
            printLog("no permission,bridge " + bridgeInfo.getBridgeName() + " auth level is " + bridgeInfo.getAuth() + ",but group auth level is " + authConfig.getGroup());
        }
        if (z) {
            return new AuthResult(true, false, null, null, null, false, 62, null);
        }
        return new AuthResult(false, false, "method < rule", AuthErrorCode.RULE_DENY_NOT_INCLUDE, null, false, 50, null);
    }

    private final LimitRecord parseLimitFreq(String freq) {
        if (freq != null) {
            try {
                List split$default = StringsKt.split$default(freq, new String[]{"/"}, false, 0, 6, (Object) null);
                if (split$default != null) {
                    int parseInt = Integer.parseInt((String) split$default.get(0));
                    Long parseUnit = parseUnit((String) split$default.get(1));
                    if (parseUnit != null) {
                        return new LimitRecord(parseUnit.longValue(), parseInt);
                    }
                    return null;
                }
            } catch (Throwable th) {
                printLog("parse limit error:" + th.getMessage());
            }
        }
        return null;
    }

    private final Long parseUnit(String unit) {
        if (unit == null) {
            return null;
        }
        int hashCode = unit.hashCode();
        if (hashCode == 100) {
            if (unit.equals("d")) {
                return Long.valueOf(86400000);
            }
            return null;
        }
        if (hashCode == 104) {
            if (unit.equals("h")) {
                return Long.valueOf(3600000);
            }
            return null;
        }
        if (hashCode != 109) {
            return (hashCode == 115 && unit.equals("s")) ? 1000L : null;
        }
        if (unit.equals("m")) {
            return Long.valueOf(60000);
        }
        return null;
    }

    public final void setLogDep(ILogDepend logDepend) {
        Intrinsics.checkNotNullParameter(logDepend, "logDepend");
        this.logDep = logDepend;
    }

    private final void printLog(String msg) {
        this.logDep.log(TAG, msg);
    }

    public final Pair<AuthBridgeAccess, Boolean> getBridgeAuthTypeWithInfo(BridgeInfo bridgeInfo) {
        boolean enableWebForcePrivate;
        String[] webPublicMethod;
        Intrinsics.checkNotNullParameter(bridgeInfo, "bridgeInfo");
        String bridgeName = bridgeInfo.getBridgeName();
        JSBAuthMethodAuthTypeSetting jSBAuthMethodAuthTypeSetting = AuthStrategyRepository.INSTANCE.getCustomMethodAuthTypeSettings().get(PermissionConfigParser.WEBCAST_HOST_NAMESPACE);
        if (jSBAuthMethodAuthTypeSetting == null) {
            jSBAuthMethodAuthTypeSetting = new JSBAuthMethodAuthTypeSetting(false, null, false, null, null, 31, null);
        }
        if (bridgeInfo.getContainerType() == AuthConfigType.LYNX) {
            enableWebForcePrivate = jSBAuthMethodAuthTypeSetting.getEnableLynxForcePrivate();
        } else {
            enableWebForcePrivate = jSBAuthMethodAuthTypeSetting.getEnableWebForcePrivate();
        }
        if (bridgeInfo.getContainerType() == AuthConfigType.LYNX) {
            webPublicMethod = jSBAuthMethodAuthTypeSetting.getLynxPublicMethod();
        } else {
            webPublicMethod = jSBAuthMethodAuthTypeSetting.getWebPublicMethod();
        }
        Map<String, Integer> commonSecureMethod = jSBAuthMethodAuthTypeSetting.getCommonSecureMethod();
        if (commonSecureMethod.containsKey(bridgeName)) {
            Integer num = commonSecureMethod.get(bridgeName);
            if (this.feAuthConfig.getSecureAuthVersion() >= (num != null ? num.intValue() : 0)) {
                return new Pair<>(AuthBridgeAccess.SECURE, Boolean.valueOf(enableWebForcePrivate));
            }
        }
        if (ArraysKt.contains(webPublicMethod, bridgeName)) {
            return new Pair<>(AuthBridgeAccess.PUBLIC, Boolean.valueOf(enableWebForcePrivate));
        }
        if (enableWebForcePrivate) {
            return new Pair<>(AuthBridgeAccess.PRIVATE, Boolean.valueOf(enableWebForcePrivate));
        }
        return new Pair<>(bridgeInfo.getAuth(), Boolean.valueOf(enableWebForcePrivate));
    }

    public final AuthResult checkWebBridgeAuth(BridgeInfo bridgeInfo, AuthBridgeAccess methodAccess) {
        Intrinsics.checkNotNullParameter(bridgeInfo, "bridgeInfo");
        Intrinsics.checkNotNullParameter(methodAccess, "methodAccess");
        AuthErrorCode isCallInLimit = isCallInLimit(this.feAuthConfig.getMethodCallLimits(), bridgeInfo, true);
        if (isCallInLimit != null) {
            return new AuthResult(false, false, null, isCallInLimit, null, false, 54, null);
        }
        AuthResult checkMethodPermission = checkMethodPermission(bridgeInfo.getBridgeName(), methodAccess);
        if (checkMethodPermission.getPassed()) {
            checkMethodPermission = checkMethodRequestParams(bridgeInfo);
        }
        updateCallRecord(checkMethodPermission, bridgeInfo);
        return checkMethodPermission;
    }

    private final AuthResult checkMethodPermission(String methodName, AuthBridgeAccess methodAccess) {
        if (this.feAuthConfig.getExcludedMethods().contains(methodName)) {
            printLog(methodName + " is in exclude methods,fail");
            return new AuthResult(false, false, "method in exclude methods", AuthErrorCode.IN_EXCLUDE_METHODS, null, false, 50, null);
        }
        if (this.feAuthConfig.getIncludedMethods().contains(methodName)) {
            printLog(methodName + " is in included methods,pass");
            return new AuthResult(true, false, "", null, null, false, 58, null);
        }
        if (methodAccess == AuthBridgeAccess.SECURE) {
            printLog(methodName + " is secure,and not in include method,fail");
            return new AuthResult(false, false, "method is secure,and not in include method,fail", AuthErrorCode.SECURE_NOT_INCLUDE, null, false, 50, null);
        }
        boolean z = this.feAuthConfig.getAccess().compareTo(methodAccess) >= 0;
        if (!z) {
            printLog("no permission,bridge " + methodName + " auth level is " + methodAccess + ",but fe group auth level is " + this.feAuthConfig.getAccess());
        }
        if (z) {
            return new AuthResult(true, false, null, null, null, false, 62, null);
        }
        return new AuthResult(false, false, "method < rule", AuthErrorCode.RULE_DENY_NOT_INCLUDE, null, false, 50, null);
    }

    private final AuthResult checkMethodRequestParams(BridgeInfo bridgeInfo) {
        String str;
        AuthSuccessCode authSuccessCode;
        AuthSuccessCode authSuccessCode2;
        RequestCheckResult requestCheckForMethod = JSBAuthGlobalConfig.INSTANCE.getRequestCheck().requestCheckForMethod(bridgeInfo.getBridgeName(), bridgeInfo.getParams());
        AuthResult authResult = new AuthResult(true, false, null, null, null, false, 62, null);
        int i = WhenMappings.$EnumSwitchMapping$0[requestCheckForMethod.getAction().ordinal()];
        if (i == 1 || i == 2) {
            authResult.setSuccessCode(AuthSuccessCode.REQUEST_CHECK_PASSED);
        } else if (i == 3) {
            if (requestCheckForMethod.getTrackingWarn() == null && requestCheckForMethod.getDenyReason() == null) {
                authSuccessCode = AuthSuccessCode.REQUEST_CHECK_PASSED;
            } else {
                authSuccessCode = AuthSuccessCode.REQUEST_CHECK_WARNING;
            }
            authResult.setSuccessCode(authSuccessCode);
        } else if (i == 4) {
            if (requestCheckForMethod.getCheckSuccess()) {
                if (requestCheckForMethod.getTrackingWarn() == null && requestCheckForMethod.getDenyReason() == null) {
                    authSuccessCode2 = AuthSuccessCode.REQUEST_CHECK_PASSED;
                } else {
                    authSuccessCode2 = AuthSuccessCode.REQUEST_CHECK_WARNING;
                }
                authResult.setSuccessCode(authSuccessCode2);
            } else {
                authResult.setErrorCode(AuthErrorCode.REQUEST_CHECK_DENY);
            }
            authResult.setPassed(requestCheckForMethod.getCheckSuccess());
        } else {
            authResult.setSuccessCode(AuthSuccessCode.REQUEST_CHECK_WARNING);
        }
        if (authResult.getErrorCode() == AuthErrorCode.REQUEST_CHECK_DENY) {
            str = "failed_request_parameters_check_deny";
        } else if (authResult.getSuccessCode() == AuthSuccessCode.REQUEST_CHECK_WARNING) {
            str = "success_request_parameters_warn";
        } else {
            str = authResult.getSuccessCode() == AuthSuccessCode.REQUEST_CHECK_PASSED ? "success_request_parameters_check_passed" : null;
        }
        authResult.setStatus(str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", requestCheckForMethod.getAction().getValue());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> trackingInfo = requestCheckForMethod.getTrackingInfo();
        if (trackingInfo != null) {
            linkedHashMap.putAll(trackingInfo);
        }
        Map<String, String> trackingWarn = requestCheckForMethod.getTrackingWarn();
        if (trackingWarn != null) {
            linkedHashMap.putAll(trackingWarn);
        }
        if (true ^ linkedHashMap.isEmpty()) {
            jSONObject.put("trackings", linkedHashMap);
        }
        String denyReason = requestCheckForMethod.getDenyReason();
        if (denyReason != null) {
            jSONObject.put("reason", denyReason);
        }
        authResult.setRequestTrackings(jSONObject);
        return authResult;
    }
}
