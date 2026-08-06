package com.bytedance.ies.bullet.p003ui.common.loader;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletSchemeContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.LifeCycleDelegate;
import com.bytedance.ies.bullet.core.RLReportController;
import com.bytedance.ies.bullet.core.SSRConfig;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.init.ILoaderInitService;
import com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack;
import com.bytedance.ies.bullet.service.base.init.TaskStatus;
import com.bytedance.ies.bullet.service.base.lynx.IKitDynamicService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ExtraInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.SessionInfo;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContainerLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0019H\u0002J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J<\u0010!\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020 H\u0002J*\u0010$\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J*\u0010%\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J \u0010&\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0005H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J#\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b.J\u0010\u0010/\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020\bH\u0002J \u00102\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u00103\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J(\u00104\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0019H\u0002J\u0006\u00106\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/loader/BulletContainerLoader;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "bid", "", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;Ljava/lang/String;)V", "isFallback", "", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "mBid", "serviceContext", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "checkKitService", "type", "checkKitServiceInit", "", "Lcom/bytedance/ies/bullet/core/BulletContext;", "checkLoaderTasks", "uri", "Landroid/net/Uri;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "doFallBack", "e", "", "doLoadLynx", "doLoadUri", "doLoadWeb", "forceFallback", "bulletContext", "getBid", "getFallbackUri", "getKitTypeFromSchema", "getOrCreateKitViewService", "sessionId", "getOrCreateKitViewService$anniex_release", "installKitDynamicFeature", "isLynxKitReady", "isWebKitReady", "lifeCycleRunFallback", "fallbackUri", "loadUri", "mergeContext", "release", "setBid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletContainerLoader implements IServiceToken {
    private boolean isFallback;
    private KitType kitType;
    private IKitViewService kitViewService;
    private String mBid;
    private final IServiceContext serviceContext;

    /* compiled from: BulletContainerLoader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BulletContainerLoader(IServiceContext iServiceContext, String str) {
        Intrinsics.checkNotNullParameter(iServiceContext, "context");
        Intrinsics.checkNotNullParameter(str, "bid");
        this.serviceContext = iServiceContext;
        this.kitType = KitType.UNKNOWN;
        this.mBid = str;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public Map<Class<?>, Object> getAllDependency() {
        return IServiceToken.DefaultImpls.getAllDependency(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T> T getDependency(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getDependency(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T extends IBulletService> T getService(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getService(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public IServiceContext getServiceContext() {
        return this.serviceContext;
    }

    public final KitType getKitType() {
        return this.kitType;
    }

    public final void setKitType(KitType kitType) {
        Intrinsics.checkNotNullParameter(kitType, "<set-?>");
        this.kitType = kitType;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    /* renamed from: getBid, reason: from getter */
    public String getMBid() {
        return this.mBid;
    }

    public final void setBid(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.mBid = bid;
    }

    private final boolean checkKitService(KitType type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return isLynxKitReady();
        }
        if (i != 2) {
            return false;
        }
        return isWebKitReady();
    }

    private final boolean isLynxKitReady() {
        return getService(ILynxKitService.class) != null;
    }

    private final boolean isWebKitReady() {
        return getService(IWebKitService.class) != null;
    }

    public final void loadUri(BulletContext context, Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
        IServiceContext serviceContext;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        RLReportController.INSTANCE.initRLConfig(this.mBid);
        mergeContext(context);
        if (!context.getUseCardMode()) {
            context.getMonitorCallback().recordDuration(MetricConstant.LYNX_INSTALL_DYNAMIC_FEATURE, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader$loadUri$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m602invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m602invoke() {
                    BulletContainerLoader.this.installKitDynamicFeature(KitType.LYNX);
                }
            });
        }
        Uri value = new UrlParam(context.getSchemaModelUnion().getSchemaData(), "url", null).getValue();
        List<String> list = (List) new StringListParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_PACKAGES, null).getValue();
        IServiceContext serviceContext2 = context.getServiceContext();
        if (serviceContext2 != null) {
            serviceContext2.putDependency(SessionInfo.class, new SessionInfo(context.getSessionId()));
        }
        if (value != null) {
            String value2 = new StringParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_PREFIX, null).getValue();
            if (value2 != null) {
                r3 = TextUtils.isEmpty(value2) ^ true ? value2 : null;
                if (r3 != null && (serviceContext = context.getServiceContext()) != null) {
                    serviceContext.putDependency(ExtraInfo.class, new ExtraInfo(r3));
                }
            }
            BulletSchemeContext schemeContext = context.getSchemeContext();
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            schemeContext.setPackages(list);
            if (context.getUseCardMode() || !checkLoaderTasks(context, value, bundle, lifeCycle)) {
                doLoadUri(context, value, bundle, lifeCycle);
            }
            r3 = Unit.INSTANCE;
        }
        if (r3 == null) {
            lifeCycle.onLoadFail(uri, new Throwable("container_error: uri parse failed"));
        }
    }

    private final void mergeContext(BulletContext context) {
        ContextProviderFactory providerFactory = ContextProviderManager.INSTANCE.getProviderFactory(context.getSessionId());
        DebugInfo debugInfo = DebugConfig.INSTANCE.get(this.mBid);
        context.setBid(this.mBid);
        providerFactory.registerWeakHolder(DebugInfo.class, debugInfo);
    }

    private final void checkKitServiceInit(KitType kitType, BulletContext context) {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            if (checkKitService(kitType)) {
                int i = WhenMappings.$EnumSwitchMapping$0[kitType.ordinal()];
                unit = null;
                if (i == 1) {
                    ILynxKitService iLynxKitService = (ILynxKitService) getService(ILynxKitService.class);
                    if (iLynxKitService != null) {
                        if (!iLynxKitService.ready()) {
                            iLynxKitService.initKit(this);
                        }
                        ISchemaData schemaData = context.getSchemaData();
                        if (schemaData != null) {
                            if (Intrinsics.areEqual(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_DYNAMIC_V8, false).getValue(), true) && IConditionCallKt.enableDynamicLoadV8() && !iLynxKitService.isVmSdkReady()) {
                                iLynxKitService.initVmSdk();
                            }
                            unit = Unit.INSTANCE;
                        }
                    }
                } else {
                    if (i == 2) {
                        IWebKitService iWebKitService = (IWebKitService) getService(IWebKitService.class);
                        if (iWebKitService != null) {
                            if (!iWebKitService.ready()) {
                                iWebKitService.initKit(this);
                            }
                        }
                    }
                    unit = Unit.INSTANCE;
                }
            } else {
                BulletLogger.INSTANCE.printCoreReject(context.getSessionId(), "check engine init failed. kitType: " + kitType, "XView", new Throwable(), LogLevel.E);
                unit = Unit.INSTANCE;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        context.getLynxContext().setLynxEngineReady(checkKitService(KitType.LYNX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installKitDynamicFeature(KitType type) {
        IKitDynamicService iKitDynamicService = (IKitDynamicService) getService(IKitDynamicService.class);
        if (iKitDynamicService == null || iKitDynamicService.checkInstalled(type)) {
            return;
        }
        iKitDynamicService.install(type);
    }

    private final boolean checkLoaderTasks(final BulletContext context, final Uri uri, final Bundle bundle, final IBulletLifeCycle lifeCycle) {
        if (getService(ILoaderInitService.class) == null) {
            return false;
        }
        ILoaderInitService iLoaderInitService = (ILoaderInitService) getService(ILoaderInitService.class);
        if (iLoaderInitService == null) {
            return true;
        }
        context.getContainerContext().getLoaderTaskPerfMetric().setDuration(System.currentTimeMillis());
        context.getContainerContext().getLoaderTaskPerfMetric().setLoaderTasksReady(false);
        iLoaderInitService.startTask(context, new ILoaderTasksCallBack() { // from class: com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader$checkLoaderTasks$1$1
            @Override // com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack
            public void onStateChange(int code) {
                if (code == 1) {
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "all task ready", null, null, 6, null);
                    BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().setLoaderTasksReady(true);
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack
            public void onInitSuccess() {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "loader task run success", null, null, 6, null);
                BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().setDuration(System.currentTimeMillis() - BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().getDuration());
                BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().setLoaderResult(true);
                this.doLoadUri(BulletContext.this, uri, bundle, lifeCycle);
            }

            @Override // com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack
            public void onInitFailed(int code, TaskStatus taskStatus) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "loader task :" + (taskStatus != null ? taskStatus.getTaskName() : null) + " run failed, errorCode : " + code + ", statusCode:" + (taskStatus != null ? Integer.valueOf(taskStatus.getStatusCode()) : null), null, null, 6, null);
                BulletContext.this.getContainerContext().getLoaderTaskPerfMetric().setLoaderResult(false);
                lifeCycle.onLoadFail(uri, new Throwable("loader task :" + (taskStatus != null ? taskStatus.getTaskName() : null) + " init failed, errorCode : " + code + ", statusCode:" + (taskStatus != null ? Integer.valueOf(taskStatus.getStatusCode()) : null)));
            }
        });
        return true;
    }

    private final KitType getKitTypeFromSchema(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && scheme.equals("https")) {
                        return KitType.WEB;
                    }
                } else if (scheme.equals("http")) {
                    return KitType.WEB;
                }
            } else if (scheme.equals("lynxview")) {
                return KitType.LYNX;
            }
        }
        return KitType.UNKNOWN;
    }

    private final boolean forceFallback(BulletContext bulletContext) {
        return Intrinsics.areEqual(new BooleanParam(bulletContext.getSchemaModelUnion().getSchemaData(), "force_h5", null).getValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doLoadUri(BulletContext context, Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
        context.getContainerContext().setFirstLoad(BulletEnv.INSTANCE.getInstance().getIsFirstLoad());
        BulletEnv.INSTANCE.getInstance().setFirstLoad(false);
        this.kitType = getKitTypeFromSchema(uri);
        boolean forceFallback = forceFallback(context);
        checkKitServiceInit(this.kitType, context);
        if (this.kitType == KitType.UNKNOWN) {
            BulletLogger.INSTANCE.printCoreLog(context.getSessionId(), "kitView create failed. reason: kitType is unknown. schema:" + uri, "XView", LogLevel.E);
            lifeCycle.onLoadFail(uri, new IllegalStateException("container_error: No type matches the uri " + uri));
            return;
        }
        if (context.getContainerContext().getFallbackInfo() == null) {
            BulletLoadUriIdentifier bulletLoadUriIdentifier = new BulletLoadUriIdentifier(uri);
            bulletLoadUriIdentifier.setSessionId(context.getSessionId());
            context.setUriIdentifier(bulletLoadUriIdentifier);
        }
        getServiceContext().putDependency(Identifier.class, context.getUriIdentifier());
        ContextProviderManager.INSTANCE.getProviderFactory(context.getSessionId()).registerHolder(Identifier.class, context.getUriIdentifier());
        context.getMonitorCallback().recordTimeStamp(MetricConstant.KIT_LOAD_START);
        if (forceFallback || this.kitType == KitType.WEB) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.kitType.ordinal()];
            if (i == 1) {
                doFallBack(context, bundle, uri, this.kitType, new Throwable("fallback because force h5 = 1"), lifeCycle);
                return;
            } else if (i != 2) {
                return;
            } else {
                doLoadWeb(context, uri, lifeCycle);
            }
        }
        if (this.kitType == KitType.LYNX) {
            doLoadLynx(context, uri, bundle, lifeCycle);
        }
    }

    private final void doLoadWeb(BulletContext context, Uri uri, final IBulletLifeCycle lifeCycle) {
        IKitViewService orCreateKitViewService$anniex_release$default = getOrCreateKitViewService$anniex_release$default(this, KitType.WEB, null, 2, null);
        final IWebKitViewService iWebKitViewService = orCreateKitViewService$anniex_release$default instanceof IWebKitViewService ? (IWebKitViewService) orCreateKitViewService$anniex_release$default : null;
        if (iWebKitViewService == null) {
            lifeCycle.onLoadFail(uri, new Throwable("container_error: web kitInstance is null"));
            return;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        iWebKitViewService.loadUri(uri2, new LifeCycleDelegate(lifeCycle) { // from class: com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader$doLoadWeb$1
            @Override // com.bytedance.ies.bullet.core.LifeCycleDelegate, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
            public void onLoadFail(Uri uri3, Throwable e) {
                Intrinsics.checkNotNullParameter(uri3, "uri");
                Intrinsics.checkNotNullParameter(e, "e");
                if (iWebKitViewService.getSccLevel() == SccConfig.SccLevel.SAFE) {
                    iWebKitViewService.destroy(true);
                    super.onLoadFail(uri3, e);
                } else {
                    super.onLoadFail(uri3, e);
                }
            }
        }, context.getSessionId());
    }

    public static /* synthetic */ IKitViewService getOrCreateKitViewService$anniex_release$default(BulletContainerLoader bulletContainerLoader, KitType kitType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return bulletContainerLoader.getOrCreateKitViewService$anniex_release(kitType, str);
    }

    public final IKitViewService getOrCreateKitViewService$anniex_release(KitType kitType, String sessionId) {
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        if (IConditionCallKt.enableAnnieXBulletFallback()) {
            IKitViewService iKitViewService = this.kitViewService;
            if (iKitViewService != null && !this.isFallback) {
                return iKitViewService;
            }
        } else {
            IKitViewService iKitViewService2 = this.kitViewService;
            if (iKitViewService2 != null) {
                return iKitViewService2;
            }
        }
        if (kitType == KitType.LYNX && sessionId != null) {
            ILynxKitService iLynxKitService = (ILynxKitService) getService(ILynxKitService.class);
            this.kitViewService = iLynxKitService != null ? iLynxKitService.createKitViewWithSessionId(sessionId, this) : null;
        } else if (kitType == KitType.WEB) {
            if (sessionId != null) {
                IWebKitService iWebKitService = (IWebKitService) getService(IWebKitService.class);
                if (iWebKitService != null) {
                    r1 = iWebKitService.createKitViewWithSessionId(sessionId, this);
                }
            } else {
                IWebKitService iWebKitService2 = (IWebKitService) getService(IWebKitService.class);
                if (iWebKitService2 != null) {
                    r1 = iWebKitService2.createKitView(this);
                }
            }
            this.kitViewService = r1;
        }
        return this.kitViewService;
    }

    private final void doLoadLynx(final BulletContext context, Uri uri, final Bundle bundle, final IBulletLifeCycle lifeCycle) {
        IKitViewService orCreateKitViewService$anniex_release = getOrCreateKitViewService$anniex_release(KitType.LYNX, context.getSessionId());
        ILynxKitViewService iLynxKitViewService = orCreateKitViewService$anniex_release instanceof ILynxKitViewService ? (ILynxKitViewService) orCreateKitViewService$anniex_release : null;
        if (iLynxKitViewService != null) {
            context.getContainerContext().setSsrConfig((SSRConfig) ContextProviderManager.INSTANCE.getProviderFactory(context.getSessionId()).provideInstance(SSRConfig.class));
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            final ILynxKitViewService iLynxKitViewService2 = iLynxKitViewService;
            iLynxKitViewService.loadUri(uri2, new LifeCycleDelegate(iLynxKitViewService2, this, context, bundle) { // from class: com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader$doLoadLynx$1
                final /* synthetic */ Bundle $bundle;
                final /* synthetic */ BulletContext $context;
                final /* synthetic */ ILynxKitViewService $lynxKitViewService;
                final /* synthetic */ BulletContainerLoader this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(IBulletLifeCycle.this);
                    this.$lynxKitViewService = iLynxKitViewService2;
                    this.this$0 = this;
                    this.$context = context;
                    this.$bundle = bundle;
                }

                @Override // com.bytedance.ies.bullet.core.LifeCycleDelegate, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadFail(Uri uri3, Throwable e) {
                    Intrinsics.checkNotNullParameter(uri3, "uri");
                    Intrinsics.checkNotNullParameter(e, "e");
                    this.$lynxKitViewService.destroy(true);
                    this.this$0.doFallBack(this.$context, this.$bundle, uri3, KitType.LYNX, e, IBulletLifeCycle.this);
                }
            }, context.getSessionId());
            return;
        }
        BulletLogger.INSTANCE.printCoreLog(context.getSessionId(), "kitView create failed. reason: lynx not enable. schema:" + uri, "XView", LogLevel.E);
        doFallBack(context, bundle, uri, KitType.LYNX, new Throwable(KitType.LYNX + " not enable"), lifeCycle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doFallBack(BulletContext context, Bundle bundle, Uri uri, KitType kitType, Throwable e, IBulletLifeCycle lifeCycle) {
        String str;
        Uri fallbackUri = getFallbackUri(context, uri);
        BulletLogger.INSTANCE.printCoreLog(context.getSessionId(), "fallback triggered reason: " + (e != null ? e.getMessage() : null) + ". origin_url:" + uri + ", fallbackUri= " + fallbackUri, "XView", LogLevel.W);
        if (fallbackUri != null) {
            lifeCycleRunFallback(lifeCycle, fallbackUri, new Throwable(kitType + " load failed,message=" + (e != null ? e.getMessage() : null)));
            this.isFallback = true;
            doLoadUri(context, fallbackUri, bundle, lifeCycle);
            SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, context.getSessionId(), fallbackUri.toString(), (String) null, 4, (Object) null);
            return;
        }
        StringBuilder sb = new StringBuilder("container_error: ");
        if (e == null || (str = e.getMessage()) == null) {
            str = "fall back failed";
        }
        lifeCycle.onLoadFail(uri, new Throwable(sb.append(str).toString()));
    }

    private final void lifeCycleRunFallback(IBulletLifeCycle lifeCycle, Uri fallbackUri, Throwable e) {
        lifeCycle.onFallback(fallbackUri, e);
    }

    private final Uri getFallbackUri(BulletContext context, Uri uri) {
        if (getKitTypeFromSchema(uri) == KitType.WEB) {
            return null;
        }
        return new UrlParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_FALLBACK_URL, null).getValue();
    }

    public final void release() {
        this.kitViewService = null;
    }
}
