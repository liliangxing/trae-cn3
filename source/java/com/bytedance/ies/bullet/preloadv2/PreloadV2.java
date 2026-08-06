package com.bytedance.ies.bullet.preloadv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import bolts.Task;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.FontPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.HighSubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.ImagePreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadCache;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadErrorCode;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadResourceType;
import com.bytedance.ies.bullet.preloadv2.cache.SubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.TemplateMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadImageHelper;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.TemplateBundle;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: PreloadV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020+J.\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0014\u00101\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020'02H\u0002J\u0006\u00103\u001a\u00020'J\u000e\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020'2\u0006\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020+J\u0018\u00107\u001a\u00020'2\u0006\u0010;\u001a\u00020+2\b\b\u0002\u0010:\u001a\u00020+J,\u00107\u001a\u00020'2\u0006\u0010;\u001a\u00020+2\b\b\u0002\u0010:\u001a\u00020+2\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\u0007J>\u0010>\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010:\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020'02H\u0002J<\u0010?\u001a\u00020'2\u0006\u0010-\u001a\u00020@2\u0006\u0010:\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020'02H\u0002J,\u0010A\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u0010:\u001a\u00020+2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020'02H\u0002J\u001a\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020+2\b\u0010D\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010E\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006F"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadV2;", "", "()V", "CPU_COUNT", "", "corePoolSize", "enablePreload", "", "getEnablePreload", "()Z", "setEnablePreload", "(Z)V", "mExecutorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "maximumPoolSize", "memReadHandler", "Landroid/os/Handler;", "getMemReadHandler", "()Landroid/os/Handler;", "memReadHandler$delegate", "Lkotlin/Lazy;", "memWarningProportion", "", "getMemWarningProportion", "()D", "setMemWarningProportion", "(D)V", "subResMemSize", "getSubResMemSize", "()I", "setSubResMemSize", "(I)V", "templateSize", "getTemplateSize", "setTemplateSize", "checkAppMemWarning", "size", "", "clearCache", "", "highPriority", "redirect", ISignalReportConstants.KEY_REASON, "", "handleSubResourceMem", "item", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "cache", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadCache;", "callback", "Lkotlin/Function1;", "onLowMemory", "preWarmLynx", "context", "Landroid/content/Context;", ResourceInfo.RESOURCE_FROM_PRELOAD, "config", "Lcom/bytedance/ies/bullet/preloadv2/PreloadConfig;", "targetBid", "schema", "decodeTemplate", "preCodeCache", "preloadItem", "preloadLynxTemplate", "Lcom/bytedance/ies/bullet/preloadv2/cache/TemplatePreloadItem;", "preloadSubResource", "reportCrash", "url", "message", "warmClass", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadV2 {
    private static final int CPU_COUNT;
    private static final int corePoolSize;
    private static final ThreadPoolExecutor mExecutorService;
    private static final int maximumPoolSize;

    /* renamed from: memReadHandler$delegate, reason: from kotlin metadata */
    private static final Lazy memReadHandler;
    public static final PreloadV2 INSTANCE = new PreloadV2();
    private static boolean enablePreload = true;
    private static int templateSize = 10;
    private static int subResMemSize = 10485760;
    private static double memWarningProportion = 0.1d;

    /* compiled from: PreloadV2.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreloadResourceType.values().length];
            try {
                iArr[PreloadResourceType.Template.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreloadResourceType.Image.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreloadResourceType.Font.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreloadResourceType.DynamicComponent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreloadResourceType.ExternalJs.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreloadResourceType.Lottie.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreloadResourceType.Video.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreloadResourceType.Redirect.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreloadResourceType.Any.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreloadV2() {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int coerceAtLeast = RangesKt.coerceAtLeast(2, RangesKt.coerceAtMost(availableProcessors - 1, 4));
        corePoolSize = coerceAtLeast;
        int i = (availableProcessors * 2) + 1;
        maximumPoolSize = i;
        mExecutorService = new ThreadPoolExecutor(coerceAtLeast, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$mExecutorService$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                int i2;
                int i3;
                Thread thread = new Thread(runnable, "bullet_preload_" + runnable.hashCode());
                PreloadLogger preloadLogger = PreloadLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("generate preload thread, coreSize ");
                i2 = PreloadV2.corePoolSize;
                StringBuilder append = sb.append(i2).append(", maxSize ");
                i3 = PreloadV2.maximumPoolSize;
                preloadLogger.m41d(append.append(i3).toString());
                return thread;
            }
        });
        memReadHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$memReadHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m537invoke() {
                HandlerThread handlerThread = new HandlerThread(IPreloadV2ServiceKt.PRELOAD_LOG_TAG, 10);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            }
        });
    }

    public final boolean getEnablePreload() {
        return enablePreload;
    }

    public final void setEnablePreload(boolean z) {
        enablePreload = z;
    }

    public final int getTemplateSize() {
        return templateSize;
    }

    public final void setTemplateSize(int i) {
        templateSize = i;
    }

    public final int getSubResMemSize() {
        return subResMemSize;
    }

    public final void setSubResMemSize(int i) {
        subResMemSize = i;
    }

    public final double getMemWarningProportion() {
        return memWarningProportion;
    }

    public final void setMemWarningProportion(double d) {
        memWarningProportion = d;
    }

    private final Handler getMemReadHandler() {
        return (Handler) memReadHandler.getValue();
    }

    public static /* synthetic */ void clearCache$default(PreloadV2 preloadV2, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        preloadV2.clearCache(z, z2, str);
    }

    public final void clearCache(boolean highPriority, boolean redirect, String reason) {
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        PreloadLogger.INSTANCE.m43i("clearCache because of " + reason);
        TemplateMemCache.INSTANCE.reSize(templateSize);
        SubResourceMemCache.INSTANCE.reSize(subResMemSize);
        if (highPriority) {
            HighSubResourceMemCache.INSTANCE.reSize(subResMemSize);
        }
    }

    public final void onLowMemory() {
        clearCache(true, false, "onLowMemory");
    }

    public static /* synthetic */ void preload$default(PreloadV2 preloadV2, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        preloadV2.preload(str, str2);
    }

    public final void preload(String schema, String targetBid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(targetBid, "targetBid");
        preload(schema, targetBid, false, false);
    }

    public static /* synthetic */ void preload$default(PreloadV2 preloadV2, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "default_bid";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        preloadV2.preload(str, str2, z, z2);
    }

    public final void preload(final String schema, final String targetBid, final boolean decodeTemplate, final boolean preCodeCache) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(targetBid, "targetBid");
        if (!enablePreload) {
            PreloadLogger.INSTANCE.m43i("enablePreload is false");
        } else {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preload$1
                /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
                @Override // java.util.concurrent.Callable
                /* renamed from: call-xLWZpok, reason: not valid java name and merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Result<? extends Unit> call() {
                    Object obj;
                    Throwable th;
                    Uri parse;
                    boolean z;
                    boolean z2;
                    PreloadConfig config;
                    String str = schema;
                    boolean z3 = decodeTemplate;
                    boolean z4 = preCodeCache;
                    String str2 = targetBid;
                    try {
                        Result.Companion companion = Result.Companion;
                        parse = Uri.parse(str);
                        PreloadLogger.INSTANCE.m43i("decodeTemplate:" + z3 + ", preCodeCache:" + z4);
                        z = true;
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (!z3 && !parse.getBooleanQueryParameter("decodeTemplate", false)) {
                        z2 = false;
                        if (!z4 && !parse.getBooleanQueryParameter("preCodeCache", false)) {
                            z = false;
                        }
                        PreloadLogger.INSTANCE.m43i("preload schema " + str + ",bid " + str2 + ", decodeTemplate:" + z2 + ", preCodeCache:" + z);
                        config = PreloadConfig.INSTANCE.getConfig(str, str2);
                        if (!config.getDecodeTemplate() && z2) {
                            PreloadLogger.INSTANCE.m43i("force set decodeTemplate to true");
                            config.setDecodeTemplate(z2);
                        }
                        if (!config.getPreCodeCache() && z) {
                            PreloadLogger.INSTANCE.m43i("force set preCodeCache to true");
                            config.setPreCodeCache(z);
                        }
                        PreloadV2.INSTANCE.preload(config, str2);
                        obj = Result.constructor-impl(Unit.INSTANCE);
                        th = Result.exceptionOrNull-impl(obj);
                        if (th != null) {
                            PreloadLogger.INSTANCE.m42e("preload failure " + th.getMessage());
                        }
                        return Result.box-impl(obj);
                    }
                    z2 = true;
                    if (!z4) {
                        z = false;
                    }
                    PreloadLogger.INSTANCE.m43i("preload schema " + str + ",bid " + str2 + ", decodeTemplate:" + z2 + ", preCodeCache:" + z);
                    config = PreloadConfig.INSTANCE.getConfig(str, str2);
                    if (!config.getDecodeTemplate()) {
                        PreloadLogger.INSTANCE.m43i("force set decodeTemplate to true");
                        config.setDecodeTemplate(z2);
                    }
                    if (!config.getPreCodeCache()) {
                        PreloadLogger.INSTANCE.m43i("force set preCodeCache to true");
                        config.setPreCodeCache(z);
                    }
                    PreloadV2.INSTANCE.preload(config, str2);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    th = Result.exceptionOrNull-impl(obj);
                    if (th != null) {
                    }
                    return Result.box-impl(obj);
                }
            }, mExecutorService);
        }
    }

    public static /* synthetic */ void preload$default(PreloadV2 preloadV2, PreloadConfig preloadConfig, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        preloadV2.preload(preloadConfig, str);
    }

    public final void preload(final PreloadConfig config, final String targetBid) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(targetBid, "targetBid");
        if (enablePreload) {
            for (final PreloadItem preloadItem : config.getItems()) {
                final long currentTimeMillis = System.currentTimeMillis();
                Task.call(new Callable() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preload$2
                    @Override // java.util.concurrent.Callable
                    /* renamed from: call-xLWZpok, reason: not valid java name and merged with bridge method [inline-methods] */
                    public final Result<? extends Unit> call() {
                        Object obj;
                        final PreloadItem preloadItem2 = PreloadItem.this;
                        final long j = currentTimeMillis;
                        String str = targetBid;
                        PreloadConfig preloadConfig = config;
                        try {
                            Result.Companion companion = Result.Companion;
                            PreloadLogger.INSTANCE.m41d(preloadItem2 + " thread switch to rlThread cost " + (System.currentTimeMillis() - j));
                            PreloadV2.INSTANCE.preloadItem(preloadItem2, str, preloadConfig.getDecodeTemplate(), preloadConfig.getPreCodeCache(), new Function1<PreloadItem, Unit>() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preload$2$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((PreloadItem) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(PreloadItem preloadItem3) {
                                    Intrinsics.checkNotNullParameter(preloadItem3, "it");
                                    PreloadItem.this.setTotalDuration(System.currentTimeMillis() - j);
                                    PreloadLogger.INSTANCE.m43i(preloadItem3 + " callback " + PreloadItem.this.getResUrl() + ", rlDuration " + PreloadItem.this.getRlDuration() + ", memDuration " + PreloadItem.this.getMemoryDuration() + ", totalDuration " + PreloadItem.this.getTotalDuration());
                                    if (preloadItem3.getErrCode() != PreloadErrorCode.None) {
                                        PreloadLogger.INSTANCE.m42e(preloadItem3 + " error " + preloadItem3.getErrCode() + ", " + preloadItem3.getErrMessage());
                                        if (preloadItem3.getErrCode() == PreloadErrorCode.Crash) {
                                            PreloadV2.INSTANCE.reportCrash(PreloadItem.this.getResUrl(), preloadItem3.getErrMessage());
                                        }
                                    }
                                }
                            });
                            obj = Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        PreloadItem preloadItem3 = PreloadItem.this;
                        Throwable th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                            PreloadLogger.INSTANCE.m42e(preloadItem3 + " callback Crash, " + th2.getMessage());
                            PreloadV2.INSTANCE.reportCrash(preloadItem3.getResUrl(), th2.getMessage());
                        }
                        return Result.box-impl(obj);
                    }
                }, mExecutorService);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCrash(String url, String message) {
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("bdx_preload_crash", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resUrl", url);
            if (message != null) {
                jSONObject.put("message", message);
            }
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }

    static /* synthetic */ void preloadItem$default(PreloadV2 preloadV2, PreloadItem preloadItem, String str, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        preloadV2.preloadItem(preloadItem, str, z, z2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadItem(PreloadItem item, String targetBid, boolean decodeTemplate, boolean preCodeCache, Function1<? super PreloadItem, Unit> callback) {
        if (WhenMappings.$EnumSwitchMapping$0[item.getType().ordinal()] == 1) {
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem");
            preloadLynxTemplate((TemplatePreloadItem) item, targetBid, decodeTemplate, preCodeCache, callback);
        } else {
            preloadSubResource(item, targetBid, callback);
        }
    }

    private final void preloadLynxTemplate(final TemplatePreloadItem item, final String targetBid, final boolean decodeTemplate, final boolean preCodeCache, final Function1<? super PreloadItem, Unit> callback) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.parse(item.getResUrl()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        final Uri uri = (Uri) obj;
        if (uri == null) {
            callback.invoke(item.markError(PreloadErrorCode.UriInvalid, "resource schema in wrong format: " + uri));
            return;
        }
        PreloadLogger.INSTANCE.m41d(item + " 模版资源 " + uri);
        long currentTimeMillis = System.currentTimeMillis();
        TaskConfig generateTaskConfig = PreloadHelper.INSTANCE.generateTaskConfig(item, uri, targetBid);
        generateTaskConfig.setLoadTimeOut(3500L);
        item.setTaskConfig(generateTaskConfig);
        TaskConfig taskConfig = new TaskConfig("");
        TaskConfig taskConfig2 = item.getTaskConfig();
        Intrinsics.checkNotNull(taskConfig2);
        TaskConfig from = taskConfig.from(taskConfig2);
        String safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("channel", uri);
        if (safeGetQueryParameter != null) {
            from.setChannel(safeGetQueryParameter);
        }
        String safeGetQueryParameter2 = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE, uri);
        if (safeGetQueryParameter2 != null) {
            from.setBundle(safeGetQueryParameter2);
        }
        item.setTaskConfigForKey(from);
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null);
        TaskConfig taskConfig3 = item.getTaskConfig();
        Intrinsics.checkNotNull(taskConfig3);
        final ResourceInfo loadSync = with$default.loadSync("", taskConfig3);
        final long currentTimeMillis2 = System.currentTimeMillis();
        item.setRlDuration(currentTimeMillis2 - currentTimeMillis);
        if ((loadSync != null ? loadSync.getFilePath() : null) == null || !PreloadHelper.INSTANCE.checkUriValid(uri)) {
            PreloadErrorCode preloadErrorCode = PreloadErrorCode.RLFail;
            TaskConfig taskConfig4 = item.getTaskConfig();
            callback.invoke(item.markError(preloadErrorCode, String.valueOf(taskConfig4 != null ? taskConfig4.getPipelineInfo() : null)));
            return;
        }
        loadSync.setMemoryCachePriority("high");
        item.setResourceInfo(loadSync);
        item.setFilePath(loadSync.getFilePath());
        PreloadLogger.INSTANCE.m43i("enableMemory: " + item.getEnableMemory() + ", decodeTemplate: " + decodeTemplate + ", preCodeCache: " + preCodeCache);
        if (item.getEnableMemory() || decodeTemplate) {
            getMemReadHandler().post(new Runnable() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preloadLynxTemplate$3
                @Override // java.lang.Runnable
                public final void run() {
                    boolean checkAppMemWarning;
                    byte[] readBytes;
                    TemplatePreloadItem templatePreloadItem = TemplatePreloadItem.this;
                    long j = currentTimeMillis2;
                    Function1<PreloadItem, Unit> function1 = callback;
                    ResourceInfo resourceInfo = loadSync;
                    boolean z = decodeTemplate;
                    boolean z2 = preCodeCache;
                    String str = targetBid;
                    Uri uri2 = uri;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        long currentTimeMillis3 = System.currentTimeMillis();
                        PreloadLogger.INSTANCE.m41d(templatePreloadItem + " thread switch to memReadThread cost " + (currentTimeMillis3 - j));
                        String filePath = templatePreloadItem.getFilePath();
                        Intrinsics.checkNotNull(filePath);
                        checkAppMemWarning = PreloadV2.INSTANCE.checkAppMemWarning(new File(filePath).length());
                        if (!checkAppMemWarning && TemplateMemCache.INSTANCE.checkEnoughSpace(1L)) {
                            InputStream provideInputStream = resourceInfo.provideInputStream();
                            if (provideInputStream != null && (readBytes = ByteStreamsKt.readBytes(provideInputStream)) != null) {
                                if (z) {
                                    TemplateBundle fromTemplate = TemplateBundle.fromTemplate(readBytes);
                                    PreloadLogger.INSTANCE.m43i("decodeTemplate stand alone");
                                    if (z2 && !PreloadHelper.INSTANCE.disableCodeCache(str)) {
                                        Uri value = new UrlParam(SchemaService.INSTANCE.getInstance().generateSchemaData(str, uri2), "url", null).getValue();
                                        if (value != null) {
                                            uri2 = value;
                                        }
                                        String identifierUrl = new BulletLoadUriIdentifier(uri2).getIdentifierUrl();
                                        fromTemplate.postJsCacheGenerationTask(identifierUrl, false);
                                        PreloadLogger.INSTANCE.m43i("PreCodeCache: " + identifierUrl);
                                    }
                                    templatePreloadItem.setTemplateBundle(fromTemplate);
                                } else {
                                    templatePreloadItem.setByteArray(readBytes);
                                }
                                if (PreloadCache.put$default(TemplateMemCache.INSTANCE, templatePreloadItem, false, 2, null)) {
                                    PreloadLogger.INSTANCE.m43i("add item into memory cache successfully");
                                    templatePreloadItem.setMemoryDuration(System.currentTimeMillis() - currentTimeMillis3);
                                    function1.invoke(templatePreloadItem);
                                    return;
                                }
                            }
                            function1.invoke(templatePreloadItem.markError(PreloadErrorCode.MemFail, "nowSize " + TemplateMemCache.INSTANCE.nowSize() + ", maxSize " + TemplateMemCache.INSTANCE.maxSize() + ", cacheSize " + templatePreloadItem.getSize()));
                            return;
                        }
                        function1.invoke(templatePreloadItem.markError(PreloadErrorCode.CacheFull, "template cache now size " + TemplateMemCache.INSTANCE.nowSize() + ", max size " + TemplateMemCache.INSTANCE.maxSize() + ", cacheSize 1"));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        Object obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                        Function1<PreloadItem, Unit> function12 = callback;
                        TemplatePreloadItem templatePreloadItem2 = TemplatePreloadItem.this;
                        Throwable th3 = Result.exceptionOrNull-impl(obj2);
                        if (th3 != null) {
                            function12.invoke(templatePreloadItem2.markError(PreloadErrorCode.Crash, th3.getMessage()));
                        }
                    }
                }
            });
        } else {
            callback.invoke(item);
        }
    }

    private final void preloadSubResource(final PreloadItem item, String targetBid, final Function1<? super PreloadItem, Unit> callback) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.parse(item.getResUrl()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri = (Uri) obj;
        if (uri == null) {
            callback.invoke(item.markError(PreloadErrorCode.UriInvalid, "resource schema in wrong format: " + uri));
            return;
        }
        PreloadLogger.INSTANCE.m41d(item + " 子资源 " + item.getResUrl());
        long currentTimeMillis = System.currentTimeMillis();
        item.setTaskConfig(PreloadHelper.INSTANCE.generateTaskConfig(item, uri, targetBid));
        TaskConfig taskConfig = new TaskConfig("");
        TaskConfig taskConfig2 = item.getTaskConfig();
        Intrinsics.checkNotNull(taskConfig2);
        TaskConfig from = taskConfig.from(taskConfig2);
        String safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("channel", uri);
        if (safeGetQueryParameter != null) {
            from.setChannel(safeGetQueryParameter);
        }
        String safeGetQueryParameter2 = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE, uri);
        if (safeGetQueryParameter2 != null) {
            from.setBundle(safeGetQueryParameter2);
        }
        item.setTaskConfigForKey(from);
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null);
        String resUrl = item.getResUrl();
        TaskConfig taskConfig3 = item.getTaskConfig();
        Intrinsics.checkNotNull(taskConfig3);
        ResourceInfo loadSync = with$default.loadSync(resUrl, taskConfig3);
        final long currentTimeMillis2 = System.currentTimeMillis();
        item.setRlDuration(currentTimeMillis2 - currentTimeMillis);
        if (loadSync != null) {
            String filePath = loadSync.getFilePath();
            if (!(filePath == null || filePath.length() == 0)) {
                item.setResourceInfo(loadSync);
                item.setFilePath(loadSync.getFilePath());
                final boolean z = item.getType() == PreloadResourceType.Image || item.getType() == PreloadResourceType.Redirect;
                if (z) {
                    item.setRedirectPath(item.getResUrl());
                    RedirectManager redirectManager = RedirectManager.INSTANCE;
                    String filePath2 = loadSync.getFilePath();
                    Intrinsics.checkNotNull(filePath2);
                    String wrapRedirectPath = redirectManager.wrapRedirectPath(filePath2, loadSync.getType());
                    if (wrapRedirectPath != null) {
                        item.setRedirectPath(wrapRedirectPath);
                    }
                    if (loadSync.getFrom() == ResourceFrom.CDN) {
                        item.setRedirectPath(item.getResUrl());
                    }
                    RedirectManager.INSTANCE.putRedirectPath(item.getResUrl(), item.getRedirectPath());
                } else {
                    item.setRedirectPath(loadSync.getFilePath());
                }
                if (item.getEnableMemory()) {
                    final PreloadCache preloadCache = item.getHighPriority() ? HighSubResourceMemCache.INSTANCE : SubResourceMemCache.INSTANCE;
                    String redirectPath = z ? item.getRedirectPath() : item.getKey();
                    Intrinsics.checkNotNull(redirectPath);
                    if (preloadCache.getCache(redirectPath) != null) {
                        callback.invoke(item.markError(PreloadErrorCode.CacheDuplicate, "duplicate cache, key " + redirectPath + " in " + preloadCache.getName()));
                        return;
                    } else {
                        getMemReadHandler().post(new Runnable() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preloadSubResource$3
                            @Override // java.lang.Runnable
                            public final void run() {
                                Object obj2;
                                final PreloadItem preloadItem = PreloadItem.this;
                                long j = currentTimeMillis2;
                                final PreloadCache preloadCache2 = preloadCache;
                                final Function1<PreloadItem, Unit> function1 = callback;
                                final boolean z2 = z;
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    final long currentTimeMillis3 = System.currentTimeMillis();
                                    Thread currentThread = Thread.currentThread();
                                    PreloadLogger.INSTANCE.m41d(preloadItem + " thread switch to memThread " + currentThread.getName() + ", priority " + currentThread.getPriority() + ", id " + currentThread.getId() + ", cost " + (currentTimeMillis3 - j));
                                    PreloadV2.INSTANCE.handleSubResourceMem(preloadItem, preloadCache2, new Function1<PreloadItem, Unit>() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$preloadSubResource$3$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                            invoke((PreloadItem) obj3);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PreloadItem preloadItem2) {
                                            if (preloadItem2 != null) {
                                                PreloadItem preloadItem3 = preloadItem;
                                                PreloadCache preloadCache3 = preloadCache2;
                                                boolean z3 = z2;
                                                long j2 = currentTimeMillis3;
                                                Function1<PreloadItem, Unit> function12 = function1;
                                                PreloadLogger.INSTANCE.m43i(preloadItem3 + " 缓存大小 size " + preloadItem2.getSize() + ", " + preloadItem2.getKey());
                                                if (preloadCache3.put(preloadItem2, z3)) {
                                                    preloadItem3.setMemoryDuration(System.currentTimeMillis() - j2);
                                                    function12.invoke(preloadItem3);
                                                    return;
                                                }
                                            }
                                            function1.invoke(preloadItem.markError(PreloadErrorCode.MemFail, "high nowSize " + preloadCache2.nowSize() + ", maxSize " + preloadCache2.maxSize() + ", cacheSize " + preloadItem.getSize()));
                                        }
                                    });
                                    obj2 = Result.constructor-impl(Unit.INSTANCE);
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                Function1<PreloadItem, Unit> function12 = callback;
                                PreloadItem preloadItem2 = PreloadItem.this;
                                Throwable th3 = Result.exceptionOrNull-impl(obj2);
                                if (th3 != null) {
                                    function12.invoke(preloadItem2.markError(PreloadErrorCode.Crash, th3.getMessage()));
                                }
                            }
                        });
                        return;
                    }
                }
                callback.invoke(item);
                return;
            }
        }
        PreloadErrorCode preloadErrorCode = PreloadErrorCode.RLFail;
        TaskConfig taskConfig4 = item.getTaskConfig();
        callback.invoke(item.markError(preloadErrorCode, String.valueOf(taskConfig4 != null ? taskConfig4.getPipelineInfo() : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkAppMemWarning(long size) {
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = maxMemory - freeMemory;
        if (j + size >= maxMemory * memWarningProportion) {
            return false;
        }
        PreloadLogger.INSTANCE.m43i("checkAppMemWarning, leftMem " + j + ", maxMemory " + maxMemory + ", size " + size);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSubResourceMem(final PreloadItem item, PreloadCache cache, final Function1<? super PreloadItem, Unit> callback) {
        InputStream provideInputStream;
        byte[] readBytes;
        switch (WhenMappings.$EnumSwitchMapping$0[item.getType().ordinal()]) {
            case 1:
            case 7:
            case 8:
            case 9:
                callback.invoke((Object) null);
                return;
            case 2:
                PreloadImageHelper preloadImageHelper = PreloadImageHelper.INSTANCE;
                String filePath = item.getFilePath();
                Intrinsics.checkNotNull(filePath);
                long imageSize = preloadImageHelper.getImageSize(filePath);
                if (imageSize == 0 || !cache.checkEnoughSpace(imageSize)) {
                    callback.invoke((Object) null);
                    return;
                }
                if (Build.VERSION.SDK_INT < 26 && checkAppMemWarning(imageSize)) {
                    callback.invoke((Object) null);
                    return;
                }
                PreloadImageHelper preloadImageHelper2 = PreloadImageHelper.INSTANCE;
                String redirectPath = item.getRedirectPath();
                Intrinsics.checkNotNull(redirectPath);
                preloadImageHelper2.request(redirectPath, new Function1<CloseableReference<Bitmap>, Unit>() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2$handleSubResourceMem$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CloseableReference<Bitmap>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CloseableReference<Bitmap> closeableReference) {
                        if (closeableReference != null) {
                            PreloadItem preloadItem = PreloadItem.this;
                            Function1<PreloadItem, Unit> function1 = callback;
                            ImagePreloadItem imagePreloadItem = preloadItem instanceof ImagePreloadItem ? (ImagePreloadItem) preloadItem : null;
                            if (imagePreloadItem != null) {
                                imagePreloadItem.setImage(closeableReference);
                            }
                            function1.invoke(preloadItem);
                        }
                    }
                });
                return;
            case 3:
                String filePath2 = item.getFilePath();
                Intrinsics.checkNotNull(filePath2);
                long length = new File(filePath2).length();
                if (checkAppMemWarning(length) || !cache.checkEnoughSpace(length)) {
                    callback.invoke((Object) null);
                    return;
                }
                String filePath3 = item.getFilePath();
                Intrinsics.checkNotNull(filePath3);
                Typeface m40xbfde710a = m40xbfde710a(new File(filePath3));
                if (m40xbfde710a != null) {
                    FontPreloadItem fontPreloadItem = item instanceof FontPreloadItem ? (FontPreloadItem) item : null;
                    if (fontPreloadItem != null) {
                        fontPreloadItem.setTypeFace(m40xbfde710a);
                    }
                    callback.invoke(item);
                    return;
                }
                return;
            case 4:
            case 5:
                String filePath4 = item.getFilePath();
                Intrinsics.checkNotNull(filePath4);
                long length2 = new File(filePath4).length();
                if (checkAppMemWarning(length2) || !cache.checkEnoughSpace(length2)) {
                    callback.invoke((Object) null);
                    return;
                }
                ResourceInfo resourceInfo = item.getResourceInfo();
                if (resourceInfo == null || (provideInputStream = resourceInfo.provideInputStream()) == null || (readBytes = ByteStreamsKt.readBytes(provideInputStream)) == null) {
                    return;
                }
                ByteArrayPreloadItem byteArrayPreloadItem = item instanceof ByteArrayPreloadItem ? (ByteArrayPreloadItem) item : null;
                if (byteArrayPreloadItem != null) {
                    byteArrayPreloadItem.setByteArray(readBytes);
                }
                callback.invoke(item);
                return;
            case 6:
                callback.invoke(item);
                return;
            default:
                return;
        }
    }

    public final void warmClass() {
        try {
            Class.forName("com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate");
            Class.forName("com.bytedance.ies.bullet.lynx.LynxKitView");
            Class.forName("com.bytedance.ies.bullet.lynx.impl.DefaultLynxViewClient");
            Class.forName("com.bytedance.ies.bullet.lynx.impl.LynxEngineGlobalConfig");
            Class.forName("com.bytedance.ies.bullet.lynx.init.LynxKit");
        } catch (Throwable unused) {
        }
    }

    public final void preWarmLynx(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Class.forName("com.lynx.tasm.LynxView").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (Throwable unused) {
            Log.w(IPreloadV2ServiceKt.PRELOAD_LOG_TAG, "preWarmLynx failed");
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_bytedance_ies_bullet_preloadv2_PreloadV2_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m40xbfde710a(File file) {
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
}
