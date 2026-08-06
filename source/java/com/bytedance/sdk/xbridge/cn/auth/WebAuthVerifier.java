package com.bytedance.sdk.xbridge.cn.auth;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.base.settings.JSBAuthStrategySetting;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigV1Bean;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeInfo;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import com.bytedance.sdk.xbridge.cn.auth.bean.JSBAuthStrategyConfig;
import com.bytedance.sdk.xbridge.cn.auth.depend.AuthReportInfo;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.depend.IReportDepend;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.auth.utils.ThreadPool;
import com.bytedance.sdk.xbridge.cn.auth.utils.VerifyUtils;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.MessagePart;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: WebAuthVerifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u0005H\u0007J \u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u0005J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0005H\u0002J \u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002J\u001d\u0010+\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010,2\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0002J\u000e\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifier;", "", "()V", "authV2VerifyHelperMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/auth/AuthV2VerifyHelper;", "logDep", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/ILogDepend;", "needReportPv", "", "onlyUseHostNamespace", "getOnlyUseHostNamespace", "()Z", "onlyUseHostNamespace$delegate", "Lkotlin/Lazy;", "reportDep", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/IReportDepend;", "addLogDepend", "", MessagePart.TYPE_LOG, "addReportDepend", "report", "checkAppIdLegal", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "config", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "bridgeInfo", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeInfo;", "checkBridgeAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "appId", LynxBridgeCall.NAME_SPACE, "checkBridgeAuthNew", "callNamespace", "findFeAuthConfig", "Lcom/bytedance/sdk/xbridge/cn/auth/FeAuthConfig;", "authUrl", "getAuthV2VerifyHelper", IWeixinService.ResponseConstants.URL, "getOrInitAllAuthV2VerifyHelper", "getShortenedHost", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "isUseAuthV2", "", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "printLog", "msg", "reportInfo", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/AuthReportInfo;", "setReportPV", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebAuthVerifier {
    public static final String EVENT_NAME_WEB_AUTH = "bdx_monitor_bridge_web_auth";
    public static final String TAG = "XBridge-auth";
    private ILogDepend logDep = new ILogDepend() { // from class: com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifier$logDep$1
        @Override // com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend
        public void log(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.i(tag, msg);
        }
    };
    private final ConcurrentHashMap<String, AuthV2VerifyHelper> authV2VerifyHelperMap = new ConcurrentHashMap<>();
    private boolean needReportPv = true;

    /* renamed from: onlyUseHostNamespace$delegate, reason: from kotlin metadata */
    private final Lazy onlyUseHostNamespace = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifier$onlyUseHostNamespace$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m891invoke() {
            SecuritySettingConfig securitySettingConfig;
            JSBAuthStrategySetting jsbAuthStrategySettingConfig;
            IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
            return Boolean.valueOf((iBulletSettingsService == null || (securitySettingConfig = (SecuritySettingConfig) iBulletSettingsService.obtainSettings(SecuritySettingConfig.class)) == null || (jsbAuthStrategySettingConfig = securitySettingConfig.getJsbAuthStrategySettingConfig()) == null) ? false : jsbAuthStrategySettingConfig.getJsbAuthOnlyUseHostNamespace());
        }
    });
    private IReportDepend reportDep = new IReportDepend() { // from class: com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifier$reportDep$1
        @Override // com.bytedance.sdk.xbridge.cn.auth.depend.IReportDepend
        public void report(AuthReportInfo reportInfo) {
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            Log.i(WebAuthVerifier.TAG, reportInfo.toString());
        }
    };

    private final boolean getOnlyUseHostNamespace() {
        return ((Boolean) this.onlyUseHostNamespace.getValue()).booleanValue();
    }

    public final void setReportPV(boolean needReportPv) {
        this.needReportPv = needReportPv;
    }

    public final boolean isUseAuthV2(Integer appId, String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        return (appId == null || appId.intValue() == -1) ? false : true;
    }

    public static /* synthetic */ AuthResult checkBridgeAuthNew$default(WebAuthVerifier webAuthVerifier, String str, BridgeInfo bridgeInfo, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return webAuthVerifier.checkBridgeAuthNew(str, bridgeInfo, str2);
    }

    public final AuthResult checkBridgeAuthNew(String appId, BridgeInfo bridgeInfo, String callNamespace) {
        int packageVersion;
        AuthResult authResult;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(bridgeInfo, "bridgeInfo");
        Intrinsics.checkNotNullParameter(callNamespace, "callNamespace");
        String url = bridgeInfo.getUrl();
        printLog("Start H5 auth v3: " + url + ", method name: " + bridgeInfo.getBridgeName() + ", namespace: " + callNamespace);
        if (url == null) {
            authResult = new AuthResult(false, false, "empty url", AuthErrorCode.URL_EMPTY, null, false, 50, null);
        } else if (PermissionConfigV2Parser.INSTANCE.isPermissionConfigEmpty()) {
            authResult = new AuthResult(true, false, "all permission config not found", null, AuthSuccessCode.NO_AUTH_PACKAGE, false, 42, null);
        } else {
            AuthV2VerifyHelper orInitAllAuthV2VerifyHelper = getOrInitAllAuthV2VerifyHelper(url, appId, callNamespace);
            Pair<AuthBridgeAccess, Boolean> bridgeAuthTypeWithInfo = orInitAllAuthV2VerifyHelper.getBridgeAuthTypeWithInfo(bridgeInfo);
            AuthBridgeAccess authBridgeAccess = (AuthBridgeAccess) bridgeAuthTypeWithInfo.component1();
            boolean booleanValue = ((Boolean) bridgeAuthTypeWithInfo.component2()).booleanValue();
            AuthResult checkWebBridgeAuth = orInitAllAuthV2VerifyHelper.checkWebBridgeAuth(bridgeInfo, authBridgeAccess);
            checkWebBridgeAuth.setAuthUrl(url);
            checkWebBridgeAuth.setAuthMode(booleanValue ? AuthMode.STANDARD_H5_V3_FORCE_PRIVATE : AuthMode.STANDARD_H5_V3);
            checkWebBridgeAuth.setMethodAuthType(authBridgeAccess);
            checkWebBridgeAuth.setCallNamespace(callNamespace);
            checkWebBridgeAuth.setAuthFeId(orInitAllAuthV2VerifyHelper.getFeAuthConfig().getFeId());
            checkWebBridgeAuth.setFeAuthConfigSource(orInitAllAuthV2VerifyHelper.getFeAuthConfig().getSource());
            checkWebBridgeAuth.setFeAuthGroup(orInitAllAuthV2VerifyHelper.getFeAuthConfig().getAccess());
            if (orInitAllAuthV2VerifyHelper.getFeAuthConfig().isFromContentV2()) {
                callNamespace = "";
            }
            if (getOnlyUseHostNamespace()) {
                packageVersion = PermissionConfigV2Parser.getPackageVersion$default(PermissionConfigV2Parser.INSTANCE, null, 1, null);
            } else {
                packageVersion = PermissionConfigV2Parser.INSTANCE.getPackageVersion(callNamespace);
            }
            checkWebBridgeAuth.setPackageVersion(packageVersion);
            if (this.needReportPv) {
                AuthReportInfo authReportInfo = new AuthReportInfo(EVENT_NAME_WEB_AUTH);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("auth_url", url);
                jSONObject.put("fe_id", checkWebBridgeAuth.getAuthFeId());
                jSONObject.put("fe_id_mapper", checkWebBridgeAuth.getAuthFeIdMapper());
                jSONObject.put("method_name", bridgeInfo.getBridgeName());
                jSONObject.put("method_auth_type", authBridgeAccess.getValue());
                jSONObject.put("result", checkWebBridgeAuth.getPassed() ? 1 : 0);
                jSONObject.put(PageDataManager.EXTRA_STATUS, checkWebBridgeAuth.getAuthMsg());
                jSONObject.put("package_version", checkWebBridgeAuth.getPackageVersion());
                JSONObject requestTrackings = checkWebBridgeAuth.getRequestTrackings();
                jSONObject.put("request_trackings", requestTrackings != null ? requestTrackings : "");
                authReportInfo.setCategory(jSONObject);
                authReportInfo.setHighFrequency(true);
                report(authReportInfo);
            }
            authResult = checkWebBridgeAuth;
        }
        printLog("End H5 auth v3: verify result: " + authResult.getPassed() + ", auth code: " + authResult.getAuthCode() + ", status: " + authResult.getAuthMsg());
        return authResult;
    }

    private final AuthV2VerifyHelper getOrInitAllAuthV2VerifyHelper(String authUrl, String appId, String callNamespace) {
        Uri parse = Uri.parse(authUrl);
        String str = parse.getHost() + parse.getPath();
        AuthV2VerifyHelper authV2VerifyHelper = this.authV2VerifyHelperMap.get(str);
        if (authV2VerifyHelper != null) {
            FeAuthConfig feAuthConfig = authV2VerifyHelper.getFeAuthConfig();
            if (feAuthConfig.isFromContentV2()) {
                AuthConfigBean authConfig$default = PermissionConfigV2Parser.getAuthConfig$default(PermissionConfigV2Parser.INSTANCE, feAuthConfig.getFeId(), null, 2, null);
                if (authConfig$default != null) {
                    authV2VerifyHelper.getFeAuthConfig().updateContentV2Config(feAuthConfig.getFeId(), authConfig$default, FeAuthConfigSource.CONTENT_V2_FROM_CACHE);
                }
            } else if (feAuthConfig.getSource() == FeAuthConfigSource.CONTENT_V1_FROM_MATCH) {
                authV2VerifyHelper.getFeAuthConfig().setSource(FeAuthConfigSource.CONTENT_V1_FROM_CACHE);
            }
        } else {
            FeAuthConfig findFeAuthConfig = findFeAuthConfig(authUrl, appId, callNamespace);
            authV2VerifyHelper = new AuthV2VerifyHelper(findFeAuthConfig);
            authV2VerifyHelper.setLogDep(this.logDep);
            if (findFeAuthConfig.getSource().getCode() > 0) {
                this.authV2VerifyHelperMap.put(str, authV2VerifyHelper);
            }
        }
        return authV2VerifyHelper;
    }

    private final FeAuthConfig findFeAuthConfig(String authUrl, String appId, String namespace) {
        FeAuthConfig feAuthConfig;
        String str;
        List<AuthConfigV1Bean> contentAuthConfigBasedHost;
        AuthConfigBean authConfig$default;
        Uri parse = Uri.parse(authUrl);
        String host = parse.getHost();
        FeAuthConfig feAuthConfig2 = new FeAuthConfig(AuthBridgeAccess.PUBLIC, null, null, 0, null, null, FeAuthConfigSource.NOT_FOUND, 62, null);
        Integer intOrNull = StringsKt.toIntOrNull(appId);
        if ((intOrNull != null ? intOrNull.intValue() : 0) > 0 && (authConfig$default = PermissionConfigV2Parser.getAuthConfig$default(PermissionConfigV2Parser.INSTANCE, appId, null, 2, null)) != null && VerifyUtils.INSTANCE.verifyUrl$anniex_release(authConfig$default.getSafe_urls(), authUrl)) {
            feAuthConfig2.updateContentV2Config(appId, authConfig$default, FeAuthConfigSource.CONTENT_V2_FROM_CALL);
        } else {
            if (AuthStrategyRepository.INSTANCE.getWebAuthStrategy().getEnableAutoMatchUrl()) {
                for (Map.Entry<String, AuthConfigBean> entry : PermissionConfigV2Parser.INSTANCE.getWholeContentV2AuthConfig().entrySet()) {
                    String key = entry.getKey();
                    AuthConfigBean value = entry.getValue();
                    if (value.getType() == AuthConfigType.WEB && VerifyUtils.INSTANCE.verifyUrl$anniex_release(value.getSafe_urls(), authUrl)) {
                        feAuthConfig2.updateContentV2Config(key, value, FeAuthConfigSource.CONTENT_V2_FROM_AUTO_MATCH);
                    }
                }
            }
            feAuthConfig2.setFeId(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW);
            String shortenedHost = getShortenedHost(host);
            if (host == null || TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(host) || shortenedHost == null) {
                feAuthConfig = feAuthConfig2;
                str = namespace;
                feAuthConfig.setSource(FeAuthConfigSource.LOGIC_ERROR);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                AuthBridgeAccess authBridgeAccess = AuthBridgeAccess.PUBLIC;
                if (getOnlyUseHostNamespace()) {
                    contentAuthConfigBasedHost = PermissionConfigV2Parser.getContentAuthConfigBasedHost$default(PermissionConfigV2Parser.INSTANCE, shortenedHost, null, 2, null);
                    feAuthConfig = feAuthConfig2;
                    str = namespace;
                } else {
                    feAuthConfig = feAuthConfig2;
                    str = namespace;
                    contentAuthConfigBasedHost = PermissionConfigV2Parser.INSTANCE.getContentAuthConfigBasedHost(shortenedHost, str);
                }
                boolean z = false;
                for (AuthConfigV1Bean authConfigV1Bean : contentAuthConfigBasedHost) {
                    if (VerifyUtils.INSTANCE.isPatternMatch$anniex_release(authUrl, authConfigV1Bean.getPattern())) {
                        linkedHashSet.addAll(authConfigV1Bean.getIncluded_methods());
                        linkedHashSet2.addAll(authConfigV1Bean.getExcluded_methods());
                        if (authConfigV1Bean.getAccess().compareTo(authBridgeAccess) >= 0) {
                            authBridgeAccess = authConfigV1Bean.getAccess();
                        }
                        z = true;
                    }
                }
                if (z) {
                    feAuthConfig.updateContentConfig(authBridgeAccess, linkedHashSet, linkedHashSet2, FeAuthConfigSource.CONTENT_V1_FROM_MATCH);
                    return feAuthConfig;
                }
            }
            if (host == null) {
                return feAuthConfig;
            }
            String[] strArr = AuthStrategyRepository.INSTANCE.getWebAuthStrategy().getPrivateDomains().get(JSBAuthStrategyConfig.INSTANCE.parseMatchNamespace(str));
            if (strArr == null) {
                strArr = new String[0];
            }
            for (String str2 : strArr) {
                if (Intrinsics.areEqual(host, str2) || StringsKt.endsWith$default(host, "." + str2, false, 2, (Object) null)) {
                    feAuthConfig.updatePrivateDomainsConfig();
                    return feAuthConfig;
                }
            }
            return feAuthConfig;
        }
        return feAuthConfig2;
    }

    public static /* synthetic */ AuthResult checkBridgeAuth$default(WebAuthVerifier webAuthVerifier, String str, BridgeInfo bridgeInfo, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return webAuthVerifier.checkBridgeAuth(str, bridgeInfo, str2);
    }

    @Deprecated(message = "废弃，有前端兼容性问题", replaceWith = @ReplaceWith(expression = "checkBridgeAuthNew", imports = {}))
    public final AuthResult checkBridgeAuth(String appId, BridgeInfo bridgeInfo, String namespace) {
        AuthResult authResult;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(bridgeInfo, "bridgeInfo");
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        AuthConfigBean authConfig = PermissionConfigV2Parser.INSTANCE.getAuthConfig(appId, namespace);
        AuthErrorCode checkAppIdLegal = checkAppIdLegal(authConfig, bridgeInfo);
        if (checkAppIdLegal == null) {
            String url = bridgeInfo.getUrl();
            if (url == null) {
                url = "";
            }
            authResult = getAuthV2VerifyHelper(url).checkWebBridgeAuth(authConfig, bridgeInfo);
        } else if (checkAppIdLegal == AuthErrorCode.URL_EMPTY) {
            authResult = new AuthResult(false, false, "auth url is empty", checkAppIdLegal, null, false, 50, null);
            printLog("WebAuthVerifier auth url is empty");
        } else if (checkAppIdLegal == AuthErrorCode.NO_FE_ID_CONFIG) {
            authResult = new AuthResult(false, false, "app id is not legal, appid:" + appId, checkAppIdLegal, null, false, 50, null);
            printLog("WebAuthVerifier app id is not legal");
        } else {
            authResult = new AuthResult(false, false, "not in safe url, url:" + bridgeInfo.getUrl(), checkAppIdLegal, null, false, 50, null);
            printLog("WebAuthVerifier not in safe url");
        }
        if (this.needReportPv) {
            AuthReportInfo authReportInfo = new AuthReportInfo(EVENT_NAME_WEB_AUTH);
            JSONObject jSONObject = new JSONObject();
            String url2 = bridgeInfo.getUrl();
            jSONObject.put(IWeixinService.ResponseConstants.URL, url2 != null ? url2 : "");
            jSONObject.put("fe_id", appId);
            jSONObject.put("method_name", bridgeInfo.getBridgeName());
            jSONObject.put("auth_type", bridgeInfo.getAuth());
            jSONObject.put("result", authResult.getPassed() ? 1 : 0);
            jSONObject.put(PageDataManager.EXTRA_STATUS, authResult.getAuthMsg());
            authReportInfo.setCategory(jSONObject);
            authReportInfo.setHighFrequency(true);
            report(authReportInfo);
        }
        authResult.setPackageVersion(PermissionConfigV2Parser.INSTANCE.getPackageVersion(namespace));
        return authResult;
    }

    private final AuthV2VerifyHelper getAuthV2VerifyHelper(String url) {
        Uri parse = Uri.parse(url);
        String str = parse.getHost() + parse.getPath();
        AuthV2VerifyHelper authV2VerifyHelper = this.authV2VerifyHelperMap.get(str);
        if (authV2VerifyHelper != null) {
            return authV2VerifyHelper;
        }
        FeAuthConfig feAuthConfig = null;
        AuthV2VerifyHelper authV2VerifyHelper2 = new AuthV2VerifyHelper(feAuthConfig, 1, feAuthConfig);
        authV2VerifyHelper2.setLogDep(this.logDep);
        this.authV2VerifyHelperMap.put(str, authV2VerifyHelper2);
        return authV2VerifyHelper2;
    }

    private final AuthErrorCode checkAppIdLegal(AuthConfigBean config, BridgeInfo bridgeInfo) {
        AuthErrorCode authErrorCode = AuthErrorCode.NOT_IN_SAFE_URl;
        if (bridgeInfo.getUrl() == null) {
            return AuthErrorCode.URL_EMPTY;
        }
        if (config == null) {
            return AuthErrorCode.NO_FE_ID_CONFIG;
        }
        String url = bridgeInfo.getUrl();
        if (url == null || !VerifyUtils.INSTANCE.verifyUrl$anniex_release(config.getSafe_urls(), url)) {
            return authErrorCode;
        }
        return null;
    }

    private final String getShortenedHost(String host) {
        if (host == null) {
            return null;
        }
        Object[] array = new Regex("[.]").split(host, 0).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            if (length < 2) {
                return null;
            }
            return length == 2 ? host : strArr[length - 2] + '.' + strArr[length - 1];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void addLogDepend(ILogDepend log) {
        Intrinsics.checkNotNullParameter(log, MessagePart.TYPE_LOG);
        this.logDep = log;
    }

    public final void addReportDepend(IReportDepend report) {
        Intrinsics.checkNotNullParameter(report, "report");
        this.reportDep = report;
    }

    private final void printLog(final String msg) {
        ThreadPool.INSTANCE.runInBackGround(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifier$printLog$1
            @Override // java.lang.Runnable
            public final void run() {
                ILogDepend iLogDepend;
                iLogDepend = WebAuthVerifier.this.logDep;
                iLogDepend.log(WebAuthVerifier.TAG, msg);
            }
        });
    }

    private final void report(AuthReportInfo reportInfo) {
        this.reportDep.report(reportInfo);
    }
}
