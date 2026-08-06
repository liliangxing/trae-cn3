package com.bytedance.trae.kmp.network;

import com.bytedance.trae.kmp.host.KmpHostInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: KmpHostResolver.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHostResolver;", "", "<init>", "()V", "hostMap", "", "Lcom/bytedance/trae/kmp/network/KmpHostType;", "Lcom/bytedance/trae/kmp/network/KmpHostEntry;", "overrideProvider", "Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;", "configure", "", "map", "baseUrlOverrideProvider", "host", "", "type", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "baseUrl", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpHostResolver {
    private static KmpBaseUrlOverrideProvider overrideProvider;
    public static final KmpHostResolver INSTANCE = new KmpHostResolver();
    private static Map<KmpHostType, KmpHostEntry> hostMap = MapsKt.emptyMap();
    public static final int $stable = 8;

    private KmpHostResolver() {
    }

    public static /* synthetic */ void configure$default(KmpHostResolver kmpHostResolver, Map map, KmpBaseUrlOverrideProvider kmpBaseUrlOverrideProvider, int i, Object obj) {
        if ((i & 2) != 0) {
            kmpBaseUrlOverrideProvider = null;
        }
        kmpHostResolver.configure(map, kmpBaseUrlOverrideProvider);
    }

    public final void configure(Map<KmpHostType, KmpHostEntry> map, KmpBaseUrlOverrideProvider baseUrlOverrideProvider) {
        Intrinsics.checkNotNullParameter(map, "map");
        hostMap = MapsKt.toMap(map);
        overrideProvider = baseUrlOverrideProvider;
    }

    public final String host(KmpHostType type, KmpHostInfo hostInfo) {
        KmpDomainList publicUser;
        String str;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(hostInfo, "hostInfo");
        KmpHostEntry kmpHostEntry = hostMap.get(type);
        if (kmpHostEntry == null) {
            return "";
        }
        if (hostInfo.isEnterprise()) {
            if (hostInfo.isEnterpriseBoe()) {
                publicUser = kmpHostEntry.getEnterpriseBoeUser();
                if (publicUser == null && (publicUser = kmpHostEntry.getEnterpriseUser()) == null) {
                    publicUser = kmpHostEntry.getPublicUser();
                }
            } else {
                publicUser = kmpHostEntry.getEnterpriseUser();
                if (publicUser == null) {
                    publicUser = kmpHostEntry.getPublicUser();
                }
            }
        } else if (hostInfo.isByteCloud()) {
            publicUser = kmpHostEntry.getBytecloudUser();
            if (publicUser == null) {
                publicUser = kmpHostEntry.getPublicUser();
            }
        } else {
            publicUser = kmpHostEntry.getPublicUser();
        }
        return (publicUser.getRegions().isEmpty() || (str = publicUser.getRegions().get(KmpAiRegion.INSTANCE.from(hostInfo.getAiRegion()))) == null) ? publicUser.getNormal() : str;
    }

    public final String baseUrl(KmpHostType type, KmpHostInfo hostInfo) {
        String overrideBaseUrlOrNull;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(hostInfo, "hostInfo");
        KmpBaseUrlOverrideProvider kmpBaseUrlOverrideProvider = overrideProvider;
        if (kmpBaseUrlOverrideProvider != null && (overrideBaseUrlOrNull = kmpBaseUrlOverrideProvider.overrideBaseUrlOrNull(type)) != null) {
            return overrideBaseUrlOrNull;
        }
        String host = host(type, hostInfo);
        return StringsKt.isBlank(host) ? "" : "https://" + host + '/';
    }
}
