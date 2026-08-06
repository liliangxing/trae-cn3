package com.bytedance.pia.core.tracing;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.apm.ApmAgent;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.pia.core.misc.CopyableInputStream;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnlineTracing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 J2\u00020\u0001:\u0005JKLMNB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u0003J\u001a\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u001a\u0010.\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u00020\fJ,\u00104\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010*J\u001c\u00108\u001a\u00020$2\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010:J\u0006\u0010;\u001a\u00020$J\u0018\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010?J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\nJ\u0016\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0003J\u000e\u0010E\u001a\u00020$2\u0006\u0010A\u001a\u00020\nJ\u000e\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020\nJ\u000e\u0010H\u001a\u00020$2\u0006\u0010A\u001a\u00020\nJ\u000e\u0010I\u001a\u00020$2\u0006\u0010A\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing;", "", "name", "", "(Ljava/lang/String;)V", "bootTime", "", "bootTimeoutRunnable", "Ljava/lang/Runnable;", "cacheStatus", "", "closeOnlineMonitor", "", "getCloseOnlineMonitor", "()Z", "closeOnlineMonitor$delegate", "Lkotlin/Lazy;", "dataTimeoutRunnable", "durations", "Ljava/util/concurrent/ConcurrentHashMap;", "", "extras", "htmlFlag", "htmlPreloadStatus", "isV2", "getName", "()Ljava/lang/String;", "navsTime", "nsrStatus", "piaMode", "piaVersion", "prefetchStatus", "snapshotStatus", "ssrStatus", "url", "addDuration", "", LynxTimingPerformanceReportProcessor.KEY_DURATION, "addDurationByTimestamp", "dealNSRStatus", "html", "configs", "Lcom/bytedance/pia/core/setting/Config;", "dealPiaMode", "dealPiaVersion", "dealSSRStatus", "dealSnapshotStatus", "handlerWorkerMessage", "jsonObject", "Lcom/google/gson/JsonObject;", "parseConfigs", "isCacheEnabled", "parseHTML", "copyableInputStream", "Lcom/bytedance/pia/core/misc/CopyableInputStream;", "encoding", "parseHeader", HeaderKeys.KEY_SSR_FALLBACK_HEADER, "", "reportMetrics", "setValid", "valid", "uri", "Landroid/net/Uri;", "updateCacheStatus", "status", "updateExtras", "key", "value", "updateHTMLPreloadStatus", "updatePrefetchProcess", "process", "updatePrefetchStatus", "updateSSRStatus", "Companion", "HTMLKeys", "HeaderKeys", "NativeMetricsKeys", "ReportKeys", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OnlineTracing {
    public static final long BOOT_TIMEOUT = 1000;
    public static final long DATA_TIMEOUT = 3000;
    public static final String MODE_CSR = "csr";
    public static final String MODE_SSR = "ssr";
    private long bootTime;
    private Runnable bootTimeoutRunnable;
    private int cacheStatus;

    /* renamed from: closeOnlineMonitor$delegate, reason: from kotlin metadata */
    private final Lazy closeOnlineMonitor;
    private Runnable dataTimeoutRunnable;
    private final ConcurrentHashMap<String, List<Long>> durations;
    private final ConcurrentHashMap<String, String> extras;
    private volatile boolean htmlFlag;
    private int htmlPreloadStatus;
    private boolean isV2;
    private final String name;
    private final long navsTime;
    private int nsrStatus;
    private String piaMode;
    private String piaVersion;
    private int prefetchStatus;
    private int snapshotStatus;
    private int ssrStatus;
    private String url;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> DURATION_WHILE_LIST = CollectionsKt.listOf(new String[]{"RD", "WRD", "PF", "FR3", "PPS", "LCP"});
    private static final LruCache<String, Long> navsByUrls = new LruCache<>(5);

    /* compiled from: OnlineTracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing$HTMLKeys;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class HTMLKeys {
        public static final String KEY_ENABLE_NSR = "window.use_pia_nsr = true";
        public static final String KEY_ENABLE_NSR_C = "window.use_pia_nsr=!0";
        public static final String KEY_ENABLE_SNAPSHOT = "window.use_pia_snapshot = true";
        public static final String KEY_ENABLE_SNAPSHOT_C = "window.use_pia_snapshot=!0";
        public static final String KEY_ENABLE_SSR = "window.use_pia_ssr = true";
        public static final String KEY_ENABLE_SSR_C = "window.use_pia_ssr!=0";
        public static final String KEY_USE_NSR = "window.pia_nsr_enable = true";
        public static final String KEY_USE_SNAPSHOT = "window.pia_snapshot_enable = true";
        public static final String KEY_USE_SSR = "script name=\"pia-ssr-data\"";
        public static final String KEY_USE_WARMUP = "window.pia_warmup_resources";
    }

    /* compiled from: OnlineTracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing$HeaderKeys;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class HeaderKeys {
        public static final String KEY_SSR_FALLBACK = "x-pia-ssr-fallback";
        public static final String KEY_SSR_FALLBACK_CUSTOM = "custom";
        public static final String KEY_SSR_FALLBACK_ERROR = "error";
        public static final String KEY_SSR_FALLBACK_HEADER = "header";
        public static final String KEY_SSR_FALLBACK_MIDDLEWARE = "middleware";
        public static final String KEY_SSR_FALLBACK_QUERY = "query";
    }

    /* compiled from: OnlineTracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing$NativeMetricsKeys;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class NativeMetricsKeys {
        public static final String KEY_NBF = "NBF";
        public static final String KEY_NDF = "NDF";
        public static final String KEY_NLS = "NLS";
        public static final String KEY_NPS = "NPS";
        public static final String KEY_NTF = "NTF";
    }

    /* compiled from: OnlineTracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing$ReportKeys;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ReportKeys {
        public static final String CT_MODE = "pia_mode";
        public static final String CT_URL = "url";
        public static final String CT_VERSION = "pia_version";
        public static final String NAME = "pia_online_monitor";
        public static final String ST_HTML_PRELOAD = "st_preload_html";
        public static final String ST_NSR = "st_nsr";
        public static final String ST_PREFETCH = "st_prefetch";
        public static final String ST_SNAPSHOT = "st_snapshot";
        public static final String ST_SSR = "st_ssr";
    }

    public OnlineTracing(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.closeOnlineMonitor = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.pia.core.tracing.OnlineTracing$closeOnlineMonitor$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m765invoke() {
                return Boolean.valueOf(!Settings.INSTANCE.openOnlineMonitor());
            }
        });
        this.cacheStatus = -1;
        this.piaVersion = "-1";
        this.piaMode = MODE_CSR;
        this.prefetchStatus = -1;
        this.snapshotStatus = -1;
        this.nsrStatus = -1;
        this.ssrStatus = -1;
        this.htmlPreloadStatus = -1;
        this.durations = new ConcurrentHashMap<>();
        this.extras = new ConcurrentHashMap<>();
        this.navsTime = INSTANCE.getNAVS(str);
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: OnlineTracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pia/core/tracing/OnlineTracing$Companion;", "", "()V", "BOOT_TIMEOUT", "", "DATA_TIMEOUT", "DURATION_WHILE_LIST", "", "", "getDURATION_WHILE_LIST", "()Ljava/util/List;", "MODE_CSR", "MODE_SSR", "navsByUrls", "Landroid/util/LruCache;", "getNAVS", "name", "putNAVS", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getDURATION_WHILE_LIST() {
            return OnlineTracing.DURATION_WHILE_LIST;
        }

        @JvmStatic
        public final synchronized void putNAVS(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            OnlineTracing.navsByUrls.put(name, Long.valueOf(System.currentTimeMillis()));
        }

        public final synchronized long getNAVS(String name) {
            Long l;
            Intrinsics.checkNotNullParameter(name, "name");
            l = (Long) OnlineTracing.navsByUrls.get(name);
            return l == null ? 0L : l.longValue();
        }
    }

    @JvmStatic
    public static final synchronized void putNAVS(String str) {
        synchronized (OnlineTracing.class) {
            INSTANCE.putNAVS(str);
        }
    }

    private final boolean getCloseOnlineMonitor() {
        return ((Boolean) this.closeOnlineMonitor.getValue()).booleanValue();
    }

    public final void setValid(boolean valid, Uri uri) {
        this.url = uri == null ? null : uri.getHost() + uri.getPath();
        this.isV2 = valid;
    }

    public final void addDuration(String name, long duration) {
        Intrinsics.checkNotNullParameter(name, "name");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = name.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        for (String str : DURATION_WHILE_LIST) {
            if (StringsKt.contains$default(upperCase, LibrarianImpl.Constants.DOT + str, false, 2, (Object) null)) {
                ArrayList arrayList = this.durations.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.durations.put(str, arrayList);
                }
                arrayList.add(Long.valueOf(duration));
            }
        }
    }

    public final void addDurationByTimestamp(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.navsTime > 0) {
            this.durations.put(name, CollectionsKt.mutableListOf(new Long[]{Long.valueOf(System.currentTimeMillis() - this.navsTime)}));
        }
    }

    public final void handlerWorkerMessage(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (!getCloseOnlineMonitor() && jsonObject.has("t")) {
            float asFloat = jsonObject.get("t").getAsFloat();
            boolean z = true;
            if (asFloat == 10.0f) {
                addDurationByTimestamp(NativeMetricsKeys.KEY_NBF);
                updatePrefetchProcess(1);
                return;
            }
            if (asFloat == 11.0f) {
                addDurationByTimestamp(NativeMetricsKeys.KEY_NDF);
                updatePrefetchProcess(2);
                try {
                    if (jsonObject.get("p").getAsJsonObject().get("response").getAsJsonObject().get("statusCode").getAsFloat() != 1.0f) {
                        z = false;
                    }
                    if (z) {
                        updatePrefetchStatus(0);
                    } else {
                        updatePrefetchStatus(8);
                    }
                } catch (Throwable unused) {
                    updatePrefetchStatus(8);
                }
            }
        }
    }

    public final void updateExtras(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.extras.put(key, value);
    }

    public final void updatePrefetchProcess(int process) {
        Runnable runnable;
        if (getCloseOnlineMonitor()) {
            return;
        }
        if (process == 0) {
            this.bootTime = System.currentTimeMillis();
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.pia.core.tracing.OnlineTracing$updatePrefetchProcess$1
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineTracing.this.prefetchStatus = 3;
                }
            };
            this.bootTimeoutRunnable = runnable2;
            Intrinsics.checkNotNull(runnable2);
            ThreadUtil.runOnPia(runnable2, 1000L);
            Runnable runnable3 = new Runnable() { // from class: com.bytedance.pia.core.tracing.OnlineTracing$updatePrefetchProcess$2
                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    i = OnlineTracing.this.prefetchStatus;
                    if (i != 3) {
                        OnlineTracing.this.prefetchStatus = 7;
                    }
                }
            };
            this.dataTimeoutRunnable = runnable3;
            Intrinsics.checkNotNull(runnable3);
            ThreadUtil.runOnPia(runnable3, DATA_TIMEOUT);
            return;
        }
        if (process != 1) {
            if (process == 2 && (runnable = this.dataTimeoutRunnable) != null) {
                ThreadUtil.cancelOnPia(runnable);
                return;
            }
            return;
        }
        Runnable runnable4 = this.bootTimeoutRunnable;
        if (runnable4 != null) {
            ThreadUtil.cancelOnPia(runnable4);
        }
    }

    public final void updateHTMLPreloadStatus(int status) {
        this.htmlPreloadStatus = status;
    }

    public final void updatePrefetchStatus(int status) {
        this.prefetchStatus = status;
    }

    public final void updateSSRStatus(int status) {
        this.ssrStatus = status;
    }

    public final void updateCacheStatus(int status) {
        this.cacheStatus = status;
        if (this.nsrStatus == -1) {
            this.nsrStatus = status;
        }
        if (this.snapshotStatus == -1) {
            this.snapshotStatus = status;
        }
    }

    public final void parseConfigs(Config configs, boolean isCacheEnabled) {
        if (configs != null) {
            if (!configs.isPrefetchEnabled()) {
                this.prefetchStatus = 1;
            }
            if (!configs.isNsrEnabled() || !isCacheEnabled) {
                this.nsrStatus = 1;
            }
            if (configs.isSnapshotEnabled() && isCacheEnabled) {
                return;
            }
            this.snapshotStatus = 1;
        }
    }

    public final void parseHeader(Map<String, String> header) {
        boolean z = false;
        if (header != null && header.containsKey(HeaderKeys.KEY_SSR_FALLBACK)) {
            z = true;
        }
        if (z) {
            if (Intrinsics.areEqual(header.get(HeaderKeys.KEY_SSR_FALLBACK), "query")) {
                this.ssrStatus = 11;
                return;
            }
            if (Intrinsics.areEqual(header.get(HeaderKeys.KEY_SSR_FALLBACK), "custom")) {
                this.ssrStatus = 15;
                return;
            }
            if (Intrinsics.areEqual(header.get(HeaderKeys.KEY_SSR_FALLBACK), HeaderKeys.KEY_SSR_FALLBACK_HEADER)) {
                this.ssrStatus = 12;
            } else if (Intrinsics.areEqual(header.get(HeaderKeys.KEY_SSR_FALLBACK), "error")) {
                this.ssrStatus = 13;
            } else if (Intrinsics.areEqual(header.get(HeaderKeys.KEY_SSR_FALLBACK), HeaderKeys.KEY_SSR_FALLBACK_MIDDLEWARE)) {
                this.ssrStatus = 14;
            }
        }
    }

    public final void parseHTML(final String html, final CopyableInputStream copyableInputStream, final String encoding, final Config configs) {
        Intrinsics.checkNotNullParameter(html, "html");
        if (getCloseOnlineMonitor() || this.htmlFlag) {
            return;
        }
        this.htmlFlag = true;
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.tracing.OnlineTracing$parseHTML$1
            @Override // java.lang.Runnable
            public final void run() {
                String str = html;
                if (copyableInputStream != null) {
                    try {
                        if (str.length() == 0) {
                            String parseHtml = HtmlPlugin.parseHtml(copyableInputStream, encoding);
                            Intrinsics.checkNotNullExpressionValue(parseHtml, "parseHtml(copyableInputStream, encoding)");
                            str = parseHtml;
                        } else {
                            copyableInputStream.close();
                        }
                    } catch (Throwable unused) {
                        Logger.e$default("online monitor read html error", null, null, 6, null);
                    }
                }
                this.dealSSRStatus(str);
                this.dealNSRStatus(str, configs);
                this.dealSnapshotStatus(str, configs);
                this.dealPiaVersion(str);
                this.dealPiaMode(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealSSRStatus(String html) {
        int i;
        String str = html;
        boolean contains$default = StringsKt.contains$default(str, HTMLKeys.KEY_USE_SSR, false, 2, (Object) null);
        boolean z = StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_SSR, false, 2, (Object) null) || StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_SSR_C, false, 2, (Object) null);
        if (z) {
            this.piaMode = MODE_SSR;
            if (this.ssrStatus == 3) {
                return;
            }
        } else {
            this.ssrStatus = 1;
        }
        if (contains$default && z) {
            this.ssrStatus = 0;
            return;
        }
        if (contains$default) {
            this.ssrStatus = 2;
        } else {
            if (!z || (i = this.ssrStatus) == 1 || i == -1) {
                return;
            }
            this.ssrStatus = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealNSRStatus(String html, Config configs) {
        int i;
        String str = html;
        boolean contains$default = StringsKt.contains$default(str, HTMLKeys.KEY_USE_NSR, false, 2, (Object) null);
        boolean z = StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_NSR, false, 2, (Object) null) || StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_NSR_C, false, 2, (Object) null);
        if (!z || this.cacheStatus < 0) {
            if (!(configs != null && configs.isNsrEnabled() == z)) {
                this.nsrStatus = 6;
                return;
            }
            if (contains$default && z) {
                this.nsrStatus = 0;
                return;
            }
            if (contains$default) {
                this.nsrStatus = 2;
            } else {
                if (!z || (i = this.ssrStatus) == 1 || i == -1) {
                    return;
                }
                this.nsrStatus = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealSnapshotStatus(String html, Config configs) {
        int i;
        int i2;
        String str = html;
        boolean contains$default = StringsKt.contains$default(str, HTMLKeys.KEY_USE_SNAPSHOT, false, 2, (Object) null);
        boolean z = StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_SNAPSHOT, false, 2, (Object) null) || StringsKt.contains$default(str, HTMLKeys.KEY_ENABLE_SNAPSHOT_C, false, 2, (Object) null);
        if (z && (i2 = this.cacheStatus) >= 0) {
            this.snapshotStatus = i2;
            return;
        }
        if (!(configs != null && configs.isSnapshotEnabled() == z)) {
            this.snapshotStatus = 6;
            return;
        }
        if (contains$default && z) {
            this.snapshotStatus = 0;
            return;
        }
        if (contains$default) {
            this.snapshotStatus = 2;
        } else {
            if (!z || (i = this.snapshotStatus) == 1 || i == -1) {
                return;
            }
            this.snapshotStatus = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealPiaVersion(String html) {
        List groupValues;
        String str;
        MatchResult find$default = Regex.find$default(new Regex("pia-version\\s*=\\s*\"([^\"]+)\""), html, 0, 2, (Object) null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) {
            return;
        }
        this.piaVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealPiaMode(String html) {
        List groupValues;
        String str;
        MatchResult find$default = Regex.find$default(new Regex("pia_ssr_mode\\s*=\\s*\"([^\"]+)\""), html, 0, 2, (Object) null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) {
            return;
        }
        this.piaMode = "ssr:" + str;
    }

    public final void reportMetrics() {
        if (getCloseOnlineMonitor()) {
            return;
        }
        String str = this.url;
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.isV2 || Intrinsics.areEqual(this.piaMode, MODE_SSR)) {
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.tracing.OnlineTracing$reportMetrics$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    String str3;
                    String str4;
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    int i5;
                    ConcurrentHashMap concurrentHashMap;
                    ConcurrentHashMap concurrentHashMap2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        str2 = OnlineTracing.this.url;
                        jSONObject.put("url", str2);
                        str3 = OnlineTracing.this.piaMode;
                        jSONObject.put(OnlineTracing.ReportKeys.CT_MODE, str3);
                        str4 = OnlineTracing.this.piaVersion;
                        jSONObject.put(OnlineTracing.ReportKeys.CT_VERSION, str4);
                        i = OnlineTracing.this.prefetchStatus;
                        jSONObject.put(OnlineTracing.ReportKeys.ST_PREFETCH, i);
                        i2 = OnlineTracing.this.nsrStatus;
                        jSONObject.put(OnlineTracing.ReportKeys.ST_NSR, i2);
                        i3 = OnlineTracing.this.snapshotStatus;
                        jSONObject.put(OnlineTracing.ReportKeys.ST_SNAPSHOT, i3);
                        i4 = OnlineTracing.this.ssrStatus;
                        jSONObject.put(OnlineTracing.ReportKeys.ST_SSR, i4);
                        i5 = OnlineTracing.this.htmlPreloadStatus;
                        jSONObject.put(OnlineTracing.ReportKeys.ST_HTML_PRELOAD, i5);
                        JSONObject jSONObject2 = new JSONObject();
                        concurrentHashMap = OnlineTracing.this.durations;
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            jSONObject2.put("dr_" + ((String) entry.getKey()), CollectionsKt.averageOfLong((Iterable) entry.getValue()));
                        }
                        concurrentHashMap2 = OnlineTracing.this.extras;
                        for (Map.Entry entry2 : concurrentHashMap2.entrySet()) {
                            jSONObject.put((String) entry2.getKey(), entry2.getValue());
                        }
                        ApmAgent.monitorEvent(OnlineTracing.ReportKeys.NAME, jSONObject, jSONObject2, (JSONObject) null);
                        JSONObject jSONObject3 = new JSONObject();
                        GsonUtils.INSTANCE.mergeJSONObject$anniex_release(jSONObject3, jSONObject);
                        GsonUtils.INSTANCE.mergeJSONObject$anniex_release(jSONObject3, jSONObject2);
                        Logger.w$default("PIA_REPORT: " + jSONObject3, null, null, 6, null);
                    } catch (JSONException e) {
                        Logger.e$default("pia online metrics report error", e, null, 4, null);
                    }
                }
            });
        }
    }
}
