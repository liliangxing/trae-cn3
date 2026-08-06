package com.bytedance.pia.core.setting;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.api.IPiaSettingsProvider;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.UrlUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/setting/ConfigProvider;", "Lcom/bytedance/pia/core/setting/Config$IProvider;", "()V", "INVALID_VALUE", "Lcom/bytedance/pia/core/setting/Config;", "cachedConfig", "Lkotlin/Pair;", "", "buildKey", "uri", "Landroid/net/Uri;", "contains", "", "provide", "updateDisableFeatures", "", "config", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ConfigProvider implements Config.IProvider {
    public static final ConfigProvider INSTANCE = new ConfigProvider();
    private static final Config INVALID_VALUE = new Config(null, null, null, false, 15, null);
    private static Pair<String, Config> cachedConfig;

    private ConfigProvider() {
    }

    @Override // com.bytedance.pia.core.setting.Config.IProvider
    public boolean contains(Uri uri) {
        return provide(uri) != null;
    }

    @Override // com.bytedance.pia.core.setting.Config.IProvider
    public synchronized Config provide(Uri uri) {
        if (uri == null) {
            return null;
        }
        String buildKey = buildKey(uri);
        String str = buildKey;
        if (str == null || str.length() == 0) {
            return null;
        }
        Pair<String, Config> pair = cachedConfig;
        if (pair != null && Intrinsics.areEqual(pair.getFirst(), buildKey)) {
            updateDisableFeatures((Config) pair.getSecond(), uri);
            return (Config) pair.getSecond();
        }
        IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
        Config config = settingsProvider != null ? (Config) settingsProvider.getValue(buildKey, Config.class, INVALID_VALUE) : null;
        if (config != null && !Intrinsics.areEqual(config, INVALID_VALUE)) {
            if (config.getEnabledFeatures().isEmpty()) {
                return null;
            }
            cachedConfig = TuplesKt.to(buildKey, config);
            updateDisableFeatures(config, uri);
            return config;
        }
        return null;
    }

    private final void updateDisableFeatures(Config config, Uri uri) {
        PIAConfig pIAConfig;
        Map<String, String[]> disableFeatures;
        String[] strArr;
        if (config == null || uri == null) {
            return;
        }
        IPiaSettingsProvider settingsProvider = PiaEnv.Default.getSettingsProvider();
        config.setDisableFeatures((settingsProvider == null || (pIAConfig = settingsProvider.getPIAConfig()) == null || (disableFeatures = pIAConfig.getDisableFeatures()) == null || (strArr = disableFeatures.get(new StringBuilder().append(uri.getHost()).append(uri.getPath()).toString())) == null) ? null : ArraysKt.toSet(strArr));
    }

    private final String buildKey(Uri uri) {
        if (!UrlUtils.isHttp(uri)) {
            return null;
        }
        boolean z = true;
        String match = Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getUrlMatcher().match(uri);
        String str = match;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            return match;
        }
        String authority = uri.getAuthority();
        String path = uri.getPath();
        if (TextUtils.isEmpty(authority) || TextUtils.isEmpty(path)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("pia_page/");
        String str2 = authority + path;
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (charAt == '-') {
                sb.append("--");
            } else if (charAt == '.') {
                sb.append('-');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
