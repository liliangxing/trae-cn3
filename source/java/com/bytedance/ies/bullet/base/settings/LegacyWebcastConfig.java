package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "", "()V", "domainWhiteList", "", "", "getDomainWhiteList", "()Ljava/util/List;", "setDomainWhiteList", "(Ljava/util/List;)V", "domainWhiteMap", "", "", "getDomainWhiteMap", "()Ljava/util/Map;", "domainWhiteMap$delegate", "Lkotlin/Lazy;", "enable", "", "getEnable", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LegacyWebcastConfig {

    @SerializedName("enable")
    private final boolean enable = true;

    @SerializedName("domain_white_list")
    private List<String> domainWhiteList = CollectionsKt.emptyList();

    /* renamed from: domainWhiteMap$delegate, reason: from kotlin metadata */
    private final Lazy domainWhiteMap = LazyKt.lazy(new Function0<Map<String, ? extends Integer>>() { // from class: com.bytedance.ies.bullet.base.settings.LegacyWebcastConfig$domainWhiteMap$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        public final Map<String, Integer> invoke() {
            List<String> domainWhiteList = LegacyWebcastConfig.this.getDomainWhiteList();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(domainWhiteList, 10)), 16));
            for (Object obj : domainWhiteList) {
                linkedHashMap.put(obj, 1);
            }
            return linkedHashMap;
        }
    });

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getDomainWhiteList() {
        return this.domainWhiteList;
    }

    public final void setDomainWhiteList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.domainWhiteList = list;
    }

    public final Map<String, Integer> getDomainWhiteMap() {
        return (Map) this.domainWhiteMap.getValue();
    }
}
