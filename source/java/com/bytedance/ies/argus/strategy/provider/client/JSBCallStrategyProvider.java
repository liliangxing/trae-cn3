package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.JSBCallParams;
import com.bytedance.ies.argus.api.params.JSBCallRewritePayload;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.FeAuthConfig;
import com.bytedance.ies.argus.aspect.eventCenter.FeAuthConfigSource;
import com.bytedance.ies.argus.aspect.eventCenter.LynxViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.WebViewContext;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusJSBCallVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeCallRecord;
import com.bytedance.sdk.xbridge.cn.auth.bean.LimitRecord;
import com.bytedance.sdk.xbridge.cn.auth.bean.MethodCallLimitsBean;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: JSBCallStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2 \u0010\u000f\u001a\u001c0\u0010R\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0011H\u0016J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J6\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020 2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010(\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002Jj\u0010*\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00182\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020/0.j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020/`02\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u000203\u0018\u0001022\u0006\u00104\u001a\u00020\u0004H\u0002J\"\u00105\u001a\u00020\u00042\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u00109\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010=\u001a\u00020\u00182\b\u0010>\u001a\u0004\u0018\u00010\u0018H\u0002J\u0019\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010BJ \u0010C\u001a\u00020D2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010E\u001a\u00020FH\u0016J4\u0010G\u001a\u00020\n2\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020/0.j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020/`02\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006I"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/JSBCallStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "globalEnableLynxJsbAuth", "", "getGlobalEnableLynxJsbAuth", "()Z", "globalEnableLynxJsbCallLimit", "getGlobalEnableLynxJsbCallLimit", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "checkMethodPermission", "config", "Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "methodName", "", "methodAccess", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "getBridgeAuthTypeWithInfo", "Lkotlin/Pair;", "bridgeInfo", "Lcom/bytedance/ies/argus/api/params/JSBCallParams;", "feAuthConfig", "jsbCallConfig", "Lcom/bytedance/ies/argus/strategy/provider/client/JSBAuthConfig;", "handleLynxJSBCall", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/LynxViewContext;", "params", "rewritePayload", "Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "isCallInLimit", "Lcom/bytedance/ies/argus/bean/ArgusJSBCallVerifyReason;", "authUrl", "bridgeLimitRule", "Ljava/util/HashMap;", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeCallRecord;", "Lkotlin/collections/HashMap;", "methodCallLimitConfig", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "isWeb", "isMethodInCallLimitSafeUrls", "safeUrls", "", "url", "isValidLynxAuthUrl", "parseLimitFreq", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", ApmTrafficStats.KEY_FREQ, "parseNamespace", "namespace", "parseUnit", "", Scraps.INNER_UNIT, "(Ljava/lang/String;)Ljava/lang/Long;", "putCommonLynxJSBAuthCategory", "Lorg/json/JSONObject;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "updateCallRecord", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JSBCallStrategyProvider extends BaseStrategyProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LimitRecord RECORD_NO_LIMIT = new LimitRecord(1000, 999);
    public static final String TAG = "JSBCallStrategyProvider";

    /* compiled from: JSBCallStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/JSBCallStrategyProvider$Companion;", "", "()V", "RECORD_NO_LIMIT", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "getRECORD_NO_LIMIT", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "TAG", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LimitRecord getRECORD_NO_LIMIT() {
            return JSBCallStrategyProvider.RECORD_NO_LIMIT;
        }
    }

    private final boolean getGlobalEnableLynxJsbAuth() {
        return PermissionConfigV2Parser.getLynxAuthSwitch$default(PermissionConfigV2Parser.INSTANCE, (String) null, 1, (Object) null).getEnableJsbAuth();
    }

    private final boolean getGlobalEnableLynxJsbCallLimit() {
        return PermissionConfigV2Parser.getLynxAuthSwitch$default(PermissionConfigV2Parser.INSTANCE, (String) null, 1, (Object) null).getEnableJsbCallLimit();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.JSBAuth;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        final BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        final BaseRewritePayload rewritePayload = verifyResult.getRewritePayload();
        if (!(callerParams instanceof JSBCallParams) || !(rewritePayload instanceof JSBCallRewritePayload)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        final BaseViewContext<?> viewContext = context.getViewContext();
        if (viewContext instanceof LynxViewContext) {
            handleLynxJSBCall((LynxViewContext) viewContext, (JSBCallParams) callerParams, verifyResult, (JSBCallRewritePayload) rewritePayload, strategyConfig != null ? strategyConfig.getJsbCall() : null);
            context.getReportParams().setAddReportDataBlock(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.strategy.provider.client.JSBCallStrategyProvider$calculate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final JSONObject invoke() {
                    JSONObject putCommonLynxJSBAuthCategory;
                    putCommonLynxJSBAuthCategory = JSBCallStrategyProvider.this.putCommonLynxJSBAuthCategory((LynxViewContext) viewContext, (JSBCallParams) callerParams, (JSBCallRewritePayload) rewritePayload);
                    return putCommonLynxJSBAuthCategory;
                }
            });
        } else {
            if (viewContext instanceof WebViewContext) {
                return;
            }
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
        }
    }

    private final void handleLynxJSBCall(LynxViewContext viewContext, JSBCallParams params, AspectVerifyResult<?> verifyResult, JSBCallRewritePayload rewritePayload, JSBAuthConfig jsbCallConfig) {
        FeAuthConfig feAuthConfig;
        String desc;
        Boolean enableLynxJsbCallLimit;
        FeAuthConfigSource feAuthConfigSource;
        Boolean enableLynxJsbAuth;
        if (!((jsbCallConfig == null || (enableLynxJsbAuth = jsbCallConfig.getEnableLynxJsbAuth()) == null) ? getGlobalEnableLynxJsbAuth() : enableLynxJsbAuth.booleanValue())) {
            ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "global jsb auth switch is disable", null, 4, null);
            AspectVerifyResult.onPass$default(verifyResult, ArgusJSBCallVerifyReason.GLOBAL_DISABLE_LYNX_AUTH, null, null, 6, null);
            return;
        }
        String verifyUrl = viewContext.getVerifyUrl();
        Long feId = viewContext.getFeId();
        rewritePayload.setAuthUrl(verifyUrl);
        rewritePayload.setAuthFeId(String.valueOf(feId != null ? feId.longValue() : -1L));
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "start handle lynx jsb call, feId: " + feId + ", tasmFeId: " + viewContext.getTasmFeId() + ", authUrl: " + verifyUrl, null, 4, null);
        if (verifyUrl == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusJSBCallVerifyReason.AUTH_URL_IS_NULL, null, null, 6, null);
            return;
        }
        if (feId == null || feId.longValue() <= 0) {
            ArgusJSBCallVerifyReason argusJSBCallVerifyReason = ArgusJSBCallVerifyReason.LYNX_INVALID_FE_ID;
            StringBuilder sb = new StringBuilder();
            Object obj = feId;
            if (feId == null) {
                obj = ArgusConstants.NULL_PLACE_HOLDER;
            }
            AspectVerifyResult.onPass$default(verifyResult, argusJSBCallVerifyReason, sb.append(obj).append(", is null or <=0").toString(), null, 4, null);
            return;
        }
        FeAuthConfig feAuthConfig2 = viewContext.getFeAuthConfig();
        if (feAuthConfig2 == null) {
            String l = feId.toString();
            AuthConfigBean authConfig$default = PermissionConfigV2Parser.getAuthConfig$default(PermissionConfigV2Parser.INSTANCE, l, (String) null, 2, (Object) null);
            FeAuthConfig feAuthConfig3 = new FeAuthConfig(null, null, null, 0, null, null, null, 127, null);
            if (authConfig$default != null) {
                feAuthConfigSource = FeAuthConfigSource.CONTENT_V2_FROM_LYNX;
            } else {
                feAuthConfigSource = FeAuthConfigSource.CONTENT_V2_FROM_LYNX_UN_FOUND;
            }
            feAuthConfig3.updateContentV2Config(l, authConfig$default, feAuthConfigSource);
            viewContext.setFeAuthConfig(feAuthConfig3);
            feAuthConfig = feAuthConfig3;
        } else {
            feAuthConfig = feAuthConfig2;
        }
        if (feAuthConfig.getSource() != FeAuthConfigSource.CONTENT_V2_FROM_LYNX) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusJSBCallVerifyReason.LYNX_AUTH_CONFIG_IS_NULL, null, null, 6, null);
            return;
        }
        Pair<AuthBridgeAccess, Boolean> bridgeAuthTypeWithInfo = getBridgeAuthTypeWithInfo(params, feAuthConfig, jsbCallConfig);
        AuthBridgeAccess authBridgeAccess = (AuthBridgeAccess) bridgeAuthTypeWithInfo.component1();
        boolean booleanValue = ((Boolean) bridgeAuthTypeWithInfo.component2()).booleanValue();
        rewritePayload.setMethodAuthType(authBridgeAccess);
        if (booleanValue) {
            desc = AuthMode.STANDARD_LYNX_FORCE_PRIVATE.getDesc();
        } else {
            desc = AuthMode.STANDARD_LYNX.getDesc();
        }
        verifyResult.addExtra("auth_mode", desc);
        if ((jsbCallConfig == null || (enableLynxJsbCallLimit = jsbCallConfig.getEnableLynxJsbCallLimit()) == null) ? getGlobalEnableLynxJsbCallLimit() : enableLynxJsbCallLimit.booleanValue()) {
            Pair<ArgusJSBCallVerifyReason, String> isCallInLimit = isCallInLimit(params.getMethodName(), verifyUrl, viewContext.getBridgeLimitRule(), feAuthConfig.getMethodCallLimits(), false);
            ArgusJSBCallVerifyReason argusJSBCallVerifyReason2 = (ArgusJSBCallVerifyReason) isCallInLimit.component1();
            String str = (String) isCallInLimit.component2();
            if (argusJSBCallVerifyReason2 != null) {
                AspectVerifyResult.onBlock$default(verifyResult, argusJSBCallVerifyReason2, str, null, 4, null);
                return;
            }
        }
        checkMethodPermission(feAuthConfig, params.getMethodName(), authBridgeAccess, verifyResult);
        if (!verifyResult.isPass() || feAuthConfig.getMethodCallLimits().get(params.getMethodName()) == null) {
            return;
        }
        updateCallRecord(viewContext.getBridgeLimitRule(), params);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
    
        if (r13 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009c, code lost:
    
        if (r13 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<AuthBridgeAccess, Boolean> getBridgeAuthTypeWithInfo(JSBCallParams bridgeInfo, FeAuthConfig feAuthConfig, JSBAuthConfig jsbCallConfig) {
        Map<String, Integer> emptyMap;
        boolean z;
        String[] webPublicMethods;
        String methodName = bridgeInfo.getMethodName();
        String[] strArr = new String[0];
        if (jsbCallConfig == null || (emptyMap = jsbCallConfig.getCommonSecureMethods()) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "containerType=" + bridgeInfo.getContainerType() + ", enableAuth=" + (jsbCallConfig != null ? jsbCallConfig.getEnableLynxJsbAuth() : null) + ", lynxForcePrivate=" + (jsbCallConfig != null ? jsbCallConfig.getEnableLynxForcePrivate() : null) + ", webForcePrivate=" + (jsbCallConfig != null ? jsbCallConfig.getEnableWebForcePrivate() : null), null, 4, null);
        if (jsbCallConfig != null) {
            if (bridgeInfo.getContainerType() == ArgusContainerType.LYNX) {
                Boolean enableLynxForcePrivate = jsbCallConfig.getEnableLynxForcePrivate();
                z = enableLynxForcePrivate != null ? enableLynxForcePrivate.booleanValue() : true;
                webPublicMethods = jsbCallConfig.getLynxPublicMethods();
            } else if (bridgeInfo.getContainerType() == ArgusContainerType.WEB) {
                Boolean enableWebForcePrivate = jsbCallConfig.getEnableWebForcePrivate();
                z = enableWebForcePrivate != null ? enableWebForcePrivate.booleanValue() : true;
                webPublicMethods = jsbCallConfig.getWebPublicMethods();
            }
            if (emptyMap.containsKey(methodName)) {
                Integer num = emptyMap.get(methodName);
                if (feAuthConfig.getSecureAuthVersion() >= (num != null ? num.intValue() : 0)) {
                    return new Pair<>(AuthBridgeAccess.SECURE, Boolean.valueOf(z));
                }
            }
            if (!ArraysKt.contains(strArr, methodName)) {
                return new Pair<>(AuthBridgeAccess.PUBLIC, Boolean.valueOf(z));
            }
            if (z) {
                return new Pair<>(AuthBridgeAccess.PRIVATE, true);
            }
            return new Pair<>(bridgeInfo.getMethodAuthType(), false);
        }
        z = true;
        if (emptyMap.containsKey(methodName)) {
        }
        if (!ArraysKt.contains(strArr, methodName)) {
        }
    }

    private final void checkMethodPermission(FeAuthConfig config, String methodName, AuthBridgeAccess methodAccess, AspectVerifyResult<?> verifyResult) {
        if (config.getExcludedMethods().contains(methodName)) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusJSBCallVerifyReason.IN_EXCLUDE_METHODS, null, null, 6, null);
            return;
        }
        if (config.getIncludedMethods().contains(methodName)) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusJSBCallVerifyReason.IN_INCLUDE_METHODS, null, null, 6, null);
            return;
        }
        if (methodAccess == AuthBridgeAccess.SECURE) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusJSBCallVerifyReason.SECURE_NOT_INCLUDE, null, null, 6, null);
            return;
        }
        if (config.getAccess().compareTo((Enum) methodAccess) >= 0) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusJSBCallVerifyReason.PASS_GROUP_COMPARE, "method(" + methodAccess + ") >= rule(" + config.getAccess() + ')', null, 4, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusJSBCallVerifyReason.RULE_DENY_NOT_INCLUDE, "method(" + methodAccess + ") < rule(" + config.getAccess() + ')', null, 4, null);
        }
    }

    private final Pair<ArgusJSBCallVerifyReason, String> isCallInLimit(String methodName, String authUrl, HashMap<String, BridgeCallRecord> bridgeLimitRule, Map<String, MethodCallLimitsBean> methodCallLimitConfig, boolean isWeb) {
        if (methodCallLimitConfig == null) {
            methodCallLimitConfig = MapsKt.emptyMap();
        }
        MethodCallLimitsBean methodCallLimitsBean = methodCallLimitConfig.get(methodName);
        if (methodCallLimitsBean == null) {
            return new Pair<>((Object) null, (Object) null);
        }
        if (isWeb && !isMethodInCallLimitSafeUrls(methodCallLimitsBean.getUrl(), authUrl)) {
            return new Pair<>(ArgusJSBCallVerifyReason.NOT_IN_SAFE_URL, (Object) null);
        }
        if (!isWeb && isValidLynxAuthUrl(authUrl) && !isMethodInCallLimitSafeUrls(methodCallLimitsBean.getUrl(), authUrl)) {
            return new Pair<>(ArgusJSBCallVerifyReason.NOT_IN_SAFE_URL, (Object) null);
        }
        BridgeCallRecord bridgeCallRecord = bridgeLimitRule.get(methodName);
        if (bridgeCallRecord != null) {
            Integer runtime_call_count = methodCallLimitsBean.getRuntime_call_count();
            int intValue = runtime_call_count != null ? runtime_call_count.intValue() : 0;
            if (intValue != 0 && intValue <= bridgeCallRecord.getCallTimes()) {
                return new Pair<>(ArgusJSBCallVerifyReason.OVER_CALL_TIMES, String.valueOf(intValue));
            }
            String runtime_call_frequency = methodCallLimitsBean.getRuntime_call_frequency();
            LimitRecord parseLimitFreq = parseLimitFreq(runtime_call_frequency);
            if (parseLimitFreq == null || Intrinsics.areEqual(parseLimitFreq, RECORD_NO_LIMIT)) {
                return new Pair<>((Object) null, (Object) null);
            }
            Long lastCallTimeStamp = bridgeCallRecord.getLastCallTimeStamp();
            long longValue = lastCallTimeStamp != null ? lastCallTimeStamp.longValue() : 0L;
            if (System.currentTimeMillis() - longValue <= parseLimitFreq.getSpendTimestamp() && bridgeCallRecord.getCallFreqTimes() >= parseLimitFreq.getCount()) {
                return new Pair<>(ArgusJSBCallVerifyReason.OVER_CALL_FREQ, String.valueOf(runtime_call_frequency));
            }
            if (System.currentTimeMillis() - longValue > parseLimitFreq.getSpendTimestamp()) {
                bridgeLimitRule.put(methodName, new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), bridgeCallRecord.getCallTimes(), 0));
            }
        }
        return new Pair<>((Object) null, (Object) null);
    }

    private final void updateCallRecord(HashMap<String, BridgeCallRecord> bridgeLimitRule, JSBCallParams bridgeInfo) {
        BridgeCallRecord bridgeCallRecord;
        BridgeCallRecord bridgeCallRecord2 = bridgeLimitRule.get(bridgeInfo.getMethodName());
        HashMap<String, BridgeCallRecord> hashMap = bridgeLimitRule;
        String methodName = bridgeInfo.getMethodName();
        if (bridgeCallRecord2 != null) {
            bridgeCallRecord = new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), bridgeCallRecord2.getCallTimes() + 1, bridgeCallRecord2.getCallFreqTimes() + 1);
        } else {
            bridgeCallRecord = new BridgeCallRecord(Long.valueOf(System.currentTimeMillis()), 1, 1);
        }
        hashMap.put(methodName, bridgeCallRecord);
    }

    private final boolean isMethodInCallLimitSafeUrls(List<String> safeUrls, String url) {
        List<String> list = safeUrls;
        if (list == null || list.isEmpty()) {
            return true;
        }
        if (url == null) {
            return false;
        }
        return CommonUtils.INSTANCE.verifyDecodeUrl$anniex_release(safeUrls, url);
    }

    private final boolean isValidLynxAuthUrl(String authUrl) {
        if (authUrl != null) {
            return StringsKt.startsWith$default(authUrl, "gecko://", false, 2, (Object) null) || StringsKt.startsWith$default(authUrl, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(authUrl, "https://", false, 2, (Object) null);
        }
        return false;
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
                }
            } catch (Throwable unused) {
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
                return Long.valueOf(DateUtils.DAY);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject putCommonLynxJSBAuthCategory(LynxViewContext viewContext, JSBCallParams params, JSBCallRewritePayload rewritePayload) {
        String str;
        FeAuthConfigSource source;
        ArgusResourceLoaderInfo loaderInfo;
        Long resourceVersion;
        AuthBridgeAccess access;
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "bridge_name", params.getMethodName());
        String verifyUrl = viewContext.getVerifyUrl();
        if (verifyUrl == null || (str = CommonUtils.INSTANCE.removeQuery(verifyUrl)) == null) {
            str = "";
        }
        JSONUtilsKt.safelyPut(jSONObject, "auth_url", str);
        Object feId = viewContext.getFeId();
        if (feId == null) {
            feId = "";
        }
        JSONUtilsKt.safelyPut(jSONObject, "fe_id", feId);
        JSONUtilsKt.safelyPut(jSONObject, "method_auth_type", rewritePayload.getMethodAuthType().getValue());
        FeAuthConfig feAuthConfig = viewContext.getFeAuthConfig();
        if (feAuthConfig != null && (access = feAuthConfig.getAccess()) != null) {
            JSONUtilsKt.safelyPut(jSONObject, "fe_auth_group", access.getValue());
        }
        JSONUtilsKt.safelyPut(jSONObject, "fe_config_version", Integer.valueOf(PermissionConfigV2Parser.getPackageVersion$default(PermissionConfigV2Parser.INSTANCE, (String) null, 1, (Object) null)));
        JSONUtilsKt.safelyPut(jSONObject, "fe_config_from", PermissionConfigV2Parser.INSTANCE.getPackageLoaderName());
        LoadTemplateParams templateInfo = viewContext.getTemplateInfo(ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);
        JSONUtilsKt.safelyPut(jSONObject, "page_gecko_version", Long.valueOf((templateInfo == null || (loaderInfo = templateInfo.getLoaderInfo()) == null || (resourceVersion = loaderInfo.getResourceVersion()) == null) ? 0L : resourceVersion.longValue()));
        JSONUtilsKt.safelyPut(jSONObject, "container_type", ArgusContainerType.LYNX.getValue());
        String verifyUrl2 = viewContext.getVerifyUrl();
        if (verifyUrl2 == null) {
            verifyUrl2 = "";
        }
        JSONUtilsKt.safelyPut(jSONObject, "origin_auth_url", verifyUrl2);
        FeAuthConfig feAuthConfig2 = viewContext.getFeAuthConfig();
        if (feAuthConfig2 != null && (source = feAuthConfig2.getSource()) != null) {
            JSONUtilsKt.safelyPut(jSONObject, "auth_config_source", Integer.valueOf(source.getCode()));
        }
        Long tasmFeId = viewContext.getTasmFeId();
        JSONUtilsKt.safelyPut(jSONObject, "tasm_fe_id", tasmFeId != null ? tasmFeId : "");
        JSONUtilsKt.safelyPut(jSONObject, "namespace", parseNamespace(params.getNamespace()));
        JSONUtilsKt.safelyPut(jSONObject, "origin_method_auth_type", params.getMethodAuthType().getValue());
        return jSONObject;
    }

    private final String parseNamespace(String namespace) {
        return (namespace == null || !Intrinsics.areEqual(namespace, "")) ? namespace == null ? "unset" : namespace : "host";
    }
}
