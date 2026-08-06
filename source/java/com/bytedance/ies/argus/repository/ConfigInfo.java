package com.bytedance.ies.argus.repository;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/ies/argus/repository/ConfigInfo;", "", "from", "Lcom/bytedance/ies/argus/repository/ConfigFrom;", "version", "", "createTimeStamp", "", "fetchType", "Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "geckoVersion", "(Lcom/bytedance/ies/argus/repository/ConfigFrom;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;Ljava/lang/String;)V", "getCreateTimeStamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFetchType", "()Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "getFrom", "()Lcom/bytedance/ies/argus/repository/ConfigFrom;", "getGeckoVersion", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/ies/argus/repository/ConfigFrom;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;Ljava/lang/String;)Lcom/bytedance/ies/argus/repository/ConfigInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfigInfo {
    private final Long createTimeStamp;
    private final ArgusGeckoFetchType fetchType;
    private final ConfigFrom from;
    private final String geckoVersion;
    private final String version;

    public static /* synthetic */ ConfigInfo copy$default(ConfigInfo configInfo, ConfigFrom configFrom, String str, Long l, ArgusGeckoFetchType argusGeckoFetchType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            configFrom = configInfo.from;
        }
        if ((i & 2) != 0) {
            str = configInfo.version;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            l = configInfo.createTimeStamp;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            argusGeckoFetchType = configInfo.fetchType;
        }
        ArgusGeckoFetchType argusGeckoFetchType2 = argusGeckoFetchType;
        if ((i & 16) != 0) {
            str2 = configInfo.geckoVersion;
        }
        return configInfo.copy(configFrom, str3, l2, argusGeckoFetchType2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final ConfigFrom getFrom() {
        return this.from;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    /* renamed from: component4, reason: from getter */
    public final ArgusGeckoFetchType getFetchType() {
        return this.fetchType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGeckoVersion() {
        return this.geckoVersion;
    }

    public final ConfigInfo copy(ConfigFrom from, String version, Long createTimeStamp, ArgusGeckoFetchType fetchType, String geckoVersion) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(version, "version");
        return new ConfigInfo(from, version, createTimeStamp, fetchType, geckoVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigInfo)) {
            return false;
        }
        ConfigInfo configInfo = (ConfigInfo) other;
        return this.from == configInfo.from && Intrinsics.areEqual(this.version, configInfo.version) && Intrinsics.areEqual(this.createTimeStamp, configInfo.createTimeStamp) && this.fetchType == configInfo.fetchType && Intrinsics.areEqual(this.geckoVersion, configInfo.geckoVersion);
    }

    public int hashCode() {
        int hashCode = ((this.from.hashCode() * 31) + this.version.hashCode()) * 31;
        Long l = this.createTimeStamp;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        ArgusGeckoFetchType argusGeckoFetchType = this.fetchType;
        int hashCode3 = (hashCode2 + (argusGeckoFetchType == null ? 0 : argusGeckoFetchType.hashCode())) * 31;
        String str = this.geckoVersion;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ConfigInfo(from=" + this.from + ", version=" + this.version + ", createTimeStamp=" + this.createTimeStamp + ", fetchType=" + this.fetchType + ", geckoVersion=" + this.geckoVersion + ')';
    }

    public ConfigInfo(ConfigFrom from, String version, Long l, ArgusGeckoFetchType argusGeckoFetchType, String str) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(version, "version");
        this.from = from;
        this.version = version;
        this.createTimeStamp = l;
        this.fetchType = argusGeckoFetchType;
        this.geckoVersion = str;
    }

    public /* synthetic */ ConfigInfo(ConfigFrom configFrom, String str, Long l, ArgusGeckoFetchType argusGeckoFetchType, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(configFrom, (i & 2) != 0 ? "-1" : str, l, (i & 8) != 0 ? null : argusGeckoFetchType, (i & 16) != 0 ? null : str2);
    }

    public final ConfigFrom getFrom() {
        return this.from;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public final ArgusGeckoFetchType getFetchType() {
        return this.fetchType;
    }

    public final String getGeckoVersion() {
        return this.geckoVersion;
    }
}
