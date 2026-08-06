package com.bytedance.lynx.service.settings;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.bytedance.lynx.service.settings.LynxSettingsDownloader;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: LynxSettingsDownloader.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001GB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\r\u00101\u001a\u00020\u0006H\u0001¢\u0006\u0002\b2J\b\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020\u0006H\u0002J\r\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7J\u0016\u00108\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\b\u00109\u001a\u00020-H\u0002JF\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u0002062\b\u0010<\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020/2\u0006\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010?\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020\u0006H\u0002J\u001a\u0010A\u001a\u00020-2\b\u0010?\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020\u0006H\u0002J>\u0010B\u001a\u00020-2\u0006\u0010;\u001a\u0002062\b\u0010<\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020/2\u0006\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020\u0006H\u0002J\b\u0010F\u001a\u000206H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u00020\u00158\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u001a8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u0006H"}, d2 = {"Lcom/bytedance/lynx/service/settings/LynxSettingsDownloader;", "", "()V", "DEFAULT_SETTINGS_INTERVAL", "", "DEFAULT_SETTINGS_RETRY_INTERVAL", "", "DEFAULT_SETTINGS_RETRY_TIME", "LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY", "", "LYNX_SETTINGS_FIRST_FETCH_INTERVAL_KEY", "LYNX_SETTINGS_LAST_SYNC_TIME_KEY", "LYNX_SETTINGS_UPDATE_IMMEDIATELY_EXPERIMENT_KEY", "ONE_DAY", "SP_LYNX_SETTINGS_DOWNLOADER_KEY", "TAG", "adapter", "Lcom/bytedance/lynx/service/settings/ILynxSettingsDownloaderAdapter;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "mHandler", "Landroid/os/Handler;", "getMHandler$LynxService_release$annotations", "getMHandler$LynxService_release", "()Landroid/os/Handler;", "mHasInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMHasInitialized$LynxService_release$annotations", "getMHasInitialized$LynxService_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "mRemainingRetryTimes", "mRunnable", "Ljava/lang/Runnable;", "getMRunnable$LynxService_release$annotations", "getMRunnable$LynxService_release", "()Ljava/lang/Runnable;", "setMRunnable$LynxService_release", "(Ljava/lang/Runnable;)V", "mSharedPreferences", "Landroid/content/SharedPreferences;", "getMSharedPreferences", "()Landroid/content/SharedPreferences;", "mSharedPreferences$delegate", "Lkotlin/Lazy;", "fetchSettings", "", EventConstants.PARAM_SOURCE, "Lcom/bytedance/lynx/service/settings/LynxSettingsDownloader$LynxSettingsSource;", "getSettingsFetchingInterval", "getTimeIntervalForFirstFetching", "getTimeIntervalForFirstFetching$LynxService_release", "getTimeIntervalForFirstFetchingFromSP", "getTimeIntervalForFirstFetchingFromSettings", "hasInitialized", "", "hasInitialized$LynxService_release", "initialize", "onDownloadFail", "onDownloadFinished", "succeed", "urlString", "errorCode", "errorMessage", "settingsString", "settingsTime", "onDownloadSuccess", "reportFetchEvent", "responseJsonString", "schedule", "timeInterval", "shouldFetchImmediately", "LynxSettingsSource", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxSettingsDownloader {
    private static final int DEFAULT_SETTINGS_INTERVAL = 1800000;
    private static final long DEFAULT_SETTINGS_RETRY_INTERVAL = 30000;
    private static final int DEFAULT_SETTINGS_RETRY_TIME = 3;
    private static final String LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY = "lynx_settings_experiment_update_timestamp";
    private static final String LYNX_SETTINGS_FIRST_FETCH_INTERVAL_KEY = "settings_first_fetch_interval";
    private static final String LYNX_SETTINGS_LAST_SYNC_TIME_KEY = "lynx_settings_last_sync_time";
    private static final String LYNX_SETTINGS_UPDATE_IMMEDIATELY_EXPERIMENT_KEY = "lynxsdk_update_settings_immediately";
    private static final long ONE_DAY = 86400000;
    private static final String SP_LYNX_SETTINGS_DOWNLOADER_KEY = "sp_lynx_settings_downloader";
    public static final String TAG = "LynxSettingsDownloader";
    private static ILynxSettingsDownloaderAdapter adapter;
    private static LynxServiceConfig lynxServiceConfig;
    private static Runnable mRunnable;
    public static final LynxSettingsDownloader INSTANCE = new LynxSettingsDownloader();
    private static final AtomicBoolean mHasInitialized = new AtomicBoolean(false);
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: mSharedPreferences$delegate, reason: from kotlin metadata */
    private static final Lazy mSharedPreferences = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$mSharedPreferences$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences m730invoke() {
            LynxServiceConfig lynxServiceConfig2;
            lynxServiceConfig2 = LynxSettingsDownloader.lynxServiceConfig;
            if (lynxServiceConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
                lynxServiceConfig2 = null;
            }
            return lynxServiceConfig2.getContext().getSharedPreferences("sp_lynx_settings_downloader", 0);
        }
    });
    private static int mRemainingRetryTimes = 3;

    public static /* synthetic */ void getMHandler$LynxService_release$annotations() {
    }

    public static /* synthetic */ void getMHasInitialized$LynxService_release$annotations() {
    }

    public static /* synthetic */ void getMRunnable$LynxService_release$annotations() {
    }

    private LynxSettingsDownloader() {
    }

    public final AtomicBoolean getMHasInitialized$LynxService_release() {
        return mHasInitialized;
    }

    public final Handler getMHandler$LynxService_release() {
        return mHandler;
    }

    public final Runnable getMRunnable$LynxService_release() {
        return mRunnable;
    }

    public final void setMRunnable$LynxService_release(Runnable runnable) {
        mRunnable = runnable;
    }

    private final SharedPreferences getMSharedPreferences() {
        Object value = mSharedPreferences.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LynxSettingsDownloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/lynx/service/settings/LynxSettingsDownloader$LynxSettingsSource;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "CUSTOM", "TIMER", "EXPERIMENT", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum LynxSettingsSource {
        CUSTOM("custom"),
        TIMER("timer"),
        EXPERIMENT("experiment");

        private final String description;

        LynxSettingsSource(String str) {
            this.description = str;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    public final boolean hasInitialized$LynxService_release() {
        return !mHasInitialized.compareAndSet(false, true);
    }

    public final void initialize(final LynxServiceConfig lynxServiceConfig2, final ILynxSettingsDownloaderAdapter adapter2) {
        Intrinsics.checkNotNullParameter(lynxServiceConfig2, "lynxServiceConfig");
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        if (hasInitialized$LynxService_release()) {
            LLog.e(TAG, "Already initialized");
        } else {
            new Thread(new Runnable() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LynxSettingsDownloader.m726initialize$lambda0(LynxServiceConfig.this, adapter2, this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initialize$lambda-0, reason: not valid java name */
    public static final void m726initialize$lambda0(LynxServiceConfig lynxServiceConfig2, ILynxSettingsDownloaderAdapter iLynxSettingsDownloaderAdapter, LynxSettingsDownloader lynxSettingsDownloader) {
        Intrinsics.checkNotNullParameter(lynxServiceConfig2, "$lynxServiceConfig");
        Intrinsics.checkNotNullParameter(iLynxSettingsDownloaderAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(lynxSettingsDownloader, "this$0");
        TraceEvent.beginSection(TraceEventDef.LYNX_SETTINGS_SCHEDULE);
        LynxSettingsManager.inst().initialize(lynxServiceConfig2.getContext());
        iLynxSettingsDownloaderAdapter.initLynxSettingsDownloaderAdapter(lynxServiceConfig2);
        if (!iLynxSettingsDownloaderAdapter.enabled()) {
            LLog.e(TAG, "adapter disabled settings fetch, adapter: " + iLynxSettingsDownloaderAdapter);
            TraceEvent.endSection(TraceEventDef.LYNX_SETTINGS_SCHEDULE);
            return;
        }
        lynxServiceConfig = lynxServiceConfig2;
        adapter = iLynxSettingsDownloaderAdapter;
        LynxSettingsDownloader lynxSettingsDownloader2 = INSTANCE;
        long timeIntervalForFirstFetching$LynxService_release = lynxSettingsDownloader2.getTimeIntervalForFirstFetching$LynxService_release();
        LLog.i(TAG, "Next fetch timeInterval: " + timeIntervalForFirstFetching$LynxService_release + ", adapter: " + iLynxSettingsDownloaderAdapter);
        if (timeIntervalForFirstFetching$LynxService_release <= 0) {
            lynxSettingsDownloader2.fetchSettings(LynxSettingsSource.CUSTOM);
        } else if (lynxSettingsDownloader2.shouldFetchImmediately()) {
            lynxSettingsDownloader2.fetchSettings(LynxSettingsSource.EXPERIMENT);
        } else {
            lynxSettingsDownloader2.schedule(timeIntervalForFirstFetching$LynxService_release);
        }
        TraceEvent.endSection(TraceEventDef.LYNX_SETTINGS_SCHEDULE);
    }

    public final long getTimeIntervalForFirstFetching$LynxService_release() {
        return Math.max(getTimeIntervalForFirstFetchingFromSettings(), getTimeIntervalForFirstFetchingFromSP());
    }

    private final long getTimeIntervalForFirstFetchingFromSettings() {
        String stringValueForTrailKey;
        Long longOrNull;
        ILynxTrailService service = LynxServiceCenter.inst().getService(ILynxTrailService.class);
        if (service == null || (stringValueForTrailKey = service.stringValueForTrailKey(LYNX_SETTINGS_FIRST_FETCH_INTERVAL_KEY)) == null || (longOrNull = StringsKt.toLongOrNull(stringValueForTrailKey)) == null) {
            return 0L;
        }
        return longOrNull.longValue();
    }

    private final long getTimeIntervalForFirstFetchingFromSP() {
        long j;
        try {
            j = getMSharedPreferences().getLong(LYNX_SETTINGS_LAST_SYNC_TIME_KEY, 0L);
        } catch (ClassCastException e) {
            LLog.e(TAG, "Read lastSyncTime failed: " + e);
            j = 0;
        }
        if (j == 0) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j >= currentTimeMillis) {
            return 0L;
        }
        return 1800000 - (currentTimeMillis - j);
    }

    private final boolean shouldFetchImmediately() {
        long j;
        ILynxTrailService service = LynxServiceCenter.inst().getService(ILynxTrailService.class);
        String stringValueForTrailKey = service != null ? service.stringValueForTrailKey(LYNX_SETTINGS_UPDATE_IMMEDIATELY_EXPERIMENT_KEY) : null;
        if (stringValueForTrailKey == null) {
            return false;
        }
        if (stringValueForTrailKey.length() == 0) {
            return false;
        }
        long parseLong = Long.parseLong(stringValueForTrailKey);
        try {
            j = getMSharedPreferences().getLong(LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY, 0L);
        } catch (ClassCastException unused) {
            j = 0;
        }
        if (parseLong < 0) {
            getMSharedPreferences().edit().putLong(LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY, parseLong).apply();
            if (j < 0) {
                return false;
            }
        } else {
            if (parseLong <= j) {
                return false;
            }
            getMSharedPreferences().edit().putLong(LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY, parseLong).apply();
        }
        return true;
    }

    private final void schedule(long timeInterval) {
        Runnable runnable = mRunnable;
        if (runnable != null) {
            mHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                LynxSettingsDownloader.m728schedule$lambda3();
            }
        };
        mRunnable = runnable2;
        mHandler.postDelayed(runnable2, timeInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: schedule$lambda-3, reason: not valid java name */
    public static final void m728schedule$lambda3() {
        new Thread(new Runnable() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LynxSettingsDownloader.m729schedule$lambda3$lambda2();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: schedule$lambda-3$lambda-2, reason: not valid java name */
    public static final void m729schedule$lambda3$lambda2() {
        INSTANCE.fetchSettings(LynxSettingsSource.TIMER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDownloadFinished(boolean succeed, String urlString, LynxSettingsSource source, int errorCode, String errorMessage, String settingsString, long settingsTime) {
        TraceEvent.instant(1L, TraceEventDef.LYNX_SETTINGS_FETCH_FINISH);
        reportFetchEvent(succeed, urlString, source, errorCode, errorMessage, settingsString);
        if (succeed) {
            onDownloadSuccess(settingsString, settingsTime);
        } else {
            onDownloadFail();
        }
    }

    private final void onDownloadSuccess(String settingsString, long settingsTime) {
        TraceEvent.instant(1L, TraceEventDef.LYNX_SETTINGS_FETCH_UPDATE);
        if (settingsString != null) {
            LLog.i(TAG, "Will update settings: " + settingsString);
            LynxSettingsManager.inst().setSettingsWithTime(settingsString, settingsTime);
            getMSharedPreferences().edit().putLong(LYNX_SETTINGS_LAST_SYNC_TIME_KEY, System.currentTimeMillis()).apply();
        }
        mRemainingRetryTimes = 3;
        schedule(getSettingsFetchingInterval());
    }

    private final long getSettingsFetchingInterval() {
        return Random.Default.nextLong(86400000L, 259200000L);
    }

    private final void onDownloadFail() {
        LLog.e(TAG, "Download settings failed");
        int i = mRemainingRetryTimes;
        if (i > 0) {
            mRemainingRetryTimes = i - 1;
            schedule(30000L);
        } else {
            mRemainingRetryTimes = 3;
            schedule(getSettingsFetchingInterval());
        }
    }

    private final void fetchSettings(final LynxSettingsSource source) {
        TraceEvent.instant(1L, TraceEventDef.LYNX_SETTINGS_FETCH_ENTER);
        ILynxSettingsDownloaderAdapter iLynxSettingsDownloaderAdapter = adapter;
        if (iLynxSettingsDownloaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            iLynxSettingsDownloaderAdapter = null;
        }
        iLynxSettingsDownloaderAdapter.fetchSettings(new Function6<Boolean, String, Integer, String, String, Long, Unit>() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$fetchSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(6);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke(((Boolean) obj).booleanValue(), (String) obj2, ((Number) obj3).intValue(), (String) obj4, (String) obj5, ((Number) obj6).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, String str, int i, String str2, String str3, long j) {
                LynxSettingsDownloader.INSTANCE.onDownloadFinished(z, str, LynxSettingsDownloader.LynxSettingsSource.this, i, str2, str3, j);
            }
        });
    }

    private final void reportFetchEvent(final boolean succeed, final String urlString, final LynxSettingsSource source, final int errorCode, final String errorMessage, final String responseJsonString) {
        final String str;
        String str2 = "";
        try {
            str = String.valueOf(getMSharedPreferences().getLong(LYNX_SETTINGS_LAST_SYNC_TIME_KEY, 0L));
        } catch (ClassCastException unused) {
            str = "";
        }
        try {
            str2 = String.valueOf(getMSharedPreferences().getLong(LYNX_SETTINGS_EXPERIMENT_UPDATE_TIMESTAMP_KEY, 0L));
        } catch (ClassCastException unused2) {
        }
        final String str3 = str2;
        LynxEventReporter.onEvent("lynxsdk_settings_fetch_event", -1, new LynxEventReporter.PropsBuilder() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$$ExternalSyntheticLambda0
            public final Map build() {
                Map m727reportFetchEvent$lambda7;
                m727reportFetchEvent$lambda7 = LynxSettingsDownloader.m727reportFetchEvent$lambda7(LynxSettingsDownloader.LynxSettingsSource.this, str, str3, urlString, succeed, errorCode, errorMessage, responseJsonString);
                return m727reportFetchEvent$lambda7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.bytedance.lynx.service.settings.LynxSettingsDownloader$reportFetchEvent$1$lynxCommonMap$type$1] */
    /* renamed from: reportFetchEvent$lambda-7, reason: not valid java name */
    public static final Map m727reportFetchEvent$lambda7(LynxSettingsSource lynxSettingsSource, String str, String str2, String str3, boolean z, int i, String str4, String str5) {
        List split$default;
        Intrinsics.checkNotNullParameter(lynxSettingsSource, "$source");
        Intrinsics.checkNotNullParameter(str, "$lastCheckTime");
        Intrinsics.checkNotNullParameter(str2, "$lastExperimentUpdateTimestamp");
        HashMap hashMap = new HashMap();
        hashMap.put("base_source", lynxSettingsSource.getDescription());
        hashMap.put("base_current_time", String.valueOf(System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError));
        hashMap.put("base_last_check_time", str);
        LynxServiceConfig lynxServiceConfig2 = lynxServiceConfig;
        Map map = null;
        if (lynxServiceConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
            lynxServiceConfig2 = null;
        }
        hashMap.put("base_app_id", lynxServiceConfig2.getAppId());
        hashMap.put("base_experiment_update_timestamp", str2);
        URL url = new URL(str3);
        String host = url.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "url.host");
        hashMap.put("request_host", host);
        String protocol = url.getProtocol();
        Intrinsics.checkNotNullExpressionValue(protocol, "url.protocol");
        hashMap.put("request_scheme", protocol);
        String path = url.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "url.path");
        hashMap.put("request_path", path);
        String query = url.getQuery();
        if (query != null && (split$default = StringsKt.split$default(query, new String[]{"&"}, false, 0, 6, (Object) null)) != null) {
            List list = split$default;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                List split$default2 = StringsKt.split$default((String) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
                Pair pair = TuplesKt.to((String) split$default2.get(0), (String) split$default2.get(1));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                hashMap.put("request_query_" + ((String) entry.getKey()), (String) entry.getValue());
            }
        }
        hashMap.put("response_succeed", z ? "1" : ViewVisibleBridge.INVISIBLE);
        hashMap.put("response_error_code", String.valueOf(i));
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("response_error_domain", str4);
        hashMap.put("response_json", str5 != null ? str5 : "");
        if (str5 != null) {
            try {
                map = (Map) new Gson().fromJson(new JsonParser().parse(str5).getAsJsonObject().getAsJsonObject("data").getAsJsonObject(ErrorType.SETTINGS).getAsJsonObject("lynx_common"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.bytedance.lynx.service.settings.LynxSettingsDownloader$reportFetchEvent$1$lynxCommonMap$type$1
                }.getType());
            } catch (Throwable th) {
                LLog.e(TAG, "report fetch event parse error: " + th);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        return hashMap;
    }
}
