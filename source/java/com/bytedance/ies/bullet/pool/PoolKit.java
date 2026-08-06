package com.bytedance.ies.bullet.pool;

import android.app.ActivityManager;
import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.pool.impl.KeyPreRenderPool;
import com.bytedance.ies.bullet.pool.impl.ReUsePool;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.Event;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventObserver;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderConfig;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.IUniqueSchemaConverter;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.router.RouterServiceKt;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: PoolKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 S2\u00020\u0001:\u0001SB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0005J\"\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bJ\u0012\u00100\u001a\u0004\u0018\u00010+2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010+2\u0006\u00102\u001a\u00020-H\u0002J\u000f\u00103\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010,\u001a\u00020-H\u0002J\u0084\u0001\u0010;\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2X\u0010?\u001aT\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b()\u0012%\u0012#\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&0@¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020&0@j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+`DJ'\u0010E\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\b\u0010F\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000208H\u0002J\u0016\u0010I\u001a\u00020J2\u0006\u0010,\u001a\u00020-2\u0006\u0010K\u001a\u00020LJ\u000e\u0010I\u001a\u00020J2\u0006\u0010M\u001a\u00020+J\u001e\u0010N\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0018\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u0002082\b\b\u0002\u0010Q\u001a\u00020RR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010 ¨\u0006T"}, d2 = {"Lcom/bytedance/ies/bullet/pool/PoolKit;", "", "config", "Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "bid", "", "(Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;Ljava/lang/String;)V", "enableBulletPrerenderCallMonitor", "", "getEnableBulletPrerenderCallMonitor", "()Z", "enableBulletPrerenderCallMonitor$delegate", "Lkotlin/Lazy;", "enableBulletPrerenderGovern", "getEnableBulletPrerenderGovern", "enableBulletPrerenderGovern$delegate", "mEventObserver", "Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "mKeyPreRenderPool", "Lcom/bytedance/ies/bullet/pool/impl/KeyPreRenderPool;", "mReUsePool", "Lcom/bytedance/ies/bullet/pool/impl/ReUsePool;", "mUniqueSchemaConvert", "Lcom/bytedance/ies/bullet/service/base/IUniqueSchemaConverter;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "preRenderMaxCacheTime", "", "getPreRenderMaxCacheTime", "()J", "preRenderMaxCacheTime$delegate", "preRenderMinFreeMemory", "getPreRenderMinFreeMemory", "preRenderMinFreeMemory$delegate", "clearAll", "", ISignalReportConstants.KEY_REASON, "clearCache", "cacheKey", "fetch", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "originSchema", "Landroid/net/Uri;", "openPreRenderOpt", "openReUseOpt", "fetchPreRendered", "fetchReUsed", "uniqueSchema", "getFreeMemory", "()Ljava/lang/Long;", "getPoolInfo", "Lorg/json/JSONObject;", "curPreRenderSize", "", "curReuseSize", "getUniqueSchema", "preRender", LynxTimingPerformanceReportProcessor.KEY_DURATION, "callback", "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "preRenderOp", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "Lcom/bytedance/ies/bullet/pool/api/PreRenderOperationWithKey;", "prerenderAvailableCheck", "freeMemory", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;)Z", "prerenderRemainingSize", "reUse", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "containerView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "cacheItem", "remove", "resize", "newSize", "type", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PoolKit {
    private static final int DEFAULT_POOL_SIZE_PRE_RENDER = 3;
    private static final int DEFAULT_POOL_SIZE_REUSE = 3;
    private final String bid;
    private final IPreRenderConfig config;

    /* renamed from: enableBulletPrerenderCallMonitor$delegate, reason: from kotlin metadata */
    private final Lazy enableBulletPrerenderCallMonitor;

    /* renamed from: enableBulletPrerenderGovern$delegate, reason: from kotlin metadata */
    private final Lazy enableBulletPrerenderGovern;
    private IEventObserver mEventObserver;
    private KeyPreRenderPool mKeyPreRenderPool;
    private ReUsePool mReUsePool;
    private IUniqueSchemaConverter mUniqueSchemaConvert;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* renamed from: preRenderMaxCacheTime$delegate, reason: from kotlin metadata */
    private final Lazy preRenderMaxCacheTime;

    /* renamed from: preRenderMinFreeMemory$delegate, reason: from kotlin metadata */
    private final Lazy preRenderMinFreeMemory;

    /* compiled from: PoolKit.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheType.values().length];
            try {
                iArr[CacheType.REUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheType.PRE_RENDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CacheType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PoolKit(IPreRenderConfig iPreRenderConfig, String str) {
        Intrinsics.checkNotNullParameter(iPreRenderConfig, "config");
        Intrinsics.checkNotNullParameter(str, "bid");
        this.config = iPreRenderConfig;
        this.bid = str;
        this.mEventObserver = iPreRenderConfig.getEventObserver();
        this.mKeyPreRenderPool = new KeyPreRenderPool(iPreRenderConfig.getPreRenderPoolSize(), this.mEventObserver);
        this.mReUsePool = new ReUsePool(iPreRenderConfig.getReUsePoolSize());
        this.mUniqueSchemaConvert = iPreRenderConfig.getUniqueSchemaConverter();
        this.mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.bullet.pool.PoolKit$mainHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m523invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.enableBulletPrerenderGovern = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.pool.PoolKit$enableBulletPrerenderGovern$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m522invoke() {
                BulletSettings provideBulletSettings;
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableBulletPreRenderGovern());
            }
        });
        this.preRenderMinFreeMemory = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.ies.bullet.pool.PoolKit$preRenderMinFreeMemory$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Long m525invoke() {
                BulletSettings provideBulletSettings;
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 200L : provideBulletSettings.getPreRenderMinFreeMemory());
            }
        });
        this.preRenderMaxCacheTime = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.ies.bullet.pool.PoolKit$preRenderMaxCacheTime$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Long m524invoke() {
                BulletSettings provideBulletSettings;
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? Constants.TASK_WAIT_THRESHOLD : provideBulletSettings.getPreRenderMaxCacheTime());
            }
        });
        this.enableBulletPrerenderCallMonitor = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.pool.PoolKit$enableBulletPrerenderCallMonitor$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m521invoke() {
                return Boolean.valueOf(IConditionCallKt.enableBulletPrerenderCallMonitor());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    private final boolean getEnableBulletPrerenderGovern() {
        return ((Boolean) this.enableBulletPrerenderGovern.getValue()).booleanValue();
    }

    private final long getPreRenderMinFreeMemory() {
        return ((Number) this.preRenderMinFreeMemory.getValue()).longValue();
    }

    private final long getPreRenderMaxCacheTime() {
        return ((Number) this.preRenderMaxCacheTime.getValue()).longValue();
    }

    private final boolean getEnableBulletPrerenderCallMonitor() {
        return ((Boolean) this.enableBulletPrerenderCallMonitor.getValue()).booleanValue();
    }

    public final void preRender(final String cacheKey, final Uri originSchema, long duration, final IPreRenderCallback callback, Function2<? super String, ? super Function2<? super CacheItemStatus, ? super CacheItem, Unit>, Unit> preRenderOp) {
        String str;
        boolean z;
        Long l;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(preRenderOp, "preRenderOp");
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = duration;
        if (getEnableBulletPrerenderGovern()) {
            longRef.element = RangesKt.coerceAtMost(duration, getPreRenderMaxCacheTime());
        }
        if (originSchema == null || !getEnableBulletPrerenderCallMonitor()) {
            str = null;
            z = true;
            l = null;
        } else {
            Long freeMemory = getFreeMemory();
            z = prerenderAvailableCheck(originSchema, freeMemory, this.bid);
            str = null;
            PreMonitorReporter.INSTANCE.reportPreRenderPUse(originSchema, "load", z, this.config.getPreRenderPoolSize(), this.mKeyPreRenderPool.size(), this.bid, duration, freeMemory);
            l = freeMemory;
        }
        if (cacheKey != null && originSchema != null && z) {
            this.mKeyPreRenderPool.preRender(cacheKey, new IPreRenderCallback() { // from class: com.bytedance.ies.bullet.pool.PoolKit$preRender$1
                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onSuccess(String sessionId) {
                    IPreRenderConfig iPreRenderConfig;
                    KeyPreRenderPool keyPreRenderPool;
                    String str2;
                    Handler mainHandler;
                    Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                    IPreRenderCallback.this.onSuccess(sessionId);
                    PreMonitorReporter preMonitorReporter = PreMonitorReporter.INSTANCE;
                    Uri uri = originSchema;
                    iPreRenderConfig = this.config;
                    int preRenderPoolSize = iPreRenderConfig.getPreRenderPoolSize();
                    keyPreRenderPool = this.mKeyPreRenderPool;
                    int size = keyPreRenderPool.size();
                    str2 = this.bid;
                    preMonitorReporter.reportPreRenderCreate(uri, "load_success", preRenderPoolSize, size, null, str2);
                    if (longRef.element > 0) {
                        mainHandler = this.getMainHandler();
                        final PoolKit poolKit = this;
                        final Uri uri2 = originSchema;
                        final String str3 = cacheKey;
                        mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.pool.PoolKit$preRender$1$onSuccess$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                IPreRenderConfig iPreRenderConfig2;
                                KeyPreRenderPool keyPreRenderPool2;
                                String str4;
                                PoolKit.this.remove(uri2, str3, EventConstants.PARAM_TIME_OUT);
                                PreMonitorReporter preMonitorReporter2 = PreMonitorReporter.INSTANCE;
                                Uri uri3 = uri2;
                                iPreRenderConfig2 = PoolKit.this.config;
                                int preRenderPoolSize2 = iPreRenderConfig2.getPreRenderPoolSize();
                                keyPreRenderPool2 = PoolKit.this.mKeyPreRenderPool;
                                int size2 = keyPreRenderPool2.size();
                                str4 = PoolKit.this.bid;
                                preMonitorReporter2.reportPreRenderClear(uri3, "timer", preRenderPoolSize2, size2, str4);
                            }
                        }, longRef.element);
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onFailed(PoolResult result, String errorMsg) {
                    IPreRenderConfig iPreRenderConfig;
                    KeyPreRenderPool keyPreRenderPool;
                    String str2;
                    Intrinsics.checkNotNullParameter(result, "result");
                    IPreRenderCallback.this.onFailed(result, errorMsg);
                    PreMonitorReporter preMonitorReporter = PreMonitorReporter.INSTANCE;
                    Uri uri = originSchema;
                    iPreRenderConfig = this.config;
                    int preRenderPoolSize = iPreRenderConfig.getPreRenderPoolSize();
                    keyPreRenderPool = this.mKeyPreRenderPool;
                    int size = keyPreRenderPool.size();
                    str2 = this.bid;
                    preMonitorReporter.reportPreRenderCreate(uri, "load_failed", preRenderPoolSize, size, errorMsg, str2);
                }
            }, preRenderOp);
        } else if (!z) {
            callback.onFailed(PoolResult.FAIL_INVALID, "prerender denied duration: " + duration + ", freeMemory: " + l);
        } else {
            IPreRenderCallback.DefaultImpls.onFailed$default(callback, PoolResult.FAIL_INVALID, str, 2, str);
        }
    }

    private final boolean prerenderAvailableCheck(Uri originSchema, Long freeMemory, String bid) {
        if (!getEnableBulletPrerenderGovern()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (freeMemory == null || freeMemory.longValue() >= getPreRenderMinFreeMemory()) {
            return true;
        }
        sb.append("freeMemory: " + freeMemory + ", limit: " + getPreRenderMinFreeMemory());
        PreMonitorReporter.INSTANCE.reportPreRenderCreate(originSchema, "load_denied", this.config.getPreRenderPoolSize(), this.mKeyPreRenderPool.size(), sb.toString(), bid);
        return false;
    }

    private final Long getFreeMemory() {
        try {
            Application application = BulletEnv.INSTANCE.getInstance().getApplication();
            if (application == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService = application.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return Long.valueOf(memoryInfo.availMem / PreloadV2Kt.M_MEM_SIZE);
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "getFreeMemory", message, null, null, 12, null);
            }
            return null;
        }
    }

    private final Uri getUniqueSchema(Uri originSchema) {
        Uri convert = this.mUniqueSchemaConvert.convert(originSchema);
        return convert == null ? originSchema : convert;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CacheItem fetch(Uri originSchema, boolean openPreRenderOpt, boolean openReUseOpt) {
        String queryParameterSafely;
        if (originSchema == null) {
            return null;
        }
        Uri uniqueSchema = getUniqueSchema(originSchema);
        String queryParameterSafely2 = RouterServiceKt.getQueryParameterSafely(originSchema, "url");
        if (queryParameterSafely2 != null) {
            Uri parse = Uri.parse(queryParameterSafely2);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(it)");
            queryParameterSafely = RouterServiceKt.getQueryParameterSafely(parse, "view_cache_key");
        }
        queryParameterSafely = RouterServiceKt.getQueryParameterSafely(originSchema, "view_cache_key");
        String str = queryParameterSafely;
        boolean z = false;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            CacheItem fetchPreRendered = fetchPreRendered(str);
            if (fetchPreRendered != null) {
                this.mEventObserver.onItemFetch(PoolUtilKt.transform(fetchPreRendered));
                PreMonitorReporter.INSTANCE.reportPreRenderFetch(originSchema, "success", this.config.getPreRenderPoolSize(), this.mKeyPreRenderPool.size(), str, this.bid);
                return fetchPreRendered;
            }
            PreMonitorReporter.INSTANCE.reportPreRenderFetch(originSchema, SccResult.MESSAGE_FAIL, this.config.getPreRenderPoolSize(), this.mKeyPreRenderPool.size(), str, this.bid);
        }
        CacheItem fetchReUsed = fetchReUsed(uniqueSchema);
        if (fetchReUsed != null) {
            this.mEventObserver.onItemFetch(PoolUtilKt.transform(fetchReUsed));
            return fetchReUsed;
        }
        this.mEventObserver.onItemFetch(new Event(originSchema, uniqueSchema, CacheType.NONE));
        return null;
    }

    private final CacheItem fetchPreRendered(String cacheKey) {
        CacheItem fetch = this.mKeyPreRenderPool.fetch(cacheKey);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "fetchPreRendered cache key: " + cacheKey + ", status: " + (fetch != null) + ", pool left: " + this.mKeyPreRenderPool.size(), null, "XPreRender", 2, null);
        return fetch;
    }

    private final CacheItem fetchReUsed(Uri uniqueSchema) {
        CacheItem fetch = this.mReUsePool.fetch(uniqueSchema);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "fetchReUsed uniqueSchema, status: " + (fetch != null) + ", pool left: " + this.mReUsePool.size(), null, "XPreRender", 2, null);
        return fetch;
    }

    public final PoolResult reUse(CacheItem cacheItem) {
        Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
        PoolResult reUse = this.mReUsePool.reUse(cacheItem);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "reUse result: " + reUse + " on originSchema: " + cacheItem.getOriginSchema() + ", uniqueSchema: " + cacheItem.getUniqueSchema() + ')', null, "XPreRender", 2, null);
        if (reUse == PoolResult.SUCCESS) {
            this.mEventObserver.onItemPut(PoolUtilKt.transform(cacheItem));
        }
        return reUse;
    }

    public static /* synthetic */ void resize$default(PoolKit poolKit, int i, CacheType cacheType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cacheType = CacheType.NONE;
        }
        poolKit.resize(i, cacheType);
    }

    public final void resize(int newSize, CacheType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.mReUsePool.resize(newSize);
            return;
        }
        if (i == 2) {
            this.mKeyPreRenderPool.resize(newSize);
        } else {
            if (i != 3) {
                return;
            }
            this.mReUsePool.resize(newSize);
            this.mKeyPreRenderPool.resize(newSize);
        }
    }

    public final PoolResult reUse(Uri originSchema, BulletContainerView containerView) {
        Intrinsics.checkNotNullParameter(originSchema, "originSchema");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        return reUse(new CacheItem(originSchema, getUniqueSchema(originSchema), containerView, CacheType.REUSE));
    }

    public final void clearCache(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.mKeyPreRenderPool.remove(cacheKey);
    }

    public final void remove(Uri originSchema, String cacheKey, String reason) {
        Intrinsics.checkNotNullParameter(originSchema, "originSchema");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        if (this.mKeyPreRenderPool.remove(cacheKey)) {
            IEventObserver iEventObserver = this.mEventObserver;
            Event event = new Event(originSchema, originSchema, CacheType.NONE);
            event.setCacheKey(cacheKey);
            JSONObject poolInfo = getPoolInfo(this.mKeyPreRenderPool.size(), this.mReUsePool.size());
            poolInfo.put(ISignalReportConstants.KEY_REASON, reason);
            Unit unit = Unit.INSTANCE;
            iEventObserver.onItemRemove(event, poolInfo);
        }
    }

    public static /* synthetic */ void clearAll$default(PoolKit poolKit, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        poolKit.clearAll(str);
    }

    public final void clearAll(String reason) {
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        int size = this.mKeyPreRenderPool.size();
        int size2 = this.mReUsePool.size();
        if (size2 > 0 || size > 0) {
            IEventObserver iEventObserver = this.mEventObserver;
            JSONObject poolInfo = getPoolInfo(size, size2);
            if (reason.length() > 0) {
                poolInfo.put(ISignalReportConstants.KEY_REASON, reason);
            }
            iEventObserver.onClearAll(poolInfo);
        }
        this.mKeyPreRenderPool.clearAll();
        this.mReUsePool.clearAll();
    }

    private final int prerenderRemainingSize() {
        return this.config.getPreRenderPoolSize() - this.mKeyPreRenderPool.size();
    }

    private final JSONObject getPoolInfo(int curPreRenderSize, int curReuseSize) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("prerender_pool_size", String.valueOf(curPreRenderSize));
        jSONObject.put("prerender_pool_max_size", String.valueOf(this.config.getPreRenderPoolSize()));
        jSONObject.put("reuse_pool_size", String.valueOf(curReuseSize));
        jSONObject.put("reuse_pool_max_size", String.valueOf(this.config.getReUsePoolSize()));
        return jSONObject;
    }
}
