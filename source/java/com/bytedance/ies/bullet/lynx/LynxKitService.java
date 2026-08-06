package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.lynx.init.LynxKit;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010$\u001a\u00020 H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxKitService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitService;", "()V", "kitConfig", "Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "provider", "Lcom/bytedance/ies/bullet/lynx/ILynxDelegateProvider;", "(Lcom/bytedance/ies/bullet/service/base/IKitConfig;Lcom/bytedance/ies/bullet/lynx/ILynxDelegateProvider;)V", "getKitConfig", "()Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "setKitConfig", "(Lcom/bytedance/ies/bullet/service/base/IKitConfig;)V", "getProvider", "()Lcom/bytedance/ies/bullet/lynx/ILynxDelegateProvider;", "sdkVersion", "", "getSdkVersion", "()Ljava/lang/String;", "sessionId", "beginSection", "", "sectionName", "createKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "createKitViewWithSessionId", "endSection", "initKit", "initVmSdk", "isVmSdkReady", "", "provideDelegate", "Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "service", "ready", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxKitService extends BaseBulletService implements ILynxKitService {
    private static volatile boolean sHasLynxEnvInitialized;
    private IKitConfig kitConfig;
    private final ILynxDelegateProvider provider;
    private String sessionId;

    public /* synthetic */ LynxKitService(IKitConfig iKitConfig, ILynxDelegateProvider iLynxDelegateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iKitConfig, (i & 2) != 0 ? null : iLynxDelegateProvider);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public IKitConfig getKitConfig() {
        return this.kitConfig;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void setKitConfig(IKitConfig iKitConfig) {
        Intrinsics.checkNotNullParameter(iKitConfig, "<set-?>");
        this.kitConfig = iKitConfig;
    }

    public final ILynxDelegateProvider getProvider() {
        return this.provider;
    }

    public LynxKitService(IKitConfig iKitConfig, ILynxDelegateProvider iLynxDelegateProvider) {
        Intrinsics.checkNotNullParameter(iKitConfig, "kitConfig");
        this.kitConfig = iKitConfig;
        this.provider = iLynxDelegateProvider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LynxKitService() {
        this(new IKitConfig() { // from class: com.bytedance.ies.bullet.lynx.LynxKitService.1
        }, r1, 2, r1);
        ILynxDelegateProvider iLynxDelegateProvider = null;
    }

    public final AbsLynxDelegate provideDelegate(BaseBulletService service, IServiceToken context) {
        AbsLynxDelegate provideLynxDelegate;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(context, "context");
        ILynxDelegateProvider iLynxDelegateProvider = this.provider;
        return (iLynxDelegateProvider == null || (provideLynxDelegate = iLynxDelegateProvider.provideLynxDelegate(service, context)) == null) ? new DefaultLynxDelegate(this, context) : provideLynxDelegate;
    }

    public final AbsLynxDelegate provideDelegate(BaseBulletService service, IServiceToken context, String sessionId) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ILynxDelegateProvider iLynxDelegateProvider = this.provider;
        if (iLynxDelegateProvider != null && (iLynxDelegateProvider instanceof AbsLynxDelegateProvider)) {
            return ((AbsLynxDelegateProvider) iLynxDelegateProvider).provideLynxDelegate(service, context, sessionId);
        }
        if (iLynxDelegateProvider != null) {
            return iLynxDelegateProvider.provideLynxDelegate(service, context);
        }
        return new DefaultLynxDelegate(this, context, sessionId);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void initKit(IServiceToken context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LynxEnv inst = LynxEnv.inst();
        Intrinsics.checkNotNullExpressionValue(inst, "inst()");
        synchronized (inst) {
            IKitConfig kitConfig = getKitConfig();
            LynxConfig lynxConfig = kitConfig instanceof LynxConfig ? (LynxConfig) kitConfig : null;
            Boolean forceInit = lynxConfig != null ? lynxConfig.getForceInit() : null;
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "forceInit :" + forceInit, null, "XLynxKit", 2, null);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "sHasLynxEnvInitialized :" + sHasLynxEnvInitialized, null, "XLynxKit", 2, null);
            if (!sHasLynxEnvInitialized || Intrinsics.areEqual(forceInit, true)) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to init lynx lib", null, "XLynxKit", 2, null);
                try {
                    IKitConfig kitConfig2 = getKitConfig();
                    if (!(kitConfig2 instanceof LynxConfig)) {
                        kitConfig2 = null;
                    }
                    Intrinsics.checkNotNull(kitConfig2, "null cannot be cast to non-null type com.bytedance.ies.bullet.lynx.init.LynxConfig");
                    LynxKit.init$default(LynxKit.INSTANCE, (LynxConfig) kitConfig2, context, false, 4, null);
                    ILynxKitService iLynxKitService = (ILynxKitService) getService(ILynxKitService.class);
                    sHasLynxEnvInitialized = iLynxKitService != null ? iLynxKitService.ready() : false;
                    if (Intrinsics.areEqual(forceInit, true)) {
                        ILynxKitService iLynxKitService2 = (ILynxKitService) getService(ILynxKitService.class);
                        Object kitConfig3 = iLynxKitService2 != null ? iLynxKitService2.getKitConfig() : null;
                        LynxConfig lynxConfig2 = kitConfig3 instanceof LynxConfig ? (LynxConfig) kitConfig3 : null;
                        if (lynxConfig2 != null) {
                            lynxConfig2.setForceInit(false);
                        }
                    }
                } catch (Exception e) {
                    BulletLogger.INSTANCE.printReject(e, "init lynx failed", "XLynxKit");
                    sHasLynxEnvInitialized = false;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public boolean ready() {
        return LynxKit.INSTANCE.ready();
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public IKitViewService createKitView(IServiceToken context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.sessionId != null) {
            String str = this.sessionId;
            Intrinsics.checkNotNull(str);
            return new LynxKitView(context, this, str);
        }
        return new LynxKitView(context, this);
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitService
    public String getSdkVersion() {
        String lynxVersion = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
        return lynxVersion;
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitService
    public boolean isVmSdkReady() {
        return LynxKit.INSTANCE.isVmSdkReady();
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitService
    public void initVmSdk() {
        LynxKit.INSTANCE.initVmSdk();
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitService
    public IKitViewService createKitViewWithSessionId(String sessionId, IServiceToken context) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.sessionId = sessionId;
        return createKitView(context);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void beginSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        TraceEvent.beginSection(sectionName);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void endSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        TraceEvent.endSection(sectionName);
    }
}
