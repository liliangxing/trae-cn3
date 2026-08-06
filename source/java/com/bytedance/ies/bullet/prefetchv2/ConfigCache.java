package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/ConfigCache;", "", "()V", "configCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "configCacheByIdentifier", "getBySchemaUri", "uri", "Landroid/net/Uri;", "getConfigByIdentifier", "identifier", "getConfigKeyBySchemaUri", "bid", "put", "", "config", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ConfigCache {
    public static final ConfigCache INSTANCE = new ConfigCache();
    private static final ConcurrentHashMap<String, PrefetchConfig> configCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, PrefetchConfig> configCacheByIdentifier = new ConcurrentHashMap<>();

    private ConfigCache() {
    }

    public static /* synthetic */ void put$default(ConfigCache configCache2, Uri uri, PrefetchConfig prefetchConfig, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "default_bid";
        }
        configCache2.put(uri, prefetchConfig, str);
    }

    public final void put(Uri uri, PrefetchConfig config, String bid) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bid, "bid");
        String configKeyBySchemaUri$default = getConfigKeyBySchemaUri$default(this, uri, null, 2, null);
        PrefetchLogger.INSTANCE.m36d("Put config cache by url: " + uri + ", configKey: " + configKeyBySchemaUri$default);
        configCache.put(configKeyBySchemaUri$default, config);
        String generateIdentifierBySchemaUri = ExtKt.generateIdentifierBySchemaUri(uri, bid);
        PrefetchLogger.INSTANCE.m36d("Put config cache by identifier: " + generateIdentifierBySchemaUri);
        configCacheByIdentifier.put(generateIdentifierBySchemaUri, config);
    }

    public final PrefetchConfig getBySchemaUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String configKeyBySchemaUri$default = getConfigKeyBySchemaUri$default(this, uri, null, 2, null);
        PrefetchConfig prefetchConfig = configCache.get(configKeyBySchemaUri$default);
        PrefetchLogger.INSTANCE.m36d("Get config cache by schema uri: " + uri + ", configKey: " + configKeyBySchemaUri$default + ", config: " + prefetchConfig);
        return prefetchConfig;
    }

    public final PrefetchConfig getConfigByIdentifier(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        PrefetchConfig prefetchConfig = configCacheByIdentifier.get(identifier);
        PrefetchLogger.INSTANCE.m36d("Get config cache by identifier: " + identifier + ", config: " + prefetchConfig);
        return prefetchConfig;
    }

    static /* synthetic */ String getConfigKeyBySchemaUri$default(ConfigCache configCache2, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        return configCache2.getConfigKeyBySchemaUri(uri, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if ((r2 == null || r2.length() == 0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getConfigKeyBySchemaUri(Uri uri, String bid) {
        String cdn = ExtKt.getCDN(uri, bid);
        String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, PrefetchSchemaParam.PREFETCH_CHANNEL);
        String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, PrefetchSchemaParam.PREFETCH_BUNDLE);
        String str = safeGetQueryParameter;
        if (!(str == null || str.length() == 0)) {
            String str2 = safeGetQueryParameter2;
        }
        safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "channel");
        safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, SchemaConstants.QUERY_KEY_BUNDLE);
        return (cdn != null ? ConfigLoaderKt.suffixReplace(cdn, InternalConfigLoader.CONFIG_FILE_NAME) : null) + '_' + safeGetQueryParameter + '_' + (safeGetQueryParameter2 != null ? ConfigLoaderKt.bundleReplace(safeGetQueryParameter2, InternalConfigLoader.CONFIG_FILE_NAME) : null) + '_' + ExtKt.safeGetQueryParameter(uri, PrefetchSchemaParam.PREFETCH_ACCESS_KEY);
    }
}
