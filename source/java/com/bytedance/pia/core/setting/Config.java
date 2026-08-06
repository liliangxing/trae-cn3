package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Config.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u0000 \"2\u00020\u0001:\u0002\"#B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\u0004H\u0016R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/pia/core/setting/Config;", "", "expectedFeatures", "", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "streaming", "isFromMock", "", "(Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Z)V", "disableFeatures", "getDisableFeatures", "()Ljava/util/Set;", "setDisableFeatures", "(Ljava/util/Set;)V", "enabledFeatures", "getEnabledFeatures", "enabledFeatures$delegate", "Lkotlin/Lazy;", "getExpectedFeatures", "()Z", "getStreaming", "()Ljava/lang/String;", "getVersion", "enableFeaturesValid", "isCacheEnabled", "isEmptyForV1", "isManifestCacheEnabled", "isNsrEnabled", "isPrefetchEnabled", "isPreloadEnabled", "isSnapshotEnabled", "isStreamingEnabled", "toString", "Companion", "IProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Config {
    private static IProvider proxy;

    @GsonUtils.Exclude
    private Set<String> disableFeatures;

    /* renamed from: enabledFeatures$delegate, reason: from kotlin metadata */
    @GsonUtils.Exclude
    private final Lazy enabledFeatures;

    @SerializedName("features")
    private final Set<String> expectedFeatures;

    @SerializedName("isMocked")
    private final boolean isFromMock;

    @SerializedName("streaming")
    private final String streaming;

    @SerializedName(IPiaCacheProvider.CacheConfig.FIELD_VERSION)
    private final String version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Config EMPTY_VALUE = new Config(null, null, null, false, 15, null);
    private static final Config DISABLE_SETTINGS_VALUE = new Config(SetsKt.setOf(new String[]{ErrorType.PREFETCH, "nsr", ErrorType.SNAPSHOT, "cache", "streaming", ResourceInfo.RESOURCE_FROM_PRELOAD}), null, null, false, 14, null);

    /* compiled from: Config.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/setting/Config$IProvider;", "", "contains", "", "uri", "Landroid/net/Uri;", "provide", "Lcom/bytedance/pia/core/setting/Config;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IProvider {
        boolean contains(Uri uri);

        Config provide(Uri uri);
    }

    public Config() {
        this(null, null, null, false, 15, null);
    }

    @JvmStatic
    public static final boolean contains(Uri uri) {
        return INSTANCE.contains(uri);
    }

    @JvmStatic
    public static final Config createDefault() {
        return INSTANCE.createDefault();
    }

    @JvmStatic
    public static final Config createEmptyForV1() {
        return INSTANCE.createEmptyForV1();
    }

    @JvmStatic
    public static final Config get(Uri uri) {
        return INSTANCE.get(uri);
    }

    @JvmStatic
    public static final IProvider getProxy() {
        return INSTANCE.getProxy();
    }

    @JvmStatic
    public static final void setProxy(IProvider iProvider) {
        INSTANCE.setProxy(iProvider);
    }

    public Config(Set<String> set, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(set, "expectedFeatures");
        Intrinsics.checkNotNullParameter(str, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkNotNullParameter(str2, "streaming");
        this.expectedFeatures = set;
        this.version = str;
        this.streaming = str2;
        this.isFromMock = z;
        this.enabledFeatures = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.bytedance.pia.core.setting.Config$enabledFeatures$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Set<String> invoke() {
                if (Config.this.getIsFromMock()) {
                    return Config.this.getExpectedFeatures();
                }
                return CollectionsKt.intersect(Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getEnabledFeatures(), Config.this.getExpectedFeatures());
            }
        });
    }

    public /* synthetic */ Config(Set set, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? false : z);
    }

    public final Set<String> getExpectedFeatures() {
        return this.expectedFeatures;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getStreaming() {
        return this.streaming;
    }

    /* renamed from: isFromMock, reason: from getter */
    public final boolean getIsFromMock() {
        return this.isFromMock;
    }

    public final Set<String> getEnabledFeatures() {
        return (Set) this.enabledFeatures.getValue();
    }

    public final Set<String> getDisableFeatures() {
        return this.disableFeatures;
    }

    public final void setDisableFeatures(Set<String> set) {
        this.disableFeatures = set;
    }

    private final Set<String> enableFeaturesValid() {
        Set<String> set = this.disableFeatures;
        if (set == null || set.isEmpty()) {
            return getEnabledFeatures();
        }
        Set<String> enabledFeatures = getEnabledFeatures();
        Set<String> set2 = this.disableFeatures;
        Intrinsics.checkNotNull(set2);
        return SetsKt.minus(enabledFeatures, set2);
    }

    public final boolean isPrefetchEnabled() {
        return enableFeaturesValid().contains(ErrorType.PREFETCH);
    }

    public final boolean isNsrEnabled() {
        return enableFeaturesValid().contains("nsr");
    }

    public final boolean isSnapshotEnabled() {
        return enableFeaturesValid().contains(ErrorType.SNAPSHOT);
    }

    public final boolean isCacheEnabled() {
        return enableFeaturesValid().contains("cache");
    }

    public final boolean isPreloadEnabled() {
        return enableFeaturesValid().contains(ResourceInfo.RESOURCE_FROM_PRELOAD);
    }

    public final boolean isStreamingEnabled() {
        if (enableFeaturesValid().contains("streaming")) {
            return this.streaming.length() > 0;
        }
        return false;
    }

    public final boolean isManifestCacheEnabled() {
        return this.version.length() > 0;
    }

    public final boolean isEmptyForV1() {
        return Intrinsics.areEqual(this, EMPTY_VALUE);
    }

    public String toString() {
        String json = GsonUtils.getGson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }

    /* compiled from: Config.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pia/core/setting/Config$Companion;", "", "()V", "DISABLE_SETTINGS_VALUE", "Lcom/bytedance/pia/core/setting/Config;", "EMPTY_VALUE", "proxy", "Lcom/bytedance/pia/core/setting/Config$IProvider;", "getProxy$annotations", "contains", "", "uri", "Landroid/net/Uri;", "createDefault", "createEmptyForV1", PrefetchRequestConfig.METHOD_GET, "getProxy", "setProxy", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getProxy$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final Config createDefault() {
            return new Config(SetsKt.setOf(ErrorType.PREFETCH), null, null, false, 14, null);
        }

        @JvmStatic
        public final boolean contains(Uri uri) {
            IProvider iProvider = Config.proxy;
            if ((iProvider == null || iProvider.provide(uri) == null) && Settings.INSTANCE.isSettingsEnabled() && ConfigProvider.INSTANCE.provide(uri) == null) {
                return SettingService.INSTANCE.contains(uri);
            }
            return true;
        }

        @JvmStatic
        public final Config get(Uri uri) {
            Config provide;
            IProvider iProvider = Config.proxy;
            if (iProvider != null && (provide = iProvider.provide(uri)) != null) {
                return provide;
            }
            if (uri == null) {
                return null;
            }
            boolean z = false;
            if (!uri.getBooleanQueryParameter("_pia_", false) && uri.getBooleanQueryParameter(PiaRuntime.SCHEMA_V1, false)) {
                z = true;
            }
            if (!z && !Settings.INSTANCE.isSettingsEnabled()) {
                return Config.DISABLE_SETTINGS_VALUE;
            }
            Config provide2 = ConfigProvider.INSTANCE.provide(uri);
            return provide2 != null ? provide2 : SettingService.INSTANCE.provide(uri);
        }

        @JvmStatic
        public final Config createEmptyForV1() {
            return Config.EMPTY_VALUE;
        }

        @JvmStatic
        public final void setProxy(IProvider proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Config.proxy = proxy;
        }

        @JvmStatic
        public final IProvider getProxy() {
            return Config.proxy;
        }
    }
}
