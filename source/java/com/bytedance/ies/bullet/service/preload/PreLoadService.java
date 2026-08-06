package com.bytedance.ies.bullet.service.preload;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import bolts.Task;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.RLReportController;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPreLoadService;
import com.bytedance.ies.bullet.service.base.IPreLoadServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.PreDownloadConfig;
import com.bytedance.ies.bullet.service.base.PreLoadResult;
import com.bytedance.ies.bullet.service.base.PreloadConfig;
import com.bytedance.ies.bullet.service.base.PreloadFontConfig;
import com.bytedance.ies.bullet.service.base.PreloadGeckoChannelConfig;
import com.bytedance.ies.bullet.service.base.PreloadImageConfig;
import com.bytedance.ies.bullet.service.base.PreloadJsConfig;
import com.bytedance.ies.bullet.service.base.PreloadResourceInfo;
import com.bytedance.ies.bullet.service.base.PreloadSourceType;
import com.bytedance.ies.bullet.service.base.PreloadStrategy;
import com.bytedance.ies.bullet.service.base.PreloadVideoConfig;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.ResourceFileType;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.SessionInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.preload.PreloadMemoryCache;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.rts.foundation.Int32;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.ss.ttvideoengine.TTVideoEngine;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: PreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 b2\u00020\u0001:\u0001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dH\u0002J$\u0010 \u001a\u00020!\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00020\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0%H\u0002J\u0012\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020*H\u0002J\u001c\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020*H\u0016J\u0012\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J'\u00100\u001a\u0004\u0018\u0001H1\"\b\b\u0000\u00101*\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H104H\u0002¢\u0006\u0002\u00105J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0016Jb\u00108\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2>\u00109\u001a:\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020!\u0018\u00010:j\u0004\u0018\u0001`@H\u0016JX\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020D2>\u00109\u001a:\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020!\u0018\u00010:j\u0004\u0018\u0001`@H\u0016JX\u0010A\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010C\u001a\u00020D2>\u00109\u001a:\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020!\u0018\u00010:j\u0004\u0018\u0001`@H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020LH\u0002J\u0018\u0010M\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010N\u001a\u00020DH\u0002J\u0010\u0010O\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020PH\u0002J\u0016\u0010Q\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010C\u001a\u00020DJ\u0010\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020\u0005H\u0002J\u0010\u0010T\u001a\u00020!2\u0006\u0010S\u001a\u00020\u0005H\u0002J$\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020\u00052\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0002J\u0018\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0016J,\u0010\\\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u00052\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dH\u0002J\u001a\u0010^\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020*H\u0002J\u0010\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u00020aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/PreLoadService;", "Lcom/bytedance/ies/bullet/service/base/IPreLoadService;", "application", "Landroid/app/Application;", "bid", "", "(Landroid/app/Application;Ljava/lang/String;)V", "getApplication", "()Landroid/app/Application;", "getBid", "()Ljava/lang/String;", "bulletSettings", "Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "mCache", "Lcom/bytedance/ies/bullet/service/preload/PreloadMemoryCache;", "mInitSuccess", "", "mLock", "Ljava/lang/Object;", "mPreloadConfigs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/service/base/PreloadConfig;", "mSerialExecutorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "mUrlMap", "downloadCDN", "config", "Lcom/bytedance/ies/bullet/service/base/PreDownloadConfig;", "resourceInfoList", "", "Lcom/bytedance/ies/bullet/service/base/PreloadResourceInfo;", "downloadGecko", "executeWithService", "", "TResult", "serial", "action", "Lkotlin/Function0;", "forceClean", "schema", "frescoHasBeenInitialized", "generateMaxCacheSize", "", "getCache", "", "url", "type", "getChannelFromSchema", "getService", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "initWithConfig", "onLowMemory", "preDownloadResource", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/PreLoadResult;", "code", "Lcom/bytedance/ies/bullet/service/base/PreLoadCallBack;", ResourceInfo.RESOURCE_FROM_PRELOAD, "preloadConfig", "preloadStrategy", "Lcom/bytedance/ies/bullet/service/base/PreloadStrategy;", "preloadChannel", "Lcom/bytedance/ies/bullet/service/base/PreloadGeckoChannelConfig;", "preloadFont", "Lcom/bytedance/ies/bullet/service/base/PreloadFontConfig;", "preloadImage", "Lcom/bytedance/ies/bullet/service/base/PreloadImageConfig;", "preloadJs", "Lcom/bytedance/ies/bullet/service/base/PreloadJsConfig;", "preloadTemplate", "strategy", "preloadVideo", "Lcom/bytedance/ies/bullet/service/base/PreloadVideoConfig;", "preloadWithConfig", "printError", "msg", "printInfo", "printLog", "message", "logLevel", "Lcom/bytedance/ies/bullet/service/base/api/LogLevel;", "subModule", "putUrl", "redirectUrl", "realLoadChannel", "geckoChannel", "reportHitPreloadCache", "requireLowQuality", "uri", "Landroid/net/Uri;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreLoadService implements IPreLoadService {
    private static final String KEY_QUALITY = "quality";

    /* renamed from: MB */
    private static final int f16MB = 1048576;
    private static final String TAG = "PreLoadService";
    private static final String VAL_QUALITY_LOW = "0";
    private final Application application;
    private final String bid;
    private BulletSettings bulletSettings;
    private PreloadMemoryCache mCache;
    private volatile boolean mInitSuccess;
    private final Object mLock;
    private final ConcurrentHashMap<String, PreloadConfig> mPreloadConfigs;
    private final ThreadPoolExecutor mSerialExecutorService;
    private ConcurrentHashMap<String, String> mUrlMap;

    public PreLoadService(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(str, "bid");
        this.application = application;
        this.bid = str;
        this.mPreloadConfigs = new ConcurrentHashMap<>();
        this.mLock = new Object();
        this.mUrlMap = new ConcurrentHashMap<>();
        this.mSerialExecutorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        application.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                PreLoadService.this.onLowMemory();
            }
        });
        initWithConfig();
    }

    public /* synthetic */ PreLoadService(Application application, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? "default_bid" : str);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getBid() {
        return this.bid;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void preDownloadResource(final PreDownloadConfig config, final List<PreloadResourceInfo> resourceInfoList, final Function2<? super Boolean, ? super PreLoadResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!this.mInitSuccess) {
            initWithConfig();
        }
        if (this.bulletSettings == null) {
            ISettingService iSettingService = (ISettingService) getService(ISettingService.class);
            this.bulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        }
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preDownloadResource$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                Object obj;
                Unit unit;
                obj = PreLoadService.this.mLock;
                PreDownloadConfig preDownloadConfig = config;
                PreLoadService preLoadService = PreLoadService.this;
                List<PreloadResourceInfo> list = resourceInfoList;
                Function2<Boolean, PreLoadResult, Unit> function2 = callback;
                synchronized (obj) {
                    boolean downloadGecko = preDownloadConfig.getLoaderType() == PreloadSourceType.GECKO ? preLoadService.downloadGecko(preDownloadConfig, list) : preLoadService.downloadCDN(preDownloadConfig, list);
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(downloadGecko), downloadGecko ? PreLoadResult.SUCCESS : PreLoadResult.ERR_MISS_CONFIG);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
                return unit;
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    private final void initWithConfig() {
        if (this.mInitSuccess) {
            printError("preload config init success");
        } else {
            this.mInitSuccess = true;
            PreloadConfigsExecutor.INSTANCE.execute(new Runnable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$initWithConfig$1
                /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x00c5, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0020, B:11:0x002c, B:12:0x0034, B:14:0x003a, B:17:0x0051, B:20:0x0057, B:23:0x0061, B:30:0x007c, B:31:0x009e, B:37:0x0098), top: B:3:0x000d }] */
                /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[Catch: all -> 0x00c5, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0020, B:11:0x002c, B:12:0x0034, B:14:0x003a, B:17:0x0051, B:20:0x0057, B:23:0x0061, B:30:0x007c, B:31:0x009e, B:37:0x0098), top: B:3:0x000d }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    Object obj;
                    boolean z;
                    ConcurrentHashMap concurrentHashMap;
                    long currentTimeMillis = System.currentTimeMillis();
                    obj = PreLoadService.this.mLock;
                    PreLoadService preLoadService = PreLoadService.this;
                    synchronized (obj) {
                        Map<String, String> preloadConfigs = ResourceLoader.with$default(ResourceLoader.INSTANCE, preLoadService.getBid(), null, 2, null).getPreloadConfigs();
                        if (preloadConfigs != null && !preloadConfigs.isEmpty()) {
                            z = false;
                            if (!z) {
                                preLoadService.printError("no configs from gecko");
                            } else {
                                for (Map.Entry<String, String> entry : preloadConfigs.entrySet()) {
                                    File file = new File(entry.getValue());
                                    if (file.exists() && file.canRead() && file.length() > 0) {
                                        JSONObject jSONObject = new JSONObject(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                                        concurrentHashMap = preLoadService.mPreloadConfigs;
                                        concurrentHashMap.put(entry.getKey(), IPreLoadServiceKt.toPreloadConfig(jSONObject));
                                    }
                                }
                                preLoadService.printInfo("read preload config success: size: " + preloadConfigs.size());
                            }
                            RLReportController.INSTANCE.initRLConfig(preLoadService.getBid());
                            Unit unit = Unit.INSTANCE;
                        }
                        z = true;
                        if (!z) {
                        }
                        RLReportController.INSTANCE.initRLConfig(preLoadService.getBid());
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Log.d("OptPreloadConfigs", "preload config cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void preload(final String schema, final PreloadStrategy preloadStrategy, final Function2<? super Boolean, ? super PreLoadResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(preloadStrategy, "preloadStrategy");
        if (!this.mInitSuccess) {
            initWithConfig();
        }
        if (this.bulletSettings == null) {
            ISettingService iSettingService = (ISettingService) getService(ISettingService.class);
            this.bulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        }
        if (this.mCache == null) {
            this.mCache = new PreloadMemoryCache(generateMaxCacheSize());
        }
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preload$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0077 A[Catch: all -> 0x0169, TryCatch #0 {, blocks: (B:4:0x0012, B:6:0x0039, B:9:0x004b, B:11:0x0052, B:12:0x0058, B:14:0x005e, B:20:0x006c, B:21:0x0165, B:26:0x0077, B:28:0x008c, B:33:0x0098, B:35:0x00a0, B:36:0x00ab, B:38:0x00b1, B:39:0x00b4, B:41:0x00cf, B:42:0x00d8, B:45:0x00e0, B:46:0x00eb, B:48:0x00f9, B:50:0x0109, B:52:0x010e, B:54:0x0114, B:55:0x011a, B:57:0x0120, B:60:0x0130, B:65:0x0134, B:67:0x013c, B:68:0x0146, B:70:0x015c), top: B:3:0x0012 }] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[Catch: all -> 0x0169, TryCatch #0 {, blocks: (B:4:0x0012, B:6:0x0039, B:9:0x004b, B:11:0x0052, B:12:0x0058, B:14:0x005e, B:20:0x006c, B:21:0x0165, B:26:0x0077, B:28:0x008c, B:33:0x0098, B:35:0x00a0, B:36:0x00ab, B:38:0x00b1, B:39:0x00b4, B:41:0x00cf, B:42:0x00d8, B:45:0x00e0, B:46:0x00eb, B:48:0x00f9, B:50:0x0109, B:52:0x010e, B:54:0x0114, B:55:0x011a, B:57:0x0120, B:60:0x0130, B:65:0x0134, B:67:0x013c, B:68:0x0146, B:70:0x015c), top: B:3:0x0012 }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x0169, TryCatch #0 {, blocks: (B:4:0x0012, B:6:0x0039, B:9:0x004b, B:11:0x0052, B:12:0x0058, B:14:0x005e, B:20:0x006c, B:21:0x0165, B:26:0x0077, B:28:0x008c, B:33:0x0098, B:35:0x00a0, B:36:0x00ab, B:38:0x00b1, B:39:0x00b4, B:41:0x00cf, B:42:0x00d8, B:45:0x00e0, B:46:0x00eb, B:48:0x00f9, B:50:0x0109, B:52:0x010e, B:54:0x0114, B:55:0x011a, B:57:0x0120, B:60:0x0130, B:65:0x0134, B:67:0x013c, B:68:0x0146, B:70:0x015c), top: B:3:0x0012 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void call() {
                Object obj;
                boolean z;
                ConcurrentHashMap concurrentHashMap;
                boolean z2;
                PreloadMemoryCache preloadMemoryCache;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                List<PreloadJsConfig> js;
                obj = PreLoadService.this.mLock;
                PreLoadService preLoadService = PreLoadService.this;
                String str = schema;
                Function2<Boolean, PreLoadResult, Unit> function2 = callback;
                PreloadStrategy preloadStrategy2 = preloadStrategy;
                synchronized (obj) {
                    SchemaService companion = SchemaService.INSTANCE.getInstance();
                    String bid = preLoadService.getBid();
                    Uri parse = Uri.parse(str);
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(schema)");
                    ISchemaData generateSchemaData = companion.generateSchemaData(bid, parse);
                    String str2 = generateSchemaData.getQueryItems().get("url");
                    if (str2 == null && (str2 = generateSchemaData.getQueryItems().get(SchemaConstants.QUERY_KEY_SURL)) == null) {
                        str2 = "";
                    }
                    Uri parse2 = Uri.parse(str2);
                    String uri = parse2 != null ? parse2.toString() : null;
                    if (uri != null && uri.length() != 0) {
                        z = false;
                        if (z) {
                            String uri2 = parse2.toString();
                            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                            preLoadService.preloadTemplate(uri2, preloadStrategy2);
                            concurrentHashMap = preLoadService.mPreloadConfigs;
                            ConcurrentHashMap concurrentHashMap4 = concurrentHashMap;
                            if (concurrentHashMap4 != null && !concurrentHashMap4.isEmpty()) {
                                z2 = false;
                                if (!z2) {
                                    preLoadService.printInfo("preloadConfigs isNullOrEmpty on #preload");
                                    if (function2 != null) {
                                        function2.invoke(false, PreLoadResult.ERR_CONFIG_EMPTY);
                                    }
                                } else {
                                    preloadMemoryCache = preLoadService.mCache;
                                    if (preloadMemoryCache != null) {
                                        preloadMemoryCache.trimExpired();
                                    }
                                    ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, preLoadService.getBid(), null, 2, null);
                                    Intrinsics.checkNotNullExpressionValue(parse2, "uri");
                                    RLChannelBundleModel parseChannelBundle = with$default.parseChannelBundle(ExtKt.getCDN$default(parse2, null, 1, null));
                                    if (parseChannelBundle == null) {
                                        parseChannelBundle = new RLChannelBundleModel("", "", false);
                                    }
                                    if (parseChannelBundle.getValid()) {
                                        concurrentHashMap2 = preLoadService.mPreloadConfigs;
                                        if (concurrentHashMap2.containsKey(parseChannelBundle.getChannel())) {
                                            concurrentHashMap3 = preLoadService.mPreloadConfigs;
                                            PreloadConfig preloadConfig = (PreloadConfig) concurrentHashMap3.get(parseChannelBundle.getChannel());
                                            if (preloadConfig != null) {
                                                preLoadService.preloadWithConfig(preloadConfig, preloadStrategy2);
                                            }
                                            if (preloadConfig != null && (js = preloadConfig.getJs()) != null) {
                                                for (PreloadJsConfig preloadJsConfig : js) {
                                                    if (preloadJsConfig.getPriority() >= preloadStrategy2.getPriority()) {
                                                        preLoadService.preloadJs(preloadJsConfig);
                                                    }
                                                }
                                            }
                                            preLoadService.printInfo("preload configs success");
                                            if (function2 != null) {
                                                function2.invoke(true, PreLoadResult.SUCCESS);
                                            }
                                        } else {
                                            preLoadService.printError("preload configs not container " + parseChannelBundle.getChannel());
                                            if (function2 != null) {
                                                function2.invoke(false, PreLoadResult.ERR_GET_CONFIG_FAILED);
                                            }
                                        }
                                    } else if (function2 != null) {
                                        function2.invoke(false, PreLoadResult.ERR_GET_CONFIG_FAILED);
                                    }
                                }
                            }
                            z2 = true;
                            if (!z2) {
                            }
                        } else if (function2 != null) {
                            function2.invoke(false, PreLoadResult.ERR_URL_EMPTY);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    z = true;
                    if (z) {
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void preload(final PreloadConfig preloadConfig, final PreloadStrategy preloadStrategy, final Function2<? super Boolean, ? super PreLoadResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(preloadConfig, "preloadConfig");
        Intrinsics.checkNotNullParameter(preloadStrategy, "preloadStrategy");
        if (!this.mInitSuccess) {
            initWithConfig();
        }
        if (this.bulletSettings == null) {
            ISettingService iSettingService = (ISettingService) getService(ISettingService.class);
            this.bulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        }
        if (this.mCache == null) {
            this.mCache = new PreloadMemoryCache(generateMaxCacheSize());
        }
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preload$2
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                Object obj;
                Unit unit;
                obj = PreLoadService.this.mLock;
                PreLoadService preLoadService = PreLoadService.this;
                PreloadConfig preloadConfig2 = preloadConfig;
                PreloadStrategy preloadStrategy2 = preloadStrategy;
                Function2<Boolean, PreLoadResult, Unit> function2 = callback;
                synchronized (obj) {
                    preLoadService.preloadWithConfig(preloadConfig2, preloadStrategy2);
                    if (function2 != null) {
                        function2.invoke(true, PreLoadResult.SUCCESS);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
                return unit;
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    private final int generateMaxCacheSize() {
        int i;
        BulletSettings bulletSettings = this.bulletSettings;
        int maxMemCache = bulletSettings != null ? bulletSettings.getMaxMemCache() : 2097152;
        try {
            Application application = BulletEnv.INSTANCE.getInstance().getApplication();
            Object systemService = application != null ? application.getSystemService("activity") : null;
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            int coerceAtMost = RangesKt.coerceAtMost(activityManager != null ? activityManager.getMemoryClass() : 2097152, Int32.MAX_VALUE);
            if (coerceAtMost < 33554432) {
                i = 4194304;
            } else {
                i = coerceAtMost < 67108864 ? 6291456 : coerceAtMost / 4;
            }
            maxMemCache = i / 2;
            BulletLogger.onLog$default(BulletLogger.INSTANCE, "preload config init, maxCacheSize = " + maxMemCache, null, 2, null);
            return maxMemCache;
        } catch (Throwable th) {
            BulletLogger.INSTANCE.onReject(th, "preload config failed");
            return maxMemCache;
        }
    }

    public final void preloadWithConfig(PreloadConfig config, PreloadStrategy preloadStrategy) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(preloadStrategy, "preloadStrategy");
        List<PreloadImageConfig> image = config.getImage();
        if (image != null) {
            if (!frescoHasBeenInitialized()) {
                printError("fresco not init when preload");
            } else {
                for (PreloadImageConfig preloadImageConfig : image) {
                    if (preloadImageConfig.getPriority() >= preloadStrategy.getPriority()) {
                        preloadImage(preloadImageConfig);
                    }
                }
            }
        }
        List<PreloadFontConfig> font = config.getFont();
        if (font != null) {
            for (PreloadFontConfig preloadFontConfig : font) {
                if (preloadFontConfig.getPriority() >= preloadStrategy.getPriority()) {
                    preloadFont(preloadFontConfig);
                }
            }
        }
        List<PreloadVideoConfig> video = config.getVideo();
        if (video != null) {
            for (PreloadVideoConfig preloadVideoConfig : video) {
                if (preloadVideoConfig.getPriority() >= preloadStrategy.getPriority()) {
                    preloadVideo(preloadVideoConfig);
                }
            }
        }
        List<PreloadGeckoChannelConfig> geckoChannel = config.getGeckoChannel();
        if (geckoChannel != null) {
            for (PreloadGeckoChannelConfig preloadGeckoChannelConfig : geckoChannel) {
                if (preloadGeckoChannelConfig.getPriority() >= preloadStrategy.getPriority()) {
                    preloadChannel(preloadGeckoChannelConfig);
                }
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public Object getCache(String url, @ResourceFileType int type) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(url, "url");
        synchronized (this.mLock) {
            typeface = null;
            if (type == 0) {
                printError("cannot get template cache from PreloadService, if has cache, use cache on load ");
            } else if (type == 1) {
                PreloadMemoryCache preloadMemoryCache = this.mCache;
                Expired expired = preloadMemoryCache != null ? preloadMemoryCache.get(url) : null;
                if (expired instanceof WrapImage) {
                    CloseableReference<Bitmap> image = ((WrapImage) expired).getImage();
                    if ((image != null ? (Bitmap) image.get() : null) != null) {
                        reportHitPreloadCache(url, type);
                        printInfo("get cache image success from PreloadService, url is " + url);
                        typeface = ((WrapImage) expired).getImage();
                    }
                }
                printError("cannot get cache image from PreloadService， url is " + url);
            } else if (type == 2) {
                PreloadMemoryCache preloadMemoryCache2 = this.mCache;
                Expired expired2 = preloadMemoryCache2 != null ? preloadMemoryCache2.get(url) : null;
                if ((expired2 instanceof WrapTypeface) && ((WrapTypeface) expired2).getTypeface() != null) {
                    reportHitPreloadCache(url, type);
                    printInfo("get cache typeface success from PreloadService, url is " + url);
                    typeface = ((WrapTypeface) expired2).getTypeface();
                } else {
                    printError("cannot get cache typeface from PreloadService, url is " + url);
                }
            } else if (type == 3) {
                printError("cannot get video cache from PreloadService");
            } else if (type == 4) {
                printError("cannot get video cache from PreloadService");
            } else if (type == 5) {
                printError("cannot get channel cache from PreloadService");
            }
        }
        return typeface;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void putUrl(String redirectUrl, String url) {
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(url, "url");
        this.mUrlMap.put(redirectUrl, url);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void forceClean(final String schema) {
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$forceClean$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:57:0x00b0 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:11:0x001c, B:13:0x0022, B:15:0x002c, B:17:0x0038, B:19:0x003e, B:20:0x0044, B:22:0x004a, B:25:0x0056, B:31:0x0060, B:33:0x0066, B:34:0x006c, B:36:0x0072, B:39:0x007e, B:45:0x0088, B:47:0x008e, B:48:0x0094, B:50:0x009a, B:55:0x00aa, B:57:0x00b0), top: B:3:0x000b }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void call() {
                Object obj;
                boolean z;
                PreloadMemoryCache preloadMemoryCache;
                String channelFromSchema;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                List<PreloadVideoConfig> video;
                List<PreloadFontConfig> font;
                PreloadMemoryCache preloadMemoryCache2;
                List<PreloadImageConfig> image;
                PreloadMemoryCache preloadMemoryCache3;
                obj = PreLoadService.this.mLock;
                String str = schema;
                PreLoadService preLoadService = PreLoadService.this;
                synchronized (obj) {
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                        if (!z || channelFromSchema == null) {
                            preloadMemoryCache = preLoadService.mCache;
                            if (preloadMemoryCache != null) {
                                preloadMemoryCache.trimAll();
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        concurrentHashMap = preLoadService.mPreloadConfigs;
                        if (concurrentHashMap.containsKey(channelFromSchema)) {
                            concurrentHashMap2 = preLoadService.mPreloadConfigs;
                            PreloadConfig preloadConfig = (PreloadConfig) concurrentHashMap2.get(channelFromSchema);
                            if (preloadConfig != null && (image = preloadConfig.getImage()) != null) {
                                for (PreloadImageConfig preloadImageConfig : image) {
                                    preloadMemoryCache3 = preLoadService.mCache;
                                    if (preloadMemoryCache3 != null) {
                                        preloadMemoryCache3.remove(preloadImageConfig.getUrl());
                                    }
                                }
                            }
                            if (preloadConfig != null && (font = preloadConfig.getFont()) != null) {
                                for (PreloadFontConfig preloadFontConfig : font) {
                                    preloadMemoryCache2 = preLoadService.mCache;
                                    if (preloadMemoryCache2 != null) {
                                        preloadMemoryCache2.remove(preloadFontConfig.getUrl());
                                    }
                                }
                            }
                            if (preloadConfig != null && (video = preloadConfig.getVideo()) != null) {
                                Iterator<T> it = video.iterator();
                                while (it.hasNext()) {
                                    TTVideoEngine.removeCacheFile(((PreloadVideoConfig) it.next()).getUri());
                                }
                            }
                        }
                        return;
                    }
                    z = true;
                    if (!z) {
                        channelFromSchema = preLoadService.getChannelFromSchema(str);
                    }
                    preloadMemoryCache = preLoadService.mCache;
                    if (preloadMemoryCache != null) {
                    }
                }
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreLoadService
    public void onLowMemory() {
        PreloadMemoryCache preloadMemoryCache = this.mCache;
        if (preloadMemoryCache != null) {
            preloadMemoryCache.trimAll();
        }
        this.mUrlMap.clear();
    }

    private final boolean frescoHasBeenInitialized() {
        return Fresco.hasBeenInitialized();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean requireLowQuality(Uri uri) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            PreLoadService preLoadService = this;
            obj = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(uri.getQueryParameter(KEY_QUALITY), "0")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printError(String msg) {
        printLog(msg, LogLevel.E, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printInfo(String msg) {
        printLog(msg, LogLevel.I, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadTemplate(final String schema, final PreloadStrategy strategy) {
        executeWithService(false, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadTemplate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m579invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x016c A[Catch: all -> 0x01b6, TryCatch #2 {all -> 0x01b6, blocks: (B:22:0x00eb, B:31:0x0166, B:33:0x016c, B:34:0x01ad, B:43:0x015c), top: B:21:0x00eb }] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x01c7  */
            /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m579invoke() {
                Integer num;
                Object obj;
                Object obj2;
                Unit unit;
                Object obj3;
                Throwable th;
                BulletLogger.INSTANCE.printTridentCoreLog("start preloadTemplate", (r15 & 2) != 0 ? null : MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", schema), TuplesKt.to("bid", this.getBid()), TuplesKt.to("strategy", strategy.toString())}), (r15 & 4) != 0 ? LogLevel.I : null, (r15 & 8) != 0 ? "" : "XPreload", (r15 & 16) != 0 ? "" : strategy.getSession(), (r15 & 32) != 0 ? "" : null, (r15 & 64) == 0 ? null : "");
                if (schema.length() == 0) {
                    return;
                }
                ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.getBid(), null, 2, null);
                String str = schema;
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                PreloadStrategy preloadStrategy = strategy;
                taskConfig.setResTag("template");
                TaskContext taskContext = new TaskContext();
                taskContext.putDependency(SessionInfo.class, new SessionInfo(preloadStrategy.getSession()));
                taskConfig.setTaskContext(taskContext);
                taskConfig.setPreload(true);
                taskConfig.setEnableCached(preloadStrategy.getTemplateStrategy() != 2);
                taskConfig.setOnlyLocal(preloadStrategy.getTemplateStrategy() == 0);
                if (preloadStrategy.getTemplateStrategy() != 0) {
                    num = 1;
                } else {
                    num = 0;
                }
                taskConfig.setDynamic(num);
                Unit unit2 = Unit.INSTANCE;
                ResourceInfo loadSync = with$default.loadSync(str, taskConfig);
                if (loadSync != null) {
                    String str2 = schema;
                    PreLoadService preLoadService = this;
                    PreloadStrategy preloadStrategy2 = strategy;
                    InputStream provideInputStream = loadSync.provideInputStream();
                    if (provideInputStream != null) {
                        InputStream inputStream = provideInputStream;
                        try {
                            InputStream inputStream2 = inputStream;
                            try {
                                Result.Companion companion = Result.Companion;
                                ByteStreamsKt.readBytes(inputStream2);
                                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                                Pair[] pairArr = new Pair[5];
                                pairArr[0] = TuplesKt.to("schema", str2);
                                pairArr[1] = TuplesKt.to("success", true);
                                obj2 = "bid";
                                try {
                                    pairArr[2] = TuplesKt.to(obj2, preLoadService.getBid());
                                    obj = "strategy";
                                    try {
                                        pairArr[3] = TuplesKt.to(obj, preloadStrategy2.toString());
                                        pairArr[4] = TuplesKt.to("resourceInfo", loadSync.toString());
                                        bulletLogger.printTridentCoreLog("preloadTemplate result", (r15 & 2) != 0 ? null : MapsKt.mapOf(pairArr), (r15 & 4) != 0 ? LogLevel.I : null, (r15 & 8) != 0 ? "" : "XPreload", (r15 & 16) != 0 ? "" : preloadStrategy2.getSession(), (r15 & 32) != 0 ? "" : null, (r15 & 64) == 0 ? null : "");
                                        obj3 = Result.constructor-impl(Unit.INSTANCE);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Result.Companion companion2 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                        th = Result.exceptionOrNull-impl(obj3);
                                        if (th != null) {
                                        }
                                        Unit unit3 = Unit.INSTANCE;
                                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                                        unit = Unit.INSTANCE;
                                        if (unit == null) {
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = "strategy";
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = "strategy";
                                obj2 = "bid";
                            }
                            th = Result.exceptionOrNull-impl(obj3);
                            if (th != null) {
                                BulletLogger.INSTANCE.printTridentCoreLog("preloadTemplate result", (r15 & 2) != 0 ? null : MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", str2), TuplesKt.to("success", false), TuplesKt.to(obj2, preLoadService.getBid()), TuplesKt.to("error", th.getMessage())}), (r15 & 4) != 0 ? LogLevel.I : null, (r15 & 8) != 0 ? "" : "XPreload", (r15 & 16) != 0 ? "" : preloadStrategy2.getSession(), (r15 & 32) != 0 ? "" : null, (r15 & 64) == 0 ? null : "");
                            }
                            Unit unit32 = Unit.INSTANCE;
                            CloseableKt.closeFinally(inputStream, (Throwable) null);
                            unit = Unit.INSTANCE;
                            if (unit == null) {
                                BulletLogger.INSTANCE.printTridentCoreLog("preloadTemplate result", (r15 & 2) != 0 ? null : MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", schema), TuplesKt.to("success", false), TuplesKt.to(obj2, this.getBid()), TuplesKt.to(obj, strategy.toString()), TuplesKt.to("error", "resourceInfo is null")}), (r15 & 4) != 0 ? LogLevel.I : null, (r15 & 8) != 0 ? "" : "XPreload", (r15 & 16) != 0 ? "" : strategy.getSession(), (r15 & 32) != 0 ? "" : null, (r15 & 64) == 0 ? null : "");
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                CloseableKt.closeFinally(inputStream, th5);
                                throw th6;
                            }
                        }
                    }
                }
                obj = "strategy";
                obj2 = "bid";
                unit = null;
                if (unit == null) {
                }
            }
        });
    }

    private final void preloadImage(final PreloadImageConfig config) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Uri.parse(config.getUrl());
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        executeWithService(config.getSerial(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadImage$1

            /* compiled from: PreLoadService.kt */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ResourceType.values().length];
                    try {
                        iArr[ResourceType.ASSET.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m577invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m577invoke() {
                boolean requireLowQuality;
                PreloadMemoryCache preloadMemoryCache;
                String uri;
                ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, PreLoadService.this.getBid(), null, 2, null);
                String url = config.getUrl();
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
                customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));
                taskConfig.setLoaderConfig(customLoaderConfig);
                taskConfig.setResTag("sub_resource");
                Unit unit = Unit.INSTANCE;
                ResourceInfo loadSync = with$default.loadSync(url, taskConfig);
                if (loadSync != null) {
                    Ref.ObjectRef<String> objectRef3 = objectRef2;
                    String filePath = loadSync.getFilePath();
                    if (filePath == null) {
                        filePath = "";
                    }
                    if (new File(filePath).exists()) {
                        ResourceType type = loadSync.getType();
                        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
                            uri = new Uri.Builder().scheme("asset").authority("").path(loadSync.getFilePath()).build().toString();
                            Intrinsics.checkNotNullExpressionValue(uri, "{\n                      …                        }");
                        } else {
                            uri = new Uri.Builder().scheme("file").authority("").path(loadSync.getFilePath()).build().toString();
                            Intrinsics.checkNotNullExpressionValue(uri, "{\n                      …                        }");
                        }
                        objectRef3.element = uri;
                    }
                }
                if (((CharSequence) objectRef2.element).length() > 0) {
                    objectRef.element = Uri.parse((String) objectRef2.element);
                }
                PreloadMemoryCache.Companion companion = PreloadMemoryCache.INSTANCE;
                Object obj = objectRef.element;
                Intrinsics.checkNotNullExpressionValue(obj, "imageUri");
                PreLoadService preLoadService = PreLoadService.this;
                Object obj2 = objectRef.element;
                Intrinsics.checkNotNullExpressionValue(obj2, "imageUri");
                requireLowQuality = preLoadService.requireLowQuality((Uri) obj2);
                ImageRequest makeDefaultRequest = companion.makeDefaultRequest((Uri) obj, requireLowQuality);
                final PreLoadService preLoadService2 = PreLoadService.this;
                final PreloadImageConfig preloadImageConfig = config;
                final Ref.ObjectRef<Uri> objectRef4 = objectRef;
                preloadMemoryCache = preLoadService2.mCache;
                if ((preloadMemoryCache != null ? preloadMemoryCache.get(preloadImageConfig.getUrl()) : null) != null) {
                    preLoadService2.printInfo("image is cached, will not preload, src = " + preloadImageConfig.getUrl());
                } else {
                    ((DataSource) Fresco.getImagePipeline().getDataSourceSupplier(makeDefaultRequest, (Object) null, ImageRequest.RequestLevel.FULL_FETCH).get()).subscribe(new BaseBitmapDataSubscriber() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadImage$1$3$1
                        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
                        
                            r3 = r1.mCache;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        protected void onNewResultImpl(Bitmap bitmap) {
                            PreloadMemoryCache preloadMemoryCache2;
                            if (bitmap != null) {
                                PreloadImageConfig preloadImageConfig2 = PreloadImageConfig.this;
                                PreLoadService preLoadService3 = preLoadService2;
                                Ref.ObjectRef<Uri> objectRef5 = objectRef4;
                                if (preloadImageConfig2.getEnableMemory() && preloadMemoryCache2 != null) {
                                    String uri2 = ((Uri) objectRef5.element).toString();
                                    Intrinsics.checkNotNullExpressionValue(uri2, "imageUri.toString()");
                                    preloadMemoryCache2.put(uri2, new WrapImage(Fresco.getImagePipelineFactory().getPlatformBitmapFactory().createBitmap(bitmap), BitmapUtil.getSizeInBytes(bitmap), null, 4, null));
                                }
                                preLoadService3.printInfo("preload success, enableMemoryCache: " + preloadImageConfig2.getEnableMemory() + "，src = " + preloadImageConfig2.getUrl() + ", redirectTo: " + objectRef5.element);
                            }
                        }

                        protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                            preLoadService2.printError("preload failed, src = " + PreloadImageConfig.this.getUrl() + ", redirectTo: " + objectRef4.element);
                        }

                        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                            preLoadService2.printError("preload canceled, src = " + PreloadImageConfig.this.getUrl() + ", redirectTo: " + objectRef4.element);
                        }
                    }, new Executor() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadImage$1$3$2
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            runnable.run();
                        }
                    });
                }
            }
        });
    }

    private final void preloadFont(final PreloadFontConfig config) {
        executeWithService(config.getSerial(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadFont$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final Unit invoke() {
                PreloadMemoryCache preloadMemoryCache;
                ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, PreLoadService.this.getBid(), null, 2, null);
                String url = config.getUrl();
                boolean z = true;
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                taskConfig.setResTag("sub_resource");
                Unit unit = Unit.INSTANCE;
                ResourceInfo loadSync = with$default.loadSync(url, taskConfig);
                if (loadSync == null) {
                    return null;
                }
                PreloadFontConfig preloadFontConfig = config;
                PreLoadService preLoadService = PreLoadService.this;
                String filePath = loadSync.getFilePath();
                if (filePath != null && filePath.length() != 0) {
                    z = false;
                }
                if (!z && preloadFontConfig.getEnableMemory()) {
                    try {
                        if (preloadFontConfig.getEnableMemory()) {
                            String filePath2 = loadSync.getFilePath();
                            Intrinsics.checkNotNull(filePath2);
                            Typeface m52x75728ab4 = m52x75728ab4(new File(filePath2));
                            if (m52x75728ab4 != null) {
                                Intrinsics.checkNotNullExpressionValue(m52x75728ab4, "createFromFile(File(it.filePath!!))");
                                preloadMemoryCache = preLoadService.mCache;
                                if (preloadMemoryCache != null) {
                                    String url2 = preloadFontConfig.getUrl();
                                    String filePath3 = loadSync.getFilePath();
                                    Intrinsics.checkNotNull(filePath3);
                                    preloadMemoryCache.put(url2, new WrapTypeface(m52x75728ab4, new File(filePath3).length(), null, 4, null));
                                }
                            }
                        }
                        preLoadService.printInfo("preload font success, enableMemory: " + preloadFontConfig.getEnableMemory() + ", src: " + preloadFontConfig.getUrl());
                    } catch (Exception e) {
                        preLoadService.printError("preload font error," + e.getLocalizedMessage());
                    }
                }
                return Unit.INSTANCE;
            }

            @Proxy("createFromFile")
            @TargetClass("android.graphics.Typeface")
            /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_service_preload_PreLoadService$preloadFont$1_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
            public static Typeface m52x75728ab4(File file) {
                String path;
                if (TypeFaceOptimizer.getSwitch() && (path = file.getPath()) != null) {
                    if (TypeFaceLancet.cache.contains(path)) {
                        return (Typeface) TypeFaceLancet.cache.get(path);
                    }
                    Typeface createFromFile = Typeface.createFromFile(file);
                    if (createFromFile != null) {
                        TypeFaceLancet.cache.put(path, createFromFile);
                        return createFromFile;
                    }
                }
                return Typeface.createFromFile(file);
            }
        });
    }

    private final void preloadVideo(final PreloadVideoConfig config) {
        executeWithService(config.getSerial(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadVideo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m580invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m580invoke() {
                String uri = PreloadVideoConfig.this.getUri();
                String id = PreloadVideoConfig.this.getId();
                Object[] array = PreloadVideoConfig.this.getUrl().toArray(new String[0]);
                if (array != null) {
                    TTVideoEngine.addTask(uri, id, (String[]) array, 819200);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        });
    }

    private final void preloadChannel(PreloadGeckoChannelConfig config) {
        realLoadChannel$default(this, config.getSerial(), config.getChannel(), null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void realLoadChannel$default(PreLoadService preLoadService, boolean z, String str, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        preLoadService.realLoadChannel(z, str, list);
    }

    private final void realLoadChannel(boolean serial, final String geckoChannel, final List<PreloadResourceInfo> resourceInfoList) {
        executeWithService(serial, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$realLoadChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final Unit invoke() {
                ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, PreLoadService.this.getBid(), null, 2, null);
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                String str = geckoChannel;
                CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
                customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));
                taskConfig.setChannel(str);
                taskConfig.setDynamic(2);
                taskConfig.setLoaderConfig(customLoaderConfig);
                Unit unit = Unit.INSTANCE;
                ResourceInfo loadSync = with$default.loadSync("", taskConfig);
                if (loadSync == null) {
                    return null;
                }
                List<PreloadResourceInfo> list = resourceInfoList;
                PreLoadService preLoadService = PreLoadService.this;
                String str2 = geckoChannel;
                PreloadResourceInfo preloadResourceInfo = new PreloadResourceInfo(loadSync.getSrcUri(), loadSync.getFilePath(), loadSync.getIsCache());
                if (list != null) {
                    list.add(preloadResourceInfo);
                }
                String filePath = loadSync.getFilePath();
                if (new File(filePath != null ? filePath : "").exists()) {
                    preLoadService.printInfo("download gecko " + str2 + " success");
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadJs(final PreloadJsConfig config) {
        final String url;
        if (Intrinsics.areEqual("high", config.getMemoryPriority())) {
            url = Uri.parse(config.getUrl()).buildUpon().appendQueryParameter("memory_cache_priority", "high").build().toString();
        } else {
            url = config.getUrl();
        }
        Intrinsics.checkNotNullExpressionValue(url, "if (MEMORY_PRIORITY_HIGH…     config.url\n        }");
        printInfo("preloadJs == " + url);
        executeWithService(config.getSerial(), new Function0<byte[]>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$preloadJs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final byte[] invoke() {
                InputStream provideInputStream;
                ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, PreLoadService.this.getBid(), null, 2, null);
                String str = url;
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                PreloadJsConfig preloadJsConfig = config;
                taskConfig.setResTag("external_js");
                try {
                    Uri parse = Uri.parse(preloadJsConfig.getUrl());
                    Intrinsics.checkNotNullExpressionValue(parse, "uri");
                    String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
                    if (cDN$default != null) {
                        taskConfig.setCdnUrl(cDN$default);
                    }
                    String queryParameter = parse.getQueryParameter("channel");
                    if (queryParameter != null) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                        taskConfig.setChannel(queryParameter);
                    }
                    String queryParameter2 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                    if (queryParameter2 != null) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                        taskConfig.setBundle(queryParameter2);
                    }
                    taskConfig.setDynamic(1);
                    String queryParameter3 = parse.getQueryParameter("dynamic");
                    if (queryParameter3 != null) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                        taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter3)));
                    }
                } catch (Throwable unused) {
                }
                Unit unit = Unit.INSTANCE;
                ResourceInfo loadSync = with$default.loadSync(str, taskConfig);
                if (loadSync == null || (provideInputStream = loadSync.provideInputStream()) == null) {
                    return null;
                }
                InputStream inputStream = provideInputStream;
                try {
                    byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    return readBytes;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStream, th);
                        throw th2;
                    }
                }
            }
        });
    }

    private final <TResult> void executeWithService(boolean serial, final Function0<? extends TResult> action) {
        Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$executeWithService$callable$1
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, TResult] */
            @Override // java.util.concurrent.Callable
            public final TResult call() {
                return action.invoke();
            }
        };
        if (serial) {
            Task.call(callable);
        } else {
            Task.call(callable, this.mSerialExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean downloadGecko(PreDownloadConfig config, List<PreloadResourceInfo> resourceInfoList) {
        if (config.getLoaderType() != PreloadSourceType.GECKO) {
            printInfo("Try download Gecko with " + config.getLoaderType());
            return false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = config.getUrl().iterator();
        while (it.hasNext()) {
            Uri parse = Uri.parse((String) it.next());
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(parse, "channel");
            if (safeGetQueryParameter != null) {
                linkedHashSet.add(safeGetQueryParameter);
            }
        }
        if (linkedHashSet.isEmpty()) {
            return false;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            realLoadChannel(config.getSerial(), (String) it2.next(), resourceInfoList);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean downloadCDN$default(PreLoadService preLoadService, PreDownloadConfig preDownloadConfig, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return preLoadService.downloadCDN(preDownloadConfig, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean downloadCDN(PreDownloadConfig config, final List<PreloadResourceInfo> resourceInfoList) {
        if (config.getLoaderType() != PreloadSourceType.CDN) {
            printInfo("Try download CDN with " + config.getLoaderType());
            return false;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        Iterator<T> it = config.getUrl().iterator();
        while (it.hasNext()) {
            Uri parse = Uri.parse((String) it.next());
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            String cdn = ExtKt.getCDN(parse, this.bid);
            if (cdn != null) {
                linkedHashSet.add(cdn);
            }
        }
        if (linkedHashSet.isEmpty()) {
            return false;
        }
        for (final String str : linkedHashSet) {
            executeWithService(config.getSerial(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$downloadCDN$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final Unit invoke() {
                    ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, PreLoadService.this.getBid(), null, 2, null);
                    TaskConfig taskConfig = new TaskConfig(null, 1, null);
                    taskConfig.setCdnUrl(str);
                    CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
                    customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.CDN}));
                    taskConfig.setDynamic(2);
                    taskConfig.setLoaderConfig(customLoaderConfig);
                    Unit unit = Unit.INSTANCE;
                    ResourceInfo loadSync = with$default.loadSync("", taskConfig);
                    if (loadSync == null) {
                        return null;
                    }
                    List<PreloadResourceInfo> list = resourceInfoList;
                    PreLoadService preLoadService = PreLoadService.this;
                    String str2 = str;
                    PreloadResourceInfo preloadResourceInfo = new PreloadResourceInfo(loadSync.getSrcUri(), loadSync.getFilePath(), loadSync.getIsCache());
                    if (list != null) {
                        list.add(preloadResourceInfo);
                    }
                    String filePath = loadSync.getFilePath();
                    if (new File(filePath != null ? filePath : "").exists()) {
                        preLoadService.printInfo("download cdn " + str2 + " success");
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelFromSchema(String schema) {
        Uri parse = Uri.parse(schema);
        Intrinsics.checkNotNullExpressionValue(parse, "getChannelFromSchema$lambda$15");
        String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
        if (cDN$default != null) {
            RLChannelBundleModel parseChannelBundle = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.bid, null, 2, null).parseChannelBundle(cDN$default);
            String channel = parseChannelBundle != null ? parseChannelBundle.getChannel() : null;
            if (channel != null) {
                return channel;
            }
        }
        return parse.getQueryParameter("channel");
    }

    private final void reportHitPreloadCache(final String url, @ResourceFileType final int type) {
        executeWithService(false, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.preload.PreLoadService$reportHitPreloadCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final Unit invoke() {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                IBulletService service;
                PreloadImageConfig preloadImageConfig;
                Object obj;
                ConcurrentHashMap concurrentHashMap3;
                String str = url;
                concurrentHashMap = this.mUrlMap;
                if (concurrentHashMap.containsKey(url)) {
                    concurrentHashMap3 = this.mUrlMap;
                    str = (String) concurrentHashMap3.get(url);
                    if (str == null) {
                        str = url;
                    }
                }
                int i = type;
                String str2 = i != 1 ? i != 2 ? "" : "font" : "image";
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                concurrentHashMap2 = this.mPreloadConfigs;
                Set entrySet = concurrentHashMap2.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "mPreloadConfigs.entries");
                Iterator it = entrySet.iterator();
                while (true) {
                    Object obj2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    List<PreloadImageConfig> image = ((PreloadConfig) entry.getValue()).getImage();
                    if (image != null) {
                        Iterator<T> it2 = image.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            if (Intrinsics.areEqual(((PreloadImageConfig) obj).getUrl(), str)) {
                                break;
                            }
                        }
                        preloadImageConfig = (PreloadImageConfig) obj;
                    } else {
                        preloadImageConfig = null;
                    }
                    booleanRef.element = preloadImageConfig != null;
                    if (!booleanRef.element) {
                        List<PreloadFontConfig> font = ((PreloadConfig) entry.getValue()).getFont();
                        if (font != null) {
                            Iterator<T> it3 = font.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Object next = it3.next();
                                if (Intrinsics.areEqual(((PreloadFontConfig) next).getUrl(), str)) {
                                    obj2 = next;
                                    break;
                                }
                            }
                            obj2 = (PreloadFontConfig) obj2;
                        }
                        booleanRef.element = obj2 != null;
                    }
                }
                service = this.getService(IMonitorReportService.class);
                IMonitorReportService iMonitorReportService = (IMonitorReportService) service;
                if (iMonitorReportService == null) {
                    return null;
                }
                ReportInfo reportInfo = new ReportInfo(RLMonitorReporter.EVENT_FETCH, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                reportInfo.setUrl(str);
                reportInfo.setPlatform("unknown");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("res_from", "preloadCache");
                jSONObject.put("res_memory", "1");
                jSONObject.put("res_type", str2);
                jSONObject.put("res_in_preload_config", booleanRef.element ? "1" : ViewVisibleBridge.INVISIBLE);
                jSONObject.put("res_state", "success");
                reportInfo.setCategory(jSONObject);
                iMonitorReportService.report(reportInfo);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends IBulletService> T getService(Class<T> clazz) {
        return (T) ServiceCenter.INSTANCE.instance().get(this.bid, clazz);
    }

    static /* synthetic */ void printLog$default(PreLoadService preLoadService, String str, LogLevel logLevel, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            logLevel = LogLevel.I;
        }
        if ((i & 4) != 0) {
            str2 = "XPreload";
        }
        preLoadService.printLog(str, logLevel, str2);
    }

    private final void printLog(String message, LogLevel logLevel, String subModule) {
        BulletLogger.INSTANCE.printLog(message, logLevel, subModule);
    }
}
