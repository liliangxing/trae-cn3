package com.bytedance.trae.multilanguage;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StarlingOnlineTextUpdater.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;", "", "apiKey", "", "namespace", "zoneHost", "mode", "fallbackLanguages", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getApiKey", "()Ljava/lang/String;", "getNamespace", "getZoneHost", "getMode", "getFallbackLanguages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class StarlingOnlineTextConfig {
    private final String apiKey;
    private final List<String> fallbackLanguages;
    private final String mode;
    private final String namespace;
    private final String zoneHost;

    public static /* synthetic */ StarlingOnlineTextConfig copy$default(StarlingOnlineTextConfig starlingOnlineTextConfig, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = starlingOnlineTextConfig.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = starlingOnlineTextConfig.namespace;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = starlingOnlineTextConfig.zoneHost;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = starlingOnlineTextConfig.mode;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = starlingOnlineTextConfig.fallbackLanguages;
        }
        return starlingOnlineTextConfig.copy(str, str5, str6, str7, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* renamed from: component3, reason: from getter */
    public final String getZoneHost() {
        return this.zoneHost;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final List<String> component5() {
        return this.fallbackLanguages;
    }

    public final StarlingOnlineTextConfig copy(String apiKey, String namespace, String zoneHost, String mode, List<String> fallbackLanguages) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(zoneHost, "zoneHost");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(fallbackLanguages, "fallbackLanguages");
        return new StarlingOnlineTextConfig(apiKey, namespace, zoneHost, mode, fallbackLanguages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StarlingOnlineTextConfig)) {
            return false;
        }
        StarlingOnlineTextConfig starlingOnlineTextConfig = (StarlingOnlineTextConfig) other;
        return Intrinsics.areEqual(this.apiKey, starlingOnlineTextConfig.apiKey) && Intrinsics.areEqual(this.namespace, starlingOnlineTextConfig.namespace) && Intrinsics.areEqual(this.zoneHost, starlingOnlineTextConfig.zoneHost) && Intrinsics.areEqual(this.mode, starlingOnlineTextConfig.mode) && Intrinsics.areEqual(this.fallbackLanguages, starlingOnlineTextConfig.fallbackLanguages);
    }

    public int hashCode() {
        return (((((((this.apiKey.hashCode() * 31) + this.namespace.hashCode()) * 31) + this.zoneHost.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.fallbackLanguages.hashCode();
    }

    public String toString() {
        return "StarlingOnlineTextConfig(apiKey=" + this.apiKey + ", namespace=" + this.namespace + ", zoneHost=" + this.zoneHost + ", mode=" + this.mode + ", fallbackLanguages=" + this.fallbackLanguages + ')';
    }

    public StarlingOnlineTextConfig(String str, String str2, String str3, String str4, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(str2, "namespace");
        Intrinsics.checkNotNullParameter(str3, "zoneHost");
        Intrinsics.checkNotNullParameter(str4, "mode");
        Intrinsics.checkNotNullParameter(list, "fallbackLanguages");
        this.apiKey = str;
        this.namespace = str2;
        this.zoneHost = str3;
        this.mode = str4;
        this.fallbackLanguages = list;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final String getZoneHost() {
        return this.zoneHost;
    }

    public final String getMode() {
        return this.mode;
    }

    public /* synthetic */ StarlingOnlineTextConfig(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "normal" : str4, (i & 16) != 0 ? CollectionsKt.listOf(I18nLanguage.f139ZH.getCode()) : list);
    }

    public final List<String> getFallbackLanguages() {
        return this.fallbackLanguages;
    }
}
