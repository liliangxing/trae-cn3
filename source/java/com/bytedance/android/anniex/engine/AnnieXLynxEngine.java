package com.bytedance.android.anniex.engine;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import bolts.Task;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.config.LynxEngineConfig;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider;
import com.bytedance.crash.Npth;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestResourceInfo;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.secure.ArgusLynxDelegateAdapter;
import com.bytedance.ies.bullet.secure.SecureProviderFactory;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.ILynxEngine;
import com.lynx.tasm.LynxEngineBuilder;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxUpdateMeta;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnnieXLynxEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020%H\u0016J\r\u00100\u001a\u00020\u0011H\u0000¢\u0006\u0002\b1J\u000f\u00102\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b3J\r\u00104\u001a\u00020\u0005H\u0000¢\u0006\u0002\b5J\u0006\u00106\u001a\u00020\u0015J\r\u00107\u001a\u00020\u0001H\u0000¢\u0006\u0002\b8J\u000f\u00109\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b:J\r\u0010;\u001a\u00020\u001dH\u0000¢\u0006\u0002\b<J\u000f\u0010=\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b>J\u000f\u0010?\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0002\b@J\u0018\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B2\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020IH\u0002J\u0006\u0010J\u001a\u00020\u0017J!\u0010K\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0002\bLJ\u0010\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010Q\u001a\u00020RH\u0002J \u0010S\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010T\u001a\u00020C2\u0006\u0010Q\u001a\u00020RH\u0002J*\u0010U\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010!\u001a\u00020.2\u0006\u0010Q\u001a\u00020RH\u0002J.\u0010X\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010!\u001a\u00020.2\u0006\u0010Q\u001a\u00020RH\u0002J\u0018\u0010Z\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010Q\u001a\u00020RH\u0002J\u000e\u0010[\u001a\u00020%2\u0006\u0010\\\u001a\u00020\u0011J \u0010]\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0003H\u0002J\u0016\u0010_\u001a\u00020%2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020%0aH\u0002J\u0017\u0010b\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u00020%H\u0000¢\u0006\u0002\beJ\u0015\u0010f\u001a\u00020%2\u0006\u0010g\u001a\u00020\u0017H\u0000¢\u0006\u0002\bhJ\u0017\u0010i\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\bjJ\u0017\u0010k\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020%2\b\u0010n\u001a\u0004\u0018\u00010\u0003H\u0002J\u0015\u0010o\u001a\u00020%2\u0006\u0010p\u001a\u00020IH\u0000¢\u0006\u0002\bqJ!\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020s0rH\u0000¢\u0006\u0002\bqJ\u0010\u0010t\u001a\u00020%2\u0006\u0010u\u001a\u00020vH\u0016J\u0018\u0010w\u001a\u00020%2\u0006\u0010x\u001a\u00020\u00112\u0006\u0010y\u001a\u00020\u0011H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "Lcom/lynx/tasm/ILynxEngine;", "bid", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "builder", "Lcom/lynx/tasm/LynxEngineBuilder;", "sessionId", "(Ljava/lang/String;Landroid/content/MutableContextWrapper;Lcom/lynx/tasm/LynxEngineBuilder;Ljava/lang/String;)V", "argusDelegate", "Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "getArgusDelegate$anniex_release", "()Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "argusDelegate$delegate", "Lkotlin/Lazy;", "cacheNumber", "", "config", "Lcom/bytedance/android/anniex/config/LynxEngineConfig;", "expirationTime", "", "hasAttachLynxView", "", "impl", "isColdStart", "lynxBdxBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "lynxEngineClient", "Lcom/bytedance/android/anniex/engine/AnnieXDefaultLynxEngineClient;", "lynxViewProvider", "Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewProvider;", "optimizeFlag", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "beforeLoadTemplate", "", "annieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "annieXCardScene", "Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "completeGlobalPropsForLoad", "resFrom", "Lcom/bytedance/ies/bullet/forest/ForestResourceInfo;", "destroy", "getCacheNumber", "getCacheNumber$anniex_release", "getConfig", "getConfig$anniex_release", "getContextWrapper", "getContextWrapper$anniex_release", "getExpirationTime", "getImpl", "getImpl$anniex_release", "getLynxBdxBridge", "getLynxBdxBridge$anniex_release", "getLynxEngineClient", "getLynxEngineClient$anniex_release", "getLynxViewProvider", "getLynxViewProvider$anniex_release", "getResourceInfo", "getResourceInfo$anniex_release", "getTemplateBundleResponse", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "Lcom/lynx/tasm/TemplateBundle;", "response", "Lcom/bytedance/forest/model/Response;", "initSecureDelegate", "injectGlobalProps", "templateData", "Lcom/lynx/tasm/TemplateData;", "isExpired", "load", "load$anniex_release", "loadTemplate", "metaData", "Lcom/lynx/tasm/LynxLoadMeta;", "loadTemplateWithExternalTemplateArray", "loadMode", "Lcom/lynx/tasm/LynxLoadMode;", "loadTemplateWithExternalTemplateBundle", "templateBundle", "loadTemplateWithInternalTemplateArray", "byteArray", "", "loadTemplateWithInternalTemplateBundle", "templateBundleResponse", "loadTemplateWithUrl", "markOptimizeFlag", "flag", "onLoadFail", "errorMessage", "runOnUiThread", StrategyConstants.ACTION, "Lkotlin/Function0;", "setConfig", "setConfig$anniex_release", "setExpirationTimeAndCacheNumber", "setExpirationTimeAndCacheNumber$anniex_release", "setHasAttachLynxView", "AttachLynxView", "setHasAttachLynxView$anniex_release", "setLynxBdxBridge", "setLynxBdxBridge$anniex_release", "setLynxViewProvider", "setLynxViewProvider$anniex_release", "setNpthLastUrl", StreamTrafficObservable.STREAM_URL, "updateGlobalProps", "props", "updateGlobalProps$anniex_release", "", "", "updateMetaData", "meta", "Lcom/lynx/tasm/LynxUpdateMeta;", "updateViewport", "widthMeasureSpec", "heightMeasureSpec", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEngine implements ILynxEngine {

    /* renamed from: argusDelegate$delegate, reason: from kotlin metadata */
    private final Lazy argusDelegate;
    private int cacheNumber;
    private LynxEngineConfig config;
    private final MutableContextWrapper contextWrapper;
    private long expirationTime;
    private boolean hasAttachLynxView;
    private final ILynxEngine impl;
    private boolean isColdStart;
    private LynxBDXBridge lynxBdxBridge;
    private AnnieXDefaultLynxEngineClient lynxEngineClient;
    private LynxViewProvider lynxViewProvider;
    private int optimizeFlag;
    private ResourceInfo resourceInfo;
    private long timestamp;

    public AnnieXLynxEngine(String str, MutableContextWrapper mutableContextWrapper, LynxEngineBuilder lynxEngineBuilder, String str2) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(mutableContextWrapper, "contextWrapper");
        Intrinsics.checkNotNullParameter(lynxEngineBuilder, "builder");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        this.contextWrapper = mutableContextWrapper;
        this.timestamp = System.currentTimeMillis();
        this.cacheNumber = 5;
        this.expirationTime = 15000L;
        this.argusDelegate = LazyKt.lazy(new Function0<ArgusLynxDelegateAdapter>() { // from class: com.bytedance.android.anniex.engine.AnnieXLynxEngine$argusDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ArgusLynxDelegateAdapter m3336invoke() {
                ArgusLynxDelegateAdapter initSecureDelegate;
                initSecureDelegate = AnnieXLynxEngine.this.initSecureDelegate();
                return initSecureDelegate;
            }
        });
        LynxTemplateRender build = lynxEngineBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        this.impl = build;
        AnnieXDefaultLynxEngineClient annieXDefaultLynxEngineClient = new AnnieXDefaultLynxEngineClient(str, str2);
        this.lynxEngineClient = annieXDefaultLynxEngineClient;
        annieXDefaultLynxEngineClient.setEnableSticky(true);
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type com.lynx.tasm.LynxTemplateRender");
        build.addLynxViewClient(this.lynxEngineClient);
    }

    public final ArgusLynxDelegateAdapter getArgusDelegate$anniex_release() {
        return (ArgusLynxDelegateAdapter) this.argusDelegate.getValue();
    }

    public final void setExpirationTimeAndCacheNumber$anniex_release() {
        Long expireMs;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        CommonConfig commonConfig = iBulletSettingsService != null ? (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class) : null;
        LynxEngineConfig lynxEngineConfig = this.config;
        long lynxEngineExpireTime = (lynxEngineConfig == null || (expireMs = lynxEngineConfig.getExpireMs()) == null) ? commonConfig != null ? commonConfig.getLynxEngineExpireTime() : 15000L : expireMs.longValue();
        this.expirationTime = lynxEngineExpireTime;
        if (lynxEngineExpireTime < 0 || lynxEngineExpireTime > 300000) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXLynxEngine", "expireTime is invalid, use default value 15000", (Map) null, (LoggerContext) null, 12, (Object) null);
            this.expirationTime = 15000L;
        }
        int lynxEngineCacheNumber = commonConfig != null ? commonConfig.getLynxEngineCacheNumber() : 5;
        this.cacheNumber = lynxEngineCacheNumber;
        if (lynxEngineCacheNumber < 0 || lynxEngineCacheNumber > 50) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieXLynxEngine", "cacheNumber is invalid, use default value 5", (Map) null, (LoggerContext) null, 12, (Object) null);
            this.cacheNumber = 5;
        }
    }

    /* renamed from: getImpl$anniex_release, reason: from getter */
    public final ILynxEngine getImpl() {
        return this.impl;
    }

    /* renamed from: getCacheNumber$anniex_release, reason: from getter */
    public final int getCacheNumber() {
        return this.cacheNumber;
    }

    public final void setLynxBdxBridge$anniex_release(LynxBDXBridge lynxBdxBridge) {
        this.lynxBdxBridge = lynxBdxBridge;
    }

    /* renamed from: getLynxBdxBridge$anniex_release, reason: from getter */
    public final LynxBDXBridge getLynxBdxBridge() {
        return this.lynxBdxBridge;
    }

    public final void setLynxViewProvider$anniex_release(LynxViewProvider lynxViewProvider) {
        this.lynxViewProvider = lynxViewProvider;
    }

    /* renamed from: getLynxViewProvider$anniex_release, reason: from getter */
    public final LynxViewProvider getLynxViewProvider() {
        return this.lynxViewProvider;
    }

    public final void setConfig$anniex_release(LynxEngineConfig config) {
        this.config = config;
    }

    /* renamed from: getConfig$anniex_release, reason: from getter */
    public final LynxEngineConfig getConfig() {
        return this.config;
    }

    /* renamed from: getContextWrapper$anniex_release, reason: from getter */
    public final MutableContextWrapper getContextWrapper() {
        return this.contextWrapper;
    }

    public final void setHasAttachLynxView$anniex_release(boolean AttachLynxView) {
        this.hasAttachLynxView = AttachLynxView;
    }

    /* renamed from: getLynxEngineClient$anniex_release, reason: from getter */
    public final AnnieXDefaultLynxEngineClient getLynxEngineClient() {
        return this.lynxEngineClient;
    }

    public final boolean isExpired() {
        return this.expirationTime > 0 && System.currentTimeMillis() - this.timestamp > this.expirationTime;
    }

    public final long getExpirationTime() {
        return this.expirationTime;
    }

    /* renamed from: getResourceInfo$anniex_release, reason: from getter */
    public final ResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public void loadTemplate(LynxLoadMeta metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        this.impl.loadTemplate(metaData);
    }

    public void updateMetaData(LynxUpdateMeta meta) {
        Intrinsics.checkNotNullParameter(meta, "meta");
        this.impl.updateMetaData(meta);
    }

    public void updateViewport(int widthMeasureSpec, int heightMeasureSpec) {
        this.impl.updateViewport(widthMeasureSpec, heightMeasureSpec);
    }

    public void destroy() {
        ArgusLynxDelegateAdapter argusDelegate$anniex_release = getArgusDelegate$anniex_release();
        if (argusDelegate$anniex_release != null) {
            argusDelegate$anniex_release.onViewDestroy();
        }
        this.impl.destroy();
    }

    public static /* synthetic */ void load$anniex_release$default(AnnieXLynxEngine annieXLynxEngine, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        annieXLynxEngine.load$anniex_release(annieXLynxModel, contextProviderFactory);
    }

    static /* synthetic */ void beforeLoadTemplate$default(AnnieXLynxEngine annieXLynxEngine, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, AnnieXCardScene annieXCardScene, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            annieXCardScene = AnnieXCardScene.NEW;
        }
        annieXLynxEngine.beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXCardScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void beforeLoadTemplate(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, AnnieXCardScene annieXCardScene) {
        MonitorManager.INSTANCE.onLoadStart(annieXLynxModel.getSessionId(), annieXCardScene);
        this.lynxEngineClient.onLoadStart(annieXLynxModel.getOriginalUri());
    }

    static /* synthetic */ void completeGlobalPropsForLoad$default(AnnieXLynxEngine annieXLynxEngine, AnnieXLynxModel annieXLynxModel, String str, ForestResourceInfo forestResourceInfo, int i, Object obj) {
        if ((i & 4) != 0) {
            forestResourceInfo = null;
        }
        annieXLynxEngine.completeGlobalPropsForLoad(annieXLynxModel, str, forestResourceInfo);
    }

    private final void completeGlobalPropsForLoad(AnnieXLynxModel annieXLynxModel, String resFrom, ForestResourceInfo resourceInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("res_from", resFrom);
        if (resourceInfo != null) {
            linkedHashMap.put("geckoId", String.valueOf(resourceInfo.getVersion()));
            linkedHashMap.put("geckoChannel", resourceInfo.getChannel());
        }
        TemplateData globalProps = annieXLynxModel.getGlobalProps();
        if (globalProps != null) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                globalProps.put((String) entry.getKey(), entry.getValue());
            }
            Map<String, Object> pageGlobalPropsByActivity = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(this.contextWrapper);
            if (pageGlobalPropsByActivity != null) {
                for (Map.Entry<String, Object> entry2 : pageGlobalPropsByActivity.entrySet()) {
                    globalProps.put(entry2.getKey(), entry2.getValue());
                }
            }
            injectGlobalProps(globalProps);
            globalProps.markConcurrent();
            updateGlobalProps$anniex_release(globalProps);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTemplateWithExternalTemplateBundle(AnnieXLynxModel annieXLynxModel, TemplateBundle templateBundle, LynxLoadMode loadMode) {
        MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
        MonitorManager.INSTANCE.onPrepareTemplateEnd(annieXLynxModel.getSessionId());
        MonitorManager.INSTANCE.onLynxReadTemplateBegin(annieXLynxModel.getSessionId());
        this.lynxEngineClient.onTemplateReady("externalTemplateBundle", true);
        MonitorManager.INSTANCE.onLynxReadTemplateEnd(annieXLynxModel.getSessionId(), null, (r17 & 4) != 0 ? "userInput" : "externalTemplateBundle", (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
        setNpthLastUrl(annieXLynxModel.getUrl());
        if (!annieXLynxModel.isCompactMode()) {
            completeGlobalPropsForLoad$default(this, annieXLynxModel, "externalTemplateBundle", null, 4, null);
        }
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(annieXLynxModel.getUrl());
        builder.setInitialData(annieXLynxModel.getTemplateData());
        builder.setTemplateBundle(templateBundle);
        builder.setLoadMode(loadMode);
        builder.addLoadOption(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        if (!this.hasAttachLynxView) {
            builder.addLoadOption(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
        }
        LynxLoadMeta build = builder.build();
        MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
        Intrinsics.checkNotNullExpressionValue(build, "loadMeta");
        loadTemplate(build);
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTemplateWithExternalTemplateArray(AnnieXLynxModel annieXLynxModel, LynxLoadMode loadMode) {
        if (annieXLynxModel.getTemplate() != null) {
            if (!(annieXLynxModel.getTemplate().getTemplateJS().length == 0)) {
                MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onPrepareTemplateEnd(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onLynxReadTemplateBegin(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onLynxReadTemplateEnd(annieXLynxModel.getSessionId(), null, (r17 & 4) != 0 ? "userInput" : "custom", (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
                setNpthLastUrl(annieXLynxModel.getUrl());
                this.lynxEngineClient.onTemplateReady("custom", true);
                if (!annieXLynxModel.isCompactMode()) {
                    completeGlobalPropsForLoad$default(this, annieXLynxModel, "custom", null, 4, null);
                }
                LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
                builder.setUrl(annieXLynxModel.getUrl());
                builder.setBinaryData(annieXLynxModel.getTemplate().getTemplateJS());
                builder.setInitialData(annieXLynxModel.getTemplateData());
                builder.setLoadMode(loadMode);
                builder.addLoadOption(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
                if (!this.hasAttachLynxView) {
                    builder.addLoadOption(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
                }
                LynxLoadMeta build = builder.build();
                MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
                Intrinsics.checkNotNullExpressionValue(build, "loadMeta");
                loadTemplate(build);
                MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        if (!(response instanceof ProcessedResponse)) {
            return null;
        }
        ProcessedResponse<TemplateBundle> processedResponse = (ProcessedResponse) response;
        if (!processedResponse.isProcessSucceed() || processedResponse.provideProcessedData() == null) {
            return null;
        }
        return processedResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTemplateWithInternalTemplateBundle(AnnieXLynxModel annieXLynxModel, ProcessedResponse<TemplateBundle> templateBundleResponse, ForestResourceInfo resourceInfo, LynxLoadMode loadMode) {
        String url = annieXLynxModel.getUrl();
        setNpthLastUrl(annieXLynxModel.getUrl());
        completeGlobalPropsForLoad(annieXLynxModel, "internalTemplateBundle", resourceInfo);
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(url);
        builder.setTemplateBundle((TemplateBundle) templateBundleResponse.provideProcessedData());
        builder.setInitialData(annieXLynxModel.getTemplateData());
        builder.setLoadMode(loadMode);
        builder.addLoadOption(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        if (!this.hasAttachLynxView) {
            builder.addLoadOption(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
        }
        LynxLoadMeta build = builder.build();
        MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
        Intrinsics.checkNotNullExpressionValue(build, "loadMeta");
        loadTemplate(build);
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTemplateWithInternalTemplateArray(AnnieXLynxModel annieXLynxModel, byte[] byteArray, ForestResourceInfo resourceInfo, LynxLoadMode loadMode) {
        String filePath;
        if (byteArray == null) {
            onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), "byte array is null. url: " + annieXLynxModel.getOriginalUri());
            return;
        }
        if (resourceInfo.getFrom() == ResourceFrom.CDN) {
            filePath = annieXLynxModel.getUrl();
        } else {
            filePath = resourceInfo.getFilePath();
            if (filePath == null) {
                filePath = annieXLynxModel.getUrl();
            }
        }
        setNpthLastUrl(annieXLynxModel.getUrl());
        ArgusLynxDelegateAdapter argusDelegate$anniex_release = getArgusDelegate$anniex_release();
        if (argusDelegate$anniex_release != null) {
            argusDelegate$anniex_release.onLoadTemplate((ResourceInfo) resourceInfo, true, "AnnieXLynxEngine");
        }
        completeGlobalPropsForLoad(annieXLynxModel, resourceInfo.getStatisticFrom(), resourceInfo);
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(filePath);
        builder.setBinaryData(byteArray);
        builder.setInitialData(annieXLynxModel.getTemplateData());
        builder.setLoadMode(loadMode);
        builder.addLoadOption(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        if (!this.hasAttachLynxView) {
            builder.addLoadOption(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
        }
        LynxLoadMeta build = builder.build();
        MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
        Intrinsics.checkNotNullExpressionValue(build, "loadMeta");
        loadTemplate(build);
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    private final void runOnUiThread(final Function0<Unit> action) {
        if (IConditionCallKt.enableLoadFailedOnUIThread() && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Task.call(new Callable() { // from class: com.bytedance.android.anniex.engine.AnnieXLynxEngine$runOnUiThread$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    action.invoke();
                }
            }, Task.UI_THREAD_EXECUTOR);
        } else {
            action.invoke();
        }
    }

    public final void markOptimizeFlag(int flag) {
        this.optimizeFlag = flag | this.optimizeFlag;
    }

    private final void injectGlobalProps(TemplateData templateData) {
        int i = this.optimizeFlag;
        boolean z = (i & 1) > 0;
        boolean z2 = (i & 2) > 0;
        templateData.put("isColdStart", Boolean.valueOf(this.isColdStart));
        templateData.put("isPreCreate", Boolean.valueOf(z));
        templateData.put("isAsyncLayout", Boolean.valueOf(z2));
        templateData.put("isFromEngine", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArgusLynxDelegateAdapter initSecureDelegate() {
        return ArgusLynxDelegateAdapter.Companion.build((SecureProviderFactory) null, (LynxView) null);
    }

    public final void updateGlobalProps$anniex_release(TemplateData props) {
        Intrinsics.checkNotNullParameter(props, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        try {
            this.impl.updateMetaData(new LynxUpdateMeta.Builder().setUpdatedGlobalProps(props).build());
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("LynxView:updateGlobalProps");
        }
    }

    public final void updateGlobalProps$anniex_release(Map<String, ? extends Object> props) {
        Intrinsics.checkNotNullParameter(props, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        try {
            this.impl.updateMetaData(new LynxUpdateMeta.Builder().setUpdatedGlobalProps(TemplateData.fromMap(props)).build());
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("LynxView:updateGlobalProps");
        }
    }

    public final void load$anniex_release(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory) {
        LynxLoadMode lynxLoadMode;
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxEngine:load");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d("LynxEngine: ", "load: " + this);
            }
            if (DefaultLynxDelegate.Companion.getGlobalColdStart()) {
                this.isColdStart = true;
                DefaultLynxDelegate.Companion.setGlobalColdStart(false);
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, AnnieXCardScene.NEW);
            TemplateBundle templateBundle = contextProviderFactory != null ? (TemplateBundle) contextProviderFactory.provideInstance(TemplateBundle.class) : null;
            if (contextProviderFactory == null || (lynxLoadMode = (LynxLoadMode) contextProviderFactory.provideInstance(LynxLoadMode.class)) == null) {
                lynxLoadMode = LynxLoadMode.NORMAL;
            }
            if (templateBundle != null) {
                loadTemplateWithExternalTemplateBundle(annieXLynxModel, templateBundle, lynxLoadMode);
            } else {
                if (annieXLynxModel.getTemplate() != null) {
                    if (!(annieXLynxModel.getTemplate().getTemplateJS().length == 0)) {
                        loadTemplateWithExternalTemplateArray(annieXLynxModel, lynxLoadMode);
                    }
                }
                loadTemplateWithUrl(annieXLynxModel, lynxLoadMode);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxEngine:load");
        }
    }

    private final void setNpthLastUrl(String url) {
        String str;
        List split$default;
        TraceEvent.beginSection("AnnieXLynxEngine:setNpthLastUrl");
        try {
            Result.Companion companion = Result.Companion;
            HashMap hashMap = new HashMap();
            if (url == null || (split$default = StringsKt.split$default(url, new String[]{"?"}, false, 0, 6, (Object) null)) == null || (str = (String) split$default.get(0)) == null) {
                str = "";
            }
            hashMap.put("last_lynx_url", str);
            String lynxVersion = LynxEnv.inst().getLynxVersion();
            Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
            hashMap.put("lynx_sdk_version", lynxVersion);
            Npth.addTags(hashMap);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        } finally {
        }
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTemplateWithUrl(final AnnieXLynxModel annieXLynxModel, final LynxLoadMode loadMode) {
        boolean booleanQueryParameter;
        Integer num;
        TraceEvent.beginSection("AnnieXLynxEngine:loadTemplateWithUrl");
        try {
            Log.d("LynxEngine", "==========onPrepareTemplateBegin========");
            MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
            booleanQueryParameter = annieXLynxModel.getOriginalUri().getBooleanQueryParameter("enable_lynx_predecode", false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Function1<Response, Unit> function1 = new Function1<Response, Unit>() { // from class: com.bytedance.android.anniex.engine.AnnieXLynxEngine$loadTemplateWithUrl$1$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Response response) {
                    ProcessedResponse templateBundleResponse;
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSucceed()) {
                        Log.d("LynxEngine", "==========onPrepareTemplateEnd========");
                        MonitorManager.INSTANCE.onPrepareTemplateEnd(AnnieXLynxModel.this.getSessionId());
                        MonitorManager.INSTANCE.onLynxReadTemplateBegin(AnnieXLynxModel.this.getSessionId());
                        templateBundleResponse = this.getTemplateBundleResponse(response);
                        ResourceInfo forestResourceInfo = new ForestResourceInfo(Uri.parse(AnnieXLynxModel.this.getUrl()), response);
                        ResourceInfo resourceInfo = forestResourceInfo;
                        this.resourceInfo = resourceInfo;
                        this.lynxEngineClient.lynxViewMonitorAddContext("geckoId", String.valueOf(forestResourceInfo.getVersion()));
                        this.lynxEngineClient.lynxViewMonitorAddContext("channel", forestResourceInfo.getChannel());
                        if (templateBundleResponse != null) {
                            this.lynxEngineClient.onTemplateReady("internalTemplateBundle", forestResourceInfo.isFromMemory());
                            MonitorManager.INSTANCE.onLynxReadTemplateEnd(AnnieXLynxModel.this.getSessionId(), null, "internalTemplateBundle", forestResourceInfo.getVersion(), templateBundleResponse.processedDataSize());
                            this.loadTemplateWithInternalTemplateBundle(AnnieXLynxModel.this, templateBundleResponse, forestResourceInfo, loadMode);
                            return;
                        } else {
                            byte[] provideByteArray = forestResourceInfo.provideByteArray();
                            this.lynxEngineClient.onTemplateReady(forestResourceInfo.getStatisticFrom(), forestResourceInfo.isFromMemory());
                            MonitorManager.INSTANCE.onLynxReadTemplateEnd(AnnieXLynxModel.this.getSessionId(), resourceInfo, (r17 & 4) != 0 ? "userInput" : null, (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
                            this.loadTemplateWithInternalTemplateArray(AnnieXLynxModel.this, provideByteArray, forestResourceInfo, loadMode);
                            return;
                        }
                    }
                    this.onLoadFail(AnnieXLynxModel.this.getBid(), AnnieXLynxModel.this.getSessionId(), "Failed to load template. url: " + AnnieXLynxModel.this.getOriginalUri() + ", error message: " + response.getErrorInfo());
                }
            };
            Integer num2 = null;
            if (!booleanQueryParameter) {
                Log.d("LynxEngine", "==========ForestLoader.loadAsync========");
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                String uri = annieXLynxModel.getOriginalUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "annieXLynxModel.originalUri.toString()");
                Scene scene = Scene.LYNX_TEMPLATE;
                String sessionId = annieXLynxModel.getSessionId();
                TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                String queryParameter = annieXLynxModel.getOriginalUri().getQueryParameter("dynamic");
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(\"dynamic\")");
                    num2 = StringsKt.toIntOrNull(queryParameter);
                }
                taskConfig.setDynamic(num2);
                Unit unit = Unit.INSTANCE;
                ForestLoader.loadAsync$default(forestLoader, (Forest) null, uri, (String) null, scene, sessionId, taskConfig, false, (Function1) null, function1, 197, (Object) null);
            } else {
                if (!TraceEvent.enableTrace()) {
                    Log.d("LynxEngine", "==========loadAsyncWithProcessor========");
                }
                ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                String uri2 = annieXLynxModel.getOriginalUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "annieXLynxModel.originalUri.toString()");
                Scene scene2 = Scene.LYNX_TEMPLATE;
                String sessionId2 = annieXLynxModel.getSessionId();
                TaskConfig taskConfig2 = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                String queryParameter2 = annieXLynxModel.getOriginalUri().getQueryParameter("dynamic");
                if (queryParameter2 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter2, "getQueryParameter(\"dynamic\")");
                    num = StringsKt.toIntOrNull(queryParameter2);
                } else {
                    num = null;
                }
                taskConfig2.setDynamic(num);
                Unit unit2 = Unit.INSTANCE;
                ForestLoader.loadAsyncWithProcessor$default(forestLoader2, (Forest) null, uri2, (String) null, scene2, sessionId2, taskConfig2, false, new TemplateBundleProcessor((String) null, false, 3, (DefaultConstructorMarker) null), (Function1) null, function1, 325, (Object) null);
            }
            Unit unit3 = Unit.INSTANCE;
            TraceEvent.endSection("AnnieXLynxEngine:loadTemplateWithUrl");
        } catch (Throwable th2) {
            th = th2;
            TraceEvent.endSection("AnnieXLynxEngine:loadTemplateWithUrl");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadFail(String bid, String sessionId, String errorMessage) {
        TraceEvent.beginSection("AnnieXLynxEngine:onLoadFail");
        try {
            this.lynxEngineClient.onEngineLoadFailed(errorMessage);
            HybridLogger.e$default(HybridLogger.INSTANCE, "XResourceLoader", errorMessage, (Map) null, (LoggerContext) null, 12, (Object) null);
            MonitorManager.INSTANCE.onLoadFail(bid, sessionId, AbsBulletMonitorCallback.ErrStage.RL, errorMessage, (LynxView) null);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxEngine:onLoadFail");
        }
    }
}
