package com.bytedance.trae.network;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0006J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/network/HostResolver;", "", "<init>", "()V", "hostMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/network/HostType;", "Lcom/bytedance/trae/network/HostEntry;", "loginContextProvider", "Lcom/bytedance/trae/network/LoginContextProvider;", EventConstants.PARAM_SOURCE_INIT, "", "map", "", "setLoginContextProvider", "provider", "isBytecloudLogin", "", "isEnterpriseLogin", "getHost", "", "type", "getEntry", "getAllHosts", "", "getBaseUrl", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HostResolver {
    public static final HostResolver INSTANCE = new HostResolver();
    private static final ConcurrentHashMap<HostType, HostEntry> hostMap = new ConcurrentHashMap<>();
    private static volatile LoginContextProvider loginContextProvider;

    private HostResolver() {
    }

    public final void init(Map<HostType, HostEntry> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        ConcurrentHashMap<HostType, HostEntry> concurrentHashMap = hostMap;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(map);
    }

    public final void setLoginContextProvider(LoginContextProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        loginContextProvider = provider;
    }

    public final boolean isBytecloudLogin() {
        LoginContextProvider loginContextProvider2 = loginContextProvider;
        return loginContextProvider2 != null && loginContextProvider2.isBytecloudLogin();
    }

    public final boolean isEnterpriseLogin() {
        LoginContextProvider loginContextProvider2 = loginContextProvider;
        return loginContextProvider2 != null && loginContextProvider2.isEnterpriseLogin();
    }

    public final String getHost(HostType type) {
        DomainList publicUser;
        Intrinsics.checkNotNullParameter(type, "type");
        HostEntry hostEntry = hostMap.get(type);
        if (hostEntry == null) {
            return "";
        }
        LoginContextProvider loginContextProvider2 = loginContextProvider;
        if (loginContextProvider2 != null && loginContextProvider2.isEnterpriseLogin()) {
            if (loginContextProvider2.isEnterpriseBoeEnv()) {
                publicUser = hostEntry.getEnterpriseBoeUser();
                if (publicUser == null && (publicUser = hostEntry.getEnterpriseUser()) == null) {
                    publicUser = hostEntry.getPublicUser();
                }
            } else {
                publicUser = hostEntry.getEnterpriseUser();
                if (publicUser == null) {
                    publicUser = hostEntry.getPublicUser();
                }
            }
        } else if (loginContextProvider2 == null || !loginContextProvider2.isBytecloudLogin()) {
            publicUser = hostEntry.getPublicUser();
        } else {
            publicUser = hostEntry.getBytecloudUser();
            if (publicUser == null) {
                publicUser = hostEntry.getPublicUser();
            }
        }
        if (publicUser.getRegions().isEmpty()) {
            return publicUser.getNormal();
        }
        String str = publicUser.getRegions().get(loginContextProvider2 != null ? loginContextProvider2.getAiRegion() : AiRegion.f140CN);
        return str == null ? publicUser.getNormal() : str;
    }

    public final HostEntry getEntry(HostType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return hostMap.get(type);
    }

    public final Set<String> getAllHosts(HostType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        HostEntry hostEntry = hostMap.get(type);
        if (hostEntry == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(hostEntry.getPublicUser().getNormal());
        linkedHashSet.addAll(hostEntry.getPublicUser().getRegions().values());
        DomainList bytecloudUser = hostEntry.getBytecloudUser();
        if (bytecloudUser != null) {
            linkedHashSet.add(bytecloudUser.getNormal());
            linkedHashSet.addAll(bytecloudUser.getRegions().values());
        }
        DomainList enterpriseUser = hostEntry.getEnterpriseUser();
        if (enterpriseUser != null) {
            linkedHashSet.add(enterpriseUser.getNormal());
            linkedHashSet.addAll(enterpriseUser.getRegions().values());
        }
        DomainList enterpriseBoeUser = hostEntry.getEnterpriseBoeUser();
        if (enterpriseBoeUser != null) {
            linkedHashSet.add(enterpriseBoeUser.getNormal());
            linkedHashSet.addAll(enterpriseBoeUser.getRegions().values());
        }
        return linkedHashSet;
    }

    public final String getBaseUrl(HostType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String overrideBaseUrlOrNull = E2ENetworkOverrides.INSTANCE.overrideBaseUrlOrNull();
        return overrideBaseUrlOrNull != null ? overrideBaseUrlOrNull : "https://" + getHost(type) + '/';
    }
}
