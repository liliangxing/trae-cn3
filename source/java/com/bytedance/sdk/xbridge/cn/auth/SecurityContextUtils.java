package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.SecurityContext;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.BaseBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SecurityContextUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\n\u0010\u0015\u001a\u00020\u0004*\u00020\u0016J\n\u0010\u0015\u001a\u00020\u0004*\u00020\u0017J\n\u0010\u0015\u001a\u00020\u0004*\u00020\u0018J\n\u0010\u0019\u001a\u00020\u0004*\u00020\u0016J\n\u0010\u0019\u001a\u00020\u0004*\u00020\u0017J\n\u0010\u0019\u001a\u00020\u0004*\u00020\u0018J\u0012\u0010\u001a\u001a\u00020\u000e*\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/SecurityContextUtils;", "", "()V", "PREFIX", "", "X_SECURITY_ARGUS_HEADER_KEY", "defaultTargetMethodList", "", "getDefaultTargetMethodList", "()Ljava/util/Set;", "getContainerType", DBData.FIELD_TYPE, "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "registerSecurityContext", "", "containerContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "removeQuery", IWeixinService.ResponseConstants.URL, "getXSecurityArgusHeaderKey", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "Lcom/bytedance/sdk/xbridge/cn/auth/ISecurityContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "getXSecurityArgusHeaderValue", "putSecurityContext", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SecurityContextUtils {
    public static final String PREFIX = "BridgeNetworkRequest";
    public static final String X_SECURITY_ARGUS_HEADER_KEY = "x-security-argus";
    public static final SecurityContextUtils INSTANCE = new SecurityContextUtils();
    private static final Set<String> defaultTargetMethodList = SetsKt.setOf(new String[]{"__prefetch", "downloadFile", "fetch", "downloadFileWithMetaData", "pda.awemeRequest", OauthTokenTriggerScene.REQUEST, "ttcjpay.request", "uploadFile"});

    /* compiled from: SecurityContextUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlatformType.values().length];
            try {
                iArr[PlatformType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlatformType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlatformType.WORKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getXSecurityArgusHeaderKey(CallContext callContext) {
        Intrinsics.checkNotNullParameter(callContext, "<this>");
        return X_SECURITY_ARGUS_HEADER_KEY;
    }

    public final String getXSecurityArgusHeaderKey(ISecurityContext iSecurityContext) {
        Intrinsics.checkNotNullParameter(iSecurityContext, "<this>");
        return X_SECURITY_ARGUS_HEADER_KEY;
    }

    public final String getXSecurityArgusHeaderKey(IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "<this>");
        return X_SECURITY_ARGUS_HEADER_KEY;
    }

    private SecurityContextUtils() {
    }

    public final Set<String> getDefaultTargetMethodList() {
        return defaultTargetMethodList;
    }

    public final void registerSecurityContext(BaseBDXBridgeContext containerContext, final BaseBridgeCall<?> call) {
        List emptyList;
        ContextProviderFactory contextProviderFactory;
        Intrinsics.checkNotNullParameter(containerContext, "containerContext");
        Intrinsics.checkNotNullParameter(call, "call");
        ArgusGlobalCommonConfig argusSecuritySettingConfig = ArgusConfigManager.Companion.getInstance().getArgusSecuritySettingConfig();
        if (argusSecuritySettingConfig == null || (emptyList = argusSecuritySettingConfig.getInjectSecurityContextJsbList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        if (SetsKt.plus(defaultTargetMethodList, emptyList).contains(call.getMethodName()) && (contextProviderFactory = (ContextProviderFactory) containerContext.getService(ContextProviderFactory.class)) != null) {
            contextProviderFactory.registerProvider(ISecurityContext.class, new Function0<ISecurityContext>() { // from class: com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils$registerSecurityContext$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final ISecurityContext m890invoke() {
                    final BaseBridgeCall<?> baseBridgeCall = call;
                    return new ISecurityContext() { // from class: com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils$registerSecurityContext$1.1
                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getAuthUrl() {
                            String authUrl = baseBridgeCall.getAuthUrl();
                            return authUrl == null ? "" : authUrl;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getAuthFeId() {
                            return baseBridgeCall.getAuthFeId();
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getContainerType() {
                            String containerType;
                            containerType = SecurityContextUtils.INSTANCE.getContainerType(baseBridgeCall.getPlatformType());
                            return containerType;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getAppId() {
                            String appId = BulletEnv.Companion.getInstance().getAppId();
                            return appId == null ? "" : appId;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getAppVersion() {
                            String appVersion = BulletEnv.Companion.getInstance().getAppVersion();
                            return appVersion == null ? "" : appVersion;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getChannel() {
                            String channel = BulletEnv.Companion.getInstance().getChannel();
                            return channel == null ? "" : channel;
                        }

                        @Override // com.bytedance.sdk.xbridge.cn.auth.ISecurityContext
                        public String getMethodName() {
                            return baseBridgeCall.getMethodName();
                        }
                    };
                }
            });
        }
    }

    public final String getXSecurityArgusHeaderValue(ISecurityContext iSecurityContext) {
        Intrinsics.checkNotNullParameter(iSecurityContext, "<this>");
        String authUrl = iSecurityContext.getAuthUrl();
        String authFeId = iSecurityContext.getAuthFeId();
        String appId = iSecurityContext.getAppId();
        String channel = iSecurityContext.getChannel();
        String appVersion = iSecurityContext.getAppVersion();
        String containerType = iSecurityContext.getContainerType();
        iSecurityContext.getMethodName();
        return "BridgeNetworkRequest/unknown aid/" + appId + '/' + channel + "/Android/" + appVersion + '/' + containerType + '/' + authFeId + ' ' + removeQuery(authUrl);
    }

    public final String getXSecurityArgusHeaderValue(IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "<this>");
        BaseBridgeCall<?> bridgeCall = iBDXBridgeContext.getBridgeCall();
        String authUrl = bridgeCall.getAuthUrl();
        if (authUrl == null) {
            authUrl = "";
        }
        String authFeId = bridgeCall.getAuthFeId();
        String appId = BulletEnv.Companion.getInstance().getAppId();
        if (appId == null) {
            appId = "";
        }
        String channel = BulletEnv.Companion.getInstance().getChannel();
        if (channel == null) {
            channel = "";
        }
        bridgeCall.getMethodName();
        String appVersion = BulletEnv.Companion.getInstance().getAppVersion();
        return "BridgeNetworkRequest/unknown aid/" + appId + '/' + channel + "/Android/" + (appVersion != null ? appVersion : "") + '/' + getContainerType(bridgeCall.getPlatformType()) + '/' + authFeId + ' ' + removeQuery(authUrl);
    }

    public final String getXSecurityArgusHeaderValue(CallContext callContext) {
        Intrinsics.checkNotNullParameter(callContext, "<this>");
        SecurityContext securityContext = callContext.getSecurityContext();
        securityContext.getMethodName();
        String authUrl = securityContext.getAuthUrl();
        if (authUrl == null) {
            authUrl = "";
        }
        String authFeId = securityContext.getAuthFeId();
        String appId = BulletEnv.Companion.getInstance().getAppId();
        if (appId == null) {
            appId = "";
        }
        String channel = BulletEnv.Companion.getInstance().getChannel();
        if (channel == null) {
            channel = "";
        }
        String appVersion = BulletEnv.Companion.getInstance().getAppVersion();
        return "BridgeNetworkRequest/unknown aid/" + appId + '/' + channel + "/Android/" + (appVersion != null ? appVersion : "") + '/' + securityContext.getContainerType() + '/' + authFeId + ' ' + removeQuery(authUrl);
    }

    public final void putSecurityContext(CallContext callContext, ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(callContext, "<this>");
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        ISecurityContext iSecurityContext = (ISecurityContext) contextProviderFactory.provideInstance(ISecurityContext.class);
        if (iSecurityContext == null) {
            return;
        }
        SecurityContext securityContext = callContext.getSecurityContext();
        securityContext.setAuthUrl(iSecurityContext.getAuthUrl());
        securityContext.setAuthFeId(iSecurityContext.getAuthFeId());
        securityContext.setAppId(iSecurityContext.getAppId());
        securityContext.setAppVersion(iSecurityContext.getAppVersion());
        securityContext.setChannel(iSecurityContext.getChannel());
        securityContext.setContainerType(iSecurityContext.getContainerType());
        securityContext.setMethodName(iSecurityContext.getMethodName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getContainerType(PlatformType type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return "lynx";
        }
        if (i == 2) {
            return "h5";
        }
        if (i == 3) {
            return "worker";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String removeQuery(String url) {
        int indexOf$default = StringsKt.indexOf$default(url, "?", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return url;
        }
        if (url == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = url.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
