package com.bytedance.trae.kmp.network;

import com.bytedance.trae.network.AiRegion;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.DomainList;
import com.bytedance.trae.network.E2ENetworkOverrides;
import com.bytedance.trae.network.HostEntry;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpHttpClientFactory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\f\u0010\u000b\u001a\u00020\f*\u00020\tH\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\nH\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;", "", "<init>", "()V", "configureFromNativeHostResolver", "", "configure", "map", "", "Lcom/bytedance/trae/network/HostType;", "Lcom/bytedance/trae/network/HostEntry;", "toKmpHostType", "Lcom/bytedance/trae/kmp/network/KmpHostType;", "toKmpHostEntry", "Lcom/bytedance/trae/kmp/network/KmpHostEntry;", "toKmpDomainList", "Lcom/bytedance/trae/kmp/network/KmpDomainList;", "Lcom/bytedance/trae/network/DomainList;", "NOTIFICATION_BOE_BASE_URL", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpHostResolverBridge {
    public static final int $stable = 0;
    public static final AndroidKmpHostResolverBridge INSTANCE = new AndroidKmpHostResolverBridge();
    private static final String NOTIFICATION_BOE_BASE_URL = "https://icube-boe-api.bytedance.net/";

    /* compiled from: AndroidKmpHttpClientFactory.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HostType.values().length];
            try {
                iArr[HostType.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HostType.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HostType.f144AI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HostType.REMOTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HostType.IMAGEX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HostType.MSSDK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HostType.PASSPORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HostType.SETTINGS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[HostType.PRAISE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[HostType.NOTIFICATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[HostType.MARKETPLACE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[HostType.WEBSITE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[HostType.DOCS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[HostType.COMMUNITY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[HostType.PLUGIN_WEB.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AiRegion.values().length];
            try {
                iArr2[AiRegion.f140CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[AiRegion.f141SG.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[AiRegion.f142US.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AndroidKmpHostResolverBridge() {
    }

    public final void configureFromNativeHostResolver() {
        Iterable<HostType> entries = HostType.getEntries();
        ArrayList arrayList = new ArrayList();
        for (HostType hostType : entries) {
            HostEntry entry = HostResolver.INSTANCE.getEntry(hostType);
            Pair pair = entry != null ? TuplesKt.to(hostType, entry) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        configure(MapsKt.toMap(arrayList));
    }

    public final void configure(Map<HostType, HostEntry> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        KmpHostResolver kmpHostResolver = KmpHostResolver.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(INSTANCE.toKmpHostType((HostType) entry.getKey()), entry.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), INSTANCE.toKmpHostEntry((HostEntry) entry2.getValue()));
        }
        kmpHostResolver.configure(linkedHashMap2, new KmpBaseUrlOverrideProvider() { // from class: com.bytedance.trae.kmp.network.AndroidKmpHostResolverBridge$$ExternalSyntheticLambda0
            @Override // com.bytedance.trae.kmp.network.KmpBaseUrlOverrideProvider
            public final String overrideBaseUrlOrNull(KmpHostType kmpHostType) {
                String configure$lambda$4;
                configure$lambda$4 = AndroidKmpHostResolverBridge.configure$lambda$4(kmpHostType);
                return configure$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String configure$lambda$4(KmpHostType kmpHostType) {
        Intrinsics.checkNotNullParameter(kmpHostType, "hostType");
        String overrideBaseUrlOrNull = E2ENetworkOverrides.INSTANCE.overrideBaseUrlOrNull();
        if (overrideBaseUrlOrNull != null) {
            return overrideBaseUrlOrNull;
        }
        if (kmpHostType == KmpHostType.Notification && DebugSettings.INSTANCE.getNotificationBoe()) {
            return NOTIFICATION_BOE_BASE_URL;
        }
        return null;
    }

    private final KmpHostType toKmpHostType(HostType hostType) {
        switch (WhenMappings.$EnumSwitchMapping$0[hostType.ordinal()]) {
            case 1:
                return KmpHostType.Online;
            case 2:
                return KmpHostType.Login;
            case 3:
                return KmpHostType.f127Ai;
            case 4:
                return KmpHostType.Remote;
            case 5:
                return KmpHostType.Imagex;
            case 6:
                return KmpHostType.Mssdk;
            case 7:
                return KmpHostType.Passport;
            case 8:
                return KmpHostType.Settings;
            case 9:
                return KmpHostType.Praise;
            case 10:
                return KmpHostType.Notification;
            case 11:
                return KmpHostType.Marketplace;
            case 12:
                return KmpHostType.Website;
            case 13:
                return KmpHostType.Docs;
            case 14:
                return KmpHostType.Community;
            case 15:
                return KmpHostType.PluginWeb;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final KmpHostEntry toKmpHostEntry(HostEntry hostEntry) {
        KmpDomainList kmpDomainList = toKmpDomainList(hostEntry.getPublicUser());
        DomainList bytecloudUser = hostEntry.getBytecloudUser();
        KmpDomainList kmpDomainList2 = bytecloudUser != null ? toKmpDomainList(bytecloudUser) : null;
        DomainList enterpriseUser = hostEntry.getEnterpriseUser();
        KmpDomainList kmpDomainList3 = enterpriseUser != null ? toKmpDomainList(enterpriseUser) : null;
        DomainList enterpriseBoeUser = hostEntry.getEnterpriseBoeUser();
        return new KmpHostEntry(kmpDomainList, kmpDomainList2, kmpDomainList3, enterpriseBoeUser != null ? toKmpDomainList(enterpriseBoeUser) : null);
    }

    private final KmpDomainList toKmpDomainList(DomainList domainList) {
        KmpAiRegion kmpAiRegion;
        String normal = domainList.getNormal();
        Map<AiRegion, String> regions = domainList.getRegions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(regions.size()));
        Iterator<T> it = regions.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int i = WhenMappings.$EnumSwitchMapping$1[((AiRegion) entry.getKey()).ordinal()];
            if (i == 1) {
                kmpAiRegion = KmpAiRegion.f124CN;
            } else if (i == 2) {
                kmpAiRegion = KmpAiRegion.f125SG;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                kmpAiRegion = KmpAiRegion.f126US;
            }
            linkedHashMap.put(kmpAiRegion, entry.getValue());
        }
        return new KmpDomainList(normal, linkedHashMap);
    }
}
