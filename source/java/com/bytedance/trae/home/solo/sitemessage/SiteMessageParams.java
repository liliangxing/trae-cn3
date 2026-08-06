package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.utils.LocaleManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eJ(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;", "", "<init>", "()V", "version", "", "getVersion", "()Ljava/lang/String;", "platform", "types", "getTypes", SettingsTracker.TYPE_LANGUAGE, "getLanguage", "buildCountParams", "", "buildQueryParams", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageParams {
    public static final int $stable = 0;
    public static final SiteMessageParams INSTANCE = new SiteMessageParams();
    public static final String platform = "Android";

    private SiteMessageParams() {
    }

    public final String getVersion() {
        return AppHost.INSTANCE.getVersionName();
    }

    public final String getTypes() {
        return SiteMessagePreferencesCache.INSTANCE.getEnabledTypes();
    }

    public final String getLanguage() {
        String effectiveLanguage = LocaleManager.INSTANCE.getEffectiveLanguage();
        return StringsKt.startsWith$default(effectiveLanguage, "zh", false, 2, (Object) null) ? "zh-cn" : StringsKt.startsWith$default(effectiveLanguage, "ja", false, 2, (Object) null) ? "ja" : "en";
    }

    public final Map<String, String> buildCountParams() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("version", getVersion()), TuplesKt.to("platform", platform), TuplesKt.to(SettingsTracker.TYPE_LANGUAGE, getLanguage()), TuplesKt.to("storeCountryCode", SiteMessagePreferencesCache.INSTANCE.getStoreCountryCode())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map buildQueryParams$default(SiteMessageParams siteMessageParams, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return siteMessageParams.buildQueryParams(map);
    }

    public final Map<String, String> buildQueryParams(Map<String, String> extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("version", getVersion()), TuplesKt.to("platform", platform), TuplesKt.to("types", getTypes()), TuplesKt.to(SettingsTracker.TYPE_LANGUAGE, getLanguage()), TuplesKt.to("storeCountryCode", SiteMessagePreferencesCache.INSTANCE.getStoreCountryCode())});
        mutableMapOf.putAll(extra);
        return mutableMapOf;
    }
}
