package com.bytedance.trae.common.security.impl;

import android.content.Context;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.security.android.aopcheck.env.AOPEnvironment;
import com.bytedance.security.android.aopcheck.env.ICommonConfig;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.security.api.CommonMsReportScenes;
import com.bytedance.trae.common.security.api.SecurityService;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SecurityServiceImpl.kt */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&H\u0016J\b\u0010(\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;", "Lcom/bytedance/trae/common/security/api/SecurityService;", "<init>", "()V", "didListener", "com/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1", "Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;", "msInit", "", "appContext", "Landroid/content/Context;", "initMsInternal", "isLogin", "", "privacyAccepted", "msReport", "context", "scene", "", "msFrameSign", "", "rawStr", "report", "withDid", "observeAndUpdateDid", "reportReceiveDid", "did", "iid", "initBdInstall", "createBdInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "initAOPEnvironment", "enableTTNetEncrypt", "getTTNetEncryptScene", "requestUrl", "shouldAddTTNetEncryptHeader", "tryMobTTNetEncryptResult", "responseHeaders", "", "", "forceTTNetRetry", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SecurityServiceImpl implements SecurityService {
    private static final String MS_SDK_LICENSE = "QgOQBrRT5fGyDbtY52i4z4HFVPb1QKNo5V9CmM9q13PpijZGpMGpmIl97Q+nimje9MSX7RVv7AlXPOM8pMApx5PpdkSNVwiqylpWPZ/bUDDZtf/fyDxN2kDpW6z4Mz4eM+Qe5enKwdxkMAcrsRonO1Q+4EfTvSL39iyLBCxiiz2Ybi6bSubaFOAp2eA4J0owrLPz+RyYf9eUICEAAzOCYScic/GD6cUayMVJbS/FD8m8vYcFKJh08NfL1S6KiHtUn1GXID8QLyZ31o5j0zvVbup9ermTNfJWbq9GfYh8LtqNM+VdZi6S68neWG6E8VXiUQfuEQ==";
    private static final String TAG = "SecurityService";
    private final SecurityServiceImpl$didListener$1 didListener = new OnGetAppLogIdListener() { // from class: com.bytedance.trae.common.security.impl.SecurityServiceImpl$didListener$1
        @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
        public void onGetId(String did, String iid, String ssid) {
            Intrinsics.checkNotNullParameter(did, "did");
            Intrinsics.checkNotNullParameter(iid, "iid");
            Intrinsics.checkNotNullParameter(ssid, "ssid");
            if (did.length() > 0) {
                SecurityServiceImpl.this.reportReceiveDid(did, iid);
            }
        }
    };

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public Interceptor createBdInterceptor() {
        return null;
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public boolean enableTTNetEncrypt() {
        return false;
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public boolean forceTTNetRetry() {
        return false;
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public String getTTNetEncryptScene(String requestUrl) {
        return null;
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public void initBdInstall() {
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public boolean shouldAddTTNetEncryptHeader(String requestUrl) {
        return false;
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public void tryMobTTNetEncryptResult(String requestUrl, String scene, List<Object> responseHeaders) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public void msInit(final Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        boolean isTraeLoggedIn = iLoginService != null ? iLoginService.isTraeLoggedIn() : false;
        initMsInternal(appContext, isTraeLoggedIn, isTraeLoggedIn);
        observeAndUpdateDid();
        if (isTraeLoggedIn) {
            IApplog.INSTANCE.doWhenIdsReady(new Function2() { // from class: com.bytedance.trae.common.security.impl.SecurityServiceImpl$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit msInit$lambda$0;
                    msInit$lambda$0 = SecurityServiceImpl.msInit$lambda$0(SecurityServiceImpl.this, appContext, (String) obj, (String) obj2);
                    return msInit$lambda$0;
                }
            });
            return;
        }
        report(appContext, "cold_start", false);
        ILoginService iLoginService2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService2 != null) {
            ILoginService.DefaultImpls.registerAccountStatusChangeListener$default(iLoginService2, new SecurityServiceImpl$msInit$2(this, appContext), (Boolean) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit msInit$lambda$0(SecurityServiceImpl securityServiceImpl, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        securityServiceImpl.report(context, "cold_start", true);
        return Unit.INSTANCE;
    }

    private final void initMsInternal(Context appContext, boolean isLogin, boolean privacyAccepted) {
        MSConfig.Builder builder = new MSConfig.Builder(String.valueOf(AppHost.INSTANCE.getAppId()), MS_SDK_LICENSE, 810);
        builder.addAdvanceInfo("kS1", "1");
        builder.setClientType(0);
        builder.setChannel(AppHost.INSTANCE.getBuildChannel());
        builder.setDefaultReportHost("https://" + HostResolver.INSTANCE.getHost(HostType.MSSDK));
        if (privacyAccepted) {
            String deviceId = IApplog.INSTANCE.getDeviceId();
            if (deviceId.length() > 0) {
                builder.setDeviceID(deviceId);
            }
        }
        String installId = IApplog.INSTANCE.getInstallId();
        if (installId.length() > 0) {
            builder.setInstallID(installId);
        }
        MSManagerUtils.init(appContext, builder.build());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new SecurityServiceImpl$initMsInternal$1(null), 3, (Object) null);
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public void msReport(Context context, String scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        report(context, scene, iLoginService != null ? iLoginService.isTraeLoggedIn() : false);
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public Map<String, String> msFrameSign(String rawStr) {
        Intrinsics.checkNotNullParameter(rawStr, "rawStr");
        Map<String, String> frameSign = MSManagerUtils.get(String.valueOf(AppHost.INSTANCE.getAppId())).frameSign(rawStr, 1);
        return frameSign == null ? MapsKt.emptyMap() : frameSign;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(Context context, String scene, boolean withDid) {
        MSManager mSManager = MSManagerUtils.get(String.valueOf(AppHost.INSTANCE.getAppId()));
        if (withDid) {
            String deviceId = IApplog.INSTANCE.getDeviceId();
            if (deviceId.length() > 0) {
                mSManager.setDeviceID(deviceId);
            }
        }
        String installId = IApplog.INSTANCE.getInstallId();
        if (installId.length() > 0) {
            mSManager.setInstallID(installId);
        }
        mSManager.report(scene);
    }

    private final void observeAndUpdateDid() {
        IApplog.INSTANCE.removeDidListener(this.didListener);
        IApplog.INSTANCE.addGetAppLogIdListener(this.didListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportReceiveDid(String did, String iid) {
        MSManager mSManager = MSManagerUtils.get(String.valueOf(AppHost.INSTANCE.getAppId()));
        mSManager.setDeviceID(did);
        mSManager.setInstallID(iid);
        mSManager.report(CommonMsReportScenes.DID_IID_UPDATE);
    }

    @Override // com.bytedance.trae.common.security.api.SecurityService
    public void initAOPEnvironment(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IApplog.INSTANCE.doWhenIdsReady(new Function2() { // from class: com.bytedance.trae.common.security.impl.SecurityServiceImpl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit initAOPEnvironment$lambda$1;
                initAOPEnvironment$lambda$1 = SecurityServiceImpl.initAOPEnvironment$lambda$1(context, (String) obj, (String) obj2);
                return initAOPEnvironment$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAOPEnvironment$lambda$1(Context context, final String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "did");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        AOPEnvironment.INSTANCE.active(context, new ICommonConfig() { // from class: com.bytedance.trae.common.security.impl.SecurityServiceImpl$initAOPEnvironment$1$1
            @Override // com.bytedance.security.android.aopcheck.env.ICommonConfig
            public String getAppVersion() {
                return AppHost.INSTANCE.getVersionName();
            }

            @Override // com.bytedance.security.android.aopcheck.env.ICommonConfig
            /* renamed from: getDeviceId, reason: from getter */
            public String get$did() {
                return str;
            }

            @Override // com.bytedance.security.android.aopcheck.env.ICommonConfig
            public String getHostAid() {
                return String.valueOf(AppHost.INSTANCE.getAppId());
            }

            @Override // com.bytedance.security.android.aopcheck.env.ICommonConfig
            public String getChannel() {
                return AppHost.INSTANCE.getBuildChannel();
            }

            @Override // com.bytedance.security.android.aopcheck.env.ICommonConfig
            public String getUpdateVersionCode() {
                return String.valueOf(AppHost.INSTANCE.getUpdateVersionCode());
            }
        });
        return Unit.INSTANCE;
    }
}
