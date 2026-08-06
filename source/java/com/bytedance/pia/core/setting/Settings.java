package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.pia.core.api.IPiaSettingsProvider;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.misc.UrlMatcher;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.SampleUtils;
import com.bytedance.pia.core.utils.UrlUtils;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: Settings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0001FBÿ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010D\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010E\u001a\u00020\u000bH\u0016R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030 8FX\u0087\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010&R\u0016\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030 8FX\u0087\u0084\u0002¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b,\u0010\"R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u00100R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u00100R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00100R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00100R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00100R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u00100R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00100R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00100R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00100R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u00100R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u00100R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u00100R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u00100R\u0016\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b038BX\u0083\u0084\u0002¢\u0006\f\n\u0004\b6\u0010$\u001a\u0004\b4\u00105R!\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0083\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b8\u00109R\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u001b\u0010<\u001a\u00020=8FX\u0087\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\b>\u0010?R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/pia/core/setting/Settings;", "", "isPiaEnabled", "", "isBootEnabled", "isCacheEnabled", "isWorkerEnabled", "isVanillaFetchEnabled", "isWarmupEnabled", "allowedDomains", "", "", "htmlInterceptTimeout", "", "enabledFeatures", "", "pageStorageCapacity", "streamingInterceptTimeout", "blockedPages", "urlRules", "isPiaQueryDisable", "isMustFinishWarmup", "isUrlCompatV2Enabled", "isNsrV1Enabled", "isPrefetchV1Enabled", "isSnapshotV1Enabled", "blockedV1Page", "isCreateRuntimeWaitEnable", "createRuntimeWaitInternal", "", "(ZZZZZZLjava/util/List;ILjava/util/Set;IILjava/util/List;Ljava/util/List;ZZZZZZLjava/util/List;ZJ)V", "base", "", "getBase", "()Ljava/util/Map;", "base$delegate", "Lkotlin/Lazy;", "getBlockedV1Page$annotations", "()V", "getCreateRuntimeWaitInternal", "()J", "getEnabledFeatures", "()Ljava/util/Set;", "features", "getFeatures", "features$delegate", "getHtmlInterceptTimeout", "()I", "()Z", "getPageStorageCapacity", "safeAllowedDomain", "", "getSafeAllowedDomain", "()Ljava/util/Collection;", "safeAllowedDomain$delegate", "safeBlockedPages", "getSafeBlockedPages", "()Ljava/util/List;", "safeBlockedPages$delegate", "getStreamingInterceptTimeout", "urlMatcher", "Lcom/bytedance/pia/core/misc/UrlMatcher;", "getUrlMatcher", "()Lcom/bytedance/pia/core/misc/UrlMatcher;", "urlMatcher$delegate", "isDomainAllowed", "uri", "Landroid/net/Uri;", "isPageBlocked", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Settings {
    private static final String SETTINGS_KEY = "pia_global_config";
    private static volatile Settings cachedSettings;

    @SerializedName("allow_domains")
    private final List<String> allowedDomains;

    /* renamed from: base$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy base;

    @SerializedName("blocked_pages")
    private final List<String> blockedPages;

    @SerializedName("blocked_pages_v1")
    private final List<String> blockedV1Page;

    @SerializedName("create_runtime_wait_internal")
    private final long createRuntimeWaitInternal;

    @SerializedName("features")
    private final Set<String> enabledFeatures;

    /* renamed from: features$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy features;

    @SerializedName("html_intercept_timeout")
    private final int htmlInterceptTimeout;

    @SerializedName(ErrorType.BOOT)
    private final boolean isBootEnabled;

    @SerializedName("cache")
    private final boolean isCacheEnabled;

    @SerializedName("create_runtime_wait")
    private final boolean isCreateRuntimeWaitEnable;

    @SerializedName("experiment_must_finish_warmup")
    private final boolean isMustFinishWarmup;

    @SerializedName("nsr_v1")
    private final boolean isNsrV1Enabled;

    @SerializedName("main")
    private final boolean isPiaEnabled;

    @SerializedName("experiment_disable_pia_query")
    private final boolean isPiaQueryDisable;

    @SerializedName("prefetch_v1")
    private final boolean isPrefetchV1Enabled;

    @SerializedName("snapshot_v1")
    private final boolean isSnapshotV1Enabled;

    @SerializedName("enable_add_cache_key")
    private final boolean isUrlCompatV2Enabled;

    @SerializedName("vanilla_fetch")
    private final boolean isVanillaFetchEnabled;

    @SerializedName("warmup")
    private final boolean isWarmupEnabled;

    @SerializedName(ErrorType.WORKER)
    private final boolean isWorkerEnabled;

    @SerializedName("page_storage_capacity")
    private final int pageStorageCapacity;

    /* renamed from: safeAllowedDomain$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy safeAllowedDomain;

    /* renamed from: safeBlockedPages$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy safeBlockedPages;

    @SerializedName("streaming_intercept_timeout")
    private final int streamingInterceptTimeout;

    /* renamed from: urlMatcher$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy urlMatcher;

    @SerializedName("url_rules")
    private final List<String> urlRules;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Settings> DEFAULT_SETTINGS$delegate = LazyKt.lazy(new Function0<Settings>() { // from class: com.bytedance.pia.core.setting.Settings$Companion$DEFAULT_SETTINGS$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Settings m758invoke() {
            return new Settings(false, false, false, false, false, false, null, 0, null, 0, 0, null, null, false, false, false, false, false, false, null, false, 0L, 4194303, null);
        }
    });
    private static final Lazy<Settings> DISABLED_SETTINGS$delegate = LazyKt.lazy(new Function0<Settings>() { // from class: com.bytedance.pia.core.setting.Settings$Companion$DISABLED_SETTINGS$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Settings m759invoke() {
            return new Settings(false, false, false, false, false, false, CollectionsKt.listOf(UrlMatcher.WILDCARD), 0, null, 0, 0, null, null, true, false, false, true, true, true, null, false, 0L, 3727295, null);
        }
    });
    private static volatile boolean isSettingsEnabled = true;

    public Settings() {
        this(false, false, false, false, false, false, null, 0, null, 0, 0, null, null, false, false, false, false, false, false, null, false, 0L, 4194303, null);
    }

    @JvmStatic
    public static final void enableSettings(boolean z) {
        INSTANCE.enableSettings(z);
    }

    @JvmStatic
    public static final Settings get() {
        return INSTANCE.get();
    }

    @JvmStatic
    public static final Settings get(boolean z) {
        return INSTANCE.get(z);
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "blockedPages", imports = {}))
    private static /* synthetic */ void getBlockedV1Page$annotations() {
    }

    @JvmStatic
    public static final boolean inOpenManifestCacheSample() {
        return INSTANCE.inOpenManifestCacheSample();
    }

    @JvmStatic
    public static final boolean isOpenManifestCachePage(String str) {
        return INSTANCE.isOpenManifestCachePage(str);
    }

    @JvmStatic
    public static final boolean openCancelUselessWarmup() {
        return INSTANCE.openCancelUselessWarmup();
    }

    @JvmStatic
    public static final boolean openDefaultResourcePreload() {
        return INSTANCE.openDefaultResourcePreload();
    }

    @JvmStatic
    public static final boolean openManifestCache(String str) {
        return INSTANCE.openManifestCache(str);
    }

    @JvmStatic
    public static final boolean openOnlineMonitor() {
        return INSTANCE.openOnlineMonitor();
    }

    @JvmStatic
    public static final boolean openParseLink() {
        return INSTANCE.openParseLink();
    }

    public Settings(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List<String> list, int i, Set<String> set, int i2, int i3, List<String> list2, List<String> list3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, List<String> list4, boolean z13, long j) {
        Intrinsics.checkNotNullParameter(list, "allowedDomains");
        Intrinsics.checkNotNullParameter(set, "enabledFeatures");
        Intrinsics.checkNotNullParameter(list2, "blockedPages");
        Intrinsics.checkNotNullParameter(list3, "urlRules");
        Intrinsics.checkNotNullParameter(list4, "blockedV1Page");
        this.isPiaEnabled = z;
        this.isBootEnabled = z2;
        this.isCacheEnabled = z3;
        this.isWorkerEnabled = z4;
        this.isVanillaFetchEnabled = z5;
        this.isWarmupEnabled = z6;
        this.allowedDomains = list;
        this.htmlInterceptTimeout = i;
        this.enabledFeatures = set;
        this.pageStorageCapacity = i2;
        this.streamingInterceptTimeout = i3;
        this.blockedPages = list2;
        this.urlRules = list3;
        this.isPiaQueryDisable = z7;
        this.isMustFinishWarmup = z8;
        this.isUrlCompatV2Enabled = z9;
        this.isNsrV1Enabled = z10;
        this.isPrefetchV1Enabled = z11;
        this.isSnapshotV1Enabled = z12;
        this.blockedV1Page = list4;
        this.isCreateRuntimeWaitEnable = z13;
        this.createRuntimeWaitInternal = j;
        this.base = LazyKt.lazy(new Function0<Map<String, ? extends Boolean>>() { // from class: com.bytedance.pia.core.setting.Settings$base$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<String, Boolean> invoke() {
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("main", Boolean.valueOf(Settings.this.getIsPiaEnabled())), TuplesKt.to(ErrorType.BOOT, Boolean.valueOf(Settings.this.getIsBootEnabled())), TuplesKt.to(ErrorType.WORKER, Boolean.valueOf(Settings.this.getIsWorkerEnabled())), TuplesKt.to("cache", Boolean.valueOf(Settings.this.getIsCacheEnabled()))});
            }
        });
        this.features = LazyKt.lazy(new Function0<Map<String, ? extends Boolean>>() { // from class: com.bytedance.pia.core.setting.Settings$features$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<String, Boolean> invoke() {
                List listOf = CollectionsKt.listOf(new String[]{ErrorType.PREFETCH, "nsr", ErrorType.SNAPSHOT, "cache", "streaming", ResourceInfo.RESOURCE_FROM_PRELOAD});
                Settings settings = Settings.this;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
                for (Object obj : listOf) {
                    linkedHashMap.put(obj, Boolean.valueOf(settings.getEnabledFeatures().contains((String) obj)));
                }
                return linkedHashMap;
            }
        });
        this.safeAllowedDomain = LazyKt.lazy(new Function0<Collection<? extends String>>() { // from class: com.bytedance.pia.core.setting.Settings$safeAllowedDomain$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Collection<String> invoke() {
                List list5;
                List list6;
                list5 = Settings.this.allowedDomains;
                if (!list5.contains(UrlMatcher.WILDCARD)) {
                    list6 = Settings.this.allowedDomains;
                    List<String> list7 = list6;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                    for (String str : list7) {
                        if (!StringsKt.startsWith$default(str, '.', false, 2, (Object) null)) {
                            str = LibrarianImpl.Constants.DOT + str;
                        }
                        arrayList.add(str);
                    }
                    return arrayList;
                }
                return SetsKt.setOf(UrlMatcher.WILDCARD);
            }
        });
        this.safeBlockedPages = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.bytedance.pia.core.setting.Settings$safeBlockedPages$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<String> invoke() {
                List list5;
                List list6;
                list5 = Settings.this.blockedPages;
                list6 = Settings.this.blockedV1Page;
                return CollectionsKt.plus(list5, list6);
            }
        });
        this.urlMatcher = LazyKt.lazy(new Function0<UrlMatcher>() { // from class: com.bytedance.pia.core.setting.Settings$urlMatcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final UrlMatcher m764invoke() {
                List list5;
                UrlMatcher urlMatcher = new UrlMatcher();
                list5 = Settings.this.urlRules;
                Iterator it = list5.iterator();
                while (it.hasNext()) {
                    urlMatcher.addRule((String) it.next());
                }
                return urlMatcher;
            }
        });
    }

    /* renamed from: isPiaEnabled, reason: from getter */
    public final boolean getIsPiaEnabled() {
        return this.isPiaEnabled;
    }

    /* renamed from: isBootEnabled, reason: from getter */
    public final boolean getIsBootEnabled() {
        return this.isBootEnabled;
    }

    /* renamed from: isCacheEnabled, reason: from getter */
    public final boolean getIsCacheEnabled() {
        return this.isCacheEnabled;
    }

    /* renamed from: isWorkerEnabled, reason: from getter */
    public final boolean getIsWorkerEnabled() {
        return this.isWorkerEnabled;
    }

    /* renamed from: isVanillaFetchEnabled, reason: from getter */
    public final boolean getIsVanillaFetchEnabled() {
        return this.isVanillaFetchEnabled;
    }

    /* renamed from: isWarmupEnabled, reason: from getter */
    public final boolean getIsWarmupEnabled() {
        return this.isWarmupEnabled;
    }

    public /* synthetic */ Settings(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List list, int i, Set set, int i2, int i3, List list2, List list3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, List list4, boolean z13, long j, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? true : z, (i4 & 2) != 0 ? true : z2, (i4 & 4) != 0 ? true : z3, (i4 & 8) != 0 ? true : z4, (i4 & 16) != 0 ? true : z5, (i4 & 32) == 0 ? z6 : true, (i4 & 64) != 0 ? CollectionsKt.emptyList() : list, (i4 & 128) != 0 ? 20 : i, (i4 & 256) != 0 ? SetsKt.setOf(new String[]{ErrorType.PREFETCH, "nsr", ErrorType.SNAPSHOT, "cache", "streaming", ResourceInfo.RESOURCE_FROM_PRELOAD}) : set, (i4 & 512) != 0 ? 500 : i2, (i4 & 1024) != 0 ? 5 : i3, (i4 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 4096) != 0 ? CollectionsKt.emptyList() : list3, (i4 & 8192) != 0 ? false : z7, (i4 & 16384) != 0 ? false : z8, (i4 & 32768) != 0 ? false : z9, (i4 & ArtifactRepository.IO_CHUNK_SIZE) != 0 ? false : z10, (i4 & 131072) != 0 ? false : z11, (i4 & 262144) != 0 ? false : z12, (i4 & 524288) != 0 ? CollectionsKt.emptyList() : list4, (i4 & PreloadV2Kt.M_MEM_SIZE) != 0 ? false : z13, (i4 & 2097152) != 0 ? 200L : j);
    }

    public final int getHtmlInterceptTimeout() {
        return this.htmlInterceptTimeout;
    }

    public final Set<String> getEnabledFeatures() {
        return this.enabledFeatures;
    }

    public final int getPageStorageCapacity() {
        return this.pageStorageCapacity;
    }

    public final int getStreamingInterceptTimeout() {
        return this.streamingInterceptTimeout;
    }

    /* renamed from: isPiaQueryDisable, reason: from getter */
    public final boolean getIsPiaQueryDisable() {
        return this.isPiaQueryDisable;
    }

    /* renamed from: isMustFinishWarmup, reason: from getter */
    public final boolean getIsMustFinishWarmup() {
        return this.isMustFinishWarmup;
    }

    /* renamed from: isUrlCompatV2Enabled, reason: from getter */
    public final boolean getIsUrlCompatV2Enabled() {
        return this.isUrlCompatV2Enabled;
    }

    /* renamed from: isNsrV1Enabled, reason: from getter */
    public final boolean getIsNsrV1Enabled() {
        return this.isNsrV1Enabled;
    }

    /* renamed from: isPrefetchV1Enabled, reason: from getter */
    public final boolean getIsPrefetchV1Enabled() {
        return this.isPrefetchV1Enabled;
    }

    /* renamed from: isSnapshotV1Enabled, reason: from getter */
    public final boolean getIsSnapshotV1Enabled() {
        return this.isSnapshotV1Enabled;
    }

    /* renamed from: isCreateRuntimeWaitEnable, reason: from getter */
    public final boolean getIsCreateRuntimeWaitEnable() {
        return this.isCreateRuntimeWaitEnable;
    }

    public final long getCreateRuntimeWaitInternal() {
        return this.createRuntimeWaitInternal;
    }

    public final Map<String, Boolean> getBase() {
        return (Map) this.base.getValue();
    }

    public final Map<String, Boolean> getFeatures() {
        return (Map) this.features.getValue();
    }

    private final Collection<String> getSafeAllowedDomain() {
        return (Collection) this.safeAllowedDomain.getValue();
    }

    private final List<String> getSafeBlockedPages() {
        return (List) this.safeBlockedPages.getValue();
    }

    public final UrlMatcher getUrlMatcher() {
        return (UrlMatcher) this.urlMatcher.getValue();
    }

    public final boolean isDomainAllowed(Uri uri) {
        if (!isSettingsEnabled) {
            return true;
        }
        if (!this.isPiaEnabled || getSafeAllowedDomain().isEmpty()) {
            return false;
        }
        if (getSafeAllowedDomain().contains(UrlMatcher.WILDCARD)) {
            return true;
        }
        if (uri == null || !UrlUtils.isHttp(uri)) {
            return false;
        }
        Collection<String> safeAllowedDomain = getSafeAllowedDomain();
        if (!(safeAllowedDomain instanceof Collection) || !safeAllowedDomain.isEmpty()) {
            Iterator<T> it = safeAllowedDomain.iterator();
            while (it.hasNext()) {
                if (StringsKt.endsWith$default(LibrarianImpl.Constants.DOT + uri.getHost(), (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isPageBlocked(Uri uri) {
        String path;
        if (!isSettingsEnabled) {
            return false;
        }
        if (uri == null || !this.isPiaEnabled || !UrlUtils.isHttp(uri)) {
            return true;
        }
        if (getSafeBlockedPages().isEmpty()) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || (path = uri.getPath()) == null) {
            return true;
        }
        String str = host + path;
        List<String> safeBlockedPages = getSafeBlockedPages();
        if ((safeBlockedPages instanceof Collection) && safeBlockedPages.isEmpty()) {
            return false;
        }
        Iterator<T> it = safeBlockedPages.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default(str, (String) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PiaSettings(enabled=" + isSettingsEnabled + "): " + GsonUtils.getGson().toJson(this);
    }

    /* compiled from: Settings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0007J\b\u0010\u0016\u001a\u00020\u0010H\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\rH\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0019\u001a\u00020\u0010H\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\rH\u0007J\b\u0010\u001c\u001a\u00020\u0010H\u0007J\b\u0010\u001d\u001a\u00020\u0010H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/pia/core/setting/Settings$Companion;", "", "()V", "DEFAULT_SETTINGS", "Lcom/bytedance/pia/core/setting/Settings;", "getDEFAULT_SETTINGS", "()Lcom/bytedance/pia/core/setting/Settings;", "DEFAULT_SETTINGS$delegate", "Lkotlin/Lazy;", "DISABLED_SETTINGS", "getDISABLED_SETTINGS", "DISABLED_SETTINGS$delegate", "SETTINGS_KEY", "", "cachedSettings", "isSettingsEnabled", "", "enableSettings", "", "enable", PrefetchRequestConfig.METHOD_GET, "canUseCache", "inOpenManifestCacheSample", "isOpenManifestCachePage", "url", "openCancelUselessWarmup", "openDefaultResourcePreload", "openManifestCache", "openOnlineMonitor", "openParseLink", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Settings get() {
            return get$default(this, false, 1, null);
        }

        private Companion() {
        }

        private final Settings getDEFAULT_SETTINGS() {
            return (Settings) Settings.DEFAULT_SETTINGS$delegate.getValue();
        }

        private final Settings getDISABLED_SETTINGS() {
            return (Settings) Settings.DISABLED_SETTINGS$delegate.getValue();
        }

        public static /* synthetic */ Settings get$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.get(z);
        }

        @JvmStatic
        public final Settings get(boolean canUseCache) {
            if (Settings.isSettingsEnabled) {
                Settings settings = Settings.cachedSettings;
                if (canUseCache && settings != null && !Intrinsics.areEqual(settings, getDEFAULT_SETTINGS())) {
                    return settings;
                }
                IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
                Settings settings2 = settingsProvider != null ? (Settings) settingsProvider.getValue(Settings.SETTINGS_KEY, Settings.class, getDEFAULT_SETTINGS()) : null;
                if (settings2 == null) {
                    settings2 = getDEFAULT_SETTINGS();
                }
                Settings.cachedSettings = settings2;
                return settings2;
            }
            return getDISABLED_SETTINGS();
        }

        public static /* synthetic */ void enableSettings$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            companion.enableSettings(z);
        }

        @JvmStatic
        public final void enableSettings(boolean enable) {
            Settings.isSettingsEnabled = enable;
        }

        public final boolean isSettingsEnabled() {
            return Settings.isSettingsEnabled;
        }

        @JvmStatic
        public final boolean openOnlineMonitor() {
            PIAConfig pIAConfig;
            Boolean openOnlineMonitor;
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            if (settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openOnlineMonitor = pIAConfig.getOpenOnlineMonitor()) == null) {
                return true;
            }
            return openOnlineMonitor.booleanValue();
        }

        @JvmStatic
        public final boolean inOpenManifestCacheSample() {
            PIAConfig pIAConfig;
            Integer openManifestCacheInt;
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            return SampleUtils.sample((settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openManifestCacheInt = pIAConfig.getOpenManifestCacheInt()) == null) ? 5000 : openManifestCacheInt.intValue(), "openManifestCacheInt");
        }

        @JvmStatic
        public final boolean isOpenManifestCachePage(String url) {
            PIAConfig pIAConfig;
            List<String> openManifestCachePages;
            Intrinsics.checkNotNullParameter(url, "url");
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            if (settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openManifestCachePages = pIAConfig.getOpenManifestCachePages()) == null) {
                return false;
            }
            return openManifestCachePages.contains(url);
        }

        @JvmStatic
        public final boolean openManifestCache(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return inOpenManifestCacheSample() && isOpenManifestCachePage(url);
        }

        @JvmStatic
        public final boolean openCancelUselessWarmup() {
            PIAConfig pIAConfig;
            Boolean openCancelUselessWarmup;
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            if (settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openCancelUselessWarmup = pIAConfig.getOpenCancelUselessWarmup()) == null) {
                return true;
            }
            return openCancelUselessWarmup.booleanValue();
        }

        @JvmStatic
        public final boolean openDefaultResourcePreload() {
            PIAConfig pIAConfig;
            Boolean openDefaultResourcePreload;
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            if (settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openDefaultResourcePreload = pIAConfig.getOpenDefaultResourcePreload()) == null) {
                return true;
            }
            return openDefaultResourcePreload.booleanValue();
        }

        @JvmStatic
        public final boolean openParseLink() {
            PIAConfig pIAConfig;
            Boolean openParseLink;
            IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
            if (settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (openParseLink = pIAConfig.getOpenParseLink()) == null) {
                return true;
            }
            return openParseLink.booleanValue();
        }
    }
}
